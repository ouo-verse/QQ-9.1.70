package com.tencent.qqmini.container.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qqmini.container.core.NativeContainer;
import com.tencent.qqmini.container.view.TextArea;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqmini.miniapp.widget.CoverCameraView;
import com.tencent.qqmini.miniapp.widget.media.CoverLiveView;
import com.tencent.qqmini.miniapp.widget.media.CoverPusherView;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.plugins.InputJsPlugin;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.qqmini.sdk.widget.CoverView;
import com.tencent.qqmini.sdk.widget.media.CoverVideoView;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes23.dex */
public class NativeContainer extends FrameLayout {
    private final SparseArray<TextArea> C;
    private final Queue<RequestEvent> D;
    private SoftKeyboardStateHelper E;
    private int F;
    private long G;

    /* renamed from: d, reason: collision with root package name */
    private final float f345997d;

    /* renamed from: e, reason: collision with root package name */
    private final ax f345998e;

    /* renamed from: f, reason: collision with root package name */
    private final MiniWebView f345999f;

    /* renamed from: h, reason: collision with root package name */
    private final com.tencent.qqmini.container.view.a f346000h;

    /* renamed from: i, reason: collision with root package name */
    private final InputMethodManager f346001i;

    /* renamed from: m, reason: collision with root package name */
    private final SparseArray<CoverView> f346002m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class a implements SoftKeyboardStateHelper.SoftKeyboardStateListener {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            NativeContainer.this.d0(0);
            NativeContainer.this.j0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(int i3) {
            NativeContainer.this.d0(i3);
        }

        @Override // com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener
        public void onSoftKeyboardClosed() {
            eu3.f.d(new Runnable() { // from class: com.tencent.qqmini.container.core.al
                @Override // java.lang.Runnable
                public final void run() {
                    NativeContainer.a.this.c();
                }
            }, 50L);
        }

        @Override // com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener
        public void onSoftKeyboardOpened(int i3) {
            Context context = NativeContainer.this.getContext();
            if (context != null && DisplayUtil.hasNavBar(context)) {
                i3 -= DisplayUtil.getNavigationBarHeight(context);
            }
            final int i16 = (int) (i3 / NativeContainer.this.f345997d);
            eu3.f.d(new Runnable() { // from class: com.tencent.qqmini.container.core.am
                @Override // java.lang.Runnable
                public final void run() {
                    NativeContainer.a.this.d(i16);
                }
            }, 50L);
        }
    }

    public NativeContainer(ax axVar, MiniWebView miniWebView) {
        super(miniWebView.getContext());
        this.G = 0L;
        this.f345998e = axVar;
        this.f345999f = miniWebView;
        this.C = new SparseArray<>();
        this.f346002m = new SparseArray<>();
        this.D = new ConcurrentLinkedQueue();
        this.f345997d = DisplayUtil.getDensity(axVar.getContext());
        this.f346000h = new com.tencent.qqmini.container.view.a(this);
        this.f346001i = (InputMethodManager) axVar.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        N(miniWebView);
        axVar.G(this);
    }

    private void A(NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(nativeViewRequestEvent.jsonParams);
            s(jSONObject.optInt("canvasId"), jSONObject.optBoolean("reserve", false), jSONObject.optBoolean("useHardwareAccelerate"), jSONObject.optJSONArray("actions"), nativeViewRequestEvent);
            nativeViewRequestEvent.ok();
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void B(final NativeViewRequestEvent nativeViewRequestEvent) {
        eu3.f.e(new Runnable() { // from class: com.tencent.qqmini.container.core.ae
            @Override // java.lang.Runnable
            public final void run() {
                NativeContainer.this.Q(nativeViewRequestEvent);
            }
        }, 100L);
    }

    private void C(final NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(nativeViewRequestEvent.jsonParams);
            final int optInt = jSONObject.optInt("canvasId");
            final int optInt2 = jSONObject.optInt("parentId");
            final JSONObject optJSONObject = jSONObject.optJSONObject("position");
            final JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("containerId", optInt);
            final String optString = jSONObject.optString("data");
            final boolean optBoolean = jSONObject.optBoolean("hide");
            final boolean optBoolean2 = jSONObject.optBoolean("useHardwareAccelerate");
            final boolean optBoolean3 = jSONObject.optBoolean("disableScroll");
            final boolean optBoolean4 = jSONObject.optBoolean("gesture");
            eu3.f.i(new Runnable() { // from class: com.tencent.qqmini.container.core.ac
                @Override // java.lang.Runnable
                public final void run() {
                    NativeContainer.this.R(optJSONObject, optInt, nativeViewRequestEvent, optString, optBoolean2, optBoolean3, optBoolean4, optInt2, optBoolean, jSONObject2);
                }
            });
        } catch (JSONException e16) {
            QMLog.e("Mini-NativeContainer", nativeViewRequestEvent.event + " error.", e16);
        }
    }

