package com.tencent.ntcompose.material.base;

import com.tencent.kuikly.core.views.APNGVView;
import com.tencent.kuikly.core.views.CanvasView;
import com.tencent.kuikly.core.views.FooterRefreshView;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.InputView;
import com.tencent.kuikly.core.views.ModalView;
import com.tencent.kuikly.core.views.PageListView;
import com.tencent.kuikly.core.views.RefreshView;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.TextAreaView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ab;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ax;
import com.tencent.kuikly.core.views.az;
import com.tencent.kuikly.core.views.bc;
import com.tencent.kuikly.core.views.cm;
import com.tencent.kuikly.core.views.h;
import com.tencent.kuikly.core.views.n;
import com.tencent.kuikly.core.views.v;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.ntcompose.core.ComposeRenderView;
import com.tencent.ntcompose.core.e;
import com.tencent.qq.effect.engine.QEffectType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ntcompose/material/base/a;", "Lcom/tencent/ntcompose/core/e;", "", "viewType", "Lcom/tencent/ntcompose/core/ComposeRenderView;", "createComposeView", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a implements com.tencent.ntcompose.core.e {

    /* renamed from: a, reason: collision with root package name */
    public static final a f339408a = new a();

    a() {
    }

    public ComposeRenderView a(String str) {
        return e.a.a(this, str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000c. Please report as an issue. */
    @Override // com.tencent.ntcompose.core.e
    public ComposeRenderView createComposeView(String viewType) {
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        boolean z16 = false;
        int i3 = 1;
        switch (viewType.hashCode()) {
            case -1113182960:
                if (viewType.equals("root_modal")) {
                    ModalView modalView = new ModalView();
                    modalView.l(false);
                    return com.tencent.ntcompose.core.c.b(modalView);
                }
                return com.tencent.ntcompose.core.c.b(new v());
            case -1096937569:
                if (viewType.equals(QEffectType.LOTTIE_TAG)) {
                    return com.tencent.ntcompose.core.c.b(new ax());
                }
                return com.tencent.ntcompose.core.c.b(new v());
            case -1038124961:
                if (viewType.equals("text_area")) {
                    return com.tencent.ntcompose.core.c.b(new TextAreaView());
                }
                return com.tencent.ntcompose.core.c.b(new v());
            case -945063535:
                if (viewType.equals("refresh_in_footer")) {
                    return com.tencent.ntcompose.core.c.b(new RefreshView(true));
                }
                return com.tencent.ntcompose.core.c.b(new v());
            case -842613072:
                if (viewType.equals("rich_text")) {
                    ComposeRenderView a16 = a("RichTextView");
                    return a16 == null ? com.tencent.ntcompose.core.c.b(new RichTextView()) : a16;
                }
                return com.tencent.ntcompose.core.c.b(new v());
            case -650254229:
                if (viewType.equals(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT)) {
                    return com.tencent.ntcompose.core.c.b(new TextView());
                }
                return com.tencent.ntcompose.core.c.b(new v());
            case -543421525:
                if (viewType.equals("waterfall_list")) {
                    return com.tencent.ntcompose.core.c.b(new cm());
                }
                return com.tencent.ntcompose.core.c.b(new v());
            case 110742:
                if (viewType.equals("pag")) {
                    return com.tencent.ntcompose.core.c.b(new bc());
                }
                return com.tencent.ntcompose.core.c.b(new v());
            case 3000872:
                if (viewType.equals("apng")) {
                    return com.tencent.ntcompose.core.c.b(new APNGVView());
                }
                return com.tencent.ntcompose.core.c.b(new v());
            case 3027047:
                if (viewType.equals("blur")) {
                    return com.tencent.ntcompose.core.c.b(new n());
                }
                return com.tencent.ntcompose.core.c.b(new v());
            case 3322014:
                if (viewType.equals("list")) {
                    return com.tencent.ntcompose.core.c.b(new aq());
                }
                return com.tencent.ntcompose.core.c.b(new v());
            case 3344108:
                if (viewType.equals("mask")) {
                    return com.tencent.ntcompose.core.c.b(new az());
                }
                return com.tencent.ntcompose.core.c.b(new v());
            case 3556653:
                if (viewType.equals("text")) {
                    ComposeRenderView a17 = a("TextView");
                    return a17 == null ? com.tencent.ntcompose.core.c.b(new TextView()) : a17;
                }
                return com.tencent.ntcompose.core.c.b(new v());
            case 3619493:
                if (viewType.equals("view")) {
                    ComposeRenderView a18 = a("DivView");
                    return a18 == null ? com.tencent.ntcompose.core.c.b(new v()) : a18;
                }
                return com.tencent.ntcompose.core.c.b(new v());
            case 99469628:
                if (viewType.equals("hover")) {
                    return com.tencent.ntcompose.core.c.b(new ab());
                }
                return com.tencent.ntcompose.core.c.b(new v());
            case 100313435:
                if (viewType.equals("image")) {
                    ComposeRenderView a19 = a("ImageView");
                    return a19 == null ? com.tencent.ntcompose.core.c.b(new ImageView()) : a19;
                }
                return com.tencent.ntcompose.core.c.b(new v());
            case 100358090:
                if (viewType.equals("input")) {
                    return com.tencent.ntcompose.core.c.b(new InputView());
                }
                return com.tencent.ntcompose.core.c.b(new v());
            case 104069805:
                if (viewType.equals("modal")) {
                    ModalView modalView2 = new ModalView();
                    modalView2.l(true);
                    return com.tencent.ntcompose.core.c.b(modalView2);
                }
                return com.tencent.ntcompose.core.c.b(new v());
            case 124740831:
                if (viewType.equals("activity_indicator")) {
                    return com.tencent.ntcompose.core.c.b(new h());
                }
                return com.tencent.ntcompose.core.c.b(new v());
            case 883640398:
                if (viewType.equals("page_list")) {
                    return com.tencent.ntcompose.core.c.b(new PageListView());
                }
                return com.tencent.ntcompose.core.c.b(new v());
            case 1085444827:
                if (viewType.equals("refresh")) {
                    return com.tencent.ntcompose.core.c.b(new RefreshView(z16, i3, null));
                }
                return com.tencent.ntcompose.core.c.b(new v());
            case 1804280887:
                if (viewType.equals("footer_refresh")) {
                    return com.tencent.ntcompose.core.c.b(new FooterRefreshView());
                }
                return com.tencent.ntcompose.core.c.b(new v());
            case 2011128184:
                if (viewType.equals("Canvas")) {
                    return com.tencent.ntcompose.core.c.b(new CanvasView());
                }
                return com.tencent.ntcompose.core.c.b(new v());
            default:
                return com.tencent.ntcompose.core.c.b(new v());
        }
    }
}
