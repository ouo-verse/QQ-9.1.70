package ln0;

import com.tencent.aio.base.mvi.part.TitleUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.article.msglist.GuildArticleMsgListEvent;
import com.tencent.guild.aio.article.title.GuildArticleAIOTitleUIState;
import com.tencent.guild.aio.article.title.GuildArticleTitleEvent;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mvi.api.ability.e;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ln0.c;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\t*\u0001\u0014\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0002H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lln0/b;", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/guild/aio/title/c;", "Lcom/tencent/aio/base/mvi/part/TitleUIState;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "E", "", "isShowing", "", "topScreenPosition", "bottomScreenPosition", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "intent", "l", "ln0/b$b", "d", "Lln0/b$b;", "mAction", "<init>", "()V", "e", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b extends com.tencent.aio.base.mvvm.b<com.tencent.guild.aio.title.c, TitleUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C10737b mAction = new C10737b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"ln0/b$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ln0.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C10737b implements com.tencent.mvi.base.route.a {
        C10737b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            b.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent i3) {
        if (i3 instanceof GuildArticleMsgListEvent.MainMsgViewScreenPositionChanged) {
            GuildArticleMsgListEvent.MainMsgViewScreenPositionChanged mainMsgViewScreenPositionChanged = (GuildArticleMsgListEvent.MainMsgViewScreenPositionChanged) i3;
            m(mainMsgViewScreenPositionChanged.getIsShowing(), mainMsgViewScreenPositionChanged.getTopScreenPosition(), mainMsgViewScreenPositionChanged.getBottomScreenPosition());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m(boolean isShowing, int topScreenPosition, int bottomScreenPosition) {
        e fetchVBState = fetchVBState(new c.a());
        int i3 = fetchVBState.b().getInt("status_bar_bottom_screen_position");
        int i16 = fetchVBState.b().getInt("title_bar_bottom_screen_position");
        if (isShowing && topScreenPosition != Integer.MAX_VALUE && bottomScreenPosition != Integer.MAX_VALUE) {
            if (bottomScreenPosition <= i16) {
                updateUI(new GuildArticleAIOTitleUIState.TitleAlphaUIState(255.0f));
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildArticleTitleEvent.TitleBarUserInfoVisibleIntent(4));
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildArticleTitleEvent.TitleBarNavigateVisibleIntent(0));
                return;
            } else if (topScreenPosition <= i3) {
                updateUI(new GuildArticleAIOTitleUIState.TitleAlphaUIState(255.0f));
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildArticleTitleEvent.TitleBarNavigateVisibleIntent(4));
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildArticleTitleEvent.TitleBarUserInfoVisibleIntent(0));
                return;
            } else {
                updateUI(new GuildArticleAIOTitleUIState.TitleAlphaUIState(0.0f));
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildArticleTitleEvent.TitleBarNavigateVisibleIntent(4));
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildArticleTitleEvent.TitleBarUserInfoVisibleIntent(4));
                return;
            }
        }
        updateUI(new GuildArticleAIOTitleUIState.TitleAlphaUIState(255.0f));
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildArticleTitleEvent.TitleBarUserInfoVisibleIntent(4));
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildArticleTitleEvent.TitleBarNavigateVisibleIntent(0));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.guild.aio.title.c intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgListScrollEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.MainMsgViewScreenPositionChanged.class).getQualifiedName(), this.mAction);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMsgListScrollEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.MainMsgViewScreenPositionChanged.class).getQualifiedName(), this.mAction);
    }
}
