package com.tencent.luggage.wxa.nq;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.preference.Preference;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.weui.base.preference.IPreferenceScreen;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d {

    /* renamed from: c, reason: collision with root package name */
    public static final Class[] f135931c = {Context.class, AttributeSet.class};

    /* renamed from: d, reason: collision with root package name */
    public static HashMap f135932d = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final Context f135933a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f135934b = new Object[2];

    public d(Context context) {
        this.f135933a = context;
    }

    public void a(int i3, IPreferenceScreen iPreferenceScreen) {
        a(i3, iPreferenceScreen, iPreferenceScreen != null);
    }

    public void a(int i3, IPreferenceScreen iPreferenceScreen, boolean z16) {
        XmlResourceParser xml = this.f135933a.getResources().getXml(i3);
        if (xml == null) {
            return;
        }
        try {
            a(xml, iPreferenceScreen, z16);
        } finally {
            xml.close();
        }
    }

    public void a(XmlPullParser xmlPullParser, IPreferenceScreen iPreferenceScreen, boolean z16) {
        synchronized (this.f135934b) {
            AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
            this.f135934b[0] = this.f135933a;
            try {
                int next = xmlPullParser.next();
                while (next != 2 && next != 1) {
                    next = xmlPullParser.next();
                }
                if (next == 2) {
                    a(xmlPullParser, xmlPullParser.getName(), asAttributeSet);
                    a(xmlPullParser, iPreferenceScreen, asAttributeSet);
                } else {
                    throw new InflateException(xmlPullParser.getPositionDescription() + ": No start tag found!");
                }
            } catch (InflateException e16) {
                throw e16;
            } catch (IOException e17) {
                InflateException inflateException = new InflateException(xmlPullParser.getPositionDescription() + MsgSummary.STR_COLON + e17.getMessage());
                inflateException.initCause(e17);
                throw inflateException;
            } catch (XmlPullParserException e18) {
                InflateException inflateException2 = new InflateException(e18.getMessage());
                inflateException2.initCause(e18);
                throw inflateException2;
            }
        }
    }

    public final Preference a(String str, String str2, AttributeSet attributeSet) {
        String str3;
        String positionDescription;
        Constructor<?> constructor = (Constructor) f135932d.get(str);
        if (constructor == null) {
            try {
                ClassLoader classLoader = this.f135933a.getClassLoader();
                if (str2 != null) {
                    str3 = str2 + str;
                } else {
                    str3 = str;
                }
                constructor = classLoader.loadClass(str3).getConstructor(f135931c);
                f135932d.put(str, constructor);
            } catch (ClassNotFoundException e16) {
                throw e16;
            } catch (NoSuchMethodException e17) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(attributeSet.getPositionDescription());
                sb5.append(": Error inflating class ");
                if (str2 != null) {
                    str = str2 + str;
                }
                sb5.append(str);
                InflateException inflateException = new InflateException(sb5.toString());
                inflateException.initCause(e17);
                throw inflateException;
            } catch (Exception e18) {
                if (attributeSet == null) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("(null): Error inflating class ");
                    sb6.append(constructor);
                    positionDescription = sb6.toString() != null ? constructor.getClass().getName() : "(null)";
                } else {
                    positionDescription = attributeSet.getPositionDescription();
                }
                InflateException inflateException2 = new InflateException(positionDescription);
                inflateException2.initCause(e18);
                throw inflateException2;
            }
        }
        Object[] objArr = this.f135934b;
        objArr[1] = attributeSet;
        return (Preference) constructor.newInstance(objArr);
    }

    public final Preference a(XmlPullParser xmlPullParser, String str, AttributeSet attributeSet) {
        try {
            if (-1 == str.indexOf(46)) {
                return a(str, "android.preference.", attributeSet);
            }
            return a(str, (String) null, attributeSet);
        } catch (InflateException e16) {
            throw e16;
        } catch (ClassNotFoundException e17) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException.initCause(e17);
            throw inflateException;
        } catch (Exception e18) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e18);
            throw inflateException2;
        }
    }

    public final void a(XmlPullParser xmlPullParser, IPreferenceScreen iPreferenceScreen, AttributeSet attributeSet) {
        int depth = xmlPullParser.getDepth();
        int next = xmlPullParser.next();
        while (true) {
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next != 2) {
                next = xmlPullParser.next();
            } else {
                iPreferenceScreen.addPreference(a(xmlPullParser, xmlPullParser.getName(), attributeSet), -1);
                next = xmlPullParser.next();
            }
        }
    }
}
