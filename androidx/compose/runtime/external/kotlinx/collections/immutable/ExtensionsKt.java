package androidx.compose.runtime.external.kotlinx.collections.immutable;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.UtilsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSetBuilder;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt___StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\u0010%\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aQ\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032*\u0010\u0004\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0005\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006H\u0001\u00a2\u0006\u0002\u0010\u0007\u001a-\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005\"\u0002H\nH\u0001\u00a2\u0006\u0002\u0010\f\u001a\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\nH\u0001\u001a-\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005\"\u0002H\nH\u0001\u00a2\u0006\u0002\u0010\u000f\u001aQ\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032*\u0010\u0004\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0005\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006H\u0001\u00a2\u0006\u0002\u0010\u0007\u001a\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\nH\u0001\u001a-\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005\"\u0002H\nH\u0001\u00a2\u0006\u0002\u0010\f\u001a \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\u0000\u001aQ\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032*\u0010\u0004\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0005\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006H\u0000\u00a2\u0006\u0002\u0010\u0007\u001a\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\nH\u0000\u001a-\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005\"\u0002H\nH\u0000\u00a2\u0006\u0002\u0010\f\u001a\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\nH\u0000\u001a-\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005\"\u0002H\nH\u0000\u00a2\u0006\u0002\u0010\u000f\u001a \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\u0000\u001aQ\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032*\u0010\u0004\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0005\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006H\u0000\u00a2\u0006\u0002\u0010\u0007\u001a\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\nH\u0000\u001a-\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005\"\u0002H\nH\u0000\u00a2\u0006\u0002\u0010\f\u001a-\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0019H\u0080\u0004\u001a-\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0019H\u0080\u0004\u001a,\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00182\u0006\u0010\u001b\u001a\u0002H\nH\u0080\n\u00a2\u0006\u0002\u0010\u001c\u001a4\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00182\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005H\u0080\u0002\u00a2\u0006\u0002\u0010\u001d\u001a-\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0019H\u0080\u0002\u001a-\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u001eH\u0080\u0002\u001a,\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000e2\u0006\u0010\u001b\u001a\u0002H\nH\u0080\n\u00a2\u0006\u0002\u0010\u001f\u001a4\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000e2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005H\u0080\u0002\u00a2\u0006\u0002\u0010 \u001a-\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0019H\u0080\u0002\u001a-\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u001eH\u0080\u0002\u001a@\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010!\u001a\u0002H\u0002H\u0080\u0002\u00a2\u0006\u0002\u0010\"\u001aH\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u000e\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005H\u0080\u0002\u00a2\u0006\u0002\u0010$\u001aA\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0019H\u0080\u0002\u001aA\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001eH\u0080\u0002\u001a,\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\u0006\u0010\u001b\u001a\u0002H\nH\u0080\n\u00a2\u0006\u0002\u0010%\u001a4\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005H\u0080\u0002\u00a2\u0006\u0002\u0010&\u001a-\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0019H\u0080\u0002\u001a-\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u001eH\u0080\u0002\u001a<\u0010'\u001a\b\u0012\u0004\u0012\u0002H(0\u000e\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u000e2\u0018\u0010)\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H(0+\u0012\u0004\u0012\u00020,0*H\u0080\b\u00f8\u0001\u0000\u001aV\u0010'\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001e\u0010)\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030-\u0012\u0004\u0012\u00020,0*H\u0080\b\u00f8\u0001\u0000\u001a<\u0010'\u001a\b\u0012\u0004\u0012\u0002H(0\t\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\t2\u0018\u0010)\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H(0.\u0012\u0004\u0012\u00020,0*H\u0080\b\u00f8\u0001\u0000\u001a,\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00182\u0006\u0010\u001b\u001a\u0002H\nH\u0080\n\u00a2\u0006\u0002\u0010\u001c\u001a4\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00182\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005H\u0080\u0002\u00a2\u0006\u0002\u0010\u001d\u001a-\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0019H\u0080\u0002\u001a-\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\u0018\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u001eH\u0080\u0002\u001a,\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000e2\u0006\u0010\u001b\u001a\u0002H\nH\u0080\n\u00a2\u0006\u0002\u0010\u001f\u001a4\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000e2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005H\u0080\u0002\u00a2\u0006\u0002\u0010 \u001a-\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0019H\u0080\u0002\u001a-\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u001eH\u0080\u0002\u001aT\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001a\u0010\u0004\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0005H\u0080\n\u00a2\u0006\u0002\u00100\u001aG\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006H\u0080\n\u001aM\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0019H\u0080\n\u001aI\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0014\u00102\u001a\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303H\u0080\n\u001aM\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u001eH\u0080\n\u001a,\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\u0006\u0010\u001b\u001a\u0002H\nH\u0080\n\u00a2\u0006\u0002\u0010%\u001a4\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0005H\u0080\u0002\u00a2\u0006\u0002\u0010&\u001a-\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0019H\u0080\u0002\u001a-\u0010/\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u001eH\u0080\u0002\u001aS\u00104\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001a\u0010\u0004\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0005H\u0000\u00a2\u0006\u0002\u00100\u001aL\u00104\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0019H\u0000\u001aH\u00104\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0014\u00102\u001a\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303H\u0000\u001aL\u00104\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u001eH\u0000\u001a\u0012\u00105\u001a\b\u0012\u0004\u0012\u00020706*\u000208H\u0000\u001a\u001e\u00105\u001a\b\u0012\u0004\u0012\u0002H(06\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u0019H\u0000\u001a\u001e\u00105\u001a\b\u0012\u0004\u0012\u0002H(06\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u001eH\u0000\u001a0\u00109\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030:\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303H\u0000\u001a\u0012\u0010;\u001a\b\u0012\u0004\u0012\u0002070\t*\u000208H\u0000\u001a\u001e\u0010;\u001a\b\u0012\u0004\u0012\u0002H(0<\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u0019H\u0000\u001a\u001e\u0010;\u001a\b\u0012\u0004\u0012\u0002H(0<\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u001eH\u0000\u001a0\u0010=\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303H\u0000\u001a\u0012\u0010>\u001a\b\u0012\u0004\u0012\u0002070\t*\u000208H\u0000\u001a\u001e\u0010>\u001a\b\u0012\u0004\u0012\u0002H(0\t\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u0019H\u0000\u001a\u001e\u0010>\u001a\b\u0012\u0004\u0012\u0002H(0\t\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u001eH\u0000\u001a\u0012\u0010?\u001a\b\u0012\u0004\u0012\u0002070\u000e*\u000208H\u0000\u001a\u001e\u0010?\u001a\b\u0012\u0004\u0012\u0002H(0\u000e\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u0019H\u0000\u001a\u001e\u0010?\u001a\b\u0012\u0004\u0012\u0002H(0\u000e\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u001eH\u0000\u001a0\u0010@\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303H\u0000\u001a\u0012\u0010A\u001a\b\u0012\u0004\u0012\u0002070\t*\u000208H\u0000\u001a\u001e\u0010A\u001a\b\u0012\u0004\u0012\u0002H(0\t\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u0019H\u0000\u001a\u001e\u0010A\u001a\b\u0012\u0004\u0012\u0002H(0\t\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u001eH\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006B"}, d2 = {"immutableHashMapOf", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "K", "V", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "immutableHashSetOf", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "E", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "([Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "immutableListOf", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "([Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "immutableMapOf", "immutableSetOf", "persistentHashMapOf", "persistentHashSetOf", "persistentListOf", "persistentMapOf", "persistentSetOf", "intersect", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "", "minus", DTConstants.TAG.ELEMENT, "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "Lkotlin/sequences/Sequence;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "key", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "keys", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;[Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "mutate", "T", "mutator", "Lkotlin/Function1;", "", "", "", "", QCircleDaTongConstant.ElementParamValue.PLUS, "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;[Lkotlin/Pair;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "pair", "map", "", "putAll", "toImmutableList", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "", "", "toImmutableMap", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableMap;", "toImmutableSet", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "toPersistentHashMap", "toPersistentHashSet", "toPersistentList", "toPersistentMap", "toPersistentSet", "runtime_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class ExtensionsKt {
    @Deprecated(message = "Use persistentHashMapOf instead.", replaceWith = @ReplaceWith(expression = "persistentHashMapOf(*pairs)", imports = {}))
    public static final <K, V> PersistentMap<K, V> immutableHashMapOf(Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        return persistentHashMapOf((Pair[]) Arrays.copyOf(pairs, pairs.length));
    }

    @Deprecated(message = "Use persistentHashSetOf instead.", replaceWith = @ReplaceWith(expression = "persistentHashSetOf(*elements)", imports = {}))
    public static final <E> PersistentSet<E> immutableHashSetOf(E... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return persistentHashSetOf(Arrays.copyOf(elements, elements.length));
    }

    @Deprecated(message = "Use persistentListOf instead.", replaceWith = @ReplaceWith(expression = "persistentListOf(*elements)", imports = {}))
    public static final <E> PersistentList<E> immutableListOf(E... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return persistentListOf(Arrays.copyOf(elements, elements.length));
    }

    @Deprecated(message = "Use persistentMapOf instead.", replaceWith = @ReplaceWith(expression = "persistentMapOf(*pairs)", imports = {}))
    public static final <K, V> PersistentMap<K, V> immutableMapOf(Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        return persistentMapOf((Pair[]) Arrays.copyOf(pairs, pairs.length));
    }

    @Deprecated(message = "Use persistentSetOf instead.", replaceWith = @ReplaceWith(expression = "persistentSetOf(*elements)", imports = {}))
    public static final <E> PersistentSet<E> immutableSetOf(E... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return persistentSetOf(Arrays.copyOf(elements, elements.length));
    }

    public static final <E> PersistentSet<E> intersect(PersistentSet<? extends E> persistentSet, Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter(persistentSet, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            return persistentSet.retainAll((Collection<? extends Object>) elements);
        }
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        CollectionsKt__MutableCollectionsKt.retainAll(builder, elements);
        return builder.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> PersistentCollection<E> minus(PersistentCollection<? extends E> persistentCollection, E e16) {
        Intrinsics.checkNotNullParameter(persistentCollection, "<this>");
        return persistentCollection.remove((PersistentCollection<? extends E>) e16);
    }

    public static final <T> PersistentSet<T> mutate(PersistentSet<? extends T> persistentSet, Function1<? super Set<T>, Unit> mutator) {
        Intrinsics.checkNotNullParameter(persistentSet, "<this>");
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        PersistentSet.Builder<? extends T> builder = persistentSet.builder();
        mutator.invoke(builder);
        return builder.build();
    }

    public static final <K, V> PersistentMap<K, V> persistentHashMapOf(Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        PersistentMap.Builder<K, V> builder = PersistentHashMap.INSTANCE.emptyOf$runtime_release().builder();
        MapsKt__MapsKt.putAll(builder, pairs);
        return builder.build();
    }

    public static final <E> PersistentSet<E> persistentHashSetOf(E... elements) {
        List asList;
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentSet<E> emptyOf$runtime_release = PersistentHashSet.INSTANCE.emptyOf$runtime_release();
        asList = ArraysKt___ArraysJvmKt.asList(elements);
        return emptyOf$runtime_release.addAll((Collection) asList);
    }

    public static final <E> PersistentList<E> persistentListOf(E... elements) {
        List asList;
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentList persistentVectorOf = UtilsKt.persistentVectorOf();
        asList = ArraysKt___ArraysJvmKt.asList(elements);
        return persistentVectorOf.addAll((Collection) asList);
    }

    public static final <K, V> PersistentMap<K, V> persistentMapOf(Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        PersistentMap.Builder<K, V> builder = PersistentOrderedMap.INSTANCE.emptyOf$runtime_release().builder();
        MapsKt__MapsKt.putAll(builder, pairs);
        return builder.build();
    }

    public static final <E> PersistentSet<E> persistentSetOf(E... elements) {
        List asList;
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentSet<E> emptyOf$runtime_release = PersistentOrderedSet.INSTANCE.emptyOf$runtime_release();
        asList = ArraysKt___ArraysJvmKt.asList(elements);
        return emptyOf$runtime_release.addAll((Collection) asList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> PersistentCollection<E> plus(PersistentCollection<? extends E> persistentCollection, E e16) {
        Intrinsics.checkNotNullParameter(persistentCollection, "<this>");
        return persistentCollection.add((PersistentCollection<? extends E>) e16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> PersistentMap<K, V> putAll(PersistentMap<? extends K, ? extends V> persistentMap, Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(map, "map");
        return persistentMap.putAll((Map<? extends Object, ? extends Object>) map);
    }

    public static final <T> ImmutableList<T> toImmutableList(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        ImmutableList<T> immutableList = iterable instanceof ImmutableList ? (ImmutableList) iterable : null;
        return immutableList == null ? toPersistentList(iterable) : immutableList;
    }

    public static final <K, V> ImmutableMap<K, V> toImmutableMap(Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        ImmutableMap<K, V> immutableMap = map instanceof ImmutableMap ? (ImmutableMap) map : null;
        if (immutableMap != null) {
            return immutableMap;
        }
        PersistentMap.Builder builder = map instanceof PersistentMap.Builder ? (PersistentMap.Builder) map : null;
        PersistentMap<K, V> build = builder != null ? builder.build() : null;
        return build != null ? build : persistentMapOf().putAll((Map) map);
    }

    public static final <T> ImmutableSet<T> toImmutableSet(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        ImmutableSet<T> immutableSet = iterable instanceof ImmutableSet ? (ImmutableSet) iterable : null;
        if (immutableSet != null) {
            return immutableSet;
        }
        PersistentSet.Builder builder = iterable instanceof PersistentSet.Builder ? (PersistentSet.Builder) iterable : null;
        PersistentSet build = builder != null ? builder.build() : null;
        return build != null ? build : plus(persistentSetOf(), (Iterable) iterable);
    }

    public static final <K, V> PersistentMap<K, V> toPersistentHashMap(Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        PersistentHashMap persistentHashMap = map instanceof PersistentHashMap ? (PersistentHashMap) map : null;
        if (persistentHashMap != null) {
            return persistentHashMap;
        }
        PersistentHashMapBuilder persistentHashMapBuilder = map instanceof PersistentHashMapBuilder ? (PersistentHashMapBuilder) map : null;
        PersistentHashMap<K, V> build = persistentHashMapBuilder != null ? persistentHashMapBuilder.build() : null;
        return build != null ? build : PersistentHashMap.INSTANCE.emptyOf$runtime_release().putAll((Map) map);
    }

    public static final <T> PersistentSet<T> toPersistentHashSet(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        PersistentHashSet persistentHashSet = iterable instanceof PersistentHashSet ? (PersistentHashSet) iterable : null;
        if (persistentHashSet != null) {
            return persistentHashSet;
        }
        PersistentHashSetBuilder persistentHashSetBuilder = iterable instanceof PersistentHashSetBuilder ? (PersistentHashSetBuilder) iterable : null;
        PersistentHashSet build = persistentHashSetBuilder != null ? persistentHashSetBuilder.build() : null;
        return build != null ? build : plus(PersistentHashSet.INSTANCE.emptyOf$runtime_release(), (Iterable) iterable);
    }

    public static final <T> PersistentList<T> toPersistentList(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        PersistentList<T> persistentList = iterable instanceof PersistentList ? (PersistentList) iterable : null;
        if (persistentList != null) {
            return persistentList;
        }
        PersistentList.Builder builder = iterable instanceof PersistentList.Builder ? (PersistentList.Builder) iterable : null;
        PersistentList<T> build = builder != null ? builder.build() : null;
        return build == null ? plus(persistentListOf(), (Iterable) iterable) : build;
    }

    public static final <K, V> PersistentMap<K, V> toPersistentMap(Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        PersistentOrderedMap persistentOrderedMap = map instanceof PersistentOrderedMap ? (PersistentOrderedMap) map : null;
        if (persistentOrderedMap != null) {
            return persistentOrderedMap;
        }
        PersistentOrderedMapBuilder persistentOrderedMapBuilder = map instanceof PersistentOrderedMapBuilder ? (PersistentOrderedMapBuilder) map : null;
        PersistentMap<K, V> build = persistentOrderedMapBuilder != null ? persistentOrderedMapBuilder.build() : null;
        return build == null ? PersistentOrderedMap.INSTANCE.emptyOf$runtime_release().putAll((Map) map) : build;
    }

    public static final <T> PersistentSet<T> toPersistentSet(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        PersistentOrderedSet persistentOrderedSet = iterable instanceof PersistentOrderedSet ? (PersistentOrderedSet) iterable : null;
        if (persistentOrderedSet != null) {
            return persistentOrderedSet;
        }
        PersistentOrderedSetBuilder persistentOrderedSetBuilder = iterable instanceof PersistentOrderedSetBuilder ? (PersistentOrderedSetBuilder) iterable : null;
        PersistentSet<T> build = persistentOrderedSetBuilder != null ? persistentOrderedSetBuilder.build() : null;
        return build == null ? plus(PersistentOrderedSet.INSTANCE.emptyOf$runtime_release(), (Iterable) iterable) : build;
    }

    @Deprecated(message = "Use persistentListOf instead.", replaceWith = @ReplaceWith(expression = "persistentListOf()", imports = {}))
    public static final <E> PersistentList<E> immutableListOf() {
        return persistentListOf();
    }

    @Deprecated(message = "Use persistentSetOf instead.", replaceWith = @ReplaceWith(expression = "persistentSetOf()", imports = {}))
    public static final <E> PersistentSet<E> immutableSetOf() {
        return persistentSetOf();
    }

    public static final <E> PersistentCollection<E> minus(PersistentCollection<? extends E> persistentCollection, Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter(persistentCollection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            return persistentCollection.removeAll((Collection<? extends Object>) elements);
        }
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        CollectionsKt__MutableCollectionsKt.removeAll(builder, elements);
        return builder.build();
    }

    public static final <T> PersistentList<T> mutate(PersistentList<? extends T> persistentList, Function1<? super List<T>, Unit> mutator) {
        Intrinsics.checkNotNullParameter(persistentList, "<this>");
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        PersistentList.Builder<? extends T> builder = persistentList.builder();
        mutator.invoke(builder);
        return builder.build();
    }

    public static final <E> PersistentSet<E> persistentHashSetOf() {
        return PersistentHashSet.INSTANCE.emptyOf$runtime_release();
    }

    public static final <E> PersistentList<E> persistentListOf() {
        return UtilsKt.persistentVectorOf();
    }

    public static final <E> PersistentSet<E> persistentSetOf() {
        return PersistentOrderedSet.INSTANCE.emptyOf$runtime_release();
    }

    public static final <E> PersistentCollection<E> plus(PersistentCollection<? extends E> persistentCollection, Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter(persistentCollection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            return persistentCollection.addAll((Collection<? extends Object>) elements);
        }
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        CollectionsKt__MutableCollectionsKt.addAll(builder, elements);
        return builder.build();
    }

    public static final <K, V> PersistentMap<K, V> putAll(PersistentMap<? extends K, ? extends V> persistentMap, Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder();
        MapsKt__MapsKt.putAll(builder, pairs);
        return builder.build();
    }

    public static final <E> PersistentCollection<E> minus(PersistentCollection<? extends E> persistentCollection, E[] elements) {
        Intrinsics.checkNotNullParameter(persistentCollection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        CollectionsKt__MutableCollectionsKt.removeAll(builder, elements);
        return builder.build();
    }

    public static final <K, V> PersistentMap<K, V> mutate(PersistentMap<? extends K, ? extends V> persistentMap, Function1<? super Map<K, V>, Unit> mutator) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder();
        mutator.invoke(builder);
        return builder.build();
    }

    public static final <E> PersistentCollection<E> plus(PersistentCollection<? extends E> persistentCollection, E[] elements) {
        Intrinsics.checkNotNullParameter(persistentCollection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        CollectionsKt__MutableCollectionsKt.addAll(builder, elements);
        return builder.build();
    }

    public static final <T> ImmutableList<T> toImmutableList(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return toPersistentList(sequence);
    }

    public static final <E> PersistentCollection<E> minus(PersistentCollection<? extends E> persistentCollection, Sequence<? extends E> elements) {
        Intrinsics.checkNotNullParameter(persistentCollection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        CollectionsKt__MutableCollectionsKt.removeAll(builder, elements);
        return builder.build();
    }

    public static final <E> PersistentCollection<E> plus(PersistentCollection<? extends E> persistentCollection, Sequence<? extends E> elements) {
        Intrinsics.checkNotNullParameter(persistentCollection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentCollection.Builder<? extends E> builder = persistentCollection.builder();
        CollectionsKt__MutableCollectionsKt.addAll(builder, elements);
        return builder.build();
    }

    public static final ImmutableList<Character> toImmutableList(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return toPersistentList(charSequence);
    }

    public static final <T> ImmutableSet<T> toImmutableSet(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return toPersistentSet(sequence);
    }

    public static final <T> PersistentSet<T> toPersistentHashSet(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return plus(persistentHashSetOf(), (Sequence) sequence);
    }

    public static final <T> PersistentList<T> toPersistentList(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return plus(persistentListOf(), (Sequence) sequence);
    }

    public static final <T> PersistentSet<T> toPersistentSet(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return plus(persistentSetOf(), (Sequence) sequence);
    }

    public static final <E> PersistentSet<E> intersect(PersistentCollection<? extends E> persistentCollection, Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter(persistentCollection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return intersect(toPersistentSet(persistentCollection), (Iterable) elements);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> PersistentList<E> minus(PersistentList<? extends E> persistentList, E e16) {
        Intrinsics.checkNotNullParameter(persistentList, "<this>");
        return persistentList.remove((PersistentList<? extends E>) e16);
    }

    public static final <K, V> PersistentMap<K, V> persistentHashMapOf() {
        return PersistentHashMap.INSTANCE.emptyOf$runtime_release();
    }

    public static final <K, V> PersistentMap<K, V> persistentMapOf() {
        return PersistentOrderedMap.INSTANCE.emptyOf$runtime_release();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> PersistentList<E> plus(PersistentList<? extends E> persistentList, E e16) {
        Intrinsics.checkNotNullParameter(persistentList, "<this>");
        return persistentList.add((PersistentList<? extends E>) e16);
    }

    public static final <K, V> PersistentMap<K, V> putAll(PersistentMap<? extends K, ? extends V> persistentMap, Pair<? extends K, ? extends V>[] pairs) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder();
        MapsKt__MapsKt.putAll(builder, pairs);
        return builder.build();
    }

    public static final PersistentSet<Character> toImmutableSet(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return toPersistentSet(charSequence);
    }

    public static final PersistentSet<Character> toPersistentHashSet(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        PersistentSet.Builder builder = persistentHashSetOf().builder();
        StringsKt___StringsKt.toCollection(charSequence, builder);
        return builder.build();
    }

    public static final PersistentList<Character> toPersistentList(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        PersistentList.Builder builder = persistentListOf().builder();
        StringsKt___StringsKt.toCollection(charSequence, builder);
        return builder.build();
    }

    public static final PersistentSet<Character> toPersistentSet(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        PersistentSet.Builder builder = persistentSetOf().builder();
        StringsKt___StringsKt.toCollection(charSequence, builder);
        return builder.build();
    }

    public static final <E> PersistentList<E> minus(PersistentList<? extends E> persistentList, Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter(persistentList, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            return persistentList.removeAll((Collection<? extends Object>) elements);
        }
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        CollectionsKt__MutableCollectionsKt.removeAll(builder, elements);
        return builder.build();
    }

    public static final <E> PersistentList<E> plus(PersistentList<? extends E> persistentList, Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter(persistentList, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            return persistentList.addAll((Collection<? extends Object>) elements);
        }
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        CollectionsKt__MutableCollectionsKt.addAll(builder, elements);
        return builder.build();
    }

    public static final <K, V> PersistentMap<K, V> putAll(PersistentMap<? extends K, ? extends V> persistentMap, Sequence<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder();
        MapsKt__MapsKt.putAll(builder, pairs);
        return builder.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> PersistentSet<E> minus(PersistentSet<? extends E> persistentSet, E e16) {
        Intrinsics.checkNotNullParameter(persistentSet, "<this>");
        return persistentSet.remove((PersistentSet<? extends E>) e16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> PersistentSet<E> plus(PersistentSet<? extends E> persistentSet, E e16) {
        Intrinsics.checkNotNullParameter(persistentSet, "<this>");
        return persistentSet.add((PersistentSet<? extends E>) e16);
    }

    public static final <E> PersistentSet<E> minus(PersistentSet<? extends E> persistentSet, Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter(persistentSet, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            return persistentSet.removeAll((Collection<? extends Object>) elements);
        }
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        CollectionsKt__MutableCollectionsKt.removeAll(builder, elements);
        return builder.build();
    }

    public static final <E> PersistentSet<E> plus(PersistentSet<? extends E> persistentSet, Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter(persistentSet, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            return persistentSet.addAll((Collection<? extends Object>) elements);
        }
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        CollectionsKt__MutableCollectionsKt.addAll(builder, elements);
        return builder.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> PersistentMap<K, V> minus(PersistentMap<? extends K, ? extends V> persistentMap, K k3) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        return persistentMap.remove((PersistentMap<? extends K, ? extends V>) k3);
    }

    public static final <K, V> PersistentMap<K, V> plus(PersistentMap<? extends K, ? extends V> persistentMap, Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(pair, "pair");
        return persistentMap.put((PersistentMap<? extends K, ? extends V>) pair.getFirst(), (K) pair.getSecond());
    }

    public static final <E> PersistentList<E> minus(PersistentList<? extends E> persistentList, E[] elements) {
        Intrinsics.checkNotNullParameter(persistentList, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        CollectionsKt__MutableCollectionsKt.removeAll(builder, elements);
        return builder.build();
    }

    public static final <K, V> PersistentMap<K, V> plus(PersistentMap<? extends K, ? extends V> persistentMap, Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        return putAll(persistentMap, pairs);
    }

    public static final <K, V> PersistentMap<K, V> plus(PersistentMap<? extends K, ? extends V> persistentMap, Pair<? extends K, ? extends V>[] pairs) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        return putAll(persistentMap, pairs);
    }

    public static final <K, V> PersistentMap<K, V> plus(PersistentMap<? extends K, ? extends V> persistentMap, Sequence<? extends Pair<? extends K, ? extends V>> pairs) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        return putAll(persistentMap, pairs);
    }

    public static final <E> PersistentList<E> minus(PersistentList<? extends E> persistentList, Sequence<? extends E> elements) {
        Intrinsics.checkNotNullParameter(persistentList, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        CollectionsKt__MutableCollectionsKt.removeAll(builder, elements);
        return builder.build();
    }

    public static final <K, V> PersistentMap<K, V> plus(PersistentMap<? extends K, ? extends V> persistentMap, Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(map, "map");
        return putAll(persistentMap, map);
    }

    public static final <E> PersistentList<E> plus(PersistentList<? extends E> persistentList, E[] elements) {
        Intrinsics.checkNotNullParameter(persistentList, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        CollectionsKt__MutableCollectionsKt.addAll(builder, elements);
        return builder.build();
    }

    public static final <E> PersistentSet<E> minus(PersistentSet<? extends E> persistentSet, E[] elements) {
        Intrinsics.checkNotNullParameter(persistentSet, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        CollectionsKt__MutableCollectionsKt.removeAll(builder, elements);
        return builder.build();
    }

    public static final <E> PersistentList<E> plus(PersistentList<? extends E> persistentList, Sequence<? extends E> elements) {
        Intrinsics.checkNotNullParameter(persistentList, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentList.Builder<? extends E> builder = persistentList.builder();
        CollectionsKt__MutableCollectionsKt.addAll(builder, elements);
        return builder.build();
    }

    public static final <E> PersistentSet<E> minus(PersistentSet<? extends E> persistentSet, Sequence<? extends E> elements) {
        Intrinsics.checkNotNullParameter(persistentSet, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        CollectionsKt__MutableCollectionsKt.removeAll(builder, elements);
        return builder.build();
    }

    public static final <E> PersistentSet<E> plus(PersistentSet<? extends E> persistentSet, E[] elements) {
        Intrinsics.checkNotNullParameter(persistentSet, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        CollectionsKt__MutableCollectionsKt.addAll(builder, elements);
        return builder.build();
    }

    public static final <K, V> PersistentMap<K, V> minus(PersistentMap<? extends K, ? extends V> persistentMap, Iterable<? extends K> keys) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(keys, "keys");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder();
        CollectionsKt__MutableCollectionsKt.removeAll(builder.keySet(), keys);
        return builder.build();
    }

    public static final <E> PersistentSet<E> plus(PersistentSet<? extends E> persistentSet, Sequence<? extends E> elements) {
        Intrinsics.checkNotNullParameter(persistentSet, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentSet.Builder<? extends E> builder = persistentSet.builder();
        CollectionsKt__MutableCollectionsKt.addAll(builder, elements);
        return builder.build();
    }

    public static final <K, V> PersistentMap<K, V> minus(PersistentMap<? extends K, ? extends V> persistentMap, K[] keys) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(keys, "keys");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder();
        CollectionsKt__MutableCollectionsKt.removeAll(builder.keySet(), keys);
        return builder.build();
    }

    public static final <K, V> PersistentMap<K, V> minus(PersistentMap<? extends K, ? extends V> persistentMap, Sequence<? extends K> keys) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(keys, "keys");
        PersistentMap.Builder<? extends K, ? extends V> builder = persistentMap.builder();
        CollectionsKt__MutableCollectionsKt.removeAll(builder.keySet(), keys);
        return builder.build();
    }
}
