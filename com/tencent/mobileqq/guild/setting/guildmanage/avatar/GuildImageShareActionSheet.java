package com.tencent.mobileqq.guild.setting.guildmanage.avatar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.libra.LibraPicLoader;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.temp.api.IGuildPhotoUtilsApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqforward.api.IForwardOption;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.sharepanel.n;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.QQToastUtil;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\b*\u0002,0\u0018\u0000 62\u00020\u0001:\u0001!B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010#\u001a\u00020\u000f\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\f\u0010\t\u001a\u00020\u0002*\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\nH\u0002J(\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J$\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000f2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00020\u0016H\u0002J\u001c\u0010\u0019\u001a\u00020\u00022\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00020\u0016H\u0002J$\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000f2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0002J\u0006\u0010 \u001a\u00020\u0002R\u0014\u0010#\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/avatar/GuildImageShareActionSheet;", "", "", "E", UserInfo.SEX_FEMALE, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "r", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "sheetItem", "B", "", "url", "localPath", "u", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "imageUrl", "Lkotlin/Function1;", "block", "t", BdhLogUtil.LogTag.Tag_Conn, "v", "p", "dstPath", "Landroid/content/Intent;", "o", DomainData.DOMAIN_NAME, "D", "a", "Ljava/lang/String;", "shareImageUrl", "Ljava/lang/ref/WeakReference;", "b", "Ljava/lang/ref/WeakReference;", "activityRef", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$c;", "c", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$c;", "clickListener", "com/tencent/mobileqq/guild/setting/guildmanage/avatar/GuildImageShareActionSheet$forwardHandler$1", "d", "Lcom/tencent/mobileqq/guild/setting/guildmanage/avatar/GuildImageShareActionSheet$forwardHandler$1;", "forwardHandler", "com/tencent/mobileqq/guild/setting/guildmanage/avatar/GuildImageShareActionSheet$panelClickListener$1", "e", "Lcom/tencent/mobileqq/guild/setting/guildmanage/avatar/GuildImageShareActionSheet$panelClickListener$1;", "panelClickListener", "<init>", "(Landroid/app/Activity;Ljava/lang/String;)V", "f", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildImageShareActionSheet {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String shareImageUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<Activity> activityRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ShareActionSheet.c clickListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildImageShareActionSheet$forwardHandler$1 forwardHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildImageShareActionSheet$panelClickListener$1 panelClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/avatar/GuildImageShareActionSheet$b", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1<String, Unit> f233668e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f233669f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super String, Unit> function1, String str) {
            super(true);
            this.f233668e = function1;
            this.f233669f = str;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@NotNull LoadState state, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            Logger logger = Logger.f235387a;
            String str = this.f233669f;
            logger.d().i("GuildImageShareActionSheet", 1, "onStateChangeCallback  state = " + state + " url:" + str);
            if (state == LoadState.STATE_SUCCESS) {
                String localPath = com.tencent.mobileqq.guild.picload.e.a().c(option);
                Function1<String, Unit> function1 = this.f233668e;
                Intrinsics.checkNotNullExpressionValue(localPath, "localPath");
                function1.invoke(localPath);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/avatar/GuildImageShareActionSheet$c", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends QQPermission.BasePermissionsListener {
        c() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            GuildImageShareActionSheet.this.z();
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.tencent.mobileqq.guild.setting.guildmanage.avatar.GuildImageShareActionSheet$forwardHandler$1] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.tencent.mobileqq.guild.setting.guildmanage.avatar.GuildImageShareActionSheet$panelClickListener$1] */
    public GuildImageShareActionSheet(@NotNull Activity activity, @NotNull String shareImageUrl) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareImageUrl, "shareImageUrl");
        this.shareImageUrl = shareImageUrl;
        this.activityRef = new WeakReference<>(activity);
        this.clickListener = new ShareActionSheet.c() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.avatar.a
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.c
            public final void w6(View view, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
                GuildImageShareActionSheet.m(GuildImageShareActionSheet.this, view, actionSheetItem, shareActionSheet);
            }
        };
        this.forwardHandler = new n() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.avatar.GuildImageShareActionSheet$forwardHandler$1
            @Override // com.tencent.mobileqq.sharepanel.n
            public void a(@NotNull ArrayList<ResultRecord> targetList, @NotNull final com.tencent.mobileqq.sharepanel.m callback) {
                Intrinsics.checkNotNullParameter(targetList, "targetList");
                Intrinsics.checkNotNullParameter(callback, "callback");
                final GuildImageShareActionSheet guildImageShareActionSheet = GuildImageShareActionSheet.this;
                guildImageShareActionSheet.C(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.avatar.GuildImageShareActionSheet$forwardHandler$1$prepareForwardData$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull String it) {
                        Intent o16;
                        Intrinsics.checkNotNullParameter(it, "it");
                        o16 = GuildImageShareActionSheet.this.o(it);
                        callback.a(o16);
                    }
                });
            }
        };
        this.panelClickListener = new com.tencent.mobileqq.sharepanel.j() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.avatar.GuildImageShareActionSheet$panelClickListener$1
            @Override // com.tencent.mobileqq.sharepanel.j
            public void a(@NotNull String channelId) {
                Intrinsics.checkNotNullParameter(channelId, "channelId");
                Logger.f235387a.d().i("GuildImageShareActionSheet", 1, "onShareChannelClick channelId:" + channelId);
                if (Intrinsics.areEqual(channelId, "qqfriend")) {
                    final GuildImageShareActionSheet guildImageShareActionSheet = GuildImageShareActionSheet.this;
                    guildImageShareActionSheet.C(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.avatar.GuildImageShareActionSheet$panelClickListener$1$onShareChannelClick$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(String str) {
                            invoke2(str);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull String it) {
                            Activity n3;
                            Intent o16;
                            Intrinsics.checkNotNullParameter(it, "it");
                            n3 = GuildImageShareActionSheet.this.n();
                            if (n3 == null) {
                                return;
                            }
                            IForwardOption iForwardOption = (IForwardOption) QRoute.api(IForwardOption.class);
                            o16 = GuildImageShareActionSheet.this.o(it);
                            iForwardOption.startForwardActivityForResult(n3, o16, 21);
                        }
                    });
                } else if (Intrinsics.areEqual(channelId, "qqchannel")) {
                    final GuildImageShareActionSheet guildImageShareActionSheet2 = GuildImageShareActionSheet.this;
                    guildImageShareActionSheet2.C(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.avatar.GuildImageShareActionSheet$panelClickListener$1$onShareChannelClick$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(String str) {
                            invoke2(str);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull String it) {
                            Activity n3;
                            Intent o16;
                            Intrinsics.checkNotNullParameter(it, "it");
                            n3 = GuildImageShareActionSheet.this.n();
                            if (n3 == null) {
                                return;
                            }
                            IGuildFeatureAdapterApi iGuildFeatureAdapterApi = (IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class);
                            o16 = GuildImageShareActionSheet.this.o(it);
                            iGuildFeatureAdapterApi.startQQGuildForwardGuildListFragment(n3, o16, 20000);
                        }
                    });
                }
            }

            @Override // com.tencent.mobileqq.sharepanel.j
            public void b(@NotNull String actionId) {
                Intrinsics.checkNotNullParameter(actionId, "actionId");
                Logger.f235387a.d().i("GuildImageShareActionSheet", 1, "onAppendActionClick actionId:" + actionId);
                if (Intrinsics.areEqual(actionId, "save_to_phone")) {
                    GuildImageShareActionSheet.this.A();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        Activity n3 = n();
        if (n3 == null) {
            return;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(n3, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_CHANNEL_MAINFRAME, QQPermissionConstants.Business.SCENE.QQCHANEL_GUILD_AVATAR));
        if (qQPermission == null) {
            QQToastUtil.showQQToast(1, R.string.f155091gk);
        } else if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new c());
        } else {
            z();
        }
    }

    private final void B(final ShareActionSheetBuilder.ActionSheetItem sheetItem) {
        t(this.shareImageUrl, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.avatar.GuildImageShareActionSheet$shareToQQOrChannelByPic$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
            
                r0 = r4.this$0.n();
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(@NotNull String it) {
                Activity n3;
                String str;
                Intrinsics.checkNotNullParameter(it, "it");
                if ((it.length() == 0) || n3 == null) {
                    return;
                }
                GuildImageShareActionSheet guildImageShareActionSheet = GuildImageShareActionSheet.this;
                str = guildImageShareActionSheet.shareImageUrl;
                guildImageShareActionSheet.u(n3, str, it, sheetItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(final Function1<? super String, Unit> block) {
        t(this.shareImageUrl, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.avatar.GuildImageShareActionSheet$shareToQQOrChannelByPic$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                GuildImageShareActionSheet.this.v(it, block);
            }
        });
    }

    private final void E() {
        Activity n3 = n();
        if (!(n3 instanceof FragmentActivity)) {
            return;
        }
        com.tencent.mobileqq.sharepanel.f createSharePanel = ((ISharePanelApi) QRoute.api(ISharePanelApi.class)).createSharePanel((FragmentActivity) n3, "pindao_feedcomment");
        createSharePanel.k0(this.forwardHandler);
        createSharePanel.t0(this.panelClickListener);
        createSharePanel.m0(false);
        createSharePanel.c0("save_to_phone", true);
        createSharePanel.show();
    }

    private final void F() {
        Activity activity = this.activityRef.get();
        if (activity == null) {
            return;
        }
        ShareActionSheet r16 = r(activity);
        r16.setItemClickListenerV3(this.clickListener);
        r16.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(GuildImageShareActionSheet this$0, View view, ShareActionSheetBuilder.ActionSheetItem item, ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        shareActionSheet.dismiss();
        Intrinsics.checkNotNullExpressionValue(item, "item");
        this$0.q(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Activity n() {
        Activity activity = this.activityRef.get();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            return activity;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        bVar.a().add("getActivity() activity is null");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("GuildImageShareActionSheet", 1, (String) it.next(), null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Intent o(String dstPath) {
        Intent intent = new Intent();
        intent.putExtra("forward_type", 1);
        intent.putExtra(AppConstants.Key.FORWARD_FILEPATH, dstPath);
        intent.putExtra(AppConstants.Key.FORWARD_THUMB, dstPath);
        intent.putExtra(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        intent.putExtra(AppConstants.Key.FORWARD_USE_BOTTOM_SHEET_PREVIEW, true);
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
        return intent;
    }

    private final String p(String localPath) {
        boolean endsWith$default;
        String replace$default;
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(localPath, LibraPicLoader.PIC_LOCAL_PATH_END_SUFFIX, false, 2, null);
        if (endsWith$default) {
            replace$default = StringsKt__StringsJVMKt.replace$default(localPath, LibraPicLoader.PIC_LOCAL_PATH_END_SUFFIX, ".jpg", false, 4, (Object) null);
            return replace$default;
        }
        return localPath;
    }

    private final void q(ShareActionSheetBuilder.ActionSheetItem item) {
        int i3 = item.action;
        if (i3 != 2 && i3 != 26) {
            if (i3 != 39) {
                if (i3 != 171 && i3 != 72 && i3 != 73) {
                    return;
                }
            } else {
                A();
                return;
            }
        }
        B(item);
    }

    private final ShareActionSheet r(Activity activity) {
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = activity;
        activity.getIntent().putExtra("big_brother_source_key", "biz_src_jc_qqstation");
        ShareActionSheet initOldActionSheet$lambda$0 = ShareActionSheetFactory.create(param);
        Intrinsics.checkNotNullExpressionValue(initOldActionSheet$lambda$0, "initOldActionSheet$lambda$0");
        s(initOldActionSheet$lambda$0);
        Intrinsics.checkNotNullExpressionValue(initOldActionSheet$lambda$0, "create(param).apply {\n  \u2026hAndOperation()\n        }");
        return initOldActionSheet$lambda$0;
    }

    private final void s(ShareActionSheet shareActionSheet) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(171));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(39));
        shareActionSheet.setActionSheetItems(arrayList, arrayList2);
        shareActionSheet.setRowVisibility(0, 0, 0);
        shareActionSheet.setIntentForStartForwardRecentActivity(new Intent());
    }

    private final void t(String imageUrl, Function1<? super String, Unit> block) {
        com.tencent.mobileqq.guild.picload.e.a().f(Option.obtain().setUrl(imageUrl), new b(block, imageUrl));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(final Activity activity, final String url, final String localPath, final ShareActionSheetBuilder.ActionSheetItem sheetItem) {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.avatar.c
            @Override // java.lang.Runnable
            public final void run() {
                GuildImageShareActionSheet.w(localPath, this, sheetItem, url, activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(final String localPath, final Function1<? super String, Unit> block) {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.avatar.b
            @Override // java.lang.Runnable
            public final void run() {
                GuildImageShareActionSheet.x(localPath, this, block);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(String localPath, GuildImageShareActionSheet this$0, ShareActionSheetBuilder.ActionSheetItem sheetItem, String url, Activity activity) {
        Intrinsics.checkNotNullParameter(localPath, "$localPath");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sheetItem, "$sheetItem");
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        if (TextUtils.isEmpty(localPath)) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("picFileShare  localPath == null");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildImageShareActionSheet", 1, (String) it.next(), null);
            }
            return;
        }
        String p16 = this$0.p(localPath);
        boolean copyFile = FileUtils.copyFile(localPath, p16);
        Logger.f235387a.d().i("GuildImageShareActionSheet", 1, "picFileShare  copyFile  result = " + copyFile);
        File file = new File(p16);
        Bundle bundle = new Bundle();
        bundle.putBoolean(AppConstants.Key.FORWARD_URLDRAWABLE, false);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_THUMB_URL, p16);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, p16);
        AIOPictureData aIOPictureData = new AIOPictureData();
        aIOPictureData.friendUin = sheetItem.uin;
        aIOPictureData.largeImageFile = p16;
        aIOPictureData.originImageFile = p16;
        aIOPictureData.picServerUrl = url;
        aIOPictureData.thumbImageFile = p16;
        if (sheetItem.action == 171) {
            ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).forwardToChannel(file, false, aIOPictureData, bundle, activity, sheetItem.action, ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getSharePanelType(), "biz_src_jc_photo");
        } else {
            ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).forwardPicToFriend(file, false, aIOPictureData, bundle, activity, sheetItem.action, sheetItem.uin, sheetItem.uinType, ((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getSharePanelType(), "biz_src_jc_photo");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(String localPath, GuildImageShareActionSheet this$0, final Function1 block) {
        Intrinsics.checkNotNullParameter(localPath, "$localPath");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(block, "$block");
        if (TextUtils.isEmpty(localPath)) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("picFileShare  localPath == null");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildImageShareActionSheet", 1, (String) it.next(), null);
            }
            return;
        }
        final String p16 = this$0.p(localPath);
        boolean copyFile = FileUtils.copyFile(localPath, p16);
        Logger.f235387a.d().i("GuildImageShareActionSheet", 1, "picFileShare  copyFile  result = " + copyFile);
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.avatar.d
            @Override // java.lang.Runnable
            public final void run() {
                GuildImageShareActionSheet.y(Function1.this, p16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(Function1 block, String dstPath) {
        Intrinsics.checkNotNullParameter(block, "$block");
        Intrinsics.checkNotNullParameter(dstPath, "$dstPath");
        block.invoke(dstPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        t(this.shareImageUrl, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.avatar.GuildImageShareActionSheet$savePic$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
            
                r0 = r2.this$0.n();
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(@NotNull String it) {
                Activity n3;
                Intrinsics.checkNotNullParameter(it, "it");
                if ((it.length() == 0) || n3 == null) {
                    return;
                }
                ((IGuildPhotoUtilsApi) QRoute.api(IGuildPhotoUtilsApi.class)).savePic(it, n3);
            }
        });
    }

    public final void D() {
        if (((ISharePanelApi) QRoute.api(ISharePanelApi.class)).useNewSharePanel("pindao_feedcomment")) {
            E();
        } else {
            F();
        }
    }
}
