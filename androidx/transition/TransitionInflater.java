package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import com.tencent.ams.mosaic.jsengine.component.imagegallery.ImageGalleryComponent;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.io.IOException;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes.dex */
public class TransitionInflater {
    private final Context mContext;
    private static final Class<?>[] CONSTRUCTOR_SIGNATURE = {Context.class, AttributeSet.class};
    private static final ArrayMap<String, Constructor<?>> CONSTRUCTORS = new ArrayMap<>();

    TransitionInflater(@NonNull Context context) {
        this.mContext = context;
    }

    private Object createCustom(AttributeSet attributeSet, Class<?> cls, String str) {
        Object newInstance;
        Class<? extends U> asSubclass;
        String attributeValue = attributeSet.getAttributeValue(null, Constants.Service.CLASS);
        if (attributeValue != null) {
            try {
                ArrayMap<String, Constructor<?>> arrayMap = CONSTRUCTORS;
                synchronized (arrayMap) {
                    Constructor<?> constructor = arrayMap.get(attributeValue);
                    if (constructor == null && (asSubclass = Class.forName(attributeValue, false, this.mContext.getClassLoader()).asSubclass(cls)) != 0) {
                        constructor = asSubclass.getConstructor(CONSTRUCTOR_SIGNATURE);
                        constructor.setAccessible(true);
                        arrayMap.put(attributeValue, constructor);
                    }
                    newInstance = constructor.newInstance(this.mContext, attributeSet);
                }
                return newInstance;
            } catch (Exception e16) {
                throw new InflateException("Could not instantiate " + cls + " class " + attributeValue, e16);
            }
        }
        throw new InflateException(str + " tag must have a 'class' attribute");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0191, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Transition createTransitionFromXml(XmlPullParser xmlPullParser, AttributeSet attributeSet, Transition transition) throws XmlPullParserException, IOException {
        TransitionSet transitionSet;
        int depth = xmlPullParser.getDepth();
        if (transition instanceof TransitionSet) {
            transitionSet = (TransitionSet) transition;
        } else {
            transitionSet = null;
        }
        loop0: while (true) {
            Transition transition2 = null;
            while (true) {
                int next = xmlPullParser.next();
                if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                    if (next == 2) {
                        String name = xmlPullParser.getName();
                        if (ImageGalleryComponent.AnimationType.FADE.equals(name)) {
                            transition2 = new Fade(this.mContext, attributeSet);
                        } else if ("changeBounds".equals(name)) {
                            transition2 = new ChangeBounds(this.mContext, attributeSet);
                        } else if (WinkDaTongReportConstant.ElementParamValue.BOTTOM_TAB_SWITCH_TYPE_SLIDE.equals(name)) {
                            transition2 = new Slide(this.mContext, attributeSet);
                        } else if ("explode".equals(name)) {
                            transition2 = new Explode(this.mContext, attributeSet);
                        } else if ("changeImageTransform".equals(name)) {
                            transition2 = new ChangeImageTransform(this.mContext, attributeSet);
                        } else if ("changeTransform".equals(name)) {
                            transition2 = new ChangeTransform(this.mContext, attributeSet);
                        } else if ("changeClipBounds".equals(name)) {
                            transition2 = new ChangeClipBounds(this.mContext, attributeSet);
                        } else if ("autoTransition".equals(name)) {
                            transition2 = new AutoTransition(this.mContext, attributeSet);
                        } else if ("changeScroll".equals(name)) {
                            transition2 = new ChangeScroll(this.mContext, attributeSet);
                        } else if ("transitionSet".equals(name)) {
                            transition2 = new TransitionSet(this.mContext, attributeSet);
                        } else if ("transition".equals(name)) {
                            transition2 = (Transition) createCustom(attributeSet, Transition.class, "transition");
                        } else if ("targets".equals(name)) {
                            getTargetIds(xmlPullParser, attributeSet, transition);
                        } else if ("arcMotion".equals(name)) {
                            if (transition != null) {
                                transition.setPathMotion(new ArcMotion(this.mContext, attributeSet));
                            } else {
                                throw new RuntimeException("Invalid use of arcMotion element");
                            }
                        } else if ("pathMotion".equals(name)) {
                            if (transition != null) {
                                transition.setPathMotion((PathMotion) createCustom(attributeSet, PathMotion.class, "pathMotion"));
                            } else {
                                throw new RuntimeException("Invalid use of pathMotion element");
                            }
                        } else if ("patternPathMotion".equals(name)) {
                            if (transition != null) {
                                transition.setPathMotion(new PatternPathMotion(this.mContext, attributeSet));
                            } else {
                                throw new RuntimeException("Invalid use of patternPathMotion element");
                            }
                        } else {
                            throw new RuntimeException("Unknown scene name: " + xmlPullParser.getName());
                        }
                        if (transition2 == null) {
                            continue;
                        } else {
                            if (!xmlPullParser.isEmptyElementTag()) {
                                createTransitionFromXml(xmlPullParser, attributeSet, transition2);
                            }
                            if (transitionSet != null) {
                                break;
                            }
                            if (transition != null) {
                                throw new InflateException("Could not add transition to another transition.");
                            }
                        }
                    }
                }
            }
            transitionSet.addTransition(transition2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0057, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private TransitionManager createTransitionManagerFromXml(XmlPullParser xmlPullParser, AttributeSet attributeSet, ViewGroup viewGroup) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        TransitionManager transitionManager = null;
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if (name.equals("transitionManager")) {
                        transitionManager = new TransitionManager();
                    } else {
                        if (!name.equals("transition") || transitionManager == null) {
                            break;
                        }
                        loadTransition(attributeSet, xmlPullParser, viewGroup, transitionManager);
                    }
                }
            }
        }
        throw new RuntimeException("Unknown scene name: " + xmlPullParser.getName());
    }

    public static TransitionInflater from(Context context) {
        return new TransitionInflater(context);
    }

    @SuppressLint({"RestrictedApi"})
    private void getTargetIds(XmlPullParser xmlPullParser, AttributeSet attributeSet, Transition transition) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    if (xmlPullParser.getName().equals("target")) {
                        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, Styleable.TRANSITION_TARGET);
                        int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, "targetId", 1, 0);
                        if (namedResourceId != 0) {
                            transition.addTarget(namedResourceId);
                        } else {
                            int namedResourceId2 = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, "excludeId", 2, 0);
                            if (namedResourceId2 != 0) {
                                transition.excludeTarget(namedResourceId2, true);
                            } else {
                                String namedString = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlPullParser, "targetName", 4);
                                if (namedString != null) {
                                    transition.addTarget(namedString);
                                } else {
                                    String namedString2 = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlPullParser, "excludeName", 5);
                                    if (namedString2 != null) {
                                        transition.excludeTarget(namedString2, true);
                                    } else {
                                        String namedString3 = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlPullParser, "excludeClass", 3);
                                        if (namedString3 != null) {
                                            try {
                                                transition.excludeTarget(Class.forName(namedString3), true);
                                            } catch (ClassNotFoundException e16) {
                                                obtainStyledAttributes.recycle();
                                                throw new RuntimeException("Could not create " + namedString3, e16);
                                            }
                                        } else {
                                            String namedString4 = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlPullParser, "targetClass", 0);
                                            if (namedString4 != null) {
                                                transition.addTarget(Class.forName(namedString4));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        obtainStyledAttributes.recycle();
                    } else {
                        throw new RuntimeException("Unknown scene name: " + xmlPullParser.getName());
                    }
                }
            } else {
                return;
            }
        }
    }

    @SuppressLint({"RestrictedApi"})
    private void loadTransition(AttributeSet attributeSet, XmlPullParser xmlPullParser, ViewGroup viewGroup, TransitionManager transitionManager) throws Resources.NotFoundException {
        Scene sceneForLayout;
        Transition inflateTransition;
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, Styleable.TRANSITION_MANAGER);
        int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, "transition", 2, -1);
        int namedResourceId2 = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, "fromScene", 0, -1);
        Scene scene = null;
        if (namedResourceId2 < 0) {
            sceneForLayout = null;
        } else {
            sceneForLayout = Scene.getSceneForLayout(viewGroup, namedResourceId2, this.mContext);
        }
        int namedResourceId3 = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, "toScene", 1, -1);
        if (namedResourceId3 >= 0) {
            scene = Scene.getSceneForLayout(viewGroup, namedResourceId3, this.mContext);
        }
        if (namedResourceId >= 0 && (inflateTransition = inflateTransition(namedResourceId)) != null) {
            if (scene != null) {
                if (sceneForLayout == null) {
                    transitionManager.setTransition(scene, inflateTransition);
                } else {
                    transitionManager.setTransition(sceneForLayout, scene, inflateTransition);
                }
            } else {
                throw new RuntimeException("No toScene for transition ID " + namedResourceId);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public Transition inflateTransition(int i3) {
        XmlResourceParser xml = this.mContext.getResources().getXml(i3);
        try {
            try {
                return createTransitionFromXml(xml, Xml.asAttributeSet(xml), null);
            } catch (IOException e16) {
                throw new InflateException(xml.getPositionDescription() + MsgSummary.STR_COLON + e16.getMessage(), e16);
            } catch (XmlPullParserException e17) {
                throw new InflateException(e17.getMessage(), e17);
            }
        } finally {
            xml.close();
        }
    }

    public TransitionManager inflateTransitionManager(int i3, ViewGroup viewGroup) {
        XmlResourceParser xml = this.mContext.getResources().getXml(i3);
        try {
            try {
                return createTransitionManagerFromXml(xml, Xml.asAttributeSet(xml), viewGroup);
            } catch (IOException e16) {
                InflateException inflateException = new InflateException(xml.getPositionDescription() + MsgSummary.STR_COLON + e16.getMessage());
                inflateException.initCause(e16);
                throw inflateException;
            } catch (XmlPullParserException e17) {
                InflateException inflateException2 = new InflateException(e17.getMessage());
                inflateException2.initCause(e17);
                throw inflateException2;
            }
        } finally {
            xml.close();
        }
    }
}
