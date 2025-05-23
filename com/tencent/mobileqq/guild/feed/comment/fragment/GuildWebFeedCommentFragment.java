package com.tencent.mobileqq.guild.feed.comment.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.GuildBaseTransFragment;
import com.tencent.mobileqq.guild.feed.comment.fragment.GuildWebFeedCommentFragment;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.InputFunctionType;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ReplyCommentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ShowInputComponentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.feed.widget.comment.d;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStReply;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import cooperation.qzone.QzoneIPCModule;
import ej1.c;
import ej1.e;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import nj1.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0002?@B\u0007\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\nH\u0014J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\"\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010 \u001a\u00020\u001fH\u0014J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020\u0003H\u0016R$\u0010+\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u00103\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u0010;\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/comment/fragment/GuildWebFeedCommentFragment;", "Lcom/tencent/mobileqq/guild/base/GuildBaseTransFragment;", "Lej1/e;", "", "Ah", "Ch", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/InputFunctionType;", "vh", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/h;", "sh", "", "wh", "uh", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;", "rh", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStReply;", "th", "", "xh", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "", "getLogTag", "Landroidx/fragment/app/Fragment;", "getFragment", "dismiss", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDetailInitBean;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDetailInitBean;", "getInitBean", "()Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDetailInitBean;", "setInitBean", "(Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDetailInitBean;)V", "initBean", "Lnj1/a;", "D", "Lnj1/a;", "getInputConfigParams", "()Lnj1/a;", "Bh", "(Lnj1/a;)V", "inputConfigParams", "Lcom/tencent/mobileqq/guild/feed/comment/fragment/GuildWebFeedCommentFragment$b;", "E", "Lcom/tencent/mobileqq/guild/feed/comment/fragment/GuildWebFeedCommentFragment$b;", "getDismissListener", "()Lcom/tencent/mobileqq/guild/feed/comment/fragment/GuildWebFeedCommentFragment$b;", OcrConfig.CHINESE, "(Lcom/tencent/mobileqq/guild/feed/comment/fragment/GuildWebFeedCommentFragment$b;)V", "dismissListener", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildWebFeedCommentFragment extends GuildBaseTransFragment implements e {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private GuildFeedDetailInitBean initBean;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private a inputConfigParams;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private b dismissListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J.\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0007R\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/comment/fragment/GuildWebFeedCommentFragment$a;", "", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "parentFragment", "Lnj1/a;", "inputParams", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDetailInitBean;", "bean", "Lcom/tencent/mobileqq/guild/feed/comment/fragment/GuildWebFeedCommentFragment$b;", "listener", "Lej1/e;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.comment.fragment.GuildWebFeedCommentFragment$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final e a(@NotNull WebViewFragment parentFragment, @NotNull a inputParams, @NotNull GuildFeedDetailInitBean bean, @Nullable b listener) {
            Intrinsics.checkNotNullParameter(parentFragment, "parentFragment");
            Intrinsics.checkNotNullParameter(inputParams, "inputParams");
            Intrinsics.checkNotNullParameter(bean, "bean");
            FragmentManager parentFragmentManager = parentFragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragment.parentFragmentManager");
            if (!parentFragmentManager.isDestroyed() && !parentFragment.isDetached()) {
                int id5 = parentFragment.getContentView().getId();
                GuildWebFeedCommentFragment guildWebFeedCommentFragment = new GuildWebFeedCommentFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable(com.tencent.mobileqq.guild.feed.b.f218115a, bean);
                guildWebFeedCommentFragment.setArguments(bundle);
                guildWebFeedCommentFragment.Bh(inputParams);
                guildWebFeedCommentFragment.zh(listener);
                parentFragmentManager.beginTransaction().replace(id5, guildWebFeedCommentFragment).commitNowAllowingStateLoss();
                return guildWebFeedCommentFragment;
            }
            QLog.e("GuildWebFeedCommentFragment", 1, "launch fail, fragmentManager is Destroyed");
            return null;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/comment/fragment/GuildWebFeedCommentFragment$b;", "", "", "onDismiss", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        void onDismiss();
    }

    private final void Ah() {
        String str;
        String str2;
        String str3;
        boolean z16;
        int i3;
        boolean z17;
        String str4;
        boolean z18;
        boolean z19;
        GuildFeedDetailInitBean guildFeedDetailInitBean = this.initBean;
        String str5 = null;
        if (guildFeedDetailInitBean != null) {
            str = guildFeedDetailInitBean.getGuildId();
        } else {
            str = null;
        }
        String str6 = "";
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
        } else {
            str3 = null;
        }
        if (str3 != null) {
            str6 = str3;
        }
        GuildFeedDetailInitBean guildFeedDetailInitBean4 = this.initBean;
        boolean z26 = false;
        if (guildFeedDetailInitBean4 != null) {
            z16 = guildFeedDetailInitBean4.isMember();
        } else {
            z16 = false;
        }
        GuildFeedDetailInitBean guildFeedDetailInitBean5 = this.initBean;
        if (guildFeedDetailInitBean5 != null) {
            i3 = guildFeedDetailInitBean5.getBusinessType();
        } else {
            i3 = 0;
        }
        a aVar = this.inputConfigParams;
        if (aVar != null) {
            z17 = aVar.getSupportAt();
        } else {
            z17 = true;
        }
        a aVar2 = this.inputConfigParams;
        if (aVar2 != null) {
            str4 = aVar2.getPlaceHolder();
        } else {
            str4 = null;
        }
        a aVar3 = this.inputConfigParams;
        if (aVar3 != null) {
            str5 = aVar3.getTroopName();
        }
        if (str.length() == 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z18) {
            if (str2.length() == 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (!z19) {
                if (str6.length() == 0) {
                    z26 = true;
                }
                if (!z26) {
                    Bundle bundle = new Bundle();
                    bundle.putString("feed_id", str6);
                    bundle.putString("guild_id", str);
                    bundle.putString("channel_id", str2);
                    bundle.putBoolean("guild_feed_is_member", z16);
                    bundle.putInt("business_type", i3);
                    bundle.putBoolean("guild_feed_support_at_entrance", z17);
                    bundle.putString("feed_comment_input_bar_hint", str4);
                    bundle.putString("guild_feed_channel_name", str5);
                    QLog.i("GuildWebFeedCommentFragment", 1, "setInitData bundle=" + bundle.hashCode() + " feedId=" + str6 + " guildId=" + str + " channelId=" + str2 + " isMember=" + z16 + " businessType=" + i3 + " supportAt=" + z17 + " troopName=" + str5 + " placeHolder=" + str4);
                    setArguments(bundle);
                    return;
                }
            }
        }
        QLog.e("GuildWebFeedCommentFragment", 1, "setInitData fail, Params invalid");
    }

    private final void Ch() {
        getPartManager().broadcastMessage("message_check_input_speak_permission_succ", new a.ShowInputComponentMessage(new ShowInputComponentArgs(vh(), sh(), wh(), (short) uh(), null, 16, null)));
    }

    private final GProStComment rh() {
        String str;
        long j3;
        GProStComment gProStComment = new GProStComment();
        nj1.a aVar = this.inputConfigParams;
        String str2 = null;
        if (aVar != null) {
            str = aVar.getCom.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams.KEY_COMMENT_ID java.lang.String();
        } else {
            str = null;
        }
        gProStComment.idd = str;
        nj1.a aVar2 = this.inputConfigParams;
        if (aVar2 != null) {
            j3 = aVar2.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CREATE_TIME java.lang.String();
        } else {
            j3 = 0;
        }
        gProStComment.createTime = j3;
        GProStUser gProStUser = new GProStUser();
        nj1.a aVar3 = this.inputConfigParams;
        if (aVar3 != null) {
            str2 = aVar3.getCommentPosterId();
        }
        gProStUser.idd = str2;
        gProStComment.postUser = gProStUser;
        return gProStComment;
    }

    private final ReplyCommentArgs sh() {
        nj1.a aVar = this.inputConfigParams;
        boolean z16 = false;
        int i3 = 1;
        if (aVar != null && aVar.getIsReply()) {
            z16 = true;
        }
        if (z16) {
            if (!xh()) {
                i3 = 2;
            }
            return new ReplyCommentArgs(i3, rh(), th(), null, false, 16, null);
        }
        return null;
    }

    private final GProStReply th() {
        String str;
        GProStReply gProStReply = new GProStReply();
        nj1.a aVar = this.inputConfigParams;
        String str2 = null;
        if (aVar != null) {
            str = aVar.getReplyTargetId();
        } else {
            str = null;
        }
        gProStReply.idd = str;
        GProStUser gProStUser = new GProStUser();
        nj1.a aVar2 = this.inputConfigParams;
        if (aVar2 != null) {
            str2 = aVar2.getReplyTargetUserId();
        }
        gProStUser.idd = str2;
        gProStReply.postUser = gProStUser;
        return gProStReply;
    }

    private final int uh() {
        nj1.a aVar = this.inputConfigParams;
        if (aVar != null) {
            return aVar.getClickRegion();
        }
        return 1;
    }

    private final InputFunctionType vh() {
        nj1.a aVar = this.inputConfigParams;
        boolean z16 = false;
        if (aVar != null && aVar.getIsReply()) {
            z16 = true;
        }
        if (z16) {
            return InputFunctionType.FUNCTION_TYPE_REPLY_COMMENT;
        }
        return InputFunctionType.FUNCTION_TYPE_COMMENT_FEED;
    }

    private final int wh() {
        nj1.a aVar = this.inputConfigParams;
        if (aVar != null) {
            return aVar.getActiveType();
        }
        return 0;
    }

    private final boolean xh() {
        String str;
        nj1.a aVar = this.inputConfigParams;
        if (aVar == null) {
            return false;
        }
        String str2 = null;
        if (aVar != null) {
            str = aVar.getCom.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams.KEY_COMMENT_ID java.lang.String();
        } else {
            str = null;
        }
        nj1.a aVar2 = this.inputConfigParams;
        if (aVar2 != null) {
            str2 = aVar2.getReplyTargetId();
        }
        return Intrinsics.areEqual(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(GuildWebFeedCommentFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ch();
    }

    public final void Bh(@Nullable nj1.a aVar) {
        this.inputConfigParams = aVar;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        if (this.initBean == null) {
            QLog.e("GuildWebFeedCommentFragment", 1, "assembleParts initBean invalid");
            return arrayList;
        }
        GuildFeedDetailInitBean guildFeedDetailInitBean = this.initBean;
        Intrinsics.checkNotNull(guildFeedDetailInitBean);
        arrayList.add(new c(guildFeedDetailInitBean));
        arrayList.add(new ej1.b(this.dismissListener));
        arrayList.add(new com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.c(d.f224303h, null, null, false, 14, null));
        GuildFeedDetailInitBean guildFeedDetailInitBean2 = this.initBean;
        Intrinsics.checkNotNull(guildFeedDetailInitBean2);
        arrayList.add(new com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.b(guildFeedDetailInitBean2, false, 2, null));
        return arrayList;
    }

    @Override // ej1.e
    public void dismiss() {
        Object obj;
        try {
            List<Fragment> fragments = getParentFragmentManager().getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "parentFragmentManager.fragments");
            Iterator<T> it = fragments.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((Fragment) obj) instanceof GuildWebFeedCommentFragment) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            Fragment fragment = (Fragment) obj;
            if (fragment != null) {
                getParentFragmentManager().beginTransaction().remove(fragment).commitNowAllowingStateLoss();
            }
        } catch (Exception e16) {
            QLog.e("GuildWebFeedCommentFragment", 1, "dismiss error, " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.ep9;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    public String getLogTag() {
        return "GuildWebFeedCommentFragment";
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        QLog.i("GuildWebFeedCommentFragment", 1, "onActivityResult requestCode=" + requestCode + " resultCode=" + resultCode);
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
        Ah();
        super.onCreate(savedInstanceState);
        getMainHandler().post(new Runnable() { // from class: fj1.b
            @Override // java.lang.Runnable
            public final void run() {
                GuildWebFeedCommentFragment.yh(GuildWebFeedCommentFragment.this);
            }
        });
    }

    public final void zh(@Nullable b bVar) {
        this.dismissListener = bVar;
    }

    @Override // ej1.e
    @NotNull
    public Fragment getFragment() {
        return this;
    }
}
