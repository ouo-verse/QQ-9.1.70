package mn0;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.aio.base.mvi.part.TitleUIState;
import com.tencent.aio.data.AIOContact;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.article.msglist.GuildArticleMsgListEvent;
import com.tencent.guild.aio.article.msglist.h;
import com.tencent.guild.aio.article.title.action.GuildArticleTitleActionUIState;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.api.activity.IAIOSingleActivityApi;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mn0.a;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001\u001d\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001a\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0002H\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lmn0/g;", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/guild/aio/title/c;", "Lcom/tencent/aio/base/mvi/part/TitleUIState;", "", "p", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "E", "", "isMultiSelectMode", "t", "isSuccess", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", ReportConstant.COSTREPORT_PREFIX, "r", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/aio/data/AIOContact;", "d", "Lcom/tencent/aio/data/AIOContact;", "contact", "mn0/g$b", "e", "Lmn0/g$b;", "mAction", "<init>", "()V", "f", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class g extends com.tencent.aio.base.mvvm.b<com.tencent.guild.aio.title.c, TitleUIState> {

    /* renamed from: h, reason: collision with root package name */
    private static final long f417034h = 400;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private AIOContact contact;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"mn0/g$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            g.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent i3) {
        if (i3 instanceof GuildMsgListIntent.GuildMultiSelectModeChangeEvent) {
            t(((GuildMsgListIntent.GuildMultiSelectModeChangeEvent) i3).getIsSelectMode());
            return;
        }
        if (i3 instanceof GuildArticleMsgListEvent.MainMsgRecordInitCompleted) {
            GuildArticleMsgListEvent.MainMsgRecordInitCompleted mainMsgRecordInitCompleted = (GuildArticleMsgListEvent.MainMsgRecordInitCompleted) i3;
            s(mainMsgRecordInitCompleted.getIsSuccess(), mainMsgRecordInitCompleted.getMsgRecord());
        } else if (i3 instanceof GuildArticleMsgListEvent.MainMsgInfoUpdated) {
            r(((GuildArticleMsgListEvent.MainMsgInfoUpdated) i3).getMsgRecord());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m() {
        GuildMultiMsgManager.INSTANCE.a().n(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())), false);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildMultiSelectModeChangeEvent("GuildAioDefaultTitleViewBinder", false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n() {
        View view;
        Fragment parentFragment = ((com.tencent.aio.api.runtime.a) getMContext()).c().getParentFragment();
        if (parentFragment != null && (view = parentFragment.getView()) != null) {
            view.animate().translationYBy(view.getHeight()).setDuration(f417034h).withEndAction(new Runnable() { // from class: mn0.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.o(g.this);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void o(g this$0) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity2 = ((com.tencent.aio.api.runtime.a) this$0.getMContext()).c().getActivity();
        if (activity2 != null) {
            activity2.onBackPressed();
        }
        if (((com.tencent.aio.api.runtime.a) this$0.getMContext()).c().getActivity() != null) {
            IAIOSingleActivityApi iAIOSingleActivityApi = (IAIOSingleActivityApi) QRoute.api(IAIOSingleActivityApi.class);
            FragmentActivity requireActivity = ((com.tencent.aio.api.runtime.a) this$0.getMContext()).c().requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "mContext.fragment.requireActivity()");
            if (iAIOSingleActivityApi.isGuildAIOSingleTaskActivity(requireActivity) && (activity = ((com.tencent.aio.api.runtime.a) this$0.getMContext()).c().getActivity()) != null) {
                activity.finish();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p() {
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(GuildArticleMsgListEvent.MainMsgRecordGet.f109915d);
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.guild.aio.article.msglist.GuildArticleMsgListResult.MainMsgRecordGetResult");
        MsgRecord msgRecord = ((h.b) k3).getMsgRecord();
        if (msgRecord != null) {
            GuildMsgItem guildMsgItem = new GuildMsgItem(msgRecord);
            co0.a aVar = co0.a.f31161a;
            FragmentActivity activity = ((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "mContext.fragment.activi\u2026y).supportFragmentManager");
            aVar.b(supportFragmentManager, guildMsgItem, (com.tencent.aio.api.runtime.a) getMContext());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
    
        if (r2 != 1) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void r(MsgRecord msgRecord) {
        boolean z16;
        if (msgRecord != null && (r2 = msgRecord.msgType) != 5) {
            z16 = true;
        }
        z16 = false;
        updateUI(new GuildArticleTitleActionUIState.GuildArticleMoreUIState(z16));
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000a, code lost:
    
        if (r1 != 1) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void s(boolean isSuccess, MsgRecord msgRecord) {
        boolean z16;
        if (isSuccess && msgRecord != null && (r1 = msgRecord.msgType) != 5) {
            z16 = true;
        }
        z16 = false;
        updateUI(new GuildArticleTitleActionUIState.GuildArticleMoreUIState(z16));
    }

    private final void t(boolean isMultiSelectMode) {
        updateUI(new GuildArticleTitleActionUIState.GuildAIOTitleMultiUIState(isMultiSelectMode));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        GuildMultiMsgManager.d dVar = new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext()));
        GuildMultiMsgManager.Companion companion = GuildMultiMsgManager.INSTANCE;
        if (companion.a().i(dVar)) {
            companion.a().n(dVar, false);
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildMultiSelectModeChangeEvent("GuildAioTitleViewModel", false));
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.MainMsgRecordInitCompleted.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.MainMsgInfoUpdated.class).getQualifiedName(), this.mAction);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.guild.aio.title.c intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.c) {
            p();
        } else if (intent instanceof a.b) {
            n();
        } else if (intent instanceof a.C10796a) {
            m();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), this.mAction);
        this.contact = context.g().r().c();
        t(GuildMultiMsgManager.INSTANCE.a().i(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext()))));
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.MainMsgRecordInitCompleted.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.MainMsgInfoUpdated.class).getQualifiedName(), this.mAction);
    }
}
