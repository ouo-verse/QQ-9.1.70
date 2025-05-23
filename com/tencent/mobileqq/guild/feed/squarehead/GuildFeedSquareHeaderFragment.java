package com.tencent.mobileqq.guild.feed.squarehead;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.square.GuildFeedSquareInitBean;
import com.tencent.mobileqq.guild.feed.squarehead.gamedistribute.GameDistributeAdPart;
import com.tencent.mobileqq.guild.feed.squarehead.noticebubble.GuildFeedSquareNoticeBubblePart;
import com.tencent.mobileqq.guild.feed.squarehead.ownertask.GuildFeedPublishToastPart;
import com.tencent.mobileqq.guild.feed.squarehead.topFeed.TopFeedListPart;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.richframework.argus.node.ArgusTag;
import ek1.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xj1.c;

/* compiled from: P */
@ArgusTag(testConfigKey = "Argus_Guild", testTags = {"AUTO_PRELOAD"})
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\b\u0010\r\u001a\u00020\fH\u0014J\u001c\u0010\u0012\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0013\u001a\u00020\u0002H\u0014J\b\u0010\u0014\u001a\u00020\u0002H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/squarehead/GuildFeedSquareHeaderFragment;", "Lcom/tencent/biz/richframework/part/BasePartFragment;", "", "initIoc", "qh", "", "getLogTag", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Lcom/tencent/mobileqq/guild/feed/square/GuildFeedSquareInitBean;", "ph", "", "getContentLayoutId", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedBeforePartInit", "onFragmentViewDestroyed", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Lxj1/c;", BdhLogUtil.LogTag.Tag_Conn, "Lxj1/c;", "dtReportIoc", "D", "Lcom/tencent/mobileqq/guild/feed/square/GuildFeedSquareInitBean;", "initBean", "", "E", "Z", "needReCheck", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSquareHeaderFragment extends BasePartFragment {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private c dtReportIoc;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private GuildFeedSquareInitBean initBean;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean needReCheck;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/squarehead/GuildFeedSquareHeaderFragment$a;", "", "Landroid/os/Bundle;", "arguments", "Landroidx/fragment/app/Fragment;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.squarehead.GuildFeedSquareHeaderFragment$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Fragment a(@Nullable Bundle arguments) {
            GuildFeedSquareHeaderFragment guildFeedSquareHeaderFragment = new GuildFeedSquareHeaderFragment();
            if (arguments != null) {
                guildFeedSquareHeaderFragment.setArguments(new Bundle(arguments));
            }
            return guildFeedSquareHeaderFragment;
        }

        Companion() {
        }
    }

    private final void initIoc() {
        if (this.initBean == null) {
            qh();
        }
        GuildFeedSquareInitBean guildFeedSquareInitBean = this.initBean;
        if (guildFeedSquareInitBean != null) {
            this.dtReportIoc = new a(guildFeedSquareInitBean);
            RFWIocAbilityProvider.g().registerIoc(getView(), this.dtReportIoc, c.class);
        }
    }

    private final void qh() {
        GuildFeedBaseInitBean o16 = ax.o(this);
        if (o16 instanceof GuildFeedSquareInitBean) {
            this.initBean = (GuildFeedSquareInitBean) o16;
            QLog.d(getTAG(), 1, "getInitBeanSuccess:" + this.initBean);
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        String str;
        IGProChannelInfo B;
        GuildFeedSquareInitBean ph5 = ph();
        if (ph5 != null) {
            str = ph5.getChannelId();
        } else {
            str = null;
        }
        if (str == null) {
            str = "0";
        }
        boolean z16 = true;
        if (!Intrinsics.areEqual(str, "0") && (B = ch.B(str)) != null) {
            z16 = B.isHiddenPostChannel();
        }
        if (z16) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new GuildFeedSquareNoticeBubblePart());
            arrayList.add(new TopFeedListPart("0"));
            arrayList.add(new GameDistributeAdPart());
            arrayList.add(new GuildFeedPublishToastPart());
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new TopFeedListPart(str));
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168092er4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GuildFeedSquareTopFragment";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onFragmentViewDestroyed() {
        super.onFragmentViewDestroyed();
        if (this.initBean != null) {
            RFWIocAbilityProvider.g().unregisterSingleIoc(getView(), c.class);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.needReCheck = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(@Nullable View contentView, @Nullable Bundle savedInstanceState) {
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        if (contentView == null) {
            return;
        }
        initIoc();
    }

    @Nullable
    public final GuildFeedSquareInitBean ph() {
        if (this.initBean == null) {
            qh();
        }
        return this.initBean;
    }
}
