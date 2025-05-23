package com.tencent.mobileqq.guild.feed.comment.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.GuildBaseTransFragment;
import com.tencent.mobileqq.guild.feed.comment.fragment.GuildFeedListCommentFragment;
import com.tencent.mobileqq.guild.feed.detail.task.e;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.InputFunctionType;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ShowInputComponentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.a;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.feed.widget.comment.d;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import ej1.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0002\u0019\u001aB\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0014J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/comment/fragment/GuildFeedListCommentFragment;", "Lcom/tencent/mobileqq/guild/base/GuildBaseTransFragment;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/a;", "", "uh", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getLogTag", "Landroid/content/Intent;", "intent", "l4", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDetailInitBean;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDetailInitBean;", "initBean", "<init>", "()V", "D", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedListCommentFragment extends GuildBaseTransFragment implements a {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private GuildFeedDetailInitBean initBean;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007R\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/comment/fragment/GuildFeedListCommentFragment$a;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "containerId", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDetailInitBean;", "initBean", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "data", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.comment.fragment.GuildFeedListCommentFragment$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull FragmentManager fragmentManager, int containerId, @NotNull GuildFeedDetailInitBean initBean, @NotNull GProStFeed data) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(initBean, "initBean");
            Intrinsics.checkNotNullParameter(data, "data");
            if (containerId <= 0) {
                QLog.e("GuildFeedListCommentFragment", 1, "GuildFeedListCommentFragment launch fail");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable(com.tencent.mobileqq.guild.feed.b.f218115a, initBean);
            bundle.putString("key_poster_nick_name", data.poster.nick);
            bundle.putInt("public_fragment_window_feature", 1);
            bundle.putString("feed_id", initBean.getFeedId());
            bundle.putString("guild_id", initBean.getGuildId());
            bundle.putString("channel_id", initBean.getChannelId());
            bundle.putInt("business_type", initBean.getBusinessType());
            if (initBean.getBusinessType() == 7) {
                bundle.putBoolean("guild_feed_support_at_entrance", false);
            }
            GuildFeedListCommentFragment guildFeedListCommentFragment = new GuildFeedListCommentFragment();
            guildFeedListCommentFragment.setArguments(bundle);
            try {
                fragmentManager.beginTransaction().add(containerId, guildFeedListCommentFragment).commitNowAllowingStateLoss();
            } catch (Exception e16) {
                QLog.e("GuildFeedListCommentFragment", 1, "launch fail: " + e16);
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/comment/fragment/GuildFeedListCommentFragment$b;", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", "event", "", "", "getDynamicParams", "<init>", "(Lcom/tencent/mobileqq/guild/feed/comment/fragment/GuildFeedListCommentFragment;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public final class b implements IDynamicParams {
        public b() {
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        @NotNull
        public Map<String, Object> getDynamicParams(@Nullable String event) {
            String str;
            String str2;
            String str3;
            Map<String, Object> mutableMapOf;
            HashMap<String, String> hashMap;
            String str4;
            HashMap<String, String> discoverSearchDtParams;
            String str5;
            HashMap<String, String> discoverSearchDtParams2;
            HashMap<String, String> discoverSearchDtParams3;
            QLog.i("GuildFeedListCommentFragment", 1, "FeedListCommentParams getDynamicParams event=" + event);
            Pair[] pairArr = new Pair[3];
            GuildFeedDetailInitBean guildFeedDetailInitBean = GuildFeedListCommentFragment.this.initBean;
            String str6 = null;
            if (guildFeedDetailInitBean != null) {
                str = guildFeedDetailInitBean.getChannelId();
            } else {
                str = null;
            }
            String str7 = "";
            if (str == null) {
                str = "";
            }
            pairArr[0] = TuplesKt.to("sgrp_sub_channel_id", str);
            GuildFeedDetailInitBean guildFeedDetailInitBean2 = GuildFeedListCommentFragment.this.initBean;
            if (guildFeedDetailInitBean2 != null) {
                str2 = guildFeedDetailInitBean2.getFeedId();
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = "";
            }
            pairArr[1] = TuplesKt.to("sgrp_feed_id", str2);
            GuildFeedDetailInitBean guildFeedDetailInitBean3 = GuildFeedListCommentFragment.this.initBean;
            if (guildFeedDetailInitBean3 != null) {
                str3 = guildFeedDetailInitBean3.getGuildId();
            } else {
                str3 = null;
            }
            if (str3 == null) {
                str3 = "";
            }
            pairArr[2] = TuplesKt.to("sgrp_channel_id", str3);
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            GuildFeedDetailInitBean guildFeedDetailInitBean4 = GuildFeedListCommentFragment.this.initBean;
            if (guildFeedDetailInitBean4 != null) {
                hashMap = guildFeedDetailInitBean4.getDiscoverSearchDtParams();
            } else {
                hashMap = null;
            }
            if (hashMap != null) {
                GuildFeedDetailInitBean guildFeedDetailInitBean5 = GuildFeedListCommentFragment.this.initBean;
                if (guildFeedDetailInitBean5 != null && (discoverSearchDtParams3 = guildFeedDetailInitBean5.getDiscoverSearchDtParams()) != null) {
                    str6 = discoverSearchDtParams3.get("sgrp_rank");
                }
                if (str6 == null) {
                    str6 = 0;
                }
                GuildFeedDetailInitBean guildFeedDetailInitBean6 = GuildFeedListCommentFragment.this.initBean;
                if (guildFeedDetailInitBean6 == null || (discoverSearchDtParams2 = guildFeedDetailInitBean6.getDiscoverSearchDtParams()) == null || (str4 = discoverSearchDtParams2.get("sgrp_section_name")) == null) {
                    str4 = "";
                }
                GuildFeedDetailInitBean guildFeedDetailInitBean7 = GuildFeedListCommentFragment.this.initBean;
                if (guildFeedDetailInitBean7 != null && (discoverSearchDtParams = guildFeedDetailInitBean7.getDiscoverSearchDtParams()) != null && (str5 = discoverSearchDtParams.get("sgrp_forum_trace_id")) != null) {
                    str7 = str5;
                }
                QLog.i("GuildFeedListCommentFragment", 1, "FeedListCommentParams getDynamicParams event=" + event + " rank=" + str6 + " sectionName=" + str4 + " traceId=" + str7);
                mutableMapOf.put("sgrp_rank", str6);
                mutableMapOf.put("sgrp_section_name", str4);
                mutableMapOf.put("sgrp_forum_trace_id", str7);
            }
            return mutableMapOf;
        }
    }

    @JvmStatic
    public static final void sh(@NotNull FragmentManager fragmentManager, int i3, @NotNull GuildFeedDetailInitBean guildFeedDetailInitBean, @NotNull GProStFeed gProStFeed) {
        INSTANCE.a(fragmentManager, i3, guildFeedDetailInitBean, gProStFeed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void th(GuildFeedListCommentFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.uh();
    }

    private final void uh() {
        String str;
        String str2;
        boolean z16;
        boolean z17;
        GuildFeedDetailInitBean guildFeedDetailInitBean = this.initBean;
        String str3 = null;
        if (guildFeedDetailInitBean != null) {
            str = guildFeedDetailInitBean.getGuildId();
        } else {
            str = null;
        }
        String str4 = "";
        if (str == null) {
            str = "";
        }
        GuildFeedDetailInitBean guildFeedDetailInitBean2 = this.initBean;
        if (guildFeedDetailInitBean2 != null) {
            str2 = guildFeedDetailInitBean2.getChannelId();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        GuildFeedDetailInitBean guildFeedDetailInitBean3 = this.initBean;
        if (guildFeedDetailInitBean3 != null) {
            str3 = guildFeedDetailInitBean3.getFeedId();
        }
        if (str3 != null) {
            str4 = str3;
        }
        boolean z18 = false;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (str2.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                if (str4.length() == 0) {
                    z18 = true;
                }
                if (!z18) {
                    getPartManager().broadcastMessage("message_check_input_speak_permission_succ", new a.ShowInputComponentMessage(new ShowInputComponentArgs(InputFunctionType.FUNCTION_TYPE_COMMENT_FEED, null, 0, (short) 1, null, 16, null)));
                    return;
                }
            }
        }
        QLog.e("GuildFeedListCommentFragment", 1, "showInputBar fail, Params invalid");
        finish();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        int i3 = 1;
        if (this.initBean == null) {
            QLog.e("GuildFeedListCommentFragment", 1, "assembleParts initBean invalid");
            return arrayList;
        }
        arrayList.add(new ej1.b(null, i3, 0 == true ? 1 : 0));
        GuildFeedDetailInitBean guildFeedDetailInitBean = this.initBean;
        Intrinsics.checkNotNull(guildFeedDetailInitBean);
        arrayList.add(new c(guildFeedDetailInitBean));
        arrayList.add(new com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.c(d.f224303h, new b(), this, true));
        GuildFeedDetailInitBean guildFeedDetailInitBean2 = this.initBean;
        Intrinsics.checkNotNull(guildFeedDetailInitBean2);
        arrayList.add(new com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.b(guildFeedDetailInitBean2, true));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.ep9;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GuildFeedListCommentFragment";
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.a
    public void l4(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (getFragmentManager() != null && getHost() != null && !isDetached() && !isRemoving()) {
            try {
                startActivityForResult(intent, 10014);
                return;
            } catch (Exception e16) {
                QLog.e("GuildFeedListCommentFragment", 1, "openAlbum fail " + e16);
                return;
            }
        }
        QLog.e("GuildFeedListCommentFragment", 1, "openAlbum fail");
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Serializable serializable;
        Bundle arguments = getArguments();
        GuildFeedDetailInitBean guildFeedDetailInitBean = null;
        if (arguments != null) {
            serializable = arguments.getSerializable(com.tencent.mobileqq.guild.feed.b.f218115a);
        } else {
            serializable = null;
        }
        if (serializable instanceof GuildFeedDetailInitBean) {
            guildFeedDetailInitBean = (GuildFeedDetailInitBean) serializable;
        }
        this.initBean = guildFeedDetailInitBean;
        if (guildFeedDetailInitBean == null) {
            QLog.e("GuildFeedListCommentFragment", 1, "showInputBar fail, initBean == null");
            finish();
            return;
        }
        super.onCreate(savedInstanceState);
        getMainHandler().post(new Runnable() { // from class: fj1.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedListCommentFragment.th(GuildFeedListCommentFragment.this);
            }
        });
        if (MobileQQ.sMobileQQ.peekAppRuntime() instanceof BaseQQAppInterface) {
            e.h().n();
        }
    }
}
