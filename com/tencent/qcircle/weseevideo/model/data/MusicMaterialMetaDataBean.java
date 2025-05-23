package com.tencent.qcircle.weseevideo.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.provider.BaseColumns;
import com.google.gson.annotations.SerializedName;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qcircle.weishi.module.publisher.data.VolumeAutomaticEffect;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\bI\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u009f\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u009f\u0001\u00a0\u0001B\u00d3\u0005\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\r\u0012\b\b\u0002\u0010\u001a\u001a\u00020\r\u0012\b\b\u0002\u0010\u001b\u001a\u00020\r\u0012\b\b\u0002\u0010\u001c\u001a\u00020\r\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u001f\u001a\u00020\r\u0012\b\b\u0002\u0010 \u001a\u00020\r\u0012\b\b\u0002\u0010!\u001a\u00020\r\u0012\b\b\u0002\u0010\"\u001a\u00020\r\u0012\b\b\u0002\u0010#\u001a\u00020\u0007\u0012\b\b\u0002\u0010$\u001a\u00020\r\u0012\b\b\u0002\u0010%\u001a\u00020\r\u0012\b\b\u0002\u0010&\u001a\u00020'\u0012\b\b\u0002\u0010(\u001a\u00020\r\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005\u0018\u00010/\u0012\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u0014\u0012\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u0014\u0012\b\b\u0002\u00103\u001a\u00020\r\u0012\b\b\u0002\u00104\u001a\u00020\r\u0012\b\b\u0002\u00105\u001a\u00020\r\u0012\b\b\u0002\u00106\u001a\u00020\r\u0012\b\b\u0002\u00107\u001a\u00020\r\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u00109\u001a\u00020:\u0012\b\b\u0002\u0010;\u001a\u00020\r\u0012\b\b\u0002\u0010<\u001a\u00020\r\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010?\u001a\u00020:\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010A\u001a\u00020:\u0012\b\b\u0002\u0010B\u001a\u00020\u0007\u0012\b\b\u0002\u0010C\u001a\u00020\u0007\u0012\b\b\u0002\u0010D\u001a\u00020\u0007\u0012\b\b\u0002\u0010E\u001a\u00020\u0007\u0012\b\b\u0002\u0010F\u001a\u00020:\u0012\b\b\u0002\u0010G\u001a\u00020\u0007\u0012\b\b\u0002\u0010H\u001a\u00020I\u0012\b\b\u0002\u0010J\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010K\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010L\u00a2\u0006\u0002\u0010NJ\t\u0010S\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0011\u0010W\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014H\u00c6\u0003J\t\u0010X\u001a\u00020\rH\u00c6\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010Z\u001a\u00020\rH\u00c6\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\\\u001a\u00020\rH\u00c6\u0003J\t\u0010]\u001a\u00020\rH\u00c6\u0003J\t\u0010^\u001a\u00020\u0007H\u00c6\u0003J\t\u0010_\u001a\u00020\rH\u00c6\u0003J\t\u0010`\u001a\u00020\rH\u00c6\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010c\u001a\u00020\rH\u00c6\u0003J\t\u0010d\u001a\u00020\rH\u00c6\u0003J\t\u0010e\u001a\u00020\rH\u00c6\u0003J\t\u0010f\u001a\u00020\rH\u00c6\u0003J\t\u0010g\u001a\u00020\u0007H\u00c6\u0003J\t\u0010h\u001a\u00020\rH\u00c6\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010j\u001a\u00020\rH\u00c6\u0003J\t\u0010k\u001a\u00020'H\u00c6\u0003J\t\u0010l\u001a\u00020\rH\u00c6\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0017\u0010r\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005\u0018\u00010/H\u00c6\u0003J\u0011\u0010s\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u0014H\u00c6\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0011\u0010u\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u0014H\u00c6\u0003J\t\u0010v\u001a\u00020\rH\u00c6\u0003J\t\u0010w\u001a\u00020\rH\u00c6\u0003J\t\u0010x\u001a\u00020\rH\u00c6\u0003J\t\u0010y\u001a\u00020\rH\u00c6\u0003J\t\u0010z\u001a\u00020\rH\u00c6\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010|\u001a\u00020:H\u00c6\u0003J\t\u0010}\u001a\u00020\rH\u00c6\u0003J\t\u0010~\u001a\u00020\rH\u00c6\u0003J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\n\u0010\u0082\u0001\u001a\u00020:H\u00c6\u0003J\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\n\u0010\u0084\u0001\u001a\u00020:H\u00c6\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0007H\u00c6\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0007H\u00c6\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0007H\u00c6\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0007H\u00c6\u0003J\n\u0010\u0089\u0001\u001a\u00020:H\u00c6\u0003J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0007H\u00c6\u0003J\n\u0010\u008c\u0001\u001a\u00020IH\u00c6\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0007H\u00c6\u0003J\u0012\u0010\u008e\u0001\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010LH\u00c6\u0003J\n\u0010\u008f\u0001\u001a\u00020\rH\u00c6\u0003J\n\u0010\u0090\u0001\u001a\u00020\rH\u00c6\u0003J\f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u00d8\u0005\u0010\u0092\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0017\u001a\u00020\r2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\r2\b\b\u0002\u0010#\u001a\u00020\u00072\b\b\u0002\u0010$\u001a\u00020\r2\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\r2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005\u0018\u00010/2\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u00142\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u00142\b\b\u0002\u00103\u001a\u00020\r2\b\b\u0002\u00104\u001a\u00020\r2\b\b\u0002\u00105\u001a\u00020\r2\b\b\u0002\u00106\u001a\u00020\r2\b\b\u0002\u00107\u001a\u00020\r2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020\r2\b\b\u0002\u0010<\u001a\u00020\r2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010?\u001a\u00020:2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010A\u001a\u00020:2\b\b\u0002\u0010B\u001a\u00020\u00072\b\b\u0002\u0010C\u001a\u00020\u00072\b\b\u0002\u0010D\u001a\u00020\u00072\b\b\u0002\u0010E\u001a\u00020\u00072\b\b\u0002\u0010F\u001a\u00020:2\b\b\u0002\u0010G\u001a\u00020\u00072\b\b\u0002\u0010H\u001a\u00020I2\b\b\u0002\u0010J\u001a\u00020\u00072\u0010\b\u0002\u0010K\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010LH\u00c6\u0001J\u0007\u0010\u0093\u0001\u001a\u00020\u0000J\n\u0010\u0094\u0001\u001a\u00020\rH\u00d6\u0001J\u0016\u0010\u0095\u0001\u001a\u00020:2\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001H\u00d6\u0003J\n\u0010\u0098\u0001\u001a\u00020\rH\u00d6\u0001J\n\u0010\u0099\u0001\u001a\u00020\u0005H\u00d6\u0001J\u001e\u0010\u009a\u0001\u001a\u00030\u009b\u00012\b\u0010\u009c\u0001\u001a\u00030\u009d\u00012\u0007\u0010\u009e\u0001\u001a\u00020\rH\u00d6\u0001R\u0012\u0010$\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u00020'8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u00108\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010D\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\b\n\u0000\u0012\u0004\bO\u0010PR\u0012\u0010\u001b\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010;\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010B\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u00103\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u00109\u001a\u00020:8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010F\u001a\u00020:8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010A\u001a\u00020:8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010?\u001a\u00020:8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010)\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u00104\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u00105\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\b\n\u0000\u0012\u0004\bQ\u0010PR\u0012\u0010J\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010K\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010L8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010>\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010=\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u00106\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010,\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010<\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R \u0010.\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005\u0018\u00010/8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010C\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\b\n\u0000\u0012\u0004\bR\u0010PR\u0012\u0010E\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u00107\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010@\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010G\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010H\u001a\u00020I8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u00a1\u0001"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/data/MusicMaterialMetaDataBean;", "Landroid/provider/BaseColumns;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "id", "", "sid", "", "name", "desc", "type", "thumbUrl", "version", "", "miniSptVersion", "packageUrl", "path", "feedlist_time_id", "feedlist_hot_id", "topic_ids", "", "mask", "shortName", "rich_flag", "title", "feedNum", "startTime", "endTime", "orgStartTime", "followFeedId", "mTogetherFeed", "mTogetherType", "mFeedUseType", "mDefaultFeedPosition", "mDefaultTogetherFeed", "collectTime", "audioDuration", "isCollected", "autoPlay", "", "exclusive", "lyric", "secLyric", "lyricFormat", "secLyricFormat", "label", "songLabels", "", "nameIndices", "Lcom/tencent/qcircle/weseevideo/model/data/MusicMaterialMetaDataBean$HighlightIndex;", "descIndices", "indexInCategory", "mFromDataType", "mTotalTime", "refer", "state", "categroyId", "isCloseLyric", "", "iSource", "segDuration", "recommendInfo", "musicFrom", "isStuckPoint", "stuckPointJsonUrl", "isImportType", "importTime", "startInTime", "endOutTime", "startPlayOffset", "isEdit", "userStartTime", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "", "mTotalTimeMs", "mVolumeAutomaticEffectList", "", "Lcom/tencent/qcircle/weishi/module/publisher/data/VolumeAutomaticEffect;", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;ILjava/lang/String;IIIILjava/lang/String;Ljava/lang/String;IIIIJIIBILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/util/List;IIIIILjava/lang/String;ZIILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZJJJJZJFJLjava/util/List;)V", "endOutTime$annotations", "()V", "mTotalTime$annotations", "startInTime$annotations", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component6", "component60", "component61", "component62", "component63", "component7", "component8", "component9", "copy", "deepClone", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "Companion", "HighlightIndex", "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final /* data */ class MusicMaterialMetaDataBean implements BaseColumns, Serializable, Parcelable {
    public static final int ReferDefault = 0;
    public static final int ReferDuiQi = 2;
    public static final int ReferLocalVideo = 1;

    @JvmField
    public int audioDuration;

    @JvmField
    public byte autoPlay;

    @JvmField
    @Nullable
    public String categroyId;

    @JvmField
    public long collectTime;

    @JvmField
    @Nullable
    public String desc;

    @SerializedName("descindex")
    @JvmField
    @Nullable
    public List<HighlightIndex> descIndices;

    @JvmField
    public long endOutTime;

    @JvmField
    public int endTime;

    @JvmField
    public int exclusive;

    @JvmField
    public int feedNum;

    @JvmField
    @Nullable
    public String feedlist_hot_id;

    @JvmField
    @Nullable
    public String feedlist_time_id;

    @JvmField
    @Nullable
    public String followFeedId;

    @JvmField
    public int iSource;

    @JvmField
    @NotNull
    public String id;

    @JvmField
    public long importTime;

    @JvmField
    public int indexInCategory;

    @JvmField
    public boolean isCloseLyric;

    @JvmField
    public int isCollected;

    @JvmField
    public boolean isEdit;

    @JvmField
    public boolean isImportType;

    @JvmField
    public boolean isStuckPoint;

    @JvmField
    @Nullable
    public String label;

    @JvmField
    @Nullable
    public String lyric;

    @JvmField
    @Nullable
    public String lyricFormat;

    @JvmField
    public int mDefaultFeedPosition;

    @JvmField
    public int mDefaultTogetherFeed;

    @JvmField
    public int mFeedUseType;

    @JvmField
    public int mFromDataType;

    @JvmField
    @Nullable
    public String mTogetherFeed;

    @JvmField
    public int mTogetherType;

    @JvmField
    public int mTotalTime;

    @JvmField
    public long mTotalTimeMs;

    @JvmField
    @Nullable
    public List<VolumeAutomaticEffect> mVolumeAutomaticEffectList;

    @JvmField
    public int mask;

    @JvmField
    public int miniSptVersion;

    @JvmField
    @Nullable
    public String musicFrom;

    @JvmField
    @Nullable
    public String name;

    @SerializedName("titleindex")
    @JvmField
    @Nullable
    public List<HighlightIndex> nameIndices;

    @JvmField
    public int orgStartTime;

    @JvmField
    @Nullable
    public String packageUrl;

    @JvmField
    @Nullable
    public String path;

    @JvmField
    @Nullable
    public String recommendInfo;

    @JvmField
    public int refer;

    @JvmField
    public int rich_flag;

    @JvmField
    @Nullable
    public String secLyric;

    @JvmField
    @Nullable
    public String secLyricFormat;

    @JvmField
    public int segDuration;

    @JvmField
    @Nullable
    public String shortName;

    @JvmField
    public long sid;

    @JvmField
    @Nullable
    public Map<Integer, String> songLabels;

    @JvmField
    public long startInTime;

    @JvmField
    public long startPlayOffset;

    @JvmField
    public int startTime;

    @JvmField
    public int state;

    @JvmField
    @Nullable
    public String stuckPointJsonUrl;

    @JvmField
    @Nullable
    public String thumbUrl;

    @JvmField
    @Nullable
    public String title;

    @JvmField
    @Nullable
    public List<String> topic_ids;

    @JvmField
    @Nullable
    public String type;

    @JvmField
    public long userStartTime;

    @JvmField
    public int version;

    @JvmField
    public float volume;
    public static final Parcelable.Creator CREATOR = new Creator();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object createFromParcel(@NotNull Parcel in5) {
            String str;
            String str2;
            String str3;
            LinkedHashMap linkedHashMap;
            ArrayList arrayList;
            ArrayList arrayList2;
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            ArrayList arrayList3;
            Intrinsics.checkParameterIsNotNull(in5, "in");
            String readString = in5.readString();
            long readLong = in5.readLong();
            String readString2 = in5.readString();
            String readString3 = in5.readString();
            String readString4 = in5.readString();
            String readString5 = in5.readString();
            int readInt = in5.readInt();
            int readInt2 = in5.readInt();
            String readString6 = in5.readString();
            String readString7 = in5.readString();
            String readString8 = in5.readString();
            String readString9 = in5.readString();
            ArrayList<String> createStringArrayList = in5.createStringArrayList();
            int readInt3 = in5.readInt();
            String readString10 = in5.readString();
            int readInt4 = in5.readInt();
            String readString11 = in5.readString();
            int readInt5 = in5.readInt();
            int readInt6 = in5.readInt();
            int readInt7 = in5.readInt();
            int readInt8 = in5.readInt();
            String readString12 = in5.readString();
            String readString13 = in5.readString();
            int readInt9 = in5.readInt();
            int readInt10 = in5.readInt();
            int readInt11 = in5.readInt();
            int readInt12 = in5.readInt();
            long readLong2 = in5.readLong();
            int readInt13 = in5.readInt();
            int readInt14 = in5.readInt();
            byte readByte = in5.readByte();
            int readInt15 = in5.readInt();
            String readString14 = in5.readString();
            String readString15 = in5.readString();
            String readString16 = in5.readString();
            String readString17 = in5.readString();
            String readString18 = in5.readString();
            if (in5.readInt() != 0) {
                int readInt16 = in5.readInt();
                str3 = readString9;
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(readInt16);
                while (readInt16 != 0) {
                    linkedHashMap2.put(Integer.valueOf(in5.readInt()), in5.readString());
                    readInt16--;
                    readString7 = readString7;
                    readString8 = readString8;
                }
                str = readString7;
                str2 = readString8;
                linkedHashMap = linkedHashMap2;
            } else {
                str = readString7;
                str2 = readString8;
                str3 = readString9;
                linkedHashMap = null;
            }
            if (in5.readInt() != 0) {
                int readInt17 = in5.readInt();
                ArrayList arrayList4 = new ArrayList(readInt17);
                while (readInt17 != 0) {
                    arrayList4.add((HighlightIndex) HighlightIndex.CREATOR.createFromParcel(in5));
                    readInt17--;
                }
                arrayList = arrayList4;
            } else {
                arrayList = null;
            }
            if (in5.readInt() != 0) {
                int readInt18 = in5.readInt();
                ArrayList arrayList5 = new ArrayList(readInt18);
                while (readInt18 != 0) {
                    arrayList5.add((HighlightIndex) HighlightIndex.CREATOR.createFromParcel(in5));
                    readInt18--;
                }
                arrayList2 = arrayList5;
            } else {
                arrayList2 = null;
            }
            int readInt19 = in5.readInt();
            int readInt20 = in5.readInt();
            int readInt21 = in5.readInt();
            int readInt22 = in5.readInt();
            int readInt23 = in5.readInt();
            String readString19 = in5.readString();
            if (in5.readInt() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            int readInt24 = in5.readInt();
            int readInt25 = in5.readInt();
            String readString20 = in5.readString();
            String readString21 = in5.readString();
            if (in5.readInt() != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            String readString22 = in5.readString();
            if (in5.readInt() != 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            long readLong3 = in5.readLong();
            long readLong4 = in5.readLong();
            long readLong5 = in5.readLong();
            long readLong6 = in5.readLong();
            if (in5.readInt() != 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            long readLong7 = in5.readLong();
            float readFloat = in5.readFloat();
            long readLong8 = in5.readLong();
            if (in5.readInt() != 0) {
                int readInt26 = in5.readInt();
                ArrayList arrayList6 = new ArrayList(readInt26);
                while (readInt26 != 0) {
                    arrayList6.add((VolumeAutomaticEffect) VolumeAutomaticEffect.CREATOR.createFromParcel(in5));
                    readInt26--;
                }
                arrayList3 = arrayList6;
            } else {
                arrayList3 = null;
            }
            return new MusicMaterialMetaDataBean(readString, readLong, readString2, readString3, readString4, readString5, readInt, readInt2, readString6, str, str2, str3, createStringArrayList, readInt3, readString10, readInt4, readString11, readInt5, readInt6, readInt7, readInt8, readString12, readString13, readInt9, readInt10, readInt11, readInt12, readLong2, readInt13, readInt14, readByte, readInt15, readString14, readString15, readString16, readString17, readString18, linkedHashMap, arrayList, arrayList2, readInt19, readInt20, readInt21, readInt22, readInt23, readString19, z16, readInt24, readInt25, readString20, readString21, z17, readString22, z18, readLong3, readLong4, readLong5, readLong6, z19, readLong7, readFloat, readLong8, arrayList3);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object[] newArray(int i3) {
            return new MusicMaterialMetaDataBean[i3];
        }
    }

    /* compiled from: P */
    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qcircle/weseevideo/model/data/MusicMaterialMetaDataBean$HighlightIndex;", "Landroid/os/Parcelable;", "start", "", c.E, "(II)V", "getLen", "()I", "setLen", "(I)V", "getStart", "setStart", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "libtavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public static final /* data */ class HighlightIndex implements Parcelable {
        public static final Parcelable.Creator CREATOR = new Creator();
        private int len;
        private int start;

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
        /* loaded from: classes22.dex */
        public static class Creator implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Object createFromParcel(@NotNull Parcel in5) {
                Intrinsics.checkParameterIsNotNull(in5, "in");
                return new HighlightIndex(in5.readInt(), in5.readInt());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Object[] newArray(int i3) {
                return new HighlightIndex[i3];
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public HighlightIndex() {
            this(r2, r2, 3, null);
            int i3 = 0;
        }

        public static /* synthetic */ HighlightIndex copy$default(HighlightIndex highlightIndex, int i3, int i16, int i17, Object obj) {
            if ((i17 & 1) != 0) {
                i3 = highlightIndex.start;
            }
            if ((i17 & 2) != 0) {
                i16 = highlightIndex.len;
            }
            return highlightIndex.copy(i3, i16);
        }

        /* renamed from: component1, reason: from getter */
        public final int getStart() {
            return this.start;
        }

        /* renamed from: component2, reason: from getter */
        public final int getLen() {
            return this.len;
        }

        @NotNull
        public final HighlightIndex copy(int start, int len) {
            return new HighlightIndex(start, len);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof HighlightIndex) {
                    HighlightIndex highlightIndex = (HighlightIndex) other;
                    if (this.start != highlightIndex.start || this.len != highlightIndex.len) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public final int getLen() {
            return this.len;
        }

        public final int getStart() {
            return this.start;
        }

        public int hashCode() {
            return (this.start * 31) + this.len;
        }

        public final void setLen(int i3) {
            this.len = i3;
        }

        public final void setStart(int i3) {
            this.start = i3;
        }

        @NotNull
        public String toString() {
            return "HighlightIndex(start=" + this.start + ", len=" + this.len + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            parcel.writeInt(this.start);
            parcel.writeInt(this.len);
        }

        public HighlightIndex(int i3, int i16) {
            this.start = i3;
            this.len = i16;
        }

        public /* synthetic */ HighlightIndex(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? 0 : i16);
        }
    }

    public MusicMaterialMetaDataBean() {
        this(null, 0L, null, null, null, null, 0, 0, null, null, null, null, null, 0, null, 0, null, 0, 0, 0, 0, null, null, 0, 0, 0, 0, 0L, 0, 0, (byte) 0, 0, null, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, null, false, 0, 0, null, null, false, null, false, 0L, 0L, 0L, 0L, false, 0L, 0.0f, 0L, null, -1, Integer.MAX_VALUE, null);
    }

    public static /* synthetic */ MusicMaterialMetaDataBean copy$default(MusicMaterialMetaDataBean musicMaterialMetaDataBean, String str, long j3, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9, List list, int i17, String str10, int i18, String str11, int i19, int i26, int i27, int i28, String str12, String str13, int i29, int i36, int i37, int i38, long j16, int i39, int i46, byte b16, int i47, String str14, String str15, String str16, String str17, String str18, Map map, List list2, List list3, int i48, int i49, int i56, int i57, int i58, String str19, boolean z16, int i59, int i65, String str20, String str21, boolean z17, String str22, boolean z18, long j17, long j18, long j19, long j26, boolean z19, long j27, float f16, long j28, List list4, int i66, int i67, Object obj) {
        String str23 = (i66 & 1) != 0 ? musicMaterialMetaDataBean.id : str;
        long j29 = (i66 & 2) != 0 ? musicMaterialMetaDataBean.sid : j3;
        String str24 = (i66 & 4) != 0 ? musicMaterialMetaDataBean.name : str2;
        String str25 = (i66 & 8) != 0 ? musicMaterialMetaDataBean.desc : str3;
        String str26 = (i66 & 16) != 0 ? musicMaterialMetaDataBean.type : str4;
        String str27 = (i66 & 32) != 0 ? musicMaterialMetaDataBean.thumbUrl : str5;
        int i68 = (i66 & 64) != 0 ? musicMaterialMetaDataBean.version : i3;
        int i69 = (i66 & 128) != 0 ? musicMaterialMetaDataBean.miniSptVersion : i16;
        String str28 = (i66 & 256) != 0 ? musicMaterialMetaDataBean.packageUrl : str6;
        String str29 = (i66 & 512) != 0 ? musicMaterialMetaDataBean.path : str7;
        String str30 = (i66 & 1024) != 0 ? musicMaterialMetaDataBean.feedlist_time_id : str8;
        return musicMaterialMetaDataBean.copy(str23, j29, str24, str25, str26, str27, i68, i69, str28, str29, str30, (i66 & 2048) != 0 ? musicMaterialMetaDataBean.feedlist_hot_id : str9, (i66 & 4096) != 0 ? musicMaterialMetaDataBean.topic_ids : list, (i66 & 8192) != 0 ? musicMaterialMetaDataBean.mask : i17, (i66 & 16384) != 0 ? musicMaterialMetaDataBean.shortName : str10, (i66 & 32768) != 0 ? musicMaterialMetaDataBean.rich_flag : i18, (i66 & 65536) != 0 ? musicMaterialMetaDataBean.title : str11, (i66 & 131072) != 0 ? musicMaterialMetaDataBean.feedNum : i19, (i66 & 262144) != 0 ? musicMaterialMetaDataBean.startTime : i26, (i66 & 524288) != 0 ? musicMaterialMetaDataBean.endTime : i27, (i66 & 1048576) != 0 ? musicMaterialMetaDataBean.orgStartTime : i28, (i66 & 2097152) != 0 ? musicMaterialMetaDataBean.followFeedId : str12, (i66 & 4194304) != 0 ? musicMaterialMetaDataBean.mTogetherFeed : str13, (i66 & 8388608) != 0 ? musicMaterialMetaDataBean.mTogetherType : i29, (i66 & 16777216) != 0 ? musicMaterialMetaDataBean.mFeedUseType : i36, (i66 & 33554432) != 0 ? musicMaterialMetaDataBean.mDefaultFeedPosition : i37, (i66 & 67108864) != 0 ? musicMaterialMetaDataBean.mDefaultTogetherFeed : i38, (i66 & 134217728) != 0 ? musicMaterialMetaDataBean.collectTime : j16, (i66 & 268435456) != 0 ? musicMaterialMetaDataBean.audioDuration : i39, (536870912 & i66) != 0 ? musicMaterialMetaDataBean.isCollected : i46, (i66 & 1073741824) != 0 ? musicMaterialMetaDataBean.autoPlay : b16, (i66 & Integer.MIN_VALUE) != 0 ? musicMaterialMetaDataBean.exclusive : i47, (i67 & 1) != 0 ? musicMaterialMetaDataBean.lyric : str14, (i67 & 2) != 0 ? musicMaterialMetaDataBean.secLyric : str15, (i67 & 4) != 0 ? musicMaterialMetaDataBean.lyricFormat : str16, (i67 & 8) != 0 ? musicMaterialMetaDataBean.secLyricFormat : str17, (i67 & 16) != 0 ? musicMaterialMetaDataBean.label : str18, (i67 & 32) != 0 ? musicMaterialMetaDataBean.songLabels : map, (i67 & 64) != 0 ? musicMaterialMetaDataBean.nameIndices : list2, (i67 & 128) != 0 ? musicMaterialMetaDataBean.descIndices : list3, (i67 & 256) != 0 ? musicMaterialMetaDataBean.indexInCategory : i48, (i67 & 512) != 0 ? musicMaterialMetaDataBean.mFromDataType : i49, (i67 & 1024) != 0 ? musicMaterialMetaDataBean.mTotalTime : i56, (i67 & 2048) != 0 ? musicMaterialMetaDataBean.refer : i57, (i67 & 4096) != 0 ? musicMaterialMetaDataBean.state : i58, (i67 & 8192) != 0 ? musicMaterialMetaDataBean.categroyId : str19, (i67 & 16384) != 0 ? musicMaterialMetaDataBean.isCloseLyric : z16, (i67 & 32768) != 0 ? musicMaterialMetaDataBean.iSource : i59, (i67 & 65536) != 0 ? musicMaterialMetaDataBean.segDuration : i65, (i67 & 131072) != 0 ? musicMaterialMetaDataBean.recommendInfo : str20, (i67 & 262144) != 0 ? musicMaterialMetaDataBean.musicFrom : str21, (i67 & 524288) != 0 ? musicMaterialMetaDataBean.isStuckPoint : z17, (i67 & 1048576) != 0 ? musicMaterialMetaDataBean.stuckPointJsonUrl : str22, (i67 & 2097152) != 0 ? musicMaterialMetaDataBean.isImportType : z18, (i67 & 4194304) != 0 ? musicMaterialMetaDataBean.importTime : j17, (i67 & 8388608) != 0 ? musicMaterialMetaDataBean.startInTime : j18, (i67 & 16777216) != 0 ? musicMaterialMetaDataBean.endOutTime : j19, (i67 & 33554432) != 0 ? musicMaterialMetaDataBean.startPlayOffset : j26, (i67 & 67108864) != 0 ? musicMaterialMetaDataBean.isEdit : z19, (134217728 & i67) != 0 ? musicMaterialMetaDataBean.userStartTime : j27, (i67 & 268435456) != 0 ? musicMaterialMetaDataBean.volume : f16, (536870912 & i67) != 0 ? musicMaterialMetaDataBean.mTotalTimeMs : j28, (i67 & 1073741824) != 0 ? musicMaterialMetaDataBean.mVolumeAutomaticEffectList : list4);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final String getFeedlist_time_id() {
        return this.feedlist_time_id;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final String getFeedlist_hot_id() {
        return this.feedlist_hot_id;
    }

    @Nullable
    public final List<String> component13() {
        return this.topic_ids;
    }

    /* renamed from: component14, reason: from getter */
    public final int getMask() {
        return this.mask;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final String getShortName() {
        return this.shortName;
    }

    /* renamed from: component16, reason: from getter */
    public final int getRich_flag() {
        return this.rich_flag;
    }

    @Nullable
    /* renamed from: component17, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component18, reason: from getter */
    public final int getFeedNum() {
        return this.feedNum;
    }

    /* renamed from: component19, reason: from getter */
    public final int getStartTime() {
        return this.startTime;
    }

    /* renamed from: component2, reason: from getter */
    public final long getSid() {
        return this.sid;
    }

    /* renamed from: component20, reason: from getter */
    public final int getEndTime() {
        return this.endTime;
    }

    /* renamed from: component21, reason: from getter */
    public final int getOrgStartTime() {
        return this.orgStartTime;
    }

    @Nullable
    /* renamed from: component22, reason: from getter */
    public final String getFollowFeedId() {
        return this.followFeedId;
    }

    @Nullable
    /* renamed from: component23, reason: from getter */
    public final String getMTogetherFeed() {
        return this.mTogetherFeed;
    }

    /* renamed from: component24, reason: from getter */
    public final int getMTogetherType() {
        return this.mTogetherType;
    }

    /* renamed from: component25, reason: from getter */
    public final int getMFeedUseType() {
        return this.mFeedUseType;
    }

    /* renamed from: component26, reason: from getter */
    public final int getMDefaultFeedPosition() {
        return this.mDefaultFeedPosition;
    }

    /* renamed from: component27, reason: from getter */
    public final int getMDefaultTogetherFeed() {
        return this.mDefaultTogetherFeed;
    }

    /* renamed from: component28, reason: from getter */
    public final long getCollectTime() {
        return this.collectTime;
    }

    /* renamed from: component29, reason: from getter */
    public final int getAudioDuration() {
        return this.audioDuration;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component30, reason: from getter */
    public final int getIsCollected() {
        return this.isCollected;
    }

    /* renamed from: component31, reason: from getter */
    public final byte getAutoPlay() {
        return this.autoPlay;
    }

    /* renamed from: component32, reason: from getter */
    public final int getExclusive() {
        return this.exclusive;
    }

    @Nullable
    /* renamed from: component33, reason: from getter */
    public final String getLyric() {
        return this.lyric;
    }

    @Nullable
    /* renamed from: component34, reason: from getter */
    public final String getSecLyric() {
        return this.secLyric;
    }

    @Nullable
    /* renamed from: component35, reason: from getter */
    public final String getLyricFormat() {
        return this.lyricFormat;
    }

    @Nullable
    /* renamed from: component36, reason: from getter */
    public final String getSecLyricFormat() {
        return this.secLyricFormat;
    }

    @Nullable
    /* renamed from: component37, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    public final Map<Integer, String> component38() {
        return this.songLabels;
    }

    @Nullable
    public final List<HighlightIndex> component39() {
        return this.nameIndices;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @Nullable
    public final List<HighlightIndex> component40() {
        return this.descIndices;
    }

    /* renamed from: component41, reason: from getter */
    public final int getIndexInCategory() {
        return this.indexInCategory;
    }

    /* renamed from: component42, reason: from getter */
    public final int getMFromDataType() {
        return this.mFromDataType;
    }

    /* renamed from: component43, reason: from getter */
    public final int getMTotalTime() {
        return this.mTotalTime;
    }

    /* renamed from: component44, reason: from getter */
    public final int getRefer() {
        return this.refer;
    }

    /* renamed from: component45, reason: from getter */
    public final int getState() {
        return this.state;
    }

    @Nullable
    /* renamed from: component46, reason: from getter */
    public final String getCategroyId() {
        return this.categroyId;
    }

    /* renamed from: component47, reason: from getter */
    public final boolean getIsCloseLyric() {
        return this.isCloseLyric;
    }

    /* renamed from: component48, reason: from getter */
    public final int getISource() {
        return this.iSource;
    }

    /* renamed from: component49, reason: from getter */
    public final int getSegDuration() {
        return this.segDuration;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component50, reason: from getter */
    public final String getRecommendInfo() {
        return this.recommendInfo;
    }

    @Nullable
    /* renamed from: component51, reason: from getter */
    public final String getMusicFrom() {
        return this.musicFrom;
    }

    /* renamed from: component52, reason: from getter */
    public final boolean getIsStuckPoint() {
        return this.isStuckPoint;
    }

    @Nullable
    /* renamed from: component53, reason: from getter */
    public final String getStuckPointJsonUrl() {
        return this.stuckPointJsonUrl;
    }

    /* renamed from: component54, reason: from getter */
    public final boolean getIsImportType() {
        return this.isImportType;
    }

    /* renamed from: component55, reason: from getter */
    public final long getImportTime() {
        return this.importTime;
    }

    /* renamed from: component56, reason: from getter */
    public final long getStartInTime() {
        return this.startInTime;
    }

    /* renamed from: component57, reason: from getter */
    public final long getEndOutTime() {
        return this.endOutTime;
    }

    /* renamed from: component58, reason: from getter */
    public final long getStartPlayOffset() {
        return this.startPlayOffset;
    }

    /* renamed from: component59, reason: from getter */
    public final boolean getIsEdit() {
        return this.isEdit;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getThumbUrl() {
        return this.thumbUrl;
    }

    /* renamed from: component60, reason: from getter */
    public final long getUserStartTime() {
        return this.userStartTime;
    }

    /* renamed from: component61, reason: from getter */
    public final float getVolume() {
        return this.volume;
    }

    /* renamed from: component62, reason: from getter */
    public final long getMTotalTimeMs() {
        return this.mTotalTimeMs;
    }

    @Nullable
    public final List<VolumeAutomaticEffect> component63() {
        return this.mVolumeAutomaticEffectList;
    }

    /* renamed from: component7, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    /* renamed from: component8, reason: from getter */
    public final int getMiniSptVersion() {
        return this.miniSptVersion;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getPackageUrl() {
        return this.packageUrl;
    }

    @NotNull
    public final MusicMaterialMetaDataBean copy(@NotNull String id5, long sid, @Nullable String name, @Nullable String desc, @Nullable String type, @Nullable String thumbUrl, int version, int miniSptVersion, @Nullable String packageUrl, @Nullable String path, @Nullable String feedlist_time_id, @Nullable String feedlist_hot_id, @Nullable List<String> topic_ids, int mask, @Nullable String shortName, int rich_flag, @Nullable String title, int feedNum, int startTime, int endTime, int orgStartTime, @Nullable String followFeedId, @Nullable String mTogetherFeed, int mTogetherType, int mFeedUseType, int mDefaultFeedPosition, int mDefaultTogetherFeed, long collectTime, int audioDuration, int isCollected, byte autoPlay, int exclusive, @Nullable String lyric, @Nullable String secLyric, @Nullable String lyricFormat, @Nullable String secLyricFormat, @Nullable String label, @Nullable Map<Integer, String> songLabels, @Nullable List<HighlightIndex> nameIndices, @Nullable List<HighlightIndex> descIndices, int indexInCategory, int mFromDataType, int mTotalTime, int refer, int state, @Nullable String categroyId, boolean isCloseLyric, int iSource, int segDuration, @Nullable String recommendInfo, @Nullable String musicFrom, boolean isStuckPoint, @Nullable String stuckPointJsonUrl, boolean isImportType, long importTime, long startInTime, long endOutTime, long startPlayOffset, boolean isEdit, long userStartTime, float volume, long mTotalTimeMs, @Nullable List<VolumeAutomaticEffect> mVolumeAutomaticEffectList) {
        Intrinsics.checkParameterIsNotNull(id5, "id");
        return new MusicMaterialMetaDataBean(id5, sid, name, desc, type, thumbUrl, version, miniSptVersion, packageUrl, path, feedlist_time_id, feedlist_hot_id, topic_ids, mask, shortName, rich_flag, title, feedNum, startTime, endTime, orgStartTime, followFeedId, mTogetherFeed, mTogetherType, mFeedUseType, mDefaultFeedPosition, mDefaultTogetherFeed, collectTime, audioDuration, isCollected, autoPlay, exclusive, lyric, secLyric, lyricFormat, secLyricFormat, label, songLabels, nameIndices, descIndices, indexInCategory, mFromDataType, mTotalTime, refer, state, categroyId, isCloseLyric, iSource, segDuration, recommendInfo, musicFrom, isStuckPoint, stuckPointJsonUrl, isImportType, importTime, startInTime, endOutTime, startPlayOffset, isEdit, userStartTime, volume, mTotalTimeMs, mVolumeAutomaticEffectList);
    }

    @NotNull
    public final MusicMaterialMetaDataBean deepClone() {
        List list;
        List<VolumeAutomaticEffect> list2 = this.mVolumeAutomaticEffectList;
        if (list2 != null) {
            list = CollectionsKt___CollectionsKt.toMutableList((Collection) list2);
        } else {
            list = null;
        }
        return copy$default(this, null, 0L, null, null, null, null, 0, 0, null, null, null, null, null, 0, null, 0, null, 0, 0, 0, 0, null, null, 0, 0, 0, 0, 0L, 0, 0, (byte) 0, 0, null, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, null, false, 0, 0, null, null, false, null, false, 0L, 0L, 0L, 0L, false, 0L, 0.0f, 0L, list, -1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof MusicMaterialMetaDataBean) {
                MusicMaterialMetaDataBean musicMaterialMetaDataBean = (MusicMaterialMetaDataBean) other;
                if (!Intrinsics.areEqual(this.id, musicMaterialMetaDataBean.id) || this.sid != musicMaterialMetaDataBean.sid || !Intrinsics.areEqual(this.name, musicMaterialMetaDataBean.name) || !Intrinsics.areEqual(this.desc, musicMaterialMetaDataBean.desc) || !Intrinsics.areEqual(this.type, musicMaterialMetaDataBean.type) || !Intrinsics.areEqual(this.thumbUrl, musicMaterialMetaDataBean.thumbUrl) || this.version != musicMaterialMetaDataBean.version || this.miniSptVersion != musicMaterialMetaDataBean.miniSptVersion || !Intrinsics.areEqual(this.packageUrl, musicMaterialMetaDataBean.packageUrl) || !Intrinsics.areEqual(this.path, musicMaterialMetaDataBean.path) || !Intrinsics.areEqual(this.feedlist_time_id, musicMaterialMetaDataBean.feedlist_time_id) || !Intrinsics.areEqual(this.feedlist_hot_id, musicMaterialMetaDataBean.feedlist_hot_id) || !Intrinsics.areEqual(this.topic_ids, musicMaterialMetaDataBean.topic_ids) || this.mask != musicMaterialMetaDataBean.mask || !Intrinsics.areEqual(this.shortName, musicMaterialMetaDataBean.shortName) || this.rich_flag != musicMaterialMetaDataBean.rich_flag || !Intrinsics.areEqual(this.title, musicMaterialMetaDataBean.title) || this.feedNum != musicMaterialMetaDataBean.feedNum || this.startTime != musicMaterialMetaDataBean.startTime || this.endTime != musicMaterialMetaDataBean.endTime || this.orgStartTime != musicMaterialMetaDataBean.orgStartTime || !Intrinsics.areEqual(this.followFeedId, musicMaterialMetaDataBean.followFeedId) || !Intrinsics.areEqual(this.mTogetherFeed, musicMaterialMetaDataBean.mTogetherFeed) || this.mTogetherType != musicMaterialMetaDataBean.mTogetherType || this.mFeedUseType != musicMaterialMetaDataBean.mFeedUseType || this.mDefaultFeedPosition != musicMaterialMetaDataBean.mDefaultFeedPosition || this.mDefaultTogetherFeed != musicMaterialMetaDataBean.mDefaultTogetherFeed || this.collectTime != musicMaterialMetaDataBean.collectTime || this.audioDuration != musicMaterialMetaDataBean.audioDuration || this.isCollected != musicMaterialMetaDataBean.isCollected || this.autoPlay != musicMaterialMetaDataBean.autoPlay || this.exclusive != musicMaterialMetaDataBean.exclusive || !Intrinsics.areEqual(this.lyric, musicMaterialMetaDataBean.lyric) || !Intrinsics.areEqual(this.secLyric, musicMaterialMetaDataBean.secLyric) || !Intrinsics.areEqual(this.lyricFormat, musicMaterialMetaDataBean.lyricFormat) || !Intrinsics.areEqual(this.secLyricFormat, musicMaterialMetaDataBean.secLyricFormat) || !Intrinsics.areEqual(this.label, musicMaterialMetaDataBean.label) || !Intrinsics.areEqual(this.songLabels, musicMaterialMetaDataBean.songLabels) || !Intrinsics.areEqual(this.nameIndices, musicMaterialMetaDataBean.nameIndices) || !Intrinsics.areEqual(this.descIndices, musicMaterialMetaDataBean.descIndices) || this.indexInCategory != musicMaterialMetaDataBean.indexInCategory || this.mFromDataType != musicMaterialMetaDataBean.mFromDataType || this.mTotalTime != musicMaterialMetaDataBean.mTotalTime || this.refer != musicMaterialMetaDataBean.refer || this.state != musicMaterialMetaDataBean.state || !Intrinsics.areEqual(this.categroyId, musicMaterialMetaDataBean.categroyId) || this.isCloseLyric != musicMaterialMetaDataBean.isCloseLyric || this.iSource != musicMaterialMetaDataBean.iSource || this.segDuration != musicMaterialMetaDataBean.segDuration || !Intrinsics.areEqual(this.recommendInfo, musicMaterialMetaDataBean.recommendInfo) || !Intrinsics.areEqual(this.musicFrom, musicMaterialMetaDataBean.musicFrom) || this.isStuckPoint != musicMaterialMetaDataBean.isStuckPoint || !Intrinsics.areEqual(this.stuckPointJsonUrl, musicMaterialMetaDataBean.stuckPointJsonUrl) || this.isImportType != musicMaterialMetaDataBean.isImportType || this.importTime != musicMaterialMetaDataBean.importTime || this.startInTime != musicMaterialMetaDataBean.startInTime || this.endOutTime != musicMaterialMetaDataBean.endOutTime || this.startPlayOffset != musicMaterialMetaDataBean.startPlayOffset || this.isEdit != musicMaterialMetaDataBean.isEdit || this.userStartTime != musicMaterialMetaDataBean.userStartTime || Float.compare(this.volume, musicMaterialMetaDataBean.volume) != 0 || this.mTotalTimeMs != musicMaterialMetaDataBean.mTotalTimeMs || !Intrinsics.areEqual(this.mVolumeAutomaticEffectList, musicMaterialMetaDataBean.mVolumeAutomaticEffectList)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        int i46;
        int i47;
        int i48;
        int i49;
        int i56;
        int i57;
        int i58;
        int i59;
        int i65;
        int i66;
        int i67;
        int i68;
        int i69;
        String str = this.id;
        int i75 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        long j3 = this.sid;
        int i76 = ((i3 * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        String str2 = this.name;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i77 = (i76 + i16) * 31;
        String str3 = this.desc;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i78 = (i77 + i17) * 31;
        String str4 = this.type;
        if (str4 != null) {
            i18 = str4.hashCode();
        } else {
            i18 = 0;
        }
        int i79 = (i78 + i18) * 31;
        String str5 = this.thumbUrl;
        if (str5 != null) {
            i19 = str5.hashCode();
        } else {
            i19 = 0;
        }
        int i85 = (((((i79 + i19) * 31) + this.version) * 31) + this.miniSptVersion) * 31;
        String str6 = this.packageUrl;
        if (str6 != null) {
            i26 = str6.hashCode();
        } else {
            i26 = 0;
        }
        int i86 = (i85 + i26) * 31;
        String str7 = this.path;
        if (str7 != null) {
            i27 = str7.hashCode();
        } else {
            i27 = 0;
        }
        int i87 = (i86 + i27) * 31;
        String str8 = this.feedlist_time_id;
        if (str8 != null) {
            i28 = str8.hashCode();
        } else {
            i28 = 0;
        }
        int i88 = (i87 + i28) * 31;
        String str9 = this.feedlist_hot_id;
        if (str9 != null) {
            i29 = str9.hashCode();
        } else {
            i29 = 0;
        }
        int i89 = (i88 + i29) * 31;
        List<String> list = this.topic_ids;
        if (list != null) {
            i36 = list.hashCode();
        } else {
            i36 = 0;
        }
        int i95 = (((i89 + i36) * 31) + this.mask) * 31;
        String str10 = this.shortName;
        if (str10 != null) {
            i37 = str10.hashCode();
        } else {
            i37 = 0;
        }
        int i96 = (((i95 + i37) * 31) + this.rich_flag) * 31;
        String str11 = this.title;
        if (str11 != null) {
            i38 = str11.hashCode();
        } else {
            i38 = 0;
        }
        int i97 = (((((((((i96 + i38) * 31) + this.feedNum) * 31) + this.startTime) * 31) + this.endTime) * 31) + this.orgStartTime) * 31;
        String str12 = this.followFeedId;
        if (str12 != null) {
            i39 = str12.hashCode();
        } else {
            i39 = 0;
        }
        int i98 = (i97 + i39) * 31;
        String str13 = this.mTogetherFeed;
        if (str13 != null) {
            i46 = str13.hashCode();
        } else {
            i46 = 0;
        }
        int i99 = (((((((((i98 + i46) * 31) + this.mTogetherType) * 31) + this.mFeedUseType) * 31) + this.mDefaultFeedPosition) * 31) + this.mDefaultTogetherFeed) * 31;
        long j16 = this.collectTime;
        int i100 = (((((((((i99 + ((int) (j16 ^ (j16 >>> 32)))) * 31) + this.audioDuration) * 31) + this.isCollected) * 31) + this.autoPlay) * 31) + this.exclusive) * 31;
        String str14 = this.lyric;
        if (str14 != null) {
            i47 = str14.hashCode();
        } else {
            i47 = 0;
        }
        int i101 = (i100 + i47) * 31;
        String str15 = this.secLyric;
        if (str15 != null) {
            i48 = str15.hashCode();
        } else {
            i48 = 0;
        }
        int i102 = (i101 + i48) * 31;
        String str16 = this.lyricFormat;
        if (str16 != null) {
            i49 = str16.hashCode();
        } else {
            i49 = 0;
        }
        int i103 = (i102 + i49) * 31;
        String str17 = this.secLyricFormat;
        if (str17 != null) {
            i56 = str17.hashCode();
        } else {
            i56 = 0;
        }
        int i104 = (i103 + i56) * 31;
        String str18 = this.label;
        if (str18 != null) {
            i57 = str18.hashCode();
        } else {
            i57 = 0;
        }
        int i105 = (i104 + i57) * 31;
        Map<Integer, String> map = this.songLabels;
        if (map != null) {
            i58 = map.hashCode();
        } else {
            i58 = 0;
        }
        int i106 = (i105 + i58) * 31;
        List<HighlightIndex> list2 = this.nameIndices;
        if (list2 != null) {
            i59 = list2.hashCode();
        } else {
            i59 = 0;
        }
        int i107 = (i106 + i59) * 31;
        List<HighlightIndex> list3 = this.descIndices;
        if (list3 != null) {
            i65 = list3.hashCode();
        } else {
            i65 = 0;
        }
        int i108 = (((((((((((i107 + i65) * 31) + this.indexInCategory) * 31) + this.mFromDataType) * 31) + this.mTotalTime) * 31) + this.refer) * 31) + this.state) * 31;
        String str19 = this.categroyId;
        if (str19 != null) {
            i66 = str19.hashCode();
        } else {
            i66 = 0;
        }
        int i109 = (i108 + i66) * 31;
        boolean z16 = this.isCloseLyric;
        int i110 = 1;
        int i111 = z16;
        if (z16 != 0) {
            i111 = 1;
        }
        int i112 = (((((i109 + i111) * 31) + this.iSource) * 31) + this.segDuration) * 31;
        String str20 = this.recommendInfo;
        if (str20 != null) {
            i67 = str20.hashCode();
        } else {
            i67 = 0;
        }
        int i113 = (i112 + i67) * 31;
        String str21 = this.musicFrom;
        if (str21 != null) {
            i68 = str21.hashCode();
        } else {
            i68 = 0;
        }
        int i114 = (i113 + i68) * 31;
        boolean z17 = this.isStuckPoint;
        int i115 = z17;
        if (z17 != 0) {
            i115 = 1;
        }
        int i116 = (i114 + i115) * 31;
        String str22 = this.stuckPointJsonUrl;
        if (str22 != null) {
            i69 = str22.hashCode();
        } else {
            i69 = 0;
        }
        int i117 = (i116 + i69) * 31;
        boolean z18 = this.isImportType;
        int i118 = z18;
        if (z18 != 0) {
            i118 = 1;
        }
        long j17 = this.importTime;
        int i119 = (((i117 + i118) * 31) + ((int) (j17 ^ (j17 >>> 32)))) * 31;
        long j18 = this.startInTime;
        int i120 = (i119 + ((int) (j18 ^ (j18 >>> 32)))) * 31;
        long j19 = this.endOutTime;
        int i121 = (i120 + ((int) (j19 ^ (j19 >>> 32)))) * 31;
        long j26 = this.startPlayOffset;
        int i122 = (i121 + ((int) (j26 ^ (j26 >>> 32)))) * 31;
        boolean z19 = this.isEdit;
        if (!z19) {
            i110 = z19 ? 1 : 0;
        }
        long j27 = this.userStartTime;
        int floatToIntBits = (((((i122 + i110) * 31) + ((int) (j27 ^ (j27 >>> 32)))) * 31) + Float.floatToIntBits(this.volume)) * 31;
        long j28 = this.mTotalTimeMs;
        int i123 = (floatToIntBits + ((int) (j28 ^ (j28 >>> 32)))) * 31;
        List<VolumeAutomaticEffect> list4 = this.mVolumeAutomaticEffectList;
        if (list4 != null) {
            i75 = list4.hashCode();
        }
        return i123 + i75;
    }

    @NotNull
    public String toString() {
        return "MusicMaterialMetaDataBean(id=" + this.id + ", sid=" + this.sid + ", name=" + this.name + ", desc=" + this.desc + ", type=" + this.type + ", thumbUrl=" + this.thumbUrl + ", version=" + this.version + ", miniSptVersion=" + this.miniSptVersion + ", packageUrl=" + this.packageUrl + ", path=" + this.path + ", feedlist_time_id=" + this.feedlist_time_id + ", feedlist_hot_id=" + this.feedlist_hot_id + ", topic_ids=" + this.topic_ids + ", mask=" + this.mask + ", shortName=" + this.shortName + ", rich_flag=" + this.rich_flag + ", title=" + this.title + ", feedNum=" + this.feedNum + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", orgStartTime=" + this.orgStartTime + ", followFeedId=" + this.followFeedId + ", mTogetherFeed=" + this.mTogetherFeed + ", mTogetherType=" + this.mTogetherType + ", mFeedUseType=" + this.mFeedUseType + ", mDefaultFeedPosition=" + this.mDefaultFeedPosition + ", mDefaultTogetherFeed=" + this.mDefaultTogetherFeed + ", collectTime=" + this.collectTime + ", audioDuration=" + this.audioDuration + ", isCollected=" + this.isCollected + ", autoPlay=" + ((int) this.autoPlay) + ", exclusive=" + this.exclusive + ", lyric=" + this.lyric + ", secLyric=" + this.secLyric + ", lyricFormat=" + this.lyricFormat + ", secLyricFormat=" + this.secLyricFormat + ", label=" + this.label + ", songLabels=" + this.songLabels + ", nameIndices=" + this.nameIndices + ", descIndices=" + this.descIndices + ", indexInCategory=" + this.indexInCategory + ", mFromDataType=" + this.mFromDataType + ", mTotalTime=" + this.mTotalTime + ", refer=" + this.refer + ", state=" + this.state + ", categroyId=" + this.categroyId + ", isCloseLyric=" + this.isCloseLyric + ", iSource=" + this.iSource + ", segDuration=" + this.segDuration + ", recommendInfo=" + this.recommendInfo + ", musicFrom=" + this.musicFrom + ", isStuckPoint=" + this.isStuckPoint + ", stuckPointJsonUrl=" + this.stuckPointJsonUrl + ", isImportType=" + this.isImportType + ", importTime=" + this.importTime + ", startInTime=" + this.startInTime + ", endOutTime=" + this.endOutTime + ", startPlayOffset=" + this.startPlayOffset + ", isEdit=" + this.isEdit + ", userStartTime=" + this.userStartTime + ", volume=" + this.volume + ", mTotalTimeMs=" + this.mTotalTimeMs + ", mVolumeAutomaticEffectList=" + this.mVolumeAutomaticEffectList + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeLong(this.sid);
        parcel.writeString(this.name);
        parcel.writeString(this.desc);
        parcel.writeString(this.type);
        parcel.writeString(this.thumbUrl);
        parcel.writeInt(this.version);
        parcel.writeInt(this.miniSptVersion);
        parcel.writeString(this.packageUrl);
        parcel.writeString(this.path);
        parcel.writeString(this.feedlist_time_id);
        parcel.writeString(this.feedlist_hot_id);
        parcel.writeStringList(this.topic_ids);
        parcel.writeInt(this.mask);
        parcel.writeString(this.shortName);
        parcel.writeInt(this.rich_flag);
        parcel.writeString(this.title);
        parcel.writeInt(this.feedNum);
        parcel.writeInt(this.startTime);
        parcel.writeInt(this.endTime);
        parcel.writeInt(this.orgStartTime);
        parcel.writeString(this.followFeedId);
        parcel.writeString(this.mTogetherFeed);
        parcel.writeInt(this.mTogetherType);
        parcel.writeInt(this.mFeedUseType);
        parcel.writeInt(this.mDefaultFeedPosition);
        parcel.writeInt(this.mDefaultTogetherFeed);
        parcel.writeLong(this.collectTime);
        parcel.writeInt(this.audioDuration);
        parcel.writeInt(this.isCollected);
        parcel.writeByte(this.autoPlay);
        parcel.writeInt(this.exclusive);
        parcel.writeString(this.lyric);
        parcel.writeString(this.secLyric);
        parcel.writeString(this.lyricFormat);
        parcel.writeString(this.secLyricFormat);
        parcel.writeString(this.label);
        Map<Integer, String> map = this.songLabels;
        if (map != null) {
            parcel.writeInt(1);
            parcel.writeInt(map.size());
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                parcel.writeInt(entry.getKey().intValue());
                parcel.writeString(entry.getValue());
            }
        } else {
            parcel.writeInt(0);
        }
        List<HighlightIndex> list = this.nameIndices;
        if (list != null) {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator<HighlightIndex> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        List<HighlightIndex> list2 = this.descIndices;
        if (list2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(list2.size());
            Iterator<HighlightIndex> it5 = list2.iterator();
            while (it5.hasNext()) {
                it5.next().writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.indexInCategory);
        parcel.writeInt(this.mFromDataType);
        parcel.writeInt(this.mTotalTime);
        parcel.writeInt(this.refer);
        parcel.writeInt(this.state);
        parcel.writeString(this.categroyId);
        parcel.writeInt(this.isCloseLyric ? 1 : 0);
        parcel.writeInt(this.iSource);
        parcel.writeInt(this.segDuration);
        parcel.writeString(this.recommendInfo);
        parcel.writeString(this.musicFrom);
        parcel.writeInt(this.isStuckPoint ? 1 : 0);
        parcel.writeString(this.stuckPointJsonUrl);
        parcel.writeInt(this.isImportType ? 1 : 0);
        parcel.writeLong(this.importTime);
        parcel.writeLong(this.startInTime);
        parcel.writeLong(this.endOutTime);
        parcel.writeLong(this.startPlayOffset);
        parcel.writeInt(this.isEdit ? 1 : 0);
        parcel.writeLong(this.userStartTime);
        parcel.writeFloat(this.volume);
        parcel.writeLong(this.mTotalTimeMs);
        List<VolumeAutomaticEffect> list3 = this.mVolumeAutomaticEffectList;
        if (list3 != null) {
            parcel.writeInt(1);
            parcel.writeInt(list3.size());
            Iterator<VolumeAutomaticEffect> it6 = list3.iterator();
            while (it6.hasNext()) {
                it6.next().writeToParcel(parcel, 0);
            }
            return;
        }
        parcel.writeInt(0);
    }

    public MusicMaterialMetaDataBean(@NotNull String id5, long j3, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i3, int i16, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable List<String> list, int i17, @Nullable String str9, int i18, @Nullable String str10, int i19, int i26, int i27, int i28, @Nullable String str11, @Nullable String str12, int i29, int i36, int i37, int i38, long j16, int i39, int i46, byte b16, int i47, @Nullable String str13, @Nullable String str14, @Nullable String str15, @Nullable String str16, @Nullable String str17, @Nullable Map<Integer, String> map, @Nullable List<HighlightIndex> list2, @Nullable List<HighlightIndex> list3, int i48, int i49, int i56, int i57, int i58, @Nullable String str18, boolean z16, int i59, int i65, @Nullable String str19, @Nullable String str20, boolean z17, @Nullable String str21, boolean z18, long j17, long j18, long j19, long j26, boolean z19, long j27, float f16, long j28, @Nullable List<VolumeAutomaticEffect> list4) {
        Intrinsics.checkParameterIsNotNull(id5, "id");
        this.id = id5;
        this.sid = j3;
        this.name = str;
        this.desc = str2;
        this.type = str3;
        this.thumbUrl = str4;
        this.version = i3;
        this.miniSptVersion = i16;
        this.packageUrl = str5;
        this.path = str6;
        this.feedlist_time_id = str7;
        this.feedlist_hot_id = str8;
        this.topic_ids = list;
        this.mask = i17;
        this.shortName = str9;
        this.rich_flag = i18;
        this.title = str10;
        this.feedNum = i19;
        this.startTime = i26;
        this.endTime = i27;
        this.orgStartTime = i28;
        this.followFeedId = str11;
        this.mTogetherFeed = str12;
        this.mTogetherType = i29;
        this.mFeedUseType = i36;
        this.mDefaultFeedPosition = i37;
        this.mDefaultTogetherFeed = i38;
        this.collectTime = j16;
        this.audioDuration = i39;
        this.isCollected = i46;
        this.autoPlay = b16;
        this.exclusive = i47;
        this.lyric = str13;
        this.secLyric = str14;
        this.lyricFormat = str15;
        this.secLyricFormat = str16;
        this.label = str17;
        this.songLabels = map;
        this.nameIndices = list2;
        this.descIndices = list3;
        this.indexInCategory = i48;
        this.mFromDataType = i49;
        this.mTotalTime = i56;
        this.refer = i57;
        this.state = i58;
        this.categroyId = str18;
        this.isCloseLyric = z16;
        this.iSource = i59;
        this.segDuration = i65;
        this.recommendInfo = str19;
        this.musicFrom = str20;
        this.isStuckPoint = z17;
        this.stuckPointJsonUrl = str21;
        this.isImportType = z18;
        this.importTime = j17;
        this.startInTime = j18;
        this.endOutTime = j19;
        this.startPlayOffset = j26;
        this.isEdit = z19;
        this.userStartTime = j27;
        this.volume = f16;
        this.mTotalTimeMs = j28;
        this.mVolumeAutomaticEffectList = list4;
    }

    public /* synthetic */ MusicMaterialMetaDataBean(String str, long j3, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9, List list, int i17, String str10, int i18, String str11, int i19, int i26, int i27, int i28, String str12, String str13, int i29, int i36, int i37, int i38, long j16, int i39, int i46, byte b16, int i47, String str14, String str15, String str16, String str17, String str18, Map map, List list2, List list3, int i48, int i49, int i56, int i57, int i58, String str19, boolean z16, int i59, int i65, String str20, String str21, boolean z17, String str22, boolean z18, long j17, long j18, long j19, long j26, boolean z19, long j27, float f16, long j28, List list4, int i66, int i67, DefaultConstructorMarker defaultConstructorMarker) {
        this((i66 & 1) != 0 ? "" : str, (i66 & 2) != 0 ? 0L : j3, (i66 & 4) != 0 ? null : str2, (i66 & 8) != 0 ? null : str3, (i66 & 16) != 0 ? null : str4, (i66 & 32) != 0 ? null : str5, (i66 & 64) != 0 ? 0 : i3, (i66 & 128) != 0 ? 0 : i16, (i66 & 256) != 0 ? null : str6, (i66 & 512) != 0 ? null : str7, (i66 & 1024) != 0 ? null : str8, (i66 & 2048) != 0 ? null : str9, (i66 & 4096) != 0 ? null : list, (i66 & 8192) != 0 ? 0 : i17, (i66 & 16384) != 0 ? null : str10, (i66 & 32768) != 0 ? 0 : i18, (i66 & 65536) != 0 ? null : str11, (i66 & 131072) != 0 ? 0 : i19, (i66 & 262144) != 0 ? 0 : i26, (i66 & 524288) != 0 ? 0 : i27, (i66 & 1048576) != 0 ? 0 : i28, (i66 & 2097152) != 0 ? "" : str12, (i66 & 4194304) != 0 ? "" : str13, (i66 & 8388608) != 0 ? 0 : i29, (i66 & 16777216) != 0 ? 0 : i36, (i66 & 33554432) != 0 ? 0 : i37, (i66 & 67108864) != 0 ? 0 : i38, (i66 & 134217728) != 0 ? 0L : j16, (i66 & 268435456) != 0 ? 0 : i39, (i66 & 536870912) != 0 ? 0 : i46, (i66 & 1073741824) != 0 ? (byte) 0 : b16, (i66 & Integer.MIN_VALUE) != 0 ? 0 : i47, (i67 & 1) != 0 ? "" : str14, (i67 & 2) != 0 ? "" : str15, (i67 & 4) != 0 ? "" : str16, (i67 & 8) != 0 ? "" : str17, (i67 & 16) != 0 ? null : str18, (i67 & 32) != 0 ? null : map, (i67 & 64) != 0 ? null : list2, (i67 & 128) != 0 ? null : list3, (i67 & 256) != 0 ? 0 : i48, (i67 & 512) != 0 ? -1 : i49, (i67 & 1024) != 0 ? -1 : i56, (i67 & 2048) != 0 ? 0 : i57, (i67 & 4096) == 0 ? i58 : -1, (i67 & 8192) != 0 ? "" : str19, (i67 & 16384) != 0 ? false : z16, (i67 & 32768) != 0 ? 0 : i59, (i67 & 65536) != 0 ? 0 : i65, (i67 & 131072) != 0 ? "" : str20, (i67 & 262144) != 0 ? "" : str21, (i67 & 524288) != 0 ? false : z17, (i67 & 1048576) != 0 ? null : str22, (i67 & 2097152) != 0 ? false : z18, (i67 & 4194304) != 0 ? 0L : j17, (i67 & 8388608) != 0 ? 0L : j18, (i67 & 16777216) != 0 ? 0L : j19, (i67 & 33554432) != 0 ? 0L : j26, (i67 & 67108864) != 0 ? false : z19, (i67 & 134217728) != 0 ? -1L : j27, (i67 & 268435456) != 0 ? 0.0f : f16, (i67 & 536870912) != 0 ? 0L : j28, (i67 & 1073741824) != 0 ? new ArrayList() : list4);
    }

    @Deprecated(message = "")
    public static /* synthetic */ void endOutTime$annotations() {
    }

    @Deprecated(message = "")
    public static /* synthetic */ void mTotalTime$annotations() {
    }

    @Deprecated(message = "")
    public static /* synthetic */ void startInTime$annotations() {
    }
}
