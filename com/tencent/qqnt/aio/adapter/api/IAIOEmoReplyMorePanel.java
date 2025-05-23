package com.tencent.qqnt.aio.adapter.api;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.aio.emoreply.j;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0016JP\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\b\u0010\u0013\u001a\u00020\u0011H&J\b\u0010\u0015\u001a\u00020\u0014H&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOEmoReplyMorePanel;", "", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Landroid/view/View;", "anchorView", HippyNestedScrollComponent.PRIORITY_PARENT, "", "from", "Lcom/tencent/qqnt/aio/adapter/api/IAIOEmoReplyMorePanel$Source;", "source", "", NodeProps.PADDING_BOTTOM, "Lcom/tencent/qqnt/aio/emoreply/j;", "callBack", "", "a", "dismiss", "", "isShowing", "Source", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface IAIOEmoReplyMorePanel {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IAIOEmoReplyMorePanel$Source;", "", "(Ljava/lang/String;I)V", "EMO_REPLY_MORE", "EMO_REPLY_ADD", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class Source {
        private static final /* synthetic */ Source[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final Source EMO_REPLY_ADD;
        public static final Source EMO_REPLY_MORE;

        private static final /* synthetic */ Source[] $values() {
            return new Source[]{EMO_REPLY_MORE, EMO_REPLY_ADD};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30100);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            EMO_REPLY_MORE = new Source("EMO_REPLY_MORE", 0);
            EMO_REPLY_ADD = new Source("EMO_REPLY_ADD", 1);
            $VALUES = $values();
        }

        Source(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static Source valueOf(String str) {
            return (Source) Enum.valueOf(Source.class, str);
        }

        public static Source[] values() {
            return (Source[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        public static /* synthetic */ void a(IAIOEmoReplyMorePanel iAIOEmoReplyMorePanel, Context context, MsgRecord msgRecord, View view, View view2, String str, Source source, int i3, j jVar, int i16, Object obj) {
            int i17;
            j jVar2;
            if (obj == null) {
                if ((i16 & 64) != 0) {
                    i17 = 0;
                } else {
                    i17 = i3;
                }
                if ((i16 & 128) != 0) {
                    jVar2 = null;
                } else {
                    jVar2 = jVar;
                }
                iAIOEmoReplyMorePanel.a(context, msgRecord, view, view2, str, source, i17, jVar2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
        }
    }

    void a(@NotNull Context context, @NotNull MsgRecord msgRecord, @NotNull View anchorView, @Nullable View parent, @NotNull String from, @NotNull Source source, int paddingBottom, @Nullable j callBack);

    void dismiss();

    boolean isShowing();
}
