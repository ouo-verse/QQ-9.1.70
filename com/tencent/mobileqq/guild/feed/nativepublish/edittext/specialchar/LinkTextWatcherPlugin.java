package com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar;

import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.aio.input.at.utils.AtTroopMemberSpan;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.feed.link.LinkApi;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.SpecialCharDetectTextWatcher;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.cg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBatchTransThirdPlatformURLItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBatchTransThirdPlatformURLReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBatchTransThirdPlatformURLRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00ab\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r*\u0001\u0013\u0018\u0000 c2\u00020\u0001:\u0002%dB\u000f\u0012\u0006\u0010.\u001a\u00020+\u00a2\u0006\u0004\ba\u0010bJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J \u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J)\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0014\u001a\u00020\u00132\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J2\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J \u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J>\u0010$\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0016J\b\u0010%\u001a\u00020\u0010H\u0016J(\u0010(\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0006H\u0016J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010*\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R$\u00106\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010<\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020908078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010?\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b=\u0010>R$\u0010E\u001a\u0012\u0012\u0004\u0012\u00020A0@j\b\u0012\u0004\u0012\u00020A`B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u001b\u0010K\u001a\u00020F8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR0\u0010P\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00170Lj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0017`M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR$\u0010W\u001a\u00020Q2\u0006\u0010R\u001a\u00020Q8\u0016@RX\u0096\u000e\u00a2\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020X078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010]\u001a\u00020Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010TR\u0016\u0010`\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/LinkTextWatcherPlugin;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/SpecialCharDetectTextWatcher$b;", "Landroid/text/Editable;", "text", "", "potentialLink", "", "startIndex", "endIndex", "Lkotlinx/coroutines/Job;", "y", "fullContent", HippyTKDListViewAdapter.X, "", "Lsk1/b;", "matchedSpans", "", "o", "(Landroid/text/Editable;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/LinkTextWatcherPlugin$c", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/util/List;Landroid/text/Editable;)Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/LinkTextWatcherPlugin$c;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProBatchTransThirdPlatformURLItem;", "map", ReportConstant.COSTREPORT_PREFIX, "start", "end", "v", "p", "", "source", "Landroid/text/Spanned;", "dest", "dstart", "dend", "filter", "a", "before", "count", "onTextChanged", "afterTextChanged", "w", "Landroidx/lifecycle/LifecycleCoroutineScope;", "f", "Landroidx/lifecycle/LifecycleCoroutineScope;", "scope", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/LinkTextWatcherPlugin$a;", tl.h.F, "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/LinkTextWatcherPlugin$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/LinkTextWatcherPlugin$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/LinkTextWatcherPlugin$a;)V", "callback", "", "Ljava/lang/Class;", "Landroid/text/style/CharacterStyle;", "i", "[Ljava/lang/Class;", "barrierSpans", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "validURLChars", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/HashSet;", "goodCharSet", "Lcom/tencent/mobileqq/guild/feed/link/LinkApi;", "D", "Lkotlin/Lazy;", "r", "()Lcom/tencent/mobileqq/guild/feed/link/LinkApi;", "linkApi", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "E", "Ljava/util/HashMap;", "urlCache", "", "<set-?>", UserInfo.SEX_FEMALE, "Z", "d", "()Z", "isActivatable", "Landroid/text/InputFilter;", "G", "[Landroid/text/InputFilter;", "inputFilters", "H", "isPasting", "I", "Ljava/lang/CharSequence;", "pastedContent", "<init>", "(Landroidx/lifecycle/LifecycleCoroutineScope;)V", "J", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class LinkTextWatcherPlugin extends SpecialCharDetectTextWatcher.b {
    private static final Pattern K = Pattern.compile(cg.f307524c.pattern() + "|" + cg.f307525d.pattern());

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final HashSet<Character> goodCharSet;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy linkApi;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, GProBatchTransThirdPlatformURLItem> urlCache;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isActivatable;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final InputFilter[] inputFilters;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isPasting;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private CharSequence pastedContent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleCoroutineScope scope;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a callback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Class<? extends CharacterStyle>[] barrierSpans;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String validURLChars;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u001e\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00030\u0002H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/LinkTextWatcherPlugin$a;", "", "", "Lkotlin/Triple;", "Lsk1/b;", "", "", ForwardMiniChooseFriendOption.RESULT_LIST, "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface a {
        void a(@NotNull List<Triple<sk1.b, String, Integer>> results);
    }

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004J*\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0014J\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0003H\u0014\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/edittext/specialchar/LinkTextWatcherPlugin$c", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/framework/RequestSenderCallback;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProBatchTransThirdPlatformURLReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProBatchTransThirdPlatformURLRsp;", "Lcom/tencent/mobileqq/guild/feed/link/UrlInfoRequestCallback;", "", "result", "", "errMsg", "req", "rsp", "", tl.h.F, "i", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends RequestSenderCallback<GProBatchTransThirdPlatformURLReq, GProBatchTransThirdPlatformURLRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<sk1.b> f221927b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ LinkTextWatcherPlugin f221928c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Editable f221929d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(List<sk1.b> list, LinkTextWatcherPlugin linkTextWatcherPlugin, Editable editable) {
            super(true);
            this.f221927b = list;
            this.f221928c = linkTextWatcherPlugin;
            this.f221929d = editable;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void f(int result, @NotNull String errMsg, @NotNull GProBatchTransThirdPlatformURLReq req, @Nullable GProBatchTransThirdPlatformURLRsp rsp) {
            int collectionSizeOrDefault;
            Set set;
            Triple triple;
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Intrinsics.checkNotNullParameter(req, "req");
            List<sk1.b> list = this.f221927b;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((sk1.b) it.next()).getUrl());
            }
            set = CollectionsKt___CollectionsKt.toSet(arrayList);
            QLog.e("LinkTextWatcherPlugin", 1, "[batchTransThirdPlatformURL] code: " + result + ", err: " + errMsg + " urls:" + set);
            List<sk1.b> list2 = this.f221927b;
            Editable editable = this.f221929d;
            ArrayList arrayList2 = new ArrayList();
            for (sk1.b bVar : list2) {
                int spanStart = editable.getSpanStart(bVar);
                int spanEnd = editable.getSpanEnd(bVar);
                if (spanStart != -1 && spanEnd != -1) {
                    triple = new Triple(bVar, bVar.getUrl(), 0);
                } else {
                    QLog.d("LinkTextWatcherPlugin", 1, "[batchTransThirdPlatformURL] Link skip for url=" + bVar.getUrl() + " : span missing");
                    triple = null;
                }
                if (triple != null) {
                    arrayList2.add(triple);
                }
            }
            a callback = this.f221928c.getCallback();
            if (callback != null) {
                callback.a(arrayList2);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(@NotNull GProBatchTransThirdPlatformURLReq req, @NotNull GProBatchTransThirdPlatformURLRsp rsp) {
            int collectionSizeOrDefault;
            int mapCapacity;
            int coerceAtLeast;
            boolean z16;
            Intrinsics.checkNotNullParameter(req, "req");
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            ArrayList<GProBatchTransThirdPlatformURLItem> arrayList = rsp.items;
            Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.items");
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
            for (Object obj : arrayList) {
                linkedHashMap.put(((GProBatchTransThirdPlatformURLItem) obj).url, obj);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                String str = ((GProBatchTransThirdPlatformURLItem) entry.getValue()).displayText;
                Intrinsics.checkNotNullExpressionValue(str, "it.value.displayText");
                if (str.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            LinkTextWatcherPlugin linkTextWatcherPlugin = this.f221928c;
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                HashMap hashMap = linkTextWatcherPlugin.urlCache;
                Object key = entry2.getKey();
                Intrinsics.checkNotNullExpressionValue(key, "it.key");
                Object value = entry2.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "it.value");
                hashMap.put(key, value);
            }
            this.f221928c.s(this.f221929d, this.f221927b, linkedHashMap);
        }
    }

    public LinkTextWatcherPlugin(@NotNull LifecycleCoroutineScope scope) {
        Lazy lazy;
        List list;
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
        this.barrierSpans = new Class[]{sk1.b.class, AtTroopMemberSpan.class, EmoticonSpan.class};
        this.validURLChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-._~:/?#[]@!$&'()*+,;=%";
        HashSet<Character> hashSet = new HashSet<>();
        this.goodCharSet = hashSet;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<LinkApi>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.LinkTextWatcherPlugin$linkApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinkApi invoke() {
                return new LinkApi();
            }
        });
        this.linkApi = lazy;
        this.urlCache = new HashMap<>();
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-._~:/?#[]@!$&'()*+,;=%".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        list = ArraysKt___ArraysKt.toList(charArray);
        hashSet.addAll(list);
        this.inputFilters = new InputFilter[]{new InputFilter() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.h
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
                CharSequence t16;
                t16 = LinkTextWatcherPlugin.t(LinkTextWatcherPlugin.this, charSequence, i3, i16, spanned, i17, i18);
                return t16;
            }
        }, new InputFilter() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.i
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
                CharSequence u16;
                u16 = LinkTextWatcherPlugin.u(LinkTextWatcherPlugin.this, charSequence, i3, i16, spanned, i17, i18);
                return u16;
            }
        }};
        this.pastedContent = "";
    }

    private final c A(List<sk1.b> matchedSpans, Editable text) {
        return new c(matchedSpans, this, text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object o(Editable editable, List<sk1.b> list, Continuation<? super Unit> continuation) {
        LinkTextWatcherPlugin$applyLinkSpans$1 linkTextWatcherPlugin$applyLinkSpans$1;
        Object coroutine_suspended;
        int i3;
        int collectionSizeOrDefault;
        Set set;
        LinkTextWatcherPlugin linkTextWatcherPlugin;
        if (continuation instanceof LinkTextWatcherPlugin$applyLinkSpans$1) {
            linkTextWatcherPlugin$applyLinkSpans$1 = (LinkTextWatcherPlugin$applyLinkSpans$1) continuation;
            int i16 = linkTextWatcherPlugin$applyLinkSpans$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                linkTextWatcherPlugin$applyLinkSpans$1.label = i16 - Integer.MIN_VALUE;
                Object obj = linkTextWatcherPlugin$applyLinkSpans$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = linkTextWatcherPlugin$applyLinkSpans$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        linkTextWatcherPlugin = (LinkTextWatcherPlugin) linkTextWatcherPlugin$applyLinkSpans$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (list.isEmpty()) {
                        return Unit.INSTANCE;
                    }
                    List<sk1.b> list2 = list;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : list2) {
                        if (!this.urlCache.containsKey(((sk1.b) obj2).getUrl())) {
                            arrayList.add(obj2);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj3 : list2) {
                        if (this.urlCache.containsKey(((sk1.b) obj3).getUrl())) {
                            arrayList2.add(obj3);
                        }
                    }
                    if (!arrayList2.isEmpty()) {
                        s(editable, arrayList2, this.urlCache);
                        QLog.e("LinkTextWatcherPlugin", 1, "[applyLinkSpans] cache hit " + arrayList2.size() + " spans");
                    }
                    if (!arrayList.isEmpty()) {
                        LinkApi r16 = r();
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            arrayList3.add(((sk1.b) it.next()).getUrl());
                        }
                        set = CollectionsKt___CollectionsKt.toSet(arrayList3);
                        c A = A(arrayList, editable);
                        linkTextWatcherPlugin$applyLinkSpans$1.L$0 = this;
                        linkTextWatcherPlugin$applyLinkSpans$1.label = 1;
                        if (r16.a(set, A, linkTextWatcherPlugin$applyLinkSpans$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        linkTextWatcherPlugin = this;
                    } else {
                        this.isActivatable = false;
                        return Unit.INSTANCE;
                    }
                }
                linkTextWatcherPlugin.isActivatable = false;
                return Unit.INSTANCE;
            }
        }
        linkTextWatcherPlugin$applyLinkSpans$1 = new LinkTextWatcherPlugin$applyLinkSpans$1(this, continuation);
        Object obj4 = linkTextWatcherPlugin$applyLinkSpans$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = linkTextWatcherPlugin$applyLinkSpans$1.label;
        if (i3 == 0) {
        }
        linkTextWatcherPlugin.isActivatable = false;
        return Unit.INSTANCE;
    }

    private final int p(final Editable text, int startIndex) {
        String joinToString$default;
        Integer num;
        int i3;
        List list;
        int i16 = startIndex - 1;
        while (true) {
            if (i16 >= 0) {
                if (!this.goodCharSet.contains(Character.valueOf(text.charAt(i16)))) {
                    Class<? extends CharacterStyle>[] clsArr = this.barrierSpans;
                    ArrayList arrayList = new ArrayList();
                    for (Class<? extends CharacterStyle> cls : clsArr) {
                        Object[] spans = text.getSpans(i16, startIndex + 1, cls);
                        Intrinsics.checkNotNullExpressionValue(spans, "text.getSpans(current, startIndex + 1, it)");
                        list = ArraysKt___ArraysKt.toList(spans);
                        CollectionsKt__MutableCollectionsKt.addAll(arrayList, list);
                    }
                    joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", null, null, 0, null, new Function1<CharacterStyle, CharSequence>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.LinkTextWatcherPlugin$findFirstNonMatchingChar$spanDescriptions$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final CharSequence invoke(CharacterStyle characterStyle) {
                            return characterStyle.getClass().getSimpleName() + "@" + text.getSpanStart(characterStyle) + " to " + text.getSpanEnd(characterStyle);
                        }
                    }, 30, null);
                    Iterator it = arrayList.iterator();
                    if (!it.hasNext()) {
                        num = null;
                    } else {
                        Integer valueOf = Integer.valueOf(text.getSpanEnd((CharacterStyle) it.next()));
                        while (it.hasNext()) {
                            Integer valueOf2 = Integer.valueOf(text.getSpanEnd((CharacterStyle) it.next()));
                            if (valueOf.compareTo(valueOf2) < 0) {
                                valueOf = valueOf2;
                            }
                        }
                        num = valueOf;
                    }
                    Integer num2 = num;
                    QLog.d("LinkTextWatcherPlugin", 1, "[match] Non-matching character found at index " + i16 + ",Spans: [" + joinToString$default + "]");
                    if (arrayList.isEmpty()) {
                        int i17 = i16 + 1;
                        QLog.d("LinkTextWatcherPlugin", 1, "[match] No spans found. Returning index " + i17);
                        return i17;
                    }
                    if (num2 != null) {
                        i3 = RangesKt___RangesKt.coerceAtMost(num2.intValue(), startIndex);
                    } else {
                        i3 = startIndex;
                    }
                    QLog.d("LinkTextWatcherPlugin", 1, "[match] Spans found. Returning max span end " + i3);
                    return i3;
                }
                i16--;
            } else {
                QLog.d("LinkTextWatcherPlugin", 1, "[match] No non-matching character found. Returning 0");
                return 0;
            }
        }
    }

    private final LinkApi r() {
        return (LinkApi) this.linkApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(Editable text, List<sk1.b> matchedSpans, Map<String, GProBatchTransThirdPlatformURLItem> map) {
        a aVar;
        String displayText;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = matchedSpans.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            sk1.b bVar = (sk1.b) it.next();
            GProBatchTransThirdPlatformURLItem gProBatchTransThirdPlatformURLItem = map.get(bVar.getUrl());
            Triple triple = null;
            if (gProBatchTransThirdPlatformURLItem != null) {
                int spanStart = text.getSpanStart(bVar);
                int spanEnd = text.getSpanEnd(bVar);
                if (spanStart != -1 && spanEnd != -1) {
                    String str = gProBatchTransThirdPlatformURLItem.displayText;
                    if (str != null && str.length() != 0) {
                        z16 = false;
                    }
                    if (z16) {
                        displayText = gProBatchTransThirdPlatformURLItem.url;
                    } else {
                        displayText = gProBatchTransThirdPlatformURLItem.displayText;
                    }
                    Intrinsics.checkNotNullExpressionValue(displayText, "displayText");
                    triple = new Triple(bVar, displayText, Integer.valueOf(gProBatchTransThirdPlatformURLItem.iconType));
                } else {
                    QLog.d("LinkTextWatcherPlugin", 1, "Link skip for url=" + bVar.getUrl() + " : span missing");
                }
            }
            if (triple != null) {
                arrayList.add(triple);
            }
        }
        if ((!arrayList.isEmpty()) && (aVar = this.callback) != null) {
            aVar.a(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence t(LinkTextWatcherPlugin this$0, CharSequence source, int i3, int i16, Spanned spanned, int i17, int i18) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(source, "source");
        if (source.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return source;
        }
        Object[] spans = spanned.getSpans(i17, i18, sk1.b.class);
        Intrinsics.checkNotNullExpressionValue(spans, "dest.getSpans(dstart, dend, LinkSpan::class.java)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : spans) {
            sk1.b bVar = (sk1.b) obj;
            int spanStart = spanned.getSpanStart(bVar);
            int spanEnd = spanned.getSpanEnd(bVar);
            if (i17 <= spanStart && i18 >= spanEnd) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            Editable editable = this$0.b().get();
            if (editable != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    editable.removeSpan((sk1.b) it.next());
                }
            }
            return source;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final CharSequence u(LinkTextWatcherPlugin this$0, CharSequence source, int i3, int i16, Spanned spanned, int i17, int i18) {
        boolean z16;
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(source, "source");
        if (source.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return source;
        }
        sk1.b[] spans = (sk1.b[]) spanned.getSpans(i17, i18, sk1.b.class);
        if (spans != null) {
            if (spans.length == 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!z18) {
                z17 = false;
                if (!z17) {
                    return source;
                }
                QLog.d("LinkTextWatcherPlugin", 1, "[spanDeletion] dest Start: " + i17 + ", dest End: " + i18);
                Intrinsics.checkNotNullExpressionValue(spans, "spans");
                for (sk1.b bVar : spans) {
                    int spanStart = spanned.getSpanStart(bVar);
                    int spanEnd = spanned.getSpanEnd(bVar);
                    if (i17 > spanStart || i18 < spanEnd) {
                        Editable editable = this$0.b().get();
                        if (editable != null) {
                            Selection.removeSelection(editable);
                            Selection.setSelection(editable, spanStart, spanEnd);
                        }
                        QLog.d("LinkTextWatcherPlugin", 1, "[spanDeletion] Selection does not cover the entire LinkSpan. add selection and Blocking modification.");
                        return spanned.subSequence(i17, i18);
                    }
                }
                return source;
            }
        }
        z17 = true;
        if (!z17) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final sk1.b v(Editable text, int start, int end) {
        sk1.b bVar = new sk1.b(text.subSequence(start, end).toString(), null, null, 0, 14, null);
        Object[] spans = text.getSpans(start, end, yn1.b.class);
        Intrinsics.checkNotNullExpressionValue(spans, "text.getSpans(start, end\u2026torTopicSpan::class.java)");
        for (Object obj : spans) {
            text.removeSpan((yn1.b) obj);
        }
        text.setSpan(bVar, start, end, 33);
        return bVar;
    }

    private final Job x(Editable text, String fullContent, int startIndex) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new LinkTextWatcherPlugin$processMultipleLinks$1(fullContent, text, startIndex, this, null), 3, null);
        return launch$default;
    }

    private final Job y(Editable text, String potentialLink, int startIndex, int endIndex) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new LinkTextWatcherPlugin$processSingleLink$1(text, startIndex, endIndex, potentialLink, this, null), 3, null);
        return launch$default;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.SpecialCharDetectTextWatcher.b
    public void a() {
        QLog.d("LinkTextWatcherPlugin", 4, "[beforePaste] isPasting = true");
        this.isPasting = true;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.SpecialCharDetectTextWatcher.b, android.text.TextWatcher
    public void afterTextChanged(@NotNull Editable text) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(text, "text");
        int selectionEnd = Selection.getSelectionEnd(text) - 1;
        isBlank = StringsKt__StringsJVMKt.isBlank(this.pastedContent);
        if (!isBlank) {
            QLog.d("LinkTextWatcherPlugin", 4, "checking pasted content");
            String obj = this.pastedContent.toString();
            this.pastedContent = "";
            x(text, obj, (selectionEnd + 1) - obj.length());
            QLog.d("LinkTextWatcherPlugin", 4, "done checking pasted content");
            return;
        }
        if (selectionEnd >= 0) {
            if (text.charAt(selectionEnd) == ' ' || text.charAt(selectionEnd) == '\n') {
                QLog.d("LinkTextWatcherPlugin", 4, "checking space trigger content");
                int p16 = p(text, selectionEnd);
                y(text, text.subSequence(p16, selectionEnd).toString(), p16, selectionEnd);
                QLog.d("LinkTextWatcherPlugin", 4, "done checking space trigger content");
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.SpecialCharDetectTextWatcher.b
    /* renamed from: d, reason: from getter */
    public boolean getIsActivatable() {
        return this.isActivatable;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.SpecialCharDetectTextWatcher.b, android.text.InputFilter
    @Nullable
    public CharSequence filter(@Nullable CharSequence source, int start, int end, @Nullable Spanned dest, int dstart, int dend) {
        for (InputFilter inputFilter : this.inputFilters) {
            CharSequence filter = inputFilter.filter(source, start, end, dest, dstart, dend);
            if (filter != source) {
                return filter;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.SpecialCharDetectTextWatcher.b, android.text.TextWatcher
    public void onTextChanged(@NotNull CharSequence text, int start, int before, int count) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(text, "text");
        super.onTextChanged(text, start, before, count);
        if (this.isPasting) {
            this.isPasting = false;
            if (count > 0) {
                charSequence = text.subSequence(start, count + start);
            } else {
                charSequence = "";
            }
            this.pastedContent = charSequence;
            QLog.d("LinkTextWatcherPlugin", 4, "update pasted content, length=" + charSequence.length());
        }
    }

    @Nullable
    /* renamed from: q, reason: from getter */
    public final a getCallback() {
        return this.callback;
    }

    @NotNull
    public final Job w(@NotNull Editable text) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(text, "text");
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new LinkTextWatcherPlugin$parseUnRichLinkSpan$1(text, this, null), 3, null);
        return launch$default;
    }

    public final void z(@Nullable a aVar) {
        this.callback = aVar;
    }
}
