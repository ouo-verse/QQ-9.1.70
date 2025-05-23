package com.tencent.mobileqq.wink.editor.music;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditUIData;
import com.tencent.mobileqq.wink.editor.menu.MenuSwitchAction;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicMenuPartV2;
import com.tencent.mobileqq.wink.editor.music.adapter.WinkMusicListPageAdapter;
import com.tencent.mobileqq.wink.editor.music.event.WinkMusicLyricEvent;
import com.tencent.mobileqq.wink.editor.music.event.WinkMusicRetryRecommendRequestEvent;
import com.tencent.mobileqq.wink.editor.music.fragments.WinkMusicListFragment;
import com.tencent.mobileqq.wink.editor.music.ui.WinkMusicButton;
import com.tencent.mobileqq.wink.editor.music.view.WinkMusicTab;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import com.tencent.mobileqq.wink.editor.music.vo.Scene;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.editor.template.x;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.wink.tag.TagRetriever;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.session.ISessionListener;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tenpay.sdk.util.UinConfigManager;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u00d9\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u00da\u0001B\t\u00a2\u0006\u0006\b\u00d7\u0001\u0010\u00d8\u0001J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\u001e\u0010\u001c\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\rH\u0002J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\nH\u0002J\b\u0010\"\u001a\u00020\u0006H\u0002J\b\u0010#\u001a\u00020\u0006H\u0002J\b\u0010%\u001a\u00020$H\u0002J\b\u0010&\u001a\u00020\nH\u0002J\b\u0010'\u001a\u00020\u0006H\u0002J\u0010\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(H\u0002J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\rH\u0002J\u0010\u0010,\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(H\u0002J\b\u0010-\u001a\u00020\u0006H\u0002J\b\u0010.\u001a\u00020\u0006H\u0002J\b\u0010/\u001a\u00020\u0006H\u0002J\b\u00100\u001a\u00020\u0006H\u0002J \u00104\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0004H\u0002J\u0012\u00105\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u00106\u001a\u00020\u0004H\u0016J\b\u00108\u001a\u000207H\u0014J\b\u00109\u001a\u00020\u0006H\u0014J\b\u0010;\u001a\u00020:H\u0016J\b\u0010<\u001a\u00020\u0006H\u0016J\b\u0010=\u001a\u00020(H\u0016J\u001a\u0010B\u001a\u00020\u00062\u0006\u0010?\u001a\u00020>2\b\u0010A\u001a\u0004\u0018\u00010@H\u0016J\u0010\u0010C\u001a\u00020\u00062\u0006\u0010?\u001a\u00020>H\u0016J\u0010\u0010D\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u0012\u0010F\u001a\u00020\u00062\b\u0010E\u001a\u0004\u0018\u00010@H\u0016J\b\u0010G\u001a\u00020\u0006H\u0016J\u0010\u0010H\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\rH\u0015J\u0010\u0010I\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010J\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\nH\u0014J\b\u0010K\u001a\u00020\nH\u0016J\u0012\u0010L\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010M\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\rH\u0014J\u0012\u0010P\u001a\u00020\u00062\b\u0010O\u001a\u0004\u0018\u00010NH\u0016J$\u0010T\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0R0Qj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0R`SH\u0016J\b\u0010U\u001a\u00020\u0006H\u0016J\u0012\u0010X\u001a\u00020\u00062\b\u0010W\u001a\u0004\u0018\u00010VH\u0016J\u0010\u0010[\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020YH\u0016J\b\u0010\\\u001a\u00020\u0006H\u0016J\b\u0010]\u001a\u00020(H\u0016J\b\u0010^\u001a\u00020\nH\u0014J\b\u0010_\u001a\u00020\nH\u0014R\u0018\u0010c\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\be\u0010fR\"\u0010o\u001a\u00020h8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u0016\u0010s\u001a\u00020p8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010w\u001a\u00020t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010y\u001a\u00020p8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bx\u0010rR\u0016\u0010{\u001a\u00020t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bz\u0010vR&\u0010\u0083\u0001\u001a\u00020|8\u0004@\u0004X\u0084.\u00a2\u0006\u0015\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R(\u0010\u0089\u0001\u001a\u00020d8\u0006@\u0006X\u0086.\u00a2\u0006\u0017\n\u0005\b\u0084\u0001\u0010f\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0019\u0010\u008c\u0001\u001a\u00030\u008a\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b[\u0010\u008b\u0001R\u0018\u0010\u008e\u0001\u001a\u00020t8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u008d\u0001\u0010vR\u001a\u0010\u0090\u0001\u001a\u00030\u008a\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u008f\u0001\u0010\u008b\u0001R\u0018\u0010\u0092\u0001\u001a\u00020t8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0091\u0001\u0010vR\u0018\u0010\u0094\u0001\u001a\u00020p8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0093\u0001\u0010rR\u0018\u0010\u0096\u0001\u001a\u00020t8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0095\u0001\u0010vR\u0018\u0010\u0098\u0001\u001a\u00020p8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0097\u0001\u0010rR\u0018\u0010\u009a\u0001\u001a\u00020t8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0099\u0001\u0010vR\u0019\u0010\u009d\u0001\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0018\u0010\u009f\u0001\u001a\u0004\u0018\u00010t8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u009e\u0001\u0010vR \u0010\u00a3\u0001\u001a\t\u0012\u0004\u0012\u00020\r0\u00a0\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00a1\u0001\u0010\u00a2\u0001R,\u0010\u00ab\u0001\u001a\u0005\u0018\u00010\u00a4\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00a5\u0001\u0010\u00a6\u0001\u001a\u0006\b\u00a7\u0001\u0010\u00a8\u0001\"\u0006\b\u00a9\u0001\u0010\u00aa\u0001R\u0019\u0010\u00ad\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ac\u0001\u0010\u0091\u0001R\u0019\u0010\u00af\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ae\u0001\u0010\u0091\u0001R\u0019\u0010\u00b1\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b0\u0001\u0010\u0091\u0001R\u0019\u0010\u00b3\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b2\u0001\u0010\u0091\u0001R\u0019\u0010\u00b5\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b4\u0001\u0010\u0091\u0001R\u001c\u0010\u00b9\u0001\u001a\u0005\u0018\u00010\u00b6\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b7\u0001\u0010\u00b8\u0001R!\u0010\u00bf\u0001\u001a\u00030\u00ba\u00018DX\u0084\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00bb\u0001\u0010\u00bc\u0001\u001a\u0006\b\u00bd\u0001\u0010\u00be\u0001R!\u0010\u00c4\u0001\u001a\u00030\u00c0\u00018DX\u0084\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00c1\u0001\u0010\u00bc\u0001\u001a\u0006\b\u00c2\u0001\u0010\u00c3\u0001R!\u0010\u00c9\u0001\u001a\u00030\u00c5\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00c6\u0001\u0010\u00bc\u0001\u001a\u0006\b\u00c7\u0001\u0010\u00c8\u0001R!\u0010\u00ce\u0001\u001a\u00030\u00ca\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00cb\u0001\u0010\u00bc\u0001\u001a\u0006\b\u00cc\u0001\u0010\u00cd\u0001R\u0018\u0010\u00d2\u0001\u001a\u00030\u00cf\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d0\u0001\u0010\u00d1\u0001R\u0018\u0010\u00d6\u0001\u001a\u00030\u00d3\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d4\u0001\u0010\u00d5\u0001\u00a8\u0006\u00db\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/WinkEditorMusicMenuPartV2;", "Lcom/tencent/mobileqq/wink/editor/menu/WinkEditorMenuPart;", "Lc73/a;", "Landroid/view/View$OnClickListener;", "", "categoryName", "", "Ua", "Ta", "ib", "", "isMusicCleared", "Xb", "Landroid/view/View;", "v", ViewStickEventHelper.IS_SHOW, "Jb", "Ib", "initViewModel", "tb", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "musicInfo", "Yb", "mb", "Lcom/tencent/mobileqq/wink/editor/music/vo/b;", "infoWrapper", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editMode", "Zb", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "vb", "cc", "enable", "Pb", "Bb", "bc", "Landroid/content/Intent;", "Va", "Ab", "Gb", "", "position", "Hb", "qb", "Fb", UinConfigManager.KEY_HB, "Vb", "kb", "Oa", "musicName", "musicId", "musicCategory", "Lb", "Mb", "getLogTag", "Landroidx/lifecycle/ViewModelStoreOwner;", "cb", "Kb", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "ba", "oa", "B9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "onInitView", "args", "L9", "onDismiss", "initAfterInflation", "J9", "Qb", "onBackEvent", NodeProps.ON_CLICK, "rb", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "simpleBaseEvent", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "j1", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditUIData;", "data", "N9", "", "durationUs", "W", "Y2", "Za", "Sa", "yb", "Lcom/tencent/mobileqq/wink/editor/music/ui/WinkMusicButton;", "M", "Lcom/tencent/mobileqq/wink/editor/music/ui/WinkMusicButton;", "mMusicMenuItem", "Landroidx/constraintlayout/widget/ConstraintLayout;", "N", "Landroidx/constraintlayout/widget/ConstraintLayout;", "winkMusicPanelLl", "Lcom/tencent/mobileqq/wink/editor/music/view/WinkMusicTab;", "P", "Lcom/tencent/mobileqq/wink/editor/music/view/WinkMusicTab;", "bb", "()Lcom/tencent/mobileqq/wink/editor/music/view/WinkMusicTab;", "Rb", "(Lcom/tencent/mobileqq/wink/editor/music/view/WinkMusicTab;)V", "tabLayout", "Landroid/widget/ImageView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/ImageView;", "winkMusicLibraryIv", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/TextView;", "winkMusicLibraryTv", ExifInterface.LATITUDE_SOUTH, "winkMusicSearchIv", "T", "winkMusicSearchTv", "Landroidx/viewpager/widget/ViewPager;", "U", "Landroidx/viewpager/widget/ViewPager;", "eb", "()Landroidx/viewpager/widget/ViewPager;", "Sb", "(Landroidx/viewpager/widget/ViewPager;)V", "viewPager", "V", "fb", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "Tb", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "winkMusicPanelBottomSheetCl", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "winkMusicOriginVoiceIv", "X", "winkMusicOriginVoiceTv", "Y", "winkMusicMusicVoiceIv", "Z", "winkMusicMusicVoiceTv", "a0", "winkMusicLyricIv", "b0", "winkMusicLyricTv", "c0", "winkMusicVolumeIv", "d0", "winkMusicVolumeTv", "e0", "Landroid/view/View;", "musicItemTipsLayout", "f0", "musicItemTipsText", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "g0", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", ComicCancelRedPointPopItemData.JSON_KEY_BEHAVIOR, "Lcom/tencent/mobileqq/wink/editor/music/adapter/WinkMusicListPageAdapter;", "h0", "Lcom/tencent/mobileqq/wink/editor/music/adapter/WinkMusicListPageAdapter;", "ab", "()Lcom/tencent/mobileqq/wink/editor/music/adapter/WinkMusicListPageAdapter;", "Ob", "(Lcom/tencent/mobileqq/wink/editor/music/adapter/WinkMusicListPageAdapter;)V", "musicListPageAdapter", "i0", "firstEnter", "j0", "hasEnterMusic", "k0", "hasAutoSavedUIDraft", "l0", "isTavCutInit", "m0", "hasMusicButtonExposed", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/a;", "n0", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/a;", "mMusicPlayerViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "o0", "Lkotlin/Lazy;", "Wa", "()Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "mMusicSourceViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", "p0", "Xa", "()Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", "mMusicVolumeControlViewModel", "Lcom/tencent/mobileqq/wink/editor/template/x;", "q0", "Ya", "()Lcom/tencent/mobileqq/wink/editor/template/x;", "mWinkEditorTemplateViewModel", "Lcom/tencent/mobileqq/wink/editor/recommend/b;", "r0", "gb", "()Lcom/tencent/mobileqq/wink/editor/recommend/b;", "winkRecommendViewModel", "Landroid/content/BroadcastReceiver;", "s0", "Landroid/content/BroadcastReceiver;", "mNetReceiver", "Lcom/tencent/tavcut/core/session/ISessionListener;", "t0", "Lcom/tencent/tavcut/core/session/ISessionListener;", "sessionListener", "<init>", "()V", "u0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class WinkEditorMusicMenuPartV2 extends WinkEditorMenuPart implements c73.a, View.OnClickListener {

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private WinkMusicButton mMusicMenuItem;

    /* renamed from: N, reason: from kotlin metadata */
    private ConstraintLayout winkMusicPanelLl;

    /* renamed from: P, reason: from kotlin metadata */
    protected WinkMusicTab tabLayout;

    /* renamed from: Q, reason: from kotlin metadata */
    private ImageView winkMusicLibraryIv;

    /* renamed from: R, reason: from kotlin metadata */
    private TextView winkMusicLibraryTv;

    /* renamed from: S, reason: from kotlin metadata */
    private ImageView winkMusicSearchIv;

    /* renamed from: T, reason: from kotlin metadata */
    private TextView winkMusicSearchTv;

    /* renamed from: U, reason: from kotlin metadata */
    protected ViewPager viewPager;

    /* renamed from: V, reason: from kotlin metadata */
    public ConstraintLayout winkMusicPanelBottomSheetCl;

    /* renamed from: W, reason: from kotlin metadata */
    private QUICheckBox winkMusicOriginVoiceIv;

    /* renamed from: X, reason: from kotlin metadata */
    private TextView winkMusicOriginVoiceTv;

    /* renamed from: Y, reason: from kotlin metadata */
    private QUICheckBox winkMusicMusicVoiceIv;

    /* renamed from: Z, reason: from kotlin metadata */
    private TextView winkMusicMusicVoiceTv;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private ImageView winkMusicLyricIv;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private TextView winkMusicLyricTv;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private ImageView winkMusicVolumeIv;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private TextView winkMusicVolumeTv;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View musicItemTipsLayout;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final TextView musicItemTipsText;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private BottomSheetBehavior<View> behavior;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkMusicListPageAdapter musicListPageAdapter;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private boolean firstEnter = true;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private boolean hasEnterMusic;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private boolean hasAutoSavedUIDraft;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private boolean isTavCutInit;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private boolean hasMusicButtonExposed;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.music.viewmodel.a mMusicPlayerViewModel;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mMusicSourceViewModel;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mMusicVolumeControlViewModel;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mWinkEditorTemplateViewModel;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy winkRecommendViewModel;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BroadcastReceiver mNetReceiver;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ISessionListener sessionListener;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/editor/music/WinkEditorMusicMenuPartV2$b", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$e;", "Landroid/view/View;", "bottomSheet", "", "newState", "", "onStateChanged", "", "slideOffset", "onSlide", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends BottomSheetBehavior.e {
        b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NotNull View bottomSheet, float slideOffset) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NotNull View bottomSheet, int newState) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (newState != 1) {
                if (newState != 2) {
                    if (newState != 3) {
                        if (newState != 4) {
                            if (newState == 5) {
                                w53.b.a(WinkEditorMusicMenuPartV2.this.getTAG(), "STATE_HIDDEN");
                                return;
                            }
                            return;
                        } else {
                            w53.b.a(WinkEditorMusicMenuPartV2.this.getTAG(), "STATE_COLLAPSED");
                            WinkEditorMusicMenuPartV2.this.G9().l5();
                            return;
                        }
                    }
                    w53.b.a(WinkEditorMusicMenuPartV2.this.getTAG(), "STATE_EXPANDED");
                    return;
                }
                w53.b.a(WinkEditorMusicMenuPartV2.this.getTAG(), "STATE_SETTLING");
                return;
            }
            w53.b.a(WinkEditorMusicMenuPartV2.this.getTAG(), "STATE_DRAGGING");
        }
    }

    public WinkEditorMusicMenuPartV2() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MusicSourceViewModel>() { // from class: com.tencent.mobileqq.wink.editor.music.WinkEditorMusicMenuPartV2$mMusicSourceViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MusicSourceViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(WinkEditorMusicMenuPartV2.this.cb()).get(MusicSourceViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(getVie\u2026rceViewModel::class.java)");
                return (MusicSourceViewModel) viewModel;
            }
        });
        this.mMusicSourceViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MusicVolumeControlViewModel>() { // from class: com.tencent.mobileqq.wink.editor.music.WinkEditorMusicMenuPartV2$mMusicVolumeControlViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MusicVolumeControlViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(WinkEditorMusicMenuPartV2.this.cb()).get(MusicVolumeControlViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(getVie\u2026rolViewModel::class.java)");
                return (MusicVolumeControlViewModel) viewModel;
            }
        });
        this.mMusicVolumeControlViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.editor.template.x>() { // from class: com.tencent.mobileqq.wink.editor.music.WinkEditorMusicMenuPartV2$mWinkEditorTemplateViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.wink.editor.template.x invoke() {
                return (com.tencent.mobileqq.wink.editor.template.x) WinkEditorMusicMenuPartV2.this.getViewModel(com.tencent.mobileqq.wink.editor.template.x.class);
            }
        });
        this.mWinkEditorTemplateViewModel = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.editor.recommend.b>() { // from class: com.tencent.mobileqq.wink.editor.music.WinkEditorMusicMenuPartV2$winkRecommendViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.wink.editor.recommend.b invoke() {
                return (com.tencent.mobileqq.wink.editor.recommend.b) WinkEditorMusicMenuPartV2.this.getViewModel(com.tencent.mobileqq.wink.editor.recommend.b.class);
            }
        });
        this.winkRecommendViewModel = lazy4;
        this.mNetReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.wink.editor.music.WinkEditorMusicMenuPartV2$mNetReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                WinkEditorMusicMenuPartV2.this.Kb();
            }
        };
        this.sessionListener = new c();
    }

    private final boolean Ab() {
        if (Wa().getEditMode() == WinkEditorViewModel.EditMode.Image) {
            return true;
        }
        return false;
    }

    private final void Bb() {
        QUICheckBox qUICheckBox = this.winkMusicMusicVoiceIv;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkMusicMusicVoiceIv");
            qUICheckBox = null;
        }
        if (qUICheckBox.isChecked()) {
            WinkMusicListPageAdapter winkMusicListPageAdapter = this.musicListPageAdapter;
            if (winkMusicListPageAdapter != null) {
                int f16 = winkMusicListPageAdapter.f();
                w53.b.a(getTAG(), "firstVisibleItemPosition:" + f16);
                if (f16 == -1) {
                    f16 = 0;
                }
                Wa().l4(f16);
                return;
            }
            return;
        }
        Wa().y2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Cb(WinkEditorMusicMenuPartV2 this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BottomSheetBehavior<View> bottomSheetBehavior = null;
        this$0.Q9(null);
        this$0.Wa().E3();
        BottomSheetBehavior<View> bottomSheetBehavior2 = this$0.behavior;
        if (bottomSheetBehavior2 != null) {
            if (bottomSheetBehavior2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ComicCancelRedPointPopItemData.JSON_KEY_BEHAVIOR);
            } else {
                bottomSheetBehavior = bottomSheetBehavior2;
            }
            bottomSheetBehavior.setState(3);
            this$0.Ua("\u63a8\u8350");
            this$0.Ua("\u6536\u85cf");
        }
        if (this$0.Wa().getCurrentMusic() == null) {
            this$0.Wa().i4();
        }
        this$0.Ta();
        ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).reportExpExposure("xsp_xsj_fabuqi_qukushiyongxintuijian");
        ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).reportExpExposure("exp_xsj_fabuqi_yinyuejieruqyinresou");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Db(WinkEditorMusicMenuPartV2 this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Wa().y2();
        try {
            z93.c f16 = Wink.INSTANCE.f();
            if (f16 != null) {
                WinkPublishQualityReportData.Builder eventId = new WinkPublishQualityReportData.Builder().eventId("E_MUSIC_CLOSE_BGM");
                WinkContext.Companion companion = WinkContext.INSTANCE;
                f16.b(eventId.traceId(companion.d().getTraceId()).getReportData(), companion.d().k().a());
            }
        } catch (Exception e16) {
            w53.b.e(this$0.getTAG(), e16);
        }
        w53.b.c(this$0.getTAG(), "click close button");
        WinkMusicButton winkMusicButton = this$0.mMusicMenuItem;
        if (winkMusicButton != null) {
            WinkMusicButton.f(winkMusicButton, null, 1, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eb(WinkEditorMusicMenuPartV2 this$0, MenuSwitchAction menuSwitchAction) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(menuSwitchAction, "menuSwitchAction");
        if (menuSwitchAction.getMenuType() == MenuType.BOTTOM_DASHBOARD && this$0.G9().getIsEnableMusic()) {
            WinkMusicButton winkMusicButton = this$0.mMusicMenuItem;
            Intrinsics.checkNotNull(winkMusicButton);
            winkMusicButton.setVisibility(0);
        } else {
            WinkMusicButton winkMusicButton2 = this$0.mMusicMenuItem;
            Intrinsics.checkNotNull(winkMusicButton2);
            winkMusicButton2.setVisibility(4);
        }
    }

    private final void Fb(int position) {
        WinkMusicListFragment.MusicRequestType musicRequestType;
        WinkMusicListPageAdapter winkMusicListPageAdapter = this.musicListPageAdapter;
        if (winkMusicListPageAdapter != null) {
            if (position == 1) {
                musicRequestType = WinkMusicListFragment.MusicRequestType.COLLECTION;
            } else {
                musicRequestType = WinkMusicListFragment.MusicRequestType.RECOMMEND;
            }
            winkMusicListPageAdapter.j(musicRequestType);
        }
        if (position == 1) {
            MusicSourceViewModel Wa = Wa();
            ax COLLECTION_CATEGORY_INFO = ax.f320779f;
            Intrinsics.checkNotNullExpressionValue(COLLECTION_CATEGORY_INFO, "COLLECTION_CATEGORY_INFO");
            Wa.G3(COLLECTION_CATEGORY_INFO);
            return;
        }
        MusicSourceViewModel Wa2 = Wa();
        ax RECOMM_CATEGORY_INFO = ax.f320778e;
        Intrinsics.checkNotNullExpressionValue(RECOMM_CATEGORY_INFO, "RECOMM_CATEGORY_INFO");
        Wa2.G3(RECOMM_CATEGORY_INFO);
    }

    private final void Gb() {
        dr H9;
        if ((H9() instanceof WinkVideoTavCut) && (H9 = H9()) != null) {
            H9.pause();
        }
    }

    private final void Hb(int position) {
        if (H9() instanceof WinkVideoTavCut) {
            dr H9 = H9();
            if (H9 != null) {
                H9.seek(position);
            }
            dr H92 = H9();
            if (H92 != null) {
                H92.play();
            }
        }
    }

    private final void Ib() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            getActivity().registerReceiver(this.mNetReceiver, intentFilter);
        } catch (Exception e16) {
            w53.b.g(getTAG(), "registerReceiver " + e16.getMessage());
        }
    }

    private final void Jb(View v3, boolean isShow) {
        String str;
        Map<String, ? extends Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        com.tencent.mobileqq.wink.report.a aVar = com.tencent.mobileqq.wink.report.a.f326259a;
        if (isShow) {
            str = "dt_imp";
        } else {
            str = "dt_imp_end";
        }
        aVar.a(WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_PANEL, str, WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE, buildElementParams);
    }

    private final void Lb(String musicName, String musicId, String musicCategory) {
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_music_name", musicName);
        hashMap.put("xsj_music_id", musicId);
        HashMap<String, Object> params = WinkDatongCurrentParams.params;
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_music_name", musicName);
        HashMap<String, Object> params2 = WinkDatongCurrentParams.params;
        Intrinsics.checkNotNullExpressionValue(params2, "params");
        params2.put("xsj_music_id", musicId);
        HashMap<String, Object> params3 = WinkDatongCurrentParams.params;
        Intrinsics.checkNotNullExpressionValue(params3, "params");
        params3.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_CATEGORY_NAME, musicCategory);
        VideoReport.setElementParams(this.mMusicMenuItem, hashMap);
    }

    private final void Mb(final WinkEditorMusicInfo musicInfo) {
        if (this.musicItemTipsLayout == null) {
            return;
        }
        if (musicInfo != null && !TextUtils.isEmpty(musicInfo.v())) {
            this.musicItemTipsLayout.setVisibility(0);
            this.musicItemTipsLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.music.ak
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorMusicMenuPartV2.Nb(WinkEditorMusicMenuPartV2.this, musicInfo, view);
                }
            });
            TextView textView = this.musicItemTipsText;
            if (textView != null) {
                textView.setText(musicInfo.v());
            }
            VideoReport.setElementId(this.musicItemTipsLayout, WinkDaTongReportConstant.ElementParamKey.EM_ACTIVITY_NOTICE_TIP_BAR);
            Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
            Intrinsics.checkNotNullExpressionValue(map, "map");
            map.put("xsj_text_content", musicInfo.v());
            VideoReport.setElementParams(this.musicItemTipsLayout, map);
            return;
        }
        this.musicItemTipsLayout.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nb(WinkEditorMusicMenuPartV2 this$0, WinkEditorMusicInfo winkEditorMusicInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.wink.f.l(this$0.getContext(), winkEditorMusicInfo.u());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Oa() {
        Wa().D2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.au
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorMusicMenuPartV2.Pa(WinkEditorMusicMenuPartV2.this, (MusicInfoWrapper) obj);
            }
        });
        Wa().t3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.ae
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorMusicMenuPartV2.Qa(WinkEditorMusicMenuPartV2.this, (WinkEditorMusicInfo) obj);
            }
        });
        Wa().u3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.af
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorMusicMenuPartV2.Ra(WinkEditorMusicMenuPartV2.this, ((Boolean) obj).booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pa(WinkEditorMusicMenuPartV2 this$0, MusicInfoWrapper musicInfoWrapper) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(musicInfoWrapper, "musicInfoWrapper");
        this$0.Wa().g3().postValue(musicInfoWrapper.getMusicInfo());
        if (this$0.Ab()) {
            return;
        }
        if (musicInfoWrapper.getMusicInfo() != null && !TextUtils.isEmpty(musicInfoWrapper.getMusicInfo().q())) {
            String q16 = musicInfoWrapper.getMusicInfo().q();
            Intrinsics.checkNotNullExpressionValue(q16, "musicInfoWrapper.musicInfo.songName");
            String p16 = musicInfoWrapper.getMusicInfo().p();
            Intrinsics.checkNotNullExpressionValue(p16, "musicInfoWrapper.musicInfo.songMid");
            this$0.Mb(musicInfoWrapper.getMusicInfo());
            String str = musicInfoWrapper.getMusicInfo().E;
            Intrinsics.checkNotNullExpressionValue(str, "musicInfoWrapper.musicInfo.categoryName");
            this$0.Lb(q16, p16, str);
            WinkMusicButton winkMusicButton = this$0.mMusicMenuItem;
            Intrinsics.checkNotNull(winkMusicButton);
            winkMusicButton.p(q16, musicInfoWrapper.getMusicInfo().c(), this$0.Za());
            return;
        }
        if (this$0.H9() != null) {
            dr H9 = this$0.H9();
            Intrinsics.checkNotNull(H9);
            z16 = H9.G();
        } else {
            z16 = false;
        }
        w53.b.a(this$0.getTAG(), "getBgmSourceLiveData update " + this$0.Ya().getIsUseTemplate() + ", tavcut isUsingTemplate " + z16);
        if (!this$0.Ya().getIsUseTemplate() && !z16) {
            WinkMusicButton winkMusicButton2 = this$0.mMusicMenuItem;
            Intrinsics.checkNotNull(winkMusicButton2);
            winkMusicButton2.a();
            this$0.Lb("", "", "");
        } else {
            WinkMusicButton winkMusicButton3 = this$0.mMusicMenuItem;
            Intrinsics.checkNotNull(winkMusicButton3);
            String string = this$0.getContext().getString(R.string.ym_);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026ae_editor_template_music)");
            winkMusicButton3.p(string, "", this$0.Za());
        }
        this$0.Mb(null);
    }

    private final void Pb(boolean enable) {
        w53.b.f(getTAG(), "setMusicVoiceCheckBoxEnable enable:" + enable);
        TextView textView = null;
        if (enable) {
            QUICheckBox qUICheckBox = this.winkMusicMusicVoiceIv;
            if (qUICheckBox == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkMusicMusicVoiceIv");
                qUICheckBox = null;
            }
            qUICheckBox.setVisibility(0);
            TextView textView2 = this.winkMusicMusicVoiceTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkMusicMusicVoiceTv");
            } else {
                textView = textView2;
            }
            textView.setVisibility(0);
            return;
        }
        QUICheckBox qUICheckBox2 = this.winkMusicMusicVoiceIv;
        if (qUICheckBox2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkMusicMusicVoiceIv");
            qUICheckBox2 = null;
        }
        qUICheckBox2.setVisibility(8);
        TextView textView3 = this.winkMusicMusicVoiceTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkMusicMusicVoiceTv");
        } else {
            textView = textView3;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qa(WinkEditorMusicMenuPartV2 this$0, WinkEditorMusicInfo winkEditorMusicInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.Wa().getEditMode() != WinkEditorViewModel.EditMode.Image) {
            return;
        }
        if (winkEditorMusicInfo == null) {
            WinkMusicButton winkMusicButton = this$0.mMusicMenuItem;
            Intrinsics.checkNotNull(winkMusicButton);
            winkMusicButton.a();
            this$0.Mb(null);
            this$0.Lb("", "", "");
            return;
        }
        String q16 = winkEditorMusicInfo.q();
        Intrinsics.checkNotNullExpressionValue(q16, "winkEditorMusicInfo.songName");
        String p16 = winkEditorMusicInfo.p();
        Intrinsics.checkNotNullExpressionValue(p16, "winkEditorMusicInfo.songMid");
        WinkMusicButton winkMusicButton2 = this$0.mMusicMenuItem;
        Intrinsics.checkNotNull(winkMusicButton2);
        winkMusicButton2.p(q16, winkEditorMusicInfo.c(), this$0.Za());
        this$0.Mb(winkEditorMusicInfo);
        String str = winkEditorMusicInfo.E;
        Intrinsics.checkNotNullExpressionValue(str, "winkEditorMusicInfo.categoryName");
        this$0.Lb(q16, p16, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ra(WinkEditorMusicMenuPartV2 this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            WinkMusicButton winkMusicButton = this$0.mMusicMenuItem;
            Intrinsics.checkNotNull(winkMusicButton);
            String string = this$0.getContext().getString(R.string.ym_);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026ae_editor_template_music)");
            winkMusicButton.p(string, "", this$0.Za());
            this$0.Mb(null);
        } else if (this$0.Wa().getCurrentMusic() != null) {
            WinkEditorMusicInfo currentMusic = this$0.Wa().getCurrentMusic();
            Intrinsics.checkNotNull(currentMusic);
            String q16 = currentMusic.q();
            Intrinsics.checkNotNullExpressionValue(q16, "mMusicSourceViewModel.currentMusic!!.songName");
            WinkEditorMusicInfo currentMusic2 = this$0.Wa().getCurrentMusic();
            Intrinsics.checkNotNull(currentMusic2);
            String p16 = currentMusic2.p();
            Intrinsics.checkNotNullExpressionValue(p16, "mMusicSourceViewModel.currentMusic!!.songMid");
            this$0.Mb(this$0.Wa().getCurrentMusic());
            WinkEditorMusicInfo currentMusic3 = this$0.Wa().getCurrentMusic();
            Intrinsics.checkNotNull(currentMusic3);
            String str = currentMusic3.E;
            Intrinsics.checkNotNullExpressionValue(str, "mMusicSourceViewModel.currentMusic!!.categoryName");
            this$0.Lb(q16, p16, str);
            WinkMusicButton winkMusicButton2 = this$0.mMusicMenuItem;
            Intrinsics.checkNotNull(winkMusicButton2);
            WinkEditorMusicInfo currentMusic4 = this$0.Wa().getCurrentMusic();
            Intrinsics.checkNotNull(currentMusic4);
            winkMusicButton2.p(q16, currentMusic4.c(), this$0.Za());
        } else {
            WinkMusicButton winkMusicButton3 = this$0.mMusicMenuItem;
            Intrinsics.checkNotNull(winkMusicButton3);
            winkMusicButton3.a();
            this$0.Mb(null);
        }
        if (this$0.Ya().getIsUseTemplate() && !this$0.Xa().getIsOriginalVolumeChangedManually()) {
            this$0.Xa().K2(z16);
        }
    }

    private final void Ta() {
        VideoReport.setElementId(this.mMusicMenuItem, WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_BUTTON);
        Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("xsj_music_id", WinkDatongCurrentParams.get("xsj_music_id"));
        map.put("xsj_music_name", WinkDatongCurrentParams.get("xsj_music_name"));
        VideoReport.setElementParams(this.mMusicMenuItem, map);
        VideoReport.setElementClickPolicy(this.mMusicMenuItem, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_clck", this.mMusicMenuItem, map);
    }

    private final void Ua(String categoryName) {
        Map<String, ? extends Object> map = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_CATEGORY_NAME, categoryName);
        com.tencent.mobileqq.wink.report.a.f326259a.a(WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_CATEGORY_NEW, "ev_xsj_abnormal_imp", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE, map);
    }

    private final Intent Va() {
        Intent intent = new Intent();
        intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        QZoneHelper.addSource(intent);
        intent.putExtra("videoclipduration", (int) Wa().getVideoDurationMs());
        intent.putExtra("videofrom", "fromqqwink");
        if (Ab()) {
            intent.putExtra("type", "photo");
        } else {
            intent.putExtra("type", "notphoto");
        }
        return intent;
    }

    private final void Vb() {
        final String p16 = WinkContext.INSTANCE.d().p(QCircleScheme.AttrQQPublish.MUSIC_BANNER_BUBBLE_TIPS);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s(%s)", Arrays.copyOf(new Object[]{"wink_music_item_tips_bubble_shown", p16}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        if (!TextUtils.isEmpty(p16)) {
            com.tencent.mobileqq.wink.utils.ar arVar = com.tencent.mobileqq.wink.utils.ar.f326685a;
            if (!arVar.c(format, false)) {
                arVar.m(format, true);
                w53.b.f(getTAG(), "[showBubbleTips] bubbleTipsText=" + p16);
                WinkMusicButton winkMusicButton = this.mMusicMenuItem;
                Intrinsics.checkNotNull(winkMusicButton);
                winkMusicButton.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.ap
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkEditorMusicMenuPartV2.Wb(WinkEditorMusicMenuPartV2.this, p16);
                    }
                }, 500L);
                Map<String, ?> params = WinkDTParamBuilder.buildElementParams();
                Intrinsics.checkNotNullExpressionValue(params, "params");
                params.put("dt_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
                params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
                if (getActivity().getIntent() != null) {
                    TagRetriever tagRetriever = TagRetriever.f326413a;
                    Intent intent = getActivity().getIntent();
                    Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
                    params.put("xsj_topic_name", tagRetriever.j(intent));
                }
                params.put("xsj_text_content", p16);
                com.tencent.mobileqq.wink.report.e.f326265a.q("ev_xsj_abnormal_imp", this.mMusicMenuItem, WinkDaTongReportConstant.ElementId.EM_XSJ_ACTIVITY_BUBBLE, params, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wb(WinkEditorMusicMenuPartV2 this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUIDefaultBubbleTip.r(this$0.getContext()).o0(str).S(this$0.mMusicMenuItem).R(0).k0(1).h0("wink_music_item_tips_bubble_shown").m0(3).s0();
    }

    private final void Xb(boolean isMusicCleared) {
        WinkMusicUIData winkMusicUIData = (WinkMusicUIData) getUiData();
        if (winkMusicUIData == null) {
            return;
        }
        winkMusicUIData.putBoolean(WinkMusicUIData.IS_MUSIC_CLEARED, isMusicCleared);
        w53.b.a(getTAG(), "isMusicCleared saved " + isMusicCleared);
    }

    private final com.tencent.mobileqq.wink.editor.template.x Ya() {
        Object value = this.mWinkEditorTemplateViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mWinkEditorTemplateViewModel>(...)");
        return (com.tencent.mobileqq.wink.editor.template.x) value;
    }

    private final void Yb(WinkEditorMusicInfo musicInfo) {
        Map mapOf;
        TextView textView;
        ImageView imageView;
        if (musicInfo != null) {
            boolean z16 = true;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("xsj_music_id", musicInfo.p()), TuplesKt.to("xsj_music_name", musicInfo.q()));
            com.tencent.mobileqq.wink.report.a aVar = com.tencent.mobileqq.wink.report.a.f326259a;
            TextView textView2 = this.winkMusicLyricTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkMusicLyricTv");
                textView = null;
            } else {
                textView = textView2;
            }
            com.tencent.mobileqq.wink.report.a.d(aVar, textView, WinkDaTongReportConstant.ElementId.EM_XSJ_LYRIC_ENTRY_BUTTON, null, ExposurePolicy.REPORT_NONE, null, mapOf, null, 84, null);
            ImageView imageView2 = this.winkMusicLyricIv;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkMusicLyricIv");
                imageView = null;
            } else {
                imageView = imageView2;
            }
            com.tencent.mobileqq.wink.report.a.d(aVar, imageView, WinkDaTongReportConstant.ElementId.EM_XSJ_LYRIC_ENTRY_BUTTON, null, null, null, mapOf, null, 92, null);
            String k3 = musicInfo.k();
            Intrinsics.checkNotNullExpressionValue(k3, "it.lyric");
            if (k3.length() != 0) {
                z16 = false;
            }
            if (z16) {
                ImageView imageView3 = this.winkMusicLyricIv;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkMusicLyricIv");
                    imageView3 = null;
                }
                imageView3.setVisibility(8);
                TextView textView3 = this.winkMusicLyricTv;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkMusicLyricTv");
                    textView3 = null;
                }
                textView3.setVisibility(8);
                return;
            }
            ImageView imageView4 = this.winkMusicLyricIv;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkMusicLyricIv");
                imageView4 = null;
            }
            imageView4.setVisibility(0);
            TextView textView4 = this.winkMusicLyricTv;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkMusicLyricTv");
                textView4 = null;
            }
            textView4.setVisibility(0);
        }
    }

    private final void Zb(MusicInfoWrapper infoWrapper, WinkEditorViewModel.EditMode editMode) {
        WinkEditorMusicInfo winkEditorMusicInfo;
        WinkEditorMusicInfo winkEditorMusicInfo2;
        QUICheckBox qUICheckBox;
        String tag = getTAG();
        if (infoWrapper != null) {
            winkEditorMusicInfo = infoWrapper.getMusicInfo();
        } else {
            winkEditorMusicInfo = null;
        }
        w53.b.f(tag, "updateMusicDisableView... musicInfo:" + winkEditorMusicInfo + ", editMode:" + editMode);
        if (infoWrapper != null) {
            winkEditorMusicInfo2 = infoWrapper.getMusicInfo();
        } else {
            winkEditorMusicInfo2 = null;
        }
        if (winkEditorMusicInfo2 != null) {
            QUICheckBox qUICheckBox2 = this.winkMusicMusicVoiceIv;
            if (qUICheckBox2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkMusicMusicVoiceIv");
                qUICheckBox2 = null;
            }
            qUICheckBox2.setChecked(true);
        } else {
            QUICheckBox qUICheckBox3 = this.winkMusicMusicVoiceIv;
            if (qUICheckBox3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkMusicMusicVoiceIv");
                qUICheckBox3 = null;
            }
            qUICheckBox3.setChecked(false);
        }
        com.tencent.mobileqq.wink.report.a aVar = com.tencent.mobileqq.wink.report.a.f326259a;
        QUICheckBox qUICheckBox4 = this.winkMusicMusicVoiceIv;
        if (qUICheckBox4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkMusicMusicVoiceIv");
            qUICheckBox = null;
        } else {
            qUICheckBox = qUICheckBox4;
        }
        com.tencent.mobileqq.wink.report.a.d(aVar, qUICheckBox, WinkDaTongReportConstant.ElementId.EM_XSJ_SOUND_MATCH_BUTTON, null, null, null, null, new IDynamicParams() { // from class: com.tencent.mobileqq.wink.editor.music.al
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map ac5;
                ac5 = WinkEditorMusicMenuPartV2.ac(WinkEditorMusicMenuPartV2.this, str);
                return ac5;
            }
        }, 60, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map ac(WinkEditorMusicMenuPartV2 this$0, String str) {
        String str2;
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUICheckBox qUICheckBox = this$0.winkMusicMusicVoiceIv;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkMusicMusicVoiceIv");
            qUICheckBox = null;
        }
        if (qUICheckBox.isChecked()) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("xsj_is_tick", str2));
        return mapOf;
    }

    private final void bc() {
        MusicVolumeControlViewModel Xa = Xa();
        QUICheckBox qUICheckBox = this.winkMusicOriginVoiceIv;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkMusicOriginVoiceIv");
            qUICheckBox = null;
        }
        Xa.o2(qUICheckBox.isChecked(), Ya().getIsUseTemplate(), true);
        Xa().l2().postValue(Boolean.TRUE);
    }

    private final void cc(WinkEditorViewModel.EditMode editMode) {
        boolean z16;
        WinkEditorViewModel winkEditorViewModel = (WinkEditorViewModel) getViewModel(WinkEditorViewModel.class);
        if (winkEditorViewModel == null || this.winkMusicOriginVoiceIv == null) {
            return;
        }
        boolean z17 = false;
        if (winkEditorViewModel.getMFrom() == 1 && Wa().getCurrentMusic() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        w53.b.f(getTAG(), "updateOriginVolumeLayout isFromMusicCamera:" + z16 + " isTavCutInit:" + this.isTavCutInit + " isAllImages:" + yb() + " hasEnterMusic:" + this.hasEnterMusic + " editMode:" + editMode);
        if (editMode == WinkEditorViewModel.EditMode.Video && !yb() && ((!this.hasEnterMusic || !z16) && !G9().getIsFromZShow() && !G9().getIsFromMagicStudio())) {
            z17 = true;
        }
        Qb(z17);
        Pb(!Sa());
    }

    private final com.tencent.mobileqq.wink.editor.recommend.b gb() {
        Object value = this.winkRecommendViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-winkRecommendViewModel>(...)");
        return (com.tencent.mobileqq.wink.editor.recommend.b) value;
    }

    private final void hb() {
        ConstraintLayout constraintLayout = this.winkMusicPanelLl;
        BottomSheetBehavior<View> bottomSheetBehavior = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkMusicPanelLl");
            constraintLayout = null;
        }
        BottomSheetBehavior<View> from = BottomSheetBehavior.from(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(from, "from(winkMusicPanelLl)");
        this.behavior = from;
        if (from == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ComicCancelRedPointPopItemData.JSON_KEY_BEHAVIOR);
            from = null;
        }
        from.addBottomSheetCallback(new b());
        BottomSheetBehavior<View> bottomSheetBehavior2 = this.behavior;
        if (bottomSheetBehavior2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ComicCancelRedPointPopItemData.JSON_KEY_BEHAVIOR);
            bottomSheetBehavior2 = null;
        }
        bottomSheetBehavior2.setPeekHeight(0);
        BottomSheetBehavior<View> bottomSheetBehavior3 = this.behavior;
        if (bottomSheetBehavior3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ComicCancelRedPointPopItemData.JSON_KEY_BEHAVIOR);
        } else {
            bottomSheetBehavior = bottomSheetBehavior3;
        }
        bottomSheetBehavior.setState(3);
    }

    private final void ib() {
        Wa().x3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.ag
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorMusicMenuPartV2.jb(WinkEditorMusicMenuPartV2.this, ((Boolean) obj).booleanValue());
            }
        });
    }

    private final void initViewModel() {
        Wa().D2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.ad
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorMusicMenuPartV2.wb(WinkEditorMusicMenuPartV2.this, (MusicInfoWrapper) obj);
            }
        });
        Wa().M2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.am
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorMusicMenuPartV2.xb(WinkEditorMusicMenuPartV2.this, (ax) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jb(WinkEditorMusicMenuPartV2 this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Xb(z16);
    }

    private final void kb() {
        if (Wa() != null) {
            Wa().g3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.ai
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkEditorMusicMenuPartV2.lb(WinkEditorMusicMenuPartV2.this, (WinkEditorMusicInfo) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lb(WinkEditorMusicMenuPartV2 this$0, WinkEditorMusicInfo winkEditorMusicInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.hasMusicButtonExposed) {
            this$0.hasMusicButtonExposed = true;
            g73.a.f401518a.a(this$0.mMusicMenuItem, winkEditorMusicInfo);
        }
    }

    private final void mb() {
        Xa().k2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.an
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorMusicMenuPartV2.nb(WinkEditorMusicMenuPartV2.this, ((Boolean) obj).booleanValue());
            }
        });
        Xa().h2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.ao
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorMusicMenuPartV2.ob(WinkEditorMusicMenuPartV2.this, ((Float) obj).floatValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void nb(WinkEditorMusicMenuPartV2 this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.f(this$0.getTAG(), "[observe]originVolumeSwitchLiveData update isCheck to " + z16);
        QUICheckBox qUICheckBox = this$0.winkMusicOriginVoiceIv;
        QUICheckBox qUICheckBox2 = null;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkMusicOriginVoiceIv");
            qUICheckBox = null;
        }
        if (qUICheckBox.isEnabled()) {
            QUICheckBox qUICheckBox3 = this$0.winkMusicOriginVoiceIv;
            if (qUICheckBox3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkMusicOriginVoiceIv");
            } else {
                qUICheckBox2 = qUICheckBox3;
            }
            qUICheckBox2.setChecked(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ob(final WinkEditorMusicMenuPartV2 this$0, float f16) {
        boolean z16;
        QUICheckBox qUICheckBox;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.f(this$0.getTAG(), "[observe]originLiveData update volume to " + f16);
        QUICheckBox qUICheckBox2 = this$0.winkMusicOriginVoiceIv;
        QUICheckBox qUICheckBox3 = null;
        if (qUICheckBox2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkMusicOriginVoiceIv");
            qUICheckBox2 = null;
        }
        boolean z17 = false;
        if (qUICheckBox2.isEnabled()) {
            QUICheckBox qUICheckBox4 = this$0.winkMusicOriginVoiceIv;
            if (qUICheckBox4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkMusicOriginVoiceIv");
                qUICheckBox4 = null;
            }
            if (f16 == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            qUICheckBox4.setChecked(!z16);
            com.tencent.mobileqq.wink.report.a aVar = com.tencent.mobileqq.wink.report.a.f326259a;
            QUICheckBox qUICheckBox5 = this$0.winkMusicOriginVoiceIv;
            if (qUICheckBox5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkMusicOriginVoiceIv");
                qUICheckBox = null;
            } else {
                qUICheckBox = qUICheckBox5;
            }
            com.tencent.mobileqq.wink.report.a.d(aVar, qUICheckBox, WinkDaTongReportConstant.ElementId.EM_XSJ_SOUND_ORIGIN_BUTTON, null, null, null, null, new IDynamicParams() { // from class: com.tencent.mobileqq.wink.editor.music.ah
                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                public final Map getDynamicParams(String str) {
                    Map pb5;
                    pb5 = WinkEditorMusicMenuPartV2.pb(WinkEditorMusicMenuPartV2.this, str);
                    return pb5;
                }
            }, 60, null);
        }
        MusicVolumeControlViewModel Xa = this$0.Xa();
        QUICheckBox qUICheckBox6 = this$0.winkMusicOriginVoiceIv;
        if (qUICheckBox6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkMusicOriginVoiceIv");
        } else {
            qUICheckBox3 = qUICheckBox6;
        }
        Xa.E2(Boolean.valueOf(qUICheckBox3.isChecked()));
        MusicVolumeControlViewModel Xa2 = this$0.Xa();
        if (f16 == 0.0f) {
            z17 = true;
        }
        Xa2.I2(!z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map pb(WinkEditorMusicMenuPartV2 this$0, String str) {
        String str2;
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String tag = this$0.getTAG();
        QUICheckBox qUICheckBox = this$0.winkMusicOriginVoiceIv;
        QUICheckBox qUICheckBox2 = null;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkMusicOriginVoiceIv");
            qUICheckBox = null;
        }
        w53.b.a(tag, "xsj_is_tick:" + qUICheckBox.isChecked());
        QUICheckBox qUICheckBox3 = this$0.winkMusicOriginVoiceIv;
        if (qUICheckBox3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkMusicOriginVoiceIv");
        } else {
            qUICheckBox2 = qUICheckBox3;
        }
        if (qUICheckBox2.isChecked()) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("xsj_is_tick", str2));
        return mapOf;
    }

    private final void qb(View rootView) {
        Object systemService = rootView.getContext().getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.mMusicPlayerViewModel = (com.tencent.mobileqq.wink.editor.music.viewmodel.a) new ViewModelProvider(cb(), new com.tencent.mobileqq.wink.editor.music.viewmodel.f((AudioManager) systemService, Scene.EDIT)).get(com.tencent.mobileqq.wink.editor.music.viewmodel.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sb(WinkEditorMusicMenuPartV2 this$0, String[] tabTitles, int i3, boolean z16) {
        Map<String, ? extends Object> mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tabTitles, "$tabTitles");
        w53.b.f(this$0.getTAG(), "[onTabChange] pos:" + i3 + " fromUserClick:" + z16);
        this$0.Fb(i3);
        com.tencent.mobileqq.wink.report.a aVar = com.tencent.mobileqq.wink.report.a.f326259a;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_CATEGORY_NAME, tabTitles[i3]));
        aVar.a(WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_CATEGORY_NEW, "ev_xsj_abnormal_clck", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE, mapOf);
    }

    private final void tb() {
        Ya().P1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.aj
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorMusicMenuPartV2.ub(WinkEditorMusicMenuPartV2.this, (x.UpdateTemplateAction) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ub(WinkEditorMusicMenuPartV2 this$0, x.UpdateTemplateAction updateTemplateAction) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (updateTemplateAction == null) {
            return;
        }
        if (this$0.H9() != null) {
            dr H9 = this$0.H9();
            Intrinsics.checkNotNull(H9);
            if (com.tencent.videocut.render.extension.e.u(H9.g0())) {
                z16 = true;
                if (TextUtils.isEmpty(updateTemplateAction.getTemplatePath())) {
                    if (z16) {
                        this$0.Xa().S1(0.0f, MusicVolumeControlViewModel.VolumeType.ORIGIN);
                    } else {
                        this$0.Xa().Q1(this$0.Xa().d2());
                    }
                    this$0.Xa().H2(!z16);
                    this$0.Xa().K2(true);
                    this$0.Xa().S1(this$0.Xa().Z1(), MusicVolumeControlViewModel.VolumeType.TEMPLATE);
                    return;
                }
                if (!z16) {
                    this$0.Xa().Q1(this$0.Xa().d2());
                    this$0.Xa().H2(true);
                }
                this$0.Xa().K2(false);
                return;
            }
        }
        z16 = false;
        if (TextUtils.isEmpty(updateTemplateAction.getTemplatePath())) {
        }
    }

    private final void vb(View rootView) {
        View findViewById = rootView.findViewById(R.id.f123807hn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Co\u2026R.id.wink_music_panel_ll)");
        this.winkMusicPanelLl = (ConstraintLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f123697hc);
        ImageView imageView = (ImageView) findViewById2;
        imageView.setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById<Im\u2026kEditorMusicMenuPartV2) }");
        this.winkMusicLibraryIv = imageView;
        View findViewById3 = rootView.findViewById(R.id.f123707hd);
        TextView textView = (TextView) findViewById3;
        textView.setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById<Te\u2026kEditorMusicMenuPartV2) }");
        this.winkMusicLibraryTv = textView;
        View findViewById4 = rootView.findViewById(R.id.f123827hp);
        ImageView imageView2 = (ImageView) findViewById4;
        imageView2.setOnClickListener(this);
        com.tencent.mobileqq.wink.report.a aVar = com.tencent.mobileqq.wink.report.a.f326259a;
        Intrinsics.checkNotNullExpressionValue(imageView2, "this");
        com.tencent.mobileqq.wink.report.a.d(aVar, imageView2, WinkDaTongReportConstant.ElementId.EM_XSJ_SOUND_SEARCH_ENTRANCE_BUTTON, null, null, null, null, null, 124, null);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById<Im\u2026      )\n                }");
        this.winkMusicSearchIv = imageView2;
        View findViewById5 = rootView.findViewById(R.id.f123837hq);
        TextView textView2 = (TextView) findViewById5;
        textView2.setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(textView2, "this");
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        com.tencent.mobileqq.wink.report.a.d(aVar, textView2, WinkDaTongReportConstant.ElementId.EM_XSJ_SOUND_SEARCH_ENTRANCE_BUTTON, null, exposurePolicy, null, null, null, 116, null);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById<Te\u2026      )\n                }");
        this.winkMusicSearchTv = textView2;
        View findViewById6 = rootView.findViewById(R.id.f123787hl);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026ic_panel_bottom_sheet_cl)");
        Tb((ConstraintLayout) findViewById6);
        View findViewById7 = rootView.findViewById(R.id.f123767hj);
        QUICheckBox qUICheckBox = (QUICheckBox) findViewById7;
        qUICheckBox.setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById<QU\u2026kEditorMusicMenuPartV2) }");
        this.winkMusicOriginVoiceIv = qUICheckBox;
        View findViewById8 = rootView.findViewById(R.id.f123777hk);
        TextView textView3 = (TextView) findViewById8;
        textView3.setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById<Te\u2026kEditorMusicMenuPartV2) }");
        this.winkMusicOriginVoiceTv = textView3;
        View findViewById9 = rootView.findViewById(R.id.f123747hh);
        QUICheckBox qUICheckBox2 = (QUICheckBox) findViewById9;
        qUICheckBox2.setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "rootView.findViewById<QU\u2026kEditorMusicMenuPartV2) }");
        this.winkMusicMusicVoiceIv = qUICheckBox2;
        View findViewById10 = rootView.findViewById(R.id.f123757hi);
        TextView textView4 = (TextView) findViewById10;
        textView4.setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "rootView.findViewById<Te\u2026kEditorMusicMenuPartV2) }");
        this.winkMusicMusicVoiceTv = textView4;
        View findViewById11 = rootView.findViewById(R.id.f123727hf);
        ImageView imageView3 = (ImageView) findViewById11;
        imageView3.setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "rootView.findViewById<Im\u2026kEditorMusicMenuPartV2) }");
        this.winkMusicLyricIv = imageView3;
        View findViewById12 = rootView.findViewById(R.id.f123737hg);
        TextView textView5 = (TextView) findViewById12;
        textView5.setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "rootView.findViewById<Te\u2026kEditorMusicMenuPartV2) }");
        this.winkMusicLyricTv = textView5;
        View findViewById13 = rootView.findViewById(R.id.f123847hr);
        ImageView imageView4 = (ImageView) findViewById13;
        imageView4.setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(imageView4, "this");
        com.tencent.mobileqq.wink.report.a.d(aVar, imageView4, WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_VOLUME_BUTTON, null, exposurePolicy, null, null, null, 116, null);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "rootView.findViewById<Im\u2026      )\n                }");
        this.winkMusicVolumeIv = imageView4;
        View findViewById14 = rootView.findViewById(R.id.f123857hs);
        TextView textView6 = (TextView) findViewById14;
        textView6.setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(textView6, "this");
        com.tencent.mobileqq.wink.report.a.d(aVar, textView6, WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_VOLUME_BUTTON, null, exposurePolicy, null, null, null, 116, null);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "rootView.findViewById<Te\u2026       )                }");
        this.winkMusicVolumeTv = textView6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wb(WinkEditorMusicMenuPartV2 this$0, MusicInfoWrapper musicInfoWrapper) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.f(this$0.getTAG(), "[observe] bgmSourceLiveData:" + musicInfoWrapper);
        if (this$0.H9() instanceof WinkVideoTavCut) {
            dr H9 = this$0.H9();
            Intrinsics.checkNotNull(H9);
            H9.play();
        }
        this$0.Zb(musicInfoWrapper, this$0.G9().getEditMode());
        this$0.Yb(musicInfoWrapper.getMusicInfo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xb(WinkEditorMusicMenuPartV2 this$0, ax axVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.f(this$0.getTAG(), "[observe] curCategoryLiveData:" + axVar);
        if (Intrinsics.areEqual(axVar, ax.f320779f)) {
            this$0.eb().setCurrentItem(1, false);
        } else {
            this$0.eb().setCurrentItem(0, false);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.zjs;
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void J9(@NotNull WinkEditorViewModel.EditMode editMode) {
        Intrinsics.checkNotNullParameter(editMode, "editMode");
        super.J9(editMode);
        if (this.winkMusicPanelBottomSheetCl != null) {
            if (editMode == WinkEditorViewModel.EditMode.Image) {
                fb().setVisibility(8);
            } else {
                fb().setVisibility(0);
            }
        }
        Wa().o4(editMode);
        WinkMusicListPageAdapter winkMusicListPageAdapter = this.musicListPageAdapter;
        if (winkMusicListPageAdapter != null) {
            winkMusicListPageAdapter.i(editMode);
        }
        if (!this.isTavCutInit && (H9() instanceof WinkVideoTavCut)) {
            this.isTavCutInit = true;
        }
        cc(editMode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Kb() {
        w53.b.f(getTAG(), "retryRequestMusic... isTavCutInit:" + this.isTavCutInit + " getCategoryMusicListFail:" + Wa().getGetCategoryMusicListFail());
        if (this.isTavCutInit && H9() != null && Wa().getGetCategoryMusicListFail()) {
            com.tencent.mobileqq.wink.editor.recommend.b gb5 = gb();
            dr H9 = H9();
            Intrinsics.checkNotNull(H9);
            List<MediaClip> g06 = H9.g0();
            boolean isAllImages = G9().getIsAllImages();
            dr H92 = H9();
            Intrinsics.checkNotNull(H92);
            gb5.M1(g06, isAllImages, H92.getDurationUs());
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void L9(@Nullable Bundle args) {
        super.L9(args);
        w53.b.f(getTAG(), "onShow...");
        com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar = this.mMusicPlayerViewModel;
        if (aVar != null) {
            aVar.O1();
        }
        cc(Wa().getEditMode());
        Xa().P1();
        ConstraintLayout constraintLayout = this.winkMusicPanelLl;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkMusicPanelLl");
            constraintLayout = null;
        }
        Jb(constraintLayout, true);
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void N9(@Nullable WinkEditUIData data) {
        super.N9(data);
        if (data instanceof WinkMusicUIData) {
            O9(data);
            WinkMusicUIData winkMusicUIData = (WinkMusicUIData) data;
            Xa().F2(winkMusicUIData.getMediaClipVolumes());
            boolean isChangedManually = winkMusicUIData.getIsChangedManually();
            Pair<Boolean, Boolean> originalVolumeEnable = winkMusicUIData.getOriginalVolumeEnable();
            if (originalVolumeEnable != null) {
                Xa().w2(originalVolumeEnable);
                if (isChangedManually && (originalVolumeEnable.getFirst().booleanValue() || originalVolumeEnable.getSecond().booleanValue())) {
                    Xa().N2(Xa().j2(winkMusicUIData.getMediaClipVolumes()));
                }
            }
            Xa().L2(winkMusicUIData.getBGMVolume());
            Xa().J2(isChangedManually);
            Xa().x2(isChangedManually);
            boolean z16 = winkMusicUIData.getBoolean(WinkMusicUIData.IS_MUSIC_CLEARED, false);
            w53.b.a(getTAG(), "isMusicCleared restored " + z16);
            if (z16) {
                Wa().y2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Ob(@Nullable WinkMusicListPageAdapter winkMusicListPageAdapter) {
        this.musicListPageAdapter = winkMusicListPageAdapter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Qb(boolean enable) {
        w53.b.f(getTAG(), "setOriginVoiceCheckBoxEnable enable:" + enable);
        TextView textView = null;
        if (enable) {
            QUICheckBox qUICheckBox = this.winkMusicOriginVoiceIv;
            if (qUICheckBox == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkMusicOriginVoiceIv");
                qUICheckBox = null;
            }
            qUICheckBox.setVisibility(0);
            TextView textView2 = this.winkMusicOriginVoiceTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkMusicOriginVoiceTv");
            } else {
                textView = textView2;
            }
            textView.setVisibility(0);
            return;
        }
        QUICheckBox qUICheckBox2 = this.winkMusicOriginVoiceIv;
        if (qUICheckBox2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkMusicOriginVoiceIv");
            qUICheckBox2 = null;
        }
        qUICheckBox2.setVisibility(8);
        TextView textView3 = this.winkMusicOriginVoiceTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkMusicOriginVoiceTv");
        } else {
            textView = textView3;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Rb(@NotNull WinkMusicTab winkMusicTab) {
        Intrinsics.checkNotNullParameter(winkMusicTab, "<set-?>");
        this.tabLayout = winkMusicTab;
    }

    protected boolean Sa() {
        if (!yb() && !G9().getIsFromZShow() && !G9().getIsFromMagicStudio()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Sb(@NotNull ViewPager viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "<set-?>");
        this.viewPager = viewPager;
    }

    public final void Tb(@NotNull ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.winkMusicPanelBottomSheetCl = constraintLayout;
    }

    @Override // c73.a
    public void W(long durationUs) {
        if (Wa() != null && G9().getIsEnableMusic()) {
            Wa().z4(durationUs / 1000);
            if (getActivity() != null && getActivity().getIntent() != null && this.firstEnter) {
                this.firstEnter = false;
                Intent intent = getActivity().getIntent();
                Parcelable parcelableExtra = intent.getParcelableExtra(QQWinkConstants.MUSIC_INFO);
                if (parcelableExtra instanceof WinkEditorMusicInfo) {
                    w53.b.a(getTAG(), "updateDuration... music:" + parcelableExtra);
                    WinkEditorMusicInfo winkEditorMusicInfo = (WinkEditorMusicInfo) parcelableExtra;
                    int intExtra = intent.getIntExtra(QQWinkConstants.MUSIC_START_TIME, winkEditorMusicInfo.s());
                    MusicSourceViewModel Wa = Wa();
                    String p16 = winkEditorMusicInfo.p();
                    Intrinsics.checkNotNullExpressionValue(p16, "musicItemInfo.songMid");
                    Wa.a4(p16, intExtra, true);
                    Wa().y4(Integer.valueOf(intExtra));
                    MusicSourceViewModel.O3(Wa(), winkEditorMusicInfo, 0, false, false, 8, null);
                    float floatExtra = intent.getFloatExtra(QQWinkConstants.MUSIC_VOLUME, 1.0f);
                    Xa().D2(floatExtra);
                    Xa().y2(true, false);
                    Xa().S1(floatExtra, MusicVolumeControlViewModel.VolumeType.BGM);
                    Xa().H2(false);
                    this.hasEnterMusic = true;
                    return;
                }
                if (H9() instanceof WinkVideoTavCut) {
                    Intrinsics.checkNotNull((WinkVideoTavCut) H9());
                    Xa().H2(!r12.f2());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final MusicSourceViewModel Wa() {
        return (MusicSourceViewModel) this.mMusicSourceViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final MusicVolumeControlViewModel Xa() {
        return (MusicVolumeControlViewModel) this.mMusicVolumeControlViewModel.getValue();
    }

    @Override // c73.a
    public void Y2() {
        if (!this.hasAutoSavedUIDraft) {
            this.hasAutoSavedUIDraft = true;
            j1();
        }
    }

    public int Za() {
        if (this.mMusicMenuItem == null) {
            return 0;
        }
        if (Wa().getEditMode() != WinkEditorViewModel.EditMode.Image && !Sa()) {
            return 0;
        }
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: ab, reason: from getter */
    public final WinkMusicListPageAdapter getMusicListPageAdapter() {
        return this.musicListPageAdapter;
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    @NotNull
    public MenuType ba() {
        return MenuType.MUSIC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final WinkMusicTab bb() {
        WinkMusicTab winkMusicTab = this.tabLayout;
        if (winkMusicTab != null) {
            return winkMusicTab;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public ViewModelStoreOwner cb() {
        FragmentActivity activity = getHostFragment().getActivity();
        if (activity == null) {
            Fragment hostFragment = getHostFragment();
            Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
            return hostFragment;
        }
        return activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ViewPager eb() {
        ViewPager viewPager = this.viewPager;
        if (viewPager != null) {
            return viewPager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        return null;
    }

    @NotNull
    public final ConstraintLayout fb() {
        ConstraintLayout constraintLayout = this.winkMusicPanelBottomSheetCl;
        if (constraintLayout != null) {
            return constraintLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("winkMusicPanelBottomSheetCl");
        return null;
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(WinkMusicRetryRecommendRequestEvent.class);
        eventClass.add(WinkMusicLyricEvent.class);
        return eventClass;
    }

    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkEditorMusicMenuPartV2";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    @Deprecated(message = "Deprecated in Java")
    public void initAfterInflation(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.initAfterInflation(rootView);
        w53.b.f(getTAG(), "initAfterInflation");
        vb(rootView);
        rb(rootView);
        hb();
        qb(rootView);
        initViewModel();
        mb();
        Vb();
        Ib();
        if (H9() != null) {
            dr H9 = H9();
            Intrinsics.checkNotNull(H9);
            H9.F(this.sessionListener);
            dr H92 = H9();
            Intrinsics.checkNotNull(H92);
            W(H92.getDurationUs());
        }
    }

    @Override // c73.a
    public void j1() {
        w53.b.a(getTAG(), "start saveUiData");
        WinkMusicUIData winkMusicUIData = (WinkMusicUIData) getUiData();
        if (winkMusicUIData == null) {
            return;
        }
        winkMusicUIData.saveBGMVolume(Float.valueOf(Xa().c2()));
        winkMusicUIData.saveOriginalVolumeEnable(Xa().W1());
        winkMusicUIData.saveOriginalVolumeSwitch(Xa().k2().getValue());
        winkMusicUIData.saveMediaClipVolumes(Xa().e2());
        winkMusicUIData.saveIsChangedManually(Boolean.valueOf(Xa().m2()));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (this.visible) {
            BottomSheetBehavior<View> bottomSheetBehavior = this.behavior;
            BottomSheetBehavior<View> bottomSheetBehavior2 = null;
            if (bottomSheetBehavior == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ComicCancelRedPointPopItemData.JSON_KEY_BEHAVIOR);
                bottomSheetBehavior = null;
            }
            if (bottomSheetBehavior.getState() == 3) {
                BottomSheetBehavior<View> bottomSheetBehavior3 = this.behavior;
                if (bottomSheetBehavior3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ComicCancelRedPointPopItemData.JSON_KEY_BEHAVIOR);
                } else {
                    bottomSheetBehavior2 = bottomSheetBehavior3;
                }
                bottomSheetBehavior2.setState(4);
                return true;
            }
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        boolean z16;
        boolean z17;
        boolean z18;
        EventCollector.getInstance().onViewClickedBefore(v3);
        QUICheckBox qUICheckBox = null;
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.f123767hj) {
            String tag = getTAG();
            QUICheckBox qUICheckBox2 = this.winkMusicOriginVoiceIv;
            if (qUICheckBox2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkMusicOriginVoiceIv");
            } else {
                qUICheckBox = qUICheckBox2;
            }
            w53.b.a(tag, "[setOnClickListener] iv originVoiceIv isChecked to " + qUICheckBox.isChecked());
            bc();
        } else {
            boolean z19 = true;
            if (num != null && num.intValue() == R.id.f123777hk) {
                QUICheckBox qUICheckBox3 = this.winkMusicOriginVoiceIv;
                if (qUICheckBox3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkMusicOriginVoiceIv");
                    qUICheckBox3 = null;
                }
                QUICheckBox qUICheckBox4 = this.winkMusicOriginVoiceIv;
                if (qUICheckBox4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkMusicOriginVoiceIv");
                    qUICheckBox4 = null;
                }
                qUICheckBox3.setChecked(true ^ qUICheckBox4.isChecked());
                String tag2 = getTAG();
                QUICheckBox qUICheckBox5 = this.winkMusicOriginVoiceIv;
                if (qUICheckBox5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkMusicOriginVoiceIv");
                } else {
                    qUICheckBox = qUICheckBox5;
                }
                w53.b.a(tag2, "[setOnClickListener] tv originVoiceIv isChecked to " + qUICheckBox.isChecked());
                bc();
            } else if (num != null && num.intValue() == R.id.f123747hh) {
                String tag3 = getTAG();
                QUICheckBox qUICheckBox6 = this.winkMusicMusicVoiceIv;
                if (qUICheckBox6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkMusicMusicVoiceIv");
                } else {
                    qUICheckBox = qUICheckBox6;
                }
                w53.b.a(tag3, "[setOnClickListener] iv bgmVoiceIv isChecked to $" + qUICheckBox.isChecked());
                Bb();
            } else if (num != null && num.intValue() == R.id.f123757hi) {
                QUICheckBox qUICheckBox7 = this.winkMusicMusicVoiceIv;
                if (qUICheckBox7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkMusicMusicVoiceIv");
                    qUICheckBox7 = null;
                }
                QUICheckBox qUICheckBox8 = this.winkMusicMusicVoiceIv;
                if (qUICheckBox8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkMusicMusicVoiceIv");
                    qUICheckBox8 = null;
                }
                qUICheckBox7.setChecked(true ^ qUICheckBox8.isChecked());
                String tag4 = getTAG();
                QUICheckBox qUICheckBox9 = this.winkMusicMusicVoiceIv;
                if (qUICheckBox9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkMusicMusicVoiceIv");
                } else {
                    qUICheckBox = qUICheckBox9;
                }
                w53.b.a(tag4, "[setOnClickListener] tv bgmVoiceIv isChecked to $" + qUICheckBox.isChecked());
                Bb();
            } else {
                if ((num != null && num.intValue() == R.id.f123697hc) || (num != null && num.intValue() == R.id.f123707hd)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    Intent Va = Va();
                    Activity activity = getActivity();
                    if (activity != null) {
                        WinkEditorMusicHelper.J(activity, Va, Boolean.valueOf(Ab()));
                    }
                    Gb();
                    Hb(0);
                    com.tencent.mobileqq.wink.report.a.b(com.tencent.mobileqq.wink.report.a.f326259a, WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_LIBRARY, "ev_xsj_camera_action", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE, null, 8, null);
                } else {
                    if ((num != null && num.intValue() == R.id.f123827hp) || (num != null && num.intValue() == R.id.f123837hq)) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        Intent Va2 = Va();
                        Activity activity2 = getActivity();
                        if (activity2 != null) {
                            WinkEditorMusicHelper.K(activity2, Va2, Boolean.valueOf(Ab()));
                        }
                        Gb();
                        Hb(0);
                    } else {
                        if ((num != null && num.intValue() == R.id.f123727hf) || (num != null && num.intValue() == R.id.f123737hg)) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (z18) {
                            G9().u5(MenuType.LYRIC_STICKER, null);
                        } else {
                            if ((num == null || num.intValue() != R.id.f123847hr) && (num == null || num.intValue() != R.id.f123857hs)) {
                                z19 = false;
                            }
                            if (z19) {
                                G9().u5(MenuType.MUSIC_VOLUME, null);
                            }
                        }
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void onDismiss() {
        super.onDismiss();
        w53.b.f(getTAG(), "onDismiss...");
        com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar = this.mMusicPlayerViewModel;
        if (aVar != null) {
            aVar.P1();
        }
        ConstraintLayout constraintLayout = this.winkMusicPanelLl;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkMusicPanelLl");
            constraintLayout = null;
        }
        Jb(constraintLayout, false);
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        w53.b.f(getTAG(), "onInitView");
        O9(new WinkMusicUIData(this));
        WinkMusicButton winkMusicButton = (WinkMusicButton) rootView.findViewById(R.id.zjq);
        winkMusicButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.music.ar
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorMusicMenuPartV2.Cb(WinkEditorMusicMenuPartV2.this, view);
            }
        });
        winkMusicButton.setCloseButtonListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.music.as
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorMusicMenuPartV2.Db(WinkEditorMusicMenuPartV2.this, view);
            }
        });
        this.mMusicMenuItem = winkMusicButton;
        G9().f3().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.at
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorMusicMenuPartV2.Eb(WinkEditorMusicMenuPartV2.this, (MenuSwitchAction) obj);
            }
        });
        tb();
        Oa();
        ib();
        kb();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        z93.b e16 = Wink.INSTANCE.e();
        if (e16 != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            e16.d(context);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        w53.b.f(getTAG(), "onPartDestroy...");
        try {
            activity.unregisterReceiver(this.mNetReceiver);
        } catch (Exception e16) {
            w53.b.g(getTAG(), "unregisterReceiver" + e16.getMessage());
        }
        super.onPartDestroy(activity);
        z93.b e17 = Wink.INSTANCE.e();
        if (e17 != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            e17.b(context);
        }
        this.musicListPageAdapter = null;
        if (this.viewPager != null) {
            eb().setAdapter(null);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof WinkMusicRetryRecommendRequestEvent) {
            Kb();
        } else if (simpleBaseEvent instanceof WinkMusicLyricEvent) {
            x9();
        }
    }

    protected void rb(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.kwk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.view_pager)");
        Sb((ViewPager) findViewById);
        FragmentManager childFragmentManager = getHostFragment().getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "hostFragment.childFragmentManager");
        this.musicListPageAdapter = new WinkMusicListPageAdapter(childFragmentManager, cb(), !Sa(), null, null, 24, null);
        eb().setAdapter(this.musicListPageAdapter);
        final String[] strArr = {"\u63a8\u8350", "\u6536\u85cf"};
        View findViewById2 = rootView.findViewById(R.id.j_o);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.tab_layout)");
        Rb((WinkMusicTab) findViewById2);
        bb().setTabData(strArr);
        bb().setViewPager(eb());
        bb().setTabChangeListener(new QUIPageTabBar.i() { // from class: com.tencent.mobileqq.wink.editor.music.aq
            @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.i
            public final void I0(int i3, boolean z16) {
                WinkEditorMusicMenuPartV2.sb(WinkEditorMusicMenuPartV2.this, strArr, i3, z16);
            }
        });
    }

    protected boolean yb() {
        List<MediaClip> list;
        MediaModel V;
        if (this.isTavCutInit) {
            dr H9 = H9();
            if (H9 != null && (V = H9.V()) != null) {
                list = V.videos;
            } else {
                list = null;
            }
            if (com.tencent.videocut.render.extension.e.u(list)) {
                return true;
            }
        }
        return false;
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/editor/music/WinkEditorMusicMenuPartV2$c", "Lcom/tencent/tavcut/core/session/ISessionListener;", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "newData", "", "duration", "mediaDuration", "", "onRenderDataChanged", "onRenderDataApplied", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements ISessionListener {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(long j3, WinkEditorMusicMenuPartV2 this$0, long j16) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (j3 <= 0) {
                this$0.W(j16);
            } else {
                this$0.W(j3);
            }
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataChanged(@NotNull LAKRenderModel newData, final long duration, final long mediaDuration) {
            Intrinsics.checkNotNullParameter(newData, "newData");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final WinkEditorMusicMenuPartV2 winkEditorMusicMenuPartV2 = WinkEditorMusicMenuPartV2.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.av
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorMusicMenuPartV2.c.b(mediaDuration, winkEditorMusicMenuPartV2, duration);
                }
            });
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataApplied() {
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void oa() {
    }
}
