package androidx.compose.runtime;

import androidx.compose.runtime.Composer;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.tritonaudio.webaudio.AudioContext;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$SecurityData;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u001f\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\b8\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u009d\u00012\u00020\u0001:\u0002\u009d\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\nJ\u000e\u00105\u001a\u0002022\u0006\u00104\u001a\u00020\nJ\u0010\u00106\u001a\u00020\u00072\b\b\u0002\u00107\u001a\u00020\nJ\u000e\u00108\u001a\u00020\n2\u0006\u00106\u001a\u00020\u0007J\r\u00109\u001a\u000202H\u0000\u00a2\u0006\u0002\b:J\u0006\u0010;\u001a\u000202J\u0010\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\nH\u0002J\u0006\u0010>\u001a\u000202J\u0010\u0010?\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\nH\u0002J\u0010\u0010@\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\nH\u0002J \u0010A\u001a\u00020\n2\u0006\u00106\u001a\u00020\n2\u0006\u0010B\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010C\u001a\u00020\n2\u0006\u00107\u001a\u00020\nH\u0002J\u0010\u0010D\u001a\u00020\n2\u0006\u0010C\u001a\u00020\nH\u0002J(\u0010E\u001a\u00020\n2\u0006\u00107\u001a\u00020\n2\u0006\u0010F\u001a\u00020\n2\u0006\u0010B\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010G\u001a\u00020\nJ\u0006\u0010H\u001a\u000202J\u000e\u0010I\u001a\u0002022\u0006\u00106\u001a\u00020\u0007J\u000e\u0010I\u001a\u0002022\u0006\u00107\u001a\u00020\nJ \u0010J\u001a\u0002022\u0006\u0010\"\u001a\u00020\n2\u0006\u0010G\u001a\u00020\n2\u0006\u0010K\u001a\u00020\nH\u0002J\u0010\u0010L\u001a\u0004\u0018\u00010\u00012\u0006\u00107\u001a\u00020\nJ\u0010\u0010M\u001a\u00020\n2\u0006\u00107\u001a\u00020\nH\u0002J\u000e\u0010N\u001a\u00020\n2\u0006\u00107\u001a\u00020\nJ\u0010\u0010O\u001a\u0004\u0018\u00010\u00012\u0006\u00107\u001a\u00020\nJ\u000e\u0010P\u001a\u00020\n2\u0006\u00107\u001a\u00020\nJ\u000e\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010RJ\u0006\u0010S\u001a\u00020TJ\u000e\u0010U\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\nJ\u0016\u0010V\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nJ\u000e\u0010W\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\nJ\u0010\u0010X\u001a\u0002022\b\u0010Y\u001a\u0004\u0018\u00010\u0001J\u0010\u0010Z\u001a\u0002022\u0006\u0010&\u001a\u00020\nH\u0002J\u000e\u0010[\u001a\u0002022\u0006\u0010\\\u001a\u00020\nJ\u0018\u0010]\u001a\u0002022\u0006\u0010&\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nH\u0002J\u000e\u0010\u001f\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\nJ\u000e\u0010^\u001a\b\u0012\u0004\u0012\u00020\n0_H\u0002J\u0010\u0010`\u001a\u0002022\b\b\u0002\u0010=\u001a\u00020\nJ \u0010a\u001a\u0002022\u0006\u0010b\u001a\u00020\n2\u0006\u0010c\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0002J\u001c\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00070_2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00107\u001a\u00020\nJ\u000e\u0010e\u001a\u0002022\u0006\u0010f\u001a\u00020\nJ\u0010\u0010g\u001a\u0002022\u0006\u00107\u001a\u00020\nH\u0002J$\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00070_2\u0006\u0010f\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00107\u001a\u00020\nJ\u0018\u0010i\u001a\u0002022\u0006\u00107\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nH\u0002J$\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00070_2\u0006\u00106\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\n2\u0006\u0010k\u001a\u00020\u0000J\u0010\u0010l\u001a\u0004\u0018\u00010\u00012\u0006\u00106\u001a\u00020\u0007J\u0010\u0010l\u001a\u0004\u0018\u00010\u00012\u0006\u00107\u001a\u00020\nJ\u000e\u0010 \u001a\u00020\n2\u0006\u00107\u001a\u00020\nJ\u000e\u0010\"\u001a\u00020\n2\u0006\u00106\u001a\u00020\u0007J\u000e\u0010\"\u001a\u00020\n2\u0006\u00107\u001a\u00020\nJ\u0010\u0010m\u001a\u00020\n2\u0006\u00107\u001a\u00020\nH\u0002J\u0018\u0010n\u001a\u00020\n2\u0006\u00107\u001a\u00020\n2\u0006\u0010F\u001a\u00020\nH\u0002J\b\u0010o\u001a\u000202H\u0002J\u0018\u0010p\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0002J\u0006\u0010q\u001a\u00020\u000eJ\u0018\u0010r\u001a\u00020\u000e2\u0006\u0010s\u001a\u00020\n2\u0006\u0010t\u001a\u00020\nH\u0002J \u0010u\u001a\u0002022\u0006\u0010s\u001a\u00020\n2\u0006\u0010t\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nH\u0002J\u0006\u0010v\u001a\u000202J\b\u0010w\u001a\u00020\nH\u0002J\b\u0010x\u001a\u000202H\u0002J\u000e\u0010y\u001a\u0002022\u0006\u00106\u001a\u00020\u0007J\u0010\u0010z\u001a\u0002022\b\u0010Y\u001a\u0004\u0018\u00010\u0001J\u001a\u0010z\u001a\u0004\u0018\u00010\u00012\u0006\u00107\u001a\u00020\n2\b\u0010Y\u001a\u0004\u0018\u00010\u0001J\b\u0010{\u001a\u0004\u0018\u00010\u0001J\u0006\u0010|\u001a\u00020\nJ\u0006\u0010}\u001a\u000202J\u0018\u0010~\u001a\u0004\u0018\u00010\u00012\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\nJ\u0018\u0010~\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u007f\u001a\u00020\n2\u0006\u00107\u001a\u00020\nJ\u001a\u0010\u0080\u0001\u001a\u0002022\u0006\u0010\\\u001a\u00020\n2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0001J%\u0010\u0080\u0001\u001a\u0002022\u0006\u0010\\\u001a\u00020\n2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00012\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0001J\u0007\u0010\u0083\u0001\u001a\u000202J\u000f\u0010\u0083\u0001\u001a\u0002022\u0006\u0010\\\u001a\u00020\nJ\u001a\u0010\u0083\u0001\u001a\u0002022\u0006\u0010\\\u001a\u00020\n2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0001J/\u0010\u0083\u0001\u001a\u0002022\u0006\u0010\\\u001a\u00020\n2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001f\u001a\u00020\u000e2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0001H\u0002J\u0011\u0010\u0085\u0001\u001a\u0002022\b\u0010\\\u001a\u0004\u0018\u00010\u0001J\u001b\u0010\u0085\u0001\u001a\u0002022\b\u0010\\\u001a\u0004\u0018\u00010\u00012\b\u0010l\u001a\u0004\u0018\u00010\u0001J\t\u0010\u0086\u0001\u001a\u00020TH\u0016J\u0013\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00012\b\u0010Y\u001a\u0004\u0018\u00010\u0001J\u001b\u0010\u0088\u0001\u001a\u0002022\u0007\u0010\u0089\u0001\u001a\u00020\n2\u0007\u0010\u008a\u0001\u001a\u00020\nH\u0002J\u0011\u0010\u008b\u0001\u001a\u0002022\b\u0010Y\u001a\u0004\u0018\u00010\u0001J\u0011\u0010\u008c\u0001\u001a\u0002022\u0006\u0010=\u001a\u00020\nH\u0002J\u0019\u0010\u008d\u0001\u001a\u0002022\u0006\u0010=\u001a\u00020\n2\u0006\u0010z\u001a\u00020%H\u0002J\u0019\u0010\u008e\u0001\u001a\u0002022\u0006\u00106\u001a\u00020\u00072\b\u0010Y\u001a\u0004\u0018\u00010\u0001J\u0011\u0010\u008e\u0001\u001a\u0002022\b\u0010Y\u001a\u0004\u0018\u00010\u0001J\u001b\u0010\u008f\u0001\u001a\u0002022\u0006\u00107\u001a\u00020\n2\b\u0010Y\u001a\u0004\u0018\u00010\u0001H\u0002J\u0011\u0010\u0090\u0001\u001a\u0002022\b\u0010Y\u001a\u0004\u0018\u00010\u0001J\u000f\u0010\u0091\u0001\u001a\u000202H\u0000\u00a2\u0006\u0003\b\u0092\u0001J\u000f\u0010\u0093\u0001\u001a\u000202H\u0000\u00a2\u0006\u0003\b\u0094\u0001J\u0015\u0010\u0095\u0001\u001a\u00020\n*\u00020\u001c2\u0006\u00103\u001a\u00020\nH\u0002J\u0014\u0010C\u001a\u00020\n*\u00020\u001c2\u0006\u00103\u001a\u00020\nH\u0002J\u0013\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u00020\n0_*\u00020\u001cH\u0002J\u001b\u0010\u0097\u0001\u001a\u000202*\b0\u0098\u0001j\u0003`\u0099\u00012\u0006\u00107\u001a\u00020\nH\u0002J\u0015\u0010\u009a\u0001\u001a\u00020\n*\u00020\u001c2\u0006\u00103\u001a\u00020\nH\u0002J\u0014\u0010\"\u001a\u00020\n*\u00020\u001c2\u0006\u00107\u001a\u00020\nH\u0002J\u0015\u0010\u009b\u0001\u001a\u00020\n*\u00020\u001c2\u0006\u00103\u001a\u00020\nH\u0002J\u001d\u0010\u009c\u0001\u001a\u000202*\u00020\u001c2\u0006\u00103\u001a\u00020\n2\u0006\u0010C\u001a\u00020\nH\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u0011R\u0011\u0010\u001f\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0011R\u000e\u0010 \u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\fR\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020\n8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010\fR\u0018\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010)X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010*R\u000e\u0010+\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100\u00a8\u0006\u009e\u0001"}, d2 = {"Landroidx/compose/runtime/SlotWriter;", "", "table", "Landroidx/compose/runtime/SlotTable;", "(Landroidx/compose/runtime/SlotTable;)V", "anchors", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/Anchor;", "Lkotlin/collections/ArrayList;", "capacity", "", "getCapacity", "()I", "<set-?>", "", AudioContext.State.CLOSED, "getClosed", "()Z", "currentGroup", "getCurrentGroup", "currentGroupEnd", "currentSlot", "currentSlotEnd", "endStack", "Landroidx/compose/runtime/IntStack;", "groupGapLen", "groupGapStart", "groups", "", "insertCount", "isGroupEnd", "isNode", "nodeCount", "nodeCountStack", HippyNestedScrollComponent.PRIORITY_PARENT, "getParent", "pendingRecalculateMarks", "Landroidx/compose/runtime/PrioritySet;", "size", "getSize$runtime_release", "slots", "", "[Ljava/lang/Object;", "slotsGapLen", "slotsGapOwner", "slotsGapStart", "startStack", "getTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "addToGroupSizeAlongSpine", "", "address", "amount", "advanceBy", "anchor", "index", "anchorIndex", "bashGroup", "bashGroup$runtime_release", "beginInsert", "childContainsAnyMarks", VipFunCallConstants.KEY_GROUP, "close", "containsAnyGroupMarks", "containsGroupMark", "dataAnchorToDataIndex", "gapLen", "dataIndex", "dataIndexToDataAddress", "dataIndexToDataAnchor", "gapStart", "endGroup", "endInsert", "ensureStarted", "fixParentAnchorsFor", "firstChild", "groupAux", "groupIndexToAddress", "groupKey", "groupObjectKey", "groupSize", "groupSlots", "", "groupsAsString", "", "indexInCurrentGroup", "indexInGroup", "indexInParent", "insertAux", "value", "insertGroups", "insertParentGroup", "key", "insertSlots", "keys", "", "markGroup", "moveAnchors", "originalLocation", "newLocation", "moveFrom", "moveGroup", "offset", "moveGroupGapTo", "moveIntoGroupFrom", "moveSlotGapTo", CanvasView.ACTION_MOVETO, "writer", "node", "parentAnchorToIndex", "parentIndexToAnchor", "recalculateMarks", "removeAnchors", "removeGroup", "removeGroups", "start", com.tencent.luggage.wxa.c8.c.E, "removeSlots", "reset", "restoreCurrentGroupEnd", "saveCurrentGroupEnd", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "set", "skip", "skipGroup", "skipToGroupEnd", "slot", "groupIndex", "startData", "aux", "objectKey", "startGroup", QAdRewardDefine$SecurityData.DATA_KEY, "startNode", "toString", "update", "updateAnchors", "previousGapStart", "newGapStart", "updateAux", "updateContainsMark", "updateContainsMarkNow", "updateNode", "updateNodeOfGroup", "updateParentNode", "verifyDataAnchors", "verifyDataAnchors$runtime_release", "verifyParentAnchors", "verifyParentAnchors$runtime_release", "auxIndex", "dataIndexes", "groupAsString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "nodeIndex", "slotIndex", "updateDataIndex", "Companion", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class SlotWriter {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ArrayList<Anchor> anchors;
    private boolean closed;
    private int currentGroup;
    private int currentGroupEnd;
    private int currentSlot;
    private int currentSlotEnd;
    private final IntStack endStack;
    private int groupGapLen;
    private int groupGapStart;
    private int[] groups;
    private int insertCount;
    private int nodeCount;
    private final IntStack nodeCountStack;
    private int parent;
    private PrioritySet pendingRecalculateMarks;
    private Object[] slots;
    private int slotsGapLen;
    private int slotsGapOwner;
    private int slotsGapStart;
    private final IntStack startStack;
    private final SlotTable table;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002\u00a8\u0006\u000e"}, d2 = {"Landroidx/compose/runtime/SlotWriter$Companion;", "", "()V", "moveGroup", "", "Landroidx/compose/runtime/Anchor;", "fromWriter", "Landroidx/compose/runtime/SlotWriter;", "fromIndex", "", "toWriter", "updateFromCursor", "", "updateToCursor", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<Anchor> moveGroup(SlotWriter fromWriter, int fromIndex, SlotWriter toWriter, boolean updateFromCursor, boolean updateToCursor) {
            int locationOf;
            int locationOf2;
            List<Anchor> emptyList;
            List<Anchor> list;
            boolean z16;
            boolean isNode;
            int locationOf3;
            int i3;
            int parentAnchor;
            int groupSize = fromWriter.groupSize(fromIndex);
            int i16 = fromIndex + groupSize;
            int dataIndex = fromWriter.dataIndex(fromIndex);
            int dataIndex2 = fromWriter.dataIndex(i16);
            int i17 = dataIndex2 - dataIndex;
            boolean containsAnyGroupMarks = fromWriter.containsAnyGroupMarks(fromIndex);
            toWriter.insertGroups(groupSize);
            toWriter.insertSlots(i17, toWriter.getCurrentGroup());
            if (fromWriter.groupGapStart < i16) {
                fromWriter.moveGroupGapTo(i16);
            }
            if (fromWriter.slotsGapStart < dataIndex2) {
                fromWriter.moveSlotGapTo(dataIndex2, i16);
            }
            int[] iArr = toWriter.groups;
            int currentGroup = toWriter.getCurrentGroup();
            ArraysKt___ArraysJvmKt.copyInto(fromWriter.groups, iArr, currentGroup * 5, fromIndex * 5, i16 * 5);
            Object[] objArr = toWriter.slots;
            int i18 = toWriter.currentSlot;
            ArraysKt___ArraysJvmKt.copyInto(fromWriter.slots, objArr, i18, dataIndex, dataIndex2);
            int parent = toWriter.getParent();
            SlotTableKt.updateParentAnchor(iArr, currentGroup, parent);
            int i19 = currentGroup - fromIndex;
            int i26 = currentGroup + groupSize;
            int dataIndex3 = i18 - toWriter.dataIndex(iArr, currentGroup);
            int i27 = toWriter.slotsGapOwner;
            int i28 = toWriter.slotsGapLen;
            int length = objArr.length;
            int i29 = i27;
            int i36 = currentGroup;
            while (true) {
                if (i36 >= i26) {
                    break;
                }
                if (i36 != currentGroup) {
                    parentAnchor = SlotTableKt.parentAnchor(iArr, i36);
                    i3 = i26;
                    SlotTableKt.updateParentAnchor(iArr, i36, parentAnchor + i19);
                } else {
                    i3 = i26;
                }
                int i37 = dataIndex3;
                SlotTableKt.updateDataAnchor(iArr, i36, toWriter.dataIndexToDataAnchor(toWriter.dataIndex(iArr, i36) + dataIndex3, i29 >= i36 ? toWriter.slotsGapStart : 0, i28, length));
                if (i36 == i29) {
                    i29++;
                }
                i36++;
                dataIndex3 = i37;
                i26 = i3;
            }
            int i38 = i26;
            toWriter.slotsGapOwner = i29;
            locationOf = SlotTableKt.locationOf(fromWriter.anchors, fromIndex, fromWriter.getSize$runtime_release());
            locationOf2 = SlotTableKt.locationOf(fromWriter.anchors, i16, fromWriter.getSize$runtime_release());
            if (locationOf < locationOf2) {
                ArrayList arrayList = fromWriter.anchors;
                ArrayList arrayList2 = new ArrayList(locationOf2 - locationOf);
                for (int i39 = locationOf; i39 < locationOf2; i39++) {
                    Object obj = arrayList.get(i39);
                    Intrinsics.checkNotNullExpressionValue(obj, "sourceAnchors[anchorIndex]");
                    Anchor anchor = (Anchor) obj;
                    anchor.setLocation$runtime_release(anchor.getLocation() + i19);
                    arrayList2.add(anchor);
                }
                locationOf3 = SlotTableKt.locationOf(toWriter.anchors, toWriter.getCurrentGroup(), toWriter.getSize$runtime_release());
                toWriter.anchors.addAll(locationOf3, arrayList2);
                arrayList.subList(locationOf, locationOf2).clear();
                list = arrayList2;
            } else {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                list = emptyList;
            }
            int parent2 = fromWriter.parent(fromIndex);
            if (!updateFromCursor) {
                boolean removeGroups = fromWriter.removeGroups(fromIndex, groupSize);
                fromWriter.removeSlots(dataIndex, i17, fromIndex - 1);
                z16 = removeGroups;
            } else {
                int i46 = parent2 >= 0 ? 1 : 0;
                if (i46 != 0) {
                    fromWriter.startGroup();
                    fromWriter.advanceBy(parent2 - fromWriter.getCurrentGroup());
                    fromWriter.startGroup();
                }
                fromWriter.advanceBy(fromIndex - fromWriter.getCurrentGroup());
                z16 = fromWriter.removeGroup();
                if (i46 != 0) {
                    fromWriter.skipToGroupEnd();
                    fromWriter.endGroup();
                    fromWriter.skipToGroupEnd();
                    fromWriter.endGroup();
                }
            }
            if (!z16) {
                int i47 = toWriter.nodeCount;
                isNode = SlotTableKt.isNode(iArr, currentGroup);
                toWriter.nodeCount = i47 + (isNode ? 1 : SlotTableKt.nodeCount(iArr, currentGroup));
                if (updateToCursor) {
                    toWriter.currentGroup = i38;
                    toWriter.currentSlot = i18 + i17;
                }
                if (containsAnyGroupMarks) {
                    toWriter.updateContainsMark(parent);
                }
                return list;
            }
            ComposerKt.composeRuntimeError("Unexpectedly removed anchors".toString());
            throw new KotlinNothingValueException();
        }
    }

    public SlotWriter(SlotTable table) {
        Intrinsics.checkNotNullParameter(table, "table");
        this.table = table;
        this.groups = table.getGroups();
        this.slots = table.getSlots();
        this.anchors = table.getAnchors$runtime_release();
        this.groupGapStart = table.getGroupsSize();
        this.groupGapLen = (this.groups.length / 5) - table.getGroupsSize();
        this.currentGroupEnd = table.getGroupsSize();
        this.slotsGapStart = table.getSlotsSize();
        this.slotsGapLen = this.slots.length - table.getSlotsSize();
        this.slotsGapOwner = table.getGroupsSize();
        this.startStack = new IntStack();
        this.endStack = new IntStack();
        this.nodeCountStack = new IntStack();
        this.parent = -1;
    }

    private final int auxIndex(int[] iArr, int i3) {
        int groupInfo;
        int countOneBits;
        int dataIndex = dataIndex(iArr, i3);
        groupInfo = SlotTableKt.groupInfo(iArr, i3);
        countOneBits = SlotTableKt.countOneBits(groupInfo >> 29);
        return dataIndex + countOneBits;
    }

    private final int dataAnchorToDataIndex(int anchor, int gapLen, int capacity) {
        if (anchor < 0) {
            return (capacity - gapLen) + anchor + 1;
        }
        return anchor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndex(int index) {
        return dataIndex(this.groups, groupIndexToAddress(index));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndexToDataAddress(int dataIndex) {
        return dataIndex < this.slotsGapStart ? dataIndex : dataIndex + this.slotsGapLen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndexToDataAnchor(int index, int gapStart, int gapLen, int capacity) {
        if (index > gapStart) {
            return -(((capacity - gapLen) - index) + 1);
        }
        return index;
    }

    private final List<Integer> dataIndexes(int[] iArr) {
        IntRange until;
        List slice;
        IntRange until2;
        List slice2;
        List plus;
        List dataAnchors$default = SlotTableKt.dataAnchors$default(this.groups, 0, 1, null);
        until = RangesKt___RangesKt.until(0, this.groupGapStart);
        slice = CollectionsKt___CollectionsKt.slice(dataAnchors$default, until);
        until2 = RangesKt___RangesKt.until(this.groupGapStart + this.groupGapLen, iArr.length / 5);
        slice2 = CollectionsKt___CollectionsKt.slice(dataAnchors$default, until2);
        plus = CollectionsKt___CollectionsKt.plus((Collection) slice, (Iterable) slice2);
        ArrayList arrayList = new ArrayList(plus.size());
        int size = plus.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(Integer.valueOf(dataAnchorToDataIndex(((Number) plus.get(i3)).intValue(), this.slotsGapLen, this.slots.length)));
        }
        return arrayList;
    }

    private final void fixParentAnchorsFor(int parent, int endGroup, int firstChild) {
        int groupSize;
        int parentIndexToAnchor = parentIndexToAnchor(parent, this.groupGapStart);
        while (firstChild < endGroup) {
            SlotTableKt.updateParentAnchor(this.groups, groupIndexToAddress(firstChild), parentIndexToAnchor);
            groupSize = SlotTableKt.groupSize(this.groups, groupIndexToAddress(firstChild));
            int i3 = groupSize + firstChild;
            fixParentAnchorsFor(firstChild, i3, firstChild + 1);
            firstChild = i3;
        }
    }

    private final int getCapacity() {
        return this.groups.length / 5;
    }

    private final void groupAsString(StringBuilder sb5, int i3) {
        int groupSize;
        int parentAnchor;
        int key;
        int nodeCount;
        int dataAnchor;
        int parentAnchor2;
        boolean isNode;
        int groupIndexToAddress = groupIndexToAddress(i3);
        sb5.append("Group(");
        if (i3 < 10) {
            sb5.append(TokenParser.SP);
        }
        if (i3 < 100) {
            sb5.append(TokenParser.SP);
        }
        if (i3 < 1000) {
            sb5.append(TokenParser.SP);
        }
        sb5.append(i3);
        if (groupIndexToAddress != i3) {
            sb5.append("(");
            sb5.append(groupIndexToAddress);
            sb5.append(")");
        }
        sb5.append('#');
        groupSize = SlotTableKt.groupSize(this.groups, groupIndexToAddress);
        sb5.append(groupSize);
        boolean groupAsString$isStarted = groupAsString$isStarted(this, i3);
        if (groupAsString$isStarted) {
            sb5.append('?');
        }
        sb5.append('^');
        parentAnchor = SlotTableKt.parentAnchor(this.groups, groupIndexToAddress);
        sb5.append(parentAnchorToIndex(parentAnchor));
        sb5.append(": key=");
        key = SlotTableKt.key(this.groups, groupIndexToAddress);
        sb5.append(key);
        sb5.append(", nodes=");
        nodeCount = SlotTableKt.nodeCount(this.groups, groupIndexToAddress);
        sb5.append(nodeCount);
        if (groupAsString$isStarted) {
            sb5.append('?');
        }
        sb5.append(", dataAnchor=");
        dataAnchor = SlotTableKt.dataAnchor(this.groups, groupIndexToAddress);
        sb5.append(dataAnchor);
        sb5.append(", parentAnchor=");
        parentAnchor2 = SlotTableKt.parentAnchor(this.groups, groupIndexToAddress);
        sb5.append(parentAnchor2);
        isNode = SlotTableKt.isNode(this.groups, groupIndexToAddress);
        if (isNode) {
            sb5.append(", node=" + this.slots[dataIndexToDataAddress(nodeIndex(this.groups, groupIndexToAddress))]);
        }
        int slotIndex = slotIndex(this.groups, groupIndexToAddress);
        int dataIndex = dataIndex(this.groups, groupIndexToAddress + 1);
        if (dataIndex > slotIndex) {
            sb5.append(", [");
            for (int i16 = slotIndex; i16 < dataIndex; i16++) {
                if (i16 != slotIndex) {
                    sb5.append(", ");
                }
                sb5.append(String.valueOf(this.slots[dataIndexToDataAddress(i16)]));
            }
            sb5.append(']');
        }
        sb5.append(")");
    }

    private static final boolean groupAsString$isStarted(SlotWriter slotWriter, int i3) {
        return i3 < slotWriter.currentGroup && (i3 == slotWriter.parent || slotWriter.startStack.indexOf(i3) >= 0 || groupAsString$isStarted(slotWriter, slotWriter.parent(i3)));
    }

    private final int groupIndexToAddress(int index) {
        return index < this.groupGapStart ? index : index + this.groupGapLen;
    }

    private final List<Integer> keys() {
        List keys$default = SlotTableKt.keys$default(this.groups, 0, 1, null);
        ArrayList arrayList = new ArrayList(keys$default.size());
        int size = keys$default.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = keys$default.get(i3);
            ((Number) obj).intValue();
            int i16 = this.groupGapStart;
            if (i3 < i16 || i3 >= i16 + this.groupGapLen) {
                arrayList.add(obj);
            }
            i3++;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void moveGroupGapTo(int index) {
        int parentAnchor;
        int i3 = this.groupGapLen;
        int i16 = this.groupGapStart;
        if (i16 != index) {
            if (!this.anchors.isEmpty()) {
                updateAnchors(i16, index);
            }
            if (i3 > 0) {
                int[] iArr = this.groups;
                int i17 = index * 5;
                int i18 = i3 * 5;
                int i19 = i16 * 5;
                if (index < i16) {
                    ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, i18 + i17, i17, i19);
                } else {
                    ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, i19, i19 + i18, i17 + i18);
                }
            }
            if (index < i16) {
                i16 = index + i3;
            }
            int capacity = getCapacity();
            ComposerKt.runtimeCheck(i16 < capacity);
            while (i16 < capacity) {
                parentAnchor = SlotTableKt.parentAnchor(this.groups, i16);
                int parentIndexToAnchor = parentIndexToAnchor(parentAnchorToIndex(parentAnchor), index);
                if (parentIndexToAnchor != parentAnchor) {
                    SlotTableKt.updateParentAnchor(this.groups, i16, parentIndexToAnchor);
                }
                i16++;
                if (i16 == index) {
                    i16 += i3;
                }
            }
        }
        this.groupGapStart = index;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void moveSlotGapTo(int index, int group) {
        int dataAnchor;
        int dataAnchor2;
        int i3 = this.slotsGapLen;
        int i16 = this.slotsGapStart;
        int i17 = this.slotsGapOwner;
        if (i16 != index) {
            Object[] objArr = this.slots;
            if (index < i16) {
                ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, index + i3, index, i16);
            } else {
                ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i16, i16 + i3, index + i3);
            }
            ArraysKt___ArraysJvmKt.fill(objArr, (Object) null, index, index + i3);
        }
        int min = Math.min(group + 1, getSize$runtime_release());
        if (i17 != min) {
            int length = this.slots.length - i3;
            if (min < i17) {
                int groupIndexToAddress = groupIndexToAddress(min);
                int groupIndexToAddress2 = groupIndexToAddress(i17);
                int i18 = this.groupGapStart;
                while (groupIndexToAddress < groupIndexToAddress2) {
                    dataAnchor2 = SlotTableKt.dataAnchor(this.groups, groupIndexToAddress);
                    if (dataAnchor2 >= 0) {
                        SlotTableKt.updateDataAnchor(this.groups, groupIndexToAddress, -((length - dataAnchor2) + 1));
                        groupIndexToAddress++;
                        if (groupIndexToAddress == i18) {
                            groupIndexToAddress += this.groupGapLen;
                        }
                    } else {
                        ComposerKt.composeRuntimeError("Unexpected anchor value, expected a positive anchor".toString());
                        throw new KotlinNothingValueException();
                    }
                }
            } else {
                int groupIndexToAddress3 = groupIndexToAddress(i17);
                int groupIndexToAddress4 = groupIndexToAddress(min);
                while (groupIndexToAddress3 < groupIndexToAddress4) {
                    dataAnchor = SlotTableKt.dataAnchor(this.groups, groupIndexToAddress3);
                    if (dataAnchor < 0) {
                        SlotTableKt.updateDataAnchor(this.groups, groupIndexToAddress3, dataAnchor + length + 1);
                        groupIndexToAddress3++;
                        if (groupIndexToAddress3 == this.groupGapStart) {
                            groupIndexToAddress3 += this.groupGapLen;
                        }
                    } else {
                        ComposerKt.composeRuntimeError("Unexpected anchor value, expected a negative anchor".toString());
                        throw new KotlinNothingValueException();
                    }
                }
            }
            this.slotsGapOwner = min;
        }
        this.slotsGapStart = index;
    }

    private final int nodeIndex(int[] iArr, int i3) {
        return dataIndex(iArr, i3);
    }

    private final void recalculateMarks() {
        PrioritySet prioritySet = this.pendingRecalculateMarks;
        if (prioritySet != null) {
            while (prioritySet.isNotEmpty()) {
                updateContainsMarkNow(prioritySet.takeMax(), prioritySet);
            }
        }
    }

    private final boolean removeAnchors(int gapStart, int size) {
        int locationOf;
        int i3 = size + gapStart;
        locationOf = SlotTableKt.locationOf(this.anchors, i3, getCapacity() - this.groupGapLen);
        if (locationOf >= this.anchors.size()) {
            locationOf--;
        }
        int i16 = locationOf + 1;
        int i17 = 0;
        while (locationOf >= 0) {
            Anchor anchor = this.anchors.get(locationOf);
            Intrinsics.checkNotNullExpressionValue(anchor, "anchors[index]");
            Anchor anchor2 = anchor;
            int anchorIndex = anchorIndex(anchor2);
            if (anchorIndex < gapStart) {
                break;
            }
            if (anchorIndex < i3) {
                anchor2.setLocation$runtime_release(Integer.MIN_VALUE);
                if (i17 == 0) {
                    i17 = locationOf + 1;
                }
                i16 = locationOf;
            }
            locationOf--;
        }
        boolean z16 = i16 < i17;
        if (z16) {
            this.anchors.subList(i16, i17).clear();
        }
        return z16;
    }

    private final int restoreCurrentGroupEnd() {
        int capacity = (getCapacity() - this.groupGapLen) - this.endStack.pop();
        this.currentGroupEnd = capacity;
        return capacity;
    }

    private final void saveCurrentGroupEnd() {
        this.endStack.push((getCapacity() - this.groupGapLen) - this.currentGroupEnd);
    }

    private final int slotIndex(int[] iArr, int i3) {
        int slotAnchor;
        if (i3 < getCapacity()) {
            slotAnchor = SlotTableKt.slotAnchor(iArr, i3);
            return dataAnchorToDataIndex(slotAnchor, this.slotsGapLen, this.slots.length);
        }
        return this.slots.length - this.slotsGapLen;
    }

    private final void updateAnchors(int previousGapStart, int newGapStart) {
        int locationOf;
        int locationOf2;
        int i3;
        int capacity = getCapacity() - this.groupGapLen;
        if (previousGapStart < newGapStart) {
            for (locationOf2 = SlotTableKt.locationOf(this.anchors, previousGapStart, capacity); locationOf2 < this.anchors.size(); locationOf2++) {
                Anchor anchor = this.anchors.get(locationOf2);
                Intrinsics.checkNotNullExpressionValue(anchor, "anchors[index]");
                Anchor anchor2 = anchor;
                int location = anchor2.getLocation();
                if (location >= 0 || (i3 = location + capacity) >= newGapStart) {
                    return;
                }
                anchor2.setLocation$runtime_release(i3);
            }
            return;
        }
        for (locationOf = SlotTableKt.locationOf(this.anchors, newGapStart, capacity); locationOf < this.anchors.size(); locationOf++) {
            Anchor anchor3 = this.anchors.get(locationOf);
            Intrinsics.checkNotNullExpressionValue(anchor3, "anchors[index]");
            Anchor anchor4 = anchor3;
            int location2 = anchor4.getLocation();
            if (location2 < 0) {
                return;
            }
            anchor4.setLocation$runtime_release(-(capacity - location2));
        }
    }

    private final void updateContainsMarkNow(int group, PrioritySet set) {
        boolean containsMark;
        int groupIndexToAddress = groupIndexToAddress(group);
        boolean childContainsAnyMarks = childContainsAnyMarks(group);
        containsMark = SlotTableKt.containsMark(this.groups, groupIndexToAddress);
        if (containsMark != childContainsAnyMarks) {
            SlotTableKt.updateContainsMark(this.groups, groupIndexToAddress, childContainsAnyMarks);
            int parent = parent(group);
            if (parent >= 0) {
                set.add(parent);
            }
        }
    }

    private final void updateDataIndex(int[] iArr, int i3, int i16) {
        SlotTableKt.updateDataAnchor(iArr, i3, dataIndexToDataAnchor(i16, this.slotsGapStart, this.slotsGapLen, this.slots.length));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateNodeOfGroup(int index, Object value) {
        boolean z16;
        boolean isNode;
        int groupIndexToAddress = groupIndexToAddress(index);
        int[] iArr = this.groups;
        if (groupIndexToAddress < iArr.length) {
            isNode = SlotTableKt.isNode(iArr, groupIndexToAddress);
            if (isNode) {
                z16 = true;
                if (!z16) {
                    this.slots[dataIndexToDataAddress(nodeIndex(this.groups, groupIndexToAddress))] = value;
                    return;
                }
                ComposerKt.composeRuntimeError(("Updating the node of a group at " + index + " that was not created with as a node group").toString());
                throw new KotlinNothingValueException();
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    public final Anchor anchor(int index) {
        ArrayList<Anchor> arrayList = this.anchors;
        int search = SlotTableKt.search(arrayList, index, getSize$runtime_release());
        if (search < 0) {
            if (index > this.groupGapStart) {
                index = -(getSize$runtime_release() - index);
            }
            Anchor anchor = new Anchor(index);
            arrayList.add(-(search + 1), anchor);
            return anchor;
        }
        Anchor anchor2 = arrayList.get(search);
        Intrinsics.checkNotNullExpressionValue(anchor2, "get(location)");
        return anchor2;
    }

    public final int anchorIndex(Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        int location = anchor.getLocation();
        return location < 0 ? location + getSize$runtime_release() : location;
    }

    public final void bashGroup$runtime_release() {
        startGroup();
        while (!isGroupEnd()) {
            insertParentGroup(-3);
            skipGroup();
        }
        endGroup();
    }

    public final void beginInsert() {
        int i3 = this.insertCount;
        this.insertCount = i3 + 1;
        if (i3 == 0) {
            saveCurrentGroupEnd();
        }
    }

    public final int endGroup() {
        boolean isNode;
        int groupSize;
        int nodeCount;
        boolean isNode2;
        int nodeCount2;
        int groupSize2;
        boolean z16 = this.insertCount > 0;
        int i3 = this.currentGroup;
        int i16 = this.currentGroupEnd;
        int i17 = this.parent;
        int groupIndexToAddress = groupIndexToAddress(i17);
        int i18 = this.nodeCount;
        int i19 = i3 - i17;
        isNode = SlotTableKt.isNode(this.groups, groupIndexToAddress);
        if (z16) {
            SlotTableKt.updateGroupSize(this.groups, groupIndexToAddress, i19);
            SlotTableKt.updateNodeCount(this.groups, groupIndexToAddress, i18);
            this.nodeCount = this.nodeCountStack.pop() + (isNode ? 1 : i18);
            this.parent = parent(this.groups, i17);
        } else {
            if ((i3 != i16 ? 0 : 1) != 0) {
                groupSize = SlotTableKt.groupSize(this.groups, groupIndexToAddress);
                nodeCount = SlotTableKt.nodeCount(this.groups, groupIndexToAddress);
                SlotTableKt.updateGroupSize(this.groups, groupIndexToAddress, i19);
                SlotTableKt.updateNodeCount(this.groups, groupIndexToAddress, i18);
                int pop = this.startStack.pop();
                restoreCurrentGroupEnd();
                this.parent = pop;
                int parent = parent(this.groups, i17);
                int pop2 = this.nodeCountStack.pop();
                this.nodeCount = pop2;
                if (parent == pop) {
                    this.nodeCount = pop2 + (isNode ? 0 : i18 - nodeCount);
                } else {
                    int i26 = i19 - groupSize;
                    int i27 = isNode ? 0 : i18 - nodeCount;
                    if (i26 != 0 || i27 != 0) {
                        while (parent != 0 && parent != pop && (i27 != 0 || i26 != 0)) {
                            int groupIndexToAddress2 = groupIndexToAddress(parent);
                            if (i26 != 0) {
                                groupSize2 = SlotTableKt.groupSize(this.groups, groupIndexToAddress2);
                                SlotTableKt.updateGroupSize(this.groups, groupIndexToAddress2, groupSize2 + i26);
                            }
                            if (i27 != 0) {
                                int[] iArr = this.groups;
                                nodeCount2 = SlotTableKt.nodeCount(iArr, groupIndexToAddress2);
                                SlotTableKt.updateNodeCount(iArr, groupIndexToAddress2, nodeCount2 + i27);
                            }
                            isNode2 = SlotTableKt.isNode(this.groups, groupIndexToAddress2);
                            if (isNode2) {
                                i27 = 0;
                            }
                            parent = parent(this.groups, parent);
                        }
                    }
                    this.nodeCount += i27;
                }
            } else {
                throw new IllegalArgumentException("Expected to be at the end of a group".toString());
            }
        }
        return i18;
    }

    public final void endInsert() {
        int i3 = this.insertCount;
        if (i3 > 0) {
            int i16 = i3 - 1;
            this.insertCount = i16;
            if (i16 == 0) {
                if (this.nodeCountStack.getTos() == this.startStack.getTos()) {
                    restoreCurrentGroupEnd();
                    return;
                } else {
                    ComposerKt.composeRuntimeError("startGroup/endGroup mismatch while inserting".toString());
                    throw new KotlinNothingValueException();
                }
            }
            return;
        }
        throw new IllegalStateException("Unbalanced begin/end insert".toString());
    }

    public final void ensureStarted(int index) {
        if (this.insertCount <= 0) {
            int i3 = this.parent;
            if (i3 != index) {
                if (index >= i3 && index < this.currentGroupEnd) {
                    int i16 = this.currentGroup;
                    int i17 = this.currentSlot;
                    int i18 = this.currentSlotEnd;
                    this.currentGroup = index;
                    startGroup();
                    this.currentGroup = i16;
                    this.currentSlot = i17;
                    this.currentSlotEnd = i18;
                    return;
                }
                throw new IllegalArgumentException(("Started group at " + index + " must be a subgroup of the group at " + i3).toString());
            }
            return;
        }
        throw new IllegalArgumentException("Cannot call ensureStarted() while inserting".toString());
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final int getCurrentGroup() {
        return this.currentGroup;
    }

    public final int getParent() {
        return this.parent;
    }

    public final int getSize$runtime_release() {
        return getCapacity() - this.groupGapLen;
    }

    /* renamed from: getTable$runtime_release, reason: from getter */
    public final SlotTable getTable() {
        return this.table;
    }

    public final Object groupAux(int index) {
        boolean hasAux;
        int groupIndexToAddress = groupIndexToAddress(index);
        hasAux = SlotTableKt.hasAux(this.groups, groupIndexToAddress);
        if (hasAux) {
            return this.slots[auxIndex(this.groups, groupIndexToAddress)];
        }
        return Composer.INSTANCE.getEmpty();
    }

    public final int groupKey(int index) {
        int key;
        key = SlotTableKt.key(this.groups, groupIndexToAddress(index));
        return key;
    }

    public final Object groupObjectKey(int index) {
        boolean hasObjectKey;
        int objectKeyIndex;
        int groupIndexToAddress = groupIndexToAddress(index);
        hasObjectKey = SlotTableKt.hasObjectKey(this.groups, groupIndexToAddress);
        if (!hasObjectKey) {
            return null;
        }
        Object[] objArr = this.slots;
        objectKeyIndex = SlotTableKt.objectKeyIndex(this.groups, groupIndexToAddress);
        return objArr[objectKeyIndex];
    }

    public final int groupSize(int index) {
        int groupSize;
        groupSize = SlotTableKt.groupSize(this.groups, groupIndexToAddress(index));
        return groupSize;
    }

    public final Iterator<Object> groupSlots() {
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(this.currentGroup));
        int[] iArr = this.groups;
        int i3 = this.currentGroup;
        return new SlotWriter$groupSlots$1(dataIndex, dataIndex(iArr, groupIndexToAddress(i3 + groupSize(i3))), this);
    }

    public final String groupsAsString() {
        StringBuilder sb5 = new StringBuilder();
        int size$runtime_release = getSize$runtime_release();
        for (int i3 = 0; i3 < size$runtime_release; i3++) {
            groupAsString(sb5, i3);
            sb5.append('\n');
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        return sb6;
    }

    public final boolean indexInCurrentGroup(int index) {
        return indexInGroup(index, this.currentGroup);
    }

    public final boolean indexInGroup(int index, int group) {
        int capacity;
        int groupSize;
        if (group == this.parent) {
            capacity = this.currentGroupEnd;
        } else {
            if (group > this.startStack.peekOr(0)) {
                groupSize = groupSize(group);
            } else {
                int indexOf = this.startStack.indexOf(group);
                if (indexOf < 0) {
                    groupSize = groupSize(group);
                } else {
                    capacity = (getCapacity() - this.groupGapLen) - this.endStack.peek(indexOf);
                }
            }
            capacity = groupSize + group;
        }
        return index > group && index < capacity;
    }

    public final boolean indexInParent(int index) {
        int i3 = this.parent;
        return (index > i3 && index < this.currentGroupEnd) || (i3 == 0 && index == 0);
    }

    public final void insertAux(Object value) {
        boolean hasAux;
        if (this.insertCount >= 0) {
            int i3 = this.parent;
            int groupIndexToAddress = groupIndexToAddress(i3);
            hasAux = SlotTableKt.hasAux(this.groups, groupIndexToAddress);
            if (!hasAux) {
                insertSlots(1, i3);
                int auxIndex = auxIndex(this.groups, groupIndexToAddress);
                int dataIndexToDataAddress = dataIndexToDataAddress(auxIndex);
                int i16 = this.currentSlot;
                if (i16 > auxIndex) {
                    int i17 = i16 - auxIndex;
                    if (i17 < 3) {
                        if (i17 > 1) {
                            Object[] objArr = this.slots;
                            objArr[dataIndexToDataAddress + 2] = objArr[dataIndexToDataAddress + 1];
                        }
                        Object[] objArr2 = this.slots;
                        objArr2[dataIndexToDataAddress + 1] = objArr2[dataIndexToDataAddress];
                    } else {
                        throw new IllegalStateException("Moving more than two slot not supported".toString());
                    }
                }
                SlotTableKt.addAux(this.groups, groupIndexToAddress);
                this.slots[dataIndexToDataAddress] = value;
                this.currentSlot++;
                return;
            }
            ComposerKt.composeRuntimeError("Group already has auxiliary data".toString());
            throw new KotlinNothingValueException();
        }
        ComposerKt.composeRuntimeError("Cannot insert auxiliary data when not inserting".toString());
        throw new KotlinNothingValueException();
    }

    public final boolean isGroupEnd() {
        return this.currentGroup == this.currentGroupEnd;
    }

    public final boolean isNode() {
        boolean isNode;
        int i3 = this.currentGroup;
        if (i3 < this.currentGroupEnd) {
            isNode = SlotTableKt.isNode(this.groups, groupIndexToAddress(i3));
            if (isNode) {
                return true;
            }
        }
        return false;
    }

    public final void markGroup(int group) {
        boolean hasMark;
        boolean containsMark;
        int groupIndexToAddress = groupIndexToAddress(group);
        hasMark = SlotTableKt.hasMark(this.groups, groupIndexToAddress);
        if (hasMark) {
            return;
        }
        SlotTableKt.updateMark(this.groups, groupIndexToAddress, true);
        containsMark = SlotTableKt.containsMark(this.groups, groupIndexToAddress);
        if (containsMark) {
            return;
        }
        updateContainsMark(parent(group));
    }

    public final List<Anchor> moveFrom(SlotTable table, int index) {
        Intrinsics.checkNotNullParameter(table, "table");
        if (this.insertCount > 0) {
            if (index == 0 && this.currentGroup == 0 && this.table.getGroupsSize() == 0) {
                int[] iArr = this.groups;
                Object[] objArr = this.slots;
                ArrayList<Anchor> arrayList = this.anchors;
                int[] groups = table.getGroups();
                int groupsSize = table.getGroupsSize();
                Object[] slots = table.getSlots();
                int slotsSize = table.getSlotsSize();
                this.groups = groups;
                this.slots = slots;
                this.anchors = table.getAnchors$runtime_release();
                this.groupGapStart = groupsSize;
                this.groupGapLen = (groups.length / 5) - groupsSize;
                this.slotsGapStart = slotsSize;
                this.slotsGapLen = slots.length - slotsSize;
                this.slotsGapOwner = groupsSize;
                table.setTo$runtime_release(iArr, 0, objArr, 0, arrayList);
                return this.anchors;
            }
            SlotWriter openWriter = table.openWriter();
            try {
                return INSTANCE.moveGroup(openWriter, index, this, true, true);
            } finally {
                openWriter.close();
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if (groupSize(r9.currentGroup + r10) == 1) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<Anchor> moveIntoGroupFrom(int offset, SlotTable table, int index) {
        Intrinsics.checkNotNullParameter(table, "table");
        boolean z16 = this.insertCount <= 0;
        ComposerKt.runtimeCheck(z16);
        int i3 = this.currentGroup;
        int i16 = this.currentSlot;
        int i17 = this.currentSlotEnd;
        advanceBy(offset);
        startGroup();
        beginInsert();
        SlotWriter openWriter = table.openWriter();
        try {
            List<Anchor> moveGroup = INSTANCE.moveGroup(openWriter, index, this, false, true);
            openWriter.close();
            endInsert();
            endGroup();
            this.currentGroup = i3;
            this.currentSlot = i16;
            this.currentSlotEnd = i17;
            return moveGroup;
        } catch (Throwable th5) {
            openWriter.close();
            throw th5;
        }
    }

    public final List<Anchor> moveTo(Anchor anchor, int offset, SlotWriter writer) {
        int groupSize;
        boolean isNode;
        int nodeCount;
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (writer.insertCount > 0) {
            if (this.insertCount == 0) {
                if (anchor.getValid()) {
                    int anchorIndex = anchorIndex(anchor) + offset;
                    int i3 = this.currentGroup;
                    if (i3 <= anchorIndex && anchorIndex < this.currentGroupEnd) {
                        int parent = parent(anchorIndex);
                        int groupSize2 = groupSize(anchorIndex);
                        int nodeCount2 = isNode(anchorIndex) ? 1 : nodeCount(anchorIndex);
                        List<Anchor> moveGroup = INSTANCE.moveGroup(this, anchorIndex, writer, false, false);
                        updateContainsMark(parent);
                        boolean z16 = nodeCount2 > 0;
                        while (parent >= i3) {
                            int groupIndexToAddress = groupIndexToAddress(parent);
                            int[] iArr = this.groups;
                            groupSize = SlotTableKt.groupSize(iArr, groupIndexToAddress);
                            SlotTableKt.updateGroupSize(iArr, groupIndexToAddress, groupSize - groupSize2);
                            if (z16) {
                                isNode = SlotTableKt.isNode(this.groups, groupIndexToAddress);
                                if (isNode) {
                                    z16 = false;
                                } else {
                                    int[] iArr2 = this.groups;
                                    nodeCount = SlotTableKt.nodeCount(iArr2, groupIndexToAddress);
                                    SlotTableKt.updateNodeCount(iArr2, groupIndexToAddress, nodeCount - nodeCount2);
                                }
                            }
                            parent = parent(parent);
                        }
                        if (z16) {
                            ComposerKt.runtimeCheck(this.nodeCount >= nodeCount2);
                            this.nodeCount -= nodeCount2;
                        }
                        return moveGroup;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final Object node(int index) {
        boolean isNode;
        int groupIndexToAddress = groupIndexToAddress(index);
        isNode = SlotTableKt.isNode(this.groups, groupIndexToAddress);
        if (isNode) {
            return this.slots[dataIndexToDataAddress(nodeIndex(this.groups, groupIndexToAddress))];
        }
        return null;
    }

    public final int nodeCount(int index) {
        int nodeCount;
        nodeCount = SlotTableKt.nodeCount(this.groups, groupIndexToAddress(index));
        return nodeCount;
    }

    public final int parent(int index) {
        return parent(this.groups, index);
    }

    public final boolean removeGroup() {
        if (this.insertCount == 0) {
            int i3 = this.currentGroup;
            int i16 = this.currentSlot;
            int skipGroup = skipGroup();
            PrioritySet prioritySet = this.pendingRecalculateMarks;
            if (prioritySet != null) {
                while (prioritySet.isNotEmpty() && prioritySet.peek() >= i3) {
                    prioritySet.takeMax();
                }
            }
            boolean removeGroups = removeGroups(i3, this.currentGroup - i3);
            removeSlots(i16, this.currentSlot - i16, i3 - 1);
            this.currentGroup = i3;
            this.currentSlot = i16;
            this.nodeCount -= skipGroup;
            return removeGroups;
        }
        throw new IllegalArgumentException("Cannot remove group while inserting".toString());
    }

    public final void reset() {
        if (this.insertCount == 0) {
            recalculateMarks();
            this.currentGroup = 0;
            this.currentGroupEnd = getCapacity() - this.groupGapLen;
            this.currentSlot = 0;
            this.currentSlotEnd = 0;
            this.nodeCount = 0;
            return;
        }
        ComposerKt.composeRuntimeError("Cannot reset when inserting".toString());
        throw new KotlinNothingValueException();
    }

    public final void seek(Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        advanceBy(anchor.toIndexFor(this) - this.currentGroup);
    }

    public final void set(Object value) {
        int i3 = this.currentSlot;
        if (i3 <= this.currentSlotEnd) {
            this.slots[dataIndexToDataAddress(i3 - 1)] = value;
        } else {
            ComposerKt.composeRuntimeError("Writing to an invalid slot".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final Object skip() {
        if (this.insertCount > 0) {
            insertSlots(1, this.parent);
        }
        Object[] objArr = this.slots;
        int i3 = this.currentSlot;
        this.currentSlot = i3 + 1;
        return objArr[dataIndexToDataAddress(i3)];
    }

    public final int skipGroup() {
        int groupSize;
        boolean isNode;
        int nodeCount;
        int groupIndexToAddress = groupIndexToAddress(this.currentGroup);
        int i3 = this.currentGroup;
        groupSize = SlotTableKt.groupSize(this.groups, groupIndexToAddress);
        int i16 = i3 + groupSize;
        this.currentGroup = i16;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(i16));
        isNode = SlotTableKt.isNode(this.groups, groupIndexToAddress);
        if (isNode) {
            return 1;
        }
        nodeCount = SlotTableKt.nodeCount(this.groups, groupIndexToAddress);
        return nodeCount;
    }

    public final void skipToGroupEnd() {
        int i3 = this.currentGroupEnd;
        this.currentGroup = i3;
        this.currentSlot = dataIndex(this.groups, groupIndexToAddress(i3));
    }

    public final Object slot(Anchor anchor, int index) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return slot(anchorIndex(anchor), index);
    }

    public final void startData(int key, Object objectKey, Object aux) {
        startGroup(key, objectKey, false, aux);
    }

    public final void startGroup() {
        if (this.insertCount == 0) {
            Composer.Companion companion = Composer.INSTANCE;
            startGroup(0, companion.getEmpty(), false, companion.getEmpty());
            return;
        }
        throw new IllegalArgumentException("Key must be supplied when inserting".toString());
    }

    public final void startNode(Object key) {
        startGroup(125, key, true, Composer.INSTANCE.getEmpty());
    }

    public String toString() {
        return "SlotWriter(current = " + this.currentGroup + " end=" + this.currentGroupEnd + " size = " + getSize$runtime_release() + " gap=" + this.groupGapStart + '-' + (this.groupGapStart + this.groupGapLen) + ')';
    }

    public final Object update(Object value) {
        Object skip = skip();
        set(value);
        return skip;
    }

    public final void updateAux(Object value) {
        boolean hasAux;
        int groupIndexToAddress = groupIndexToAddress(this.currentGroup);
        hasAux = SlotTableKt.hasAux(this.groups, groupIndexToAddress);
        if (hasAux) {
            this.slots[dataIndexToDataAddress(auxIndex(this.groups, groupIndexToAddress))] = value;
        } else {
            ComposerKt.composeRuntimeError("Updating the data of a group that was not created with a data slot".toString());
            throw new KotlinNothingValueException();
        }
    }

    public final void updateNode(Object value) {
        updateNodeOfGroup(this.currentGroup, value);
    }

    public final void updateParentNode(Object value) {
        updateNodeOfGroup(this.parent, value);
    }

    public final void verifyDataAnchors$runtime_release() {
        int dataAnchor;
        int i3 = this.slotsGapOwner;
        int length = this.slots.length - this.slotsGapLen;
        int size$runtime_release = getSize$runtime_release();
        int i16 = 0;
        int i17 = 0;
        boolean z16 = false;
        while (i16 < size$runtime_release) {
            int groupIndexToAddress = groupIndexToAddress(i16);
            dataAnchor = SlotTableKt.dataAnchor(this.groups, groupIndexToAddress);
            int dataIndex = dataIndex(this.groups, groupIndexToAddress);
            if (!(dataIndex >= i17)) {
                throw new IllegalStateException(("Data index out of order at " + i16 + ", previous = " + i17 + ", current = " + dataIndex).toString());
            }
            if (!(dataIndex <= length)) {
                throw new IllegalStateException(("Data index, " + dataIndex + ", out of bound at " + i16).toString());
            }
            if (dataAnchor < 0 && !z16) {
                if (!(i3 == i16)) {
                    throw new IllegalStateException(("Expected the slot gap owner to be " + i3 + " found gap at " + i16).toString());
                }
                z16 = true;
            }
            i16++;
            i17 = dataIndex;
        }
    }

    public final void verifyParentAnchors$runtime_release() {
        int parentAnchor;
        int parentAnchor2;
        int i3 = this.groupGapStart;
        int i16 = this.groupGapLen;
        int capacity = getCapacity();
        int i17 = 0;
        while (true) {
            if (i17 >= i3) {
                for (int i18 = i16 + i3; i18 < capacity; i18++) {
                    parentAnchor = SlotTableKt.parentAnchor(this.groups, i18);
                    if (parentAnchorToIndex(parentAnchor) < i3) {
                        if (!(parentAnchor > -2)) {
                            throw new IllegalStateException(("Expected a start relative anchor at " + i18).toString());
                        }
                    } else {
                        if (!(parentAnchor <= -2)) {
                            throw new IllegalStateException(("Expected an end relative anchor at " + i18).toString());
                        }
                    }
                }
                return;
            }
            parentAnchor2 = SlotTableKt.parentAnchor(this.groups, i17);
            if (!(parentAnchor2 > -2)) {
                throw new IllegalStateException(("Expected a start relative anchor at " + i17).toString());
            }
            i17++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int dataIndex(int[] iArr, int i3) {
        int dataAnchor;
        if (i3 >= getCapacity()) {
            return this.slots.length - this.slotsGapLen;
        }
        dataAnchor = SlotTableKt.dataAnchor(iArr, i3);
        return dataAnchorToDataIndex(dataAnchor, this.slotsGapLen, this.slots.length);
    }

    private final void moveAnchors(int originalLocation, int newLocation, int size) {
        int locationOf;
        int locationOf2;
        int i3 = size + originalLocation;
        int size$runtime_release = getSize$runtime_release();
        locationOf = SlotTableKt.locationOf(this.anchors, originalLocation, size$runtime_release);
        ArrayList arrayList = new ArrayList();
        if (locationOf >= 0) {
            while (locationOf < this.anchors.size()) {
                Anchor anchor = this.anchors.get(locationOf);
                Intrinsics.checkNotNullExpressionValue(anchor, "anchors[index]");
                Anchor anchor2 = anchor;
                int anchorIndex = anchorIndex(anchor2);
                if (anchorIndex < originalLocation || anchorIndex >= i3) {
                    break;
                }
                arrayList.add(anchor2);
                this.anchors.remove(locationOf);
            }
        }
        int i16 = newLocation - originalLocation;
        int size2 = arrayList.size();
        for (int i17 = 0; i17 < size2; i17++) {
            Anchor anchor3 = (Anchor) arrayList.get(i17);
            int anchorIndex2 = anchorIndex(anchor3) + i16;
            if (anchorIndex2 >= this.groupGapStart) {
                anchor3.setLocation$runtime_release(-(size$runtime_release - anchorIndex2));
            } else {
                anchor3.setLocation$runtime_release(anchorIndex2);
            }
            locationOf2 = SlotTableKt.locationOf(this.anchors, anchorIndex2, size$runtime_release);
            this.anchors.add(locationOf2, anchor3);
        }
    }

    public final void close() {
        this.closed = true;
        if (this.startStack.isEmpty()) {
            moveGroupGapTo(getSize$runtime_release());
            moveSlotGapTo(this.slots.length - this.slotsGapLen, this.groupGapStart);
            recalculateMarks();
        }
        this.table.close$runtime_release(this, this.groups, this.groupGapStart, this.slots, this.slotsGapStart, this.anchors);
    }

    public final boolean isNode(int index) {
        boolean isNode;
        isNode = SlotTableKt.isNode(this.groups, groupIndexToAddress(index));
        return isNode;
    }

    public final int parent(Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (anchor.getValid()) {
            return parent(this.groups, anchorIndex(anchor));
        }
        return -1;
    }

    public final Object slot(int groupIndex, int index) {
        int slotIndex = slotIndex(this.groups, groupIndexToAddress(groupIndex));
        int i3 = index + slotIndex;
        if (!(slotIndex <= i3 && i3 < dataIndex(this.groups, groupIndexToAddress(groupIndex + 1)))) {
            return Composer.INSTANCE.getEmpty();
        }
        return this.slots[dataIndexToDataAddress(i3)];
    }

    public final void startData(int key, Object aux) {
        startGroup(key, Composer.INSTANCE.getEmpty(), false, aux);
    }

    public final void startNode(Object key, Object node) {
        startGroup(125, key, true, node);
    }

    public final void updateNode(Anchor anchor, Object value) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        updateNodeOfGroup(anchor.toIndexFor(this), value);
    }

    private final boolean childContainsAnyMarks(int group) {
        boolean containsAnyMark;
        int i3 = group + 1;
        int groupSize = group + groupSize(group);
        while (i3 < groupSize) {
            containsAnyMark = SlotTableKt.containsAnyMark(this.groups, groupIndexToAddress(i3));
            if (containsAnyMark) {
                return true;
            }
            i3 += groupSize(i3);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean containsAnyGroupMarks(int group) {
        boolean containsAnyMark;
        if (group >= 0) {
            containsAnyMark = SlotTableKt.containsAnyMark(this.groups, groupIndexToAddress(group));
            if (containsAnyMark) {
                return true;
            }
        }
        return false;
    }

    private final boolean containsGroupMark(int group) {
        boolean containsMark;
        if (group >= 0) {
            containsMark = SlotTableKt.containsMark(this.groups, groupIndexToAddress(group));
            if (containsMark) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void insertGroups(int size) {
        if (size > 0) {
            int i3 = this.currentGroup;
            moveGroupGapTo(i3);
            int i16 = this.groupGapStart;
            int i17 = this.groupGapLen;
            int[] iArr = this.groups;
            int length = iArr.length / 5;
            int i18 = length - i17;
            if (i17 < size) {
                int max = Math.max(Math.max(length * 2, i18 + size), 32);
                int[] iArr2 = new int[max * 5];
                int i19 = max - i18;
                ArraysKt___ArraysJvmKt.copyInto(iArr, iArr2, 0, 0, i16 * 5);
                ArraysKt___ArraysJvmKt.copyInto(iArr, iArr2, (i16 + i19) * 5, (i17 + i16) * 5, length * 5);
                this.groups = iArr2;
                i17 = i19;
            }
            int i26 = this.currentGroupEnd;
            if (i26 >= i16) {
                this.currentGroupEnd = i26 + size;
            }
            int i27 = i16 + size;
            this.groupGapStart = i27;
            this.groupGapLen = i17 - size;
            int dataIndexToDataAnchor = dataIndexToDataAnchor(i18 > 0 ? dataIndex(i3 + size) : 0, this.slotsGapOwner >= i16 ? this.slotsGapStart : 0, this.slotsGapLen, this.slots.length);
            for (int i28 = i16; i28 < i27; i28++) {
                SlotTableKt.updateDataAnchor(this.groups, i28, dataIndexToDataAnchor);
            }
            int i29 = this.slotsGapOwner;
            if (i29 >= i16) {
                this.slotsGapOwner = i29 + size;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void insertSlots(int size, int group) {
        if (size > 0) {
            moveSlotGapTo(this.currentSlot, group);
            int i3 = this.slotsGapStart;
            int i16 = this.slotsGapLen;
            if (i16 < size) {
                Object[] objArr = this.slots;
                int length = objArr.length;
                int i17 = length - i16;
                int max = Math.max(Math.max(length * 2, i17 + size), 32);
                Object[] objArr2 = new Object[max];
                for (int i18 = 0; i18 < max; i18++) {
                    objArr2[i18] = null;
                }
                int i19 = max - i17;
                int i26 = i16 + i3;
                ArraysKt___ArraysJvmKt.copyInto(objArr, objArr2, 0, 0, i3);
                ArraysKt___ArraysJvmKt.copyInto(objArr, objArr2, i3 + i19, i26, length);
                this.slots = objArr2;
                i16 = i19;
            }
            int i27 = this.currentSlotEnd;
            if (i27 >= i3) {
                this.currentSlotEnd = i27 + size;
            }
            this.slotsGapStart = i3 + size;
            this.slotsGapLen = i16 - size;
        }
    }

    private final int parent(int[] iArr, int i3) {
        int parentAnchor;
        parentAnchor = SlotTableKt.parentAnchor(iArr, groupIndexToAddress(i3));
        return parentAnchorToIndex(parentAnchor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeSlots(int start, int len, int group) {
        if (len > 0) {
            int i3 = this.slotsGapLen;
            int i16 = start + len;
            moveSlotGapTo(i16, group);
            this.slotsGapStart = start;
            this.slotsGapLen = i3 + len;
            ArraysKt___ArraysJvmKt.fill(this.slots, (Object) null, start, i16);
            int i17 = this.currentSlotEnd;
            if (i17 >= start) {
                this.currentSlotEnd = i17 - len;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateContainsMark(int group) {
        if (group >= 0) {
            PrioritySet prioritySet = this.pendingRecalculateMarks;
            if (prioritySet == null) {
                prioritySet = new PrioritySet(null, 1, 0 == true ? 1 : 0);
                this.pendingRecalculateMarks = prioritySet;
            }
            prioritySet.add(group);
        }
    }

    public final void addToGroupSizeAlongSpine(int address, int amount) {
        int groupSize;
        int parentAnchor;
        while (address > 0) {
            int[] iArr = this.groups;
            groupSize = SlotTableKt.groupSize(iArr, address);
            SlotTableKt.updateGroupSize(iArr, address, groupSize + amount);
            parentAnchor = SlotTableKt.parentAnchor(this.groups, address);
            address = groupIndexToAddress(parentAnchorToIndex(parentAnchor));
        }
    }

    public final void insertParentGroup(int key) {
        int dataAnchor;
        int nodeCount;
        int groupSize;
        int i3 = 0;
        if (this.insertCount == 0) {
            if (isGroupEnd()) {
                beginInsert();
                startGroup(key);
                endGroup();
                endInsert();
                return;
            }
            int i16 = this.currentGroup;
            int parent = parent(this.groups, i16);
            int groupSize2 = parent + groupSize(parent);
            int i17 = groupSize2 - i16;
            int i18 = i16;
            while (i18 < groupSize2) {
                int groupIndexToAddress = groupIndexToAddress(i18);
                nodeCount = SlotTableKt.nodeCount(this.groups, groupIndexToAddress);
                i3 += nodeCount;
                groupSize = SlotTableKt.groupSize(this.groups, groupIndexToAddress);
                i18 += groupSize;
            }
            dataAnchor = SlotTableKt.dataAnchor(this.groups, groupIndexToAddress(i16));
            beginInsert();
            insertGroups(1);
            endInsert();
            int groupIndexToAddress2 = groupIndexToAddress(i16);
            SlotTableKt.initGroup(this.groups, groupIndexToAddress2, key, false, false, false, parent, dataAnchor);
            SlotTableKt.updateGroupSize(this.groups, groupIndexToAddress2, i17 + 1);
            SlotTableKt.updateNodeCount(this.groups, groupIndexToAddress2, i3);
            addToGroupSizeAlongSpine(groupIndexToAddress(parent), 1);
            fixParentAnchorsFor(parent, groupSize2, i16);
            this.currentGroup = groupSize2;
            return;
        }
        ComposerKt.composeRuntimeError("Writer cannot be inserting".toString());
        throw new KotlinNothingValueException();
    }

    public final void moveGroup(int offset) {
        int groupSize;
        int groupSize2;
        if (!(this.insertCount == 0)) {
            throw new IllegalArgumentException("Cannot move a group while inserting".toString());
        }
        if (!(offset >= 0)) {
            throw new IllegalArgumentException("Parameter offset is out of bounds".toString());
        }
        if (offset == 0) {
            return;
        }
        int i3 = this.currentGroup;
        int i16 = this.parent;
        int i17 = this.currentGroupEnd;
        int i18 = i3;
        for (int i19 = offset; i19 > 0; i19--) {
            groupSize2 = SlotTableKt.groupSize(this.groups, groupIndexToAddress(i18));
            i18 += groupSize2;
            if (!(i18 <= i17)) {
                throw new IllegalArgumentException("Parameter offset is out of bounds".toString());
            }
        }
        groupSize = SlotTableKt.groupSize(this.groups, groupIndexToAddress(i18));
        int i26 = this.currentSlot;
        int dataIndex = dataIndex(this.groups, groupIndexToAddress(i18));
        int i27 = i18 + groupSize;
        int dataIndex2 = dataIndex(this.groups, groupIndexToAddress(i27));
        int i28 = dataIndex2 - dataIndex;
        insertSlots(i28, Math.max(this.currentGroup - 1, 0));
        insertGroups(groupSize);
        int[] iArr = this.groups;
        int groupIndexToAddress = groupIndexToAddress(i27) * 5;
        ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, groupIndexToAddress(i3) * 5, groupIndexToAddress, (groupSize * 5) + groupIndexToAddress);
        if (i28 > 0) {
            Object[] objArr = this.slots;
            ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i26, dataIndexToDataAddress(dataIndex + i28), dataIndexToDataAddress(dataIndex2 + i28));
        }
        int i29 = dataIndex + i28;
        int i36 = i29 - i26;
        int i37 = this.slotsGapStart;
        int i38 = this.slotsGapLen;
        int length = this.slots.length;
        int i39 = this.slotsGapOwner;
        int i46 = i3 + groupSize;
        int i47 = i3;
        while (i47 < i46) {
            int groupIndexToAddress2 = groupIndexToAddress(i47);
            int i48 = i37;
            int i49 = i36;
            updateDataIndex(iArr, groupIndexToAddress2, dataIndexToDataAnchor(dataIndex(iArr, groupIndexToAddress2) - i36, i39 < groupIndexToAddress2 ? 0 : i48, i38, length));
            i47++;
            i37 = i48;
            i36 = i49;
        }
        moveAnchors(i27, i3, groupSize);
        if (!removeGroups(i27, groupSize)) {
            fixParentAnchorsFor(i16, this.currentGroupEnd, i3);
            if (i28 > 0) {
                removeSlots(i29, i28, i27 - 1);
                return;
            }
            return;
        }
        ComposerKt.composeRuntimeError("Unexpectedly removed anchors".toString());
        throw new KotlinNothingValueException();
    }

    private final int parentIndexToAnchor(int index, int gapStart) {
        return index < gapStart ? index : -((getSize$runtime_release() - index) + 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean removeGroups(int start, int len) {
        if (len > 0) {
            ArrayList<Anchor> arrayList = this.anchors;
            moveGroupGapTo(start);
            r0 = arrayList.isEmpty() ^ true ? removeAnchors(start, len) : false;
            this.groupGapStart = start;
            this.groupGapLen += len;
            int i3 = this.slotsGapOwner;
            if (i3 > start) {
                this.slotsGapOwner = Math.max(start, i3 - len);
            }
            int i16 = this.currentGroupEnd;
            if (i16 >= this.groupGapStart) {
                this.currentGroupEnd = i16 - len;
            }
            if (containsGroupMark(this.parent)) {
                updateContainsMark(this.parent);
            }
        }
        return r0;
    }

    public final Object node(Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return node(anchor.toIndexFor(this));
    }

    public final Object set(int index, Object value) {
        int slotIndex = slotIndex(this.groups, groupIndexToAddress(this.currentGroup));
        int i3 = slotIndex + index;
        if (i3 >= slotIndex && i3 < dataIndex(this.groups, groupIndexToAddress(this.currentGroup + 1))) {
            int dataIndexToDataAddress = dataIndexToDataAddress(i3);
            Object[] objArr = this.slots;
            Object obj = objArr[dataIndexToDataAddress];
            objArr[dataIndexToDataAddress] = value;
            return obj;
        }
        ComposerKt.composeRuntimeError(("Write to an invalid slot index " + index + " for group " + this.currentGroup).toString());
        throw new KotlinNothingValueException();
    }

    public final void startGroup(int key) {
        Composer.Companion companion = Composer.INSTANCE;
        startGroup(key, companion.getEmpty(), false, companion.getEmpty());
    }

    public static /* synthetic */ Anchor anchor$default(SlotWriter slotWriter, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = slotWriter.currentGroup;
        }
        return slotWriter.anchor(i3);
    }

    public static /* synthetic */ void markGroup$default(SlotWriter slotWriter, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = slotWriter.parent;
        }
        slotWriter.markGroup(i3);
    }

    private final int parentAnchorToIndex(int index) {
        return index > -2 ? index : getSize$runtime_release() + index + 2;
    }

    public final void startGroup(int key, Object dataKey) {
        startGroup(key, dataKey, false, Composer.INSTANCE.getEmpty());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void startGroup(int key, Object objectKey, boolean isNode, Object aux) {
        int nodeCount;
        int groupSize;
        int i3;
        byte b16 = this.insertCount > 0;
        this.nodeCountStack.push(this.nodeCount);
        if (b16 != false) {
            insertGroups(1);
            int i16 = this.currentGroup;
            int groupIndexToAddress = groupIndexToAddress(i16);
            Composer.Companion companion = Composer.INSTANCE;
            int i17 = objectKey != companion.getEmpty() ? 1 : 0;
            int i18 = (isNode || aux == companion.getEmpty()) ? 0 : 1;
            SlotTableKt.initGroup(this.groups, groupIndexToAddress, key, isNode, i17, i18, this.parent, this.currentSlot);
            this.currentSlotEnd = this.currentSlot;
            int i19 = (isNode ? 1 : 0) + i17 + i18;
            if (i19 > 0) {
                insertSlots(i19, i16);
                Object[] objArr = this.slots;
                int i26 = this.currentSlot;
                if (isNode) {
                    objArr[i26] = aux;
                    i26++;
                }
                if (i17 != 0) {
                    objArr[i26] = objectKey;
                    i26++;
                }
                if (i18 != 0) {
                    objArr[i26] = aux;
                    i26++;
                }
                this.currentSlot = i26;
            }
            this.nodeCount = 0;
            i3 = i16 + 1;
            this.parent = i16;
            this.currentGroup = i3;
        } else {
            this.startStack.push(this.parent);
            saveCurrentGroupEnd();
            int i27 = this.currentGroup;
            int groupIndexToAddress2 = groupIndexToAddress(i27);
            if (!Intrinsics.areEqual(aux, Composer.INSTANCE.getEmpty())) {
                if (isNode) {
                    updateNode(aux);
                } else {
                    updateAux(aux);
                }
            }
            this.currentSlot = slotIndex(this.groups, groupIndexToAddress2);
            this.currentSlotEnd = dataIndex(this.groups, groupIndexToAddress(this.currentGroup + 1));
            nodeCount = SlotTableKt.nodeCount(this.groups, groupIndexToAddress2);
            this.nodeCount = nodeCount;
            this.parent = i27;
            this.currentGroup = i27 + 1;
            groupSize = SlotTableKt.groupSize(this.groups, groupIndexToAddress2);
            i3 = i27 + groupSize;
        }
        this.currentGroupEnd = i3;
    }

    public final void advanceBy(int amount) {
        if (amount >= 0) {
            if (!(this.insertCount <= 0)) {
                throw new IllegalStateException("Cannot call seek() while inserting".toString());
            }
            if (amount == 0) {
                return;
            }
            int i3 = this.currentGroup + amount;
            if (i3 >= this.parent && i3 <= this.currentGroupEnd) {
                this.currentGroup = i3;
                int dataIndex = dataIndex(this.groups, groupIndexToAddress(i3));
                this.currentSlot = dataIndex;
                this.currentSlotEnd = dataIndex;
                return;
            }
            ComposerKt.composeRuntimeError(("Cannot seek outside the current group (" + this.parent + '-' + this.currentGroupEnd + ')').toString());
            throw new KotlinNothingValueException();
        }
        throw new IllegalArgumentException("Cannot seek backwards".toString());
    }

    public final void ensureStarted(Anchor anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        ensureStarted(anchor.toIndexFor(this));
    }
}
