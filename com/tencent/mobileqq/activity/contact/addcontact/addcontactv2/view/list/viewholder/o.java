package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.viewholder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.image.URLDrawable;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.swipe.AddContactSwipeMenuLayout;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.flock.api.IFlockLauncher;
import com.tencent.mobileqq.flock.api.JoinFlockAndTroopResult;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.addcontact.model.AddContactDataType;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.utils.TroopHeaderLayout;
import com.tencent.mobileqq.troop.widget.labelv2.TroopLabelLayoutV2;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb$Label;
import tencent.im.troop.flock.QeventPB$ActivityTime;
import tencent.im.troop.flock.QeventPB$Feed;
import tencent.im.troop.flock.QeventPB$FeedTagInfo;
import tencent.im.troop.flock.QeventPB$JoinInfo;
import tencent.im.troop.flock.QeventPB$PoiInfo;
import tencent.im.troop.flock.QeventPB$User;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0084\u00012\u00020\u0001:\u0002\u0085\u0001B\u0013\u0012\b\u0010\u0081\u0001\u001a\u00030\u0080\u0001\u00a2\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J \u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J(\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001fH\u0002J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020!H\u0003J&\u0010%\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u001fJ\u0016\u0010(\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u001fJ\u001e\u0010*\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u0018R\u0017\u0010/\u001a\u00020+8\u0006\u00a2\u0006\f\n\u0004\b*\u0010,\u001a\u0004\b-\u0010.R\u0017\u00105\u001a\u0002008\u0006\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010C\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010@R\u0014\u0010F\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010ER\u0014\u0010H\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010@R\u0014\u0010J\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010@R\u0014\u0010L\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010@R\u0014\u0010O\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010NR\u0014\u0010R\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010QR\u0014\u0010V\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010X\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010NR\u0017\u0010\\\u001a\u00020M8\u0006\u00a2\u0006\f\n\u0004\bY\u0010N\u001a\u0004\bZ\u0010[R\u0017\u0010b\u001a\u00020]8\u0006\u00a2\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u0017\u0010f\u001a\u00020S8\u0006\u00a2\u0006\f\n\u0004\bc\u0010U\u001a\u0004\bd\u0010eR\u0017\u0010h\u001a\u00020S8\u0006\u00a2\u0006\f\n\u0004\b(\u0010U\u001a\u0004\bg\u0010eR\"\u0010o\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\"\u0010r\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010j\u001a\u0004\bp\u0010l\"\u0004\bq\u0010nRT\u0010\u007f\u001a4\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\bt\u0012\b\bu\u0012\u0004\b\b(v\u0012\u0013\u0012\u00110w\u00a2\u0006\f\bt\u0012\b\bu\u0012\u0004\b\b(x\u0012\u0004\u0012\u00020\u0004\u0018\u00010s8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\by\u0010z\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~\u00a8\u0006\u0086\u0001"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/list/viewholder/o;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/troop/recommend/data/RecommendTroopItem;", "troopItem", "", "O", "K", "Ltencent/im/troop/flock/QeventPB$Feed;", "flockData", BdhLogUtil.LogTag.Tag_Conn, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/c;", "data", "", "position", "Lcom/tencent/mobileqq/app/MayknowRecommendManager;", "mayKnowManager", "Y", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/data/MayKnowRecommend;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "d0", "q0", "Landroid/graphics/Bitmap;", "defaultAvatar", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "r0", "", "coverUrl", "Landroid/graphics/drawable/Drawable;", "s0", "", "tsInMs", "z0", "cacheAvatar", "c0", "curData", "P", "W", "defaultPublisherAvatar", "E", "Landroid/widget/RelativeLayout;", "Landroid/widget/RelativeLayout;", "i0", "()Landroid/widget/RelativeLayout;", "contentLayout", "Lcom/tencent/widget/ThemeImageView;", UserInfo.SEX_FEMALE, "Lcom/tencent/widget/ThemeImageView;", "f0", "()Lcom/tencent/widget/ThemeImageView;", "avatarView", "Lcom/tencent/mobileqq/widget/RoundImageView;", "G", "Lcom/tencent/mobileqq/widget/RoundImageView;", "roundAvatarView", "Lcom/tencent/mobileqq/troop/utils/TroopHeaderLayout;", "H", "Lcom/tencent/mobileqq/troop/utils/TroopHeaderLayout;", "headerLayout", "Landroid/widget/ImageView;", "I", "Landroid/widget/ImageView;", "stateIconView", "J", "borderView", "Lcom/tencent/widget/SingleLineTextView;", "Lcom/tencent/widget/SingleLineTextView;", "titleView", "L", "officialCertificationView", "M", "certificationOneView", "N", "certificationTwoView", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "labelContainer", "Lcom/tencent/mobileqq/troop/widget/labelv2/TroopLabelLayoutV2;", "Lcom/tencent/mobileqq/troop/widget/labelv2/TroopLabelLayoutV2;", "labelLayout", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/TextView;", "reasonView", ExifInterface.LATITUDE_SOUTH, "extraTagsContainer", "T", "m0", "()Landroid/widget/LinearLayout;", "extraInfoContainer", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "U", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "o0", "()Lcom/tencent/biz/qui/quibutton/QUIButton;", "operateBtn", "V", "p0", "()Landroid/widget/TextView;", "operateText", "j0", "delText", "X", "Ljava/lang/String;", "e0", "()Ljava/lang/String;", "w0", "(Ljava/lang/String;)V", "avatarKey", "k0", "x0", "extraAvatarKey", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "key", "Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "type", "Z", "Lkotlin/jvm/functions/Function2;", "getOnItemDelAction", "()Lkotlin/jvm/functions/Function2;", "y0", "(Lkotlin/jvm/functions/Function2;)V", "onItemDelAction", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "a0", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class o extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final RelativeLayout contentLayout;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ThemeImageView avatarView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final RoundImageView roundAvatarView;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final TroopHeaderLayout headerLayout;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ImageView stateIconView;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final ImageView borderView;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final SingleLineTextView titleView;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final ImageView officialCertificationView;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final ImageView certificationOneView;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final ImageView certificationTwoView;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout labelContainer;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final TroopLabelLayoutV2 labelLayout;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final TextView reasonView;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout extraTagsContainer;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout extraInfoContainer;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final QUIButton operateBtn;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final TextView operateText;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final TextView delText;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private String avatarKey;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private String extraAvatarKey;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private Function2<? super String, ? super AddContactDataType, Unit> onItemDelAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/list/viewholder/o$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.viewholder.o$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/list/viewholder/o$b", "Lcom/tencent/mobileqq/flock/api/a;", "Lcom/tencent/mobileqq/flock/api/JoinFlockAndTroopResult;", "result", "", "a", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mobileqq.flock.api.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.flock.api.a
        public void a(@NotNull JoinFlockAndTroopResult result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) result);
                return;
            }
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("AddContactContentViewHolder", 1, "addFlockAndJoinTroop result: " + result);
        }

        @Override // com.tencent.mobileqq.flock.api.a
        public void b(@NotNull JoinFlockAndTroopResult result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) result);
                return;
            }
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.e("AddContactContentViewHolder", 1, "addFlockAndJoinTroop result: " + result);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class c<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
            }
            com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.d dVar = com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.d.f180871a;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(dVar.a(((com.tencent.mobileqq.troop.widget.labelv2.model.b) t16).b())), Integer.valueOf(dVar.a(((com.tencent.mobileqq.troop.widget.labelv2.model.b) t17).b())));
            return compareValues;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50155);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@NotNull View itemView) {
        super(itemView);
        AddContactSwipeMenuLayout addContactSwipeMenuLayout;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
            return;
        }
        this.avatarKey = "";
        this.extraAvatarKey = "";
        View findViewById = itemView.findViewById(R.id.b9w);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.content_layout)");
        this.contentLayout = (RelativeLayout) findViewById;
        View findViewById2 = itemView.findViewById(R.id.f165909du3);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.iv_avatar)");
        this.avatarView = (ThemeImageView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.y8l);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.iv_round_avatar)");
        this.roundAvatarView = (RoundImageView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.ddm);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.image_container)");
        this.headerLayout = (TroopHeaderLayout) findViewById4;
        View findViewById5 = itemView.findViewById(R.id.f88084w4);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.state_icon)");
        this.stateIconView = (ImageView) findViewById5;
        View findViewById6 = itemView.findViewById(R.id.f88054w1);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.state_border)");
        this.borderView = (ImageView) findViewById6;
        View findViewById7 = itemView.findViewById(R.id.loi);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.iv_title)");
        this.titleView = (SingleLineTextView) findViewById7;
        View findViewById8 = itemView.findViewById(R.id.tqn);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.id.certification_official)");
        this.officialCertificationView = (ImageView) findViewById8;
        View findViewById9 = itemView.findViewById(R.id.tql);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "itemView.findViewById(R.id.certification_1)");
        this.certificationOneView = (ImageView) findViewById9;
        View findViewById10 = itemView.findViewById(R.id.tqm);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "itemView.findViewById(R.id.certification_2)");
        this.certificationTwoView = (ImageView) findViewById10;
        View findViewById11 = itemView.findViewById(R.id.e1p);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "itemView.findViewById(R.id.label_container)");
        this.labelContainer = (LinearLayout) findViewById11;
        View findViewById12 = itemView.findViewById(R.id.e1r);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "itemView.findViewById(R.id.label_layout)");
        this.labelLayout = (TroopLabelLayoutV2) findViewById12;
        View findViewById13 = itemView.findViewById(R.id.uyu);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "itemView.findViewById(R.id.extra_tags_container)");
        this.extraTagsContainer = (LinearLayout) findViewById13;
        View findViewById14 = itemView.findViewById(R.id.uyt);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "itemView.findViewById(R.id.extra_info_container)");
        this.extraInfoContainer = (LinearLayout) findViewById14;
        View findViewById15 = itemView.findViewById(R.id.f110446ij);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "itemView.findViewById(R.id.tv_reason)");
        this.reasonView = (TextView) findViewById15;
        View findViewById16 = itemView.findViewById(R.id.zzi);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "itemView.findViewById(R.id.operate_btn)");
        this.operateBtn = (QUIButton) findViewById16;
        View findViewById17 = itemView.findViewById(R.id.zzk);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "itemView.findViewById(R.id.operate_text)");
        this.operateText = (TextView) findViewById17;
        View findViewById18 = itemView.findViewById(R.id.f109266fc);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "itemView.findViewById(R.id.tv_menu_del)");
        this.delText = (TextView) findViewById18;
        if (itemView instanceof AddContactSwipeMenuLayout) {
            addContactSwipeMenuLayout = (AddContactSwipeMenuLayout) itemView;
        } else {
            addContactSwipeMenuLayout = null;
        }
        if (addContactSwipeMenuLayout != null) {
            addContactSwipeMenuLayout.setOnAnimationEndListener(new com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.swipe.c() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.viewholder.b
                @Override // com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.swipe.c
                public final void onAnimationEnd() {
                    o.z();
                }
            });
        }
    }

    private final void A(QeventPB$Feed flockData) {
        Object firstOrNull;
        List<QeventPB$FeedTagInfo> list = flockData.tag_infos.get();
        if (list != null && !list.isEmpty()) {
            this.extraTagsContainer.removeAllViews();
            this.extraTagsContainer.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            QeventPB$FeedTagInfo qeventPB$FeedTagInfo = (QeventPB$FeedTagInfo) firstOrNull;
            if (qeventPB$FeedTagInfo != null) {
                com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.c cVar = com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.c.f180933a;
                Context context = this.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                String str = qeventPB$FeedTagInfo.tag_name.get();
                Intrinsics.checkNotNullExpressionValue(str, "it.tag_name.get()");
                this.extraTagsContainer.addView(cVar.a(context, str), layoutParams);
                return;
            }
            return;
        }
        this.extraTagsContainer.setVisibility(8);
    }

    private final void B(QeventPB$Feed flockData, Bitmap defaultAvatar) {
        String str;
        int i3;
        PBUInt32Field pBUInt32Field;
        PBStringField pBStringField;
        boolean z16 = false;
        this.extraInfoContainer.setVisibility(0);
        this.extraInfoContainer.removeAllViews();
        Context context = this.itemView.getContext();
        int c16 = x.c(context, 18.0f);
        ImageView imageView = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c16, c16);
        layoutParams.setMarginEnd(x.c(context, 4.0f));
        imageView.setLayoutParams(layoutParams);
        imageView.setImageBitmap(defaultAvatar);
        this.extraInfoContainer.addView(imageView);
        imageView.setId(R.id.dvo);
        QeventPB$User qeventPB$User = flockData.publisher.get();
        if (qeventPB$User != null && (pBStringField = qeventPB$User.nick) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        QeventPB$JoinInfo qeventPB$JoinInfo = flockData.join_info.get();
        if (qeventPB$JoinInfo != null && (pBUInt32Field = qeventPB$JoinInfo.count) != null) {
            i3 = pBUInt32Field.get();
        } else {
            i3 = 0;
        }
        String str2 = i3 + "\u4eba\u53c2\u4e0e";
        if (str.length() == 0) {
            z16 = true;
        }
        if (!z16) {
            str2 = str + APLogFileUtil.SEPARATOR_LOG + str2;
        }
        TextView textView = new TextView(context);
        textView.setTextSize(1, 14.0f);
        textView.setTextColor(context.getColor(R.color.qui_common_text_secondary));
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setText(str2);
        this.extraInfoContainer.addView(textView);
    }

    private final void C(final QeventPB$Feed flockData) {
        if (flockData == null) {
            this.extraTagsContainer.setVisibility(8);
            return;
        }
        this.extraTagsContainer.removeAllViews();
        this.extraTagsContainer.setVisibility(0);
        com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.c cVar = com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.c.f180933a;
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        String str = flockData.title.get();
        Intrinsics.checkNotNullExpressionValue(str, "flockData.title.get()");
        View d16 = cVar.d(context, str);
        d16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.viewholder.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.D(o.this, flockData, view);
            }
        });
        this.extraTagsContainer.addView(d16, new LinearLayout.LayoutParams(-2, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(o this$0, QeventPB$Feed qeventPB$Feed, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        this$0.r0(context, qeventPB$Feed);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(QeventPB$Feed flockData, Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(flockData, "$flockData");
        if (flockData.group_status.get() == 1) {
            QQToast.makeText(context, "\u642d\u5b50\u7fa4\u5df2\u89e3\u6563\uff0c\u53ef\u54a8\u8be2\u53d1\u8d77\u8005", 0).show();
        } else {
            IFlockLauncher iFlockLauncher = (IFlockLauncher) QRoute.api(IFlockLauncher.class);
            Intrinsics.checkNotNullExpressionValue(context, "context");
            iFlockLauncher.addFlockAndJoinTroop(context, com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.a.f180863a.b(flockData), new b(), 1004);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(o this$0, QeventPB$Feed flockData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(flockData, "$flockData");
        Context context = this$0.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        this$0.r0(context, flockData);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(o this$0, QeventPB$Feed flockData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(flockData, "$flockData");
        Function2<? super String, ? super AddContactDataType, Unit> function2 = this$0.onItemDelAction;
        if (function2 != null) {
            String str = flockData.f436058id.get();
            Intrinsics.checkNotNullExpressionValue(str, "flockData.id.get()");
            function2.invoke(str, AddContactDataType.FLOCK);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void K(final RecommendTroopItem troopItem) {
        int collectionSizeOrDefault;
        List<oidb_0x9fb$Label> list = troopItem.labelList;
        if (list != null) {
            if (!list.isEmpty()) {
                this.labelContainer.setVisibility(0);
                List<oidb_0x9fb$Label> list2 = list;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (oidb_0x9fb$Label label : list2) {
                    com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.a aVar = com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.a.f180863a;
                    Intrinsics.checkNotNullExpressionValue(label, "label");
                    arrayList.add(aVar.o(label, false));
                }
                this.labelLayout.d(arrayList);
            } else {
                this.labelContainer.setVisibility(8);
            }
        }
        com.tencent.mobileqq.troop.adapter.c.d(troopItem, this.headerLayout, this.stateIconView, this.borderView);
        final int i3 = 10028;
        this.operateBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.viewholder.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.L(o.this, troopItem, i3, view);
            }
        });
        final int i16 = 21;
        this.contentLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.viewholder.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.M(o.this, troopItem, i16, i3, view);
            }
        });
        this.delText.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.viewholder.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.N(o.this, troopItem, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(o this$0, RecommendTroopItem troopItem, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopItem, "$troopItem");
        ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).joinRecommendTroop(this$0.itemView.getContext(), troopItem, i3);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(o this$0, RecommendTroopItem troopItem, int i3, int i16, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopItem, "$troopItem");
        ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).openRecommendTroop(this$0.itemView.getContext(), troopItem, i3, i16);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(o this$0, RecommendTroopItem troopItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopItem, "$troopItem");
        Function2<? super String, ? super AddContactDataType, Unit> function2 = this$0.onItemDelAction;
        if (function2 != null) {
            function2.invoke(troopItem.uin.toString(), AddContactDataType.f293812GROUP);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void O(RecommendTroopItem troopItem) {
        this.titleView.setText(troopItem.name);
        this.titleView.setContentDescription(troopItem.name);
        if (!troopItem.isJoined() && !troopItem.hasRequestJoin) {
            this.operateBtn.setVisibility(0);
            this.operateText.setVisibility(8);
            this.operateBtn.setText(R.string.fvi);
        } else {
            this.operateBtn.setVisibility(8);
            this.operateText.setVisibility(0);
            if (troopItem.hasRequestJoin) {
                this.operateText.setText(R.string.fvj);
            } else {
                this.operateText.setText(R.string.fvk);
            }
        }
        if (TextUtils.isEmpty(troopItem.intro)) {
            this.reasonView.setVisibility(8);
        } else {
            this.reasonView.setVisibility(0);
            this.reasonView.setText(new QQText(troopItem.intro, 11, 16));
        }
    }

    private final void Q(final RecommendTroopItem troopItem) {
        int collectionSizeOrDefault;
        List<oidb_0x9fb$Label> list = troopItem.labelList;
        if (list != null) {
            if (!list.isEmpty()) {
                this.labelContainer.setVisibility(0);
                List<oidb_0x9fb$Label> list2 = list;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (oidb_0x9fb$Label label : list2) {
                    com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.a aVar = com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.a.f180863a;
                    Intrinsics.checkNotNullExpressionValue(label, "label");
                    arrayList.add(aVar.o(label, true));
                }
                CollectionsKt___CollectionsKt.sortedWith(arrayList, new c());
                this.labelLayout.d(arrayList);
            } else {
                this.labelContainer.setVisibility(8);
            }
        }
        com.tencent.mobileqq.troop.adapter.c.c(troopItem, this.stateIconView, this.borderView);
        com.tencent.mobileqq.troop.adapter.c.a(troopItem, this.officialCertificationView);
        com.tencent.mobileqq.troop.adapter.c.b(troopItem, this.certificationOneView, this.certificationTwoView);
        this.operateBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.viewholder.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.R(RecommendTroopItem.this, view);
            }
        });
        this.contentLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.viewholder.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.T(RecommendTroopItem.this, view);
            }
        });
        this.delText.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.viewholder.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.U(o.this, troopItem, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(RecommendTroopItem troopItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(troopItem, "$troopItem");
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).jumpGuildFormSearch(troopItem.uin, troopItem.authSig, 246623, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(RecommendTroopItem troopItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(troopItem, "$troopItem");
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).jumpGuildFormSearch(troopItem.uin, troopItem.authSig, 246623, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(o this$0, RecommendTroopItem troopItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopItem, "$troopItem");
        Function2<? super String, ? super AddContactDataType, Unit> function2 = this$0.onItemDelAction;
        if (function2 != null) {
            function2.invoke(troopItem.uin.toString(), AddContactDataType.GUILD);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Y(com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c data, final int position, final MayknowRecommendManager mayKnowManager) {
        ArrayList arrayList;
        List createListBuilder;
        List<? extends com.tencent.mobileqq.troop.widget.labelv2.model.b> build;
        boolean z16;
        int collectionSizeOrDefault;
        final MayKnowRecommend e16 = data.e();
        if (e16 == null) {
            return;
        }
        this.titleView.setText(e16.nick);
        com.tencent.mobileqq.troop.widget.labelv2.model.a aVar = new com.tencent.mobileqq.troop.widget.labelv2.model.a(e16.age, e16.gender);
        List<MayKnowRecommend.MayKnowRecommendLabel> list = e16.msgLabel;
        if (list != null) {
            List<MayKnowRecommend.MayKnowRecommendLabel> list2 = list;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            arrayList = new ArrayList(collectionSizeOrDefault);
            for (MayKnowRecommend.MayKnowRecommendLabel it : list2) {
                com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.a aVar2 = com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.a.f180863a;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(aVar2.n(it));
            }
        } else {
            arrayList = null;
        }
        createListBuilder = CollectionsKt__CollectionsJVMKt.createListBuilder();
        if (aVar.c() > 0) {
            createListBuilder.add(aVar);
        }
        if (arrayList != null) {
            createListBuilder.addAll(arrayList);
        }
        build = CollectionsKt__CollectionsJVMKt.build(createListBuilder);
        if (!build.isEmpty()) {
            this.labelContainer.setVisibility(0);
            this.labelLayout.d(build);
        } else {
            this.labelContainer.setVisibility(8);
        }
        String str = e16.recommendReason;
        Intrinsics.checkNotNullExpressionValue(str, "personItem.recommendReason");
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.reasonView.setVisibility(8);
        } else {
            this.reasonView.setVisibility(0);
            this.reasonView.setText(e16.recommendReason);
        }
        this.operateBtn.setVisibility(0);
        this.operateBtn.setText(this.itemView.getContext().getString(R.string.f170769zn0));
        this.operateBtn.setType(1);
        this.operateBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.viewholder.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.Z(o.this, e16, mayKnowManager, view);
            }
        });
        this.operateText.setVisibility(8);
        this.contentLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.viewholder.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.a0(o.this, e16, position, mayKnowManager, view);
            }
        });
        this.delText.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.viewholder.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.b0(o.this, e16, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(o this$0, MayKnowRecommend personItem, MayknowRecommendManager mayKnowManager, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(personItem, "$personItem");
        Intrinsics.checkNotNullParameter(mayKnowManager, "$mayKnowManager");
        Context context = this$0.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        this$0.d0(context, personItem, mayKnowManager);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(o this$0, MayKnowRecommend personItem, int i3, MayknowRecommendManager mayKnowManager, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(personItem, "$personItem");
        Intrinsics.checkNotNullParameter(mayKnowManager, "$mayKnowManager");
        Context context = this$0.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        this$0.q0(context, personItem, i3, mayKnowManager);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(o this$0, MayKnowRecommend personItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(personItem, "$personItem");
        Function2<? super String, ? super AddContactDataType, Unit> function2 = this$0.onItemDelAction;
        if (function2 != null) {
            String str = personItem.uin;
            Intrinsics.checkNotNullExpressionValue(str, "personItem.uin");
            function2.invoke(str, AddContactDataType.PERSON);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void d0(Context context, MayKnowRecommend item, MayknowRecommendManager mayKnowManager) {
        String displayName = item.getDisplayName();
        Intrinsics.checkNotNullExpressionValue(displayName, "item.getDisplayName()");
        Intent startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(context, 1, item.uin, (String) null, 3045, 52, displayName, (String) null, (String) null, context.getString(R.string.f170028dd), (String) null, item.getToken());
        startAddFriend.putExtra("key_param_age_area", ProfileCardUtil.Z(context, item.gender, item.age, item.country, item.province, item.city));
        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(context, startAddFriend);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void q0(Context context, MayKnowRecommend item, int position, MayknowRecommendManager mayKnowManager) {
        boolean z16;
        String str;
        boolean z17;
        boolean z18;
        AllInOne allInOne = new AllInOne(item.uin, 83);
        String recommendName = item.getRecommendName();
        if (recommendName != null) {
            if (recommendName.length() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                z16 = true;
                if (z16) {
                    allInOne.recommendName = recommendName;
                }
                str = item.nick;
                Intrinsics.checkNotNullExpressionValue(str, "item.nick");
                if (str.length() <= 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    allInOne.nickname = item.nick;
                }
                allInOne.profileEntryType = 88;
                Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("recommend_reason", item.recommendReason), TuplesKt.to("recommend_pos", Integer.valueOf(position)), TuplesKt.to("recommend_algh_id", item.algBuffer));
                allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 3);
                allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 34);
                ProfileActivity.J2(context, allInOne, bundleOf);
            }
        }
        z16 = false;
        if (z16) {
        }
        str = item.nick;
        Intrinsics.checkNotNullExpressionValue(str, "item.nick");
        if (str.length() <= 0) {
        }
        if (z17) {
        }
        allInOne.profileEntryType = 88;
        Bundle bundleOf2 = BundleKt.bundleOf(TuplesKt.to("recommend_reason", item.recommendReason), TuplesKt.to("recommend_pos", Integer.valueOf(position)), TuplesKt.to("recommend_algh_id", item.algBuffer));
        allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 3);
        allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 34);
        ProfileActivity.J2(context, allInOne, bundleOf2);
    }

    private final void r0(Context context, QeventPB$Feed flockData) {
        IFlockLauncher iFlockLauncher = (IFlockLauncher) QRoute.api(IFlockLauncher.class);
        String str = flockData.publisher.f436060id.get();
        String str2 = flockData.f436058id.get();
        Intrinsics.checkNotNullExpressionValue(str2, "flockData.id.get()");
        iFlockLauncher.launchFeedDetailPage(context, str, str2, flockData.create_time.get(), flockData.group_id.get(), null, 1006, 1);
    }

    private final void s0(String coverUrl, Drawable defaultAvatar) {
        boolean z16;
        if (coverUrl.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.roundAvatarView.setImageDrawable(defaultAvatar);
            return;
        }
        try {
            int c16 = x.c(this.roundAvatarView.getContext(), 58.0f);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestHeight = c16;
            obtain.mRequestWidth = c16;
            obtain.mLoadingDrawable = defaultAvatar;
            obtain.mFailedDrawable = defaultAvatar;
            URLDrawable drawable = URLDrawable.getDrawable(coverUrl, obtain);
            if (drawable != null && 1 != drawable.getStatus()) {
                drawable.restartDownload();
            }
            this.roundAvatarView.setImageDrawable(drawable);
        } catch (IllegalArgumentException unused) {
            QLog.e("AddContactListAdapterV2", 1, "illegal url: " + coverUrl);
            this.roundAvatarView.setImageDrawable(defaultAvatar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z() {
        VideoReport.traverseExposure();
    }

    @SuppressLint({"SimpleDateFormat"})
    private final String z0(long tsInMs) {
        String format = new SimpleDateFormat("MM.dd HH:mm").format(new Date(tsInMs));
        Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(format).format(Date(tsInMs))");
        return format;
    }

    public final void E(@NotNull final QeventPB$Feed flockData, @NotNull Drawable defaultAvatar, @NotNull Bitmap defaultPublisherAvatar) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, flockData, defaultAvatar, defaultPublisherAvatar);
            return;
        }
        Intrinsics.checkNotNullParameter(flockData, "flockData");
        Intrinsics.checkNotNullParameter(defaultAvatar, "defaultAvatar");
        Intrinsics.checkNotNullParameter(defaultPublisherAvatar, "defaultPublisherAvatar");
        this.titleView.setText(flockData.title.get());
        this.titleView.setContentDescription(flockData.title.get());
        String coverUrl = flockData.cover_url.get();
        Intrinsics.checkNotNullExpressionValue(coverUrl, "coverUrl");
        s0(coverUrl, defaultAvatar);
        ArrayList arrayList = new ArrayList();
        QeventPB$PoiInfo qeventPB$PoiInfo = flockData.poi_info.get();
        if (qeventPB$PoiInfo != null) {
            String str = qeventPB$PoiInfo.name.get();
            Intrinsics.checkNotNullExpressionValue(str, "poiInfo.name.get()");
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                String str2 = qeventPB$PoiInfo.name.get();
                Intrinsics.checkNotNullExpressionValue(str2, "poiInfo.name.get()");
                arrayList.add(new com.tencent.mobileqq.troop.widget.labelv2.model.b(str2, 10));
            }
        }
        QeventPB$ActivityTime qeventPB$ActivityTime = flockData.activity_time.get();
        if (qeventPB$ActivityTime != null && qeventPB$ActivityTime.start_time.get() > 0) {
            arrayList.add(new com.tencent.mobileqq.troop.widget.labelv2.model.b(z0(qeventPB$ActivityTime.start_time.get() * 1000), 9));
        }
        this.labelLayout.d(arrayList);
        this.reasonView.setVisibility(8);
        B(flockData, defaultPublisherAvatar);
        this.operateBtn.setVisibility(0);
        this.operateText.setVisibility(8);
        this.operateBtn.setText(R.string.yk5);
        A(flockData);
        final Context context = this.operateBtn.getContext();
        this.operateBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.viewholder.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.H(QeventPB$Feed.this, context, view);
            }
        });
        this.contentLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.viewholder.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.I(o.this, flockData, view);
            }
        });
        this.delText.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.viewholder.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.J(o.this, flockData, view);
            }
        });
    }

    public final void P(@NotNull com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c curData, @NotNull Drawable cacheAvatar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) curData, (Object) cacheAvatar);
            return;
        }
        Intrinsics.checkNotNullParameter(curData, "curData");
        Intrinsics.checkNotNullParameter(cacheAvatar, "cacheAvatar");
        RecommendTroopItem f16 = curData.f();
        if (f16 == null) {
            return;
        }
        this.avatarView.setImageDrawable(cacheAvatar);
        O(f16);
        K(f16);
        C(curData.d());
    }

    public final void W(@NotNull RecommendTroopItem troopItem, @NotNull Drawable cacheAvatar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) troopItem, (Object) cacheAvatar);
            return;
        }
        Intrinsics.checkNotNullParameter(troopItem, "troopItem");
        Intrinsics.checkNotNullParameter(cacheAvatar, "cacheAvatar");
        this.avatarView.setImageDrawable(cacheAvatar);
        O(troopItem);
        Q(troopItem);
    }

    public final void c0(@NotNull com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c data, @NotNull Bitmap cacheAvatar, int position, @NotNull MayknowRecommendManager mayKnowManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, data, cacheAvatar, Integer.valueOf(position), mayKnowManager);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(cacheAvatar, "cacheAvatar");
        Intrinsics.checkNotNullParameter(mayKnowManager, "mayKnowManager");
        this.avatarView.setImageBitmap(cacheAvatar);
        Y(data, position, mayKnowManager);
    }

    @NotNull
    public final String e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.avatarKey;
    }

    @NotNull
    public final ThemeImageView f0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ThemeImageView) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.avatarView;
    }

    @NotNull
    public final RelativeLayout i0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.contentLayout;
    }

    @NotNull
    public final TextView j0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TextView) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.delText;
    }

    @NotNull
    public final String k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.extraAvatarKey;
    }

    @NotNull
    public final LinearLayout m0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LinearLayout) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.extraInfoContainer;
    }

    @NotNull
    public final QUIButton o0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (QUIButton) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.operateBtn;
    }

    @NotNull
    public final TextView p0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TextView) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.operateText;
    }

    public final void w0(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.avatarKey = str;
        }
    }

    public final void x0(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.extraAvatarKey = str;
        }
    }

    public final void y0(@Nullable Function2<? super String, ? super AddContactDataType, Unit> function2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) function2);
        } else {
            this.onItemDelAction = function2;
        }
    }
}
