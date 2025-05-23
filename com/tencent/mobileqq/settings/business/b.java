package com.tencent.mobileqq.settings.business;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.avbiz.Constants;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.settings.business.b;
import com.tencent.mobileqq.settings.message.TempMsg.TempMsgSettingFragment;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0003-.\u0011B\u000f\u0012\u0006\u0010)\u001a\u00020(\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R \u0010\u0019\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R \u0010\u001b\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b \u0010!R$\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00020#j\b\u0012\u0004\u0012\u00020\u0002`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/settings/business/b;", "Lcom/tencent/mobileqq/activity/newsetting/custom/group/a;", "Lcom/tencent/mobileqq/settings/business/b$c;", DownloadInfo.spKey_Config, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "switchId", "", "isChecked", "p", "o", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/settings/business/f;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "l", "Lcom/tencent/mobileqq/widget/listitem/Group;", "c", "", "e", "I", "iconColorValue", "Lcom/tencent/mobileqq/activity/newsetting/custom/config/b;", "f", "Lcom/tencent/mobileqq/activity/newsetting/custom/config/b;", "mGroupMsgLayoutConfig", "g", "mTempMsgSettingConfig", "Lcom/tencent/mobileqq/app/activateFriends/ActivateFriendsManager;", h.F, "Lcom/tencent/mobileqq/app/activateFriends/ActivateFriendsManager;", "mActivateManager", "i", "Ljava/lang/String;", "PAGE_ID", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "j", "Ljava/util/ArrayList;", VideoTemplateParser.ITEM_LIST, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "k", "a", "b", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b extends com.tencent.mobileqq.activity.newsetting.custom.group.a {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int iconColorValue;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b<?, ?> mGroupMsgLayoutConfig;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b<?, ?> mTempMsgSettingConfig;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ActivateFriendsManager mActivateManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final String PAGE_ID;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<c> itemList;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0002J*\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0002R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/settings/business/b$a;", "", "", "url", "", "d", "Lcom/tencent/image/URLDrawable;", "", "color", "", "e", "Landroid/content/Context;", "context", "token", CustomAnimation.KeyPath.COLOR_FILTER, "Landroid/graphics/drawable/Drawable;", "b", "c", "DT_PAGE_ID", "Ljava/lang/String;", "DT_PARAM_SCENE_ID", "TAG", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.settings.business.b$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Drawable b(Context context, String token, String url, int colorFilter) {
            if (token.length() > 0) {
                int c16 = c(context, token);
                if (c16 != 0) {
                    try {
                        return ResourcesCompat.getDrawable(context.getResources(), c16, null);
                    } catch (Exception e16) {
                        QLog.w("GrowthPushSwitch.Group", 1, "[getIconDrawable] token:" + token + " error: " + e16);
                    }
                } else {
                    QLog.w("GrowthPushSwitch.Group", 1, "[getIconDrawable] invalid token, token=" + token);
                }
            }
            if (url.length() > 0) {
                try {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mUseApngImage = true;
                    obtain.mLoadingDrawable = new ColorDrawable(0);
                    obtain.mFailedDrawable = new ColorDrawable(0);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(ApngImage.KEY_USE_FILE_LOOP, true);
                    obtain.mExtraInfo = bundle;
                    URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
                    Companion companion = b.INSTANCE;
                    if (companion.d(url)) {
                        Intrinsics.checkNotNullExpressionValue(drawable, "this");
                        companion.e(drawable, colorFilter);
                    }
                    return drawable;
                } catch (Exception e17) {
                    QLog.w("GrowthPushSwitch.Group", 1, "[getIconDrawable] get url drawable failed, url:" + url + " error: " + e17);
                }
            }
            QLog.w("GrowthPushSwitch.Group", 1, "[getIconDrawable] invalid icon, token=" + token + " url=" + url);
            return ResourcesCompat.getDrawable(context.getResources(), R.drawable.qui_setting, null);
        }

        private final int c(Context context, String token) {
            int identifier = context.getResources().getIdentifier(token, "drawable", context.getPackageName());
            if (identifier != 0) {
                return identifier;
            }
            int identifier2 = context.getResources().getIdentifier("qui_" + token, "drawable", context.getPackageName());
            if (identifier2 != 0) {
                return identifier2;
            }
            int identifier3 = context.getResources().getIdentifier("qui_common_" + token, "drawable", context.getPackageName());
            if (identifier3 != 0) {
                return identifier3;
            }
            return 0;
        }

        private final void e(URLDrawable url, int color) {
            url.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP));
        }

        Companion() {
        }

        private final boolean d(String url) {
            if (url == null || url.length() == 0) {
                return true;
            }
            try {
                String queryParameter = Uri.parse(url).getQueryParameter(CustomAnimation.KeyPath.COLOR_FILTER);
                if (queryParameter != null) {
                    if (Intrinsics.areEqual(queryParameter, "0")) {
                        return false;
                    }
                    return !Intrinsics.areEqual(queryParameter, "false");
                }
            } catch (Exception e16) {
                QLog.i("GrowthPushSwitch.Group", 1, "[isIconColorFilterEnabled] url=" + url + " exc=" + e16);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B'\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J$\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fH\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/settings/business/b$c;", "Lcom/tencent/mobileqq/activity/newsetting/custom/config/b;", "Lcom/tencent/mobileqq/widget/listitem/x$b;", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "Lcom/tencent/mobileqq/settings/business/f;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "k0", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "view", "", "position", "", "payloads", "P", "w", "Lcom/tencent/mobileqq/settings/business/f;", "getItem", "()Lcom/tencent/mobileqq/settings/business/f;", "Landroid/content/Context;", "context", "iconColorFilter", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/settings/business/f;ILcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b, x.c> {

        /* renamed from: w, reason: collision with root package name and from kotlin metadata */
        private final f item;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public c(Context context, f item, int i3, QUIListItemAdapter adapter) {
            super(r0, r10, adapter);
            x.c gVar;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            x.b.C8996b c8996b = new x.b.C8996b(item.f(), 0);
            c8996b.e(b.INSTANCE.b(context, item.a(), item.b(), i3));
            if (item.e()) {
                gVar = new x.c.f(false, null, 2, null);
            } else {
                gVar = new x.c.g("", false, false, 6, null);
            }
            this.item = item;
        }

        private final void k0(final f item) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.settings.business.d
                @Override // java.lang.Runnable
                public final void run() {
                    b.c.l0(f.this);
                }
            }, 16, null, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l0(f item) {
            Intrinsics.checkNotNullParameter(item, "$item");
            HashMap hashMap = new HashMap();
            hashMap.put("SceneID", item.d());
            Unit unit = Unit.INSTANCE;
            com.tencent.qqnt.notification.report.h.C("pg_bas_message_notification", "em_bas_service_notification_entry", null, null, hashMap);
            if (QLog.isDevelopLevel()) {
                QLog.d("GrowthPushSwitch.Group", 4, "[reportExposure] item:" + item);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.widget.listitem.x, com.tencent.mobileqq.widget.listitem.w
        /* renamed from: P */
        public void F(QUISingleLineListItem view, int position, List<?> payloads) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            super.F(view, position, payloads);
            k0(this.item);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.iconColorValue = context.getResources().getColor(R.color.qui_common_text_primary, null);
        this.PAGE_ID = "pg_bas_message_notification";
        this.itemList = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(e config, b this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(config, "$config");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("GrowthPushSwitch.Group", 1, "[buildGroup] title=" + config.b() + " items=" + config.a());
        ActivateFriendsManager activateFriendsManager = this$0.mActivateManager;
        if (activateFriendsManager != null) {
            Intrinsics.checkNotNull(activateFriendsManager);
            activateFriendsManager.L(z16, true);
        }
        this$0.n("em_bas_remind_friends_birthday", z16);
    }

    private final c l(f item) {
        Context context = e();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int i3 = this.iconColorValue;
        QUIListItemAdapter quiListItemAdapter = f();
        Intrinsics.checkNotNullExpressionValue(quiListItemAdapter, "quiListItemAdapter");
        c cVar = new c(context, item, i3, quiListItemAdapter);
        cVar.x(new ItemOnClickListener(item, cVar));
        return cVar;
    }

    private final void m(c config) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager");
        ActivateFriendsManager activateFriendsManager = (ActivateFriendsManager) manager;
        this.mActivateManager = activateFriendsManager;
        if (activateFriendsManager != null) {
            Intrinsics.checkNotNull(activateFriendsManager);
            config.a0(activateFriendsManager.t(true));
        }
    }

    private final void n(String switchId, boolean isChecked) {
        com.tencent.qqnt.notification.report.h.z(this.PAGE_ID, switchId, Boolean.valueOf(isChecked), null, null, 24, null);
    }

    private final void o(String switchId) {
        com.tencent.qqnt.notification.report.h.D(this.PAGE_ID, switchId, null, null, null, 24, null);
    }

    private final void p(String switchId, boolean isChecked) {
        com.tencent.qqnt.notification.report.h.D(this.PAGE_ID, switchId, Boolean.valueOf(isChecked), null, null, 24, null);
    }

    @Override // com.tencent.mobileqq.activity.newsetting.custom.group.a
    protected Group c() {
        final e a16 = e.INSTANCE.a();
        QLog.i("GrowthPushSwitch.Group", 1, "[buildGroup] title=" + a16.b() + " items=" + a16.a());
        f fVar = new f("", "QQ\u63d0\u9192\u597d\u53cb\u751f\u65e5", "qui_cake", "", "", true);
        f fVar2 = new f("", "\u7fa4\u6d88\u606f\u901a\u77e5\u7ba1\u7406", "qui_group", "", "group_msg_notify", false);
        f fVar3 = new f("", "\u4e34\u65f6\u4f1a\u8bdd", "qui_message_record", "", "temp_aio_notify", false);
        c l3 = l(fVar);
        m(l3);
        p("em_bas_remind_friends_birthday", l3.W());
        o("em_bas_temporary_session_setup");
        o("em_bas_group_message_setup");
        l3.e0(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.settings.business.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                b.k(e.this, this, compoundButton, z16);
            }
        });
        this.mGroupMsgLayoutConfig = l(fVar2);
        this.mTempMsgSettingConfig = l(fVar3);
        this.itemList.add(l3);
        ArrayList<c> arrayList = this.itemList;
        com.tencent.mobileqq.activity.newsetting.custom.config.b<?, ?> bVar = this.mGroupMsgLayoutConfig;
        Intrinsics.checkNotNull(bVar, "null cannot be cast to non-null type com.tencent.mobileqq.settings.business.GrowthPushSettingGroup.MySingleLineConfig");
        arrayList.add((c) bVar);
        ArrayList<c> arrayList2 = this.itemList;
        com.tencent.mobileqq.activity.newsetting.custom.config.b<?, ?> bVar2 = this.mTempMsgSettingConfig;
        Intrinsics.checkNotNull(bVar2, "null cannot be cast to non-null type com.tencent.mobileqq.settings.business.GrowthPushSettingGroup.MySingleLineConfig");
        arrayList2.add((c) bVar2);
        if (a16.a().isEmpty()) {
            Object[] array = this.itemList.toArray(new c[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            c[] cVarArr = (c[]) array;
            return new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(cVarArr, cVarArr.length));
        }
        for (f fVar4 : a16.a()) {
            if (!Constants.Business.QQCIRCLE.equals(fVar4.f())) {
                this.itemList.add(l(fVar4));
            }
        }
        if (a16.b().length() == 0) {
            Object[] array2 = this.itemList.toArray(new c[0]);
            Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            c[] cVarArr2 = (c[]) array2;
            return new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(cVarArr2, cVarArr2.length));
        }
        Object[] array3 = this.itemList.toArray(new c[0]);
        Intrinsics.checkNotNull(array3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        c[] cVarArr3 = (c[]) array3;
        return new Group("\u901a\u77e5\u5185\u5bb9", (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(cVarArr3, cVarArr3.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00d6\u0003R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/settings/business/b$b;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/settings/business/f;", "d", "Lcom/tencent/mobileqq/settings/business/f;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/settings/business/b$c;", "e", "Lcom/tencent/mobileqq/settings/business/b$c;", DownloadInfo.spKey_Config, "<init>", "(Lcom/tencent/mobileqq/settings/business/f;Lcom/tencent/mobileqq/settings/business/b$c;)V", "f", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.settings.business.b$b, reason: collision with other inner class name and from toString */
    /* loaded from: classes35.dex */
    public static final /* data */ class ItemOnClickListener implements View.OnClickListener {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final f item;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final c config;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0003J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/settings/business/b$b$a;", "", "Landroid/content/Context;", "context", "", WadlProxyConsts.KEY_JUMP_URL, "", "d", "url", "", "e", WadlProxyConsts.SCENE_ID, "f", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.settings.business.b$b$a, reason: from kotlin metadata */
        /* loaded from: classes35.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void d(Context context, String jumpUrl) {
                if (jumpUrl.length() == 0) {
                    return;
                }
                if (jumpUrl.equals("group_msg_notify")) {
                    context.startActivity(new Intent(context, (Class<?>) TroopAssisSettingActivity.class));
                    com.tencent.qqnt.notification.report.h.z("pg_bas_message_notification", "em_bas_group_message_setup", null, null, null, 24, null);
                    return;
                }
                if (jumpUrl.equals("temp_aio_notify")) {
                    QPublicFragmentActivity.start(context, new Intent(), TempMsgSettingFragment.class);
                    com.tencent.qqnt.notification.report.h.z("pg_bas_message_notification", "em_bas_temporary_session_setup", null, null, null, 24, null);
                    return;
                }
                if (e(jumpUrl)) {
                    Intent intent = new Intent();
                    intent.putExtra("url", jumpUrl);
                    RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
                    QLog.i("GrowthPushSwitch.Group", 1, "[doJumpAction] jump to h5, url=" + jumpUrl);
                    return;
                }
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                Unit unit = null;
                BaseQQAppInterface baseQQAppInterface = peekAppRuntime instanceof BaseQQAppInterface ? (BaseQQAppInterface) peekAppRuntime : null;
                if (baseQQAppInterface != null) {
                    try {
                        ax c16 = bi.c(baseQQAppInterface, context, jumpUrl);
                        if (c16 != null) {
                            Intrinsics.checkNotNullExpressionValue(c16, "parser(app, context, jumpUrl)");
                            c16.b();
                            QLog.i("GrowthPushSwitch.Group", 1, "[doJumpAction] jump to native, jumpUrl=" + jumpUrl);
                            unit = Unit.INSTANCE;
                        }
                        if (unit == null) {
                            QLog.w("GrowthPushSwitch.Group", 1, "[doJumpAction] jump action is null, jumpUrl=" + jumpUrl);
                        }
                    } catch (Exception e16) {
                        QLog.e("GrowthPushSwitch.Group", 1, "[doJumpAction] error: " + e16);
                    }
                }
            }

            private final boolean e(String url) {
                boolean startsWith$default;
                boolean startsWith$default2;
                Locale ROOT = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                Intrinsics.checkNotNullExpressionValue(url.toLowerCase(ROOT), "this as java.lang.String).toLowerCase(locale)");
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "http://", false, 2, null);
                if (!startsWith$default) {
                    startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "https://", false, 2, null);
                    if (!startsWith$default2) {
                        return false;
                    }
                }
                return true;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void f(final String sceneId) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.settings.business.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.ItemOnClickListener.Companion.g(sceneId);
                    }
                }, 16, null, false);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void g(String sceneId) {
                Intrinsics.checkNotNullParameter(sceneId, "$sceneId");
                HashMap hashMap = new HashMap();
                hashMap.put("SceneID", sceneId);
                Unit unit = Unit.INSTANCE;
                com.tencent.qqnt.notification.report.h.y("pg_bas_message_notification", "em_bas_service_notification_entry", null, null, hashMap);
                if (QLog.isDevelopLevel()) {
                    QLog.d("GrowthPushSwitch.Group", 4, "[reportClick] sceneId=" + sceneId);
                }
            }

            Companion() {
            }
        }

        public ItemOnClickListener(f item, c config) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(config, "config");
            this.item = item;
            this.config = config;
        }

        public int hashCode() {
            return (this.item.hashCode() * 31) + this.config.hashCode();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            if (this.item.e() && AppSetting.f99565y) {
                this.config.a0(!r0.W());
            }
            Companion companion = INSTANCE;
            Context context = v3.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "v.context");
            companion.d(context, this.item.c());
            companion.f(this.item.d());
        }

        public String toString() {
            return "ItemOnClickListener(item=" + this.item + ", config=" + this.config + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ItemOnClickListener)) {
                return false;
            }
            ItemOnClickListener itemOnClickListener = (ItemOnClickListener) other;
            return Intrinsics.areEqual(this.item, itemOnClickListener.item) && Intrinsics.areEqual(this.config, itemOnClickListener.config);
        }
    }
}
