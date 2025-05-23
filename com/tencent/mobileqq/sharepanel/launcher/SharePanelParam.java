package com.tencent.mobileqq.sharepanel.launcher;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.sharepanel.action.j;
import com.tencent.mobileqq.sharepanel.c;
import com.tencent.mobileqq.sharepanel.e;
import com.tencent.mobileqq.sharepanel.g;
import com.tencent.mobileqq.sharepanel.i;
import com.tencent.mobileqq.sharepanel.k;
import com.tencent.mobileqq.sharepanel.l;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.mobileqq.sharepanel.model.d;
import com.tencent.mobileqq.sharepanel.n;
import com.tencent.mobileqq.sharepanel.p;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u00d6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00bc\u00012\u00020\u0001:\u0001cB\t\u00a2\u0006\u0006\b\u00b9\u0001\u0010\u00ba\u0001B\u0013\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0006\b\u00b9\u0001\u0010\u00bb\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0006\u0010\n\u001a\u00020\tR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010%\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\"\u0010-\u001a\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00104\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b\u001b\u00101\"\u0004\b2\u00103R$\u0010<\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010C\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010K\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010R\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR(\u0010[\u001a\b\u0012\u0004\u0012\u00020T0S8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR(\u0010`\u001a\b\u0012\u0004\u0012\u00020\\0S8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010V\u001a\u0004\b^\u0010X\"\u0004\b_\u0010ZR(\u0010d\u001a\b\u0012\u0004\u0012\u00020a0S8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bb\u0010V\u001a\u0004\bc\u0010X\"\u0004\b6\u0010ZR$\u0010l\u001a\u0004\u0018\u00010e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR$\u0010t\u001a\u0004\u0018\u00010m8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR$\u0010|\u001a\u0004\u0018\u00010u8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R(\u0010\u0083\u0001\u001a\u0004\u0018\u00010}8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0005\b\u0014\u0010\u0082\u0001R*\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b$\u0010\u0085\u0001\u001a\u0005\b/\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R,\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R,\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R,\u0010\u00a1\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u009b\u0001\u0010\u009c\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010\u00a0\u0001R+\u0010\u00a8\u0001\u001a\u0005\u0018\u00010\u00a2\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0006\b\u00a3\u0001\u0010\u00a4\u0001\u001a\u0006\b\u00a5\u0001\u0010\u00a6\u0001\"\u0005\bU\u0010\u00a7\u0001R+\u0010\u00af\u0001\u001a\u0005\u0018\u00010\u00a9\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0006\b\u00aa\u0001\u0010\u00ab\u0001\u001a\u0006\b\u00ac\u0001\u0010\u00ad\u0001\"\u0005\b~\u0010\u00ae\u0001R,\u0010\u00b7\u0001\u001a\u0005\u0018\u00010\u00b0\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00b1\u0001\u0010\u00b2\u0001\u001a\u0006\b\u00b3\u0001\u0010\u00b4\u0001\"\u0006\b\u00b5\u0001\u0010\u00b6\u0001R#\u0010\u00b8\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bz\u0010\u0014\u001a\u0004\b\u0013\u0010\u0016\"\u0004\bE\u0010\u0018\u00a8\u0006\u00bd\u0001"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "B", "", "d", "Ljava/lang/String;", "u", "()Ljava/lang/String;", "i0", "(Ljava/lang/String;)V", WadlProxyConsts.SCENE_ID, "e", "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Z", "n0", "(Z)V", "supportMultiSelect", "", "f", "Ljava/lang/CharSequence;", "y", "()Ljava/lang/CharSequence;", "m0", "(Ljava/lang/CharSequence;)V", "shareTitle", h.F, "getHideRecentContact", "N", "hideRecentContact", "Lcom/tencent/mobileqq/sharepanel/launcher/ShareActionDynamicModifier;", "i", "Lcom/tencent/mobileqq/sharepanel/launcher/ShareActionDynamicModifier;", "c", "()Lcom/tencent/mobileqq/sharepanel/launcher/ShareActionDynamicModifier;", "D", "(Lcom/tencent/mobileqq/sharepanel/launcher/ShareActionDynamicModifier;)V", "dynamicModifier", "Landroid/content/Intent;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Intent;", "()Landroid/content/Intent;", UserInfo.SEX_FEMALE, "(Landroid/content/Intent;)V", "forwardIntent", "Lcom/tencent/mobileqq/sharepanel/model/d;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/sharepanel/model/d;", "t", "()Lcom/tencent/mobileqq/sharepanel/model/d;", "h0", "(Lcom/tencent/mobileqq/sharepanel/model/d;)V", "reportModel", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/graphics/Bitmap;", "e0", "(Landroid/graphics/Bitmap;)V", "previewImage", "Lcom/tencent/mobileqq/sharepanel/g;", "E", "Lcom/tencent/mobileqq/sharepanel/g;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/tencent/mobileqq/sharepanel/g;", "setTopPreviewViewCreator", "(Lcom/tencent/mobileqq/sharepanel/g;)V", "topPreviewViewCreator", "Lcom/tencent/mobileqq/sharepanel/e;", "Lcom/tencent/mobileqq/sharepanel/e;", "r", "()Lcom/tencent/mobileqq/sharepanel/e;", "f0", "(Lcom/tencent/mobileqq/sharepanel/e;)V", "recentContactFilter", "", "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", "G", "Ljava/util/List;", ReportConstant.COSTREPORT_PREFIX, "()Ljava/util/List;", "g0", "(Ljava/util/List;)V", "recentContactList", "Lcom/tencent/mobileqq/sharepanel/action/j;", "H", "w", "k0", "shareChannelList", "Lcom/tencent/mobileqq/sharepanel/action/a;", "I", "a", "appendActionList", "Lcom/tencent/mobileqq/sharepanel/l;", "J", "Lcom/tencent/mobileqq/sharepanel/l;", "o", "()Lcom/tencent/mobileqq/sharepanel/l;", "c0", "(Lcom/tencent/mobileqq/sharepanel/l;)V", "onShowListener", "Lcom/tencent/mobileqq/sharepanel/k;", "K", "Lcom/tencent/mobileqq/sharepanel/k;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/sharepanel/k;", "b0", "(Lcom/tencent/mobileqq/sharepanel/k;)V", "onDismissListener", "Lcom/tencent/mobileqq/sharepanel/i;", "L", "Lcom/tencent/mobileqq/sharepanel/i;", "k", "()Lcom/tencent/mobileqq/sharepanel/i;", "V", "(Lcom/tencent/mobileqq/sharepanel/i;)V", "onCancelListener", "Lcom/tencent/mobileqq/sharepanel/j;", "M", "Lcom/tencent/mobileqq/sharepanel/j;", "l", "()Lcom/tencent/mobileqq/sharepanel/j;", "(Lcom/tencent/mobileqq/sharepanel/j;)V", "onClickListener", "Lcom/tencent/mobileqq/sharepanel/h;", "Lcom/tencent/mobileqq/sharepanel/h;", "()Lcom/tencent/mobileqq/sharepanel/h;", "a0", "(Lcom/tencent/mobileqq/sharepanel/h;)V", "onDisabledItemClickListener", "Lcom/tencent/mobileqq/sharepanel/c;", "P", "Lcom/tencent/mobileqq/sharepanel/c;", "b", "()Lcom/tencent/mobileqq/sharepanel/c;", "setBottomViewCreator", "(Lcom/tencent/mobileqq/sharepanel/c;)V", "bottomViewCreator", "Lcom/tencent/mobileqq/sharepanel/p;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/sharepanel/p;", HippyTKDListViewAdapter.X, "()Lcom/tencent/mobileqq/sharepanel/p;", "l0", "(Lcom/tencent/mobileqq/sharepanel/p;)V", "shareConfirmChecker", "Lcom/tencent/mobileqq/sharepanel/n;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/sharepanel/n;", "p", "()Lcom/tencent/mobileqq/sharepanel/n;", "d0", "(Lcom/tencent/mobileqq/sharepanel/n;)V", "prepareForwardHandler", "Lcom/tencent/mobileqq/sharepanel/d;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/sharepanel/d;", "g", "()Lcom/tencent/mobileqq/sharepanel/d;", "(Lcom/tencent/mobileqq/sharepanel/d;)V", "forwardInterceptor", "Lcom/tencent/mobileqq/sharepanel/b;", "T", "Lcom/tencent/mobileqq/sharepanel/b;", "j", "()Lcom/tencent/mobileqq/sharepanel/b;", "(Lcom/tencent/mobileqq/sharepanel/b;)V", "forwardResultCallback", "Lcom/tencent/mobileqq/sharepanel/channel/a;", "U", "Lcom/tencent/mobileqq/sharepanel/channel/a;", "v", "()Lcom/tencent/mobileqq/sharepanel/channel/a;", "j0", "(Lcom/tencent/mobileqq/sharepanel/channel/a;)V", "shareChannelHandleListener", "finishActivityWhenDismiss", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SharePanelParam implements Parcelable {
    static IPatchRedirector $redirector_;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private d reportModel;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Bitmap previewImage;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private g topPreviewViewCreator;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private e recentContactFilter;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private List<SharePanelContactItem> recentContactList;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private List<j> shareChannelList;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private List<com.tencent.mobileqq.sharepanel.action.a> appendActionList;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private l onShowListener;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private k onDismissListener;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private i onCancelListener;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.sharepanel.j onClickListener;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.sharepanel.h onDisabledItemClickListener;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private c bottomViewCreator;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private p shareConfirmChecker;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private n prepareForwardHandler;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.sharepanel.d forwardInterceptor;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.sharepanel.b forwardResultCallback;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.sharepanel.channel.a shareChannelHandleListener;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean finishActivityWhenDismiss;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String sceneId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean supportMultiSelect;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CharSequence shareTitle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hideRecentContact;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ShareActionDynamicModifier dynamicModifier;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Intent forwardIntent;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.launcher.SharePanelParam$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion implements Parcelable.Creator<SharePanelParam> {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SharePanelParam createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (SharePanelParam) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SharePanelParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SharePanelParam[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (SharePanelParam[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
            }
            return new SharePanelParam[size];
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37501);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 56)) {
            redirector.redirect((short) 56);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SharePanelParam() {
        List<SharePanelContactItem> emptyList;
        List<j> emptyList2;
        List<com.tencent.mobileqq.sharepanel.action.a> emptyList3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.sceneId = "";
        this.dynamicModifier = new ShareActionDynamicModifier(null, null, 3, null);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.recentContactList = emptyList;
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        this.shareChannelList = emptyList2;
        emptyList3 = CollectionsKt__CollectionsKt.emptyList();
        this.appendActionList = emptyList3;
    }

    @Nullable
    public final g A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (g) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.topPreviewViewCreator;
    }

    public final boolean B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Boolean) iPatchRedirector.redirect((short) 55, (Object) this)).booleanValue();
        }
        return !this.hideRecentContact;
    }

    public final void C(@NotNull List<com.tencent.mobileqq.sharepanel.action.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) list);
        } else {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.appendActionList = list;
        }
    }

    public final void D(@NotNull ShareActionDynamicModifier shareActionDynamicModifier) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) shareActionDynamicModifier);
        } else {
            Intrinsics.checkNotNullParameter(shareActionDynamicModifier, "<set-?>");
            this.dynamicModifier = shareActionDynamicModifier;
        }
    }

    public final void E(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, z16);
        } else {
            this.finishActivityWhenDismiss = z16;
        }
    }

    public final void F(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) intent);
        } else {
            this.forwardIntent = intent;
        }
    }

    public final void G(@Nullable com.tencent.mobileqq.sharepanel.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) dVar);
        } else {
            this.forwardInterceptor = dVar;
        }
    }

    public final void M(@Nullable com.tencent.mobileqq.sharepanel.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) bVar);
        } else {
            this.forwardResultCallback = bVar;
        }
    }

    public final void N(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.hideRecentContact = z16;
        }
    }

    public final void V(@Nullable i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) iVar);
        } else {
            this.onCancelListener = iVar;
        }
    }

    public final void Z(@Nullable com.tencent.mobileqq.sharepanel.j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) jVar);
        } else {
            this.onClickListener = jVar;
        }
    }

    @NotNull
    public final List<com.tencent.mobileqq.sharepanel.action.a> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (List) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.appendActionList;
    }

    public final void a0(@Nullable com.tencent.mobileqq.sharepanel.h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) hVar);
        } else {
            this.onDisabledItemClickListener = hVar;
        }
    }

    @Nullable
    public final c b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (c) iPatchRedirector.redirect((short) 38, (Object) this);
        }
        return this.bottomViewCreator;
    }

    public final void b0(@Nullable k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) kVar);
        } else {
            this.onDismissListener = kVar;
        }
    }

    @NotNull
    public final ShareActionDynamicModifier c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ShareActionDynamicModifier) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.dynamicModifier;
    }

    public final void c0(@Nullable l lVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) lVar);
        } else {
            this.onShowListener = lVar;
        }
    }

    public final void d0(@Nullable n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) nVar);
        } else {
            this.prepareForwardHandler = nVar;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return ((Integer) iPatchRedirector.redirect((short) 54, (Object) this)).intValue();
        }
        return 0;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Boolean) iPatchRedirector.redirect((short) 50, (Object) this)).booleanValue();
        }
        return this.finishActivityWhenDismiss;
    }

    public final void e0(@Nullable Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) bitmap);
        } else {
            this.previewImage = bitmap;
        }
    }

    @Nullable
    public final Intent f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Intent) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.forwardIntent;
    }

    public final void f0(@Nullable e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) eVar);
        } else {
            this.recentContactFilter = eVar;
        }
    }

    @Nullable
    public final com.tencent.mobileqq.sharepanel.d g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (com.tencent.mobileqq.sharepanel.d) iPatchRedirector.redirect((short) 44, (Object) this);
        }
        return this.forwardInterceptor;
    }

    public final void g0(@NotNull List<SharePanelContactItem> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) list);
        } else {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.recentContactList = list;
        }
    }

    public final void h0(@Nullable d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) dVar);
        } else {
            this.reportModel = dVar;
        }
    }

    public final void i0(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.sceneId = str;
        }
    }

    @Nullable
    public final com.tencent.mobileqq.sharepanel.b j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (com.tencent.mobileqq.sharepanel.b) iPatchRedirector.redirect((short) 46, (Object) this);
        }
        return this.forwardResultCallback;
    }

    public final void j0(@Nullable com.tencent.mobileqq.sharepanel.channel.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) aVar);
        } else {
            this.shareChannelHandleListener = aVar;
        }
    }

    @Nullable
    public final i k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (i) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return this.onCancelListener;
    }

    public final void k0(@NotNull List<j> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) list);
        } else {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.shareChannelList = list;
        }
    }

    @Nullable
    public final com.tencent.mobileqq.sharepanel.j l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (com.tencent.mobileqq.sharepanel.j) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return this.onClickListener;
    }

    public final void l0(@Nullable p pVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) pVar);
        } else {
            this.shareConfirmChecker = pVar;
        }
    }

    @Nullable
    public final com.tencent.mobileqq.sharepanel.h m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (com.tencent.mobileqq.sharepanel.h) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        return this.onDisabledItemClickListener;
    }

    public final void m0(@Nullable CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) charSequence);
        } else {
            this.shareTitle = charSequence;
        }
    }

    @Nullable
    public final k n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (k) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return this.onDismissListener;
    }

    public final void n0(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.supportMultiSelect = z16;
        }
    }

    @Nullable
    public final l o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (l) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.onShowListener;
    }

    @Nullable
    public final n p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (n) iPatchRedirector.redirect((short) 42, (Object) this);
        }
        return this.prepareForwardHandler;
    }

    @Nullable
    public final Bitmap q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Bitmap) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.previewImage;
    }

    @Nullable
    public final e r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (e) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.recentContactFilter;
    }

    @NotNull
    public final List<SharePanelContactItem> s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (List) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.recentContactList;
    }

    @Nullable
    public final d t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (d) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.reportModel;
    }

    @NotNull
    public final String u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.sceneId;
    }

    @Nullable
    public final com.tencent.mobileqq.sharepanel.channel.a v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return (com.tencent.mobileqq.sharepanel.channel.a) iPatchRedirector.redirect((short) 48, (Object) this);
        }
        return this.shareChannelHandleListener;
    }

    @NotNull
    public final List<j> w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (List) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.shareChannelList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.sceneId);
        parcel.writeByte(this.supportMultiSelect ? (byte) 1 : (byte) 0);
        CharSequence charSequence = this.shareTitle;
        if (charSequence != null) {
            str = charSequence.toString();
        } else {
            str = null;
        }
        parcel.writeString(str);
        parcel.writeByte(this.hideRecentContact ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.dynamicModifier, flags);
        parcel.writeParcelable(this.forwardIntent, flags);
    }

    @Nullable
    public final p x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (p) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        return this.shareConfirmChecker;
    }

    @Nullable
    public final CharSequence y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CharSequence) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.shareTitle;
    }

    public final boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.supportMultiSelect;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharePanelParam(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) parcel);
            return;
        }
        String readString = parcel.readString();
        this.sceneId = readString == null ? "" : readString;
        this.supportMultiSelect = parcel.readByte() != 0;
        this.shareTitle = parcel.readString();
        this.hideRecentContact = parcel.readByte() != 0;
        ShareActionDynamicModifier shareActionDynamicModifier = (ShareActionDynamicModifier) parcel.readParcelable(ShareActionDynamicModifier.class.getClassLoader());
        this.dynamicModifier = shareActionDynamicModifier == null ? new ShareActionDynamicModifier(null, null, 3, null) : shareActionDynamicModifier;
        this.forwardIntent = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
    }
}