    private void D(final NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            final JSONObject jSONObject = new JSONObject(nativeViewRequestEvent.jsonParams);
            final int optInt = jSONObject.optInt("inputId");
            String optString = jSONObject.optString("data");
            final JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("inputId", optInt);
            if (!TextUtils.isEmpty(optString)) {
                jSONObject2.put("data", optString);
            }
            eu3.f.i(new Runnable() { // from class: com.tencent.qqmini.container.core.aj
                @Override // java.lang.Runnable
                public final void run() {
                    NativeContainer.this.S(optInt, jSONObject, nativeViewRequestEvent, jSONObject2);
                }
            });
        } catch (JSONException e16) {
            QMLog.e("Mini-NativeContainer", nativeViewRequestEvent.event + " error.", e16);
        }
    }

    private void F(final NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            final int optInt = new JSONObject(nativeViewRequestEvent.jsonParams).optInt("canvasId");
            eu3.f.i(new Runnable() { // from class: com.tencent.qqmini.container.core.ai
                @Override // java.lang.Runnable
                public final void run() {
                    NativeContainer.this.T(optInt, nativeViewRequestEvent);
                }
            });
        } catch (JSONException e16) {
            QMLog.e("Mini-NativeContainer", nativeViewRequestEvent.event + " error.", e16);
        }
    }

    private void G(final NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            final JSONObject jSONObject = new JSONObject(nativeViewRequestEvent.jsonParams);
            final int optInt = jSONObject.optInt("inputId");
            eu3.f.i(new Runnable() { // from class: com.tencent.qqmini.container.core.ad
                @Override // java.lang.Runnable
                public final void run() {
                    NativeContainer.this.U(optInt, nativeViewRequestEvent, jSONObject);
                }
            });
        } catch (JSONException e16) {
            QMLog.e("Mini-NativeContainer", nativeViewRequestEvent.event + " error.", e16);
        }
    }

    private void I(final NativeViewRequestEvent nativeViewRequestEvent) {
        eu3.f.i(new Runnable() { // from class: com.tencent.qqmini.container.core.ak
            @Override // java.lang.Runnable
            public final void run() {
                NativeContainer.this.V(nativeViewRequestEvent);
            }
        });
    }

    private void J(final NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            int optInt = new JSONObject(nativeViewRequestEvent.jsonParams).optInt("inputId");
            if (optInt > 0) {
                l0(nativeViewRequestEvent, optInt);
            } else if (System.currentTimeMillis() - this.G > 1000) {
                this.G = System.currentTimeMillis();
                eu3.f.e(new Runnable() { // from class: com.tencent.qqmini.container.core.ag
                    @Override // java.lang.Runnable
                    public final void run() {
                        NativeContainer.this.W(nativeViewRequestEvent);
                    }
                }, 200L);
            }
        } catch (Exception e16) {
            QMLog.e("Mini-NativeContainer", nativeViewRequestEvent.event + " error.", e16);
        }
    }

    private void K(final NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(nativeViewRequestEvent.jsonParams);
            final int optInt = jSONObject.optInt("canvasId");
            final JSONObject optJSONObject = jSONObject.optJSONObject("position");
            final boolean optBoolean = jSONObject.optBoolean("hide", false);
            final JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("containerId", optInt);
            eu3.f.i(new Runnable() { // from class: com.tencent.qqmini.container.core.af
                @Override // java.lang.Runnable
                public final void run() {
                    NativeContainer.this.X(optInt, optJSONObject, optBoolean, nativeViewRequestEvent, jSONObject2);
                }
            });
        } catch (JSONException e16) {
            QMLog.e("Mini-NativeContainer", nativeViewRequestEvent.event + " error.", e16);
        }
    }

    private void L(final NativeViewRequestEvent nativeViewRequestEvent) {
        eu3.f.i(new Runnable() { // from class: com.tencent.qqmini.container.core.aa
            @Override // java.lang.Runnable
            public final void run() {
                NativeContainer.this.Y(nativeViewRequestEvent);
            }
        });
    }

    private void M(final NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            final JSONObject jSONObject = new JSONObject(nativeViewRequestEvent.jsonParams);
            final int optInt = jSONObject.optInt("inputId");
            eu3.f.i(new Runnable() { // from class: com.tencent.qqmini.container.core.ah
                @Override // java.lang.Runnable
                public final void run() {
                    NativeContainer.this.Z(optInt, jSONObject, nativeViewRequestEvent);
                }
            });
        } catch (JSONException e16) {
            QMLog.e("Mini-NativeContainer", nativeViewRequestEvent.event + " error.", e16);
        }
    }

    private void N(View view) {
        SoftKeyboardStateHelper softKeyboardStateHelper = new SoftKeyboardStateHelper(view);
        this.E = softKeyboardStateHelper;
        softKeyboardStateHelper.addSoftKeyboardStateListener(new a());
    }

    private void O(int i3, JSONObject jSONObject, NativeViewRequestEvent nativeViewRequestEvent) {
        TextArea textArea = this.C.get(i3);
        int optInt = jSONObject.optInt("parentId");
        boolean optBoolean = jSONObject.optBoolean(QCircleDaTongConstant.ElementParamValue.FIXED, false);
        if (textArea == null) {
            textArea = new TextArea(getContext(), i3, this);
            textArea.setFixed(optBoolean);
            this.C.put(i3, textArea);
            if (optInt != 0) {
                CoverView coverView = this.f346002m.get(optInt);
                if (coverView != null) {
                    coverView.addView(textArea);
                    textArea.setParentId(optInt);
                }
            } else if (optBoolean) {
                p(textArea);
            } else {
                addView(textArea);
            }
        }
        textArea.setAttributes(jSONObject, false, nativeViewRequestEvent);
    }

    private void P(RequestEvent requestEvent, JSONObject jSONObject) {
        String str;
        if (this.f345999f == null) {
            return;
        }
        JSONObject wrapCallbackFail = ApiUtil.wrapCallbackFail(requestEvent.event, jSONObject);
        if (wrapCallbackFail != null) {
            str = wrapCallbackFail.toString();
        } else {
            str = "";
        }
        this.f345999f.evaluateCallbackJs(requestEvent.callbackId, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(NativeViewRequestEvent nativeViewRequestEvent) {
        com.tencent.qqmini.container.view.a aVar;
        try {
            int optInt = new JSONObject(nativeViewRequestEvent.jsonParams).optInt("inputId");
            TextArea v3 = v(optInt);
            if (v3 != null && (aVar = this.f346000h) != null && aVar.j() != null && !this.f346000h.j().containsKey(Integer.valueOf(optInt))) {
                InputMethodManager inputMethodManager = this.f346001i;
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(v3.getWindowToken(), 0);
                }
                nativeViewRequestEvent.ok();
                String obj = v3.getText().toString();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("inputId", optInt);
                jSONObject.put("value", obj);
                jSONObject.put("cursor", obj.length());
                nativeViewRequestEvent.sendSubscribeJs(InputJsPlugin.ON_KEYBOARD_COMPLETE_CALLBACK, jSONObject.toString(), 0);
                return;
            }
            com.tencent.qqmini.container.view.a aVar2 = this.f346000h;
            if (aVar2 != null) {
                aVar2.n(nativeViewRequestEvent);
            }
        } catch (Throwable th5) {
            QMLog.e("Mini-NativeContainer", "EVENT_HIDE_KEYBOARD error.", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(JSONObject jSONObject, int i3, NativeViewRequestEvent nativeViewRequestEvent, String str, boolean z16, boolean z17, boolean z18, int i16, boolean z19, JSONObject jSONObject2) {
        JSONObject jSONObject3;
        int i17;
        if (jSONObject == null) {
            jSONObject3 = new JSONObject();
        } else {
            jSONObject3 = jSONObject;
        }
        int optInt = (int) ((this.f345997d * jSONObject3.optInt("width")) + 0.5f);
        int optInt2 = (int) ((this.f345997d * jSONObject3.optInt("height")) + 0.5f);
        int optInt3 = (int) ((this.f345997d * jSONObject3.optInt("left")) + 0.5f);
        int optInt4 = (int) ((this.f345997d * jSONObject3.optInt("top")) + 0.5f);
        CoverView coverView = this.f346002m.get(i3);
        if (coverView == null) {
            i17 = optInt4;
            CanvasView canvasView = new CanvasView(this.f345998e, this.f345999f.J(), nativeViewRequestEvent.jsService, this.f345998e.v(), str, i3, z16, Boolean.valueOf(z17), z18);
            this.f346002m.put(i3, canvasView);
            addView(canvasView);
            canvasView.setParentId(i16);
            coverView = canvasView;
        } else {
            i17 = optInt4;
        }
        if (coverView instanceof CanvasView) {
            coverView.setContentDescription("CanvasView " + i3);
            if (z19) {
                coverView.setVisibility(8);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(optInt, optInt2);
            layoutParams.leftMargin = optInt3;
            layoutParams.topMargin = i17;
            coverView.setLayoutParams(layoutParams);
        }
        nativeViewRequestEvent.ok(jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(int i3, JSONObject jSONObject, NativeViewRequestEvent nativeViewRequestEvent, JSONObject jSONObject2) {
        try {
            O(i3, jSONObject, nativeViewRequestEvent);
            nativeViewRequestEvent.ok(jSONObject2);
            q(i3);
        } catch (Throwable th5) {
            QMLog.e("Mini-NativeContainer", nativeViewRequestEvent.event + " error.", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(int i3, NativeViewRequestEvent nativeViewRequestEvent) {
        e0(i3);
        nativeViewRequestEvent.ok();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(int i3, NativeViewRequestEvent nativeViewRequestEvent, JSONObject jSONObject) {
        i0(i3);
        nativeViewRequestEvent.ok(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(NativeViewRequestEvent nativeViewRequestEvent) {
        com.tencent.qqmini.container.view.a aVar = this.f346000h;
        if (aVar != null) {
            aVar.q(nativeViewRequestEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(NativeViewRequestEvent nativeViewRequestEvent) {
        com.tencent.qqmini.container.view.a aVar = this.f346000h;
        if (aVar != null) {
            aVar.r(nativeViewRequestEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(int i3, JSONObject jSONObject, boolean z16, NativeViewRequestEvent nativeViewRequestEvent, JSONObject jSONObject2) {
        m0(i3, jSONObject, z16);
        nativeViewRequestEvent.ok(jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(NativeViewRequestEvent nativeViewRequestEvent) {
        com.tencent.qqmini.container.view.a aVar = this.f346000h;
        if (aVar != null && aVar.s(nativeViewRequestEvent.jsonParams)) {
            nativeViewRequestEvent.ok();
        } else {
            nativeViewRequestEvent.fail();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(int i3, JSONObject jSONObject, NativeViewRequestEvent nativeViewRequestEvent) {
        TextArea textArea = this.C.get(i3);
        if (textArea != null) {
            textArea.setAttributes(jSONObject, true, nativeViewRequestEvent);
        }
        nativeViewRequestEvent.ok(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(int i3, NativeViewRequestEvent nativeViewRequestEvent) {
        TextArea v3 = v(i3);
        if (v3 != null) {
            v3.setFocusable(true);
            v3.setFocusableInTouchMode(true);
            v3.requestFocus();
            InputMethodManager inputMethodManager = this.f346001i;
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(v3, 0);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("inputId", i3);
                nativeViewRequestEvent.ok(jSONObject);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(int i3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("height", i3);
            jSONObject.put("inputId", this.F);
            String jSONObject2 = jSONObject.toString();
            j jsService = this.f345998e.getJsService();
            if (jsService != null) {
                jsService.evaluateSubscribeJS("onKeyboardHeightChange", jSONObject2, w());
            }
        } catch (Throwable th5) {
            QMLog.e("Mini-NativeContainer", "KeyboardObserver error, ", th5);
        }
    }

    private void f0(int i3) {
        for (int i16 = 0; i16 < this.f346002m.size(); i16++) {
            CoverView coverView = this.f346002m.get(this.f346002m.keyAt(i16));
            if (coverView != null && coverView.getParentId() == i3) {
                if (coverView.getParentId() == 0) {
                    removeView(coverView);
                } else {
                    CoverView coverView2 = this.f346002m.get(coverView.getParentId());
                    if (coverView2 != null) {
                        coverView2.removeView(coverView);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0() {
        this.F = -1;
    }

    private void l0(final NativeViewRequestEvent nativeViewRequestEvent, final int i3) {
        eu3.f.e(new Runnable() { // from class: com.tencent.qqmini.container.core.ab
            @Override // java.lang.Runnable
            public final void run() {
                NativeContainer.this.a0(i3, nativeViewRequestEvent);
            }
        }, 100L);
    }

    private void q(int i3) {
        TextArea v3 = v(i3);
        if (v3 != null) {
            v3.A();
        }
    }

    private void x(NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(nativeViewRequestEvent.jsonParams);
            CoverView coverView = this.f346002m.get(jSONObject.optInt("canvasId"));
            if (!(coverView instanceof CanvasView)) {
                nativeViewRequestEvent.fail();
            } else {
                ((CanvasView) coverView).getImageData(jSONObject, nativeViewRequestEvent);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            nativeViewRequestEvent.fail();
        }
    }

    private void y(NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(nativeViewRequestEvent.jsonParams);
            CoverView coverView = this.f346002m.get(jSONObject.optInt("canvasId"));
            if (!(coverView instanceof CanvasView)) {
                P(nativeViewRequestEvent, null);
                return;
            }
            JSONArray jSONArray = new JSONArray();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("method", nativeViewRequestEvent.event);
                jSONObject2.put("data", jSONObject);
                jSONObject2.put("callbackId", nativeViewRequestEvent.callbackId);
                jSONArray.mo162put(jSONObject2);
                ((CanvasView) coverView).addDrawActionCommand(new CanvasView.DrawActionCommand(true, jSONArray, false));
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            P(nativeViewRequestEvent, null);
        }
    }

    private void z(NativeViewRequestEvent nativeViewRequestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(nativeViewRequestEvent.jsonParams);
            CoverView coverView = this.f346002m.get(jSONObject.optInt("canvasId"));
            if (!(coverView instanceof CanvasView)) {
                nativeViewRequestEvent.fail();
            } else {
                ((CanvasView) coverView).saveBitmap(nativeViewRequestEvent, jSONObject);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            nativeViewRequestEvent.fail();
        }
    }

    public String E(NativeViewRequestEvent nativeViewRequestEvent) {
        QMLog.d("Mini-NativeContainer", "event = " + nativeViewRequestEvent.event + ", params = " + nativeViewRequestEvent.jsonParams);
        if ("showKeyboard".equals(nativeViewRequestEvent.event)) {
            J(nativeViewRequestEvent);
            return "";
        }
        if ("hideKeyboard".equals(nativeViewRequestEvent.event)) {
            B(nativeViewRequestEvent);
            return "";
        }
        if (InputJsPlugin.EVENT_UPDATE_INPUT.equals(nativeViewRequestEvent.event)) {
            L(nativeViewRequestEvent);
            return "";
        }
        if (InputJsPlugin.EVENT_SHOW_KEY_BORAD_VALUE.equals(nativeViewRequestEvent.event)) {
            I(nativeViewRequestEvent);
            return "";
        }
        if ("insertTextArea".equals(nativeViewRequestEvent.event)) {
            D(nativeViewRequestEvent);
            return "";
        }
        if (UIJsPlugin.EVENT_UPDATE_TEXTAREA.equals(nativeViewRequestEvent.event)) {
            M(nativeViewRequestEvent);
            return "";
        }
        if (UIJsPlugin.EVENT_REMOVE_TEXTAREA.equals(nativeViewRequestEvent.event)) {
            G(nativeViewRequestEvent);
            return "";
        }
        if ("insertCanvas".equals(nativeViewRequestEvent.event)) {
            C(nativeViewRequestEvent);
            return "";
        }
        if ("updateCanvas".equals(nativeViewRequestEvent.event)) {
            K(nativeViewRequestEvent);
            return "";
        }
        if ("removeCanvas".equals(nativeViewRequestEvent.event)) {
            F(nativeViewRequestEvent);
            return "";
        }
        if ("drawCanvas".equals(nativeViewRequestEvent.event)) {
            A(nativeViewRequestEvent);
            return "";
        }
        if ("canvasToTempFilePath".equals(nativeViewRequestEvent.event)) {
            z(nativeViewRequestEvent);
            return "";
        }
        if ("canvasPutImageData".equals(nativeViewRequestEvent.event)) {
            y(nativeViewRequestEvent);
            return "";
        }
        if ("canvasGetImageData".equals(nativeViewRequestEvent.event)) {
            x(nativeViewRequestEvent);
            return "";
        }
        return "";
    }

    public String H(RequestEvent requestEvent) {
        if (!ViewCompat.isAttachedToWindow(this)) {
            this.D.offer(requestEvent);
            return "";
        }
        IJsPluginEngine jsPluginEngine = this.f345998e.getJsPluginEngine();
        if (jsPluginEngine == null) {
            return "";
        }
        return jsPluginEngine.checkAuthorization(requestEvent);
    }

    public void b0() {
        for (int i3 = 0; i3 < this.f346002m.size(); i3++) {
            ViewParent viewParent = (CoverView) this.f346002m.valueAt(i3);
            if (viewParent instanceof CoverView.OnPageChangeListener) {
                ((CoverView.OnPageChangeListener) viewParent).onPageBackground();
            }
        }
    }

    public void c0(String str, String str2) {
        MiniWebView miniWebView = this.f345999f;
        if (miniWebView == null) {
            return;
        }
        miniWebView.evaluateSubscribeJS(str, str2, miniWebView.J());
    }

    public void e0(int i3) {
        CoverView coverView = this.f346002m.get(i3);
        if (!(coverView instanceof CanvasView)) {
            return;
        }
        f0(i3);
        int parentId = coverView.getParentId();
        if (parentId != 0) {
            if (this.f346002m.get(parentId) != null) {
                this.f346002m.get(parentId).removeView(coverView);
            }
        } else {
            removeView(coverView);
        }
        this.f346002m.remove(i3);
    }

    public boolean g0(int i3) {
        CoverView coverView = this.f346002m.get(i3);
        if (coverView == null) {
            return false;
        }
        f0(i3);
        int parentId = coverView.getParentId();
        if (parentId != 0) {
            if (this.f346002m.get(parentId) != null) {
                this.f346002m.get(parentId).removeView(coverView);
            }
        } else if (coverView.isFixed()) {
            h0(coverView);
        } else {
            removeView(coverView);
        }
        this.f346002m.remove(i3);
        if (coverView instanceof CoverLiveView) {
            ((CoverLiveView) coverView).release();
            return true;
        }
        if (coverView instanceof CoverPusherView) {
            ((CoverPusherView) coverView).release();
            return true;
        }
        return true;
    }

    public void h0(View view) {
        ViewParent parent = getParent();
        if ((parent instanceof ViewGroup) && view.getParent() == parent) {
            ((ViewGroup) parent).removeView(view);
        }
    }

    public void i0(int i3) {
        TextArea textArea = this.C.get(i3);
        if (textArea == null) {
            return;
        }
        this.C.remove(i3);
        int G = textArea.G();
        if (G != 0) {
            if (this.f346002m.get(G) != null) {
                this.f346002m.get(G).removeView(textArea);
            }
        } else if (textArea.K()) {
            h0(textArea);
        } else {
            removeView(textArea);
        }
        this.C.remove(i3);
    }

    public void k0() {
        for (int i3 = 0; i3 < this.f346002m.size(); i3++) {
            ViewParent viewParent = (CoverView) this.f346002m.valueAt(i3);
            if (viewParent instanceof CoverView.OnPageChangeListener) {
                ((CoverView.OnPageChangeListener) viewParent).onPageForeground();
            }
        }
    }

    public void m0(int i3, JSONObject jSONObject, boolean z16) {
        CoverView coverView = this.f346002m.get(i3);
        if (!(coverView instanceof CanvasView)) {
            QMLog.e("Mini-NativeContainer", "updateCanvas failed! appCanvas return null! canvasId: " + i3);
            return;
        }
        if (z16) {
            coverView.setVisibility(8);
        } else {
            coverView.setVisibility(0);
        }
        if (jSONObject != null) {
            int optInt = (int) ((this.f345997d * jSONObject.optInt("width")) + 0.5f);
            int optInt2 = (int) ((this.f345997d * jSONObject.optInt("height")) + 0.5f);
            int optInt3 = (int) ((this.f345997d * jSONObject.optInt("left")) + 0.5f);
            int optInt4 = (int) ((this.f345997d * jSONObject.optInt("top")) + 0.5f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(optInt, optInt2);
            layoutParams.leftMargin = optInt3;
            layoutParams.topMargin = optInt4;
            coverView.setLayoutParams(layoutParams);
        }
    }

    public boolean o(int i3, int i16, CoverView coverView, boolean z16) {
        if (coverView == null) {
            QMLog.w("Mini-NativeContainer", "Failed to add coverView, coverView is null");
            return false;
        }
        this.f346002m.put(i16, coverView);
        if (i3 == 0) {
            if (z16) {
                p(coverView);
                return true;
            }
            addView(coverView);
            return true;
        }
        CoverView t16 = t(i3);
        if (t16 != null) {
            t16.addView(coverView);
            return true;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        while (!this.D.isEmpty()) {
            RequestEvent poll = this.D.poll();
            if (poll != null) {
                this.f345998e.getJsPluginEngine().checkAuthorization(poll);
            }
        }
    }

    public void p(View view) {
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).addView(view);
        }
    }

    public void r() {
        for (int i3 = 0; i3 < this.C.size(); i3++) {
            TextArea valueAt = this.C.valueAt(i3);
            if (valueAt != null) {
                valueAt.C();
            }
        }
        this.C.clear();
        for (int i16 = 0; i16 < this.f346002m.size(); i16++) {
            CoverView valueAt2 = this.f346002m.valueAt(i16);
            if (valueAt2 instanceof CoverVideoView) {
                CoverVideoView coverVideoView = (CoverVideoView) valueAt2;
                coverVideoView.stop();
                coverVideoView.release();
                removeView(valueAt2);
            } else if (valueAt2 instanceof CoverLiveView) {
                ((CoverLiveView) valueAt2).release();
                removeView(valueAt2);
            } else if (valueAt2 instanceof CoverPusherView) {
                ((CoverPusherView) valueAt2).release();
                removeView(valueAt2);
            } else if (valueAt2 instanceof CoverCameraView) {
                ((CoverCameraView) valueAt2).closeCamera();
            }
        }
        this.f346002m.clear();
        SoftKeyboardStateHelper softKeyboardStateHelper = this.E;
        if (softKeyboardStateHelper != null) {
            softKeyboardStateHelper.removeSoftKeyboardStateListener();
        }
        this.f345998e.H(this);
    }

    public void s(int i3, boolean z16, boolean z17, JSONArray jSONArray, NativeViewRequestEvent nativeViewRequestEvent) {
        CoverView coverView = this.f346002m.get(i3);
        if (!(coverView instanceof CanvasView)) {
            nativeViewRequestEvent.fail();
        } else {
            ((CanvasView) coverView).addDrawActionCommand(new CanvasView.DrawActionCommand(z16, jSONArray, z17));
        }
    }

    public void setCurrentInputId(int i3) {
        this.F = i3;
    }

    public CoverView t(int i3) {
        return this.f346002m.get(i3);
    }

    public SoftKeyboardStateHelper u() {
        return this.E;
    }

    public TextArea v(int i3) {
        SparseArray<TextArea> sparseArray = this.C;
        if (sparseArray != null && sparseArray.size() > 0) {
            return this.C.get(i3);
        }
        return null;
    }

    public int w() {
        return this.f345999f.J();
    }
}
