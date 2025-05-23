package androidx.preference;

import android.content.Context;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class PreferenceInflater {
    private static final String EXTRA_TAG_NAME = "extra";
    private static final String INTENT_TAG_NAME = "intent";
    private static final String TAG = "PreferenceInflater";
    private final Object[] mConstructorArgs = new Object[2];
    private final Context mContext;
    private String[] mDefaultPackages;
    private PreferenceManager mPreferenceManager;
    private static final Class<?>[] CONSTRUCTOR_SIGNATURE = {Context.class, AttributeSet.class};
    private static final HashMap<String, Constructor> CONSTRUCTOR_MAP = new HashMap<>();

    public PreferenceInflater(Context context, PreferenceManager preferenceManager) {
        this.mContext = context;
        init(preferenceManager);
    }

    private Preference createItem(@NonNull String str, @Nullable String[] strArr, AttributeSet attributeSet) throws ClassNotFoundException, InflateException {
        Class<?> loadClass;
        Constructor<?> constructor = CONSTRUCTOR_MAP.get(str);
        if (constructor == null) {
            try {
                try {
                    ClassLoader classLoader = this.mContext.getClassLoader();
                    if (strArr != null && strArr.length != 0) {
                        loadClass = null;
                        ClassNotFoundException e16 = null;
                        for (String str2 : strArr) {
                            try {
                                loadClass = classLoader.loadClass(str2 + str);
                                break;
                            } catch (ClassNotFoundException e17) {
                                e16 = e17;
                            }
                        }
                        if (loadClass == null) {
                            if (e16 == null) {
                                throw new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                            }
                            throw e16;
                        }
                        constructor = loadClass.getConstructor(CONSTRUCTOR_SIGNATURE);
                        constructor.setAccessible(true);
                        CONSTRUCTOR_MAP.put(str, constructor);
                    }
                    loadClass = classLoader.loadClass(str);
                    constructor = loadClass.getConstructor(CONSTRUCTOR_SIGNATURE);
                    constructor.setAccessible(true);
                    CONSTRUCTOR_MAP.put(str, constructor);
                } catch (Exception e18) {
                    InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                    inflateException.initCause(e18);
                    throw inflateException;
                }
            } catch (ClassNotFoundException e19) {
                throw e19;
            }
        }
        Object[] objArr = this.mConstructorArgs;
        objArr[1] = attributeSet;
        return (Preference) constructor.newInstance(objArr);
    }

    private Preference createItemFromTag(String str, AttributeSet attributeSet) {
        try {
            if (-1 == str.indexOf(46)) {
                return onCreateItem(str, attributeSet);
            }
            return createItem(str, null, attributeSet);
        } catch (InflateException e16) {
            throw e16;
        } catch (ClassNotFoundException e17) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class (not found)" + str);
            inflateException.initCause(e17);
            throw inflateException;
        } catch (Exception e18) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e18);
            throw inflateException2;
        }
    }

    private void init(PreferenceManager preferenceManager) {
        this.mPreferenceManager = preferenceManager;
        setDefaultPackages(new String[]{Preference.class.getPackage().getName() + ".", SwitchPreference.class.getPackage().getName() + "."});
    }

    @NonNull
    private PreferenceGroup onMergeRoots(PreferenceGroup preferenceGroup, @NonNull PreferenceGroup preferenceGroup2) {
        if (preferenceGroup == null) {
            preferenceGroup2.onAttachedToHierarchy(this.mPreferenceManager);
            return preferenceGroup2;
        }
        return preferenceGroup;
    }

    private void rInflate(XmlPullParser xmlPullParser, Preference preference, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if ("intent".equals(name)) {
                        try {
                            preference.setIntent(Intent.parseIntent(getContext().getResources(), xmlPullParser, attributeSet));
                        } catch (IOException e16) {
                            XmlPullParserException xmlPullParserException = new XmlPullParserException("Error parsing preference");
                            xmlPullParserException.initCause(e16);
                            throw xmlPullParserException;
                        }
                    } else if ("extra".equals(name)) {
                        getContext().getResources().parseBundleExtra("extra", attributeSet, preference.getExtras());
                        try {
                            skipCurrentTag(xmlPullParser);
                        } catch (IOException e17) {
                            XmlPullParserException xmlPullParserException2 = new XmlPullParserException("Error parsing preference");
                            xmlPullParserException2.initCause(e17);
                            throw xmlPullParserException2;
                        }
                    } else {
                        Preference createItemFromTag = createItemFromTag(name, attributeSet);
                        ((PreferenceGroup) preference).addItemFromInflater(createItemFromTag);
                        rInflate(xmlPullParser, createItemFromTag, attributeSet);
                    }
                }
            } else {
                return;
            }
        }
    }

    private static void skipCurrentTag(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                if (next == 3 && xmlPullParser.getDepth() <= depth) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public String[] getDefaultPackages() {
        return this.mDefaultPackages;
    }

    public Preference inflate(int i3, @Nullable PreferenceGroup preferenceGroup) {
        XmlResourceParser xml = getContext().getResources().getXml(i3);
        try {
            return inflate(xml, preferenceGroup);
        } finally {
            xml.close();
        }
    }

    protected Preference onCreateItem(String str, AttributeSet attributeSet) throws ClassNotFoundException {
        return createItem(str, this.mDefaultPackages, attributeSet);
    }

    public void setDefaultPackages(String[] strArr) {
        this.mDefaultPackages = strArr;
    }

    public Preference inflate(XmlPullParser xmlPullParser, @Nullable PreferenceGroup preferenceGroup) {
        int next;
        PreferenceGroup onMergeRoots;
        synchronized (this.mConstructorArgs) {
            AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
            this.mConstructorArgs[0] = this.mContext;
            do {
                try {
                    try {
                        next = xmlPullParser.next();
                        if (next == 2) {
                            break;
                        }
                    } catch (InflateException e16) {
                        throw e16;
                    } catch (IOException e17) {
                        InflateException inflateException = new InflateException(xmlPullParser.getPositionDescription() + MsgSummary.STR_COLON + e17.getMessage());
                        inflateException.initCause(e17);
                        throw inflateException;
                    }
                } catch (XmlPullParserException e18) {
                    InflateException inflateException2 = new InflateException(e18.getMessage());
                    inflateException2.initCause(e18);
                    throw inflateException2;
                }
            } while (next != 1);
            if (next == 2) {
                onMergeRoots = onMergeRoots(preferenceGroup, (PreferenceGroup) createItemFromTag(xmlPullParser.getName(), asAttributeSet));
                rInflate(xmlPullParser, onMergeRoots, asAttributeSet);
            } else {
                throw new InflateException(xmlPullParser.getPositionDescription() + ": No start tag found!");
            }
        }
        return onMergeRoots;
    }
}
