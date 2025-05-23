package nn0;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.article.msglist.GuildArticleMsgListEvent;
import com.tencent.guild.aio.article.title.GuildArticleTitleEvent;
import com.tencent.guild.aio.article.title.navigate.GuildArticleTitleNavigateUIState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.al;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import nn0.a;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0007*\u0001\u001a\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0002H\u0016R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lnn0/d;", "Lcom/tencent/aio/base/mvvm/b;", "Lnn0/a;", "Lcom/tencent/guild/aio/article/title/navigate/GuildArticleTitleNavigateUIState;", "", "p", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "E", "", "isSuccess", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "o", "", "visibility", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "l", DomainData.DOMAIN_NAME, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "nn0/d$a", "d", "Lnn0/d$a;", "mAction", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d extends com.tencent.aio.base.mvvm.b<nn0.a, GuildArticleTitleNavigateUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mAction = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"nn0/d$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a implements com.tencent.mvi.base.route.a {
        a() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            d.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent i3) {
        if (i3 instanceof GuildArticleMsgListEvent.MainMsgRecordInitCompleted) {
            GuildArticleMsgListEvent.MainMsgRecordInitCompleted mainMsgRecordInitCompleted = (GuildArticleMsgListEvent.MainMsgRecordInitCompleted) i3;
            o(mainMsgRecordInitCompleted.getIsSuccess(), mainMsgRecordInitCompleted.getMsgRecord());
        } else if (i3 instanceof GuildArticleTitleEvent.TitleBarNavigateVisibleIntent) {
            q(((GuildArticleTitleEvent.TitleBarNavigateVisibleIntent) i3).getVisibility());
        } else if (i3 instanceof GuildArticleMsgListEvent.MainMsgInfoUpdated) {
            n(((GuildArticleMsgListEvent.MainMsgInfoUpdated) i3).getMsgRecord());
        }
    }

    private final String l(MsgRecord msgRecord) {
        List filterNotNull;
        ArrayList arrayList = new ArrayList();
        ArrayList<MsgElement> elements = msgRecord.elements;
        if (elements != null) {
            Intrinsics.checkNotNullExpressionValue(elements, "elements");
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(elements);
            if (filterNotNull != null) {
                Iterator it = filterNotNull.iterator();
                while (it.hasNext()) {
                    arrayList.add((MsgElement) it.next());
                }
            }
        }
        if (al.f(msgRecord)) {
            String string = BaseApplication.context.getString(R.string.f139730c2);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026cle_main_msg_revoke_tips)");
            return string;
        }
        return iq0.a.p(arrayList, false, false, 4, null).toString();
    }

    private final void n(MsgRecord msgRecord) {
        if (msgRecord != null && al.f(msgRecord)) {
            updateUI(new GuildArticleTitleNavigateUIState.MainMsgSummaryUIState(l(msgRecord)));
        }
    }

    private final void o(boolean isSuccess, MsgRecord msgRecord) {
        if (isSuccess && msgRecord != null) {
            updateUI(new GuildArticleTitleNavigateUIState.MainMsgSummaryUIState(l(msgRecord)));
        } else {
            updateUI(new GuildArticleTitleNavigateUIState.MainMsgSummaryUIState(""));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildArticleTitleEvent.NavigateMainMsgIntent());
    }

    private final void q(int visibility) {
        updateUI(new GuildArticleTitleNavigateUIState.ShowNavigateUIState(visibility));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull nn0.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C10852a) {
            p();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.MainMsgRecordInitCompleted.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildArticleTitleEvent.TitleBarNavigateVisibleIntent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.MainMsgInfoUpdated.class).getQualifiedName(), this.mAction);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.MainMsgRecordInitCompleted.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildArticleTitleEvent.TitleBarNavigateVisibleIntent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.MainMsgInfoUpdated.class).getQualifiedName(), this.mAction);
    }
}
