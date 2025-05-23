package com.tencent.mobileqq.guild.discoveryv2.share.picture;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.component.qrcode.QUIColorfulQRCodeView;
import com.tencent.mobileqq.component.qrcode.d;
import com.tencent.mobileqq.component.qrcode.f;
import com.tencent.mobileqq.component.qrcode.g;
import com.tencent.mobileqq.component.qrcode.i;
import com.tencent.mobileqq.guild.discoveryv2.share.picture.GuildSearchLLMChatPictureAsyncWorkManager;
import com.tencent.mobileqq.guild.media.widget.audiofaceview.e;
import com.tencent.mobileqq.guild.quiprofile.GuildContextWrapper;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
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
import vp1.dj;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002+&B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J#\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\bJ\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fH\u0002J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002Jg\u0010!\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042O\u0010 \u001aK\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u001c\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0015\u0012\u0013\u0018\u00010\u001e\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00060\u0018J\u000e\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator;", "", "Lvp1/dj;", "binding", "Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$a;", "param", "", h.F, "(Lvp1/dj;Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "i", "", "k", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "f", "", "", "Lcom/tencent/mobileqq/component/qrcode/d;", "j", "", "Lcom/tencent/mobileqq/component/qrcode/f;", "l", "Landroid/content/Context;", "context", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "isAllAsyncResourcesOk", "Landroid/view/View;", "view", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "onResult", "o", "Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;", CommonConstant.KEY_QR_CODE, DomainData.DOMAIN_NAME, "Ljava/text/SimpleDateFormat;", "b", "Ljava/text/SimpleDateFormat;", "sDateFormatter", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildSearchLLMChatPictureGenerator {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildSearchLLMChatPictureGenerator f217767a = new GuildSearchLLMChatPictureGenerator();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SimpleDateFormat sDateFormatter = new SimpleDateFormat("yyyy.MM.dd");

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\u0004\b&\u0010'J_\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0005H\u00c6\u0001J\t\u0010\u0010\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001J\u0013\u0010\u0014\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0019\u001a\u0004\b\u001c\u0010\u001bR\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\u001bR\u0017\u0010\u000b\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010\u001bR\u0017\u0010\r\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b\"\u0010%R\u0017\u0010\u000e\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0019\u001a\u0004\b \u0010\u001b\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$a;", "", "Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "adapter", "", "titleIconUrl", "linkUrl", "", "isXHS", "titleName", "shareTitle", "", "maxWaitTime", "llmTip", "a", "toString", "", "hashCode", "other", "equals", "Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$b;", "c", "()Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$b;", "b", "Ljava/lang/String;", h.F, "()Ljava/lang/String;", "d", "Z", "j", "()Z", "e", "i", "f", "g", "J", "()J", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$b;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.share.picture.GuildSearchLLMChatPictureGenerator$a, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class GeneratorParam {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final b<RecyclerView.ViewHolder> adapter;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String titleIconUrl;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String linkUrl;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isXHS;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String titleName;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String shareTitle;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private final long maxWaitTime;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String llmTip;

        public GeneratorParam(@NotNull b<RecyclerView.ViewHolder> adapter, @NotNull String titleIconUrl, @NotNull String linkUrl, boolean z16, @NotNull String titleName, @NotNull String shareTitle, long j3, @NotNull String llmTip) {
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            Intrinsics.checkNotNullParameter(titleIconUrl, "titleIconUrl");
            Intrinsics.checkNotNullParameter(linkUrl, "linkUrl");
            Intrinsics.checkNotNullParameter(titleName, "titleName");
            Intrinsics.checkNotNullParameter(shareTitle, "shareTitle");
            Intrinsics.checkNotNullParameter(llmTip, "llmTip");
            this.adapter = adapter;
            this.titleIconUrl = titleIconUrl;
            this.linkUrl = linkUrl;
            this.isXHS = z16;
            this.titleName = titleName;
            this.shareTitle = shareTitle;
            this.maxWaitTime = j3;
            this.llmTip = llmTip;
        }

        public static /* synthetic */ GeneratorParam b(GeneratorParam generatorParam, b bVar, String str, String str2, boolean z16, String str3, String str4, long j3, String str5, int i3, Object obj) {
            b bVar2;
            String str6;
            String str7;
            boolean z17;
            String str8;
            String str9;
            long j16;
            String str10;
            if ((i3 & 1) != 0) {
                bVar2 = generatorParam.adapter;
            } else {
                bVar2 = bVar;
            }
            if ((i3 & 2) != 0) {
                str6 = generatorParam.titleIconUrl;
            } else {
                str6 = str;
            }
            if ((i3 & 4) != 0) {
                str7 = generatorParam.linkUrl;
            } else {
                str7 = str2;
            }
            if ((i3 & 8) != 0) {
                z17 = generatorParam.isXHS;
            } else {
                z17 = z16;
            }
            if ((i3 & 16) != 0) {
                str8 = generatorParam.titleName;
            } else {
                str8 = str3;
            }
            if ((i3 & 32) != 0) {
                str9 = generatorParam.shareTitle;
            } else {
                str9 = str4;
            }
            if ((i3 & 64) != 0) {
                j16 = generatorParam.maxWaitTime;
            } else {
                j16 = j3;
            }
            if ((i3 & 128) != 0) {
                str10 = generatorParam.llmTip;
            } else {
                str10 = str5;
            }
            return generatorParam.a(bVar2, str6, str7, z17, str8, str9, j16, str10);
        }

        @NotNull
        public final GeneratorParam a(@NotNull b<RecyclerView.ViewHolder> adapter, @NotNull String titleIconUrl, @NotNull String linkUrl, boolean isXHS, @NotNull String titleName, @NotNull String shareTitle, long maxWaitTime, @NotNull String llmTip) {
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            Intrinsics.checkNotNullParameter(titleIconUrl, "titleIconUrl");
            Intrinsics.checkNotNullParameter(linkUrl, "linkUrl");
            Intrinsics.checkNotNullParameter(titleName, "titleName");
            Intrinsics.checkNotNullParameter(shareTitle, "shareTitle");
            Intrinsics.checkNotNullParameter(llmTip, "llmTip");
            return new GeneratorParam(adapter, titleIconUrl, linkUrl, isXHS, titleName, shareTitle, maxWaitTime, llmTip);
        }

        @NotNull
        public final b<RecyclerView.ViewHolder> c() {
            return this.adapter;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getLinkUrl() {
            return this.linkUrl;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getLlmTip() {
            return this.llmTip;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GeneratorParam)) {
                return false;
            }
            GeneratorParam generatorParam = (GeneratorParam) other;
            if (Intrinsics.areEqual(this.adapter, generatorParam.adapter) && Intrinsics.areEqual(this.titleIconUrl, generatorParam.titleIconUrl) && Intrinsics.areEqual(this.linkUrl, generatorParam.linkUrl) && this.isXHS == generatorParam.isXHS && Intrinsics.areEqual(this.titleName, generatorParam.titleName) && Intrinsics.areEqual(this.shareTitle, generatorParam.shareTitle) && this.maxWaitTime == generatorParam.maxWaitTime && Intrinsics.areEqual(this.llmTip, generatorParam.llmTip)) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final long getMaxWaitTime() {
            return this.maxWaitTime;
        }

        @NotNull
        /* renamed from: g, reason: from getter */
        public final String getShareTitle() {
            return this.shareTitle;
        }

        @NotNull
        /* renamed from: h, reason: from getter */
        public final String getTitleIconUrl() {
            return this.titleIconUrl;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((this.adapter.hashCode() * 31) + this.titleIconUrl.hashCode()) * 31) + this.linkUrl.hashCode()) * 31;
            boolean z16 = this.isXHS;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return ((((((((hashCode + i3) * 31) + this.titleName.hashCode()) * 31) + this.shareTitle.hashCode()) * 31) + androidx.fragment.app.a.a(this.maxWaitTime)) * 31) + this.llmTip.hashCode();
        }

        @NotNull
        /* renamed from: i, reason: from getter */
        public final String getTitleName() {
            return this.titleName;
        }

        /* renamed from: j, reason: from getter */
        public final boolean getIsXHS() {
            return this.isXHS;
        }

        @NotNull
        public String toString() {
            return "GeneratorParam(adapter=" + this.adapter + ", titleIconUrl=" + this.titleIconUrl + ", linkUrl=" + this.linkUrl + ", isXHS=" + this.isXHS + ", titleName=" + this.titleName + ", shareTitle=" + this.shareTitle + ", maxWaitTime=" + this.maxWaitTime + ", llmTip=" + this.llmTip + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0004H&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Lqe1/b;", "", "llmTip", "v0", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "w0", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static abstract class b<VH extends RecyclerView.ViewHolder> extends qe1.b {
        @Nullable
        public abstract Object v0(@NotNull String str, @NotNull Continuation<? super b<VH>> continuation);

        @NotNull
        public abstract String w0();
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$c", "Lcom/tencent/mobileqq/component/qrcode/a;", "", "color", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends com.tencent.mobileqq.component.qrcode.a {
        c(List<f> list) {
            super(list);
        }

        @Override // com.tencent.mobileqq.component.qrcode.a
        @NotNull
        public List<Integer> a(int color) {
            int collectionSizeOrDefault;
            List<f> b16 = b();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(b16, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (f fVar : b16) {
                com.tencent.mobileqq.qui.profileskin.material_color.hct.b b17 = com.tencent.mobileqq.qui.profileskin.material_color.hct.b.b(color);
                arrayList.add(Integer.valueOf(com.tencent.mobileqq.qui.profileskin.material_color.hct.b.a(b17.d(), b17.c(), b17.e()).g()));
            }
            return arrayList;
        }
    }

    GuildSearchLLMChatPictureGenerator() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(dj binding, GeneratorParam param) {
        if (param.getIsXHS()) {
            QUIColorfulQRCodeView qUIColorfulQRCodeView = binding.f442915c;
            Intrinsics.checkNotNullExpressionValue(qUIColorfulQRCodeView, "binding.guildQrcode");
            qUIColorfulQRCodeView.setVisibility(8);
            return;
        }
        QUIColorfulQRCodeView qUIColorfulQRCodeView2 = binding.f442915c;
        Intrinsics.checkNotNullExpressionValue(qUIColorfulQRCodeView2, "binding.guildQrcode");
        qUIColorfulQRCodeView2.setVisibility(0);
        QUIColorfulQRCodeView qUIColorfulQRCodeView3 = binding.f442915c;
        Intrinsics.checkNotNullExpressionValue(qUIColorfulQRCodeView3, "binding.guildQrcode");
        n(qUIColorfulQRCodeView3);
        Logger.f235387a.d().a("Guild.share.GuildSearchLLMChatPictureGenerator", 1, "bindQRCodeView shareUrl:" + param.getLinkUrl());
        binding.f442915c.f(param.getLinkUrl(), new g() { // from class: com.tencent.mobileqq.guild.discoveryv2.share.picture.b
            @Override // com.tencent.mobileqq.component.qrcode.g
            public final void onResult(int i3) {
                GuildSearchLLMChatPictureGenerator.g(i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(int i3) {
        Logger.f235387a.d().a("Guild.share.GuildSearchLLMChatPictureGenerator", 1, "bindQRCodeView result:" + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(dj djVar, GeneratorParam generatorParam, Continuation<? super Unit> continuation) {
        GuildSearchLLMChatPictureGenerator$bindRecyclerView$1 guildSearchLLMChatPictureGenerator$bindRecyclerView$1;
        Object coroutine_suspended;
        int i3;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        if (continuation instanceof GuildSearchLLMChatPictureGenerator$bindRecyclerView$1) {
            guildSearchLLMChatPictureGenerator$bindRecyclerView$1 = (GuildSearchLLMChatPictureGenerator$bindRecyclerView$1) continuation;
            int i16 = guildSearchLLMChatPictureGenerator$bindRecyclerView$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                guildSearchLLMChatPictureGenerator$bindRecyclerView$1.label = i16 - Integer.MIN_VALUE;
                Object obj = guildSearchLLMChatPictureGenerator$bindRecyclerView$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = guildSearchLLMChatPictureGenerator$bindRecyclerView$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        recyclerView2 = (RecyclerView) guildSearchLLMChatPictureGenerator$bindRecyclerView$1.L$1;
                        recyclerView = (RecyclerView) guildSearchLLMChatPictureGenerator$bindRecyclerView$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    View findViewById = djVar.getRoot().findViewById(R.id.sfu);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "binding.root.findViewById(R.id.ai_chat_list)");
                    RecyclerView recyclerView3 = (RecyclerView) findViewById;
                    recyclerView3.setLayoutManager(new e(djVar.getRoot().getContext()));
                    b<RecyclerView.ViewHolder> c16 = generatorParam.c();
                    String llmTip = generatorParam.getLlmTip();
                    guildSearchLLMChatPictureGenerator$bindRecyclerView$1.L$0 = recyclerView3;
                    guildSearchLLMChatPictureGenerator$bindRecyclerView$1.L$1 = recyclerView3;
                    guildSearchLLMChatPictureGenerator$bindRecyclerView$1.label = 1;
                    Object v06 = c16.v0(llmTip, guildSearchLLMChatPictureGenerator$bindRecyclerView$1);
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
                com.tencent.mobileqq.guild.discoveryv2.share.picture.c.e(recyclerView);
                return Unit.INSTANCE;
            }
        }
        guildSearchLLMChatPictureGenerator$bindRecyclerView$1 = new GuildSearchLLMChatPictureGenerator$bindRecyclerView$1(this, continuation);
        Object obj2 = guildSearchLLMChatPictureGenerator$bindRecyclerView$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = guildSearchLLMChatPictureGenerator$bindRecyclerView$1.label;
        if (i3 == 0) {
        }
        recyclerView2.setAdapter((RecyclerView.Adapter) obj2);
        RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
        Intrinsics.checkNotNull(adapter2);
        adapter2.notifyDataSetChanged();
        recyclerView.requestLayout();
        com.tencent.mobileqq.guild.discoveryv2.share.picture.c.e(recyclerView);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(dj binding, GeneratorParam param) {
        int i3;
        String str;
        binding.f442917e.getPaint().setFakeBoldText(true);
        binding.f442917e.setText(param.getTitleName());
        binding.f442918f.setText("\u5206\u4eab\u4e8e" + k());
        binding.f442922j.setText(param.c().w0());
        QUIColorfulQRCodeView qUIColorfulQRCodeView = binding.f442915c;
        Intrinsics.checkNotNullExpressionValue(qUIColorfulQRCodeView, "binding.guildQrcode");
        if (true ^ param.getIsXHS()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        qUIColorfulQRCodeView.setVisibility(i3);
        TextView textView = binding.f442923k;
        if (param.getIsXHS()) {
            str = "\u6253\u5f00QQ\uff0c\u4e0a\u9891\u9053\u95ee\u95ee\u627e\u7b54\u6848";
        } else {
            str = "\u957f\u6309\u4e8c\u7ef4\u7801\u67e5\u770b\u8be6\u60c5";
        }
        textView.setText(str);
    }

    private final Map<Integer, d> j() {
        HashMap hashMap = new HashMap();
        float b16 = com.tencent.guild.aio.util.c.b(3);
        hashMap.put(3, new d(7, 6, b16, 1.5f));
        hashMap.put(4, new d(9, 7, b16, 1.5f));
        hashMap.put(5, new d(10, 8, b16, 1.5f));
        hashMap.put(6, new d(11, 9, b16, 1.5f));
        hashMap.put(7, new d(12, 10, b16, 1.5f));
        hashMap.put(8, new d(13, 11, b16, 1.5f));
        hashMap.put(9, new d(14, 12, b16, 1.5f));
        d dVar = new d(14, 12, b16, 1.0f);
        hashMap.put(10, dVar);
        hashMap.put(11, dVar);
        hashMap.put(12, dVar);
        hashMap.put(13, dVar);
        hashMap.put(14, dVar);
        hashMap.put(15, dVar);
        hashMap.put(16, dVar);
        hashMap.put(17, dVar);
        hashMap.put(18, dVar);
        hashMap.put(19, dVar);
        hashMap.put(20, dVar);
        hashMap.put(21, dVar);
        hashMap.put(22, dVar);
        hashMap.put(23, dVar);
        hashMap.put(24, dVar);
        hashMap.put(25, dVar);
        hashMap.put(26, dVar);
        hashMap.put(27, dVar);
        hashMap.put(28, dVar);
        hashMap.put(29, dVar);
        return hashMap;
    }

    private final String k() {
        String format = sDateFormatter.format(new Date(NetConnInfoCenter.getServerTimeMillis()));
        Intrinsics.checkNotNullExpressionValue(format, "sDateFormatter.format(Da\u2026r.getServerTimeMillis()))");
        return format;
    }

    private final List<f> l() {
        List<f> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new f[]{new f(0.0d, 0.0d, 0.0d), new f(0.0d, 0.0d, 0.0d), new f(0.0d, 0.0d, 0.0d)});
        return listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object m(dj djVar, GeneratorParam generatorParam, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        List mutableListOf;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        ImageView imageView = djVar.f442916d;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.guildShareAiLogo");
        ImageView imageView2 = djVar.f442914b;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.guildLogoBottom");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new GuildSearchLLMChatPictureAsyncWorkManager.ImageRemoteResData(imageView, generatorParam.getTitleIconUrl(), "LogoLeftTop", false, 8, null), new GuildSearchLLMChatPictureAsyncWorkManager.ImageRemoteResData(imageView2, "https://downv6.qq.com/innovate/guild/sfeed/guild_long_feed_share_picture_guild_logo.png", "LogoBottom", false, 8, null));
        final long currentTimeMillis = System.currentTimeMillis();
        new GuildSearchLLMChatPictureAsyncWorkManager(generatorParam.getMaxWaitTime(), mutableListOf, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.share.picture.GuildSearchLLMChatPictureGenerator$loadAsyncResources$2$1
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
                logger.d().a("Guild.share.GuildSearchLLMChatPictureGenerator", 1, "loadAsyncResources ok cost: " + (currentTimeMillis2 - j3) + " ms");
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

    public final void n(@NotNull QUIColorfulQRCodeView qrCode) {
        Intrinsics.checkNotNullParameter(qrCode, "qrCode");
        qrCode.q();
        qrCode.e(false);
        qrCode.setIsAdjustDarkLogo(false);
        qrCode.setTargetGenerateQRCodeParams(new com.tencent.mobileqq.component.qrcode.e(3, 29, j(), ErrorCorrectionLevel.Q));
        qrCode.k(-16777216, new c(f217767a.l()));
        qrCode.g(new i(R.drawable.guild_qrcode_logo, null, null, 0));
    }

    public final void o(@NotNull Context context, @NotNull GeneratorParam param, @NotNull Function3<? super Boolean, ? super View, ? super Bitmap, Unit> onResult) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        Logger.f235387a.d().a("Guild.share.GuildSearchLLMChatPictureGenerator", 1, "startGenerate param:" + param);
        GuildContextWrapper guildContextWrapper = new GuildContextWrapper(context, 1001);
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "Guild.share.GuildSearchLLMChatPictureGenerator startShare", null, null, null, new GuildSearchLLMChatPictureGenerator$startGenerate$2(guildContextWrapper, param, onResult, null), 14, null);
        }
    }
}
