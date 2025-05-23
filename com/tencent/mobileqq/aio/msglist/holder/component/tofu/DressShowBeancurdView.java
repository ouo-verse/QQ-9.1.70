package com.tencent.mobileqq.aio.msglist.holder.component.tofu;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.mobileqq.aio.msglist.holder.component.tofu.DressShowBeancurdView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.mobileqq.vas.VasNtMMKV;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.vas.VasTempConstant;
import com.tencent.mobileqq.vas.VipNtMMKV;
import com.tencent.mobileqq.vas.search.SearchConstants;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.ZipDownloadBusiness;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGView;
import q13.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u0000 Y2\u00020\u0001:\u0002Z[B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\bW\u0010XJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0016\u0010\u000e\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\u0019\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010'\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\u001cR\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u00101R\u0016\u00104\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0016\u00106\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00101R\u0016\u00107\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u00101R$\u0010<\u001a\u0012\u0012\u0004\u0012\u00020908j\b\u0012\u0004\u0012\u000209`:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010;R\u0016\u0010=\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u00101R\u0016\u0010>\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u00101R\u0016\u0010?\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u00101R\u0016\u0010@\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u00101R\u0016\u0010A\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u00101R\u0016\u0010C\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u00101R\u0016\u0010E\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u00101R\u0016\u0010G\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u00101R\u0016\u0010I\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u00101R\u0016\u0010K\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u00101R\u0016\u0010M\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u00101R\u0016\u0010O\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u00101R\u0016\u0010Q\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u00101R\u0016\u0010S\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010\u0012R\u0018\u0010V\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010U\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/DressShowBeancurdView;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/a;", "", "V", "U", "Lcom/tencent/mobileqq/aio/msg/ah;", "message", "Y", "W", "", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "X", "Lkotlin/Function0;", "loadSuccessCallback", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "T", VasPerfReportUtils.WHILE_UPDATE_ITEM, "needPlay", "Z", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "B", "Landroid/content/Context;", "context", "l", "Landroid/widget/ImageView;", "I", "Landroid/widget/ImageView;", "mBgIv", "J", "mRefreshIcon", "Lcom/tencent/mobileqq/vas/ui/VasPagView;", "K", "Lcom/tencent/mobileqq/vas/ui/VasPagView;", "mAnimPagView1", "L", "mAnimPagView2", "M", "mIcon", "Landroid/widget/TextView;", "N", "Landroid/widget/TextView;", "mText", "Landroid/widget/Button;", "P", "Landroid/widget/Button;", "mButton", "", "Ljava/lang/String;", "icon", BdhLogUtil.LogTag.Tag_Req, "text", ExifInterface.LATITUDE_SOUTH, "bgUrl", "buttonText", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/DressShowBeancurdView$b;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "dressItemDatas", "pagViewFilePath", "dressUrl0", "dressUrl1", "dressUrl2", "dressUrl3", "a0", "dressUrl4", "b0", "dressUrl5", "c0", "pagFilepath0", "d0", "pagFilepath1", "e0", "pagFilepath2", "f0", "pagFilepath3", "g0", "pagFilepath4", "h0", "pagFilepath5", "i0", "isPlaying", "j0", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/DressShowBeancurdView$b;", "curDressItemData", "<init>", "(Landroid/content/Context;)V", "k0", "a", "b", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class DressShowBeancurdView extends com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a {
    static IPatchRedirector $redirector_;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private ImageView mBgIv;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private ImageView mRefreshIcon;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private VasPagView mAnimPagView1;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private VasPagView mAnimPagView2;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private ImageView mIcon;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private TextView mText;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private Button mButton;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private String icon;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private String text;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private String bgUrl;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private String buttonText;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<b> dressItemDatas;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private String pagViewFilePath;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private String dressUrl0;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private String dressUrl1;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private String dressUrl2;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private String dressUrl3;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String dressUrl4;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String dressUrl5;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pagFilepath0;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pagFilepath1;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pagFilepath2;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pagFilepath3;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pagFilepath4;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pagFilepath5;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private boolean isPlaying;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b curDressItemData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/DressShowBeancurdView$a;", "", "", "PAY_URL", "Ljava/lang/String;", "REFRESH_URL", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.tofu.DressShowBeancurdView$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/DressShowBeancurdView$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "appId", "b", "itemId", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "picUrl", "<init>", "(IILjava/lang/String;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int appId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int itemId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String picUrl;

        public b(int i3, int i16, @NotNull String picUrl) {
            Intrinsics.checkNotNullParameter(picUrl, "picUrl");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), picUrl);
                return;
            }
            this.appId = i3;
            this.itemId = i16;
            this.picUrl = picUrl;
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.appId;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.itemId;
        }

        @NotNull
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.picUrl;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (this.appId == bVar.appId && this.itemId == bVar.itemId && Intrinsics.areEqual(this.picUrl, bVar.picUrl)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return (((this.appId * 31) + this.itemId) * 31) + this.picUrl.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "DressItemData(appId=" + this.appId + ", itemId=" + this.itemId + ", picUrl=" + this.picUrl + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001J\u0019\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0096\u0002\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/tofu/DressShowBeancurdView$c", "Lkotlin/Function2;", "", "", "", "p1", "p2", "b", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c implements Function2<Integer, String, Unit> {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f192033e;

        c(Function0<Unit> function0) {
            this.f192033e = function0;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DressShowBeancurdView.this, (Object) function0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Function0 loadSuccessCallback) {
            Intrinsics.checkNotNullParameter(loadSuccessCallback, "$loadSuccessCallback");
            loadSuccessCallback.invoke();
        }

        public void b(int p16, @NotNull String p26) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, p16, (Object) p26);
                return;
            }
            Intrinsics.checkNotNullParameter(p26, "p2");
            if (DressShowBeancurdView.this.T()) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final Function0<Unit> function0 = this.f192033e;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.tofu.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        DressShowBeancurdView.c.c(Function0.this);
                    }
                });
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
            b(num.intValue(), str);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/tofu/DressShowBeancurdView$d", "Lq13/d$a;", "", "type", "", "isSuccess", "ret", "", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class d implements d.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f192034a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ DressShowBeancurdView f192035b;

        d(b bVar, DressShowBeancurdView dressShowBeancurdView) {
            this.f192034a = bVar;
            this.f192035b = dressShowBeancurdView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar, (Object) dressShowBeancurdView);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e() {
            Toast.makeText(MobileQQ.sMobileQQ, "\u6c14\u6ce1\u5df2\u88c5\u626e\uff0c\u53d1\u4e2a\u6d88\u606f\u8bd5\u8bd5\u770b", 1).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(DressShowBeancurdView this$0, Intent intent) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(intent, "$intent");
            RouteUtils.startActivity(this$0.k().getContext(), intent, RouterConstants.UI_ROUTE_TRANSLUCENT_BROWSER);
            Toast.makeText(MobileQQ.sMobileQQ, "\u7eed\u8d39SVIP\uff0c\u7ee7\u7eed\u7545\u4eab\u7279\u6743", 1).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g() {
            Toast.makeText(MobileQQ.sMobileQQ, "\u88c5\u626e\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5", 1).show();
        }

        @Override // q13.d.a
        public void a(int type, boolean isSuccess, int ret) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(type), Boolean.valueOf(isSuccess), Integer.valueOf(ret));
                return;
            }
            if (ret != 0) {
                if (ret != 5002) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.tofu.o
                        @Override // java.lang.Runnable
                        public final void run() {
                            DressShowBeancurdView.d.g();
                        }
                    });
                    return;
                }
                final Intent intent = new Intent();
                intent.putExtra("url", "https://h5.vip.qq.com/p/pay/index?_wv=16781315&_wwv=13&type=svip&aid=mvip.n.pl.gb_txgzaio");
                intent.setData(Uri.parse("https://h5.vip.qq.com/p/pay/index?_wv=16781315&_wwv=13&type=svip&aid=mvip.n.pl.gb_txgzaio"));
                intent.putExtra(QQTranslucentBrowserActivity.FLAG_SHOW_LOADING_DIALOG, false);
                intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final DressShowBeancurdView dressShowBeancurdView = this.f192035b;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.tofu.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        DressShowBeancurdView.d.f(DressShowBeancurdView.this, intent);
                    }
                });
                return;
            }
            if (this.f192034a.a() == 2) {
                VipNtMMKV.INSTANCE.getCommon(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin()).encodeInt(AppConstants.Preferences.SVIP_BUBBLE_ID, this.f192034a.b());
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.tofu.m
                @Override // java.lang.Runnable
                public final void run() {
                    DressShowBeancurdView.d.e();
                }
            });
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50740);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DressShowBeancurdView(@NotNull Context context) {
        super(context, true);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        View findViewById = k().findViewById(R.id.f164599a82);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.bg_img)");
        this.mBgIv = (ImageView) findViewById;
        View findViewById2 = k().findViewById(R.id.xeh);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.icon_refresh)");
        this.mRefreshIcon = (ImageView) findViewById2;
        View findViewById3 = k().findViewById(R.id.spr);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.animation1)");
        this.mAnimPagView1 = (VasPagView) findViewById3;
        View findViewById4 = k().findViewById(R.id.sps);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.animation2)");
        this.mAnimPagView2 = (VasPagView) findViewById4;
        View findViewById5 = k().findViewById(R.id.icon);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R.id.icon)");
        this.mIcon = (ImageView) findViewById5;
        View findViewById6 = k().findViewById(R.id.jfb);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mRootView.findViewById(R.id.text)");
        this.mText = (TextView) findViewById6;
        View findViewById7 = k().findViewById(R.id.ama);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "mRootView.findViewById(R.id.button)");
        this.mButton = (Button) findViewById7;
        this.icon = "";
        this.text = "";
        this.bgUrl = "";
        this.buttonText = "\u5c31\u8fd9\u4e2a";
        this.dressItemDatas = new ArrayList<>();
        this.pagViewFilePath = "";
        this.dressUrl0 = "";
        this.dressUrl1 = "";
        this.dressUrl2 = "";
        this.dressUrl3 = "";
        this.dressUrl4 = "";
        this.dressUrl5 = "";
        this.pagFilepath0 = "";
        this.pagFilepath1 = "";
        this.pagFilepath2 = "";
        this.pagFilepath3 = "";
        this.pagFilepath4 = "";
        this.pagFilepath5 = "";
        k().setOnClickListener(this);
        this.mRefreshIcon.setOnClickListener(this);
        this.mButton.setOnClickListener(this);
        p(k());
    }

    private final void Q(Function0<Unit> loadSuccessCallback) {
        final ZipDownloadBusiness zipDownloadBusiness = (ZipDownloadBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(ZipDownloadBusiness.class);
        this.pagViewFilePath = zipDownloadBusiness.getSavePath(12) + File.separator + "tofu.pag";
        if (T()) {
            loadSuccessCallback.invoke();
        } else {
            final c cVar = new c(loadSuccessCallback);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.tofu.i
                @Override // java.lang.Runnable
                public final void run() {
                    DressShowBeancurdView.R(ZipDownloadBusiness.this, this, cVar);
                }
            }, 64, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(ZipDownloadBusiness zipDownloadBusiness, DressShowBeancurdView this$0, final c downloadListener) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(downloadListener, "$downloadListener");
        zipDownloadBusiness.startDownload(12);
        zipDownloadBusiness.addDownLoadListener(12, new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.tofu.j
            @Override // java.lang.Runnable
            public final void run() {
                DressShowBeancurdView.S(DressShowBeancurdView.c.this);
            }
        });
        com.tencent.cachedrawable.dynamicdrawable.business.download.a aVar = com.tencent.cachedrawable.dynamicdrawable.business.download.a.f98858a;
        aVar.a(this$0.dressUrl0, this$0.pagFilepath0, downloadListener);
        aVar.a(this$0.dressUrl1, this$0.pagFilepath1, downloadListener);
        aVar.a(this$0.dressUrl2, this$0.pagFilepath2, downloadListener);
        aVar.a(this$0.dressUrl3, this$0.pagFilepath3, downloadListener);
        aVar.a(this$0.dressUrl4, this$0.pagFilepath4, downloadListener);
        aVar.a(this$0.dressUrl5, this$0.pagFilepath5, downloadListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(c downloadListener) {
        Intrinsics.checkNotNullParameter(downloadListener, "$downloadListener");
        downloadListener.b(0, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean T() {
        if (!Intrinsics.areEqual(this.pagFilepath0, "") && new File(this.pagFilepath0).exists() && !Intrinsics.areEqual(this.pagFilepath1, "") && new File(this.pagFilepath1).exists() && !Intrinsics.areEqual(this.pagFilepath2, "") && new File(this.pagFilepath2).exists() && !Intrinsics.areEqual(this.pagFilepath3, "") && new File(this.pagFilepath3).exists() && !Intrinsics.areEqual(this.pagFilepath4, "") && new File(this.pagFilepath4).exists() && !Intrinsics.areEqual(this.pagFilepath5, "") && new File(this.pagFilepath5).exists() && !Intrinsics.areEqual(this.pagViewFilePath, "") && new File(this.pagViewFilePath).exists()) {
            return true;
        }
        return false;
    }

    private final void U() {
        if (this.isPlaying) {
            return;
        }
        this.isPlaying = true;
        X(false);
        Z(true);
    }

    private final void V() {
        b bVar;
        if (!this.isPlaying && (bVar = this.curDressItemData) != null) {
            q13.a.f428208a.b(bVar.a(), bVar.b(), new d(bVar, this));
        }
    }

    private final void W(ah message) {
        String l26 = message.l2();
        if (TextUtils.isEmpty(l26)) {
            k().setVisibility(8);
            return;
        }
        JSONObject jSONObject = new JSONObject(l26);
        String j26 = message.j2();
        if (j26 == null) {
            j26 = "";
        }
        this.bgUrl = j26;
        String optString = jSONObject.optString("icon", "");
        Intrinsics.checkNotNullExpressionValue(optString, "data.optString(\"icon\", \"\")");
        this.icon = optString;
        String optString2 = jSONObject.optString("iconMsg", "");
        Intrinsics.checkNotNullExpressionValue(optString2, "data.optString(\"iconMsg\", \"\")");
        this.text = optString2;
        JSONArray optJSONArray = jSONObject.optJSONArray(VideoTemplateParser.ITEM_LIST);
        if (optJSONArray == null) {
            return;
        }
        if (optJSONArray.length() < 3) {
            k().setVisibility(8);
            return;
        }
        k().setVisibility(0);
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            Object obj = optJSONArray.get(i3);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
            JSONObject jSONObject2 = (JSONObject) obj;
            int optInt = jSONObject2.optInt("appId");
            int optInt2 = jSONObject2.optInt("itemId");
            String picUrl = jSONObject2.optString("picUrl");
            ArrayList<b> arrayList = this.dressItemDatas;
            Intrinsics.checkNotNullExpressionValue(picUrl, "picUrl");
            arrayList.add(new b(optInt, optInt2, picUrl));
        }
        X(true);
    }

    private final void X(boolean first) {
        int random;
        VasNtMMKV.Companion companion = VasNtMMKV.INSTANCE;
        int decodeInt = companion.getDressShowBeancurd().decodeInt("curShowId", -1);
        if (decodeInt == -1) {
            decodeInt = ((int) (Math.random() * 100)) % this.dressItemDatas.size();
        }
        if (first) {
            random = decodeInt;
        } else {
            random = ((int) (Math.random() * 100)) % this.dressItemDatas.size();
        }
        companion.getDressShowBeancurd().encodeInt("curShowId", random);
        ArrayList<b> arrayList = this.dressItemDatas;
        this.curDressItemData = arrayList.get(random % arrayList.size());
        this.dressUrl0 = this.dressItemDatas.get(((r0.size() + decodeInt) - 1) % this.dressItemDatas.size()).c();
        ArrayList<b> arrayList2 = this.dressItemDatas;
        this.dressUrl1 = arrayList2.get(decodeInt % arrayList2.size()).c();
        ArrayList<b> arrayList3 = this.dressItemDatas;
        this.dressUrl2 = arrayList3.get((decodeInt + 1) % arrayList3.size()).c();
        this.dressUrl3 = this.dressItemDatas.get(((r0.size() + random) - 1) % this.dressItemDatas.size()).c();
        ArrayList<b> arrayList4 = this.dressItemDatas;
        this.dressUrl4 = arrayList4.get(random % arrayList4.size()).c();
        ArrayList<b> arrayList5 = this.dressItemDatas;
        this.dressUrl5 = arrayList5.get((random + 1) % arrayList5.size()).c();
        String str = VasTempConstant.External.BEANCURD_DRESS_DIR;
        this.pagFilepath0 = str + this.dressUrl0.hashCode() + ".png";
        this.pagFilepath1 = str + this.dressUrl1.hashCode() + ".png";
        this.pagFilepath2 = str + this.dressUrl2.hashCode() + ".png";
        this.pagFilepath3 = str + this.dressUrl3.hashCode() + ".png";
        this.pagFilepath4 = str + this.dressUrl4.hashCode() + ".png";
        this.pagFilepath5 = str + this.dressUrl5.hashCode() + ".png";
    }

    private final void Y(ah message) {
        W(message);
        Q(new DressShowBeancurdView$updateIfNeed$1(this));
    }

    private final void Z(final boolean needPlay) {
        final VasPagView vasPagView;
        if (!T()) {
            return;
        }
        if (this.mAnimPagView1.getVisibility() == 4) {
            vasPagView = this.mAnimPagView1;
        } else {
            vasPagView = this.mAnimPagView2;
        }
        vasPagView.setVisibility(0);
        final File file = new File(this.pagViewFilePath);
        vasPagView.api().build().postAction(new Function1<PAGView, Unit>(file, this, needPlay, vasPagView) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.tofu.DressShowBeancurdView$updatePagView$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ VasPagView $animPagView;
            final /* synthetic */ boolean $needPlay;
            final /* synthetic */ File $pagViewFile;
            final /* synthetic */ DressShowBeancurdView this$0;

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/tofu/DressShowBeancurdView$updatePagView$1$a", "Lorg/libpag/PAGView$PAGViewListener;", "Lorg/libpag/PAGView;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes11.dex */
            public static final class a implements PAGView.PAGViewListener {
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ DressShowBeancurdView f192036d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ boolean f192037e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ VasPagView f192038f;

                a(DressShowBeancurdView dressShowBeancurdView, boolean z16, VasPagView vasPagView) {
                    this.f192036d = dressShowBeancurdView;
                    this.f192037e = z16;
                    this.f192038f = vasPagView;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, dressShowBeancurdView, Boolean.valueOf(z16), vasPagView);
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void c(VasPagView animPagView, DressShowBeancurdView this$0) {
                    VasPagView vasPagView;
                    VasPagView vasPagView2;
                    VasPagView vasPagView3;
                    Intrinsics.checkNotNullParameter(animPagView, "$animPagView");
                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                    vasPagView = this$0.mAnimPagView1;
                    if (Intrinsics.areEqual(animPagView, vasPagView)) {
                        vasPagView3 = this$0.mAnimPagView2;
                        vasPagView3.setVisibility(4);
                    } else {
                        vasPagView2 = this$0.mAnimPagView1;
                        vasPagView2.setVisibility(4);
                    }
                }

                @Override // org.libpag.PAGView.PAGViewListener
                public void onAnimationCancel(@Nullable PAGView p06) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                        this.f192036d.isPlaying = false;
                    } else {
                        iPatchRedirector.redirect((short) 4, (Object) this, (Object) p06);
                    }
                }

                @Override // org.libpag.PAGView.PAGViewListener
                public void onAnimationEnd(@Nullable PAGView p06) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                        this.f192036d.isPlaying = false;
                    } else {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) p06);
                    }
                }

                @Override // org.libpag.PAGView.PAGViewListener
                public void onAnimationRepeat(@Nullable PAGView p06) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, (Object) this, (Object) p06);
                    }
                }

                @Override // org.libpag.PAGView.PAGViewListener
                public void onAnimationStart(@Nullable PAGView p06) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) p06);
                    }
                }

                @Override // org.libpag.PAGView.PAGViewListener
                public void onAnimationUpdate(@Nullable PAGView p06) {
                    VasPagView vasPagView;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                        iPatchRedirector.redirect((short) 6, (Object) this, (Object) p06);
                    } else if (this.f192037e) {
                        vasPagView = this.f192036d.mAnimPagView2;
                        final VasPagView vasPagView2 = this.f192038f;
                        final DressShowBeancurdView dressShowBeancurdView = this.f192036d;
                        vasPagView.post(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0022: INVOKE 
                              (r4v3 'vasPagView' com.tencent.mobileqq.vas.ui.VasPagView)
                              (wrap:java.lang.Runnable:0x001f: CONSTRUCTOR 
                              (r0v1 'vasPagView2' com.tencent.mobileqq.vas.ui.VasPagView A[DONT_INLINE])
                              (r1v0 'dressShowBeancurdView' com.tencent.mobileqq.aio.msglist.holder.component.tofu.DressShowBeancurdView A[DONT_INLINE])
                             A[MD:(com.tencent.mobileqq.vas.ui.VasPagView, com.tencent.mobileqq.aio.msglist.holder.component.tofu.DressShowBeancurdView):void (m), WRAPPED] (LINE:32) call: com.tencent.mobileqq.aio.msglist.holder.component.tofu.q.<init>(com.tencent.mobileqq.vas.ui.VasPagView, com.tencent.mobileqq.aio.msglist.holder.component.tofu.DressShowBeancurdView):void type: CONSTRUCTOR)
                             VIRTUAL call: android.view.View.post(java.lang.Runnable):boolean A[MD:(java.lang.Runnable):boolean (c)] (LINE:35) in method: com.tencent.mobileqq.aio.msglist.holder.component.tofu.DressShowBeancurdView$updatePagView$1.a.onAnimationUpdate(org.libpag.PAGView):void, file: classes11.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:157)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mobileqq.aio.msglist.holder.component.tofu.q, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                            	... 23 more
                            */
                        /*
                            this = this;
                            com.tencent.mobileqq.qfix.redirect.IPatchRedirector r0 = com.tencent.mobileqq.aio.msglist.holder.component.tofu.DressShowBeancurdView$updatePagView$1.a.$redirector_
                            if (r0 == 0) goto Lf
                            r1 = 6
                            boolean r2 = r0.hasPatch(r1)
                            if (r2 == 0) goto Lf
                            r0.redirect(r1, r3, r4)
                            return
                        Lf:
                            boolean r4 = r3.f192037e
                            if (r4 == 0) goto L25
                            com.tencent.mobileqq.aio.msglist.holder.component.tofu.DressShowBeancurdView r4 = r3.f192036d
                            com.tencent.mobileqq.vas.ui.VasPagView r4 = com.tencent.mobileqq.aio.msglist.holder.component.tofu.DressShowBeancurdView.G(r4)
                            com.tencent.mobileqq.vas.ui.VasPagView r0 = r3.f192038f
                            com.tencent.mobileqq.aio.msglist.holder.component.tofu.DressShowBeancurdView r1 = r3.f192036d
                            com.tencent.mobileqq.aio.msglist.holder.component.tofu.q r2 = new com.tencent.mobileqq.aio.msglist.holder.component.tofu.q
                            r2.<init>(r0, r1)
                            r4.post(r2)
                        L25:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.aio.msglist.holder.component.tofu.DressShowBeancurdView$updatePagView$1.a.onAnimationUpdate(org.libpag.PAGView):void");
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$pagViewFile = file;
                    this.this$0 = this;
                    this.$needPlay = needPlay;
                    this.$animPagView = vasPagView;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, file, this, Boolean.valueOf(needPlay), vasPagView);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PAGView pAGView) {
                    invoke2(pAGView);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull PAGView pv5) {
                    String str;
                    String str2;
                    String str3;
                    String str4;
                    String str5;
                    String str6;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) pv5);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(pv5, "pv");
                    PAGFile Load = PagViewMonitor.Load(this.$pagViewFile.getAbsolutePath());
                    if (Load == null) {
                        return;
                    }
                    if (Load.numImages() >= 13) {
                        str = this.this$0.pagFilepath0;
                        PAGImage FromPath = PAGImage.FromPath(str);
                        Intrinsics.checkNotNullExpressionValue(FromPath, "FromPath(pagFilepath0)");
                        str2 = this.this$0.pagFilepath1;
                        PAGImage FromPath2 = PAGImage.FromPath(str2);
                        Intrinsics.checkNotNullExpressionValue(FromPath2, "FromPath(pagFilepath1)");
                        str3 = this.this$0.pagFilepath2;
                        PAGImage FromPath3 = PAGImage.FromPath(str3);
                        Intrinsics.checkNotNullExpressionValue(FromPath3, "FromPath(pagFilepath2)");
                        str4 = this.this$0.pagFilepath3;
                        PAGImage FromPath4 = PAGImage.FromPath(str4);
                        Intrinsics.checkNotNullExpressionValue(FromPath4, "FromPath(pagFilepath3)");
                        str5 = this.this$0.pagFilepath4;
                        PAGImage FromPath5 = PAGImage.FromPath(str5);
                        Intrinsics.checkNotNullExpressionValue(FromPath5, "FromPath(pagFilepath4)");
                        str6 = this.this$0.pagFilepath5;
                        PAGImage FromPath6 = PAGImage.FromPath(str6);
                        Intrinsics.checkNotNullExpressionValue(FromPath6, "FromPath(pagFilepath5)");
                        Load.replaceImage(1, FromPath);
                        Load.replaceImage(2, FromPath2);
                        Load.replaceImage(3, FromPath3);
                        Load.replaceImage(10, FromPath4);
                        Load.replaceImage(11, FromPath5);
                        Load.replaceImage(12, FromPath6);
                    }
                    pv5.setComposition(Load);
                    pv5.setRepeatCount(1);
                    pv5.addListener(new a(this.this$0, this.$needPlay, this.$animPagView));
                    if ((pv5.getVisibility() == 0) && this.$needPlay) {
                        pv5.play();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a0(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k options) {
            Intrinsics.checkNotNullParameter(options, "options");
            options.y(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void updateView() {
            a.C1005a k3 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().k(this.bgUrl);
            VasDynamicDrawableCache vasDynamicDrawableCache = VasDynamicDrawableCache.INSTANCE;
            this.mBgIv.setImageDrawable(k3.l(vasDynamicDrawableCache).a());
            this.mRefreshIcon.setImageDrawable(com.tencent.cachedrawable.dynamicdrawable.api.a.a().k("https://tianquan.gtimg.cn/shoal/vaclient/4a1bd6da-2531-4d41-b192-51cb3c07b163.png").l(vasDynamicDrawableCache).g(new a.c() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.tofu.k
                @Override // com.tencent.cachedrawable.dynamicdrawable.api.a.c
                public final void a(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar) {
                    DressShowBeancurdView.a0(kVar);
                }
            }).a());
            this.mIcon.setImageDrawable(com.tencent.cachedrawable.dynamicdrawable.api.a.a().k(this.icon).l(vasDynamicDrawableCache).a());
            this.mButton.setText(this.buttonText);
            this.mText.setText(this.text);
            Z(false);
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a
        @NotNull
        public View B(@NotNull ah message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) message);
            }
            Intrinsics.checkNotNullParameter(message, "message");
            t(message);
            this.isPlaying = false;
            Y(message);
            q13.a.f428208a.a("tofu", "4", SearchConstants.PLATFORM, "aio", "bubble", 101, 0, System.currentTimeMillis());
            return k();
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a
        @NotNull
        public View l(@Nullable Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (View) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            }
            View inflate = View.inflate(context, R.layout.f168352fq4, null);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026_dress_show_layout, null)");
            return inflate;
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a, android.view.View.OnClickListener
        public void onClick(@NotNull View v3) {
            EventCollector.getInstance().onViewClickedBefore(v3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
            } else {
                Intrinsics.checkNotNullParameter(v3, "v");
                int id5 = v3.getId();
                if (id5 == this.mRefreshIcon.getId()) {
                    U();
                    q13.a.f428208a.a("refresh", "4", SearchConstants.PLATFORM, "aio", "bubble", 102, 0, System.currentTimeMillis());
                } else if (id5 == this.mButton.getId()) {
                    V();
                    q13.a.f428208a.a("sure", "4", SearchConstants.PLATFORM, "aio", "bubble", 102, 0, System.currentTimeMillis());
                }
            }
            EventCollector.getInstance().onViewClicked(v3);
        }
    }
