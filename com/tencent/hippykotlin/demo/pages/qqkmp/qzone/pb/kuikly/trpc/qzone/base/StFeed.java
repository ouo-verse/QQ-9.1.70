package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0083\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\u000e\b\u0002\u00100\u001a\b\u0012\u0004\u0012\u00020#0/\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000102\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u000108\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010;\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010A\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010G\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010J\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010M\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010P\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010S\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010V\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010Y\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\\\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010_\u0012\n\b\u0002\u0010c\u001a\u0004\u0018\u00010b\u0012\u000e\b\u0002\u0010e\u001a\b\u0012\u0004\u0012\u00020M0/\u00a2\u0006\u0004\bk\u0010lJ\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020#0/8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00103\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00106\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u00109\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010<\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010?\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010H\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010K\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010N\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010Q\u001a\u0004\u0018\u00010P8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010T\u001a\u0004\u0018\u00010S8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010W\u001a\u0004\u0018\u00010V8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010Z\u001a\u0004\u0018\u00010Y8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010]\u001a\u0004\u0018\u00010\\8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010`\u001a\u0004\u0018\u00010_8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010c\u001a\u0004\u0018\u00010b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u001a\u0010e\u001a\b\u0012\u0004\u0012\u00020M0/8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\be\u00101R \u0010j\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020g0f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bh\u0010i\u00a8\u0006m"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeed;", "Lc45/j;", "Lc45/f;", "u", "decodeWith", "", "fieldNumber", "", "v", "", HippyTextInputController.COMMAND_setValue, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellCommon;", "cellCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellCommon;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellUserInfo;", "cellUserInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellUserInfo;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellTitle;", "cellTitle", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellTitle;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellSummary;", "cellSummary", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellSummary;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellMedia;", "cellMedia", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellMedia;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellLBS;", "cellLbs", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellLBS;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellComment;", "cellComment", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellComment;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellLike;", "cellLike", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellLike;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellBottomRecomm;", "cellBottomRecomm", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellBottomRecomm;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellSpaceInfo;", "cellSpaceInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellSpaceInfo;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellVisitor;", "cellVisitor", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellVisitor;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellQunInfo;", "cellQunInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellQunInfo;", "", "rptBottomRecomm", "Ljava/util/List;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellRemark;", "cellRemark", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellRemark;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellOrigin;", "cellOrigin", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellOrigin;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellShare;", "cellShare", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellShare;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellDeviceInfo;", "cellDeviceInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellDeviceInfo;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellUserDesc;", "cellUserDesc", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellUserDesc;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellMusic;", "cellMusic", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellMusic;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellForwardInfo;", "cellFowardInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellForwardInfo;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellPermission;", "cellPermission", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellPermission;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellSmallTail;", "cellSmallTail", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellSmallTail;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellBigTail;", "cellBigTail", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellBigTail;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellAdv;", "cellAdv", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellAdv;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellH5Jump;", "cellH5Jump", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellH5Jump;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellFeedDeco;", "cellFeedDeco", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellFeedDeco;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellLocalInfo;", "cellLocalInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellLocalInfo;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellSealOffMemory;", "cellMemory", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellSealOffMemory;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellOperation;", "cellOperation", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellOperation;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellRecommend;", "cellRecommend", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellRecommend;", "rptCellBigTail", "", "Lc45/h;", "getIndexes", "()Ljava/util/Map;", "indexes", "<init>", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellCommon;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellUserInfo;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellTitle;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellSummary;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellMedia;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellLBS;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellComment;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellLike;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellBottomRecomm;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellSpaceInfo;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellVisitor;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellQunInfo;Ljava/util/List;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellRemark;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellOrigin;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellShare;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellDeviceInfo;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellUserDesc;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellMusic;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellForwardInfo;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellPermission;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellSmallTail;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellBigTail;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellAdv;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellH5Jump;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellFeedDeco;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellLocalInfo;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellSealOffMemory;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellOperation;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellRecommend;Ljava/util/List;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class StFeed extends j {
    public StCellAdv cellAdv;
    public StCellBigTail cellBigTail;
    public StCellBottomRecomm cellBottomRecomm;
    public StFeedCellComment cellComment;
    public StFeedCellCommon cellCommon;
    public StCellDeviceInfo cellDeviceInfo;
    public StCellFeedDeco cellFeedDeco;
    public StCellForwardInfo cellFowardInfo;
    public StCellH5Jump cellH5Jump;
    public StFeedCellLBS cellLbs;
    public StFeedCellLike cellLike;
    public StCellLocalInfo cellLocalInfo;
    public StFeedCellMedia cellMedia;
    public StCellSealOffMemory cellMemory;
    public StCellMusic cellMusic;
    public StCellOperation cellOperation;
    public StCellOrigin cellOrigin;
    public StCellPermission cellPermission;
    public StFeedCellQunInfo cellQunInfo;
    public StCellRecommend cellRecommend;
    public StCellRemark cellRemark;
    public StCellShare cellShare;
    public StCellSmallTail cellSmallTail;
    public StFeedCellSpaceInfo cellSpaceInfo;
    public StFeedCellSummary cellSummary;
    public StFeedCellTitle cellTitle;
    public StCellUserDesc cellUserDesc;
    public StFeedCellUserInfo cellUserInfo;
    public StFeedCellVisitor cellVisitor;
    public final List<StCellBottomRecomm> rptBottomRecomm;
    public final List<StCellBigTail> rptCellBigTail;

    public StFeed() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.MAX_VALUE, null);
    }

    @Override // c45.j
    public j decodeWith(f u16) {
        return u16.g(new StFeed(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0 == true ? 1 : 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.MAX_VALUE, null));
    }

    public /* synthetic */ StFeed(StFeedCellCommon stFeedCellCommon, StFeedCellUserInfo stFeedCellUserInfo, StFeedCellTitle stFeedCellTitle, StFeedCellSummary stFeedCellSummary, StFeedCellMedia stFeedCellMedia, StFeedCellLBS stFeedCellLBS, StFeedCellComment stFeedCellComment, StFeedCellLike stFeedCellLike, StCellBottomRecomm stCellBottomRecomm, StFeedCellSpaceInfo stFeedCellSpaceInfo, StFeedCellVisitor stFeedCellVisitor, StFeedCellQunInfo stFeedCellQunInfo, List list, StCellRemark stCellRemark, StCellOrigin stCellOrigin, StCellShare stCellShare, StCellDeviceInfo stCellDeviceInfo, StCellUserDesc stCellUserDesc, StCellMusic stCellMusic, StCellForwardInfo stCellForwardInfo, StCellPermission stCellPermission, StCellSmallTail stCellSmallTail, StCellBigTail stCellBigTail, StCellAdv stCellAdv, StCellH5Jump stCellH5Jump, StCellFeedDeco stCellFeedDeco, StCellLocalInfo stCellLocalInfo, StCellSealOffMemory stCellSealOffMemory, StCellOperation stCellOperation, StCellRecommend stCellRecommend, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : stFeedCellCommon, (i3 & 2) != 0 ? null : stFeedCellUserInfo, (i3 & 4) != 0 ? null : stFeedCellTitle, (i3 & 8) != 0 ? null : stFeedCellSummary, (i3 & 16) != 0 ? null : stFeedCellMedia, (i3 & 32) != 0 ? null : stFeedCellLBS, (i3 & 64) != 0 ? null : stFeedCellComment, (i3 & 128) != 0 ? null : stFeedCellLike, (i3 & 256) != 0 ? null : stCellBottomRecomm, (i3 & 512) != 0 ? null : stFeedCellSpaceInfo, (i3 & 1024) != 0 ? null : stFeedCellVisitor, (i3 & 2048) != 0 ? null : stFeedCellQunInfo, (i3 & 4096) != 0 ? new ArrayList() : list, (i3 & 8192) != 0 ? null : stCellRemark, (i3 & 16384) != 0 ? null : stCellOrigin, (i3 & 32768) != 0 ? null : stCellShare, (i3 & 65536) != 0 ? null : stCellDeviceInfo, (i3 & 131072) != 0 ? null : stCellUserDesc, (i3 & 262144) != 0 ? null : stCellMusic, (i3 & 524288) != 0 ? null : stCellForwardInfo, (i3 & 1048576) != 0 ? null : stCellPermission, (i3 & 2097152) != 0 ? null : stCellSmallTail, (i3 & 4194304) != 0 ? null : stCellBigTail, (i3 & 8388608) != 0 ? null : stCellAdv, (i3 & 16777216) != 0 ? null : stCellH5Jump, (i3 & 33554432) != 0 ? null : stCellFeedDeco, (i3 & 67108864) != 0 ? null : stCellLocalInfo, (i3 & 134217728) != 0 ? null : stCellSealOffMemory, (i3 & 268435456) != 0 ? null : stCellOperation, (i3 & 536870912) != 0 ? null : stCellRecommend, (i3 & 1073741824) != 0 ? new ArrayList() : list2);
    }

    public StFeed(StFeedCellCommon stFeedCellCommon, StFeedCellUserInfo stFeedCellUserInfo, StFeedCellTitle stFeedCellTitle, StFeedCellSummary stFeedCellSummary, StFeedCellMedia stFeedCellMedia, StFeedCellLBS stFeedCellLBS, StFeedCellComment stFeedCellComment, StFeedCellLike stFeedCellLike, StCellBottomRecomm stCellBottomRecomm, StFeedCellSpaceInfo stFeedCellSpaceInfo, StFeedCellVisitor stFeedCellVisitor, StFeedCellQunInfo stFeedCellQunInfo, List<StCellBottomRecomm> list, StCellRemark stCellRemark, StCellOrigin stCellOrigin, StCellShare stCellShare, StCellDeviceInfo stCellDeviceInfo, StCellUserDesc stCellUserDesc, StCellMusic stCellMusic, StCellForwardInfo stCellForwardInfo, StCellPermission stCellPermission, StCellSmallTail stCellSmallTail, StCellBigTail stCellBigTail, StCellAdv stCellAdv, StCellH5Jump stCellH5Jump, StCellFeedDeco stCellFeedDeco, StCellLocalInfo stCellLocalInfo, StCellSealOffMemory stCellSealOffMemory, StCellOperation stCellOperation, StCellRecommend stCellRecommend, List<StCellBigTail> list2) {
        this.cellCommon = stFeedCellCommon;
        this.cellUserInfo = stFeedCellUserInfo;
        this.cellTitle = stFeedCellTitle;
        this.cellSummary = stFeedCellSummary;
        this.cellMedia = stFeedCellMedia;
        this.cellLbs = stFeedCellLBS;
        this.cellComment = stFeedCellComment;
        this.cellLike = stFeedCellLike;
        this.cellBottomRecomm = stCellBottomRecomm;
        this.cellSpaceInfo = stFeedCellSpaceInfo;
        this.cellVisitor = stFeedCellVisitor;
        this.cellQunInfo = stFeedCellQunInfo;
        this.rptBottomRecomm = list;
        this.cellRemark = stCellRemark;
        this.cellOrigin = stCellOrigin;
        this.cellShare = stCellShare;
        this.cellDeviceInfo = stCellDeviceInfo;
        this.cellUserDesc = stCellUserDesc;
        this.cellMusic = stCellMusic;
        this.cellFowardInfo = stCellForwardInfo;
        this.cellPermission = stCellPermission;
        this.cellSmallTail = stCellSmallTail;
        this.cellBigTail = stCellBigTail;
        this.cellAdv = stCellAdv;
        this.cellH5Jump = stCellH5Jump;
        this.cellFeedDeco = stCellFeedDeco;
        this.cellLocalInfo = stCellLocalInfo;
        this.cellMemory = stCellSealOffMemory;
        this.cellOperation = stCellOperation;
        this.cellRecommend = stCellRecommend;
        this.rptCellBigTail = list2;
    }

    @Override // c45.j
    public Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        int i3 = 1;
        int i16 = 3;
        int i17 = 63;
        DefaultConstructorMarker defaultConstructorMarker = null;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.cellCommon, new b.d(new StFeedCellCommon(null, null, null, null, null, null, null, 0 == true ? 1 : 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null)))), TuplesKt.to(2, new h(2, this.cellUserInfo, new b.d(new StFeedCellUserInfo(0 == true ? 1 : 0, i3, 0 == true ? 1 : 0)))), TuplesKt.to(3, new h(3, this.cellTitle, new b.d(new StFeedCellTitle(0 == true ? 1 : 0, 0 == true ? 1 : 0, i16, 0 == true ? 1 : 0)))), TuplesKt.to(4, new h(4, this.cellSummary, new b.d(new StFeedCellSummary(0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 7, 0 == true ? 1 : 0)))), TuplesKt.to(5, new h(5, this.cellMedia, new b.d(new StFeedCellMedia(0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 255, 0 == true ? 1 : 0)))), TuplesKt.to(6, new h(6, this.cellLbs, new b.d(new StFeedCellLBS(0 == true ? 1 : 0, 0 == true ? 1 : 0, i16, 0 == true ? 1 : 0)))), TuplesKt.to(7, new h(7, this.cellComment, new b.d(new StFeedCellComment(0 == true ? 1 : 0, 0 == true ? 1 : 0, i16, 0 == true ? 1 : 0)))), TuplesKt.to(8, new h(8, this.cellLike, new b.d(new StFeedCellLike(0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, null, 15, null)))), TuplesKt.to(9, new h(9, this.cellBottomRecomm, new b.d(new StCellBottomRecomm(null, null, null, null, 15, null)))), TuplesKt.to(10, new h(10, this.cellSpaceInfo, new b.d(new StFeedCellSpaceInfo(0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 7, null)))), TuplesKt.to(11, new h(11, this.cellVisitor, new b.d(new StFeedCellVisitor(0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, null, 15, null)))), TuplesKt.to(12, new h(12, this.cellQunInfo, new b.d(new StFeedCellQunInfo(0 == true ? 1 : 0, i3, 0 == true ? 1 : 0)))), TuplesKt.to(13, new h(13, this.rptBottomRecomm, new b.f(new b.d(new StCellBottomRecomm(null, null, null, null, 15, null)), false))), TuplesKt.to(14, new h(14, this.cellRemark, new b.d(new StCellRemark(null, null, null, null, 15, null)))), TuplesKt.to(15, new h(15, this.cellOrigin, new b.d(new StCellOrigin(0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, null, i17, defaultConstructorMarker)))), TuplesKt.to(16, new h(16, this.cellShare, new b.d(new StCellShare(0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, i17, defaultConstructorMarker)))), TuplesKt.to(17, new h(17, this.cellDeviceInfo, new b.d(new StCellDeviceInfo(null, null, null, 7, null)))), TuplesKt.to(18, new h(18, this.cellUserDesc, new b.d(new StCellUserDesc(null, null, null, 7, null)))), TuplesKt.to(19, new h(19, this.cellMusic, new b.d(new StCellMusic(null, null, null, 7, null)))), TuplesKt.to(20, new h(20, this.cellFowardInfo, new b.d(new StCellForwardInfo(0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 7, null)))), TuplesKt.to(21, new h(21, this.cellPermission, new b.d(new StCellPermission(0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, i17, defaultConstructorMarker)))), TuplesKt.to(22, new h(22, this.cellSmallTail, new b.d(new StCellSmallTail(null, null, null, null, 15, null)))), TuplesKt.to(23, new h(23, this.cellBigTail, new b.d(new StCellBigTail(null, null, null, null, null, 31, null)))), TuplesKt.to(24, new h(24, this.cellAdv, new b.d(new StCellAdv(null, null, 3, null)))), TuplesKt.to(25, new h(25, this.cellH5Jump, new b.d(new StCellH5Jump(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0)))), TuplesKt.to(26, new h(26, this.cellFeedDeco, new b.d(new StCellFeedDeco(0 == true ? 1 : 0, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0)))), TuplesKt.to(27, new h(27, this.cellLocalInfo, new b.d(new StCellLocalInfo(null, 1, null)))), TuplesKt.to(28, new h(28, this.cellMemory, new b.d(new StCellSealOffMemory(null, null, null, null, null, null, null, 127, null)))), TuplesKt.to(29, new h(29, this.cellOperation, new b.d(new StCellOperation(0 == true ? 1 : 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, 7, null)))), TuplesKt.to(30, new h(30, this.cellRecommend, new b.d(new StCellRecommend(0 == true ? 1 : 0, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0)))), TuplesKt.to(31, new h(31, this.rptCellBigTail, new b.f(new b.d(new StCellBigTail(null, null, null, null, null, 31, null)), false))));
        return mapOf;
    }

    @Override // c45.j
    public void setValue(int fieldNumber, Object v3) {
        switch (fieldNumber) {
            case 1:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellCommon");
                this.cellCommon = (StFeedCellCommon) v3;
                return;
            case 2:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellUserInfo");
                this.cellUserInfo = (StFeedCellUserInfo) v3;
                return;
            case 3:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellTitle");
                this.cellTitle = (StFeedCellTitle) v3;
                return;
            case 4:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellSummary");
                this.cellSummary = (StFeedCellSummary) v3;
                return;
            case 5:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellMedia");
                this.cellMedia = (StFeedCellMedia) v3;
                return;
            case 6:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellLBS");
                this.cellLbs = (StFeedCellLBS) v3;
                return;
            case 7:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellComment");
                this.cellComment = (StFeedCellComment) v3;
                return;
            case 8:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellLike");
                this.cellLike = (StFeedCellLike) v3;
                return;
            case 9:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellBottomRecomm");
                this.cellBottomRecomm = (StCellBottomRecomm) v3;
                return;
            case 10:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellSpaceInfo");
                this.cellSpaceInfo = (StFeedCellSpaceInfo) v3;
                return;
            case 11:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellVisitor");
                this.cellVisitor = (StFeedCellVisitor) v3;
                return;
            case 12:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellQunInfo");
                this.cellQunInfo = (StFeedCellQunInfo) v3;
                return;
            case 13:
                List<StCellBottomRecomm> list = this.rptBottomRecomm;
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellBottomRecomm>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) v3);
                return;
            case 14:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellRemark");
                this.cellRemark = (StCellRemark) v3;
                return;
            case 15:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellOrigin");
                this.cellOrigin = (StCellOrigin) v3;
                return;
            case 16:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellShare");
                this.cellShare = (StCellShare) v3;
                return;
            case 17:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellDeviceInfo");
                this.cellDeviceInfo = (StCellDeviceInfo) v3;
                return;
            case 18:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellUserDesc");
                this.cellUserDesc = (StCellUserDesc) v3;
                return;
            case 19:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellMusic");
                this.cellMusic = (StCellMusic) v3;
                return;
            case 20:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellForwardInfo");
                this.cellFowardInfo = (StCellForwardInfo) v3;
                return;
            case 21:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellPermission");
                this.cellPermission = (StCellPermission) v3;
                return;
            case 22:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellSmallTail");
                this.cellSmallTail = (StCellSmallTail) v3;
                return;
            case 23:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellBigTail");
                this.cellBigTail = (StCellBigTail) v3;
                return;
            case 24:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellAdv");
                this.cellAdv = (StCellAdv) v3;
                return;
            case 25:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellH5Jump");
                this.cellH5Jump = (StCellH5Jump) v3;
                return;
            case 26:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellFeedDeco");
                this.cellFeedDeco = (StCellFeedDeco) v3;
                return;
            case 27:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellLocalInfo");
                this.cellLocalInfo = (StCellLocalInfo) v3;
                return;
            case 28:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellSealOffMemory");
                this.cellMemory = (StCellSealOffMemory) v3;
                return;
            case 29:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellOperation");
                this.cellOperation = (StCellOperation) v3;
                return;
            case 30:
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellRecommend");
                this.cellRecommend = (StCellRecommend) v3;
                return;
            case 31:
                List<StCellBigTail> list2 = this.rptCellBigTail;
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.sequences.Sequence<com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellBigTail>");
                CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) v3);
                return;
            default:
                return;
        }
    }
}
