package com.tencent.mobileqq.aio.msglist.holder.component.ptt;

import android.content.Context;
import android.util.Log;
import com.google.gson.Gson;
import com.heytap.databaseengine.apiv3.data.Element;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.PttMsgItem;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001,B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007J.\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0002J!\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001cR\u001b\u0010$\u001a\u00020\u001f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R+\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u00070%j\b\u0012\u0004\u0012\u00020\u0007`&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010!\u001a\u0004\b'\u0010(\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttUtil;", "", "", Element.ELEMENT_NAME_MIN, "sec", "", "f", "", "msgId", "progress", "", "progressWaveView", "", "j", "i", "time", "viewLenByText", "waveStyleOtherSize", "bubbleMaxContentWidth", "", "isVoiceChange", "g", "e", "Landroid/content/Context;", "context", "speakerPhoneOn", "k", "(Landroid/content/Context;Ljava/lang/Boolean;)V", "Lcom/tencent/mobileqq/aio/msg/PttMsgItem;", "msgItem", tl.h.F, "Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttUtil$a;", "b", "Lkotlin/Lazy;", "c", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttUtil$a;", "aioPttMsgProgress", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", "()Ljava/util/ArrayList;", "autoSpeechToTextWhiteList", "<init>", "()V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOPttUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AIOPttUtil f191743a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy aioPttMsgProgress;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy autoSpeechToTextWhiteList;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/AIOPttUtil$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "d", "(J)V", "msgId", "b", "I", "()I", "e", "(I)V", "progress", "", "c", UserInfo.SEX_FEMALE, "()F", "f", "(F)V", "progressWaveView", "<init>", "(JIF)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private long msgId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int progress;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private float progressWaveView;

        public a() {
            this(0L, 0, 0.0f, 7, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
                return;
            }
            iPatchRedirector.redirect((short) 16, (Object) this);
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.msgId;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.progress;
        }

        public final float c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Float) iPatchRedirector.redirect((short) 7, (Object) this)).floatValue();
            }
            return this.progressWaveView;
        }

        public final void d(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, j3);
            } else {
                this.msgId = j3;
            }
        }

        public final void e(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3);
            } else {
                this.progress = i3;
            }
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (this.msgId == aVar.msgId && this.progress == aVar.progress && Float.compare(this.progressWaveView, aVar.progressWaveView) == 0) {
                return true;
            }
            return false;
        }

        public final void f(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
            } else {
                this.progressWaveView = f16;
            }
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
            }
            return (((androidx.fragment.app.a.a(this.msgId) * 31) + this.progress) * 31) + Float.floatToIntBits(this.progressWaveView);
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (String) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return "AIOPttMsgProgress(msgId=" + this.msgId + ", progress=" + this.progress + ", progressWaveView=" + this.progressWaveView + ")";
        }

        public a(long j3, int i3, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3), Float.valueOf(f16));
                return;
            }
            this.msgId = j3;
            this.progress = i3;
            this.progressWaveView = f16;
        }

        public /* synthetic */ a(long j3, int i3, float f16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 0L : j3, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? 0.0f : f16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16), defaultConstructorMarker);
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63118);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        f191743a = new AIOPttUtil();
        lazy = LazyKt__LazyJVMKt.lazy(AIOPttUtil$aioPttMsgProgress$2.INSTANCE);
        aioPttMsgProgress = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(AIOPttUtil$autoSpeechToTextWhiteList$2.INSTANCE);
        autoSpeechToTextWhiteList = lazy2;
    }

    AIOPttUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final ArrayList<Long> d() {
        return (ArrayList) autoSpeechToTextWhiteList.getValue();
    }

    private final String f(int min, int sec) {
        if (sec < 10 && min > 0) {
            return "0" + sec;
        }
        return String.valueOf(sec);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(final Context context, Boolean bool) {
        AppRuntime peekAppRuntime;
        final int i3;
        Intrinsics.checkNotNullParameter(context, "$context");
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOPttUtil", 4, "toastSpeak");
        }
        if (com.tencent.mobileqq.qqaudio.audioplayer.c.f(context)) {
            i3 = R.string.ysx;
        } else if (com.tencent.mobileqq.qqaudio.audioplayer.c.c(context)) {
            i3 = R.string.ysu;
        } else if (Intrinsics.areEqual(bool, Boolean.TRUE) || (!Intrinsics.areEqual(bool, Boolean.FALSE) && ((peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null || com.tencent.mobileqq.qqaudio.audioplayer.c.b(peekAppRuntime)))) {
            i3 = R.string.f170278yt1;
        } else {
            i3 = R.string.f170277yt0;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.x
            @Override // java.lang.Runnable
            public final void run() {
                AIOPttUtil.m(context, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "$context");
        QQToast.makeText(context, i3, 0).show();
    }

    @NotNull
    public final a c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Object value = aioPttMsgProgress.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-aioPttMsgProgress>(...)");
        return (a) value;
    }

    @NotNull
    public final String e(int time) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, time);
        }
        int i3 = time / 60;
        int i16 = time % 60;
        if (i3 > 0) {
            str = i3 + "'";
        } else {
            str = "";
        }
        return str + f(i3, i16) + "\"";
    }

    public final int g(int time, int viewLenByText, int waveStyleOtherSize, int bubbleMaxContentWidth, boolean isVoiceChange) {
        int coerceAtLeast;
        int coerceAtMost;
        int h16;
        int coerceAtLeast2;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(1, time);
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(60, coerceAtLeast);
            if (coerceAtMost == 1) {
                h16 = 25;
            } else {
                h16 = ((int) (PttAudioWaveView.h(coerceAtMost, 60, 1.5f) * 125)) + 15;
            }
            if (isVoiceChange) {
                i16 = 26;
            }
            if (i16 != 0 && h16 > (i3 = 250 - i16)) {
                h16 = i3;
            }
            if (h16 % 5 != 0) {
                h16 = (h16 / 5) * 5;
            }
            coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(ViewUtils.dip2px(h16) + waveStyleOtherSize, viewLenByText);
            if (coerceAtLeast2 <= bubbleMaxContentWidth) {
                bubbleMaxContentWidth = coerceAtLeast2;
            }
            return bubbleMaxContentWidth - waveStyleOtherSize;
        }
        return ((Integer) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(time), Integer.valueOf(viewLenByText), Integer.valueOf(waveStyleOtherSize), Integer.valueOf(bubbleMaxContentWidth), Boolean.valueOf(isVoiceChange))).intValue();
    }

    public final boolean h(@NotNull PttMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem.getMsgRecord().chatType != 1) {
            return false;
        }
        long j3 = msgItem.getMsgRecord().peerUin;
        Iterator<T> it = d().iterator();
        while (it.hasNext()) {
            if (j3 == ((Number) it.next()).longValue()) {
                return true;
            }
        }
        return false;
    }

    public final void i(long msgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, msgId);
            return;
        }
        if (msgId == 0) {
            return;
        }
        c().d(0L);
        c().e(0);
        c().f(0.0f);
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.removeKey("aio_ptt_progress");
    }

    public final void j(long msgId, int progress, float progressWaveView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(msgId), Integer.valueOf(progress), Float.valueOf(progressWaveView));
            return;
        }
        if (Float.isNaN(progressWaveView)) {
            QLog.i("AIOPttUtil", 1, "saveProgress  progressWaveView:" + progressWaveView + ",  stackTrace:" + Log.getStackTraceString(new Throwable()));
            return;
        }
        c().d(msgId);
        c().e(progress);
        c().f(progressWaveView);
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeString("aio_ptt_progress", new Gson().toJson(c()));
    }

    public final void k(@NotNull final Context context, @Nullable final Boolean speakerPhoneOn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) speakerPhoneOn);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.w
                @Override // java.lang.Runnable
                public final void run() {
                    AIOPttUtil.l(context, speakerPhoneOn);
                }
            }, 240, null, true);
        }
    }
}
