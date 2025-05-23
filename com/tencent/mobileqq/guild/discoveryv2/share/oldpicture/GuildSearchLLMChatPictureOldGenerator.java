package com.tencent.mobileqq.guild.discoveryv2.share.oldpicture;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.guild.discoveryv2.share.picture.GuildSearchLLMChatPictureAsyncWorkManager;
import com.tencent.mobileqq.guild.discoveryv2.share.picture.GuildSearchLLMChatPictureGenerator;
import com.tencent.mobileqq.guild.media.widget.audiofaceview.e;
import com.tencent.mobileqq.guild.quiprofile.GuildContextWrapper;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vp1.dk;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001 B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J#\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\bJg\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042O\u0010\u0018\u001aK\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\u0014\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\u0016\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00060\u0010R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/share/oldpicture/GuildSearchLLMChatPictureOldGenerator;", "", "Lvp1/dk;", "binding", "Lcom/tencent/mobileqq/guild/discoveryv2/share/oldpicture/GuildSearchLLMChatPictureOldGenerator$a;", "param", "", "d", "(Lvp1/dk;Lcom/tencent/mobileqq/guild/discoveryv2/share/oldpicture/GuildSearchLLMChatPictureOldGenerator$a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "e", "", "f", "", "g", "Landroid/content/Context;", "context", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "isAllAsyncResourcesOk", "Landroid/view/View;", "view", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "onResult", h.F, "Ljava/text/SimpleDateFormat;", "b", "Ljava/text/SimpleDateFormat;", "sDateFormatter", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildSearchLLMChatPictureOldGenerator {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildSearchLLMChatPictureOldGenerator f217750a = new GuildSearchLLMChatPictureOldGenerator();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SimpleDateFormat sDateFormatter = new SimpleDateFormat("yyyy.MM.dd");

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0017\u001a\u0004\b\u000f\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/share/oldpicture/GuildSearchLLMChatPictureOldGenerator$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$b;", "()Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$b;", "adapter", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "titleIconUrl", "d", "titleName", "", "J", "()J", "maxWaitTime", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$b;Ljava/lang/String;Ljava/lang/String;J)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.share.oldpicture.GuildSearchLLMChatPictureOldGenerator$a, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class GeneratorParam {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final GuildSearchLLMChatPictureGenerator.b<RecyclerView.ViewHolder> adapter;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String titleIconUrl;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String titleName;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final long maxWaitTime;

        public GeneratorParam(@NotNull GuildSearchLLMChatPictureGenerator.b<RecyclerView.ViewHolder> adapter, @NotNull String titleIconUrl, @NotNull String titleName, long j3) {
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            Intrinsics.checkNotNullParameter(titleIconUrl, "titleIconUrl");
            Intrinsics.checkNotNullParameter(titleName, "titleName");
            this.adapter = adapter;
            this.titleIconUrl = titleIconUrl;
            this.titleName = titleName;
            this.maxWaitTime = j3;
        }

        @NotNull
        public final GuildSearchLLMChatPictureGenerator.b<RecyclerView.ViewHolder> a() {
            return this.adapter;
        }

        /* renamed from: b, reason: from getter */
        public final long getMaxWaitTime() {
            return this.maxWaitTime;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getTitleIconUrl() {
            return this.titleIconUrl;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getTitleName() {
            return this.titleName;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GeneratorParam)) {
                return false;
            }
            GeneratorParam generatorParam = (GeneratorParam) other;
            if (Intrinsics.areEqual(this.adapter, generatorParam.adapter) && Intrinsics.areEqual(this.titleIconUrl, generatorParam.titleIconUrl) && Intrinsics.areEqual(this.titleName, generatorParam.titleName) && this.maxWaitTime == generatorParam.maxWaitTime) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.adapter.hashCode() * 31) + this.titleIconUrl.hashCode()) * 31) + this.titleName.hashCode()) * 31) + androidx.fragment.app.a.a(this.maxWaitTime);
        }

        @NotNull
        public String toString() {
            return "GeneratorParam(adapter=" + this.adapter + ", titleIconUrl=" + this.titleIconUrl + ", titleName=" + this.titleName + ", maxWaitTime=" + this.maxWaitTime + ")";
        }
    }

    GuildSearchLLMChatPictureOldGenerator() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d(dk dkVar, GeneratorParam generatorParam, Continuation<? super Unit> continuation) {
        GuildSearchLLMChatPictureOldGenerator$bindRecyclerView$1 guildSearchLLMChatPictureOldGenerator$bindRecyclerView$1;
        Object coroutine_suspended;
        int i3;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        if (continuation instanceof GuildSearchLLMChatPictureOldGenerator$bindRecyclerView$1) {
            guildSearchLLMChatPictureOldGenerator$bindRecyclerView$1 = (GuildSearchLLMChatPictureOldGenerator$bindRecyclerView$1) continuation;
            int i16 = guildSearchLLMChatPictureOldGenerator$bindRecyclerView$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                guildSearchLLMChatPictureOldGenerator$bindRecyclerView$1.label = i16 - Integer.MIN_VALUE;
                Object obj = guildSearchLLMChatPictureOldGenerator$bindRecyclerView$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = guildSearchLLMChatPictureOldGenerator$bindRecyclerView$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        recyclerView2 = (RecyclerView) guildSearchLLMChatPictureOldGenerator$bindRecyclerView$1.L$1;
                        recyclerView = (RecyclerView) guildSearchLLMChatPictureOldGenerator$bindRecyclerView$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    View findViewById = dkVar.getRoot().findViewById(R.id.sfu);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "binding.root.findViewById(R.id.ai_chat_list)");
                    RecyclerView recyclerView3 = (RecyclerView) findViewById;
                    recyclerView3.setLayoutManager(new e(dkVar.getRoot().getContext()));
                    GuildSearchLLMChatPictureGenerator.b<RecyclerView.ViewHolder> a16 = generatorParam.a();
                    String w06 = generatorParam.a().w0();
                    guildSearchLLMChatPictureOldGenerator$bindRecyclerView$1.L$0 = recyclerView3;
                    guildSearchLLMChatPictureOldGenerator$bindRecyclerView$1.L$1 = recyclerView3;
                    guildSearchLLMChatPictureOldGenerator$bindRecyclerView$1.label = 1;
                    Object v06 = a16.v0(w06, guildSearchLLMChatPictureOldGenerator$bindRecyclerView$1);
                    if (v06 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    recyclerView = recyclerView3;
                    obj = v06;
                    recyclerView2 = recyclerView;
                }
                recyclerView2.setAdapter((RecyclerView.Adapter) obj);
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                Intrinsics.checkNotNull(adapter);
                adapter.notifyDataSetChanged();
                recyclerView.requestLayout();
                a.e(recyclerView);
                return Unit.INSTANCE;
            }
        }
        guildSearchLLMChatPictureOldGenerator$bindRecyclerView$1 = new GuildSearchLLMChatPictureOldGenerator$bindRecyclerView$1(this, continuation);
        Object obj2 = guildSearchLLMChatPictureOldGenerator$bindRecyclerView$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = guildSearchLLMChatPictureOldGenerator$bindRecyclerView$1.label;
        if (i3 == 0) {
        }
        recyclerView2.setAdapter((RecyclerView.Adapter) obj2);
        RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
        Intrinsics.checkNotNull(adapter2);
        adapter2.notifyDataSetChanged();
        recyclerView.requestLayout();
        a.e(recyclerView);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(dk binding, GeneratorParam param) {
        binding.f442926c.getPaint().setFakeBoldText(true);
        binding.f442926c.setText(param.getTitleName());
        binding.f442927d.setText("\u5206\u4eab\u4e8e" + f());
        binding.f442931h.setText(param.a().w0());
    }

    private final String f() {
        String format = sDateFormatter.format(new Date(NetConnInfoCenter.getServerTimeMillis()));
        Intrinsics.checkNotNullExpressionValue(format, "sDateFormatter.format(Da\u2026r.getServerTimeMillis()))");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object g(dk dkVar, GeneratorParam generatorParam, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        List mutableListOf;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        ImageView imageView = dkVar.f442925b;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.guildShareAiLogo");
        ImageView imageView2 = dkVar.f442932i;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.guildShareLogoBottom");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new GuildSearchLLMChatPictureAsyncWorkManager.ImageRemoteResData(imageView, generatorParam.getTitleIconUrl(), "LogoLeftTop", false, 8, null), new GuildSearchLLMChatPictureAsyncWorkManager.ImageRemoteResData(imageView2, "https://downv6.qq.com/innovate/guild/search/guild_search_llm_picture_bottom_1.png", "LogoBottom", false, 8, null));
        final long currentTimeMillis = System.currentTimeMillis();
        new GuildSearchLLMChatPictureAsyncWorkManager(generatorParam.getMaxWaitTime(), mutableListOf, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.share.oldpicture.GuildSearchLLMChatPictureOldGenerator$loadAsyncResources$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Logger logger = Logger.f235387a;
                long j3 = currentTimeMillis;
                logger.d().a("Guild.share.GuildSearchLLMChatPictureOldGenerator", 1, "loadAsyncResources ok cost: " + (currentTimeMillis2 - j3) + " ms");
                Continuation<Boolean> continuation2 = safeContinuation;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(Boolean.valueOf(z16)));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final void h(@NotNull Context context, @NotNull GeneratorParam param, @NotNull Function3<? super Boolean, ? super View, ? super Bitmap, Unit> onResult) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        Logger.f235387a.d().a("Guild.share.GuildSearchLLMChatPictureOldGenerator", 1, "startGenerate param:" + param);
        GuildContextWrapper guildContextWrapper = new GuildContextWrapper(context, 1001);
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "Guild.share.GuildSearchLLMChatPictureOldGenerator startShare", null, null, null, new GuildSearchLLMChatPictureOldGenerator$startGenerate$2(guildContextWrapper, param, onResult, null), 14, null);
        }
    }
}
