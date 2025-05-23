package com.tencent.ecommerce.biz.showwindow.repo.window;

import android.content.Context;
import com.tencent.ecommerce.base.network.api.IECResponse;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/repo/window/ECShowWindowAddProductRsp;", "Lcom/tencent/ecommerce/base/network/api/IECResponse;", "d", "Companion", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShowWindowAddProductRsp implements IECResponse {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/repo/window/ECShowWindowAddProductRsp$Companion;", "", "Landroid/content/Context;", "context", "Lcom/tencent/ecommerce/biz/showwindow/repo/window/ECShowWindowAddProductRsp$a;", "respMsgInfo", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final void a(Context context, a respMsgInfo) {
            ECThreadUtilKt.c(new ECShowWindowAddProductRsp$Companion$showMessageBox$1(respMsgInfo, context));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u0012\b\b\u0002\u0010\u001a\u001a\u00020\n\u0012\b\b\u0002\u0010\u001c\u001a\u00020\n\u0012\b\b\u0002\u0010\u001f\u001a\u00020\n\u00a2\u0006\u0004\b \u0010!R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0003\u0010\u000e\"\u0004\b\u0017\u0010\u0010R\"\u0010\u001a\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u000b\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\"\u0010\u001c\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u001b\u0010\u0010R\"\u0010\u001f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u001e\u0010\u0010\u00a8\u0006\""}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/repo/window/ECShowWindowAddProductRsp$a;", "", "", "a", "Z", "getDisplay", "()Z", "setDisplay", "(Z)V", "display", "", "b", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "title", "c", "e", IECSearchBar.METHOD_SET_TEXT, "text", "d", "setLeftBtnText", "leftBtnText", "setLeftBtnUrl", "leftBtnUrl", "setRightBtnText", "rightBtnText", "g", "setRightBtnUrl", "rightBtnUrl", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean display;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private String title;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private String text;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private String leftBtnText;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private String leftBtnUrl;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private String rightBtnText;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private String rightBtnUrl;

        public a(boolean z16, String str, String str2, String str3, String str4, String str5, String str6) {
            this.display = z16;
            this.title = str;
            this.text = str2;
            this.leftBtnText = str3;
            this.leftBtnUrl = str4;
            this.rightBtnText = str5;
            this.rightBtnUrl = str6;
        }

        /* renamed from: a, reason: from getter */
        public final String getLeftBtnText() {
            return this.leftBtnText;
        }

        /* renamed from: b, reason: from getter */
        public final String getLeftBtnUrl() {
            return this.leftBtnUrl;
        }

        /* renamed from: c, reason: from getter */
        public final String getRightBtnText() {
            return this.rightBtnText;
        }

        /* renamed from: d, reason: from getter */
        public final String getRightBtnUrl() {
            return this.rightBtnUrl;
        }

        /* renamed from: e, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: f, reason: from getter */
        public final String getTitle() {
            return this.title;
        }
    }
}
