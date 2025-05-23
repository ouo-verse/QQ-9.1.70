package com.tencent.mobileqq.aio.msg.data;

import android.net.Uri;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.aio.input.d;
import com.tencent.mobileqq.aio.input.f;
import com.tencent.mobileqq.aio.utils.y;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.aio.msg.element.AIOElementType;
import com.tencent.qqnt.kernel.nativeinterface.FaceBubbleElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.qqnt.msg.data.g;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b7\u00108Jo\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\u001b\b\u0002\u0010\u0011\u001a\u0015\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r\u00a2\u0006\u0002\b\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0006JB\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bJT\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\b2\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001d2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\bJ\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010$\u001a\u00020#J8\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010\u00042\u0006\u0010'\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010\u0002J$\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u00132\b\u0010-\u001a\u0004\u0018\u00010,J\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u00100\u001a\u00020/J\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u00100\u001a\u000202J\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u00100\u001a\u000204J\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0017\u001a\u00020\u0002\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/data/b;", "", "", "originPath", "Landroid/net/Uri;", "originUri", "", CustomImageProps.QUALITY, "", QCircleLpReportDc010001.KEY_SUBTYPE, "textSummary", "Lcom/tencent/qqnt/msg/data/g;", "picExtBizInfo", "Lkotlin/Function1;", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$e;", "", "Lkotlin/ExtensionFunctionType;", "ext", "isFlashPic", "", "Lcom/tencent/mobileqq/aio/msg/data/a;", "b", "k", "path", "", "duration", "audioType", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "audioData", "isVoiceChange", "isAutoConvertText", "voiceChangeType", "d", "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "marketFaceMessage", "a", "mediaUri", "businessType", "thumbPath", "e", "Lcom/tencent/mobileqq/aio/input/f$e;", "texts", "Lcom/tencent/mobileqq/aio/input/d;", "replyData", "j", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "g", "Lcom/tencent/qqnt/kernel/nativeinterface/FaceBubbleElement;", h.F, "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$j;", "f", "i", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final b f190166a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57532);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            f190166a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ List c(b bVar, String str, Uri uri, boolean z16, int i3, String str2, g gVar, Function1 function1, boolean z17, int i16, Object obj) {
        int i17;
        String str3;
        g gVar2;
        Function1 function12;
        boolean z18;
        if ((i16 & 8) != 0) {
            i17 = 0;
        } else {
            i17 = i3;
        }
        if ((i16 & 16) != 0) {
            str3 = null;
        } else {
            str3 = str2;
        }
        if ((i16 & 32) != 0) {
            gVar2 = null;
        } else {
            gVar2 = gVar;
        }
        if ((i16 & 64) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        if ((i16 & 128) != 0) {
            z18 = false;
        } else {
            z18 = z17;
        }
        return bVar.b(str, uri, z16, i17, str3, gVar2, function12, z18);
    }

    public static /* synthetic */ a l(b bVar, String str, Uri uri, boolean z16, int i3, String str2, g gVar, int i16, Object obj) {
        String str3;
        g gVar2;
        if ((i16 & 8) != 0) {
            i3 = 0;
        }
        int i17 = i3;
        if ((i16 & 16) != 0) {
            str3 = null;
        } else {
            str3 = str2;
        }
        if ((i16 & 32) != 0) {
            gVar2 = null;
        } else {
            gVar2 = gVar;
        }
        return bVar.k(str, uri, z16, i17, str3, gVar2);
    }

    @NotNull
    public final List<a> a(@NotNull MarkFaceMessage marketFaceMessage) {
        List<a> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this, (Object) marketFaceMessage);
        }
        Intrinsics.checkNotNullParameter(marketFaceMessage, "marketFaceMessage");
        a aVar = new a(11, 0, 2, null);
        aVar.p(new AIOElementType.d(marketFaceMessage));
        listOf = CollectionsKt__CollectionsJVMKt.listOf(aVar);
        return listOf;
    }

    @NotNull
    public final List<a> b(@NotNull String originPath, @Nullable Uri originUri, boolean r18, int r19, @Nullable String textSummary, @Nullable g picExtBizInfo, @Nullable Function1<? super AIOElementType.e, Unit> ext, boolean isFlashPic) {
        List<a> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, this, originPath, originUri, Boolean.valueOf(r18), Integer.valueOf(r19), textSummary, picExtBizInfo, ext, Boolean.valueOf(isFlashPic));
        }
        Intrinsics.checkNotNullParameter(originPath, "originPath");
        a aVar = new a(2, 0, 2, null);
        AIOElementType.e eVar = new AIOElementType.e(originPath, originUri, r18, r19, textSummary, 300.0f, picExtBizInfo, null, isFlashPic, 128, null);
        if (ext != null) {
            ext.invoke(eVar);
        }
        aVar.q(eVar);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(aVar);
        return listOf;
    }

    @NotNull
    public final List<a> d(@NotNull String path, float duration, int audioType, @NotNull ArrayList<Byte> audioData, boolean isVoiceChange, boolean isAutoConvertText, int voiceChangeType) {
        List<a> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, this, path, Float.valueOf(duration), Integer.valueOf(audioType), audioData, Boolean.valueOf(isVoiceChange), Boolean.valueOf(isAutoConvertText), Integer.valueOf(voiceChangeType));
        }
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(audioData, "audioData");
        a aVar = new a(4, 0, 2, null);
        aVar.r(new AIOElementType.f(path, duration, audioType, audioData, isVoiceChange, isAutoConvertText, voiceChangeType));
        listOf = CollectionsKt__CollectionsJVMKt.listOf(aVar);
        return listOf;
    }

    @NotNull
    public final List<a> e(@NotNull String originPath, @Nullable Uri mediaUri, int businessType, boolean r152, @Nullable String thumbPath) {
        List<a> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, this, originPath, mediaUri, Integer.valueOf(businessType), Boolean.valueOf(r152), thumbPath);
        }
        Intrinsics.checkNotNullParameter(originPath, "originPath");
        a aVar = new a(5, 0, 2, null);
        aVar.u(new AIOElementType.i(originPath, mediaUri, businessType, r152, thumbPath, null, 32, null));
        listOf = CollectionsKt__CollectionsJVMKt.listOf(aVar);
        return listOf;
    }

    @NotNull
    public final List<a> f(@NotNull AIOElementType.j r18) {
        List<a> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this, (Object) r18);
        }
        Intrinsics.checkNotNullParameter(r18, "item");
        a aVar = new a(1, 0, 2, null);
        aVar.t(new AIOElementType.h(r18.a(), 0, 0L, 0L, null, 30, null));
        aVar.v(r18);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(aVar);
        return listOf;
    }

    @NotNull
    public final List<a> g(@NotNull AIOElementType.b r65) {
        List<a> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this, (Object) r65);
        }
        Intrinsics.checkNotNullParameter(r65, "item");
        a aVar = new a(6, 0, 2, null);
        aVar.m(r65);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(aVar);
        return listOf;
    }

    @NotNull
    public final List<a> h(@NotNull FaceBubbleElement item) {
        List<a> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this, (Object) item);
        }
        Intrinsics.checkNotNullParameter(item, "item");
        a aVar = new a(27, 0, 2, null);
        aVar.l(new AIOElementType.a(item));
        listOf = CollectionsKt__CollectionsJVMKt.listOf(aVar);
        return listOf;
    }

    @NotNull
    public final List<a> i(@NotNull String path) {
        List<a> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, (Object) this, (Object) path);
        }
        Intrinsics.checkNotNullParameter(path, "path");
        a aVar = new a(3, 0, 2, null);
        aVar.n(new AIOElementType.c(path));
        listOf = CollectionsKt__CollectionsJVMKt.listOf(aVar);
        return listOf;
    }

    @NotNull
    public final List<a> j(@NotNull List<? extends f.e> texts, @Nullable d replyData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this, (Object) texts, (Object) replyData);
        }
        Intrinsics.checkNotNullParameter(texts, "texts");
        ArrayList arrayList = new ArrayList();
        if (replyData != null) {
            a aVar = new a(7, 0, 2, null);
            aVar.s(new AIOElementType.g(replyData.a(), replyData.b(), replyData.c(), replyData.d()));
            arrayList.add(aVar);
        }
        if (!texts.isEmpty()) {
            for (f.e eVar : texts) {
                if (eVar instanceof f.d) {
                    f.d dVar = (f.d) eVar;
                    arrayList.addAll(c(this, dVar.g(), dVar.f(), dVar.h(), 0, null, null, null, false, 248, null));
                } else {
                    arrayList.addAll(y.f194180a.b(eVar));
                }
            }
        }
        return arrayList;
    }

    @NotNull
    public final a k(@NotNull String originPath, @Nullable Uri originUri, boolean r17, int r18, @Nullable String textSummary, @Nullable g picExtBizInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, this, originPath, originUri, Boolean.valueOf(r17), Integer.valueOf(r18), textSummary, picExtBizInfo);
        }
        Intrinsics.checkNotNullParameter(originPath, "originPath");
        a aVar = new a(2, 0, 2, null);
        aVar.q(new AIOElementType.e(originPath, originUri, r17, r18, textSummary, 300.0f, picExtBizInfo, null, false, MsgConstant.KRMFILETHUMBSIZE384, null));
        return aVar;
    }
}
