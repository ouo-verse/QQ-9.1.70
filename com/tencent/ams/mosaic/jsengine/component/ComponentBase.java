package com.tencent.ams.mosaic.jsengine.component;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaNodeFactory;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaWrap;
import com.tencent.ams.hippo.quickjs.android.JSContext;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.hippo.quickjs.android.JSValue;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.f;
import com.tencent.ams.mosaic.jsengine.a;
import com.tencent.ams.mosaic.jsengine.animation.layer.LayerBase;
import com.tencent.ams.mosaic.jsengine.animation.layer.container.ContainerLayer;
import com.tencent.ams.mosaic.jsengine.animation.layer.container.FrameLayer;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.component.container.Container;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public abstract class ComponentBase implements Component, ContainerLayer, com.tencent.ams.mosaic.i {
    static IPatchRedirector $redirector_ = null;
    private static final int AUTO_VALUE = -999999;
    protected static final int REWARD_TYPE_FREE_MODE_CARD = 2;
    protected static final int REWARD_TYPE_ICON = 1;
    protected static final int REWARD_TYPE_SCRATCH_CARD = 3;
    protected static final int REWARD_TYPE_UNKNOWN = 0;
    private static final String TAG = "ComponentBase";
    private static final int VIEW_COMPONENT_ID;
    private String mAlignParent;
    protected float mBottomInPx;
    private int mBottomMarginInPx;
    protected Context mContext;
    private float mHeight;
    private final String mId;
    private com.tencent.ams.mosaic.jsengine.a mJSEngine;
    protected float mLeftInPx;
    private int mLeftMarginInPx;
    private Component mParentComponent;
    protected int mPositionType;
    protected float mRightInPx;
    private int mRightMarginInPx;
    protected float mTopInPx;
    private int mTopMarginInPx;
    protected a mViewClickListener;
    private b mViewFocusChangeListener;
    private float mWidth;
    protected Object mYogaNode;
    private int mZIndex;
    protected FrameLayer viewLayer;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener, View.OnTouchListener {
        static IPatchRedirector $redirector_;
        private float C;
        private JSValue D;

        /* renamed from: d, reason: collision with root package name */
        private JSFunction f70929d;

        /* renamed from: e, reason: collision with root package name */
        private JSFunction f70930e;

        /* renamed from: f, reason: collision with root package name */
        private final Component f70931f;

        /* renamed from: h, reason: collision with root package name */
        private float f70932h;

        /* renamed from: i, reason: collision with root package name */
        private float f70933i;

        /* renamed from: m, reason: collision with root package name */
        private float f70934m;

        /* compiled from: P */
        /* renamed from: com.tencent.ams.mosaic.jsengine.component.ComponentBase$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0689a implements a.b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean[] f70935a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f70936b;

            C0689a(boolean[] zArr, View view) {
                this.f70935a = zArr;
                this.f70936b = view;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, a.this, zArr, view);
                }
            }

            @Override // com.tencent.ams.mosaic.jsengine.a.b
            public void onFail(JSFunction jSFunction) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSFunction);
                }
            }

            @Override // com.tencent.ams.mosaic.jsengine.a.b
            public void onSuccess(JSFunction jSFunction, JSValue jSValue) {
                Boolean bool;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSFunction, (Object) jSValue);
                    return;
                }
                try {
                    JSContext l3 = a.this.f70931f.getJSEngine().l();
                    if (l3 != null && (bool = (Boolean) l3.quickJS.getAdapter(Boolean.class).fromJSValue(l3, jSValue)) != null) {
                        this.f70935a[0] = bool.booleanValue();
                    }
                } catch (Throwable th5) {
                    com.tencent.ams.mosaic.utils.f.i(ComponentBase.TAG, "view: " + this.f70936b + ", onTouch error.", th5);
                }
            }
        }

        public a(Component component) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) component);
            } else {
                this.f70931f = component;
            }
        }

        public void b(JSFunction jSFunction) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSFunction);
            } else {
                this.f70929d = jSFunction;
            }
        }

        public void c(JSFunction jSFunction) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSFunction);
            } else {
                this.f70930e = jSFunction;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Component component;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
            } else {
                this.f70931f.getJSEngine().g().b(new com.tencent.ams.mosaic.g("componentOnClick", this.f70931f.getId()));
                if (this.f70929d != null && (component = this.f70931f) != null) {
                    component.getJSEngine().u(this.f70929d, new Object[]{Float.valueOf(this.f70932h), Float.valueOf(this.f70933i), Float.valueOf(this.f70934m), Float.valueOf(this.C)}, null);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Component component;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (motionEvent.getAction() == 0) {
                this.f70932h = MosaicUtils.E(motionEvent.getX());
                this.f70933i = MosaicUtils.E(motionEvent.getY());
                view.getLocationOnScreen(new int[2]);
                this.f70934m = MosaicUtils.E(r0[0]);
                this.C = MosaicUtils.E(r0[1]);
            }
            if (this.f70930e == null || (component = this.f70931f) == null || component.getJSEngine().isClosed()) {
                return false;
            }
            JSContext l3 = this.f70931f.getJSEngine().l();
            if (this.D == null) {
                this.D = l3.createJSObject(new HashMap());
            }
            JSValue jSValue = this.D;
            if (jSValue instanceof JSObject) {
                ((JSObject) jSValue).setProperty("action", com.tencent.ams.mosaic.jsengine.e.h(l3, Integer.valueOf(motionEvent.getAction())));
                ((JSObject) this.D).setProperty(HippyTKDListViewAdapter.X, com.tencent.ams.mosaic.jsengine.e.h(l3, Float.valueOf(MosaicUtils.E(motionEvent.getX()))));
                ((JSObject) this.D).setProperty("y", com.tencent.ams.mosaic.jsengine.e.h(l3, Float.valueOf(MosaicUtils.E(motionEvent.getY()))));
            }
            boolean[] zArr = {false};
            this.f70931f.getJSEngine().p(this.f70930e, new Object[]{this.D}, new C0689a(zArr, view));
            return zArr[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b implements View.OnFocusChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private JSFunction f70938d;

        /* renamed from: e, reason: collision with root package name */
        private final Component f70939e;

        b(Component component) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) component);
            } else {
                this.f70939e = component;
            }
        }

        public void a(JSFunction jSFunction) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSFunction);
            } else {
                this.f70938d = jSFunction;
            }
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, view, Boolean.valueOf(z16));
                return;
            }
            if (this.f70939e != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("msg", this.f70939e.getId());
                hashMap.put("hasFocus", Boolean.valueOf(z16));
                this.f70939e.getJSEngine().g().b(new com.tencent.ams.mosaic.g("componentOnFocusChange", hashMap));
                if (this.f70938d != null) {
                    this.f70939e.getJSEngine().u(this.f70938d, new Object[]{this.f70939e.getId(), Boolean.valueOf(z16)}, null);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40689);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 68)) {
            redirector.redirect((short) 68);
        } else {
            VIEW_COMPONENT_ID = com.tencent.ams.mosaic.utils.k.b();
        }
    }

    public ComponentBase(Context context, String str, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.mContext = context;
        this.mId = str;
        this.mWidth = f16;
        this.mHeight = f17;
        this.mLeftInPx = -99198.0f;
        this.mTopInPx = -99198.0f;
        this.mRightInPx = -99198.0f;
        this.mBottomInPx = -99198.0f;
    }

    private Integer getIntLayoutParamsFromObject(Object obj) {
        if ((obj instanceof String) && "auto".equalsIgnoreCase((String) obj)) {
            return -999999;
        }
        if (obj instanceof Integer) {
            return Integer.valueOf((int) MosaicUtils.j(((Integer) obj).floatValue()));
        }
        if (obj instanceof Float) {
            return Integer.valueOf((int) MosaicUtils.j(((Float) obj).floatValue()));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestFocus$8() {
        getView().requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setFocusable$1(boolean z16) {
        getView().setFocusable(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setFocusableInTouchMode$2(boolean z16) {
        getView().setFocusableInTouchMode(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setNextFocusDownId$4(String str) {
        getView().setNextFocusDownId(getViewIdByComponentId(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setNextFocusLeftId$6(String str) {
        getView().setNextFocusLeftId(getViewIdByComponentId(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setNextFocusRightId$7(String str) {
        getView().setNextFocusRightId(getViewIdByComponentId(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setNextFocusUpId$5(String str) {
        getView().setNextFocusUpId(getViewIdByComponentId(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOnClickListener$0(JSFunction jSFunction) {
        if (this.mViewClickListener == null) {
            this.mViewClickListener = new a(this);
        }
        this.mViewClickListener.b(jSFunction);
        getView().setOnTouchListener(this.mViewClickListener);
        getView().setOnClickListener(this.mViewClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOnFocusChangeListener$3(JSFunction jSFunction) {
        if (this.mViewFocusChangeListener == null) {
            this.mViewFocusChangeListener = new b(this);
        }
        this.mViewFocusChangeListener.a(jSFunction);
        getView().setOnFocusChangeListener(this.mViewFocusChangeListener);
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.container.ContainerLayer
    public void addLayer(LayerBase layerBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) layerBase);
        } else if (layerBase != null) {
            if (this.viewLayer == null) {
                this.viewLayer = new FrameLayer(this.mContext, "", this.mWidth, this.mHeight);
            }
            this.viewLayer.addLayer(layerBase);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void commit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
        }
    }

    int covertAlignItemToGravity(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1383228885:
                if (str.equals("bottom")) {
                    c16 = 0;
                    break;
                }
                break;
            case -1364013995:
                if (str.equals("center")) {
                    c16 = 1;
                    break;
                }
                break;
            case -348726240:
                if (str.equals("center_vertical")) {
                    c16 = 2;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c16 = 3;
                    break;
                }
                break;
            case 115029:
                if (str.equals("top")) {
                    c16 = 4;
                    break;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    c16 = 5;
                    break;
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    c16 = 6;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c16 = 7;
                    break;
                }
                break;
            case 1063616078:
                if (str.equals("center_horizontal")) {
                    c16 = '\b';
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return 80;
            case 1:
                return 17;
            case 2:
                return 16;
            case 3:
                return 8388613;
            case 4:
                return 48;
            case 5:
                return 3;
            case 6:
                return 5;
            case 7:
                return 8388611;
            case '\b':
                return 1;
            default:
                return 0;
        }
    }

    public int covertAlignSplice(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Integer) iPatchRedirector.redirect((short) 43, (Object) this, (Object) str)).intValue();
        }
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i3 = 0;
        for (String str2 : str.split("[|]")) {
            if (!TextUtils.isEmpty(str2)) {
                i3 |= covertAlignItemToGravity(str2);
            }
        }
        return i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public Component findComponentById(String str) {
        Component findComponentById;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            return (Component) iPatchRedirector.redirect((short) 67, (Object) this, (Object) str);
        }
        if (TextUtils.equals(this.mId, str)) {
            return this;
        }
        if (this instanceof Container) {
            for (ComponentBase componentBase : ((Container) this).getChildren()) {
                if (componentBase != null && (findComponentById = componentBase.findComponentById(str)) != null) {
                    return findComponentById;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public String focusSearch(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return (String) iPatchRedirector.redirect((short) 62, (Object) this, i3);
        }
        View focusSearch = getView().focusSearch(i3);
        if (focusSearch != null) {
            Object tag = focusSearch.getTag(VIEW_COMPONENT_ID);
            if (tag instanceof String) {
                return (String) tag;
            }
            return null;
        }
        return null;
    }

    public String getAlignParent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return this.mAlignParent;
    }

    public float getBottom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Float) iPatchRedirector.redirect((short) 28, (Object) this)).floatValue();
        }
        return this.mBottomInPx;
    }

    public int getBottomMargin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        return this.mBottomMarginInPx;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public float getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
        }
        return this.mHeight;
    }

    public float getHeightPx() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Float) iPatchRedirector.redirect((short) 10, (Object) this)).floatValue();
        }
        float f16 = this.mHeight;
        if (f16 == -1.0f) {
            return -1.0f;
        }
        if (f16 == -2.0f) {
            return -2.0f;
        }
        return MosaicUtils.j(f16);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public String getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mId;
    }

    @NonNull
    public f.c getImageLoader() {
        f.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (f.c) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        try {
            cVar = this.mJSEngine.c();
        } catch (NullPointerException unused) {
            com.tencent.ams.mosaic.utils.f.h(tag(), "mJSEngine has not be initialized, you can't use image loader");
            cVar = null;
        }
        if (cVar == null) {
            com.tencent.ams.mosaic.utils.f.e(tag(), "not set image loader for js engine, use global one");
            return com.tencent.ams.mosaic.f.k().j();
        }
        return cVar;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public com.tencent.ams.mosaic.jsengine.a getJSEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (com.tencent.ams.mosaic.jsengine.a) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.mJSEngine;
    }

    public float getLeft() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Float) iPatchRedirector.redirect((short) 25, (Object) this)).floatValue();
        }
        return this.mLeftInPx;
    }

    public int getLeftMargin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return this.mLeftMarginInPx;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public Component getParent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Component) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mParentComponent;
    }

    public int getPositionType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Integer) iPatchRedirector.redirect((short) 42, (Object) this)).intValue();
        }
        return this.mPositionType;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public float getRealHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
        }
        return MosaicUtils.E(getView().getHeight());
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public float getRealWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, (Object) this)).floatValue();
        }
        return MosaicUtils.E(getView().getWidth());
    }

    public float getRight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Float) iPatchRedirector.redirect((short) 27, (Object) this)).floatValue();
        }
        return this.mRightInPx;
    }

    public int getRightMargin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return this.mRightMarginInPx;
    }

    public float getTop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Float) iPatchRedirector.redirect((short) 26, (Object) this)).floatValue();
        }
        return this.mTopInPx;
    }

    public int getTopMargin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return this.mTopMarginInPx;
    }

    @NonNull
    public f.InterfaceC0685f getVideoLoader() {
        f.InterfaceC0685f interfaceC0685f;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (f.InterfaceC0685f) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        try {
            interfaceC0685f = this.mJSEngine.getVideoLoader();
        } catch (NullPointerException unused) {
            com.tencent.ams.mosaic.utils.f.h(tag(), "mJSEngine has not be initialized, you can't use video loader");
            interfaceC0685f = null;
        }
        if (interfaceC0685f == null) {
            com.tencent.ams.mosaic.utils.f.e(tag(), "not set video loader for js engine, use global one");
            return com.tencent.ams.mosaic.f.k().s();
        }
        return interfaceC0685f;
    }

    public int getViewIdByComponentId(String str) {
        Component findComponentById;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return ((Integer) iPatchRedirector.redirect((short) 66, (Object) this, (Object) str)).intValue();
        }
        if (TextUtils.isEmpty(str) || (findComponentById = getJSEngine().d().getRootView().findComponentById(str)) == null || findComponentById.getView() == null) {
            return -1;
        }
        View view = findComponentById.getView();
        int id5 = view.getId();
        if (id5 == -1) {
            int b16 = com.tencent.ams.mosaic.utils.k.b();
            view.setId(b16);
            return b16;
        }
        return id5;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public float getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Float) iPatchRedirector.redirect((short) 3, (Object) this)).floatValue();
        }
        return this.mWidth;
    }

    public float getWidthPx() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Float) iPatchRedirector.redirect((short) 9, (Object) this)).floatValue();
        }
        float f16 = this.mWidth;
        if (f16 == -1.0f) {
            return -1.0f;
        }
        if (f16 == -2.0f) {
            return -2.0f;
        }
        return MosaicUtils.j(f16);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public float getX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Float) iPatchRedirector.redirect((short) 7, (Object) this)).floatValue();
        }
        return MosaicUtils.E(getView().getX());
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public float getXInScreen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return ((Float) iPatchRedirector.redirect((short) 64, (Object) this)).floatValue();
        }
        int[] iArr = new int[2];
        View view = getView();
        int i3 = 0;
        if (view != null) {
            view.getLocationOnScreen(iArr);
            i3 = iArr[0];
        }
        return MosaicUtils.E(i3);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public float getY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
        }
        return MosaicUtils.E(getView().getY());
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public float getYInScreen() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return ((Float) iPatchRedirector.redirect((short) 65, (Object) this)).floatValue();
        }
        int[] iArr = new int[2];
        View view = getView();
        if (view != null) {
            view.getLocationOnScreen(iArr);
            i3 = iArr[1];
        } else {
            i3 = 0;
        }
        return MosaicUtils.E(i3);
    }

    public Object getYogaNode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return iPatchRedirector.redirect((short) 41, (Object) this);
        }
        return this.mYogaNode;
    }

    public int getZIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this)).intValue();
        }
        return this.mZIndex;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public boolean isFocused() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return ((Boolean) iPatchRedirector.redirect((short) 63, (Object) this)).booleanValue();
        }
        return getView().isFocused();
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.container.ContainerLayer
    public void masksToBounds(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, z16);
            return;
        }
        FrameLayer frameLayer = this.viewLayer;
        if (frameLayer != null) {
            frameLayer.masksToBounds(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroyed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void onAddedToParent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
            return;
        }
        com.tencent.ams.mosaic.jsengine.a aVar = this.mJSEngine;
        if (aVar != null) {
            aVar.g().a(this);
        }
        getView().setTag(VIEW_COMPONENT_ID, getId());
    }

    public void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) canvas);
            return;
        }
        FrameLayer frameLayer = this.viewLayer;
        if (frameLayer != null) {
            frameLayer.setFrame(frameLayer.getPositionX(), this.viewLayer.getPositionY(), this.mWidth, this.mHeight);
            this.viewLayer.draw(canvas);
        }
    }

    @Override // com.tencent.ams.mosaic.i
    public void onEvent(com.tencent.ams.mosaic.g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) gVar);
            return;
        }
        if (gVar == null) {
            return;
        }
        String a16 = gVar.a();
        a16.hashCode();
        char c16 = '\uffff';
        switch (a16.hashCode()) {
            case -1443590229:
                if (a16.equals("onActivityDestroyed")) {
                    c16 = 0;
                    break;
                }
                break;
            case -426492010:
                if (a16.equals(MosaicConstants$JsFunction.FUNC_ON_SWITCH_FOREGROUND)) {
                    c16 = 1;
                    break;
                }
                break;
            case 551824257:
                if (a16.equals(MosaicConstants$JsFunction.FUNC_ON_SWITCH_BACKGROUND)) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                onActivityDestroyed();
                return;
            case 1:
                onSwitchForeground();
                return;
            case 2:
                onSwitchBackground();
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void onRemovedFromParent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
            return;
        }
        com.tencent.ams.mosaic.jsengine.a aVar = this.mJSEngine;
        if (aVar != null) {
            aVar.g().e(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSwitchBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSwitchForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.container.ContainerLayer
    public void removeAllLayers() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this);
            return;
        }
        FrameLayer frameLayer = this.viewLayer;
        if (frameLayer != null) {
            frameLayer.removeAllLayers();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.container.ContainerLayer
    public void removeLayer(LayerBase layerBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) layerBase);
            return;
        }
        FrameLayer frameLayer = this.viewLayer;
        if (frameLayer != null) {
            frameLayer.removeLayer(layerBase);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void requestFocus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this);
        } else {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.j
                @Override // java.lang.Runnable
                public final void run() {
                    ComponentBase.this.lambda$requestFocus$8();
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setAlignParent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e(tag(), "setAlignParent:" + str);
        this.mAlignParent = str;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setAlpha(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Float.valueOf(f16));
        } else {
            MosaicUtils.I(new Runnable(f16) { // from class: com.tencent.ams.mosaic.jsengine.component.ComponentBase.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ float f70923d;

                {
                    this.f70923d = f16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ComponentBase.this, Float.valueOf(f16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ComponentBase.this.getView().setAlpha(this.f70923d);
                    }
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0509  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0470  */
    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setFlexLayout(JSObject jSObject) {
        com.tencent.ams.mosaic.jsengine.a aVar;
        JSContext l3;
        float f16;
        float f17;
        int intValue;
        int intValue2;
        int intValue3;
        YogaAlign yogaAlign;
        Object obj;
        Object obj2;
        Integer intLayoutParamsFromObject;
        Integer intLayoutParamsFromObject2;
        Integer intLayoutParamsFromObject3;
        Integer intLayoutParamsFromObject4;
        int intValue4;
        int intValue5;
        int intValue6;
        int intValue7;
        float f18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) jSObject);
            return;
        }
        if (!MosaicUtils.D()) {
            com.tencent.ams.mosaic.utils.f.h(tag(), "setFlexLayout failed: not support yoga");
            return;
        }
        if (jSObject != null && (aVar = this.mJSEngine) != null && (l3 = aVar.l()) != null) {
            Map<String, Object> f19 = com.tencent.ams.mosaic.jsengine.e.f(l3, jSObject);
            YogaNode yogaNode = (YogaNode) this.mYogaNode;
            if (yogaNode == null) {
                MosaicUtils.l(this.mContext);
                yogaNode = YogaNodeFactory.create();
            }
            Integer intLayoutParamsFromObject5 = getIntLayoutParamsFromObject(f19.get("width"));
            if (intLayoutParamsFromObject5 != null) {
                if (intLayoutParamsFromObject5.intValue() == -999999) {
                    this.mWidth = -2.0f;
                    yogaNode.setWidthAuto();
                } else {
                    this.mWidth = MosaicUtils.E(intLayoutParamsFromObject5.intValue());
                    yogaNode.setWidth(intLayoutParamsFromObject5.intValue());
                }
            }
            Integer intLayoutParamsFromObject6 = getIntLayoutParamsFromObject(f19.get("height"));
            if (intLayoutParamsFromObject6 != null) {
                if (intLayoutParamsFromObject6.intValue() == -999999) {
                    this.mHeight = -2.0f;
                    yogaNode.setHeightAuto();
                } else {
                    this.mHeight = MosaicUtils.E(intLayoutParamsFromObject6.intValue());
                    yogaNode.setHeight(intLayoutParamsFromObject6.intValue());
                }
            }
            if (getIntLayoutParamsFromObject(f19.get(NodeProps.MIN_WIDTH)) != null) {
                yogaNode.setMinWidth(r1.intValue());
            }
            if (getIntLayoutParamsFromObject(f19.get(NodeProps.MIN_HEIGHT)) != null) {
                yogaNode.setMinHeight(r1.intValue());
            }
            if (getIntLayoutParamsFromObject(f19.get(NodeProps.MAX_WIDTH)) != null) {
                yogaNode.setMaxWidth(r1.intValue());
            }
            if (getIntLayoutParamsFromObject(f19.get(NodeProps.MAX_HEIGHT)) != null) {
                yogaNode.setMaxHeight(r1.intValue());
            }
            Integer intLayoutParamsFromObject7 = getIntLayoutParamsFromObject(f19.get(NodeProps.MARGIN_LEFT));
            Integer intLayoutParamsFromObject8 = getIntLayoutParamsFromObject(f19.get(NodeProps.MARGIN_TOP));
            Integer intLayoutParamsFromObject9 = getIntLayoutParamsFromObject(f19.get(NodeProps.MARGIN_RIGHT));
            Integer intLayoutParamsFromObject10 = getIntLayoutParamsFromObject(f19.get(NodeProps.MARGIN_BOTTOM));
            Integer intLayoutParamsFromObject11 = getIntLayoutParamsFromObject(f19.get("margin"));
            if (intLayoutParamsFromObject11 != null && intLayoutParamsFromObject11.intValue() != -999999) {
                yogaNode.setMargin(YogaEdge.ALL, intLayoutParamsFromObject11.intValue());
                this.mLeftMarginInPx = intLayoutParamsFromObject11.intValue();
                this.mTopMarginInPx = intLayoutParamsFromObject11.intValue();
                this.mRightMarginInPx = intLayoutParamsFromObject11.intValue();
                this.mBottomMarginInPx = intLayoutParamsFromObject11.intValue();
            } else {
                if (intLayoutParamsFromObject7 != null && intLayoutParamsFromObject7.intValue() != -999999) {
                    yogaNode.setMargin(YogaEdge.LEFT, intLayoutParamsFromObject7.intValue());
                    this.mLeftMarginInPx = intLayoutParamsFromObject7.intValue();
                }
                if (intLayoutParamsFromObject8 != null && intLayoutParamsFromObject8.intValue() != -999999) {
                    yogaNode.setMargin(YogaEdge.TOP, intLayoutParamsFromObject8.intValue());
                    this.mTopMarginInPx = intLayoutParamsFromObject8.intValue();
                }
                if (intLayoutParamsFromObject9 != null && intLayoutParamsFromObject9.intValue() != -999999) {
                    yogaNode.setMargin(YogaEdge.RIGHT, intLayoutParamsFromObject9.intValue());
                    this.mRightMarginInPx = intLayoutParamsFromObject9.intValue();
                }
                if (intLayoutParamsFromObject10 != null && intLayoutParamsFromObject10.intValue() != -999999) {
                    yogaNode.setMargin(YogaEdge.BOTTOM, intLayoutParamsFromObject10.intValue());
                    this.mBottomMarginInPx = intLayoutParamsFromObject10.intValue();
                }
            }
            Object obj3 = f19.get(NodeProps.FLEX_GROW);
            if (obj3 instanceof Float) {
                f16 = ((Float) obj3).floatValue();
            } else if (obj3 instanceof Integer) {
                f16 = ((Integer) obj3).floatValue();
            } else {
                f16 = 0.0f;
            }
            yogaNode.setFlexGrow(f16);
            Object obj4 = f19.get(NodeProps.FLEX_SHRINK);
            if (obj4 instanceof Float) {
                f17 = ((Float) obj4).floatValue();
            } else if (obj4 instanceof Integer) {
                f17 = ((Integer) obj4).floatValue();
            } else {
                f17 = 1.0f;
            }
            yogaNode.setFlexShrink(f17);
            Integer intLayoutParamsFromObject12 = getIntLayoutParamsFromObject(f19.get(NodeProps.FLEX_BASIS));
            if (intLayoutParamsFromObject12 != null) {
                if (intLayoutParamsFromObject12.intValue() == -999999) {
                    yogaNode.setFlexBasisAuto();
                } else {
                    yogaNode.setFlexBasis(intLayoutParamsFromObject12.intValue());
                }
            }
            Object obj5 = f19.get(NodeProps.ALIGN_SELF);
            if ((obj5 instanceof String) && "auto".equalsIgnoreCase((String) obj5)) {
                yogaNode.setAlignSelf(YogaAlign.AUTO);
            } else if (obj5 instanceof Integer) {
                YogaAlign yogaAlign2 = YogaAlign.AUTO;
                int intValue8 = ((Integer) obj5).intValue();
                if (intValue8 != 0) {
                    if (intValue8 != 1) {
                        if (intValue8 != 2) {
                            if (intValue8 != 3) {
                                if (intValue8 != 4) {
                                    if (intValue8 != 5) {
                                        com.tencent.ams.mosaic.utils.f.h(TAG, "alignSelf value not supported, alignSelfObj: " + obj5);
                                    } else {
                                        yogaAlign2 = YogaAlign.BASELINE;
                                    }
                                } else {
                                    yogaAlign2 = YogaAlign.STRETCH;
                                }
                            } else {
                                yogaAlign2 = YogaAlign.FLEX_END;
                            }
                        } else {
                            yogaAlign2 = YogaAlign.CENTER;
                        }
                    } else {
                        yogaAlign2 = YogaAlign.FLEX_START;
                    }
                }
                yogaNode.setAlignSelf(yogaAlign2);
            }
            Object obj6 = f19.get(NodeProps.BORDER_COLOR);
            if (obj6 instanceof String) {
                String str = (String) obj6;
                if (str.length() > 0) {
                    Object obj7 = f19.get(NodeProps.BORDER_WIDTH);
                    if (obj7 instanceof Integer) {
                        f18 = ((Integer) obj7).floatValue();
                    } else if (obj7 instanceof Float) {
                        f18 = ((Float) obj7).floatValue();
                    } else {
                        f18 = 0.0f;
                    }
                    if (f18 > 0.0f) {
                        setBorder(f18, str);
                    }
                }
            }
            Integer intLayoutParamsFromObject13 = getIntLayoutParamsFromObject(f19.get(NodeProps.PADDING_LEFT));
            Integer intLayoutParamsFromObject14 = getIntLayoutParamsFromObject(f19.get(NodeProps.PADDING_TOP));
            Integer intLayoutParamsFromObject15 = getIntLayoutParamsFromObject(f19.get(NodeProps.PADDING_RIGHT));
            Integer intLayoutParamsFromObject16 = getIntLayoutParamsFromObject(f19.get(NodeProps.PADDING_BOTTOM));
            if (getIntLayoutParamsFromObject(f19.get("padding")) != null) {
                yogaNode.setPadding(YogaEdge.ALL, r11.intValue());
            } else {
                int i3 = 0;
                if (intLayoutParamsFromObject13 == null) {
                    intValue = 0;
                } else {
                    intValue = intLayoutParamsFromObject13.intValue();
                }
                if (intLayoutParamsFromObject14 == null) {
                    intValue2 = 0;
                } else {
                    intValue2 = intLayoutParamsFromObject14.intValue();
                }
                if (intLayoutParamsFromObject15 == null) {
                    intValue3 = 0;
                } else {
                    intValue3 = intLayoutParamsFromObject15.intValue();
                }
                if (intLayoutParamsFromObject16 != null) {
                    i3 = intLayoutParamsFromObject16.intValue();
                }
                yogaNode.setPadding(YogaEdge.LEFT, intValue);
                yogaNode.setPadding(YogaEdge.TOP, intValue2);
                yogaNode.setPadding(YogaEdge.RIGHT, intValue3);
                yogaNode.setPadding(YogaEdge.BOTTOM, i3);
            }
            Object obj8 = f19.get(NodeProps.FLEX_DIRECTION);
            YogaFlexDirection yogaFlexDirection = YogaFlexDirection.ROW;
            if ((obj8 instanceof Integer) && (intValue7 = ((Integer) obj8).intValue()) != 0) {
                if (intValue7 != 1) {
                    if (intValue7 != 2) {
                        if (intValue7 != 3) {
                            com.tencent.ams.mosaic.utils.f.h(TAG, "flexDirection value not supported, flexDirectionObj: " + obj8);
                        } else {
                            yogaFlexDirection = YogaFlexDirection.COLUMN_REVERSE;
                        }
                    } else {
                        yogaFlexDirection = YogaFlexDirection.COLUMN;
                    }
                } else {
                    yogaFlexDirection = YogaFlexDirection.ROW_REVERSE;
                }
            }
            yogaNode.setFlexDirection(yogaFlexDirection);
            Object obj9 = f19.get(NodeProps.FLEX_WRAP);
            YogaWrap yogaWrap = YogaWrap.NO_WRAP;
            if ((obj9 instanceof Integer) && (intValue6 = ((Integer) obj9).intValue()) != 0) {
                if (intValue6 != 1) {
                    if (intValue6 != 2) {
                        com.tencent.ams.mosaic.utils.f.h(TAG, "flexWrap value not supported, flexWrapObj: " + obj9);
                    } else {
                        yogaWrap = YogaWrap.WRAP_REVERSE;
                    }
                } else {
                    yogaWrap = YogaWrap.WRAP;
                }
            }
            yogaNode.setWrap(yogaWrap);
            Object obj10 = f19.get(NodeProps.JUSTIFY_CONTENT);
            YogaJustify yogaJustify = YogaJustify.FLEX_START;
            if ((obj10 instanceof Integer) && (intValue5 = ((Integer) obj10).intValue()) != 0) {
                if (intValue5 != 1) {
                    if (intValue5 != 2) {
                        if (intValue5 != 3) {
                            if (intValue5 != 4) {
                                if (intValue5 != 5) {
                                    com.tencent.ams.mosaic.utils.f.h(TAG, "justifyContent value not supported, justifyContentObj: " + obj10);
                                } else {
                                    yogaJustify = YogaJustify.SPACE_EVENLY;
                                }
                            } else {
                                yogaJustify = YogaJustify.SPACE_AROUND;
                            }
                        } else {
                            yogaJustify = YogaJustify.SPACE_BETWEEN;
                        }
                    } else {
                        yogaJustify = YogaJustify.CENTER;
                    }
                } else {
                    yogaJustify = YogaJustify.FLEX_END;
                }
            }
            yogaNode.setJustifyContent(yogaJustify);
            Object obj11 = f19.get(NodeProps.ALIGN_ITEMS);
            YogaAlign yogaAlign3 = YogaAlign.STRETCH;
            if (obj11 instanceof Integer) {
                int intValue9 = ((Integer) obj11).intValue();
                if (intValue9 != 1) {
                    if (intValue9 != 2) {
                        if (intValue9 != 3) {
                            if (intValue9 != 4) {
                                if (intValue9 != 5) {
                                    com.tencent.ams.mosaic.utils.f.h(TAG, "alignItems value not supported, alignItemsObj: " + obj11);
                                } else {
                                    yogaAlign = YogaAlign.BASELINE;
                                }
                            }
                        } else {
                            yogaAlign = YogaAlign.FLEX_END;
                        }
                    } else {
                        yogaAlign = YogaAlign.CENTER;
                    }
                } else {
                    yogaAlign = YogaAlign.FLEX_START;
                }
                yogaNode.setAlignItems(yogaAlign);
                obj = f19.get("alignContent");
                YogaAlign yogaAlign4 = YogaAlign.FLEX_START;
                if ((obj instanceof Integer) && (intValue4 = ((Integer) obj).intValue()) != 1) {
                    if (intValue4 == 2) {
                        if (intValue4 != 3) {
                            if (intValue4 != 4) {
                                if (intValue4 != 6) {
                                    if (intValue4 != 7) {
                                        com.tencent.ams.mosaic.utils.f.h(TAG, "alignContent value not supported, alignContentObj: " + obj);
                                    } else {
                                        yogaAlign3 = YogaAlign.SPACE_AROUND;
                                    }
                                } else {
                                    yogaAlign3 = YogaAlign.SPACE_BETWEEN;
                                }
                            }
                        } else {
                            yogaAlign3 = YogaAlign.FLEX_END;
                        }
                    } else {
                        yogaAlign3 = YogaAlign.CENTER;
                    }
                    yogaNode.setAlignContent(yogaAlign3);
                    obj2 = f19.get("position");
                    if (obj2 instanceof Integer) {
                        YogaPositionType yogaPositionType = YogaPositionType.STATIC;
                        int intValue10 = ((Integer) obj2).intValue();
                        if (intValue10 != 0) {
                            if (intValue10 != 1) {
                                if (intValue10 != 2) {
                                    if (intValue10 != 3) {
                                        com.tencent.ams.mosaic.utils.f.h(TAG, "positionType value not supported, positionObj: " + obj2);
                                    } else {
                                        this.mPositionType = 3;
                                    }
                                } else {
                                    yogaPositionType = YogaPositionType.RELATIVE;
                                }
                            } else {
                                yogaPositionType = YogaPositionType.ABSOLUTE;
                            }
                        }
                        yogaNode.setPositionType(yogaPositionType);
                    }
                    intLayoutParamsFromObject = getIntLayoutParamsFromObject(f19.get("left"));
                    if (intLayoutParamsFromObject != null) {
                        float floatValue = intLayoutParamsFromObject.floatValue();
                        this.mLeftInPx = floatValue;
                        yogaNode.setPosition(YogaEdge.LEFT, floatValue);
                    }
                    intLayoutParamsFromObject2 = getIntLayoutParamsFromObject(f19.get("top"));
                    if (intLayoutParamsFromObject2 != null) {
                        float floatValue2 = intLayoutParamsFromObject2.floatValue();
                        this.mTopInPx = floatValue2;
                        yogaNode.setPosition(YogaEdge.TOP, floatValue2);
                    }
                    intLayoutParamsFromObject3 = getIntLayoutParamsFromObject(f19.get("right"));
                    if (intLayoutParamsFromObject3 != null) {
                        float floatValue3 = intLayoutParamsFromObject3.floatValue();
                        this.mRightInPx = floatValue3;
                        yogaNode.setPosition(YogaEdge.RIGHT, floatValue3);
                    }
                    intLayoutParamsFromObject4 = getIntLayoutParamsFromObject(f19.get("bottom"));
                    if (intLayoutParamsFromObject4 != null) {
                        float floatValue4 = intLayoutParamsFromObject4.floatValue();
                        this.mBottomInPx = floatValue4;
                        yogaNode.setPosition(YogaEdge.BOTTOM, floatValue4);
                    }
                    this.mYogaNode = yogaNode;
                }
                yogaAlign3 = yogaAlign4;
                yogaNode.setAlignContent(yogaAlign3);
                obj2 = f19.get("position");
                if (obj2 instanceof Integer) {
                }
                intLayoutParamsFromObject = getIntLayoutParamsFromObject(f19.get("left"));
                if (intLayoutParamsFromObject != null) {
                }
                intLayoutParamsFromObject2 = getIntLayoutParamsFromObject(f19.get("top"));
                if (intLayoutParamsFromObject2 != null) {
                }
                intLayoutParamsFromObject3 = getIntLayoutParamsFromObject(f19.get("right"));
                if (intLayoutParamsFromObject3 != null) {
                }
                intLayoutParamsFromObject4 = getIntLayoutParamsFromObject(f19.get("bottom"));
                if (intLayoutParamsFromObject4 != null) {
                }
                this.mYogaNode = yogaNode;
            }
            yogaAlign = yogaAlign3;
            yogaNode.setAlignItems(yogaAlign);
            obj = f19.get("alignContent");
            YogaAlign yogaAlign42 = YogaAlign.FLEX_START;
            if (obj instanceof Integer) {
                if (intValue4 == 2) {
                }
                yogaNode.setAlignContent(yogaAlign3);
                obj2 = f19.get("position");
                if (obj2 instanceof Integer) {
                }
                intLayoutParamsFromObject = getIntLayoutParamsFromObject(f19.get("left"));
                if (intLayoutParamsFromObject != null) {
                }
                intLayoutParamsFromObject2 = getIntLayoutParamsFromObject(f19.get("top"));
                if (intLayoutParamsFromObject2 != null) {
                }
                intLayoutParamsFromObject3 = getIntLayoutParamsFromObject(f19.get("right"));
                if (intLayoutParamsFromObject3 != null) {
                }
                intLayoutParamsFromObject4 = getIntLayoutParamsFromObject(f19.get("bottom"));
                if (intLayoutParamsFromObject4 != null) {
                }
                this.mYogaNode = yogaNode;
            }
            yogaAlign3 = yogaAlign42;
            yogaNode.setAlignContent(yogaAlign3);
            obj2 = f19.get("position");
            if (obj2 instanceof Integer) {
            }
            intLayoutParamsFromObject = getIntLayoutParamsFromObject(f19.get("left"));
            if (intLayoutParamsFromObject != null) {
            }
            intLayoutParamsFromObject2 = getIntLayoutParamsFromObject(f19.get("top"));
            if (intLayoutParamsFromObject2 != null) {
            }
            intLayoutParamsFromObject3 = getIntLayoutParamsFromObject(f19.get("right"));
            if (intLayoutParamsFromObject3 != null) {
            }
            intLayoutParamsFromObject4 = getIntLayoutParamsFromObject(f19.get("bottom"));
            if (intLayoutParamsFromObject4 != null) {
            }
            this.mYogaNode = yogaNode;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setFocusable(final boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, z16);
        } else {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.h
                @Override // java.lang.Runnable
                public final void run() {
                    ComponentBase.this.lambda$setFocusable$1(z16);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setFocusableInTouchMode(final boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, z16);
        } else {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.i
                @Override // java.lang.Runnable
                public final void run() {
                    ComponentBase.this.lambda$setFocusableInTouchMode$2(z16);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setJSEngine(com.tencent.ams.mosaic.jsengine.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) aVar);
        } else {
            this.mJSEngine = aVar;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setMargin(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        com.tencent.ams.mosaic.utils.f.e(tag(), "setSize setMargin left:" + f16 + ", top:" + f17 + ", right:" + f18 + ", bottom:" + f19);
        setMarginInPx((int) MosaicUtils.j(f16), (int) MosaicUtils.j(f17), (int) MosaicUtils.j(f18), (int) MosaicUtils.j(f19));
    }

    public void setMarginInPx(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.mLeftMarginInPx = i3;
        this.mTopMarginInPx = i16;
        this.mRightMarginInPx = i17;
        this.mBottomMarginInPx = i18;
        ViewGroup.LayoutParams layoutParams = getView().getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = this.mLeftMarginInPx;
            marginLayoutParams.topMargin = this.mTopMarginInPx;
            marginLayoutParams.rightMargin = this.mRightMarginInPx;
            marginLayoutParams.bottomMargin = this.mBottomMarginInPx;
            MosaicUtils.I(new Runnable(layoutParams) { // from class: com.tencent.ams.mosaic.jsengine.component.ComponentBase.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ViewGroup.LayoutParams f70928d;

                {
                    this.f70928d = layoutParams;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ComponentBase.this, (Object) layoutParams);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ComponentBase.this.getView().setLayoutParams(this.f70928d);
                    }
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setNextFocusDownId(final String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, (Object) str);
        } else {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.g
                @Override // java.lang.Runnable
                public final void run() {
                    ComponentBase.this.lambda$setNextFocusDownId$4(str);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setNextFocusLeftId(final String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, (Object) str);
        } else {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.m
                @Override // java.lang.Runnable
                public final void run() {
                    ComponentBase.this.lambda$setNextFocusLeftId$6(str);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setNextFocusRightId(final String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, (Object) str);
        } else {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.o
                @Override // java.lang.Runnable
                public final void run() {
                    ComponentBase.this.lambda$setNextFocusRightId$7(str);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setNextFocusUpId(final String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, (Object) str);
        } else {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.l
                @Override // java.lang.Runnable
                public final void run() {
                    ComponentBase.this.lambda$setNextFocusUpId$5(str);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setOnClickListener(final JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) jSFunction);
        } else {
            com.tencent.ams.mosaic.utils.f.e(tag(), "setOnClickListener");
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.k
                @Override // java.lang.Runnable
                public final void run() {
                    ComponentBase.this.lambda$setOnClickListener$0(jSFunction);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setOnFocusChangeListener(final JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, (Object) jSFunction);
        } else {
            com.tencent.ams.mosaic.utils.f.e(tag(), "setOnFocusChangeListener");
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.n
                @Override // java.lang.Runnable
                public final void run() {
                    ComponentBase.this.lambda$setOnFocusChangeListener$3(jSFunction);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setOnTouchListener(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) jSFunction);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e(tag(), "setOnTouchListener");
        if (this.mViewClickListener == null) {
            this.mViewClickListener = new a(this);
        }
        this.mViewClickListener.c(jSFunction);
        getView().setOnTouchListener(this.mViewClickListener);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setPadding(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
            return;
        }
        com.tencent.ams.mosaic.utils.f.e(tag(), "setSize setPadding left:" + f16 + ", top:" + f17 + ", right:" + f18 + ", bottom:" + f19);
        MosaicUtils.I(new Runnable((int) MosaicUtils.j(f16), (int) MosaicUtils.j(f17), (int) MosaicUtils.j(f18), (int) MosaicUtils.j(f19)) { // from class: com.tencent.ams.mosaic.jsengine.component.ComponentBase.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f70924d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f70925e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f70926f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f70927h;

            {
                this.f70924d = r6;
                this.f70925e = r7;
                this.f70926f = r8;
                this.f70927h = r9;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ComponentBase.this, Integer.valueOf(r6), Integer.valueOf(r7), Integer.valueOf(r8), Integer.valueOf(r9));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    ComponentBase.this.getView().setPadding(this.f70924d, this.f70925e, this.f70926f, this.f70927h);
                }
            }
        });
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setParent(Component component) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) component);
        } else {
            this.mParentComponent = component;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setSize(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        com.tencent.ams.mosaic.utils.f.e(tag(), "setSize width:" + f16 + ", height:" + f17);
        this.mWidth = f16;
        this.mHeight = f17;
        MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.ComponentBase.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ComponentBase.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                ViewGroup.LayoutParams layoutParams = ComponentBase.this.getView().getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = (int) ComponentBase.this.getWidthPx();
                    layoutParams.height = (int) ComponentBase.this.getHeightPx();
                    ComponentBase.this.getView().setLayoutParams(layoutParams);
                }
            }
        });
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else {
            MosaicUtils.I(new Runnable(z16) { // from class: com.tencent.ams.mosaic.jsengine.component.ComponentBase.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f70922d;

                {
                    this.f70922d = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ComponentBase.this, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    View view = ComponentBase.this.getView();
                    if (this.f70922d) {
                        i3 = 0;
                    } else {
                        i3 = 4;
                    }
                    view.setVisibility(i3);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setZIndex(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, i3);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e(tag(), "setZIndex:" + i3);
        this.mZIndex = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String tag();

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (String) iPatchRedirector.redirect((short) 44, (Object) this);
        }
        return getClass().getName() + "@" + Integer.toHexString(hashCode()) + ", " + tag() + "{" + getId() + "}";
    }
}
