package com.tencent.mobileqq.guild;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.adapter.ai;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildContactApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 b2\u00020\u0001:\u0004cdefB7\u0012\u0006\u0010;\u001a\u000207\u0012\u0006\u0010]\u001a\u00020\\\u0012\u0006\u0010@\u001a\u00020<\u0012\u0006\u0010_\u001a\u00020^\u0012\u0006\u0010E\u001a\u00020\u000e\u0012\u0006\u0010K\u001a\u00020F\u00a2\u0006\u0004\b`\u0010aJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J*\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\nH\u0002Jb\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00042\u001a\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u001b2\u001a\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u001b2\u001a\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u001bJ\b\u0010 \u001a\u00020\u0004H\u0016J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010#\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010%\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0016J\u0010\u0010'\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010(\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0016J\b\u0010)\u001a\u00020\u0006H\u0016J,\u0010-\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010\n2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J4\u0010/\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010\n2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u0018\u00100\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0016J\b\u00101\u001a\u00020\u0004H\u0016J\b\u00102\u001a\u00020\u0006H\u0016J\u0018\u00104\u001a\u00020\b2\u0006\u00103\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u00105\u001a\u00020\bJ\u0006\u00106\u001a\u00020\bR\u0017\u0010;\u001a\u0002078\u0006\u00a2\u0006\f\n\u0004\b\u001f\u00108\u001a\u0004\b9\u0010:R\u0017\u0010@\u001a\u00020<8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010=\u001a\u0004\b>\u0010?R\u0017\u0010E\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u0017\u0010K\u001a\u00020F8\u0006\u00a2\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020\u000e0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR0\u0010S\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00120\u001aj\b\u0012\u0004\u0012\u00020\u0012`\u001b0P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR \u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00040P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010RR\u0014\u0010W\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010BR\u0014\u0010Y\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010BR\u0014\u0010[\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010B\u00a8\u0006g"}, d2 = {"Lcom/tencent/mobileqq/guild/GuildListAdapter;", "Lcom/tencent/mobileqq/adapter/ai;", "Lcom/tencent/mobileqq/troop/adapter/contact/a;", "tag", "", "groupPosition", "", "isExpanded", "", DomainData.DOMAIN_NAME, "Landroid/view/View;", "groupView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, tl.h.F, "", "g", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "childView", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "info", "l", "unNotifyIsOpen", "o", "view", "f", "allSize", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "createdGuilds", "managedGuilds", "joinedGuilds", "i", "getGroupCount", "getChildrenCount", "", "getGroup", "childPosition", "getChild", "", "getGroupId", "getChildId", "hasStableIds", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getGroupView", "isLastChild", "getChildView", "isChildSelectable", "getHeaderViewLayoutResourceId", "needHideBackgroundGroup", "header", "configHeaderView", "k", "j", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "getGProService", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getSpExpandKey", "()Ljava/lang/String;", "spExpandKey", "Lcom/tencent/mobileqq/guild/p;", "D", "Lcom/tencent/mobileqq/guild/p;", "getIAdapterCallback", "()Lcom/tencent/mobileqq/guild/p;", "iAdapterCallback", "", "E", "Ljava/util/List;", "guildGroups", "", UserInfo.SEX_FEMALE, "Ljava/util/Map;", "guildChildren", "G", "expandGroupMap", "H", "createdGuildGroup", "I", "managedGuildGroup", "J", "joinedGuildGroup", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/widget/SwipPinnedHeaderExpandableListView;", "lv", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;Lcom/tencent/widget/SwipPinnedHeaderExpandableListView;Ljava/lang/String;Lcom/tencent/mobileqq/guild/p;)V", "K", "a", "b", "c", "SaveExpandRunnable", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class GuildListAdapter extends ai {

    /* renamed from: C, reason: from kotlin metadata */
    private final String spExpandKey;

    /* renamed from: D, reason: from kotlin metadata */
    private final p iAdapterCallback;

    /* renamed from: E, reason: from kotlin metadata */
    private final List<String> guildGroups;

    /* renamed from: F, reason: from kotlin metadata */
    private final Map<String, ArrayList<IGProGuildInfo>> guildChildren;

    /* renamed from: G, reason: from kotlin metadata */
    private final Map<String, Integer> expandGroupMap;

    /* renamed from: H, reason: from kotlin metadata */
    private final String createdGuildGroup;

    /* renamed from: I, reason: from kotlin metadata */
    private final String managedGuildGroup;

    /* renamed from: J, reason: from kotlin metadata */
    private final String joinedGuildGroup;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final IGPSService gProService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0017\u0010\u000f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\n\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/GuildListAdapter$SaveExpandRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "", "d", "I", "allExpandedBit", "", "e", "Ljava/lang/String;", "account", "f", "getSpKey", "()Ljava/lang/String;", "spKey", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class SaveExpandRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int allExpandedBit;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final String account;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final String spKey;

        public SaveExpandRunnable(int i3, String account, String spKey) {
            Intrinsics.checkNotNullParameter(account, "account");
            Intrinsics.checkNotNullParameter(spKey, "spKey");
            this.allExpandedBit = i3;
            this.account = account;
            this.spKey = spKey;
        }

        @Override // java.lang.Runnable
        public void run() {
            SharedPreferences.Editor edit;
            SharedPreferences e16 = com.tencent.relation.common.utils.h.e(BaseApplication.context, this.account);
            if (e16 == null || (edit = e16.edit()) == null) {
                return;
            }
            edit.putInt(this.spKey, this.allExpandedBit).commit();
            QLog.i("GuildListAdapter", 1, "save allExpandedBit: " + this.allExpandedBit);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/GuildListAdapter$a;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/guild/GuildListAdapter;", "d", "Ljava/lang/ref/WeakReference;", "mRef", "adapter", "<init>", "(Lcom/tencent/mobileqq/guild/GuildListAdapter;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<GuildListAdapter> mRef;

        public a(GuildListAdapter adapter) {
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            this.mRef = new WeakReference<>(adapter);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            GuildListAdapter guildListAdapter = this.mRef.get();
            Unit unit = null;
            if (guildListAdapter != null) {
                Object tag = v3.getTag();
                IGProGuildInfo iGProGuildInfo = tag instanceof IGProGuildInfo ? (IGProGuildInfo) tag : null;
                if (iGProGuildInfo != null) {
                    com.tencent.mobileqq.guild.report.b.g("connect_pindao", "GuildListAdapter");
                    IGuildContactApi iGuildContactApi = (IGuildContactApi) QRoute.api(IGuildContactApi.class);
                    String guildID = iGProGuildInfo.getGuildID();
                    Intrinsics.checkNotNullExpressionValue(guildID, "info.guildID");
                    iGuildContactApi.jumpGuildOnFullStandalone(guildID);
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    QLog.i("GuildListAdapter", 1, "child onClick:: tag is not IGProGuildInfo");
                }
            } else {
                guildListAdapter = null;
            }
            if (guildListAdapter == null) {
                QLog.i("GuildListAdapter", 1, "child onClick:: adapter is null");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/GuildListAdapter$c;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/guild/GuildListAdapter;", "d", "Ljava/lang/ref/WeakReference;", "mRef", "adapter", "<init>", "(Lcom/tencent/mobileqq/guild/GuildListAdapter;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<GuildListAdapter> mRef;

        public c(GuildListAdapter adapter) {
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            this.mRef = new WeakReference<>(adapter);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            GuildListAdapter guildListAdapter = this.mRef.get();
            if (guildListAdapter != null) {
                Object tag = v3.getTag();
                com.tencent.mobileqq.troop.adapter.contact.a aVar = tag instanceof com.tencent.mobileqq.troop.adapter.contact.a ? (com.tencent.mobileqq.troop.adapter.contact.a) tag : null;
                if (aVar != null) {
                    if (((ai) guildListAdapter).f187112f.isGroupExpanded(aVar.f293797a)) {
                        ((ai) guildListAdapter).f187112f.collapseGroup(aVar.f293797a);
                    } else {
                        ((ai) guildListAdapter).f187112f.expandGroup(aVar.f293797a);
                    }
                } else {
                    QLog.i("GuildListAdapter", 1, "Group onClick:: tag is not IGProGuildInfo");
                }
            } else {
                guildListAdapter = null;
            }
            if (guildListAdapter == null) {
                QLog.i("GuildListAdapter", 1, "Group onClick:: adapter is null");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildListAdapter(Context context, QQAppInterface app, IGPSService gProService, SwipPinnedHeaderExpandableListView lv5, String spExpandKey, p iAdapterCallback) {
        super(context, app, lv5);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(gProService, "gProService");
        Intrinsics.checkNotNullParameter(lv5, "lv");
        Intrinsics.checkNotNullParameter(spExpandKey, "spExpandKey");
        Intrinsics.checkNotNullParameter(iAdapterCallback, "iAdapterCallback");
        this.context = context;
        this.gProService = gProService;
        this.spExpandKey = spExpandKey;
        this.iAdapterCallback = iAdapterCallback;
        this.guildGroups = new ArrayList();
        this.guildChildren = new LinkedHashMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.expandGroupMap = linkedHashMap;
        String string = context.getString(R.string.f1312003);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026ing.created_guilds_by_me)");
        this.createdGuildGroup = string;
        String string2 = context.getString(R.string.f131420o);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(com.te\u2026ing.managed_guilds_by_me)");
        this.managedGuildGroup = string2;
        String string3 = context.getString(R.string.f131410n);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(com.te\u2026ring.joined_guilds_by_me)");
        this.joinedGuildGroup = string3;
        linkedHashMap.put(string, 1);
        linkedHashMap.put(string2, 2);
        linkedHashMap.put(string3, 4);
    }

    private final com.tencent.mobileqq.troop.adapter.contact.a f(View view) {
        com.tencent.mobileqq.troop.adapter.contact.a aVar = new com.tencent.mobileqq.troop.adapter.contact.a();
        View findViewById = view.findViewById(R.id.group_name);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.widget.SingleLineTextView");
        aVar.f293800d = (SingleLineTextView) findViewById;
        View findViewById2 = view.findViewById(R.id.dv_);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.CheckBox");
        aVar.f293798b = (CheckBox) findViewById2;
        View findViewById3 = view.findViewById(R.id.contact_count);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type com.tencent.mobileqq.activity.contacts.friend.SimpleTextView");
        aVar.f293802f = (SimpleTextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.f165958dx0);
        Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.widget.ProgressBar");
        aVar.f293799c = (ProgressBar) findViewById4;
        View findViewById5 = view.findViewById(R.id.f167055ka1);
        Intrinsics.checkNotNull(findViewById5, "null cannot be cast to non-null type com.tencent.widget.SingleLineTextView");
        aVar.f293801e = (SingleLineTextView) findViewById5;
        return aVar;
    }

    private final String g(com.tencent.mobileqq.troop.adapter.contact.a tag) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(tag.f293800d.getText());
        sb5.append(" ");
        sb5.append(tag.f293802f.a());
        sb5.append("\u4e2a");
        if (tag.f293798b.isChecked()) {
            sb5.append(" \u5df2\u5c55\u5f00");
        } else {
            sb5.append(" \u5df2\u6298\u53e0");
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "talkback.toString()");
        return sb6;
    }

    private final boolean h() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("guild_tab_content_description_switch", true) && AppSetting.f99565y;
    }

    private final void l(QUISingleLineListItem childView, final IGProGuildInfo info) {
        String guildName = info.getGuildName();
        Intrinsics.checkNotNullExpressionValue(guildName, "info.guildName");
        String avatarUrl = info.getAvatarUrl(140);
        Intrinsics.checkNotNullExpressionValue(avatarUrl, "info.getAvatarUrl(IGuiildAvatarUrlType.SIZE_140)");
        x<x.b, x.c> xVar = new x<>(new x.b.a(guildName, avatarUrl), new x.c.g("", false, false, 4, null));
        xVar.R(new Function2<ImageView, String, Unit>() { // from class: com.tencent.mobileqq.guild.GuildListAdapter$updateChildViewDetail$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView, String str) {
                invoke2(imageView, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ImageView avatarView, String avatarUrl2) {
                Intrinsics.checkNotNullParameter(avatarView, "avatarView");
                Intrinsics.checkNotNullParameter(avatarUrl2, "avatarUrl");
                IGuildContactApi iGuildContactApi = (IGuildContactApi) QRoute.api(IGuildContactApi.class);
                String guildName2 = IGProGuildInfo.this.getGuildName();
                Intrinsics.checkNotNullExpressionValue(guildName2, "info.guildName");
                iGuildContactApi.updateGuildAvatar(avatarView, avatarUrl2, guildName2);
            }
        });
        childView.setConfig(xVar);
        ImageView updateChildViewDetail$lambda$1 = (ImageView) childView.findViewById(R.id.f66153_v);
        float dimension = updateChildViewDetail$lambda$1.getResources().getDimension(R.dimen.dae);
        Intrinsics.checkNotNullExpressionValue(updateChildViewDetail$lambda$1, "updateChildViewDetail$lambda$1");
        ab.d(updateChildViewDetail$lambda$1, dimension);
        o(childView, info.getGuildUnNotifyFlag() != 0);
        childView.setBackgroundType(QUIListItemBackgroundType.FullWidth);
        childView.setStyle(QUIListItemStyle.FullWidth);
        childView.setOnClickListener(new a(this));
    }

    private final void m(View groupView, com.tencent.mobileqq.troop.adapter.contact.a tag, int groupPosition, boolean isExpanded) {
        String str;
        ColorStateList colorStateList = this.context.getResources().getColorStateList(R.color.qui_common_text_secondary);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "context.resources.getCol\u2026ui_common_text_secondary)");
        tag.f293797a = groupPosition;
        tag.f293802f.setTextColor(colorStateList);
        tag.f293800d.setText(this.guildGroups.get(groupPosition));
        SimpleTextView simpleTextView = tag.f293802f;
        ArrayList<IGProGuildInfo> arrayList = this.guildChildren.get(this.guildGroups.get(groupPosition));
        if (arrayList == null || (str = Integer.valueOf(arrayList.size()).toString()) == null) {
            str = "";
        }
        simpleTextView.setText(str);
        tag.f293799c.setVisibility(8);
        tag.f293798b.setVisibility(0);
        tag.f293798b.setChecked(isExpanded);
        if (groupView != null) {
            groupView.setOnClickListener(new c(this));
        }
        if (!h() || groupView == null) {
            return;
        }
        groupView.setContentDescription(g(tag));
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public void configHeaderView(View header, int groupPosition) {
        com.tencent.mobileqq.troop.adapter.contact.a aVar;
        Intrinsics.checkNotNullParameter(header, "header");
        if (!(header.getTag() instanceof com.tencent.mobileqq.troop.adapter.contact.a)) {
            aVar = f(header);
            header.setTag(aVar);
        } else {
            Object tag = header.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.troop.adapter.contact.GroupTag");
            aVar = (com.tencent.mobileqq.troop.adapter.contact.a) tag;
        }
        n(aVar, groupPosition, this.f187112f.isGroupExpanded(groupPosition));
        header.setBackground(this.context.getDrawable(R.drawable.jis));
        if (h()) {
            header.setContentDescription(g(aVar));
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int groupPosition, int childPosition) {
        ArrayList<IGProGuildInfo> arrayList = this.guildChildren.get(this.guildGroups.get(groupPosition));
        if (arrayList != null) {
            return arrayList.get(childPosition);
        }
        return null;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        IGProGuildInfo iGProGuildInfo;
        Object obj = null;
        QUISingleLineListItem qUISingleLineListItem = convertView instanceof QUISingleLineListItem ? (QUISingleLineListItem) convertView : null;
        if (qUISingleLineListItem == null) {
            qUISingleLineListItem = new QUISingleLineListItem(this.context, null, 2, null);
        }
        ArrayList<IGProGuildInfo> arrayList = this.guildChildren.get(this.guildGroups.get(groupPosition));
        if (arrayList != null && (iGProGuildInfo = arrayList.get(childPosition)) != null) {
            l(qUISingleLineListItem, iGProGuildInfo);
            obj = iGProGuildInfo;
        }
        qUISingleLineListItem.setTag(obj);
        return qUISingleLineListItem;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int groupPosition) {
        ArrayList<IGProGuildInfo> arrayList = this.guildChildren.get(this.guildGroups.get(groupPosition));
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int groupPosition) {
        return this.guildGroups.get(groupPosition);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.guildGroups.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public int getHeaderViewLayoutResourceId() {
        return R.layout.e3z;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return false;
    }

    public final void i(int allSize, ArrayList<IGProGuildInfo> createdGuilds, ArrayList<IGProGuildInfo> managedGuilds, ArrayList<IGProGuildInfo> joinedGuilds) {
        this.guildChildren.clear();
        Map<String, ArrayList<IGProGuildInfo>> map = this.guildChildren;
        String str = this.createdGuildGroup;
        if (createdGuilds == null) {
            createdGuilds = new ArrayList<>();
        }
        map.put(str, createdGuilds);
        Map<String, ArrayList<IGProGuildInfo>> map2 = this.guildChildren;
        String str2 = this.managedGuildGroup;
        if (managedGuilds == null) {
            managedGuilds = new ArrayList<>();
        }
        map2.put(str2, managedGuilds);
        Map<String, ArrayList<IGProGuildInfo>> map3 = this.guildChildren;
        String str3 = this.joinedGuildGroup;
        if (joinedGuilds == null) {
            joinedGuilds = new ArrayList<>();
        }
        map3.put(str3, joinedGuilds);
        this.guildGroups.clear();
        if (allSize != 0) {
            this.guildGroups.add(this.createdGuildGroup);
            this.guildGroups.add(this.managedGuildGroup);
            this.guildGroups.add(this.joinedGuildGroup);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public final void j() {
        int i3 = com.tencent.relation.common.utils.h.e(this.context, this.f187111e.getAccount()).getInt(this.spExpandKey, 4);
        int size = this.guildGroups.size();
        for (int i16 = 0; i16 < size; i16++) {
            Integer num = this.expandGroupMap.get(this.guildGroups.get(i16));
            if (num != null) {
                int intValue = num.intValue();
                if ((i3 & intValue) == intValue) {
                    this.f187112f.expandGroup(i16);
                } else {
                    this.f187112f.collapseGroup(i16);
                }
            }
        }
    }

    public final void k() {
        int size = this.guildGroups.size();
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            if (this.f187112f.isGroupExpanded(i16)) {
                Integer num = this.expandGroupMap.get(this.guildGroups.get(i16));
                i3 |= num != null ? num.intValue() : 0;
            } else {
                Integer num2 = this.expandGroupMap.get(this.guildGroups.get(i16));
                i3 &= num2 != null ? ~num2.intValue() : -1;
            }
        }
        String account = this.f187111e.getAccount();
        Intrinsics.checkNotNullExpressionValue(account, "mAppIntf.account");
        ThreadManagerV2.excute(new SaveExpandRunnable(i3, account, this.spExpandKey), 16, null, false);
    }

    @Override // com.tencent.widget.PinnedHeaderExpandableListView.ExpandableListAdapter
    public boolean needHideBackgroundGroup() {
        return true;
    }

    private final void n(com.tencent.mobileqq.troop.adapter.contact.a tag, int groupPosition, boolean isExpanded) {
        m(null, tag, groupPosition, isExpanded);
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            View inflate = LayoutInflater.from(this.context).inflate(R.layout.e3z, parent, false);
            com.tencent.mobileqq.troop.adapter.contact.a f16 = f(inflate);
            inflate.setTag(f16);
            m(inflate, f16, groupPosition, isExpanded);
            return inflate;
        }
        Object tag = convertView.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.troop.adapter.contact.GroupTag");
        m(convertView, (com.tencent.mobileqq.troop.adapter.contact.a) tag, groupPosition, isExpanded);
        return convertView;
    }

    private final void o(QUISingleLineListItem childView, boolean unNotifyIsOpen) {
        ImageView imageView = (ImageView) childView.findViewById(R.id.f17901j);
        if (!unNotifyIsOpen) {
            if (imageView == null) {
                return;
            }
            imageView.setVisibility(8);
            return;
        }
        if (imageView == null) {
            imageView = new ImageView(this.context);
            imageView.setId(R.id.f17901j);
            int dimensionPixelSize = imageView.getResources().getDimensionPixelSize(R.dimen.f9603);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.setMargins(imageView.getResources().getDimensionPixelSize(R.dimen.f9581), imageView.getResources().getDimensionPixelSize(R.dimen.f9592), 0, 0);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(R.drawable.guild_not_disturb_icon);
            childView.addView(imageView);
        }
        imageView.setVisibility(0);
    }
}
