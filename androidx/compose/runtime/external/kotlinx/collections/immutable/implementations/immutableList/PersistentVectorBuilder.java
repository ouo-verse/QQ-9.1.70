package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mtt.hippy.dom.node.TextNode;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0010(\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010)\n\u0000\n\u0002\u0010*\n\u0000\n\u0002\u0010+\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0018\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B=\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u001fJ\u001d\u0010\u001c\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\"J\u001e\u0010#\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u000b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J\u0016\u0010#\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J\u001d\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010!\u001a\u00020\u000bH\u0002\u00a2\u0006\u0002\u0010'J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J=\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010+\u001a\u00020\u000b2\u000e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0-H\u0002\u00a2\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u000bH\u0096\u0002\u00a2\u0006\u0002\u00100J\r\u00101\u001a\u00020\u000bH\u0000\u00a2\u0006\u0002\b2JG\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00104\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\u0006\u00105\u001a\u000206H\u0002\u00a2\u0006\u0002\u00107J[\u00103\u001a\u00020 2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%2\u0006\u0010!\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0016\u00109\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u00072\u0006\u0010:\u001a\u00020\u000b2\u000e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002\u00a2\u0006\u0002\u0010<J/\u0010=\u001a\u00020 2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010>J\u001d\u0010?\u001a\u00020\u001d2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002\u00a2\u0006\u0002\u0010@J\u000f\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000BH\u0096\u0002J\u001e\u0010C\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070D2\u0006\u0010!\u001a\u00020\u000bH\u0002J\u000e\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000FH\u0016J\u0016\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000F2\u0006\u0010!\u001a\u00020\u000bH\u0016J'\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0002\u00a2\u0006\u0002\u0010HJ-\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010J\u001a\u00020\u000bH\u0002\u00a2\u0006\u0002\u0010KJ\u0015\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002\u00a2\u0006\u0002\u0010\u0012J\u001f\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\bH\u0002\u00a2\u0006\u0002\u0010NJ5\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010!\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000bH\u0002\u00a2\u0006\u0002\u0010PJ?\u0010Q\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00104\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u000b2\u0006\u0010S\u001a\u000206H\u0002\u00a2\u0006\u0002\u0010TJ/\u0010U\u001a\u00020 2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010R\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000bH\u0002\u00a2\u0006\u0002\u0010VJM\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010R\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000b2\u0014\u0010X\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070-H\u0002\u00a2\u0006\u0002\u0010YJE\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010R\u001a\u00020\u000b2\u0014\u00109\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0007H\u0002\u00a2\u0006\u0002\u0010[J?\u0010\\\u001a\u00020 2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000e\u0010]\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010^\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002\u00a2\u0006\u0002\u0010_J?\u0010`\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00104\u001a\u00020\u000bH\u0002\u00a2\u0006\u0002\u0010aJu\u0010b\u001a\u00020\u000b2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0d2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010e\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020\u000b2\u0006\u0010g\u001a\u0002062\u0014\u0010h\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070i2\u0014\u00109\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070iH\u0002\u00a2\u0006\u0002\u0010jJ\u001c\u0010k\u001a\u00020\u001d2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0dH\u0002JA\u0010k\u001a\u00020\u000b2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0d2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010e\u001a\u00020\u000b2\u0006\u0010g\u001a\u000206H\u0002\u00a2\u0006\u0002\u0010lJ\u0016\u0010k\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J,\u0010m\u001a\u00020\u000b2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0d2\u0006\u0010n\u001a\u00020\u000b2\u0006\u0010g\u001a\u000206H\u0002J\u001a\u0010o\u001a\u00020\u001d2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0dJ\u0015\u0010p\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u000bH\u0016\u00a2\u0006\u0002\u00100J=\u0010q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00104\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010S\u001a\u000206H\u0002\u00a2\u0006\u0002\u0010TJ9\u0010r\u001a\u0004\u0018\u00010\b2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010R\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bH\u0002\u00a2\u0006\u0002\u0010sJ/\u0010t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u0018\u001a\u00020\u000bH\u0002\u00a2\u0006\u0002\u0010KJ\b\u0010R\u001a\u00020\u000bH\u0002J\u001e\u0010u\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010vJE\u0010w\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00104\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010x\u001a\u00028\u00002\u0006\u0010y\u001a\u000206H\u0002\u00a2\u0006\u0002\u00107JU\u0010z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010{\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0016\u00109\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u00072\u0006\u0010:\u001a\u00020\u000b2\u000e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002\u00a2\u0006\u0002\u0010|Jl\u0010}\u001a\u00020 2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%2\u0006\u0010!\u001a\u00020\u000b2\u000e\u0010~\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u007f\u001a\u00020\u000b2\u0016\u00109\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u00072\u0006\u0010:\u001a\u00020\u000b2\u000e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002\u00a2\u0006\u0003\u0010\u0080\u0001J\b\u0010n\u001a\u00020\u000bH\u0002J\u0010\u0010n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R4\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007@BX\u0080\u000e\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\n\u001a\u00020\u000bX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b@RX\u0096\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R0\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007@BX\u0080\u000e\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001b\u0010\u0012R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0013R\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0013\u00a8\u0006\u0081\u0001"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder;", "E", "Lkotlin/collections/AbstractMutableList;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList$Builder;", "vector", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "vectorRoot", "", "", "vectorTail", "rootShift", "", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;[Ljava/lang/Object;[Ljava/lang/Object;I)V", "ownership", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "<set-?>", "root", "getRoot$runtime_release", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "getRootShift$runtime_release", "()I", "setRootShift$runtime_release", "(I)V", "size", "getSize", TextNode.MODE_TAIL, "getTail$runtime_release", "add", "", DTConstants.TAG.ELEMENT, "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "", "bufferFor", "(I)[Ljava/lang/Object;", "build", "copyToBuffer", "buffer", "bufferIndex", "sourceIterator", "", "([Ljava/lang/Object;ILjava/util/Iterator;)[Ljava/lang/Object;", "get", "(I)Ljava/lang/Object;", "getModCount", "getModCount$runtime_release", "insertIntoRoot", "shift", "elementCarry", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;", "([Ljava/lang/Object;IILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "rightShift", "buffers", "nullBuffers", "nextBuffer", "(Ljava/util/Collection;II[[Ljava/lang/Object;I[Ljava/lang/Object;)V", "insertIntoTail", "([Ljava/lang/Object;ILjava/lang/Object;)V", "isMutable", "([Ljava/lang/Object;)Z", "iterator", "", "leafBufferIterator", "", "listIterator", "", "makeMutable", "([Ljava/lang/Object;)[Ljava/lang/Object;", "makeMutableShiftingRight", Element.ELEMENT_NAME_DISTANCE, "([Ljava/lang/Object;I)[Ljava/lang/Object;", "mutableBuffer", "mutableBufferWith", "(Ljava/lang/Object;)[Ljava/lang/Object;", "nullifyAfter", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "pullLastBuffer", "rootSize", "tailCarry", "([Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "pullLastBufferFromRoot", "([Ljava/lang/Object;II)V", "pushBuffers", "buffersIterator", "([Ljava/lang/Object;IILjava/util/Iterator;)[Ljava/lang/Object;", "pushBuffersIncreasingHeightIfNeeded", "([Ljava/lang/Object;I[[Ljava/lang/Object;)[Ljava/lang/Object;", "pushFilledTail", "filledTail", "newTail", "([Ljava/lang/Object;[Ljava/lang/Object;[Ljava/lang/Object;)V", "pushTail", "([Ljava/lang/Object;[Ljava/lang/Object;I)[Ljava/lang/Object;", "recyclableRemoveAll", "predicate", "Lkotlin/Function1;", "bufferSize", "toBufferSize", "bufferRef", "recyclableBuffers", "", "(Lkotlin/jvm/functions/Function1;[Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;Ljava/util/List;Ljava/util/List;)I", "removeAll", "(Lkotlin/jvm/functions/Function1;[Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)I", "removeAllFromTail", "tailSize", "removeAllWithPredicate", "removeAt", "removeFromRootAt", "removeFromTailAt", "([Ljava/lang/Object;III)Ljava/lang/Object;", "retainFirst", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "setInRoot", "e", "oldElementCarry", "shiftLeafBuffers", "startLeafIndex", "(II[[Ljava/lang/Object;I[Ljava/lang/Object;)[Ljava/lang/Object;", "splitToBuffers", "startBuffer", "startBufferSize", "(Ljava/util/Collection;I[Ljava/lang/Object;I[[Ljava/lang/Object;I[Ljava/lang/Object;)V", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class PersistentVectorBuilder<E> extends AbstractMutableList<E> implements PersistentList.Builder<E> {
    private MutabilityOwnership ownership;
    private Object[] root;
    private int rootShift;
    private int size;
    private Object[] tail;
    private PersistentList<? extends E> vector;
    private Object[] vectorRoot;
    private Object[] vectorTail;

    public PersistentVectorBuilder(PersistentList<? extends E> vector, Object[] objArr, Object[] vectorTail, int i3) {
        Intrinsics.checkNotNullParameter(vector, "vector");
        Intrinsics.checkNotNullParameter(vectorTail, "vectorTail");
        this.vector = vector;
        this.vectorRoot = objArr;
        this.vectorTail = vectorTail;
        this.rootShift = i3;
        this.ownership = new MutabilityOwnership();
        this.root = this.vectorRoot;
        this.tail = this.vectorTail;
        this.size = this.vector.size();
    }

    private final Object[] bufferFor(int index) {
        if (rootSize() <= index) {
            return this.tail;
        }
        Object[] objArr = this.root;
        Intrinsics.checkNotNull(objArr);
        for (int i3 = this.rootShift; i3 > 0; i3 -= 5) {
            Object[] objArr2 = objArr[UtilsKt.indexSegment(index, i3)];
            if (objArr2 != null) {
                objArr = objArr2;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            }
        }
        return objArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
    
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Object[] insertIntoRoot(Object[] root, int shift, int index, Object element, ObjectRef elementCarry) {
        Object obj;
        Object[] copyInto;
        int indexSegment = UtilsKt.indexSegment(index, shift);
        if (shift == 0) {
            elementCarry.setValue(root[31]);
            copyInto = ArraysKt___ArraysJvmKt.copyInto(root, makeMutable(root), indexSegment + 1, indexSegment, 31);
            copyInto[indexSegment] = element;
            return copyInto;
        }
        Object[] makeMutable = makeMutable(root);
        int i3 = shift - 5;
        Object obj2 = makeMutable[indexSegment];
        if (obj2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
        makeMutable[indexSegment] = insertIntoRoot((Object[]) obj2, i3, index, element, elementCarry);
        while (true) {
            indexSegment++;
            if (indexSegment >= 32 || (obj = makeMutable[indexSegment]) == null) {
                break;
            }
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            }
            makeMutable[indexSegment] = insertIntoRoot((Object[]) obj, i3, 0, elementCarry.getValue(), elementCarry);
        }
    }

    private final void insertIntoTail(Object[] root, int index, E element) {
        int tailSize = tailSize();
        Object[] makeMutable = makeMutable(this.tail);
        if (tailSize < 32) {
            ArraysKt___ArraysJvmKt.copyInto(this.tail, makeMutable, index + 1, index, tailSize);
            makeMutable[index] = element;
            this.root = root;
            this.tail = makeMutable;
            this.size = size() + 1;
            return;
        }
        Object[] objArr = this.tail;
        Object obj = objArr[31];
        ArraysKt___ArraysJvmKt.copyInto(objArr, makeMutable, index + 1, index, 31);
        makeMutable[index] = element;
        pushFilledTail(root, makeMutable, mutableBufferWith(obj));
    }

    private final boolean isMutable(Object[] buffer) {
        return buffer.length == 33 && buffer[32] == this.ownership;
    }

    private final ListIterator<Object[]> leafBufferIterator(int index) {
        if (this.root != null) {
            int rootSize = rootSize() >> 5;
            ListImplementation.checkPositionIndex$runtime_release(index, rootSize);
            int i3 = this.rootShift;
            if (i3 == 0) {
                Object[] objArr = this.root;
                Intrinsics.checkNotNull(objArr);
                return new SingleElementListIterator(objArr, index);
            }
            Object[] objArr2 = this.root;
            Intrinsics.checkNotNull(objArr2);
            return new TrieIterator(objArr2, index, rootSize, i3 / 5);
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final Object[] makeMutableShiftingRight(Object[] buffer, int distance) {
        Object[] copyInto;
        Object[] copyInto2;
        if (isMutable(buffer)) {
            copyInto2 = ArraysKt___ArraysJvmKt.copyInto(buffer, buffer, distance, 0, 32 - distance);
            return copyInto2;
        }
        copyInto = ArraysKt___ArraysJvmKt.copyInto(buffer, mutableBuffer(), distance, 0, 32 - distance);
        return copyInto;
    }

    private final Object[] pushBuffers(Object[] root, int rootSize, int shift, Iterator<Object[]> buffersIterator) {
        if (!buffersIterator.hasNext()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(shift >= 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (shift == 0) {
            return buffersIterator.next();
        }
        Object[] makeMutable = makeMutable(root);
        int indexSegment = UtilsKt.indexSegment(rootSize, shift);
        int i3 = shift - 5;
        makeMutable[indexSegment] = pushBuffers((Object[]) makeMutable[indexSegment], rootSize, i3, buffersIterator);
        while (true) {
            indexSegment++;
            if (indexSegment >= 32 || !buffersIterator.hasNext()) {
                break;
            }
            makeMutable[indexSegment] = pushBuffers((Object[]) makeMutable[indexSegment], 0, i3, buffersIterator);
        }
        return makeMutable;
    }

    private final Object[] pushBuffersIncreasingHeightIfNeeded(Object[] root, int rootSize, Object[][] buffers) {
        Object[] makeMutable;
        Iterator<Object[]> it = ArrayIteratorKt.iterator(buffers);
        int i3 = rootSize >> 5;
        int i16 = this.rootShift;
        if (i3 < (1 << i16)) {
            makeMutable = pushBuffers(root, rootSize, i16, it);
        } else {
            makeMutable = makeMutable(root);
        }
        while (it.hasNext()) {
            this.rootShift += 5;
            makeMutable = mutableBufferWith(makeMutable);
            int i17 = this.rootShift;
            pushBuffers(makeMutable, 1 << i17, i17, it);
        }
        return makeMutable;
    }

    private final void pushFilledTail(Object[] root, Object[] filledTail, Object[] newTail) {
        int size = size() >> 5;
        int i3 = this.rootShift;
        if (size > (1 << i3)) {
            this.root = pushTail(mutableBufferWith(root), filledTail, this.rootShift + 5);
            this.tail = newTail;
            this.rootShift += 5;
            this.size = size() + 1;
            return;
        }
        if (root == null) {
            this.root = filledTail;
            this.tail = newTail;
            this.size = size() + 1;
        } else {
            this.root = pushTail(root, filledTail, i3);
            this.tail = newTail;
            this.size = size() + 1;
        }
    }

    private final Object[] pushTail(Object[] root, Object[] tail, int shift) {
        int indexSegment = UtilsKt.indexSegment(size() - 1, shift);
        Object[] makeMutable = makeMutable(root);
        if (shift == 5) {
            makeMutable[indexSegment] = tail;
        } else {
            makeMutable[indexSegment] = pushTail((Object[]) makeMutable[indexSegment], tail, shift - 5);
        }
        return makeMutable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int recyclableRemoveAll(Function1<? super E, Boolean> predicate, Object[] buffer, int bufferSize, int toBufferSize, ObjectRef bufferRef, List<Object[]> recyclableBuffers, List<Object[]> buffers) {
        Object[] mutableBuffer;
        if (isMutable(buffer)) {
            recyclableBuffers.add(buffer);
        }
        Object value = bufferRef.getValue();
        if (value != null) {
            Object[] objArr = (Object[]) value;
            Object[] objArr2 = objArr;
            for (int i3 = 0; i3 < bufferSize; i3++) {
                Object obj = buffer[i3];
                if (!predicate.invoke(obj).booleanValue()) {
                    if (toBufferSize == 32) {
                        if (!recyclableBuffers.isEmpty()) {
                            mutableBuffer = recyclableBuffers.remove(recyclableBuffers.size() - 1);
                        } else {
                            mutableBuffer = mutableBuffer();
                        }
                        objArr2 = mutableBuffer;
                        toBufferSize = 0;
                    }
                    objArr2[toBufferSize] = obj;
                    toBufferSize++;
                }
            }
            bufferRef.setValue(objArr2);
            if (objArr != bufferRef.getValue()) {
                buffers.add(objArr);
            }
            return toBufferSize;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }

    private final int removeAllFromTail(Function1<? super E, Boolean> predicate, int tailSize, ObjectRef bufferRef) {
        int removeAll = removeAll(predicate, this.tail, tailSize, bufferRef);
        if (removeAll == tailSize) {
            CommonFunctionsKt.m32assert(bufferRef.getValue() == this.tail);
            return tailSize;
        }
        Object value = bufferRef.getValue();
        if (value != null) {
            Object[] objArr = (Object[]) value;
            ArraysKt___ArraysJvmKt.fill(objArr, (Object) null, removeAll, tailSize);
            this.tail = objArr;
            this.size = size() - (tailSize - removeAll);
            return removeAll;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }

    private final Object[] removeFromRootAt(Object[] root, int shift, int index, ObjectRef tailCarry) {
        Object[] copyInto;
        int indexSegment = UtilsKt.indexSegment(index, shift);
        if (shift == 0) {
            Object obj = root[indexSegment];
            copyInto = ArraysKt___ArraysJvmKt.copyInto(root, makeMutable(root), indexSegment, indexSegment + 1, 32);
            copyInto[31] = tailCarry.getValue();
            tailCarry.setValue(obj);
            return copyInto;
        }
        int indexSegment2 = root[31] == null ? UtilsKt.indexSegment(rootSize() - 1, shift) : 31;
        Object[] makeMutable = makeMutable(root);
        int i3 = shift - 5;
        int i16 = indexSegment + 1;
        if (i16 <= indexSegment2) {
            while (true) {
                Object obj2 = makeMutable[indexSegment2];
                if (obj2 != null) {
                    makeMutable[indexSegment2] = removeFromRootAt((Object[]) obj2, i3, 0, tailCarry);
                    if (indexSegment2 == i16) {
                        break;
                    }
                    indexSegment2--;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                }
            }
        }
        Object obj3 = makeMutable[indexSegment];
        if (obj3 != null) {
            makeMutable[indexSegment] = removeFromRootAt((Object[]) obj3, i3, index, tailCarry);
            return makeMutable;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }

    private final Object removeFromTailAt(Object[] root, int rootSize, int shift, int index) {
        Object[] copyInto;
        int size = size() - rootSize;
        CommonFunctionsKt.m32assert(index < size);
        if (size == 1) {
            Object obj = this.tail[0];
            pullLastBufferFromRoot(root, rootSize, shift);
            return obj;
        }
        Object[] objArr = this.tail;
        Object obj2 = objArr[index];
        copyInto = ArraysKt___ArraysJvmKt.copyInto(objArr, makeMutable(objArr), index, index + 1, size);
        copyInto[size - 1] = null;
        this.root = root;
        this.tail = copyInto;
        this.size = (rootSize + size) - 1;
        this.rootShift = shift;
        return obj2;
    }

    private final int rootSize() {
        if (size() <= 32) {
            return 0;
        }
        return UtilsKt.rootSize(size());
    }

    private final Object[] setInRoot(Object[] root, int shift, int index, E e16, ObjectRef oldElementCarry) {
        int indexSegment = UtilsKt.indexSegment(index, shift);
        Object[] makeMutable = makeMutable(root);
        if (shift == 0) {
            if (makeMutable != root) {
                ((AbstractList) this).modCount++;
            }
            oldElementCarry.setValue(makeMutable[indexSegment]);
            makeMutable[indexSegment] = e16;
            return makeMutable;
        }
        Object obj = makeMutable[indexSegment];
        if (obj != null) {
            makeMutable[indexSegment] = setInRoot((Object[]) obj, shift - 5, index, e16, oldElementCarry);
            return makeMutable;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }

    private final Object[] shiftLeafBuffers(int startLeafIndex, int rightShift, Object[][] buffers, int nullBuffers, Object[] nextBuffer) {
        if (this.root != null) {
            ListIterator<Object[]> leafBufferIterator = leafBufferIterator(rootSize() >> 5);
            while (leafBufferIterator.previousIndex() != startLeafIndex) {
                Object[] previous = leafBufferIterator.previous();
                ArraysKt___ArraysJvmKt.copyInto(previous, nextBuffer, 0, 32 - rightShift, 32);
                nextBuffer = makeMutableShiftingRight(previous, rightShift);
                nullBuffers--;
                buffers[nullBuffers] = nextBuffer;
            }
            return leafBufferIterator.previous();
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final int tailSize(int size) {
        return size <= 32 ? size : size - UtilsKt.rootSize(size);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E element) {
        ((AbstractList) this).modCount++;
        int tailSize = tailSize();
        if (tailSize < 32) {
            Object[] makeMutable = makeMutable(this.tail);
            makeMutable[tailSize] = element;
            this.tail = makeMutable;
            this.size = size() + 1;
        } else {
            pushFilledTail(this.root, this.tail, mutableBufferWith(element));
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int tailSize = tailSize();
        Iterator<? extends E> it = elements.iterator();
        if (32 - tailSize >= elements.size()) {
            this.tail = copyToBuffer(makeMutable(this.tail), tailSize, it);
            this.size = size() + elements.size();
        } else {
            int size = ((elements.size() + tailSize) - 1) / 32;
            Object[][] objArr = new Object[size];
            objArr[0] = copyToBuffer(makeMutable(this.tail), tailSize, it);
            for (int i3 = 1; i3 < size; i3++) {
                objArr[i3] = copyToBuffer(mutableBuffer(), 0, it);
            }
            this.root = pushBuffersIncreasingHeightIfNeeded(this.root, rootSize(), objArr);
            this.tail = copyToBuffer(mutableBuffer(), 0, it);
            this.size = size() + elements.size();
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int index) {
        ListImplementation.checkElementIndex$runtime_release(index, size());
        return (E) bufferFor(index)[index & 31];
    }

    public final int getModCount$runtime_release() {
        return ((AbstractList) this).modCount;
    }

    /* renamed from: getRoot$runtime_release, reason: from getter */
    public final Object[] getRoot() {
        return this.root;
    }

    /* renamed from: getRootShift$runtime_release, reason: from getter */
    public final int getRootShift() {
        return this.rootShift;
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.size;
    }

    /* renamed from: getTail$runtime_release, reason: from getter */
    public final Object[] getTail() {
        return this.tail;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return listIterator();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(final Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return removeAllWithPredicate(new Function1<E, Boolean>() { // from class: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVectorBuilder$removeAll$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(E e16) {
                return Boolean.valueOf(elements.contains(e16));
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                return invoke((PersistentVectorBuilder$removeAll$1<E>) obj);
            }
        });
    }

    public final boolean removeAllWithPredicate(Function1<? super E, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean removeAll = removeAll(predicate);
        if (removeAll) {
            ((AbstractList) this).modCount++;
        }
        return removeAll;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int index) {
        ListImplementation.checkElementIndex$runtime_release(index, size());
        ((AbstractList) this).modCount++;
        int rootSize = rootSize();
        if (index >= rootSize) {
            return (E) removeFromTailAt(this.root, rootSize, this.rootShift, index - rootSize);
        }
        ObjectRef objectRef = new ObjectRef(this.tail[0]);
        Object[] objArr = this.root;
        Intrinsics.checkNotNull(objArr);
        removeFromTailAt(removeFromRootAt(objArr, this.rootShift, index, objectRef), rootSize, this.rootShift, 0);
        return (E) objectRef.getValue();
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int index, E element) {
        ListImplementation.checkElementIndex$runtime_release(index, size());
        if (rootSize() <= index) {
            Object[] makeMutable = makeMutable(this.tail);
            if (makeMutable != this.tail) {
                ((AbstractList) this).modCount++;
            }
            int i3 = index & 31;
            E e16 = (E) makeMutable[i3];
            makeMutable[i3] = element;
            this.tail = makeMutable;
            return e16;
        }
        ObjectRef objectRef = new ObjectRef(null);
        Object[] objArr = this.root;
        Intrinsics.checkNotNull(objArr);
        this.root = setInRoot(objArr, this.rootShift, index, element, objectRef);
        return (E) objectRef.getValue();
    }

    public final void setRootShift$runtime_release(int i3) {
        this.rootShift = i3;
    }

    private final boolean removeAll(Function1<? super E, Boolean> predicate) {
        Object[] pushBuffers;
        int tailSize = tailSize();
        ObjectRef objectRef = new ObjectRef(null);
        if (this.root == null) {
            return removeAllFromTail(predicate, tailSize, objectRef) != tailSize;
        }
        ListIterator<Object[]> leafBufferIterator = leafBufferIterator(0);
        int i3 = 32;
        while (i3 == 32 && leafBufferIterator.hasNext()) {
            i3 = removeAll(predicate, leafBufferIterator.next(), 32, objectRef);
        }
        if (i3 == 32) {
            CommonFunctionsKt.m32assert(!leafBufferIterator.hasNext());
            int removeAllFromTail = removeAllFromTail(predicate, tailSize, objectRef);
            if (removeAllFromTail == 0) {
                pullLastBufferFromRoot(this.root, size(), this.rootShift);
            }
            return removeAllFromTail != tailSize;
        }
        int previousIndex = leafBufferIterator.previousIndex() << 5;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i16 = i3;
        while (leafBufferIterator.hasNext()) {
            i16 = recyclableRemoveAll(predicate, leafBufferIterator.next(), 32, i16, objectRef, arrayList2, arrayList);
            previousIndex = previousIndex;
        }
        int i17 = previousIndex;
        int recyclableRemoveAll = recyclableRemoveAll(predicate, this.tail, tailSize, i16, objectRef, arrayList2, arrayList);
        Object value = objectRef.getValue();
        if (value != null) {
            Object[] objArr = (Object[]) value;
            ArraysKt___ArraysJvmKt.fill(objArr, (Object) null, recyclableRemoveAll, 32);
            if (arrayList.isEmpty()) {
                pushBuffers = this.root;
                Intrinsics.checkNotNull(pushBuffers);
            } else {
                pushBuffers = pushBuffers(this.root, i17, this.rootShift, arrayList.iterator());
            }
            int size = i17 + (arrayList.size() << 5);
            this.root = retainFirst(pushBuffers, size);
            this.tail = objArr;
            this.size = size + recyclableRemoveAll;
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }

    private final int tailSize() {
        return tailSize(size());
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder
    public PersistentList<E> build() {
        PersistentVector persistentVector;
        if (this.root == this.vectorRoot && this.tail == this.vectorTail) {
            persistentVector = this.vector;
        } else {
            this.ownership = new MutabilityOwnership();
            Object[] objArr = this.root;
            this.vectorRoot = objArr;
            Object[] objArr2 = this.tail;
            this.vectorTail = objArr2;
            if (objArr == null) {
                if (objArr2.length == 0) {
                    persistentVector = UtilsKt.persistentVectorOf();
                } else {
                    Object[] copyOf = Arrays.copyOf(this.tail, size());
                    Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                    persistentVector = new SmallPersistentVector(copyOf);
                }
            } else {
                Object[] objArr3 = this.root;
                Intrinsics.checkNotNull(objArr3);
                persistentVector = new PersistentVector(objArr3, this.tail, size(), this.rootShift);
            }
        }
        this.vector = persistentVector;
        return (PersistentList<E>) persistentVector;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int index) {
        ListImplementation.checkPositionIndex$runtime_release(index, size());
        return new PersistentVectorMutableIterator(this, index);
    }

    private final Object[] makeMutable(Object[] buffer) {
        int coerceAtMost;
        Object[] copyInto$default;
        if (buffer == null) {
            return mutableBuffer();
        }
        if (isMutable(buffer)) {
            return buffer;
        }
        Object[] mutableBuffer = mutableBuffer();
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(buffer.length, 32);
        copyInto$default = ArraysKt___ArraysJvmKt.copyInto$default(buffer, mutableBuffer, 0, 0, coerceAtMost, 6, (Object) null);
        return copyInto$default;
    }

    private final Object[] mutableBuffer() {
        Object[] objArr = new Object[33];
        objArr[32] = this.ownership;
        return objArr;
    }

    private final Object[] mutableBufferWith(Object element) {
        Object[] objArr = new Object[33];
        objArr[0] = element;
        objArr[32] = this.ownership;
        return objArr;
    }

    private final Object[] pullLastBuffer(Object[] root, int shift, int rootSize, ObjectRef tailCarry) {
        Object[] pullLastBuffer;
        int indexSegment = UtilsKt.indexSegment(rootSize - 1, shift);
        if (shift == 5) {
            tailCarry.setValue(root[indexSegment]);
            pullLastBuffer = null;
        } else {
            Object obj = root[indexSegment];
            if (obj != null) {
                pullLastBuffer = pullLastBuffer((Object[]) obj, shift - 5, rootSize, tailCarry);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            }
        }
        if (pullLastBuffer == null && indexSegment == 0) {
            return null;
        }
        Object[] makeMutable = makeMutable(root);
        makeMutable[indexSegment] = pullLastBuffer;
        return makeMutable;
    }

    private final Object[] copyToBuffer(Object[] buffer, int bufferIndex, Iterator<? extends Object> sourceIterator) {
        while (bufferIndex < 32 && sourceIterator.hasNext()) {
            buffer[bufferIndex] = sourceIterator.next();
            bufferIndex++;
        }
        return buffer;
    }

    private final void pullLastBufferFromRoot(Object[] root, int rootSize, int shift) {
        if (shift == 0) {
            this.root = null;
            if (root == null) {
                root = new Object[0];
            }
            this.tail = root;
            this.size = rootSize;
            this.rootShift = shift;
            return;
        }
        ObjectRef objectRef = new ObjectRef(null);
        Intrinsics.checkNotNull(root);
        Object[] pullLastBuffer = pullLastBuffer(root, shift, rootSize, objectRef);
        Intrinsics.checkNotNull(pullLastBuffer);
        Object value = objectRef.getValue();
        if (value != null) {
            this.tail = (Object[]) value;
            this.size = rootSize;
            if (pullLastBuffer[1] == null) {
                this.root = (Object[]) pullLastBuffer[0];
                this.rootShift = shift - 5;
                return;
            } else {
                this.root = pullLastBuffer;
                this.rootShift = shift;
                return;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int index, E element) {
        ListImplementation.checkPositionIndex$runtime_release(index, size());
        if (index == size()) {
            add(element);
            return;
        }
        ((AbstractList) this).modCount++;
        int rootSize = rootSize();
        if (index >= rootSize) {
            insertIntoTail(this.root, index - rootSize, element);
            return;
        }
        ObjectRef objectRef = new ObjectRef(null);
        Object[] objArr = this.root;
        Intrinsics.checkNotNull(objArr);
        insertIntoTail(insertIntoRoot(objArr, this.rootShift, index, element, objectRef), 0, objectRef.getValue());
    }

    private final void insertIntoRoot(Collection<? extends E> elements, int index, int rightShift, Object[][] buffers, int nullBuffers, Object[] nextBuffer) {
        if (this.root != null) {
            int i3 = index >> 5;
            Object[] shiftLeafBuffers = shiftLeafBuffers(i3, rightShift, buffers, nullBuffers, nextBuffer);
            int rootSize = nullBuffers - (((rootSize() >> 5) - 1) - i3);
            if (rootSize < nullBuffers) {
                nextBuffer = buffers[rootSize];
                Intrinsics.checkNotNull(nextBuffer);
            }
            splitToBuffers(elements, index, shiftLeafBuffers, 32, buffers, rootSize, nextBuffer);
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final void splitToBuffers(Collection<? extends E> elements, int index, Object[] startBuffer, int startBufferSize, Object[][] buffers, int nullBuffers, Object[] nextBuffer) {
        Object[] mutableBuffer;
        if (nullBuffers >= 1) {
            Object[] makeMutable = makeMutable(startBuffer);
            buffers[0] = makeMutable;
            int i3 = index & 31;
            int size = ((index + elements.size()) - 1) & 31;
            int i16 = (startBufferSize - i3) + size;
            if (i16 < 32) {
                ArraysKt___ArraysJvmKt.copyInto(makeMutable, nextBuffer, size + 1, i3, startBufferSize);
            } else {
                int i17 = (i16 - 32) + 1;
                if (nullBuffers == 1) {
                    mutableBuffer = makeMutable;
                } else {
                    mutableBuffer = mutableBuffer();
                    nullBuffers--;
                    buffers[nullBuffers] = mutableBuffer;
                }
                int i18 = startBufferSize - i17;
                ArraysKt___ArraysJvmKt.copyInto(makeMutable, nextBuffer, 0, i18, startBufferSize);
                ArraysKt___ArraysJvmKt.copyInto(makeMutable, mutableBuffer, size + 1, i3, i18);
                nextBuffer = mutableBuffer;
            }
            Iterator<? extends E> it = elements.iterator();
            copyToBuffer(makeMutable, i3, it);
            for (int i19 = 1; i19 < nullBuffers; i19++) {
                buffers[i19] = copyToBuffer(mutableBuffer(), 0, it);
            }
            copyToBuffer(nextBuffer, 0, it);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final Object[] nullifyAfter(Object[] root, int index, int shift) {
        if (!(shift >= 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (shift == 0) {
            return root;
        }
        int indexSegment = UtilsKt.indexSegment(index, shift);
        Object obj = root[indexSegment];
        if (obj != null) {
            Object nullifyAfter = nullifyAfter((Object[]) obj, index, shift - 5);
            if (indexSegment < 31) {
                int i3 = indexSegment + 1;
                if (root[i3] != null) {
                    if (isMutable(root)) {
                        ArraysKt___ArraysJvmKt.fill(root, (Object) null, i3, 32);
                    }
                    root = ArraysKt___ArraysJvmKt.copyInto(root, mutableBuffer(), 0, 0, i3);
                }
            }
            if (nullifyAfter == root[indexSegment]) {
                return root;
            }
            Object[] makeMutable = makeMutable(root);
            makeMutable[indexSegment] = nullifyAfter;
            return makeMutable;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }

    private final Object[] retainFirst(Object[] root, int size) {
        if (!((size & 31) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (size == 0) {
            this.rootShift = 0;
            return null;
        }
        int i3 = size - 1;
        while (true) {
            int i16 = this.rootShift;
            if ((i3 >> i16) == 0) {
                this.rootShift = i16 - 5;
                Object[] objArr = root[0];
                if (objArr != null) {
                    root = objArr;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                }
            } else {
                return nullifyAfter(root, i3, i16);
            }
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int index, Collection<? extends E> elements) {
        Object[] copyInto;
        Object[] copyInto2;
        Intrinsics.checkNotNullParameter(elements, "elements");
        ListImplementation.checkPositionIndex$runtime_release(index, size());
        if (index == size()) {
            return addAll(elements);
        }
        if (elements.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int i3 = (index >> 5) << 5;
        int size = (((size() - i3) + elements.size()) - 1) / 32;
        if (size == 0) {
            CommonFunctionsKt.m32assert(index >= rootSize());
            int i16 = index & 31;
            int size2 = ((index + elements.size()) - 1) & 31;
            Object[] objArr = this.tail;
            copyInto2 = ArraysKt___ArraysJvmKt.copyInto(objArr, makeMutable(objArr), size2 + 1, i16, tailSize());
            copyToBuffer(copyInto2, i16, elements.iterator());
            this.tail = copyInto2;
            this.size = size() + elements.size();
            return true;
        }
        Object[][] objArr2 = new Object[size];
        int tailSize = tailSize();
        int tailSize2 = tailSize(size() + elements.size());
        if (index >= rootSize()) {
            copyInto = mutableBuffer();
            splitToBuffers(elements, index, this.tail, tailSize, objArr2, size, copyInto);
        } else if (tailSize2 <= tailSize) {
            int i17 = tailSize - tailSize2;
            copyInto = ArraysKt___ArraysJvmKt.copyInto(this.tail, mutableBuffer(), 0, i17, tailSize);
            int i18 = 32 - i17;
            Object[] makeMutableShiftingRight = makeMutableShiftingRight(this.tail, i18);
            int i19 = size - 1;
            objArr2[i19] = makeMutableShiftingRight;
            insertIntoRoot(elements, index, i18, objArr2, i19, makeMutableShiftingRight);
        } else {
            int i26 = tailSize2 - tailSize;
            copyInto = makeMutableShiftingRight(this.tail, i26);
            insertIntoRoot(elements, index, i26, objArr2, size, copyInto);
        }
        this.root = pushBuffersIncreasingHeightIfNeeded(this.root, i3, objArr2);
        this.tail = copyInto;
        this.size = size() + elements.size();
        return true;
    }

    private final int removeAll(Function1<? super E, Boolean> predicate, Object[] buffer, int bufferSize, ObjectRef bufferRef) {
        Object[] objArr = buffer;
        int i3 = bufferSize;
        boolean z16 = false;
        for (int i16 = 0; i16 < bufferSize; i16++) {
            Object obj = buffer[i16];
            if (predicate.invoke(obj).booleanValue()) {
                if (!z16) {
                    objArr = makeMutable(buffer);
                    z16 = true;
                    i3 = i16;
                }
            } else if (z16) {
                objArr[i3] = obj;
                i3++;
            }
        }
        bufferRef.setValue(objArr);
        return i3;
    }
}
