package kotlin.text;

import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.WasExperimental;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010\u0011\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001f\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0086\u0002\u001a\u001f\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0086\u0002\u001a\u0015\u0010\u0012\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0087\n\u001a\u0018\u0010\u0017\u001a\u00020\u0010*\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u0018\u0010\u0018\u001a\u00020\u0010*\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u001c\u0010\u0019\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010\u0019\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a:\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001aE\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0010H\u0002\u00a2\u0006\u0002\b!\u001a:\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\u001c*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010#\u001a\u00020\u0010*\u00020\u00022\u0006\u0010$\u001a\u00020\u0006\u001a7\u0010%\u001a\u0002H&\"\f\b\u0000\u0010'*\u00020\u0002*\u0002H&\"\u0004\b\u0001\u0010&*\u0002H'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H&0)H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010*\u001a7\u0010+\u001a\u0002H&\"\f\b\u0000\u0010'*\u00020\u0002*\u0002H&\"\u0004\b\u0001\u0010&*\u0002H'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H&0)H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010*\u001a&\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a;\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010 \u001a\u00020\u0010H\u0002\u00a2\u0006\u0002\b.\u001a&\u0010,\u001a\u00020\u0006*\u00020\u00022\u0006\u0010/\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u00100\u001a\u00020\u0006*\u00020\u00022\u0006\u00101\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a,\u00100\u001a\u00020\u0006*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\r\u00103\u001a\u00020\u0010*\u00020\u0002H\u0087\b\u001a\r\u00104\u001a\u00020\u0010*\u00020\u0002H\u0087\b\u001a\r\u00105\u001a\u00020\u0010*\u00020\u0002H\u0087\b\u001a \u00106\u001a\u00020\u0010*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a \u00107\u001a\u00020\u0010*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u00108\u001a\u000209*\u00020\u0002H\u0086\u0002\u001a&\u0010:\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u0010:\u001a\u00020\u0006*\u00020\u00022\u0006\u0010/\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a&\u0010;\u001a\u00020\u0006*\u00020\u00022\u0006\u00101\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a,\u0010;\u001a\u00020\u0006*\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0010\u0010<\u001a\b\u0012\u0004\u0012\u00020\r0=*\u00020\u0002\u001a\u0010\u0010>\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u0002\u001a\u0015\u0010@\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0087\f\u001a\u000f\u0010A\u001a\u00020\r*\u0004\u0018\u00010\rH\u0087\b\u001a\u001c\u0010B\u001a\u00020\u0002*\u00020\u00022\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0014\u001a\u001c\u0010B\u001a\u00020\r*\u00020\r2\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0014\u001a\u001c\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0014\u001a\u001c\u0010E\u001a\u00020\r*\u00020\r2\u0006\u0010C\u001a\u00020\u00062\b\b\u0002\u0010D\u001a\u00020\u0014\u001aG\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00010=*\u00020\u00022\u000e\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0H2\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\bI\u0010J\u001a=\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00010=*\u00020\u00022\u0006\u0010G\u001a\u0002022\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0002\u00a2\u0006\u0002\bI\u001a4\u0010K\u001a\u00020\u0010*\u00020\u00022\u0006\u0010L\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010M\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u0012\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010O\u001a\u00020\u0002\u001a\u0012\u0010N\u001a\u00020\r*\u00020\r2\u0006\u0010O\u001a\u00020\u0002\u001a\u001a\u0010P\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006\u001a\u0012\u0010P\u001a\u00020\u0002*\u00020\u00022\u0006\u0010Q\u001a\u00020\u0001\u001a\u001d\u0010P\u001a\u00020\r*\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010P\u001a\u00020\r*\u00020\r2\u0006\u0010Q\u001a\u00020\u0001H\u0087\b\u001a\u0012\u0010R\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010R\u001a\u00020\r*\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010S\u001a\u00020\u0002*\u00020\u00022\u0006\u0010T\u001a\u00020\u0002\u001a\u001a\u0010S\u001a\u00020\u0002*\u00020\u00022\u0006\u0010O\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u0012\u0010S\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u0002\u001a\u001a\u0010S\u001a\u00020\r*\u00020\r2\u0006\u0010O\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a.\u0010U\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0014\b\b\u0010V\u001a\u000e\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020\u00020WH\u0087\b\u00f8\u0001\u0000\u001a\u001d\u0010U\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\rH\u0087\b\u001a$\u0010Z\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010Z\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010\\\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010\\\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010]\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010]\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010^\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a$\u0010^\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001d\u0010_\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\rH\u0087\b\u001a)\u0010`\u001a\u00020\r*\u00020\r2\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140WH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\ba\u001a)\u0010`\u001a\u00020\r*\u00020\r2\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00020WH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\bb\u001a\"\u0010c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u0002\u001a\u001a\u0010c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010Q\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0002\u001a%\u0010c\u001a\u00020\r*\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u0002H\u0087\b\u001a\u001d\u0010c\u001a\u00020\r*\u00020\r2\u0006\u0010Q\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0002H\u0087\b\u001a=\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\u0012\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0H\"\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0002\u0010e\u001a0\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\n\u0010G\u001a\u000202\"\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u001a/\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\u0006\u0010T\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0006H\u0002\u00a2\u0006\u0002\bf\u001a%\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0?*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0087\b\u001a=\u0010g\u001a\b\u0012\u0004\u0012\u00020\r0=*\u00020\u00022\u0012\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0H\"\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0002\u0010h\u001a0\u0010g\u001a\b\u0012\u0004\u0012\u00020\r0=*\u00020\u00022\n\u0010G\u001a\u000202\"\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u001a%\u0010g\u001a\b\u0012\u0004\u0012\u00020\r0=*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0087\b\u001a\u001c\u0010i\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010i\u001a\u00020\u0010*\u00020\u00022\u0006\u0010O\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a$\u0010i\u001a\u00020\u0010*\u00020\u00022\u0006\u0010O\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u0012\u0010j\u001a\u00020\u0002*\u00020\u00022\u0006\u0010Q\u001a\u00020\u0001\u001a\u001d\u0010j\u001a\u00020\u0002*\u00020\r2\u0006\u0010k\u001a\u00020\u00062\u0006\u0010l\u001a\u00020\u0006H\u0087\b\u001a\u001f\u0010m\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010-\u001a\u00020\u0006H\u0087\b\u001a\u0012\u0010m\u001a\u00020\r*\u00020\u00022\u0006\u0010Q\u001a\u00020\u0001\u001a\u0012\u0010m\u001a\u00020\r*\u00020\r2\u0006\u0010Q\u001a\u00020\u0001\u001a\u001c\u0010n\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010n\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010o\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010o\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010p\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010p\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010q\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\u00142\b\b\u0002\u0010[\u001a\u00020\r\u001a\u001c\u0010q\u001a\u00020\r*\u00020\r2\u0006\u0010T\u001a\u00020\r2\b\b\u0002\u0010[\u001a\u00020\r\u001a\f\u0010r\u001a\u00020\u0010*\u00020\rH\u0007\u001a\u0013\u0010s\u001a\u0004\u0018\u00010\u0010*\u00020\rH\u0007\u00a2\u0006\u0002\u0010t\u001a\n\u0010u\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010u\u001a\u00020\u0002*\u00020\u00022\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\b\u00f8\u0001\u0000\u001a\u0016\u0010u\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010u\u001a\u00020\r*\u00020\rH\u0087\b\u001a$\u0010u\u001a\u00020\r*\u00020\r2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\b\u00f8\u0001\u0000\u001a\u0016\u0010u\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\u001a\n\u0010w\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010w\u001a\u00020\u0002*\u00020\u00022\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\b\u00f8\u0001\u0000\u001a\u0016\u0010w\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010w\u001a\u00020\r*\u00020\rH\u0087\b\u001a$\u0010w\u001a\u00020\r*\u00020\r2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\b\u00f8\u0001\u0000\u001a\u0016\u0010w\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\u001a\n\u0010x\u001a\u00020\u0002*\u00020\u0002\u001a$\u0010x\u001a\u00020\u0002*\u00020\u00022\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\b\u00f8\u0001\u0000\u001a\u0016\u0010x\u001a\u00020\u0002*\u00020\u00022\n\u00101\u001a\u000202\"\u00020\u0014\u001a\r\u0010x\u001a\u00020\r*\u00020\rH\u0087\b\u001a$\u0010x\u001a\u00020\r*\u00020\r2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100WH\u0086\b\u00f8\u0001\u0000\u001a\u0016\u0010x\u001a\u00020\r*\u00020\r2\n\u00101\u001a\u000202\"\u00020\u0014\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006y"}, d2 = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "requireNonNegativeLimit", "", "limit", "commonPrefixWith", "", "other", "ignoreCase", "", "commonSuffixWith", "contains", WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR, "", "regex", "Lkotlin/text/Regex;", "contentEqualsIgnoreCaseImpl", "contentEqualsImpl", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", "index", "ifBlank", BdhLogUtil.LogTag.Tag_Req, BdhLogUtil.LogTag.Tag_Conn, RemoteHandleConst.PARAM_DEFAULT_VALUE, "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", HippyControllerProps.STRING, "indexOfAny", "chars", "", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", DownloaderConstant.KEY_RANGE, "removeSuffix", "removeSurrounding", "delimiter", SQLiteDatabase.OPERATE_TYPE_REPLACE, "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceFirstChar", "replaceFirstCharWithChar", "replaceFirstCharWithCharSequence", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "toBooleanStrict", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes28.dex */
public class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    @NotNull
    public static final String commonPrefixWith(@NotNull CharSequence charSequence, @NotNull CharSequence other, boolean z16) {
        boolean equals;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(charSequence.length(), other.length());
        int i3 = 0;
        while (i3 < min) {
            equals = CharsKt__CharKt.equals(charSequence.charAt(i3), other.charAt(i3), z16);
            if (!equals) {
                break;
            }
            i3++;
        }
        int i16 = i3 - 1;
        if (hasSurrogatePairAt(charSequence, i16) || hasSurrogatePairAt(other, i16)) {
            i3--;
        }
        return charSequence.subSequence(0, i3).toString();
    }

    public static /* synthetic */ String commonPrefixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return commonPrefixWith(charSequence, charSequence2, z16);
    }

    @NotNull
    public static final String commonSuffixWith(@NotNull CharSequence charSequence, @NotNull CharSequence other, boolean z16) {
        boolean equals;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = charSequence.length();
        int min = Math.min(length, other.length());
        int i3 = 0;
        while (i3 < min) {
            equals = CharsKt__CharKt.equals(charSequence.charAt((length - i3) - 1), other.charAt((r1 - i3) - 1), z16);
            if (!equals) {
                break;
            }
            i3++;
        }
        if (hasSurrogatePairAt(charSequence, (length - i3) - 1) || hasSurrogatePairAt(other, (r1 - i3) - 1)) {
            i3--;
        }
        return charSequence.subSequence(length - i3, length).toString();
    }

    public static /* synthetic */ String commonSuffixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return commonSuffixWith(charSequence, charSequence2, z16);
    }

    public static boolean contains(@NotNull CharSequence charSequence, @NotNull CharSequence other, boolean z16) {
        int indexOf$default;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (other instanceof String) {
            indexOf$default = indexOf$default(charSequence, (String) other, 0, z16, 2, (Object) null);
            if (indexOf$default >= 0) {
                return true;
            }
        } else if (indexOf$StringsKt__StringsKt$default(charSequence, other, 0, charSequence.length(), z16, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, CharSequence charSequence2, boolean z16, int i3, Object obj) {
        boolean contains;
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        contains = contains(charSequence, charSequence2, z16);
        return contains;
    }

    public static final boolean contentEqualsIgnoreCaseImpl(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        boolean equals;
        boolean equals2;
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            equals2 = StringsKt__StringsJVMKt.equals((String) charSequence, (String) charSequence2, true);
            return equals2;
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i3 = 0; i3 < length; i3++) {
            equals = CharsKt__CharKt.equals(charSequence.charAt(i3), charSequence2.charAt(i3), true);
            if (!equals) {
                return false;
            }
        }
        return true;
    }

    public static final boolean contentEqualsImpl(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return Intrinsics.areEqual(charSequence, charSequence2);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (charSequence.charAt(i3) != charSequence2.charAt(i3)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean endsWith(@NotNull CharSequence charSequence, char c16, boolean z16) {
        int lastIndex;
        boolean equals;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() > 0) {
            lastIndex = getLastIndex(charSequence);
            equals = CharsKt__CharKt.equals(charSequence.charAt(lastIndex), c16, z16);
            if (equals) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, char c16, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return endsWith(charSequence, c16, z16);
    }

    @Nullable
    public static final Pair<Integer, String> findAnyOf(@NotNull CharSequence charSequence, @NotNull Collection<String> strings, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        return findAnyOf$StringsKt__StringsKt(charSequence, strings, i3, z16, false);
    }

    public static final Pair<Integer, String> findAnyOf$StringsKt__StringsKt(CharSequence charSequence, Collection<String> collection, int i3, boolean z16, boolean z17) {
        int lastIndex;
        int coerceAtMost;
        IntProgression downTo;
        Object obj;
        Object obj2;
        boolean regionMatches;
        int coerceAtLeast;
        Object single;
        if (!z16 && collection.size() == 1) {
            single = CollectionsKt___CollectionsKt.single(collection);
            String str = (String) single;
            int indexOf$default = !z17 ? indexOf$default(charSequence, str, i3, false, 4, (Object) null) : lastIndexOf$default(charSequence, str, i3, false, 4, (Object) null);
            if (indexOf$default < 0) {
                return null;
            }
            return TuplesKt.to(Integer.valueOf(indexOf$default), str);
        }
        if (z17) {
            lastIndex = getLastIndex(charSequence);
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i3, lastIndex);
            downTo = RangesKt___RangesKt.downTo(coerceAtMost, 0);
        } else {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3, 0);
            downTo = new IntRange(coerceAtLeast, charSequence.length());
        }
        if (charSequence instanceof String) {
            int first = downTo.getFirst();
            int last = downTo.getLast();
            int step = downTo.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj2 = it.next();
                            String str2 = (String) obj2;
                            regionMatches = StringsKt__StringsJVMKt.regionMatches(str2, 0, (String) charSequence, first, str2.length(), z16);
                            if (regionMatches) {
                                break;
                            }
                        } else {
                            obj2 = null;
                            break;
                        }
                    }
                    String str3 = (String) obj2;
                    if (str3 != null) {
                        return TuplesKt.to(Integer.valueOf(first), str3);
                    }
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            int first2 = downTo.getFirst();
            int last2 = downTo.getLast();
            int step2 = downTo.getStep();
            if ((step2 > 0 && first2 <= last2) || (step2 < 0 && last2 <= first2)) {
                while (true) {
                    Iterator<T> it5 = collection.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            obj = it5.next();
                            String str4 = (String) obj;
                            if (regionMatchesImpl(str4, 0, charSequence, first2, str4.length(), z16)) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    String str5 = (String) obj;
                    if (str5 != null) {
                        return TuplesKt.to(Integer.valueOf(first2), str5);
                    }
                    if (first2 == last2) {
                        break;
                    }
                    first2 += step2;
                }
            }
        }
        return null;
    }

    public static /* synthetic */ Pair findAnyOf$default(CharSequence charSequence, Collection collection, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        return findAnyOf(charSequence, collection, i3, z16);
    }

    @Nullable
    public static final Pair<Integer, String> findLastAnyOf(@NotNull CharSequence charSequence, @NotNull Collection<String> strings, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        return findAnyOf$StringsKt__StringsKt(charSequence, strings, i3, z16, true);
    }

    public static /* synthetic */ Pair findLastAnyOf$default(CharSequence charSequence, Collection collection, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = getLastIndex(charSequence);
        }
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        return findLastAnyOf(charSequence, collection, i3, z16);
    }

    @NotNull
    public static IntRange getIndices(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return new IntRange(0, charSequence.length() - 1);
    }

    public static int getLastIndex(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final boolean hasSurrogatePairAt(@NotNull CharSequence charSequence, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (!new IntRange(0, charSequence.length() - 2).contains(i3) || !Character.isHighSurrogate(charSequence.charAt(i3)) || !Character.isLowSurrogate(charSequence.charAt(i3 + 1))) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <C extends CharSequence & R, R> R ifBlank(C c16, Function0<? extends R> defaultValue) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        isBlank = StringsKt__StringsJVMKt.isBlank(c16);
        if (isBlank) {
            return defaultValue.invoke();
        }
        return c16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <C extends CharSequence & R, R> R ifEmpty(C c16, Function0<? extends R> defaultValue) {
        boolean z16;
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if (c16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return defaultValue.invoke();
        }
        return c16;
    }

    public static final int indexOf(@NotNull CharSequence charSequence, char c16, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (!z16 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c16, i3);
        }
        return indexOfAny(charSequence, new char[]{c16}, i3, z16);
    }

    private static final int indexOf$StringsKt__StringsKt(CharSequence charSequence, CharSequence charSequence2, int i3, int i16, boolean z16, boolean z17) {
        int lastIndex;
        int coerceAtMost;
        int coerceAtLeast;
        IntProgression downTo;
        boolean regionMatches;
        int coerceAtLeast2;
        int coerceAtMost2;
        if (z17) {
            lastIndex = getLastIndex(charSequence);
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i3, lastIndex);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i16, 0);
            downTo = RangesKt___RangesKt.downTo(coerceAtMost, coerceAtLeast);
        } else {
            coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(i3, 0);
            coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(i16, charSequence.length());
            downTo = new IntRange(coerceAtLeast2, coerceAtMost2);
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int first = downTo.getFirst();
            int last = downTo.getLast();
            int step = downTo.getStep();
            if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
                return -1;
            }
            while (true) {
                regionMatches = StringsKt__StringsJVMKt.regionMatches((String) charSequence2, 0, (String) charSequence, first, charSequence2.length(), z16);
                if (regionMatches) {
                    return first;
                }
                if (first != last) {
                    first += step;
                } else {
                    return -1;
                }
            }
        } else {
            int first2 = downTo.getFirst();
            int last2 = downTo.getLast();
            int step2 = downTo.getStep();
            if ((step2 > 0 && first2 <= last2) || (step2 < 0 && last2 <= first2)) {
                while (!regionMatchesImpl(charSequence2, 0, charSequence, first2, charSequence2.length(), z16)) {
                    if (first2 != last2) {
                        first2 += step2;
                    } else {
                        return -1;
                    }
                }
                return first2;
            }
            return -1;
        }
    }

    static /* synthetic */ int indexOf$StringsKt__StringsKt$default(CharSequence charSequence, CharSequence charSequence2, int i3, int i16, boolean z16, boolean z17, int i17, Object obj) {
        if ((i17 & 16) != 0) {
            z17 = false;
        }
        return indexOf$StringsKt__StringsKt(charSequence, charSequence2, i3, i16, z16, z17);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, char c16, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        return indexOf(charSequence, c16, i3, z16);
    }

    /* JADX WARN: Type inference failed for: r9v2, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    public static final int indexOfAny(@NotNull CharSequence charSequence, @NotNull char[] chars, int i3, boolean z16) {
        int coerceAtLeast;
        int lastIndex;
        boolean z17;
        boolean equals;
        char single;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        if (!z16 && chars.length == 1 && (charSequence instanceof String)) {
            single = ArraysKt___ArraysKt.single(chars);
            return ((String) charSequence).indexOf(single, i3);
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3, 0);
        lastIndex = getLastIndex(charSequence);
        ?? it = new IntRange(coerceAtLeast, lastIndex).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            char charAt = charSequence.charAt(nextInt);
            int length = chars.length;
            int i16 = 0;
            while (true) {
                if (i16 >= length) {
                    z17 = false;
                    break;
                }
                equals = CharsKt__CharKt.equals(chars[i16], charAt, z16);
                if (equals) {
                    z17 = true;
                    break;
                }
                i16++;
            }
            if (z17) {
                return nextInt;
            }
        }
        return -1;
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, char[] cArr, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        return indexOfAny(charSequence, cArr, i3, z16);
    }

    @InlineOnly
    private static final boolean isEmpty(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return true;
        }
        return false;
    }

    @InlineOnly
    private static final boolean isNotBlank(CharSequence charSequence) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        isBlank = StringsKt__StringsJVMKt.isBlank(charSequence);
        return !isBlank;
    }

    @InlineOnly
    private static final boolean isNotEmpty(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() > 0) {
            return true;
        }
        return false;
    }

    @InlineOnly
    private static final boolean isNullOrBlank(CharSequence charSequence) {
        boolean isBlank;
        if (charSequence != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(charSequence);
            if (!isBlank) {
                return false;
            }
        }
        return true;
    }

    @InlineOnly
    private static final boolean isNullOrEmpty(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() != 0) {
            return false;
        }
        return true;
    }

    @NotNull
    public static CharIterator iterator(@NotNull final CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return new CharIterator() { // from class: kotlin.text.StringsKt__StringsKt$iterator$1
            private int index;

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.index < charSequence.length()) {
                    return true;
                }
                return false;
            }

            @Override // kotlin.collections.CharIterator
            public char nextChar() {
                CharSequence charSequence2 = charSequence;
                int i3 = this.index;
                this.index = i3 + 1;
                return charSequence2.charAt(i3);
            }
        };
    }

    public static final int lastIndexOf(@NotNull CharSequence charSequence, char c16, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (!z16 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c16, i3);
        }
        return lastIndexOfAny(charSequence, new char[]{c16}, i3, z16);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, char c16, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = getLastIndex(charSequence);
        }
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        return lastIndexOf(charSequence, c16, i3, z16);
    }

    public static final int lastIndexOfAny(@NotNull CharSequence charSequence, @NotNull char[] chars, int i3, boolean z16) {
        int lastIndex;
        int coerceAtMost;
        boolean equals;
        char single;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        if (z16 || chars.length != 1 || !(charSequence instanceof String)) {
            lastIndex = getLastIndex(charSequence);
            for (coerceAtMost = RangesKt___RangesKt.coerceAtMost(i3, lastIndex); -1 < coerceAtMost; coerceAtMost--) {
                char charAt = charSequence.charAt(coerceAtMost);
                int length = chars.length;
                boolean z17 = false;
                int i16 = 0;
                while (true) {
                    if (i16 >= length) {
                        break;
                    }
                    equals = CharsKt__CharKt.equals(chars[i16], charAt, z16);
                    if (equals) {
                        z17 = true;
                        break;
                    }
                    i16++;
                }
                if (z17) {
                    return coerceAtMost;
                }
            }
            return -1;
        }
        single = ArraysKt___ArraysKt.single(chars);
        return ((String) charSequence).lastIndexOf(single, i3);
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, char[] cArr, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = getLastIndex(charSequence);
        }
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        return lastIndexOfAny(charSequence, cArr, i3, z16);
    }

    @NotNull
    public static final Sequence<String> lineSequence(@NotNull CharSequence charSequence) {
        Sequence<String> splitToSequence$default;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        splitToSequence$default = splitToSequence$default(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, (Object) null);
        return splitToSequence$default;
    }

    @NotNull
    public static final List<String> lines(@NotNull CharSequence charSequence) {
        List<String> list;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        list = SequencesKt___SequencesKt.toList(lineSequence(charSequence));
        return list;
    }

    @InlineOnly
    private static final boolean matches(CharSequence charSequence, Regex regex) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.matches(charSequence);
    }

    @InlineOnly
    private static final String orEmpty(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @NotNull
    public static final CharSequence padEnd(@NotNull CharSequence charSequence, int i3, char c16) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i3 >= 0) {
            if (i3 <= charSequence.length()) {
                return charSequence.subSequence(0, charSequence.length());
            }
            StringBuilder sb5 = new StringBuilder(i3);
            sb5.append(charSequence);
            ?? it = new IntRange(1, i3 - charSequence.length()).iterator();
            while (it.hasNext()) {
                it.nextInt();
                sb5.append(c16);
            }
            return sb5;
        }
        throw new IllegalArgumentException("Desired length " + i3 + " is less than zero.");
    }

    public static /* synthetic */ CharSequence padEnd$default(CharSequence charSequence, int i3, char c16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            c16 = TokenParser.SP;
        }
        return padEnd(charSequence, i3, c16);
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @NotNull
    public static final CharSequence padStart(@NotNull CharSequence charSequence, int i3, char c16) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i3 >= 0) {
            if (i3 <= charSequence.length()) {
                return charSequence.subSequence(0, charSequence.length());
            }
            StringBuilder sb5 = new StringBuilder(i3);
            ?? it = new IntRange(1, i3 - charSequence.length()).iterator();
            while (it.hasNext()) {
                it.nextInt();
                sb5.append(c16);
            }
            sb5.append(charSequence);
            return sb5;
        }
        throw new IllegalArgumentException("Desired length " + i3 + " is less than zero.");
    }

    public static /* synthetic */ CharSequence padStart$default(CharSequence charSequence, int i3, char c16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            c16 = TokenParser.SP;
        }
        return padStart(charSequence, i3, c16);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence charSequence, final char[] cArr, int i3, final boolean z16, int i16) {
        requireNonNegativeLimit(i16);
        return new DelimitedRangesSequence(charSequence, i3, i16, new Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                return invoke(charSequence2, num.intValue());
            }

            @Nullable
            public final Pair<Integer, Integer> invoke(@NotNull CharSequence $receiver, int i17) {
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                int indexOfAny = StringsKt__StringsKt.indexOfAny($receiver, cArr, i17, z16);
                if (indexOfAny < 0) {
                    return null;
                }
                return TuplesKt.to(Integer.valueOf(indexOfAny), 1);
            }
        });
    }

    static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, char[] cArr, int i3, boolean z16, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = 0;
        }
        if ((i17 & 4) != 0) {
            z16 = false;
        }
        if ((i17 & 8) != 0) {
            i16 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, cArr, i3, z16, i16);
    }

    public static final boolean regionMatchesImpl(@NotNull CharSequence charSequence, int i3, @NotNull CharSequence other, int i16, int i17, boolean z16) {
        boolean equals;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (i16 < 0 || i3 < 0 || i3 > charSequence.length() - i17 || i16 > other.length() - i17) {
            return false;
        }
        for (int i18 = 0; i18 < i17; i18++) {
            equals = CharsKt__CharKt.equals(charSequence.charAt(i3 + i18), other.charAt(i16 + i18), z16);
            if (!equals) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final CharSequence removePrefix(@NotNull CharSequence charSequence, @NotNull CharSequence prefix) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        startsWith$default = startsWith$default(charSequence, prefix, false, 2, (Object) null);
        if (startsWith$default) {
            return charSequence.subSequence(prefix.length(), charSequence.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @NotNull
    public static CharSequence removeRange(@NotNull CharSequence charSequence, int i3, int i16) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i16 < i3) {
            throw new IndexOutOfBoundsException("End index (" + i16 + ") is less than start index (" + i3 + ").");
        }
        if (i16 == i3) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb5 = new StringBuilder(charSequence.length() - (i16 - i3));
        sb5.append(charSequence, 0, i3);
        Intrinsics.checkNotNullExpressionValue(sb5, "this.append(value, startIndex, endIndex)");
        sb5.append(charSequence, i16, charSequence.length());
        Intrinsics.checkNotNullExpressionValue(sb5, "this.append(value, startIndex, endIndex)");
        return sb5;
    }

    @NotNull
    public static CharSequence removeSuffix(@NotNull CharSequence charSequence, @NotNull CharSequence suffix) {
        boolean endsWith$default;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        endsWith$default = endsWith$default(charSequence, suffix, false, 2, (Object) null);
        if (endsWith$default) {
            return charSequence.subSequence(0, charSequence.length() - suffix.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @NotNull
    public static final CharSequence removeSurrounding(@NotNull CharSequence charSequence, @NotNull CharSequence prefix, @NotNull CharSequence suffix) {
        boolean startsWith$default;
        boolean endsWith$default;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (charSequence.length() >= prefix.length() + suffix.length()) {
            startsWith$default = startsWith$default(charSequence, prefix, false, 2, (Object) null);
            if (startsWith$default) {
                endsWith$default = endsWith$default(charSequence, suffix, false, 2, (Object) null);
                if (endsWith$default) {
                    return charSequence.subSequence(prefix.length(), charSequence.length() - suffix.length());
                }
            }
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @InlineOnly
    private static final String replace(CharSequence charSequence, Regex regex, String replacement) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return regex.replace(charSequence, replacement);
    }

    @NotNull
    public static final String replaceAfter(@NotNull String str, char c16, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        int indexOf$default;
        CharSequence replaceRange;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        indexOf$default = indexOf$default((CharSequence) str, c16, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        replaceRange = replaceRange((CharSequence) str, indexOf$default + 1, str.length(), (CharSequence) replacement);
        return replaceRange.toString();
    }

    public static /* synthetic */ String replaceAfter$default(String str, char c16, String str2, String str3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str3 = str;
        }
        return replaceAfter(str, c16, str2, str3);
    }

    @NotNull
    public static final String replaceAfterLast(@NotNull String str, @NotNull String delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        int lastIndexOf$default;
        CharSequence replaceRange;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        lastIndexOf$default = lastIndexOf$default((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        replaceRange = replaceRange((CharSequence) str, lastIndexOf$default + delimiter.length(), str.length(), (CharSequence) replacement);
        return replaceRange.toString();
    }

    public static /* synthetic */ String replaceAfterLast$default(String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str4 = str;
        }
        return replaceAfterLast(str, str2, str3, str4);
    }

    @NotNull
    public static final String replaceBefore(@NotNull String str, char c16, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        int indexOf$default;
        CharSequence replaceRange;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        indexOf$default = indexOf$default((CharSequence) str, c16, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        replaceRange = replaceRange((CharSequence) str, 0, indexOf$default, (CharSequence) replacement);
        return replaceRange.toString();
    }

    public static /* synthetic */ String replaceBefore$default(String str, char c16, String str2, String str3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str3 = str;
        }
        return replaceBefore(str, c16, str2, str3);
    }

    @NotNull
    public static final String replaceBeforeLast(@NotNull String str, char c16, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        int lastIndexOf$default;
        CharSequence replaceRange;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        lastIndexOf$default = lastIndexOf$default((CharSequence) str, c16, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        replaceRange = replaceRange((CharSequence) str, 0, lastIndexOf$default, (CharSequence) replacement);
        return replaceRange.toString();
    }

    public static /* synthetic */ String replaceBeforeLast$default(String str, char c16, String str2, String str3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str3 = str;
        }
        return replaceBeforeLast(str, c16, str2, str3);
    }

    @InlineOnly
    private static final String replaceFirst(CharSequence charSequence, Regex regex, String replacement) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return regex.replaceFirst(charSequence, replacement);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "replaceFirstCharWithChar")
    @OverloadResolutionByLambdaReturnType
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final String replaceFirstCharWithChar(String str, Function1<? super Character, Character> transform) {
        boolean z16;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            char charValue = transform.invoke(Character.valueOf(str.charAt(0))).charValue();
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            return charValue + substring;
        }
        return str;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "replaceFirstCharWithCharSequence")
    @OverloadResolutionByLambdaReturnType
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final String replaceFirstCharWithCharSequence(String str, Function1<? super Character, ? extends CharSequence> transform) {
        boolean z16;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append((Object) transform.invoke(Character.valueOf(str.charAt(0))));
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            sb5.append(substring);
            return sb5.toString();
        }
        return str;
    }

    @NotNull
    public static CharSequence replaceRange(@NotNull CharSequence charSequence, int i3, int i16, @NotNull CharSequence replacement) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        if (i16 >= i3) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(charSequence, 0, i3);
            Intrinsics.checkNotNullExpressionValue(sb5, "this.append(value, startIndex, endIndex)");
            sb5.append(replacement);
            sb5.append(charSequence, i16, charSequence.length());
            Intrinsics.checkNotNullExpressionValue(sb5, "this.append(value, startIndex, endIndex)");
            return sb5;
        }
        throw new IndexOutOfBoundsException("End index (" + i16 + ") is less than start index (" + i3 + ").");
    }

    public static final void requireNonNegativeLimit(int i3) {
        boolean z16;
        if (i3 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i3).toString());
    }

    @NotNull
    public static List<String> split(@NotNull CharSequence charSequence, @NotNull String[] delimiters, boolean z16, int i3) {
        Iterable asIterable;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (!(str.length() == 0)) {
                return split$StringsKt__StringsKt(charSequence, str, z16, i3);
            }
        }
        asIterable = SequencesKt___SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, delimiters, 0, z16, i3, 2, (Object) null));
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(asIterable, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = asIterable.iterator();
        while (it.hasNext()) {
            arrayList.add(substring(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }

    private static final List<String> split$StringsKt__StringsKt(CharSequence charSequence, String str, boolean z16, int i3) {
        int indexOf;
        List<String> listOf;
        boolean z17;
        requireNonNegativeLimit(i3);
        int i16 = 0;
        indexOf = indexOf(charSequence, str, 0, z16);
        if (indexOf == -1 || i3 == 1) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(charSequence.toString());
            return listOf;
        }
        if (i3 > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        int i17 = 10;
        if (z17) {
            i17 = RangesKt___RangesKt.coerceAtMost(i3, 10);
        }
        ArrayList arrayList = new ArrayList(i17);
        do {
            arrayList.add(charSequence.subSequence(i16, indexOf).toString());
            i16 = str.length() + indexOf;
            if (z17 && arrayList.size() == i3 - 1) {
                break;
            }
            indexOf = indexOf(charSequence, str, i16, z16);
        } while (indexOf != -1);
        arrayList.add(charSequence.subSequence(i16, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, String[] strArr, boolean z16, int i3, int i16, Object obj) {
        List split;
        if ((i16 & 2) != 0) {
            z16 = false;
        }
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        split = split(charSequence, strArr, z16, i3);
        return split;
    }

    @NotNull
    public static final Sequence<String> splitToSequence(@NotNull final CharSequence charSequence, @NotNull String[] delimiters, boolean z16, int i3) {
        Sequence<String> map;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        map = SequencesKt___SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, delimiters, 0, z16, i3, 2, (Object) null), new Function1<IntRange, String>() { // from class: kotlin.text.StringsKt__StringsKt$splitToSequence$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final String invoke(@NotNull IntRange it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return StringsKt__StringsKt.substring(charSequence, it);
            }
        });
        return map;
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, String[] strArr, boolean z16, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = false;
        }
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        return splitToSequence(charSequence, strArr, z16, i3);
    }

    public static final boolean startsWith(@NotNull CharSequence charSequence, char c16, boolean z16) {
        boolean equals;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() <= 0) {
            return false;
        }
        equals = CharsKt__CharKt.equals(charSequence.charAt(0), c16, z16);
        return equals;
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, char c16, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return startsWith(charSequence, c16, z16);
    }

    @NotNull
    public static final CharSequence subSequence(@NotNull CharSequence charSequence, @NotNull IntRange range) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return charSequence.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static String substring(@NotNull String str, @NotNull IntRange range) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        String substring = str.substring(range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }

    static /* synthetic */ String substring$default(CharSequence charSequence, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i16 = charSequence.length();
        }
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.subSequence(i3, i16).toString();
    }

    @NotNull
    public static String substringAfter(@NotNull String str, char c16, @NotNull String missingDelimiterValue) {
        int indexOf$default;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        indexOf$default = indexOf$default((CharSequence) str, c16, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(indexOf$default + 1, str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringAfter$default(String str, char c16, String str2, int i3, Object obj) {
        String substringAfter;
        if ((i3 & 2) != 0) {
            str2 = str;
        }
        substringAfter = substringAfter(str, c16, str2);
        return substringAfter;
    }

    @NotNull
    public static String substringAfterLast(@NotNull String str, char c16, @NotNull String missingDelimiterValue) {
        int lastIndexOf$default;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        lastIndexOf$default = lastIndexOf$default((CharSequence) str, c16, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(lastIndexOf$default + 1, str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringAfterLast$default(String str, char c16, String str2, int i3, Object obj) {
        String substringAfterLast;
        if ((i3 & 2) != 0) {
            str2 = str;
        }
        substringAfterLast = substringAfterLast(str, c16, str2);
        return substringAfterLast;
    }

    @NotNull
    public static String substringBefore(@NotNull String str, char c16, @NotNull String missingDelimiterValue) {
        int indexOf$default;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        indexOf$default = indexOf$default((CharSequence) str, c16, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringBefore$default(String str, char c16, String str2, int i3, Object obj) {
        String substringBefore;
        if ((i3 & 2) != 0) {
            str2 = str;
        }
        substringBefore = substringBefore(str, c16, str2);
        return substringBefore;
    }

    @NotNull
    public static final String substringBeforeLast(@NotNull String str, char c16, @NotNull String missingDelimiterValue) {
        int lastIndexOf$default;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        lastIndexOf$default = lastIndexOf$default((CharSequence) str, c16, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, char c16, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = str;
        }
        return substringBeforeLast(str, c16, str2);
    }

    @SinceKotlin(version = "1.5")
    public static final boolean toBooleanStrict(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (Intrinsics.areEqual(str, "true")) {
            return true;
        }
        if (Intrinsics.areEqual(str, "false")) {
            return false;
        }
        throw new IllegalArgumentException("The string doesn't represent a boolean value: " + str);
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    public static final Boolean toBooleanStrictOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (Intrinsics.areEqual(str, "true")) {
            return Boolean.TRUE;
        }
        if (Intrinsics.areEqual(str, "false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    @NotNull
    public static final CharSequence trim(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = charSequence.length() - 1;
        int i3 = 0;
        boolean z16 = false;
        while (i3 <= length) {
            boolean booleanValue = predicate.invoke(Character.valueOf(charSequence.charAt(!z16 ? i3 : length))).booleanValue();
            if (z16) {
                if (!booleanValue) {
                    break;
                }
                length--;
            } else if (booleanValue) {
                i3++;
            } else {
                z16 = true;
            }
        }
        return charSequence.subSequence(i3, length + 1);
    }

    @NotNull
    public static final CharSequence trimEnd(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length < 0) {
            return "";
        }
        while (true) {
            int i3 = length - 1;
            if (!predicate.invoke(Character.valueOf(charSequence.charAt(length))).booleanValue()) {
                return charSequence.subSequence(0, length + 1);
            }
            if (i3 < 0) {
                return "";
            }
            length = i3;
        }
    }

    @NotNull
    public static final CharSequence trimStart(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = charSequence.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (!predicate.invoke(Character.valueOf(charSequence.charAt(i3))).booleanValue()) {
                return charSequence.subSequence(i3, charSequence.length());
            }
        }
        return "";
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, char c16, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return contains(charSequence, c16, z16);
    }

    public static final boolean endsWith(@NotNull CharSequence charSequence, @NotNull CharSequence suffix, boolean z16) {
        boolean endsWith$default;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (!z16 && (charSequence instanceof String) && (suffix instanceof String)) {
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default((String) charSequence, (String) suffix, false, 2, null);
            return endsWith$default;
        }
        return regionMatchesImpl(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), z16);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return endsWith(charSequence, charSequence2, z16);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int i3, boolean z16, int i16, Object obj) {
        int indexOf;
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        indexOf = indexOf(charSequence, str, i3, z16);
        return indexOf;
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, Collection collection, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        return indexOfAny(charSequence, (Collection<String>) collection, i3, z16);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, String str, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = getLastIndex(charSequence);
        }
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        return lastIndexOf(charSequence, str, i3, z16);
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, Collection collection, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = getLastIndex(charSequence);
        }
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        return lastIndexOfAny(charSequence, (Collection<String>) collection, i3, z16);
    }

    public static /* synthetic */ String padEnd$default(String str, int i3, char c16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            c16 = TokenParser.SP;
        }
        return padEnd(str, i3, c16);
    }

    public static /* synthetic */ String padStart$default(String str, int i3, char c16, int i16, Object obj) {
        String padStart;
        if ((i16 & 2) != 0) {
            c16 = TokenParser.SP;
        }
        padStart = padStart(str, i3, c16);
        return padStart;
    }

    static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, String[] strArr, int i3, boolean z16, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = 0;
        }
        if ((i17 & 4) != 0) {
            z16 = false;
        }
        if ((i17 & 8) != 0) {
            i16 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, strArr, i3, z16, i16);
    }

    @InlineOnly
    private static final String replace(CharSequence charSequence, Regex regex, Function1<? super MatchResult, ? extends CharSequence> transform) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return regex.replace(charSequence, transform);
    }

    public static /* synthetic */ String replaceAfter$default(String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str4 = str;
        }
        return replaceAfter(str, str2, str3, str4);
    }

    public static /* synthetic */ String replaceAfterLast$default(String str, char c16, String str2, String str3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str3 = str;
        }
        return replaceAfterLast(str, c16, str2, str3);
    }

    public static /* synthetic */ String replaceBefore$default(String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str4 = str;
        }
        return replaceBefore(str, str2, str3, str4);
    }

    public static /* synthetic */ String replaceBeforeLast$default(String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str4 = str;
        }
        return replaceBeforeLast(str, str2, str3, str4);
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, char[] cArr, boolean z16, int i3, int i16, Object obj) {
        List split;
        if ((i16 & 2) != 0) {
            z16 = false;
        }
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        split = split(charSequence, cArr, z16, i3);
        return split;
    }

    @NotNull
    public static final Sequence<String> splitToSequence(@NotNull final CharSequence charSequence, @NotNull char[] delimiters, boolean z16, int i3) {
        Sequence<String> map;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        map = SequencesKt___SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, delimiters, 0, z16, i3, 2, (Object) null), new Function1<IntRange, String>() { // from class: kotlin.text.StringsKt__StringsKt$splitToSequence$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final String invoke(@NotNull IntRange it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return StringsKt__StringsKt.substring(charSequence, it);
            }
        });
        return map;
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, char[] cArr, boolean z16, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = false;
        }
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        return splitToSequence(charSequence, cArr, z16, i3);
    }

    public static final boolean startsWith(@NotNull CharSequence charSequence, @NotNull CharSequence prefix, boolean z16) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (z16 || !(charSequence instanceof String) || !(prefix instanceof String)) {
            return regionMatchesImpl(charSequence, 0, prefix, 0, prefix.length(), z16);
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default((String) charSequence, (String) prefix, false, 2, null);
        return startsWith$default;
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return startsWith(charSequence, charSequence2, z16);
    }

    @Deprecated(message = "Use parameters named startIndex and endIndex.", replaceWith = @ReplaceWith(expression = "subSequence(startIndex = start, endIndex = end)", imports = {}))
    @InlineOnly
    private static final CharSequence subSequence(String str, int i3, int i16) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return str.subSequence(i3, i16);
    }

    @InlineOnly
    private static final String substring(CharSequence charSequence, int i3, int i16) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.subSequence(i3, i16).toString();
    }

    public static /* synthetic */ String substringAfter$default(String str, String str2, String str3, int i3, Object obj) {
        String substringAfter;
        if ((i3 & 2) != 0) {
            str3 = str;
        }
        substringAfter = substringAfter(str, str2, str3);
        return substringAfter;
    }

    public static /* synthetic */ String substringAfterLast$default(String str, String str2, String str3, int i3, Object obj) {
        String substringAfterLast;
        if ((i3 & 2) != 0) {
            str3 = str;
        }
        substringAfterLast = substringAfterLast(str, str2, str3);
        return substringAfterLast;
    }

    public static /* synthetic */ String substringBefore$default(String str, String str2, String str3, int i3, Object obj) {
        String substringBefore;
        if ((i3 & 2) != 0) {
            str3 = str;
        }
        substringBefore = substringBefore(str, str2, str3);
        return substringBefore;
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, String str2, String str3, int i3, Object obj) {
        String substringBeforeLast;
        if ((i3 & 2) != 0) {
            str3 = str;
        }
        substringBeforeLast = substringBeforeLast(str, str2, str3);
        return substringBeforeLast;
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence charSequence, String[] strArr, int i3, final boolean z16, int i16) {
        final List asList;
        requireNonNegativeLimit(i16);
        asList = ArraysKt___ArraysJvmKt.asList(strArr);
        return new DelimitedRangesSequence(charSequence, i3, i16, new Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                return invoke(charSequence2, num.intValue());
            }

            @Nullable
            public final Pair<Integer, Integer> invoke(@NotNull CharSequence $receiver, int i17) {
                Pair findAnyOf$StringsKt__StringsKt;
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                findAnyOf$StringsKt__StringsKt = StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt($receiver, asList, i17, z16, false);
                if (findAnyOf$StringsKt__StringsKt != null) {
                    return TuplesKt.to(findAnyOf$StringsKt__StringsKt.getFirst(), Integer.valueOf(((String) findAnyOf$StringsKt__StringsKt.getSecond()).length()));
                }
                return null;
            }
        });
    }

    @NotNull
    public static final String replaceAfter(@NotNull String str, @NotNull String delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        int indexOf$default;
        CharSequence replaceRange;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        indexOf$default = indexOf$default((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        replaceRange = replaceRange((CharSequence) str, indexOf$default + delimiter.length(), str.length(), (CharSequence) replacement);
        return replaceRange.toString();
    }

    @NotNull
    public static final String replaceAfterLast(@NotNull String str, char c16, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        int lastIndexOf$default;
        CharSequence replaceRange;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        lastIndexOf$default = lastIndexOf$default((CharSequence) str, c16, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        replaceRange = replaceRange((CharSequence) str, lastIndexOf$default + 1, str.length(), (CharSequence) replacement);
        return replaceRange.toString();
    }

    @NotNull
    public static final String replaceBefore(@NotNull String str, @NotNull String delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        int indexOf$default;
        CharSequence replaceRange;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        indexOf$default = indexOf$default((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        replaceRange = replaceRange((CharSequence) str, 0, indexOf$default, (CharSequence) replacement);
        return replaceRange.toString();
    }

    @NotNull
    public static final String replaceBeforeLast(@NotNull String str, @NotNull String delimiter, @NotNull String replacement, @NotNull String missingDelimiterValue) {
        int lastIndexOf$default;
        CharSequence replaceRange;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        lastIndexOf$default = lastIndexOf$default((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        replaceRange = replaceRange((CharSequence) str, 0, lastIndexOf$default, (CharSequence) replacement);
        return replaceRange.toString();
    }

    static /* synthetic */ List split$default(CharSequence charSequence, Regex regex, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.split(charSequence, i3);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final Sequence<String> splitToSequence(CharSequence charSequence, Regex regex, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.splitToSequence(charSequence, i3);
    }

    static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, Regex regex, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.splitToSequence(charSequence, i3);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        return startsWith(charSequence, charSequence2, i3, z16);
    }

    @NotNull
    public static final String substring(@NotNull CharSequence charSequence, @NotNull IntRange range) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return charSequence.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1).toString();
    }

    @NotNull
    public static String substringAfter(@NotNull String str, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        int indexOf$default;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        indexOf$default = indexOf$default((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(indexOf$default + delimiter.length(), str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static String substringAfterLast(@NotNull String str, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        int lastIndexOf$default;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        lastIndexOf$default = lastIndexOf$default((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(lastIndexOf$default + delimiter.length(), str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static String substringBefore(@NotNull String str, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        int indexOf$default;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        indexOf$default = indexOf$default((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static String substringBeforeLast(@NotNull String str, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        int lastIndexOf$default;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        lastIndexOf$default = lastIndexOf$default((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean contains(@NotNull CharSequence charSequence, char c16, boolean z16) {
        int indexOf$default;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        indexOf$default = indexOf$default(charSequence, c16, 0, z16, 2, (Object) null);
        return indexOf$default >= 0;
    }

    public static int indexOf(@NotNull CharSequence charSequence, @NotNull String string, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        if (!z16 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(string, i3);
        }
        return indexOf$StringsKt__StringsKt$default(charSequence, string, i3, charSequence.length(), z16, false, 16, null);
    }

    public static final int lastIndexOf(@NotNull CharSequence charSequence, @NotNull String string, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        if (!z16 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(string, i3);
        }
        return indexOf$StringsKt__StringsKt(charSequence, string, i3, 0, z16, true);
    }

    @NotNull
    public static String removePrefix(@NotNull String str, @NotNull CharSequence prefix) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        startsWith$default = startsWith$default((CharSequence) str, prefix, false, 2, (Object) null);
        if (!startsWith$default) {
            return str;
        }
        String substring = str.substring(prefix.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    @NotNull
    public static String removeSuffix(@NotNull String str, @NotNull CharSequence suffix) {
        boolean endsWith$default;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        endsWith$default = endsWith$default((CharSequence) str, suffix, false, 2, (Object) null);
        if (!endsWith$default) {
            return str;
        }
        String substring = str.substring(0, str.length() - suffix.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static String removeSurrounding(@NotNull String str, @NotNull CharSequence prefix, @NotNull CharSequence suffix) {
        boolean startsWith$default;
        boolean endsWith$default;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (str.length() < prefix.length() + suffix.length()) {
            return str;
        }
        startsWith$default = startsWith$default((CharSequence) str, prefix, false, 2, (Object) null);
        if (!startsWith$default) {
            return str;
        }
        endsWith$default = endsWith$default((CharSequence) str, suffix, false, 2, (Object) null);
        if (!endsWith$default) {
            return str;
        }
        String substring = str.substring(prefix.length(), str.length() - suffix.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }

    @InlineOnly
    private static final String trim(String str) {
        CharSequence trim;
        Intrinsics.checkNotNullParameter(str, "<this>");
        trim = trim((CharSequence) str);
        return trim.toString();
    }

    @InlineOnly
    private static final String trimEnd(String str) {
        CharSequence trimEnd;
        Intrinsics.checkNotNullParameter(str, "<this>");
        trimEnd = trimEnd((CharSequence) str);
        return trimEnd.toString();
    }

    @InlineOnly
    private static final String trimStart(String str) {
        CharSequence trimStart;
        Intrinsics.checkNotNullParameter(str, "<this>");
        trimStart = trimStart((CharSequence) str);
        return trimStart.toString();
    }

    @InlineOnly
    private static final boolean contains(CharSequence charSequence, Regex regex) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.containsMatchIn(charSequence);
    }

    public static final boolean startsWith(@NotNull CharSequence charSequence, @NotNull CharSequence prefix, int i3, boolean z16) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!z16 && (charSequence instanceof String) && (prefix instanceof String)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default((String) charSequence, (String) prefix, i3, false, 4, null);
            return startsWith$default;
        }
        return regionMatchesImpl(charSequence, i3, prefix, 0, prefix.length(), z16);
    }

    @NotNull
    public static final String trim(@NotNull String str, @NotNull Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = str.length() - 1;
        int i3 = 0;
        boolean z16 = false;
        while (i3 <= length) {
            boolean booleanValue = predicate.invoke(Character.valueOf(str.charAt(!z16 ? i3 : length))).booleanValue();
            if (z16) {
                if (!booleanValue) {
                    break;
                }
                length--;
            } else if (booleanValue) {
                i3++;
            } else {
                z16 = true;
            }
        }
        return str.subSequence(i3, length + 1).toString();
    }

    @NotNull
    public static final String trimEnd(@NotNull String str, @NotNull Function1<? super Character, Boolean> predicate) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                if (!predicate.invoke(Character.valueOf(str.charAt(length))).booleanValue()) {
                    charSequence = str.subSequence(0, length + 1);
                    break;
                }
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
            return charSequence.toString();
        }
        charSequence = "";
        return charSequence.toString();
    }

    @NotNull
    public static final String trimStart(@NotNull String str, @NotNull Function1<? super Character, Boolean> predicate) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = str.length();
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                charSequence = "";
                break;
            }
            if (!predicate.invoke(Character.valueOf(str.charAt(i3))).booleanValue()) {
                charSequence = str.subSequence(i3, str.length());
                break;
            }
            i3++;
        }
        return charSequence.toString();
    }

    @InlineOnly
    private static final String removeRange(String str, int i3, int i16) {
        CharSequence removeRange;
        Intrinsics.checkNotNullParameter(str, "<this>");
        removeRange = removeRange((CharSequence) str, i3, i16);
        return removeRange.toString();
    }

    @NotNull
    public static final CharSequence removeSurrounding(@NotNull CharSequence charSequence, @NotNull CharSequence delimiter) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        return removeSurrounding(charSequence, delimiter, delimiter);
    }

    @InlineOnly
    private static final String replaceRange(String str, int i3, int i16, CharSequence replacement) {
        CharSequence replaceRange;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        replaceRange = replaceRange((CharSequence) str, i3, i16, replacement);
        return replaceRange.toString();
    }

    @NotNull
    public static final CharSequence removeRange(@NotNull CharSequence charSequence, @NotNull IntRange range) {
        CharSequence removeRange;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        removeRange = removeRange(charSequence, range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
        return removeRange;
    }

    @NotNull
    public static String removeSurrounding(@NotNull String str, @NotNull CharSequence delimiter) {
        String removeSurrounding;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        removeSurrounding = removeSurrounding(str, delimiter, delimiter);
        return removeSurrounding;
    }

    @NotNull
    public static CharSequence replaceRange(@NotNull CharSequence charSequence, @NotNull IntRange range, @NotNull CharSequence replacement) {
        CharSequence replaceRange;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        replaceRange = replaceRange(charSequence, range.getStart().intValue(), range.getEndInclusive().intValue() + 1, replacement);
        return replaceRange;
    }

    public static final int indexOfAny(@NotNull CharSequence charSequence, @NotNull Collection<String> strings, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        Pair<Integer, String> findAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt(charSequence, strings, i3, z16, false);
        if (findAnyOf$StringsKt__StringsKt != null) {
            return findAnyOf$StringsKt__StringsKt.getFirst().intValue();
        }
        return -1;
    }

    public static final int lastIndexOfAny(@NotNull CharSequence charSequence, @NotNull Collection<String> strings, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        Pair<Integer, String> findAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt(charSequence, strings, i3, z16, true);
        if (findAnyOf$StringsKt__StringsKt != null) {
            return findAnyOf$StringsKt__StringsKt.getFirst().intValue();
        }
        return -1;
    }

    @NotNull
    public static final String padEnd(@NotNull String str, int i3, char c16) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return padEnd((CharSequence) str, i3, c16).toString();
    }

    @NotNull
    public static String padStart(@NotNull String str, int i3, char c16) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return padStart((CharSequence) str, i3, c16).toString();
    }

    @InlineOnly
    private static final String removeRange(String str, IntRange range) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return removeRange((CharSequence) str, range).toString();
    }

    @InlineOnly
    private static final String replaceRange(String str, IntRange range, CharSequence replacement) {
        CharSequence replaceRange;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        replaceRange = replaceRange((CharSequence) str, range, replacement);
        return replaceRange.toString();
    }

    @NotNull
    public static final CharSequence trim(@NotNull CharSequence charSequence, @NotNull char... chars) {
        boolean contains;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int length = charSequence.length() - 1;
        int i3 = 0;
        boolean z16 = false;
        while (i3 <= length) {
            contains = ArraysKt___ArraysKt.contains(chars, charSequence.charAt(!z16 ? i3 : length));
            if (z16) {
                if (!contains) {
                    break;
                }
                length--;
            } else if (contains) {
                i3++;
            } else {
                z16 = true;
            }
        }
        return charSequence.subSequence(i3, length + 1);
    }

    @NotNull
    public static CharSequence trimEnd(@NotNull CharSequence charSequence, @NotNull char... chars) {
        boolean contains;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                contains = ArraysKt___ArraysKt.contains(chars, charSequence.charAt(length));
                if (!contains) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
        }
        return "";
    }

    @NotNull
    public static CharSequence trimStart(@NotNull CharSequence charSequence, @NotNull char... chars) {
        boolean contains;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int length = charSequence.length();
        for (int i3 = 0; i3 < length; i3++) {
            contains = ArraysKt___ArraysKt.contains(chars, charSequence.charAt(i3));
            if (!contains) {
                return charSequence.subSequence(i3, charSequence.length());
            }
        }
        return "";
    }

    @NotNull
    public static List<String> split(@NotNull CharSequence charSequence, @NotNull char[] delimiters, boolean z16, int i3) {
        Iterable asIterable;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        if (delimiters.length != 1) {
            asIterable = SequencesKt___SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, delimiters, 0, z16, i3, 2, (Object) null));
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(asIterable, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it = asIterable.iterator();
            while (it.hasNext()) {
                arrayList.add(substring(charSequence, (IntRange) it.next()));
            }
            return arrayList;
        }
        return split$StringsKt__StringsKt(charSequence, String.valueOf(delimiters[0]), z16, i3);
    }

    @NotNull
    public static String trim(@NotNull String str, @NotNull char... chars) {
        boolean contains;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int length = str.length() - 1;
        int i3 = 0;
        boolean z16 = false;
        while (i3 <= length) {
            contains = ArraysKt___ArraysKt.contains(chars, str.charAt(!z16 ? i3 : length));
            if (z16) {
                if (!contains) {
                    break;
                }
                length--;
            } else if (contains) {
                i3++;
            } else {
                z16 = true;
            }
        }
        return str.subSequence(i3, length + 1).toString();
    }

    @NotNull
    public static String trimEnd(@NotNull String str, @NotNull char... chars) {
        CharSequence charSequence;
        boolean contains;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                contains = ArraysKt___ArraysKt.contains(chars, str.charAt(length));
                if (!contains) {
                    charSequence = str.subSequence(0, length + 1);
                    break;
                }
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
            return charSequence.toString();
        }
        charSequence = "";
        return charSequence.toString();
    }

    @NotNull
    public static String trimStart(@NotNull String str, @NotNull char... chars) {
        CharSequence charSequence;
        boolean contains;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int length = str.length();
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                charSequence = "";
                break;
            }
            contains = ArraysKt___ArraysKt.contains(chars, str.charAt(i3));
            if (!contains) {
                charSequence = str.subSequence(i3, str.length());
                break;
            }
            i3++;
        }
        return charSequence.toString();
    }

    @NotNull
    public static CharSequence trim(@NotNull CharSequence charSequence) {
        boolean isWhitespace;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i3 = 0;
        boolean z16 = false;
        while (i3 <= length) {
            isWhitespace = CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(!z16 ? i3 : length));
            if (z16) {
                if (!isWhitespace) {
                    break;
                }
                length--;
            } else if (isWhitespace) {
                i3++;
            } else {
                z16 = true;
            }
        }
        return charSequence.subSequence(i3, length + 1);
    }

    @NotNull
    public static CharSequence trimEnd(@NotNull CharSequence charSequence) {
        boolean isWhitespace;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                isWhitespace = CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(length));
                if (!isWhitespace) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
        }
        return "";
    }

    @NotNull
    public static CharSequence trimStart(@NotNull CharSequence charSequence) {
        boolean isWhitespace;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length();
        for (int i3 = 0; i3 < length; i3++) {
            isWhitespace = CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(i3));
            if (!isWhitespace) {
                return charSequence.subSequence(i3, charSequence.length());
            }
        }
        return "";
    }

    @InlineOnly
    private static final List<String> split(CharSequence charSequence, Regex regex, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(regex, "regex");
        return regex.split(charSequence, i3);
    }
}
