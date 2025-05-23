package kotlin.ranges;

import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlin.ranges.CharProgression;
import kotlin.ranges.IntProgression;
import kotlin.ranges.LongProgression;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001e\u001a'\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u0001\u00a2\u0006\u0002\u0010\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005\u001a\u0012\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006\u001a\u0012\u0010\u0000\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007\u001a\u0012\u0010\u0000\u001a\u00020\b*\u00020\b2\u0006\u0010\u0003\u001a\u00020\b\u001a\u0012\u0010\u0000\u001a\u00020\t*\u00020\t2\u0006\u0010\u0003\u001a\u00020\t\u001a\u0012\u0010\u0000\u001a\u00020\n*\u00020\n2\u0006\u0010\u0003\u001a\u00020\n\u001a'\u0010\u000b\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\u0006\u0010\f\u001a\u0002H\u0001\u00a2\u0006\u0002\u0010\u0004\u001a\u0012\u0010\u000b\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005\u001a\u0012\u0010\u000b\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006\u001a\u0012\u0010\u000b\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007\u001a\u0012\u0010\u000b\u001a\u00020\b*\u00020\b2\u0006\u0010\f\u001a\u00020\b\u001a\u0012\u0010\u000b\u001a\u00020\t*\u00020\t2\u0006\u0010\f\u001a\u00020\t\u001a\u0012\u0010\u000b\u001a\u00020\n*\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a3\u0010\r\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\b\u0010\u0003\u001a\u0004\u0018\u0001H\u00012\b\u0010\f\u001a\u0004\u0018\u0001H\u0001\u00a2\u0006\u0002\u0010\u000e\u001a/\u0010\r\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0010H\u0007\u00a2\u0006\u0002\u0010\u0011\u001a-\u0010\r\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u0002H\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0012\u00a2\u0006\u0002\u0010\u0013\u001a\u001a\u0010\r\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005\u001a\u001a\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006\u001a\u001a\u0010\r\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007\u001a\u001a\u0010\r\u001a\u00020\b*\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b\u001a\u0018\u0010\r\u001a\u00020\b*\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0012\u001a\u001a\u0010\r\u001a\u00020\t*\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t\u001a\u0018\u0010\r\u001a\u00020\t*\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0012\u001a\u001a\u0010\r\u001a\u00020\n*\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0087\n\u00a2\u0006\u0002\u0010\u0019\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002\u00a2\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002\u00a2\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002\u00a2\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002\u00a2\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002\u00a2\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002\u00a2\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002\u00a2\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002\u00a2\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002\u00a2\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002\u00a2\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002\u00a2\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002\u00a2\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002\u00a2\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002\u00a2\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002\u00a2\u0006\u0002\b\u001d\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002\u00a2\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002\u00a2\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002\u00a2\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002\u00a2\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002\u00a2\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002\u00a2\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002\u00a2\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002\u00a2\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002\u00a2\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002\u00a2\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002\u00a2\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0087\u0002\u00a2\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002\u00a2\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002\u00a2\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002\u00a2\u0006\u0002\b \u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020!2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\n\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020!2\b\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0087\n\u00a2\u0006\u0002\u0010\"\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020!2\u0006\u0010\u001a\u001a\u00020\tH\u0087\n\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020!2\u0006\u0010\u001a\u001a\u00020\nH\u0087\n\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020#2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\n\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020#2\u0006\u0010\u001a\u001a\u00020\bH\u0087\n\u001a\u001c\u0010\u0014\u001a\u00020\u0015*\u00020#2\b\u0010\u0017\u001a\u0004\u0018\u00010\tH\u0087\n\u00a2\u0006\u0002\u0010$\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020#2\u0006\u0010\u001a\u001a\u00020\nH\u0087\n\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002\u00a2\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002\u00a2\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002\u00a2\u0006\u0002\b\u001b\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\u00060%2\u0006\u0010\u001a\u001a\u00020\u0007H\u0087\u0002\u00a2\u0006\u0002\b\u001c\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0%2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002\u00a2\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0%2\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002\u00a2\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\b0%2\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002\u00a2\u0006\u0002\b\u001e\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0%2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002\u00a2\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0%2\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002\u00a2\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\t0%2\u0006\u0010\u001a\u001a\u00020\nH\u0087\u0002\u00a2\u0006\u0002\b\u001f\u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0%2\u0006\u0010\u001a\u001a\u00020\u0005H\u0087\u0002\u00a2\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0%2\u0006\u0010\u001a\u001a\u00020\bH\u0087\u0002\u00a2\u0006\u0002\b \u001a \u0010\u0014\u001a\u00020\u0015*\b\u0012\u0004\u0012\u00020\n0%2\u0006\u0010\u001a\u001a\u00020\tH\u0087\u0002\u00a2\u0006\u0002\b \u001a\u0015\u0010&\u001a\u00020'*\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\u00052\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\u00052\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\u00052\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020**\u00020\u00182\u0006\u0010(\u001a\u00020\u0018H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\b2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\b2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\b2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\t2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\t2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\t2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\n2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\n2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020)*\u00020\n2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010&\u001a\u00020'*\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\f\u0010+\u001a\u00020\u0018*\u00020*H\u0007\u001a\f\u0010+\u001a\u00020\b*\u00020'H\u0007\u001a\f\u0010+\u001a\u00020\t*\u00020)H\u0007\u001a\u0013\u0010,\u001a\u0004\u0018\u00010\u0018*\u00020*H\u0007\u00a2\u0006\u0002\u0010-\u001a\u0013\u0010,\u001a\u0004\u0018\u00010\b*\u00020'H\u0007\u00a2\u0006\u0002\u0010.\u001a\u0013\u0010,\u001a\u0004\u0018\u00010\t*\u00020)H\u0007\u00a2\u0006\u0002\u0010/\u001a\f\u00100\u001a\u00020\u0018*\u00020*H\u0007\u001a\f\u00100\u001a\u00020\b*\u00020'H\u0007\u001a\f\u00100\u001a\u00020\t*\u00020)H\u0007\u001a\u0013\u00101\u001a\u0004\u0018\u00010\u0018*\u00020*H\u0007\u00a2\u0006\u0002\u0010-\u001a\u0013\u00101\u001a\u0004\u0018\u00010\b*\u00020'H\u0007\u00a2\u0006\u0002\u0010.\u001a\u0013\u00101\u001a\u0004\u0018\u00010\t*\u00020)H\u0007\u00a2\u0006\u0002\u0010/\u001a\r\u00102\u001a\u00020\u0018*\u00020\u0016H\u0087\b\u001a\u0014\u00102\u001a\u00020\u0018*\u00020\u00162\u0006\u00102\u001a\u000203H\u0007\u001a\r\u00102\u001a\u00020\b*\u00020!H\u0087\b\u001a\u0014\u00102\u001a\u00020\b*\u00020!2\u0006\u00102\u001a\u000203H\u0007\u001a\r\u00102\u001a\u00020\t*\u00020#H\u0087\b\u001a\u0014\u00102\u001a\u00020\t*\u00020#2\u0006\u00102\u001a\u000203H\u0007\u001a\u0014\u00104\u001a\u0004\u0018\u00010\u0018*\u00020\u0016H\u0087\b\u00a2\u0006\u0002\u00105\u001a\u001b\u00104\u001a\u0004\u0018\u00010\u0018*\u00020\u00162\u0006\u00102\u001a\u000203H\u0007\u00a2\u0006\u0002\u00106\u001a\u0014\u00104\u001a\u0004\u0018\u00010\b*\u00020!H\u0087\b\u00a2\u0006\u0002\u00107\u001a\u001b\u00104\u001a\u0004\u0018\u00010\b*\u00020!2\u0006\u00102\u001a\u000203H\u0007\u00a2\u0006\u0002\u00108\u001a\u0014\u00104\u001a\u0004\u0018\u00010\t*\u00020#H\u0087\b\u00a2\u0006\u0002\u00109\u001a\u001b\u00104\u001a\u0004\u0018\u00010\t*\u00020#2\u0006\u00102\u001a\u000203H\u0007\u00a2\u0006\u0002\u0010:\u001a\u0015\u0010;\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0087\n\u001a\u0015\u0010;\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\bH\u0087\n\u001a\u0015\u0010;\u001a\u00020#*\u00020\u00052\u0006\u0010(\u001a\u00020\tH\u0087\n\u001a\u0015\u0010;\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\nH\u0087\n\u001a\u0015\u0010;\u001a\u00020\u0016*\u00020\u00182\u0006\u0010(\u001a\u00020\u0018H\u0087\n\u001a\u0015\u0010;\u001a\u00020!*\u00020\b2\u0006\u0010(\u001a\u00020\u0005H\u0087\n\u001a\u0015\u0010;\u001a\u00020!*\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0087\n\u001a\u0015\u0010;\u001a\u00020#*\u00020\b2\u0006\u0010(\u001a\u00020\tH\u0087\n\u001a\u0015\u0010;\u001a\u00020!*\u00020\b2\u0006\u0010(\u001a\u00020\nH\u0087\n\u001a\u0015\u0010;\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\u0005H\u0087\n\u001a\u0015\u0010;\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\bH\u0087\n\u001a\u0015\u0010;\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0087\n\u001a\u0015\u0010;\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\nH\u0087\n\u001a\u0015\u0010;\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\u0005H\u0087\n\u001a\u0015\u0010;\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\bH\u0087\n\u001a\u0015\u0010;\u001a\u00020#*\u00020\n2\u0006\u0010(\u001a\u00020\tH\u0087\n\u001a\u0015\u0010;\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0087\n\u001a\n\u0010<\u001a\u00020**\u00020*\u001a\n\u0010<\u001a\u00020'*\u00020'\u001a\n\u0010<\u001a\u00020)*\u00020)\u001a\u0015\u0010=\u001a\u00020**\u00020*2\u0006\u0010=\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010=\u001a\u00020'*\u00020'2\u0006\u0010=\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010=\u001a\u00020)*\u00020)2\u0006\u0010=\u001a\u00020\tH\u0086\u0004\u001a\u0013\u0010>\u001a\u0004\u0018\u00010\u0005*\u00020\u0006H\u0000\u00a2\u0006\u0002\u0010?\u001a\u0013\u0010>\u001a\u0004\u0018\u00010\u0005*\u00020\u0007H\u0000\u00a2\u0006\u0002\u0010@\u001a\u0013\u0010>\u001a\u0004\u0018\u00010\u0005*\u00020\bH\u0000\u00a2\u0006\u0002\u0010A\u001a\u0013\u0010>\u001a\u0004\u0018\u00010\u0005*\u00020\tH\u0000\u00a2\u0006\u0002\u0010B\u001a\u0013\u0010>\u001a\u0004\u0018\u00010\u0005*\u00020\nH\u0000\u00a2\u0006\u0002\u0010C\u001a\u0013\u0010D\u001a\u0004\u0018\u00010\b*\u00020\u0006H\u0000\u00a2\u0006\u0002\u0010E\u001a\u0013\u0010D\u001a\u0004\u0018\u00010\b*\u00020\u0007H\u0000\u00a2\u0006\u0002\u0010F\u001a\u0013\u0010D\u001a\u0004\u0018\u00010\b*\u00020\tH\u0000\u00a2\u0006\u0002\u0010G\u001a\u0013\u0010H\u001a\u0004\u0018\u00010\t*\u00020\u0006H\u0000\u00a2\u0006\u0002\u0010I\u001a\u0013\u0010H\u001a\u0004\u0018\u00010\t*\u00020\u0007H\u0000\u00a2\u0006\u0002\u0010J\u001a\u0013\u0010K\u001a\u0004\u0018\u00010\n*\u00020\u0006H\u0000\u00a2\u0006\u0002\u0010L\u001a\u0013\u0010K\u001a\u0004\u0018\u00010\n*\u00020\u0007H\u0000\u00a2\u0006\u0002\u0010M\u001a\u0013\u0010K\u001a\u0004\u0018\u00010\n*\u00020\bH\u0000\u00a2\u0006\u0002\u0010N\u001a\u0013\u0010K\u001a\u0004\u0018\u00010\n*\u00020\tH\u0000\u00a2\u0006\u0002\u0010O\u001a\u0015\u0010P\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010P\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010P\u001a\u00020#*\u00020\u00052\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010P\u001a\u00020!*\u00020\u00052\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010P\u001a\u00020\u0016*\u00020\u00182\u0006\u0010(\u001a\u00020\u0018H\u0086\u0004\u001a\u0015\u0010P\u001a\u00020!*\u00020\b2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010P\u001a\u00020!*\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010P\u001a\u00020#*\u00020\b2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010P\u001a\u00020!*\u00020\b2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010P\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010P\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010P\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010P\u001a\u00020#*\u00020\t2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u001a\u0015\u0010P\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010P\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\bH\u0086\u0004\u001a\u0015\u0010P\u001a\u00020#*\u00020\n2\u0006\u0010(\u001a\u00020\tH\u0086\u0004\u001a\u0015\u0010P\u001a\u00020!*\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0086\u0004\u00a8\u0006Q"}, d2 = {"coerceAtLeast", "T", "", "minimumValue", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "coerceAtMost", "maximumValue", "coerceIn", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", DownloaderConstant.KEY_RANGE, "Lkotlin/ranges/ClosedFloatingPointRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "Lkotlin/ranges/ClosedRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedRange;)Ljava/lang/Comparable;", "contains", "", "Lkotlin/ranges/CharRange;", DTConstants.TAG.ELEMENT, "", "(Lkotlin/ranges/CharRange;Ljava/lang/Character;)Z", "value", "byteRangeContains", "doubleRangeContains", "floatRangeContains", "intRangeContains", "longRangeContains", "shortRangeContains", "Lkotlin/ranges/IntRange;", "(Lkotlin/ranges/IntRange;Ljava/lang/Integer;)Z", "Lkotlin/ranges/LongRange;", "(Lkotlin/ranges/LongRange;Ljava/lang/Long;)Z", "Lkotlin/ranges/OpenEndRange;", "downTo", "Lkotlin/ranges/IntProgression;", "to", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/CharProgression;", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "firstOrNull", "(Lkotlin/ranges/CharProgression;)Ljava/lang/Character;", "(Lkotlin/ranges/IntProgression;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongProgression;)Ljava/lang/Long;", "last", "lastOrNull", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "Lkotlin/random/Random;", "randomOrNull", "(Lkotlin/ranges/CharRange;)Ljava/lang/Character;", "(Lkotlin/ranges/CharRange;Lkotlin/random/Random;)Ljava/lang/Character;", "(Lkotlin/ranges/IntRange;)Ljava/lang/Integer;", "(Lkotlin/ranges/IntRange;Lkotlin/random/Random;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongRange;)Ljava/lang/Long;", "(Lkotlin/ranges/LongRange;Lkotlin/random/Random;)Ljava/lang/Long;", "rangeUntil", "reversed", "step", "toByteExactOrNull", "(D)Ljava/lang/Byte;", "(F)Ljava/lang/Byte;", "(I)Ljava/lang/Byte;", "(J)Ljava/lang/Byte;", "(S)Ljava/lang/Byte;", "toIntExactOrNull", "(D)Ljava/lang/Integer;", "(F)Ljava/lang/Integer;", "(J)Ljava/lang/Integer;", "toLongExactOrNull", "(D)Ljava/lang/Long;", "(F)Ljava/lang/Long;", "toShortExactOrNull", "(D)Ljava/lang/Short;", "(F)Ljava/lang/Short;", "(I)Ljava/lang/Short;", "(J)Ljava/lang/Short;", "until", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/ranges/RangesKt")
/* loaded from: classes28.dex */
public class RangesKt___RangesKt extends RangesKt__RangesKt {
    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "byteRangeContains")
    public static final /* synthetic */ boolean byteRangeContains(ClosedRange closedRange, double d16) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(d16);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final byte coerceAtLeast(byte b16, byte b17) {
        return b16 < b17 ? b17 : b16;
    }

    public static final byte coerceAtMost(byte b16, byte b17) {
        return b16 > b17 ? b17 : b16;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T coerceIn(@NotNull T t16, @Nullable T t17, @Nullable T t18) {
        Intrinsics.checkNotNullParameter(t16, "<this>");
        if (t17 != null && t18 != null) {
            if (t17.compareTo(t18) <= 0) {
                if (t16.compareTo(t17) < 0) {
                    return t17;
                }
                if (t16.compareTo(t18) > 0) {
                    return t18;
                }
            } else {
                throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + t18 + " is less than minimum " + t17 + '.');
            }
        } else {
            if (t17 != null && t16.compareTo(t17) < 0) {
                return t17;
            }
            if (t18 != null && t16.compareTo(t18) > 0) {
                return t18;
            }
        }
        return t16;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean contains(IntRange intRange, Integer num) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        return num != null && intRange.contains(num.intValue());
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "doubleRangeContains")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange closedRange, byte b16) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Double.valueOf(b16));
    }

    @NotNull
    public static final IntProgression downTo(int i3, byte b16) {
        return IntProgression.INSTANCE.fromClosedRange(i3, b16, -1);
    }

    @SinceKotlin(version = "1.7")
    public static final int first(@NotNull IntProgression intProgression) {
        Intrinsics.checkNotNullParameter(intProgression, "<this>");
        if (!intProgression.isEmpty()) {
            return intProgression.getFirst();
        }
        throw new NoSuchElementException("Progression " + intProgression + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Integer firstOrNull(@NotNull IntProgression intProgression) {
        Intrinsics.checkNotNullParameter(intProgression, "<this>");
        if (intProgression.isEmpty()) {
            return null;
        }
        return Integer.valueOf(intProgression.getFirst());
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "floatRangeContains")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange closedRange, byte b16) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Float.valueOf(b16));
    }

    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(@NotNull ClosedRange<Integer> closedRange, byte b16) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Integer.valueOf(b16));
    }

    @SinceKotlin(version = "1.7")
    public static final int last(@NotNull IntProgression intProgression) {
        Intrinsics.checkNotNullParameter(intProgression, "<this>");
        if (!intProgression.isEmpty()) {
            return intProgression.getLast();
        }
        throw new NoSuchElementException("Progression " + intProgression + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Integer lastOrNull(@NotNull IntProgression intProgression) {
        Intrinsics.checkNotNullParameter(intProgression, "<this>");
        if (intProgression.isEmpty()) {
            return null;
        }
        return Integer.valueOf(intProgression.getLast());
    }

    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(@NotNull ClosedRange<Long> closedRange, byte b16) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Long.valueOf(b16));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final int random(IntRange intRange) {
        int random;
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        random = random(intRange, Random.INSTANCE);
        return random;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final Integer randomOrNull(IntRange intRange) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        return randomOrNull(intRange, Random.INSTANCE);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final IntRange rangeUntil(int i3, byte b16) {
        return until(i3, b16);
    }

    @NotNull
    public static IntProgression reversed(@NotNull IntProgression intProgression) {
        Intrinsics.checkNotNullParameter(intProgression, "<this>");
        return IntProgression.INSTANCE.fromClosedRange(intProgression.getLast(), intProgression.getFirst(), -intProgression.getStep());
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(@NotNull ClosedRange<Short> closedRange, byte b16) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Short.valueOf(b16));
    }

    @NotNull
    public static IntProgression step(@NotNull IntProgression intProgression, int i3) {
        Intrinsics.checkNotNullParameter(intProgression, "<this>");
        RangesKt__RangesKt.checkStepIsPositive(i3 > 0, Integer.valueOf(i3));
        IntProgression.Companion companion = IntProgression.INSTANCE;
        int first = intProgression.getFirst();
        int last = intProgression.getLast();
        if (intProgression.getStep() <= 0) {
            i3 = -i3;
        }
        return companion.fromClosedRange(first, last, i3);
    }

    @Nullable
    public static final Byte toByteExactOrNull(int i3) {
        if (new IntRange(-128, 127).contains(i3)) {
            return Byte.valueOf((byte) i3);
        }
        return null;
    }

    @Nullable
    public static final Integer toIntExactOrNull(long j3) {
        if (new LongRange(WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, TTL.MAX_VALUE).contains(j3)) {
            return Integer.valueOf((int) j3);
        }
        return null;
    }

    @Nullable
    public static final Long toLongExactOrNull(double d16) {
        boolean z16 = false;
        if (-9.223372036854776E18d <= d16 && d16 <= 9.223372036854776E18d) {
            z16 = true;
        }
        if (z16) {
            return Long.valueOf((long) d16);
        }
        return null;
    }

    @Nullable
    public static final Short toShortExactOrNull(int i3) {
        if (new IntRange(-32768, 32767).contains(i3)) {
            return Short.valueOf((short) i3);
        }
        return null;
    }

    @NotNull
    public static final IntRange until(int i3, byte b16) {
        return new IntRange(i3, b16 - 1);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "byteRangeContains")
    public static final /* synthetic */ boolean byteRangeContains(ClosedRange closedRange, float f16) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(f16);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static double coerceAtLeast(double d16, double d17) {
        return d16 < d17 ? d17 : d16;
    }

    public static double coerceAtMost(double d16, double d17) {
        return d16 > d17 ? d17 : d16;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean contains(LongRange longRange, Long l3) {
        Intrinsics.checkNotNullParameter(longRange, "<this>");
        return l3 != null && longRange.contains(l3.longValue());
    }

    @JvmName(name = "doubleRangeContains")
    public static final boolean doubleRangeContains(@NotNull ClosedRange<Double> closedRange, float f16) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Double.valueOf(f16));
    }

    @NotNull
    public static final LongProgression downTo(long j3, byte b16) {
        return LongProgression.INSTANCE.fromClosedRange(j3, b16, -1L);
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Long firstOrNull(@NotNull LongProgression longProgression) {
        Intrinsics.checkNotNullParameter(longProgression, "<this>");
        if (longProgression.isEmpty()) {
            return null;
        }
        return Long.valueOf(longProgression.getFirst());
    }

    @JvmName(name = "floatRangeContains")
    public static final boolean floatRangeContains(@NotNull ClosedRange<Float> closedRange, double d16) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Float.valueOf((float) d16));
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(@NotNull OpenEndRange<Integer> openEndRange, byte b16) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Integer.valueOf(b16));
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Long lastOrNull(@NotNull LongProgression longProgression) {
        Intrinsics.checkNotNullParameter(longProgression, "<this>");
        if (longProgression.isEmpty()) {
            return null;
        }
        return Long.valueOf(longProgression.getLast());
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(@NotNull OpenEndRange<Long> openEndRange, byte b16) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Long.valueOf(b16));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final long random(LongRange longRange) {
        Intrinsics.checkNotNullParameter(longRange, "<this>");
        return random(longRange, Random.INSTANCE);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final Long randomOrNull(LongRange longRange) {
        Intrinsics.checkNotNullParameter(longRange, "<this>");
        return randomOrNull(longRange, Random.INSTANCE);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final LongRange rangeUntil(long j3, byte b16) {
        return until(j3, b16);
    }

    @NotNull
    public static final LongProgression reversed(@NotNull LongProgression longProgression) {
        Intrinsics.checkNotNullParameter(longProgression, "<this>");
        return LongProgression.INSTANCE.fromClosedRange(longProgression.getLast(), longProgression.getFirst(), -longProgression.getStep());
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(@NotNull OpenEndRange<Short> openEndRange, byte b16) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Short.valueOf(b16));
    }

    @Nullable
    public static final Byte toByteExactOrNull(long j3) {
        if (new LongRange(-128L, 127L).contains(j3)) {
            return Byte.valueOf((byte) j3);
        }
        return null;
    }

    @Nullable
    public static final Integer toIntExactOrNull(double d16) {
        boolean z16 = false;
        if (-2.147483648E9d <= d16 && d16 <= 2.147483647E9d) {
            z16 = true;
        }
        if (z16) {
            return Integer.valueOf((int) d16);
        }
        return null;
    }

    @Nullable
    public static final Long toLongExactOrNull(float f16) {
        boolean z16 = false;
        if (-9.223372E18f <= f16 && f16 <= 9.223372E18f) {
            z16 = true;
        }
        if (z16) {
            return Long.valueOf(f16);
        }
        return null;
    }

    @Nullable
    public static final Short toShortExactOrNull(long j3) {
        if (new LongRange(-32768L, 32767L).contains(j3)) {
            return Short.valueOf((short) j3);
        }
        return null;
    }

    @NotNull
    public static final LongRange until(long j3, byte b16) {
        return new LongRange(j3, b16 - 1);
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(@NotNull ClosedRange<Byte> closedRange, int i3) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(i3);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static float coerceAtLeast(float f16, float f17) {
        return f16 < f17 ? f17 : f16;
    }

    public static float coerceAtMost(float f16, float f17) {
        return f16 > f17 ? f17 : f16;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean contains(CharRange charRange, Character ch5) {
        Intrinsics.checkNotNullParameter(charRange, "<this>");
        return ch5 != null && charRange.contains(ch5.charValue());
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @JvmName(name = "doubleRangeContains")
    public static final boolean doubleRangeContains(@NotNull OpenEndRange<Double> openEndRange, float f16) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Double.valueOf(f16));
    }

    @NotNull
    public static final IntProgression downTo(byte b16, byte b17) {
        return IntProgression.INSTANCE.fromClosedRange(b16, b17, -1);
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Character firstOrNull(@NotNull CharProgression charProgression) {
        Intrinsics.checkNotNullParameter(charProgression, "<this>");
        if (charProgression.isEmpty()) {
            return null;
        }
        return Character.valueOf(charProgression.getFirst());
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "floatRangeContains")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange closedRange, int i3) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Float.valueOf(i3));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "intRangeContains")
    public static final /* synthetic */ boolean intRangeContains(ClosedRange closedRange, double d16) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Integer intExactOrNull = toIntExactOrNull(d16);
        if (intExactOrNull != null) {
            return closedRange.contains(intExactOrNull);
        }
        return false;
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final Character lastOrNull(@NotNull CharProgression charProgression) {
        Intrinsics.checkNotNullParameter(charProgression, "<this>");
        if (charProgression.isEmpty()) {
            return null;
        }
        return Character.valueOf(charProgression.getLast());
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "longRangeContains")
    public static final /* synthetic */ boolean longRangeContains(ClosedRange closedRange, double d16) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Long longExactOrNull = toLongExactOrNull(d16);
        if (longExactOrNull != null) {
            return closedRange.contains(longExactOrNull);
        }
        return false;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final char random(CharRange charRange) {
        Intrinsics.checkNotNullParameter(charRange, "<this>");
        return random(charRange, Random.INSTANCE);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final Character randomOrNull(CharRange charRange) {
        Intrinsics.checkNotNullParameter(charRange, "<this>");
        return randomOrNull(charRange, Random.INSTANCE);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final IntRange rangeUntil(byte b16, byte b17) {
        return until(b16, b17);
    }

    @NotNull
    public static final CharProgression reversed(@NotNull CharProgression charProgression) {
        Intrinsics.checkNotNullParameter(charProgression, "<this>");
        return CharProgression.INSTANCE.fromClosedRange(charProgression.getLast(), charProgression.getFirst(), -charProgression.getStep());
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "shortRangeContains")
    public static final /* synthetic */ boolean shortRangeContains(ClosedRange closedRange, double d16) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Short shortExactOrNull = toShortExactOrNull(d16);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    @NotNull
    public static final LongProgression step(@NotNull LongProgression longProgression, long j3) {
        Intrinsics.checkNotNullParameter(longProgression, "<this>");
        RangesKt__RangesKt.checkStepIsPositive(j3 > 0, Long.valueOf(j3));
        LongProgression.Companion companion = LongProgression.INSTANCE;
        long first = longProgression.getFirst();
        long last = longProgression.getLast();
        if (longProgression.getStep() <= 0) {
            j3 = -j3;
        }
        return companion.fromClosedRange(first, last, j3);
    }

    @Nullable
    public static final Byte toByteExactOrNull(short s16) {
        if (intRangeContains((ClosedRange<Integer>) new IntRange(-128, 127), s16)) {
            return Byte.valueOf((byte) s16);
        }
        return null;
    }

    @Nullable
    public static final Integer toIntExactOrNull(float f16) {
        boolean z16 = false;
        if (-2.14748365E9f <= f16 && f16 <= 2.14748365E9f) {
            z16 = true;
        }
        if (z16) {
            return Integer.valueOf((int) f16);
        }
        return null;
    }

    @Nullable
    public static final Short toShortExactOrNull(double d16) {
        boolean z16 = false;
        if (-32768.0d <= d16 && d16 <= 32767.0d) {
            z16 = true;
        }
        if (z16) {
            return Short.valueOf((short) d16);
        }
        return null;
    }

    @NotNull
    public static final IntRange until(byte b16, byte b17) {
        return new IntRange(b16, b17 - 1);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(@NotNull OpenEndRange<Byte> openEndRange, int i3) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(i3);
        if (byteExactOrNull != null) {
            return openEndRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static int coerceAtLeast(int i3, int i16) {
        return i3 < i16 ? i16 : i3;
    }

    public static int coerceAtMost(int i3, int i16) {
        return i3 > i16 ? i16 : i3;
    }

    @InlineOnly
    private static final boolean contains(IntRange intRange, byte b16) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        return intRangeContains((ClosedRange<Integer>) intRange, b16);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "doubleRangeContains")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange closedRange, int i3) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Double.valueOf(i3));
    }

    @NotNull
    public static final IntProgression downTo(short s16, byte b16) {
        return IntProgression.INSTANCE.fromClosedRange(s16, b16, -1);
    }

    @SinceKotlin(version = "1.7")
    public static final long first(@NotNull LongProgression longProgression) {
        Intrinsics.checkNotNullParameter(longProgression, "<this>");
        if (!longProgression.isEmpty()) {
            return longProgression.getFirst();
        }
        throw new NoSuchElementException("Progression " + longProgression + " is empty.");
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "floatRangeContains")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange closedRange, long j3) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Float.valueOf((float) j3));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "intRangeContains")
    public static final /* synthetic */ boolean intRangeContains(ClosedRange closedRange, float f16) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Integer intExactOrNull = toIntExactOrNull(f16);
        if (intExactOrNull != null) {
            return closedRange.contains(intExactOrNull);
        }
        return false;
    }

    @SinceKotlin(version = "1.7")
    public static final long last(@NotNull LongProgression longProgression) {
        Intrinsics.checkNotNullParameter(longProgression, "<this>");
        if (!longProgression.isEmpty()) {
            return longProgression.getLast();
        }
        throw new NoSuchElementException("Progression " + longProgression + " is empty.");
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "longRangeContains")
    public static final /* synthetic */ boolean longRangeContains(ClosedRange closedRange, float f16) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Long longExactOrNull = toLongExactOrNull(f16);
        if (longExactOrNull != null) {
            return closedRange.contains(longExactOrNull);
        }
        return false;
    }

    @SinceKotlin(version = "1.3")
    public static int random(@NotNull IntRange intRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return RandomKt.nextInt(random, intRange);
        } catch (IllegalArgumentException e16) {
            throw new NoSuchElementException(e16.getMessage());
        }
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Integer randomOrNull(@NotNull IntRange intRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (intRange.isEmpty()) {
            return null;
        }
        return Integer.valueOf(RandomKt.nextInt(random, intRange));
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final IntRange rangeUntil(short s16, byte b16) {
        return until(s16, b16);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "shortRangeContains")
    public static final /* synthetic */ boolean shortRangeContains(ClosedRange closedRange, float f16) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Short shortExactOrNull = toShortExactOrNull(f16);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    @Nullable
    public static final Byte toByteExactOrNull(double d16) {
        boolean z16 = false;
        if (-128.0d <= d16 && d16 <= 127.0d) {
            z16 = true;
        }
        if (z16) {
            return Byte.valueOf((byte) d16);
        }
        return null;
    }

    @Nullable
    public static final Short toShortExactOrNull(float f16) {
        boolean z16 = false;
        if (-32768.0f <= f16 && f16 <= 32767.0f) {
            z16 = true;
        }
        if (z16) {
            return Short.valueOf((short) f16);
        }
        return null;
    }

    @NotNull
    public static final IntRange until(short s16, byte b16) {
        return new IntRange(s16, b16 - 1);
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(@NotNull ClosedRange<Byte> closedRange, long j3) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(j3);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static long coerceAtLeast(long j3, long j16) {
        return j3 < j16 ? j16 : j3;
    }

    public static long coerceAtMost(long j3, long j16) {
        return j3 > j16 ? j16 : j3;
    }

    @InlineOnly
    private static final boolean contains(LongRange longRange, byte b16) {
        Intrinsics.checkNotNullParameter(longRange, "<this>");
        return longRangeContains((ClosedRange<Long>) longRange, b16);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "doubleRangeContains")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange closedRange, long j3) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Double.valueOf(j3));
    }

    @NotNull
    public static final CharProgression downTo(char c16, char c17) {
        return CharProgression.INSTANCE.fromClosedRange(c16, c17, -1);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "floatRangeContains")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange closedRange, short s16) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Float.valueOf(s16));
    }

    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(@NotNull ClosedRange<Integer> closedRange, long j3) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Integer intExactOrNull = toIntExactOrNull(j3);
        if (intExactOrNull != null) {
            return closedRange.contains(intExactOrNull);
        }
        return false;
    }

    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(@NotNull ClosedRange<Long> closedRange, int i3) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Long.valueOf(i3));
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final CharRange rangeUntil(char c16, char c17) {
        return until(c16, c17);
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(@NotNull ClosedRange<Short> closedRange, int i3) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Short shortExactOrNull = toShortExactOrNull(i3);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    @NotNull
    public static final CharProgression step(@NotNull CharProgression charProgression, int i3) {
        Intrinsics.checkNotNullParameter(charProgression, "<this>");
        RangesKt__RangesKt.checkStepIsPositive(i3 > 0, Integer.valueOf(i3));
        CharProgression.Companion companion = CharProgression.INSTANCE;
        char first = charProgression.getFirst();
        char last = charProgression.getLast();
        if (charProgression.getStep() <= 0) {
            i3 = -i3;
        }
        return companion.fromClosedRange(first, last, i3);
    }

    @Nullable
    public static final Byte toByteExactOrNull(float f16) {
        boolean z16 = false;
        if (-128.0f <= f16 && f16 <= 127.0f) {
            z16 = true;
        }
        if (z16) {
            return Byte.valueOf((byte) f16);
        }
        return null;
    }

    @NotNull
    public static final CharRange until(char c16, char c17) {
        return Intrinsics.compare((int) c17, 0) <= 0 ? CharRange.INSTANCE.getEMPTY() : new CharRange(c16, (char) (c17 - 1));
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(@NotNull OpenEndRange<Byte> openEndRange, long j3) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(j3);
        if (byteExactOrNull != null) {
            return openEndRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final short coerceAtLeast(short s16, short s17) {
        return s16 < s17 ? s17 : s16;
    }

    public static final short coerceAtMost(short s16, short s17) {
        return s16 > s17 ? s17 : s16;
    }

    @InlineOnly
    private static final boolean contains(LongRange longRange, int i3) {
        Intrinsics.checkNotNullParameter(longRange, "<this>");
        return longRangeContains((ClosedRange<Long>) longRange, i3);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    @JvmName(name = "doubleRangeContains")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange closedRange, short s16) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Double.valueOf(s16));
    }

    @NotNull
    public static IntProgression downTo(int i3, int i16) {
        return IntProgression.INSTANCE.fromClosedRange(i3, i16, -1);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(@NotNull OpenEndRange<Integer> openEndRange, long j3) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Integer intExactOrNull = toIntExactOrNull(j3);
        if (intExactOrNull != null) {
            return openEndRange.contains(intExactOrNull);
        }
        return false;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(@NotNull OpenEndRange<Long> openEndRange, int i3) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Long.valueOf(i3));
    }

    @SinceKotlin(version = "1.3")
    public static final long random(@NotNull LongRange longRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(longRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return RandomKt.nextLong(random, longRange);
        } catch (IllegalArgumentException e16) {
            throw new NoSuchElementException(e16.getMessage());
        }
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Long randomOrNull(@NotNull LongRange longRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(longRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (longRange.isEmpty()) {
            return null;
        }
        return Long.valueOf(RandomKt.nextLong(random, longRange));
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final IntRange rangeUntil(int i3, int i16) {
        IntRange until;
        until = until(i3, i16);
        return until;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(@NotNull OpenEndRange<Short> openEndRange, int i3) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Short shortExactOrNull = toShortExactOrNull(i3);
        if (shortExactOrNull != null) {
            return openEndRange.contains(shortExactOrNull);
        }
        return false;
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(@NotNull ClosedRange<Byte> closedRange, short s16) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(s16);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T coerceAtLeast(@NotNull T t16, @NotNull T minimumValue) {
        Intrinsics.checkNotNullParameter(t16, "<this>");
        Intrinsics.checkNotNullParameter(minimumValue, "minimumValue");
        return t16.compareTo(minimumValue) < 0 ? minimumValue : t16;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T coerceAtMost(@NotNull T t16, @NotNull T maximumValue) {
        Intrinsics.checkNotNullParameter(t16, "<this>");
        Intrinsics.checkNotNullParameter(maximumValue, "maximumValue");
        return t16.compareTo(maximumValue) > 0 ? maximumValue : t16;
    }

    public static final byte coerceIn(byte b16, byte b17, byte b18) {
        if (b17 <= b18) {
            return b16 < b17 ? b17 : b16 > b18 ? b18 : b16;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) b18) + " is less than minimum " + ((int) b17) + '.');
    }

    @InlineOnly
    private static final boolean contains(IntRange intRange, long j3) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        return intRangeContains((ClosedRange<Integer>) intRange, j3);
    }

    @NotNull
    public static final LongProgression downTo(long j3, int i3) {
        return LongProgression.INSTANCE.fromClosedRange(j3, i3, -1L);
    }

    @SinceKotlin(version = "1.7")
    public static final char first(@NotNull CharProgression charProgression) {
        Intrinsics.checkNotNullParameter(charProgression, "<this>");
        if (!charProgression.isEmpty()) {
            return charProgression.getFirst();
        }
        throw new NoSuchElementException("Progression " + charProgression + " is empty.");
    }

    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(@NotNull ClosedRange<Integer> closedRange, short s16) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Integer.valueOf(s16));
    }

    @SinceKotlin(version = "1.7")
    public static final char last(@NotNull CharProgression charProgression) {
        Intrinsics.checkNotNullParameter(charProgression, "<this>");
        if (!charProgression.isEmpty()) {
            return charProgression.getLast();
        }
        throw new NoSuchElementException("Progression " + charProgression + " is empty.");
    }

    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(@NotNull ClosedRange<Long> closedRange, short s16) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        return closedRange.contains(Long.valueOf(s16));
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final LongRange rangeUntil(long j3, int i3) {
        return until(j3, i3);
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(@NotNull ClosedRange<Short> closedRange, long j3) {
        Intrinsics.checkNotNullParameter(closedRange, "<this>");
        Short shortExactOrNull = toShortExactOrNull(j3);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    @NotNull
    public static IntRange until(int i3, int i16) {
        if (i16 <= Integer.MIN_VALUE) {
            return IntRange.INSTANCE.getEMPTY();
        }
        return new IntRange(i3, i16 - 1);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(@NotNull OpenEndRange<Byte> openEndRange, short s16) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Byte byteExactOrNull = toByteExactOrNull(s16);
        if (byteExactOrNull != null) {
            return openEndRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final short coerceIn(short s16, short s17, short s18) {
        if (s17 <= s18) {
            return s16 < s17 ? s17 : s16 > s18 ? s18 : s16;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) s18) + " is less than minimum " + ((int) s17) + '.');
    }

    @InlineOnly
    private static final boolean contains(IntRange intRange, short s16) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        return intRangeContains((ClosedRange<Integer>) intRange, s16);
    }

    @NotNull
    public static final IntProgression downTo(byte b16, int i3) {
        return IntProgression.INSTANCE.fromClosedRange(b16, i3, -1);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(@NotNull OpenEndRange<Integer> openEndRange, short s16) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Integer.valueOf(s16));
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(@NotNull OpenEndRange<Long> openEndRange, short s16) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        return openEndRange.contains(Long.valueOf(s16));
    }

    @SinceKotlin(version = "1.3")
    public static final char random(@NotNull CharRange charRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(charRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return (char) random.nextInt(charRange.getFirst(), charRange.getLast() + 1);
        } catch (IllegalArgumentException e16) {
            throw new NoSuchElementException(e16.getMessage());
        }
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Character randomOrNull(@NotNull CharRange charRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(charRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (charRange.isEmpty()) {
            return null;
        }
        return Character.valueOf((char) random.nextInt(charRange.getFirst(), charRange.getLast() + 1));
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final IntRange rangeUntil(byte b16, int i3) {
        return until(b16, i3);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(@NotNull OpenEndRange<Short> openEndRange, long j3) {
        Intrinsics.checkNotNullParameter(openEndRange, "<this>");
        Short shortExactOrNull = toShortExactOrNull(j3);
        if (shortExactOrNull != null) {
            return openEndRange.contains(shortExactOrNull);
        }
        return false;
    }

    public static int coerceIn(int i3, int i16, int i17) {
        if (i16 <= i17) {
            return i3 < i16 ? i16 : i3 > i17 ? i17 : i3;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i17 + " is less than minimum " + i16 + '.');
    }

    @InlineOnly
    private static final boolean contains(LongRange longRange, short s16) {
        Intrinsics.checkNotNullParameter(longRange, "<this>");
        return longRangeContains((ClosedRange<Long>) longRange, s16);
    }

    @NotNull
    public static final IntProgression downTo(short s16, int i3) {
        return IntProgression.INSTANCE.fromClosedRange(s16, i3, -1);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final IntRange rangeUntil(short s16, int i3) {
        return until(s16, i3);
    }

    @NotNull
    public static final LongRange until(long j3, int i3) {
        return new LongRange(j3, i3 - 1);
    }

    public static long coerceIn(long j3, long j16, long j17) {
        if (j16 <= j17) {
            return j3 < j16 ? j16 : j3 > j17 ? j17 : j3;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j17 + " is less than minimum " + j16 + '.');
    }

    @NotNull
    public static final LongProgression downTo(int i3, long j3) {
        return LongProgression.INSTANCE.fromClosedRange(i3, j3, -1L);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final LongRange rangeUntil(int i3, long j3) {
        return until(i3, j3);
    }

    @NotNull
    public static final IntRange until(byte b16, int i3) {
        if (i3 <= Integer.MIN_VALUE) {
            return IntRange.INSTANCE.getEMPTY();
        }
        return new IntRange(b16, i3 - 1);
    }

    public static float coerceIn(float f16, float f17, float f18) {
        if (f17 <= f18) {
            return f16 < f17 ? f17 : f16 > f18 ? f18 : f16;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f18 + " is less than minimum " + f17 + '.');
    }

    @NotNull
    public static final LongProgression downTo(long j3, long j16) {
        return LongProgression.INSTANCE.fromClosedRange(j3, j16, -1L);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final LongRange rangeUntil(long j3, long j16) {
        return until(j3, j16);
    }

    public static double coerceIn(double d16, double d17, double d18) {
        if (d17 <= d18) {
            return d16 < d17 ? d17 : d16 > d18 ? d18 : d16;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d18 + " is less than minimum " + d17 + '.');
    }

    @NotNull
    public static final LongProgression downTo(byte b16, long j3) {
        return LongProgression.INSTANCE.fromClosedRange(b16, j3, -1L);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final LongRange rangeUntil(byte b16, long j3) {
        return until(b16, j3);
    }

    @NotNull
    public static final IntRange until(short s16, int i3) {
        if (i3 <= Integer.MIN_VALUE) {
            return IntRange.INSTANCE.getEMPTY();
        }
        return new IntRange(s16, i3 - 1);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T coerceIn(@NotNull T t16, @NotNull ClosedFloatingPointRange<T> range) {
        Intrinsics.checkNotNullParameter(t16, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (!range.isEmpty()) {
            return (!range.lessThanOrEquals(t16, range.getStart()) || range.lessThanOrEquals(range.getStart(), t16)) ? (!range.lessThanOrEquals(range.getEndInclusive(), t16) || range.lessThanOrEquals(t16, range.getEndInclusive())) ? t16 : range.getEndInclusive() : range.getStart();
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @NotNull
    public static final LongProgression downTo(short s16, long j3) {
        return LongProgression.INSTANCE.fromClosedRange(s16, j3, -1L);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final LongRange rangeUntil(short s16, long j3) {
        return until(s16, j3);
    }

    @NotNull
    public static final IntProgression downTo(int i3, short s16) {
        return IntProgression.INSTANCE.fromClosedRange(i3, s16, -1);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final IntRange rangeUntil(int i3, short s16) {
        return until(i3, s16);
    }

    @NotNull
    public static final LongRange until(int i3, long j3) {
        if (j3 <= Long.MIN_VALUE) {
            return LongRange.INSTANCE.getEMPTY();
        }
        return new LongRange(i3, j3 - 1);
    }

    @NotNull
    public static final LongProgression downTo(long j3, short s16) {
        return LongProgression.INSTANCE.fromClosedRange(j3, s16, -1L);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final LongRange rangeUntil(long j3, short s16) {
        return until(j3, s16);
    }

    @NotNull
    public static final IntProgression downTo(byte b16, short s16) {
        return IntProgression.INSTANCE.fromClosedRange(b16, s16, -1);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final IntRange rangeUntil(byte b16, short s16) {
        return until(b16, s16);
    }

    @NotNull
    public static final LongRange until(long j3, long j16) {
        if (j16 <= Long.MIN_VALUE) {
            return LongRange.INSTANCE.getEMPTY();
        }
        return new LongRange(j3, j16 - 1);
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T coerceIn(@NotNull T t16, @NotNull ClosedRange<T> range) {
        Intrinsics.checkNotNullParameter(t16, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return (T) coerceIn((Comparable) t16, (ClosedFloatingPointRange) range);
        }
        if (!range.isEmpty()) {
            return t16.compareTo(range.getStart()) < 0 ? range.getStart() : t16.compareTo(range.getEndInclusive()) > 0 ? range.getEndInclusive() : t16;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @NotNull
    public static final IntProgression downTo(short s16, short s17) {
        return IntProgression.INSTANCE.fromClosedRange(s16, s17, -1);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    private static final IntRange rangeUntil(short s16, short s17) {
        return until(s16, s17);
    }

    @NotNull
    public static final LongRange until(byte b16, long j3) {
        if (j3 <= Long.MIN_VALUE) {
            return LongRange.INSTANCE.getEMPTY();
        }
        return new LongRange(b16, j3 - 1);
    }

    @NotNull
    public static final LongRange until(short s16, long j3) {
        if (j3 <= Long.MIN_VALUE) {
            return LongRange.INSTANCE.getEMPTY();
        }
        return new LongRange(s16, j3 - 1);
    }

    @NotNull
    public static final IntRange until(int i3, short s16) {
        return new IntRange(i3, s16 - 1);
    }

    public static int coerceIn(int i3, @NotNull ClosedRange<Integer> range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return ((Number) coerceIn(Integer.valueOf(i3), (ClosedFloatingPointRange<Integer>) range)).intValue();
        }
        if (!range.isEmpty()) {
            return i3 < range.getStart().intValue() ? range.getStart().intValue() : i3 > range.getEndInclusive().intValue() ? range.getEndInclusive().intValue() : i3;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @NotNull
    public static final LongRange until(long j3, short s16) {
        return new LongRange(j3, s16 - 1);
    }

    @NotNull
    public static final IntRange until(byte b16, short s16) {
        return new IntRange(b16, s16 - 1);
    }

    @NotNull
    public static final IntRange until(short s16, short s17) {
        return new IntRange(s16, s17 - 1);
    }

    public static long coerceIn(long j3, @NotNull ClosedRange<Long> range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return ((Number) coerceIn(Long.valueOf(j3), (ClosedFloatingPointRange<Long>) range)).longValue();
        }
        if (!range.isEmpty()) {
            return j3 < range.getStart().longValue() ? range.getStart().longValue() : j3 > range.getEndInclusive().longValue() ? range.getEndInclusive().longValue() : j3;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }
}
