package com.tencent.mobileqq.guild.feed.util;

import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.c;
import com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.restorer.media.MediaContentPresetRestorer;
import com.tencent.mobileqq.guild.feed.nativepublish.utils.FeedEditorMediaFormatChecker;
import com.tencent.mobileqq.guild.picload.GuildFeedPicLoader;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002=>B\t\b\u0002\u00a2\u0006\u0004\b;\u0010<J$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J8\u0010\u000e\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J#\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u001a\u0010\u0017\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J<\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0002J \u0010!\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0002H\u0002J\u001d\u0010\"\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\"\u0010#JE\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0018\u00010'j\u0004\u0018\u0001`(0&2\u001c\u0010\u0015\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\rj\u0002`%0$H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b)\u0010*J#\u0010,\u001a\n\u0018\u00010'j\u0004\u0018\u0001`(2\u0006\u0010+\u001a\u00020\u001eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010-Jb\u00106\u001a\u0004\u0018\u0001052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b23\u00104\u001a/\b\u0001\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f03\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010/H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b6\u00107J\u0016\u0010:\u001a\u00020\u00162\u0006\u00108\u001a\u0002052\u0006\u00109\u001a\u00020\u0002\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/RichContentJsonPreProcessor;", "", "", "traceId", "Ljava/util/LinkedList;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "outputMediaList", "", "i", "Lorg/json/JSONObject;", "richContentJsonObject", "Lcom/tencent/mobileqq/guild/feed/util/RichContentJsonPreProcessor$a;", "option", "Lkotlin/Pair;", "j", "", "e", "(Lorg/json/JSONObject;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "source", "k", "Lorg/json/JSONArray;", "images", "", tl.h.F, "maxPhotoSelectCount", "maxVideoSelectCount", "isMediaTypeMutex", "panicMode", "d", "input", "", "property", "size", "o", "g", "(Lorg/json/JSONArray;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/sequences/Sequence;", "Lcom/tencent/mobileqq/guild/feed/util/IndexAndUrl;", "", "Lcom/tencent/libra/request/Option;", "Lcom/tencent/mobileqq/guild/feed/util/DownloadToLocalResult;", DomainData.DOMAIN_NAME, "(Lkotlin/sequences/Sequence;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "url", "f", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "richContentJson", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "errorCode", "Lkotlin/coroutines/Continuation;", "processControlCallback", "Lcom/tencent/mobileqq/guild/feed/util/RichContentJsonPreProcessor$b;", "l", "(ILorg/json/JSONObject;Lcom/tencent/mobileqq/guild/feed/util/RichContentJsonPreProcessor$a;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processResult", "scene", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "()V", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RichContentJsonPreProcessor {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final RichContentJsonPreProcessor f223806a = new RichContentJsonPreProcessor();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0011\u001a\u0004\b\t\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u000e\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0016\u0010\fR\"\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\u0014\u0010\u0012\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/RichContentJsonPreProcessor$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "f", "()Z", "isPanicModeInFilterStep", "b", "c", "needInterceptQRCode", "I", "()I", "maxPhotoSelectCount", "d", "maxVideoSelectCount", "e", "isMediaTypeMutex", "g", "(I)V", "outMediaCheckResultCode", "<init>", "(ZZIIZ)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.util.RichContentJsonPreProcessor$a, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class ProcessOption {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isPanicModeInFilterStep;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean needInterceptQRCode;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int maxPhotoSelectCount;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int maxVideoSelectCount;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isMediaTypeMutex;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int outMediaCheckResultCode;

        public ProcessOption(boolean z16, boolean z17, int i3, int i16, boolean z18) {
            this.isPanicModeInFilterStep = z16;
            this.needInterceptQRCode = z17;
            this.maxPhotoSelectCount = i3;
            this.maxVideoSelectCount = i16;
            this.isMediaTypeMutex = z18;
        }

        /* renamed from: a, reason: from getter */
        public final int getMaxPhotoSelectCount() {
            return this.maxPhotoSelectCount;
        }

        /* renamed from: b, reason: from getter */
        public final int getMaxVideoSelectCount() {
            return this.maxVideoSelectCount;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getNeedInterceptQRCode() {
            return this.needInterceptQRCode;
        }

        /* renamed from: d, reason: from getter */
        public final int getOutMediaCheckResultCode() {
            return this.outMediaCheckResultCode;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsMediaTypeMutex() {
            return this.isMediaTypeMutex;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ProcessOption)) {
                return false;
            }
            ProcessOption processOption = (ProcessOption) other;
            if (this.isPanicModeInFilterStep == processOption.isPanicModeInFilterStep && this.needInterceptQRCode == processOption.needInterceptQRCode && this.maxPhotoSelectCount == processOption.maxPhotoSelectCount && this.maxVideoSelectCount == processOption.maxVideoSelectCount && this.isMediaTypeMutex == processOption.isMediaTypeMutex) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getIsPanicModeInFilterStep() {
            return this.isPanicModeInFilterStep;
        }

        public final void g(int i3) {
            this.outMediaCheckResultCode = i3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        public int hashCode() {
            boolean z16 = this.isPanicModeInFilterStep;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            ?? r26 = this.needInterceptQRCode;
            int i17 = r26;
            if (r26 != 0) {
                i17 = 1;
            }
            int i18 = (((((i16 + i17) * 31) + this.maxPhotoSelectCount) * 31) + this.maxVideoSelectCount) * 31;
            boolean z17 = this.isMediaTypeMutex;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i18 + i3;
        }

        @NotNull
        public String toString() {
            return "ProcessOption(isPanicModeInFilterStep=" + this.isPanicModeInFilterStep + ", needInterceptQRCode=" + this.needInterceptQRCode + ", maxPhotoSelectCount=" + this.maxPhotoSelectCount + ", maxVideoSelectCount=" + this.maxVideoSelectCount + ", isMediaTypeMutex=" + this.isMediaTypeMutex + ")";
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\n\u0010\u0012R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0012R(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0014\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/RichContentJsonPreProcessor$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lorg/json/JSONObject;", "a", "Lorg/json/JSONObject;", "b", "()Lorg/json/JSONObject;", "richContentJsonObject", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Ljava/util/List;", "()Ljava/util/List;", "mediaList", "c", "getOriginMediaList", "originMediaList", "d", "getQrCodeInterceptedList", "(Ljava/util/List;)V", "qrCodeInterceptedList", "<init>", "(Lorg/json/JSONObject;Ljava/util/List;Ljava/util/List;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.util.RichContentJsonPreProcessor$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class RichContentProcessResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final JSONObject richContentJsonObject;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<LocalMediaInfo> mediaList;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<LocalMediaInfo> originMediaList;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<? extends LocalMediaInfo> qrCodeInterceptedList;

        /* JADX WARN: Multi-variable type inference failed */
        public RichContentProcessResult(@NotNull JSONObject richContentJsonObject, @NotNull List<? extends LocalMediaInfo> mediaList, @NotNull List<? extends LocalMediaInfo> originMediaList) {
            List<? extends LocalMediaInfo> emptyList;
            Intrinsics.checkNotNullParameter(richContentJsonObject, "richContentJsonObject");
            Intrinsics.checkNotNullParameter(mediaList, "mediaList");
            Intrinsics.checkNotNullParameter(originMediaList, "originMediaList");
            this.richContentJsonObject = richContentJsonObject;
            this.mediaList = mediaList;
            this.originMediaList = originMediaList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.qrCodeInterceptedList = emptyList;
        }

        @NotNull
        public final List<LocalMediaInfo> a() {
            return this.mediaList;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final JSONObject getRichContentJsonObject() {
            return this.richContentJsonObject;
        }

        public final void c(@NotNull List<? extends LocalMediaInfo> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.qrCodeInterceptedList = list;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RichContentProcessResult)) {
                return false;
            }
            RichContentProcessResult richContentProcessResult = (RichContentProcessResult) other;
            if (Intrinsics.areEqual(this.richContentJsonObject, richContentProcessResult.richContentJsonObject) && Intrinsics.areEqual(this.mediaList, richContentProcessResult.mediaList) && Intrinsics.areEqual(this.originMediaList, richContentProcessResult.originMediaList)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.richContentJsonObject.hashCode() * 31) + this.mediaList.hashCode()) * 31) + this.originMediaList.hashCode();
        }

        @NotNull
        public String toString() {
            return "RichContentProcessResult(richContentJsonObject=" + this.richContentJsonObject + ", mediaList=" + this.mediaList + ", originMediaList=" + this.originMediaList + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "state", "Lcom/tencent/libra/LoadState;", "kotlin.jvm.PlatformType", "option", "Lcom/tencent/libra/request/Option;", "onStateChange"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class c implements IPicLoadStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f223817d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Option> f223818e;

        /* JADX WARN: Multi-variable type inference failed */
        c(Ref.BooleanRef booleanRef, CancellableContinuation<? super Option> cancellableContinuation) {
            this.f223817d = booleanRef;
            this.f223818e = cancellableContinuation;
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public final void onStateChange(LoadState loadState, Option option) {
            if (option != null && !this.f223817d.element) {
                if (loadState.isFinishError()) {
                    QLog.e("RichContentJsonPreProcessor", 1, "[downloadToLocal]: isFinishError,opt.seq=" + option.getSeq());
                    this.f223817d.element = true;
                    this.f223818e.resumeWith(Result.m476constructorimpl(null));
                    return;
                }
                if (!loadState.isDownloadSuccess() && !loadState.isFinishSuccess()) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("RichContentJsonPreProcessor", 4, "[downloadToLocal]: state=" + loadState + ", opt.seq=" + option.getSeq());
                        return;
                    }
                    return;
                }
                this.f223817d.element = true;
                this.f223818e.resumeWith(Result.m476constructorimpl(option));
            }
        }
    }

    RichContentJsonPreProcessor() {
    }

    private final Pair<Boolean, Boolean> d(JSONObject source, int maxPhotoSelectCount, int maxVideoSelectCount, boolean isMediaTypeMutex, boolean panicMode) {
        int i3;
        int i16;
        JSONArray optJSONArray = source.optJSONArray("images");
        boolean z16 = false;
        if (optJSONArray != null) {
            i3 = optJSONArray.length();
        } else {
            i3 = 0;
        }
        JSONArray optJSONArray2 = source.optJSONArray("videos");
        if (optJSONArray2 != null) {
            i16 = optJSONArray2.length();
        } else {
            i16 = 0;
        }
        if (isMediaTypeMutex && i3 > 0 && i16 > 0) {
            QLog.w("RichContentJsonPreProcessor", 1, "[checkMediaCombinationType]:videos and pictures can only be inserted individually");
            return TuplesKt.to(Boolean.FALSE, Boolean.TRUE);
        }
        if (i3 > maxPhotoSelectCount) {
            QLog.w("RichContentJsonPreProcessor", 1, "[checkMediaCombinationType]: imageCount=" + i3 + ", is over limit");
            if (panicMode) {
                return TuplesKt.to(Boolean.FALSE, Boolean.TRUE);
            }
            o(source, "images", maxPhotoSelectCount);
        }
        if (i16 > maxVideoSelectCount) {
            QLog.w("RichContentJsonPreProcessor", 1, "[checkMediaCombinationType]: videoCount=" + i16 + ", is over limit");
            if (panicMode) {
                return TuplesKt.to(Boolean.FALSE, Boolean.TRUE);
            }
            o(source, "videos", maxVideoSelectCount);
        }
        Boolean bool = Boolean.TRUE;
        if (i3 > 0 || i16 > 0) {
            z16 = true;
        }
        return TuplesKt.to(bool, Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(JSONObject jSONObject, int i3, Continuation<? super Boolean> continuation) {
        RichContentJsonPreProcessor$downloadRemoteMediaAndTransformMediaNodeInJson$1 richContentJsonPreProcessor$downloadRemoteMediaAndTransformMediaNodeInJson$1;
        Object coroutine_suspended;
        int i16;
        JSONArray optJSONArray;
        RichContentJsonPreProcessor richContentJsonPreProcessor;
        int i17;
        JSONObject jSONObject2;
        long j3;
        if (continuation instanceof RichContentJsonPreProcessor$downloadRemoteMediaAndTransformMediaNodeInJson$1) {
            richContentJsonPreProcessor$downloadRemoteMediaAndTransformMediaNodeInJson$1 = (RichContentJsonPreProcessor$downloadRemoteMediaAndTransformMediaNodeInJson$1) continuation;
            int i18 = richContentJsonPreProcessor$downloadRemoteMediaAndTransformMediaNodeInJson$1.label;
            if ((i18 & Integer.MIN_VALUE) != 0) {
                richContentJsonPreProcessor$downloadRemoteMediaAndTransformMediaNodeInJson$1.label = i18 - Integer.MIN_VALUE;
                Object obj = richContentJsonPreProcessor$downloadRemoteMediaAndTransformMediaNodeInJson$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = richContentJsonPreProcessor$downloadRemoteMediaAndTransformMediaNodeInJson$1.label;
                if (i16 == 0) {
                    if (i16 == 1) {
                        j3 = richContentJsonPreProcessor$downloadRemoteMediaAndTransformMediaNodeInJson$1.J$0;
                        i17 = richContentJsonPreProcessor$downloadRemoteMediaAndTransformMediaNodeInJson$1.I$0;
                        optJSONArray = (JSONArray) richContentJsonPreProcessor$downloadRemoteMediaAndTransformMediaNodeInJson$1.L$2;
                        jSONObject2 = (JSONObject) richContentJsonPreProcessor$downloadRemoteMediaAndTransformMediaNodeInJson$1.L$1;
                        richContentJsonPreProcessor = (RichContentJsonPreProcessor) richContentJsonPreProcessor$downloadRemoteMediaAndTransformMediaNodeInJson$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Exception e16) {
                            e = e16;
                            i3 = i17;
                            QLog.e("RichContentJsonPreProcessor", 1, "[processRichContentJson]: traceId=" + i3 + ", " + e);
                            return Boxing.boxBoolean(false);
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        optJSONArray = jSONObject.optJSONArray("images");
                        long currentTimeMillis = System.currentTimeMillis();
                        RichContentJsonPreProcessor richContentJsonPreProcessor2 = f223806a;
                        richContentJsonPreProcessor$downloadRemoteMediaAndTransformMediaNodeInJson$1.L$0 = this;
                        richContentJsonPreProcessor$downloadRemoteMediaAndTransformMediaNodeInJson$1.L$1 = jSONObject;
                        richContentJsonPreProcessor$downloadRemoteMediaAndTransformMediaNodeInJson$1.L$2 = optJSONArray;
                        richContentJsonPreProcessor$downloadRemoteMediaAndTransformMediaNodeInJson$1.I$0 = i3;
                        richContentJsonPreProcessor$downloadRemoteMediaAndTransformMediaNodeInJson$1.J$0 = currentTimeMillis;
                        richContentJsonPreProcessor$downloadRemoteMediaAndTransformMediaNodeInJson$1.label = 1;
                        if (richContentJsonPreProcessor2.g(optJSONArray, richContentJsonPreProcessor$downloadRemoteMediaAndTransformMediaNodeInJson$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        richContentJsonPreProcessor = this;
                        i17 = i3;
                        jSONObject2 = jSONObject;
                        j3 = currentTimeMillis;
                    } catch (Exception e17) {
                        e = e17;
                        QLog.e("RichContentJsonPreProcessor", 1, "[processRichContentJson]: traceId=" + i3 + ", " + e);
                        return Boxing.boxBoolean(false);
                    }
                }
                QLog.i("RichContentJsonPreProcessor", 1, "[processRichContentJson]: traceId=" + i17 + ", step: download, cost " + (System.currentTimeMillis() - j3));
                richContentJsonPreProcessor.h(jSONObject2, optJSONArray);
                return Boxing.boxBoolean(true);
            }
        }
        richContentJsonPreProcessor$downloadRemoteMediaAndTransformMediaNodeInJson$1 = new RichContentJsonPreProcessor$downloadRemoteMediaAndTransformMediaNodeInJson$1(this, continuation);
        Object obj2 = richContentJsonPreProcessor$downloadRemoteMediaAndTransformMediaNodeInJson$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = richContentJsonPreProcessor$downloadRemoteMediaAndTransformMediaNodeInJson$1.label;
        if (i16 == 0) {
        }
        QLog.i("RichContentJsonPreProcessor", 1, "[processRichContentJson]: traceId=" + i17 + ", step: download, cost " + (System.currentTimeMillis() - j3));
        richContentJsonPreProcessor.h(jSONObject2, optJSONArray);
        return Boxing.boxBoolean(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f(String str, Continuation<? super Option> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        GuildFeedPicLoader guildFeedPicLoader = GuildFeedPicLoader.f231079a;
        Option url = Option.obtainDownloadOption().setUrl(str);
        Intrinsics.checkNotNullExpressionValue(url, "obtainDownloadOption().setUrl(url)");
        guildFeedPicLoader.d(url, new c(booleanRef, cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g(JSONArray jSONArray, Continuation<? super Unit> continuation) {
        RichContentJsonPreProcessor$execDownloadAndTransformImageJSONArray$1 richContentJsonPreProcessor$execDownloadAndTransformImageJSONArray$1;
        Object coroutine_suspended;
        int i3;
        Sequence<Pair<Integer, String>> mapIndexedNotNull;
        String str;
        if (continuation instanceof RichContentJsonPreProcessor$execDownloadAndTransformImageJSONArray$1) {
            richContentJsonPreProcessor$execDownloadAndTransformImageJSONArray$1 = (RichContentJsonPreProcessor$execDownloadAndTransformImageJSONArray$1) continuation;
            int i16 = richContentJsonPreProcessor$execDownloadAndTransformImageJSONArray$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                richContentJsonPreProcessor$execDownloadAndTransformImageJSONArray$1.label = i16 - Integer.MIN_VALUE;
                Object obj = richContentJsonPreProcessor$execDownloadAndTransformImageJSONArray$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = richContentJsonPreProcessor$execDownloadAndTransformImageJSONArray$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        jSONArray = (JSONArray) richContentJsonPreProcessor$execDownloadAndTransformImageJSONArray$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        mapIndexedNotNull = SequencesKt___SequencesKt.mapIndexedNotNull(yl1.i.f450608a.a(jSONArray), new Function2<Integer, JSONObject, Pair<? extends Integer, ? extends String>>() { // from class: com.tencent.mobileqq.guild.feed.util.RichContentJsonPreProcessor$execDownloadAndTransformImageJSONArray$downloadRecords$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends String> invoke(Integer num, JSONObject jSONObject) {
                                return invoke(num.intValue(), jSONObject);
                            }

                            @Nullable
                            public final Pair<Integer, String> invoke(int i17, @Nullable JSONObject jSONObject) {
                                String optString;
                                if (jSONObject == null || (optString = jSONObject.optString("picUrl")) == null) {
                                    return null;
                                }
                                if (!QAlbumUtil.isNetUrl(optString)) {
                                    optString = null;
                                }
                                if (optString != null) {
                                    return TuplesKt.to(Integer.valueOf(i17), optString);
                                }
                                return null;
                            }
                        });
                        richContentJsonPreProcessor$execDownloadAndTransformImageJSONArray$1.L$0 = jSONArray;
                        richContentJsonPreProcessor$execDownloadAndTransformImageJSONArray$1.label = 1;
                        obj = n(mapIndexedNotNull, richContentJsonPreProcessor$execDownloadAndTransformImageJSONArray$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        return Unit.INSTANCE;
                    }
                }
                Map map = (Map) obj;
                QLog.d("RichContentJsonPreProcessor", 1, "[execDownloadAndTransformImageJSONArray]: downloadRecords.size=" + map.size());
                int i17 = 0;
                for (JSONObject jSONObject : yl1.i.f450608a.a(jSONArray)) {
                    int i18 = i17 + 1;
                    if (i17 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 != null) {
                        Option option = (Option) map.get(Boxing.boxInt(i17));
                        if (option != null) {
                            str = option.getLocalPath();
                        } else {
                            str = null;
                        }
                        jSONObject2.putOpt("picUrl", str);
                    }
                    i17 = i18;
                }
                return Unit.INSTANCE;
            }
        }
        richContentJsonPreProcessor$execDownloadAndTransformImageJSONArray$1 = new RichContentJsonPreProcessor$execDownloadAndTransformImageJSONArray$1(this, continuation);
        Object obj2 = richContentJsonPreProcessor$execDownloadAndTransformImageJSONArray$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = richContentJsonPreProcessor$execDownloadAndTransformImageJSONArray$1.label;
        if (i3 == 0) {
        }
        Map map2 = (Map) obj2;
        QLog.d("RichContentJsonPreProcessor", 1, "[execDownloadAndTransformImageJSONArray]: downloadRecords.size=" + map2.size());
        int i172 = 0;
        while (r5.hasNext()) {
        }
        return Unit.INSTANCE;
    }

    private final void h(JSONObject richContentJsonObject, JSONArray images) {
        if (images != null && images.length() > 0) {
            yl1.i iVar = yl1.i.f450608a;
            JSONArray b16 = iVar.b(images, new Function2<Integer, JSONObject, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.util.RichContentJsonPreProcessor$filterIllegalImageNodeAndReplaceToHost$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num, JSONObject jSONObject) {
                    return invoke(num.intValue(), jSONObject);
                }

                @NotNull
                public final Boolean invoke(int i3, @NotNull JSONObject image) {
                    Intrinsics.checkNotNullParameter(image, "image");
                    String optString = image.optString("picUrl");
                    return Boolean.valueOf(!(optString == null || optString.length() == 0));
                }
            });
            if (iVar.h(b16)) {
                richContentJsonObject.remove("images");
            } else {
                richContentJsonObject.put("images", b16);
            }
        }
    }

    private final List<LocalMediaInfo> i(int traceId, LinkedList<LocalMediaInfo> outputMediaList) {
        long currentTimeMillis = System.currentTimeMillis();
        List<LocalMediaInfo> b16 = FeedEditorMediaFormatChecker.f222314a.b(outputMediaList);
        QLog.i("RichContentJsonPreProcessor", 1, "[processRichContentJson]: traceId=" + traceId + " step: filter out media list contains qrcode, cost " + (System.currentTimeMillis() - currentTimeMillis) + ", qrCodeList.size=" + b16.size());
        Iterator<T> it = b16.iterator();
        while (it.hasNext()) {
            outputMediaList.remove((LocalMediaInfo) it.next());
        }
        return b16;
    }

    private final Pair<LinkedList<LocalMediaInfo>, List<LocalMediaInfo>> j(int traceId, JSONObject richContentJsonObject, ProcessOption option) {
        LinkedList linkedList;
        LinkedList linkedList2 = new LinkedList();
        long currentTimeMillis = System.currentTimeMillis();
        Pair<List<LocalMediaInfo>, Integer> g16 = new MediaContentPresetRestorer(traceId).g(richContentJsonObject);
        List<LocalMediaInfo> component1 = g16.component1();
        if (g16.component2().intValue() == 1) {
            option.g(3);
        } else {
            FeedEditorMediaFormatChecker feedEditorMediaFormatChecker = FeedEditorMediaFormatChecker.f222314a;
            if (option.getIsPanicModeInFilterStep()) {
                linkedList = null;
            } else {
                linkedList = linkedList2;
            }
            option.g(feedEditorMediaFormatChecker.a(component1, linkedList));
        }
        if (option.getIsPanicModeInFilterStep() && option.getOutMediaCheckResultCode() == 0) {
            linkedList2.addAll(component1);
        }
        QLog.i("RichContentJsonPreProcessor", 1, "[processRichContentJson]: traceId=" + traceId + " step: read and check, cost " + (System.currentTimeMillis() - currentTimeMillis) + ", mediaList.size=" + component1.size() + ", outputList.size=" + linkedList2.size());
        return TuplesKt.to(linkedList2, component1);
    }

    private final JSONObject k(JSONObject source) {
        c.C7754c c7754c = c.C7754c.f220907a;
        return new JSONObject(source, new String[]{"title", "contents", "images", "videos", "third_bar", "media_lock_count"});
    }

    private final Object n(Sequence<Pair<Integer, String>> sequence, Continuation<? super Map<Integer, ? extends Option>> continuation) {
        return CoroutineScopeKt.coroutineScope(new RichContentJsonPreProcessor$transferRemoteContentToLocal$2(sequence, null), continuation);
    }

    private final void o(JSONObject input, String property, int size) {
        JSONArray optJSONArray;
        int length;
        if (size < 0 || (optJSONArray = input.optJSONArray(property)) == null || size > optJSONArray.length() - 1) {
            return;
        }
        while (true) {
            optJSONArray.remove(length);
            if (length != size) {
                length--;
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0262 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x021b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01bc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0165 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0185 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object l(int i3, @NotNull JSONObject jSONObject, @NotNull ProcessOption processOption, @Nullable Function2<? super Integer, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super RichContentProcessResult> continuation) {
        RichContentJsonPreProcessor$processMediaNodeInRichContentJson$1 richContentJsonPreProcessor$processMediaNodeInRichContentJson$1;
        Object obj;
        Object coroutine_suspended;
        int i16;
        boolean z16;
        ProcessOption processOption2;
        int i17;
        RichContentJsonPreProcessor richContentJsonPreProcessor;
        JSONObject jSONObject2;
        RichContentJsonPreProcessor richContentJsonPreProcessor2;
        List emptyList;
        List emptyList2;
        boolean z17;
        Object e16;
        RichContentJsonPreProcessor richContentJsonPreProcessor3;
        JSONObject jSONObject3;
        RichContentJsonPreProcessor richContentJsonPreProcessor4;
        boolean z18;
        ProcessOption processOption3;
        Function2<? super Integer, ? super Continuation<? super Boolean>, ? extends Object> function22;
        JSONObject jSONObject4;
        LinkedList<LocalMediaInfo> component1;
        List<LocalMediaInfo> component2;
        JSONObject jSONObject5;
        RichContentJsonPreProcessor richContentJsonPreProcessor5;
        ProcessOption processOption4;
        LinkedList<LocalMediaInfo> linkedList;
        boolean z19;
        RichContentProcessResult richContentProcessResult;
        List<LocalMediaInfo> i18;
        RichContentProcessResult richContentProcessResult2;
        JSONObject jSONObject6 = jSONObject;
        Function2<? super Integer, ? super Continuation<? super Boolean>, ? extends Object> function23 = function2;
        if (continuation instanceof RichContentJsonPreProcessor$processMediaNodeInRichContentJson$1) {
            richContentJsonPreProcessor$processMediaNodeInRichContentJson$1 = (RichContentJsonPreProcessor$processMediaNodeInRichContentJson$1) continuation;
            int i19 = richContentJsonPreProcessor$processMediaNodeInRichContentJson$1.label;
            if ((i19 & Integer.MIN_VALUE) != 0) {
                richContentJsonPreProcessor$processMediaNodeInRichContentJson$1.label = i19 - Integer.MIN_VALUE;
                RichContentJsonPreProcessor$processMediaNodeInRichContentJson$1 richContentJsonPreProcessor$processMediaNodeInRichContentJson$12 = richContentJsonPreProcessor$processMediaNodeInRichContentJson$1;
                obj = richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.label;
                boolean z26 = false;
                if (i16 != 0) {
                    ResultKt.throwOnFailure(obj);
                    JSONObject k3 = k(jSONObject6);
                    JSONObject jSONObject7 = k3;
                    Pair<Boolean, Boolean> d16 = d(k3, processOption.getMaxPhotoSelectCount(), processOption.getMaxVideoSelectCount(), processOption.getIsMediaTypeMutex(), false);
                    boolean booleanValue = d16.component1().booleanValue();
                    if (!d16.component2().booleanValue()) {
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                        return new RichContentProcessResult(jSONObject6, emptyList, emptyList2);
                    }
                    if (booleanValue) {
                        z16 = true;
                        processOption2 = processOption;
                        i17 = i3;
                        richContentJsonPreProcessor = this;
                        richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$0 = richContentJsonPreProcessor;
                        richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$1 = jSONObject6;
                        richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$2 = processOption2;
                        richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$3 = function23;
                        richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$4 = jSONObject7;
                        richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.I$0 = i17;
                        richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.label = 2;
                        e16 = richContentJsonPreProcessor.e(jSONObject7, i17, richContentJsonPreProcessor$processMediaNodeInRichContentJson$12);
                        if (e16 != coroutine_suspended) {
                        }
                    } else if (function23 != null) {
                        Integer boxInt = Boxing.boxInt(1);
                        richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$0 = this;
                        richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$1 = jSONObject6;
                        richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$2 = processOption;
                        richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$3 = function23;
                        richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$4 = jSONObject7;
                        richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.I$0 = i3;
                        z16 = true;
                        richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.label = 1;
                        obj = function23.invoke(boxInt, richContentJsonPreProcessor$processMediaNodeInRichContentJson$12);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        processOption2 = processOption;
                        i17 = i3;
                        richContentJsonPreProcessor2 = this;
                        jSONObject2 = jSONObject7;
                    } else {
                        z16 = true;
                        processOption2 = processOption;
                        i17 = i3;
                        richContentJsonPreProcessor = this;
                        jSONObject2 = jSONObject7;
                        z17 = false;
                        if (!z17) {
                            return null;
                        }
                        jSONObject7 = jSONObject2;
                        richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$0 = richContentJsonPreProcessor;
                        richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$1 = jSONObject6;
                        richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$2 = processOption2;
                        richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$3 = function23;
                        richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$4 = jSONObject7;
                        richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.I$0 = i17;
                        richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.label = 2;
                        e16 = richContentJsonPreProcessor.e(jSONObject7, i17, richContentJsonPreProcessor$processMediaNodeInRichContentJson$12);
                        if (e16 != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        richContentJsonPreProcessor3 = richContentJsonPreProcessor;
                        obj = e16;
                        jSONObject3 = jSONObject7;
                        if (((Boolean) obj).booleanValue()) {
                        }
                    }
                } else if (i16 == 1) {
                    i17 = richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.I$0;
                    jSONObject2 = (JSONObject) richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$4;
                    Function2<? super Integer, ? super Continuation<? super Boolean>, ? extends Object> function24 = (Function2) richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$3;
                    processOption2 = (ProcessOption) richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$2;
                    jSONObject6 = (JSONObject) richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$1;
                    RichContentJsonPreProcessor richContentJsonPreProcessor6 = (RichContentJsonPreProcessor) richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    function23 = function24;
                    z16 = true;
                    richContentJsonPreProcessor2 = richContentJsonPreProcessor6;
                } else if (i16 == 2) {
                    i17 = richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.I$0;
                    jSONObject3 = (JSONObject) richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$4;
                    Function2<? super Integer, ? super Continuation<? super Boolean>, ? extends Object> function25 = (Function2) richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$3;
                    processOption2 = (ProcessOption) richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$2;
                    jSONObject6 = (JSONObject) richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$1;
                    RichContentJsonPreProcessor richContentJsonPreProcessor7 = (RichContentJsonPreProcessor) richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    function23 = function25;
                    z16 = true;
                    richContentJsonPreProcessor3 = richContentJsonPreProcessor7;
                    if (((Boolean) obj).booleanValue()) {
                        if (function23 != null) {
                            Integer boxInt2 = Boxing.boxInt(3);
                            richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$0 = richContentJsonPreProcessor3;
                            richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$1 = jSONObject6;
                            richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$2 = processOption2;
                            richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$3 = function23;
                            richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$4 = jSONObject3;
                            richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.I$0 = i17;
                            richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.label = 3;
                            obj = function23.invoke(boxInt2, richContentJsonPreProcessor$processMediaNodeInRichContentJson$12);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            if (((Boolean) obj).booleanValue() == z16) {
                            }
                        }
                        richContentJsonPreProcessor4 = richContentJsonPreProcessor3;
                        z18 = false;
                        if (!z18) {
                        }
                        JSONObject jSONObject8 = jSONObject6;
                        processOption3 = processOption2;
                        function22 = function23;
                        jSONObject4 = jSONObject8;
                        Pair<LinkedList<LocalMediaInfo>, List<LocalMediaInfo>> j3 = richContentJsonPreProcessor4.j(i17, jSONObject3, processOption3);
                        component1 = j3.component1();
                        component2 = j3.component2();
                        if (component1.size() == component2.size()) {
                        }
                        if (function22 == null) {
                        }
                    } else {
                        richContentJsonPreProcessor4 = richContentJsonPreProcessor3;
                        JSONObject jSONObject82 = jSONObject6;
                        processOption3 = processOption2;
                        function22 = function23;
                        jSONObject4 = jSONObject82;
                        Pair<LinkedList<LocalMediaInfo>, List<LocalMediaInfo>> j36 = richContentJsonPreProcessor4.j(i17, jSONObject3, processOption3);
                        component1 = j36.component1();
                        component2 = j36.component2();
                        if (component1.size() == component2.size()) {
                        }
                        if (function22 == null) {
                        }
                    }
                } else if (i16 == 3) {
                    i17 = richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.I$0;
                    jSONObject3 = (JSONObject) richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$4;
                    Function2<? super Integer, ? super Continuation<? super Boolean>, ? extends Object> function26 = (Function2) richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$3;
                    processOption2 = (ProcessOption) richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$2;
                    jSONObject6 = (JSONObject) richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$1;
                    RichContentJsonPreProcessor richContentJsonPreProcessor8 = (RichContentJsonPreProcessor) richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    function23 = function26;
                    z16 = true;
                    richContentJsonPreProcessor3 = richContentJsonPreProcessor8;
                    if (((Boolean) obj).booleanValue() == z16) {
                        richContentJsonPreProcessor4 = richContentJsonPreProcessor3;
                        z18 = z16;
                        if (!z18) {
                            return null;
                        }
                        JSONObject jSONObject822 = jSONObject6;
                        processOption3 = processOption2;
                        function22 = function23;
                        jSONObject4 = jSONObject822;
                        Pair<LinkedList<LocalMediaInfo>, List<LocalMediaInfo>> j362 = richContentJsonPreProcessor4.j(i17, jSONObject3, processOption3);
                        component1 = j362.component1();
                        component2 = j362.component2();
                        if (component1.size() == component2.size() || processOption3.getOutMediaCheckResultCode() != 0) {
                            if (function22 == null) {
                                Integer boxInt3 = Boxing.boxInt(4);
                                richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$0 = richContentJsonPreProcessor4;
                                richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$1 = jSONObject4;
                                richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$2 = processOption3;
                                richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$3 = function22;
                                richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$4 = component1;
                                richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$5 = component2;
                                richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.I$0 = i17;
                                richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.label = 4;
                                Object invoke = function22.invoke(boxInt3, richContentJsonPreProcessor$processMediaNodeInRichContentJson$12);
                                if (invoke == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                richContentJsonPreProcessor5 = richContentJsonPreProcessor4;
                                obj = invoke;
                                jSONObject5 = jSONObject4;
                                if (((Boolean) obj).booleanValue() != z16) {
                                }
                            } else {
                                jSONObject5 = jSONObject4;
                                processOption4 = processOption3;
                                linkedList = component1;
                                z19 = false;
                                if (!z19) {
                                }
                            }
                        }
                        richContentProcessResult = new RichContentProcessResult(jSONObject4, component1, component2);
                        if (processOption3.getNeedInterceptQRCode()) {
                        }
                        return richContentProcessResult;
                    }
                    richContentJsonPreProcessor4 = richContentJsonPreProcessor3;
                    z18 = false;
                    if (!z18) {
                    }
                    JSONObject jSONObject8222 = jSONObject6;
                    processOption3 = processOption2;
                    function22 = function23;
                    jSONObject4 = jSONObject8222;
                    Pair<LinkedList<LocalMediaInfo>, List<LocalMediaInfo>> j3622 = richContentJsonPreProcessor4.j(i17, jSONObject3, processOption3);
                    component1 = j3622.component1();
                    component2 = j3622.component2();
                    if (component1.size() == component2.size()) {
                    }
                    if (function22 == null) {
                    }
                } else {
                    if (i16 != 4) {
                        if (i16 != 5) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        i18 = (List) richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$1;
                        richContentProcessResult2 = (RichContentProcessResult) richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        z16 = true;
                        richContentProcessResult = richContentProcessResult2;
                        if (((Boolean) obj).booleanValue() == z16) {
                            z26 = z16;
                        }
                        if (!z26) {
                            return null;
                        }
                        richContentProcessResult.c(i18);
                        return richContentProcessResult;
                    }
                    i17 = richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.I$0;
                    component2 = (List) richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$5;
                    LinkedList<LocalMediaInfo> linkedList2 = (LinkedList) richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$4;
                    function22 = (Function2) richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$3;
                    processOption3 = (ProcessOption) richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$2;
                    jSONObject4 = (JSONObject) richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$1;
                    richContentJsonPreProcessor5 = (RichContentJsonPreProcessor) richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    component1 = linkedList2;
                    z16 = true;
                    jSONObject5 = jSONObject4;
                    if (((Boolean) obj).booleanValue() != z16) {
                        richContentJsonPreProcessor4 = richContentJsonPreProcessor5;
                        processOption4 = processOption3;
                        linkedList = component1;
                        z19 = z16;
                        if (!z19) {
                            return null;
                        }
                        component1 = linkedList;
                        processOption3 = processOption4;
                        jSONObject4 = jSONObject5;
                        richContentProcessResult = new RichContentProcessResult(jSONObject4, component1, component2);
                        if (processOption3.getNeedInterceptQRCode()) {
                            i18 = richContentJsonPreProcessor4.i(i17, component1);
                            if (i18.isEmpty() ^ z16) {
                                if (function22 != null) {
                                    Integer boxInt4 = Boxing.boxInt(2);
                                    richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$0 = richContentProcessResult;
                                    richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$1 = i18;
                                    richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$2 = null;
                                    richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$3 = null;
                                    richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$4 = null;
                                    richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.L$5 = null;
                                    richContentJsonPreProcessor$processMediaNodeInRichContentJson$12.label = 5;
                                    obj = function22.invoke(boxInt4, richContentJsonPreProcessor$processMediaNodeInRichContentJson$12);
                                    if (obj == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    richContentProcessResult2 = richContentProcessResult;
                                    richContentProcessResult = richContentProcessResult2;
                                    if (((Boolean) obj).booleanValue() == z16) {
                                    }
                                }
                                if (!z26) {
                                }
                            }
                            richContentProcessResult.c(i18);
                        }
                        return richContentProcessResult;
                    }
                    richContentJsonPreProcessor4 = richContentJsonPreProcessor5;
                    processOption4 = processOption3;
                    linkedList = component1;
                    z19 = false;
                    if (!z19) {
                    }
                }
                if (((Boolean) obj).booleanValue() != z16) {
                    richContentJsonPreProcessor = richContentJsonPreProcessor2;
                    z17 = z16;
                    if (!z17) {
                    }
                } else {
                    richContentJsonPreProcessor = richContentJsonPreProcessor2;
                    z17 = false;
                    if (!z17) {
                    }
                }
            }
        }
        richContentJsonPreProcessor$processMediaNodeInRichContentJson$1 = new RichContentJsonPreProcessor$processMediaNodeInRichContentJson$1(this, continuation);
        RichContentJsonPreProcessor$processMediaNodeInRichContentJson$1 richContentJsonPreProcessor$processMediaNodeInRichContentJson$122 = richContentJsonPreProcessor$processMediaNodeInRichContentJson$1;
        obj = richContentJsonPreProcessor$processMediaNodeInRichContentJson$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = richContentJsonPreProcessor$processMediaNodeInRichContentJson$122.label;
        boolean z262 = false;
        if (i16 != 0) {
        }
        if (((Boolean) obj).booleanValue() != z16) {
        }
    }

    public final void m(@NotNull RichContentProcessResult processResult, int scene) {
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(processResult, "processResult");
        JSONObject richContentJsonObject = processResult.getRichContentJsonObject();
        if (scene != 2) {
            if (scene == 3) {
                richContentJsonObject.put("feed_source_type", 13);
                QQToastUtil.showQQToastInUiThread(0, "\u5c0f\u7a0b\u5e8f\u5df2\u9000\u5230\u540e\u53f0");
            }
        } else {
            richContentJsonObject.put("feed_source_type", 12);
        }
        if (richContentJsonObject.has("media_lock_count")) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(richContentJsonObject.optInt("media_lock_count"), processResult.a().size());
            richContentJsonObject.put("media_lock_count", coerceAtMost);
        }
    }
}
