package mm1;

import com.tencent.mobileqq.guild.feed.nativepublish.feature.msgintent.SimplifiedFeedEditorGlobalMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.root.msgintent.FeedEditorRootMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.title.SimplifiedFeedEditorTitleMviUIState;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mvi.mvvm.BaseVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mm1.b;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \u00102.\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0007:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\u000b\u001a\u00020\b2\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0002H\u0016\u00a8\u0006\u0012"}, d2 = {"Lmm1/g;", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lmm1/b;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/title/SimplifiedFeedEditorTitleMviUIState;", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/EditorBaseVM;", "", "l", "context", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "intent", "j", "<init>", "()V", "d", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g extends BaseVM<b, SimplifiedFeedEditorTitleMviUIState, com.tencent.base.api.runtime.a<zl1.a>> {
    /* JADX WARN: Multi-variable type inference failed */
    private final void l() {
        String str;
        String str2;
        boolean isSupportTitleBar = ((zl1.a) ((com.tencent.base.api.runtime.a) getMContext()).h()).getConfiguration().getIsSupportTitleBar();
        if (isSupportTitleBar) {
            IGProGuildInfo L = ch.L(((zl1.a) ((com.tencent.base.api.runtime.a) getMContext()).h()).h());
            if (L != null) {
                str2 = L.getGuildName();
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = "Unknown";
            }
            str = "\u53d1\u81f3\u9891\u9053: " + str2;
        } else {
            str = "";
        }
        updateUI(new SimplifiedFeedEditorTitleMviUIState.EditorTitleVisible(isSupportTitleBar, str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof b.C10795b) {
            ((com.tencent.base.api.runtime.a) getMContext()).e().h(new FeedEditorRootMsgIntent.TriggerCloseEditorAnyway(2));
        } else if (intent instanceof b.a) {
            ((com.tencent.base.api.runtime.a) getMContext()).e().h(new SimplifiedFeedEditorGlobalMsgIntent.ChangeDisplayMode(((b.a) intent).getCom.tencent.hippy.qq.api.OpenHippyInfo.EXTRA_KEY_IS_FULL_SCREEN java.lang.String()));
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void onCreate(@NotNull com.tencent.base.api.runtime.a<zl1.a> context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate((g) context);
        l();
    }
}
