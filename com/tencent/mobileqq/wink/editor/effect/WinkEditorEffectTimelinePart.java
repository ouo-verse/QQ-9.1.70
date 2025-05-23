package com.tencent.mobileqq.wink.editor.effect;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.clipping.TimelineViewModelV2;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.effectmask.EffectMaskContainer;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanel;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanelViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEventHandler;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timeline.SliderView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.ClipModel;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.TimeData;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackContainerView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackData;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.effect.EffectStatusManager;
import com.tencent.mobileqq.wink.editor.effect.WinkEditorEffectTimelinePart;
import com.tencent.mobileqq.wink.editor.effect.d;
import com.tencent.mobileqq.wink.editor.effect.model.WinkEffectCatType;
import com.tencent.mobileqq.wink.editor.effect.model.WinkEffectOpReportData;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.editor.template.x;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.session.ISessionListener;
import com.tencent.videocut.model.MediaClip;
import com.tenpay.sdk.util.UinConfigManager;
import e63.EffectMaskLocation;
import g63.CommonConfig;
import g63.LayoutConfig;
import g63.VideoTrackConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import m63.a;
import m63.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00aa\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00b8\u00012\u00020\u00012\u00020\u0002:\u0002\u00b9\u0001B\t\u00a2\u0006\u0006\b\u00b6\u0001\u0010\u00b7\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J6\u0010\u0015\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00140\u0013\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0002J\b\u0010\u0017\u001a\u00020\u0003H\u0002J\b\u0010\u0018\u001a\u00020\nH\u0002J\b\u0010\u0019\u001a\u00020\u0003H\u0002J\u0012\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u0014H\u0002J\b\u0010\u001c\u001a\u00020\u0003H\u0002J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\u0003H\u0002J\b\u0010!\u001a\u00020\u0003H\u0002J0\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000&\"\u0004\b\u0000\u0010\"2\u0006\u0010#\u001a\u00020\u00122\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030$H\u0002J\b\u0010(\u001a\u00020\u0003H\u0003J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\bH\u0003J$\u0010/\u001a\u00020\u00032\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u00112\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u0011H\u0003J\u0010\u00101\u001a\u00020\u00032\u0006\u00100\u001a\u00020\bH\u0002J\u0018\u00104\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\nH\u0002J\b\u00105\u001a\u00020\u0003H\u0016J\u0010\u00108\u001a\u00020\u00032\u0006\u00107\u001a\u000206H\u0016J\b\u00109\u001a\u00020\u0003H\u0014J\b\u0010:\u001a\u00020\u0003H\u0014J\u0012\u0010=\u001a\u00020\u00032\b\u0010<\u001a\u0004\u0018\u00010;H\u0014J\u0010\u0010>\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010@\u001a\u00020?H\u0016J\b\u0010A\u001a\u00020\u0003H\u0016J\b\u0010B\u001a\u00020\u0014H\u0016J\u0010\u0010E\u001a\u00020\u00032\u0006\u0010D\u001a\u00020CH\u0016J\u0010\u0010H\u001a\u00020\u00032\u0006\u0010G\u001a\u00020FH\u0016J\b\u0010I\u001a\u00020\nH\u0016R\u0016\u0010L\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010R\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010OR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010Z\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010OR\u0018\u0010]\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\\R\u0018\u0010_\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010WR\u0018\u0010a\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010OR\u0018\u0010c\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010\\R\u0018\u0010f\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010j\u001a\u00020g8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010n\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010r\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010u\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010w\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010lR\u0016\u0010y\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010lR\u0016\u0010{\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010KR\u0016\u0010\u007f\u001a\u00020|8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b}\u0010~R\u001a\u0010\u0083\u0001\u001a\u00030\u0080\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001c\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001c\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001c\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001a\u0010\u0091\u0001\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0090\u0001\u0010\\R\u001a\u0010\u0093\u0001\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0092\u0001\u0010\\R\u001c\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001a\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0098\u0001\u0010eR\u001c\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R!\u0010\u00a2\u0001\u001a\n\u0012\u0005\u0012\u00030\u009f\u00010\u009e\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a0\u0001\u0010\u00a1\u0001R \u0010\u00a4\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0\u009e\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a3\u0001\u0010\u00a1\u0001R+\u0010\u00a9\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00030\u00a6\u00010\u00a5\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a7\u0001\u0010\u00a8\u0001R\u001c\u0010\u00ad\u0001\u001a\u0005\u0018\u00010\u00aa\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ab\u0001\u0010\u00ac\u0001R\u0018\u0010\u00b1\u0001\u001a\u00030\u00ae\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00af\u0001\u0010\u00b0\u0001R\u0018\u0010\u00b5\u0001\u001a\u00030\u00b2\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b3\u0001\u0010\u00b4\u0001\u00a8\u0006\u00ba\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/effect/WinkEditorEffectTimelinePart;", "Lcom/tencent/mobileqq/wink/editor/menu/WinkEditorMenuPart;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/h;", "", "initViewModel", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Ib", "", "currentPlayingTime", "", "isLast", "Yb", "Hb", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Lkotlin/Pair;", "", "", "Lkotlin/Triple;", "", "jb", "lb", "Cb", "Lb", "yb", "startMargin", "Wb", "Vb", "Lcom/tencent/mobileqq/wink/editor/effect/model/WinkEffectCatType;", "type", "Tb", "Bb", "kb", "T", "actionName", "Lkotlin/Function1;", "action", "Landroidx/lifecycle/Observer;", UinConfigManager.KEY_HB, "ob", "duration", "Qb", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/a;", "videoTrackModelList", "", "transitionModelList", "Rb", "time", "Pb", "view", "clickable", "Sb", "M9", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editMode", "J9", "onDismiss", "ma", "Landroid/os/Bundle;", "args", "L9", "initAfterInflation", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "ba", "oa", "B9", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/event/g;", "event", "Jc", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "onBackEvent", "M", "I", "timelineMenuHeight", "Landroid/widget/ImageView;", "N", "Landroid/widget/ImageView;", "playerStatusBtn", "P", "cancelBtn", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "confirmBtn", "Landroidx/constraintlayout/widget/ConstraintLayout;", BdhLogUtil.LogTag.Tag_Req, "Landroidx/constraintlayout/widget/ConstraintLayout;", "catScreenBtn", ExifInterface.LATITUDE_SOUTH, "catScreenLogo", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "catScreenContent", "U", "catFaceBtn", "V", "catFaceLogo", "W", "catFaceContent", "X", "Landroid/view/View;", "catFaceRedDot", "Lcom/tencent/mobileqq/wink/editor/effect/d;", "Y", "Lcom/tencent/mobileqq/wink/editor/effect/d;", "effectMaterialMvp", "Lcom/tencent/mobileqq/wink/editor/clipping/TimelineViewModelV2;", "Z", "Lcom/tencent/mobileqq/wink/editor/clipping/TimelineViewModelV2;", "timelineViewModel", "Lm63/d;", "a0", "Lm63/d;", "effectViewModel", "b0", "J", "nowTimeProgress", "c0", "needRefreshSourceDuration", "d0", "needRefreshVideoTrack", "e0", "mCurrentTabPos", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView;", "f0", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView;", "videoTrack", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/EffectMaskContainer;", "g0", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/EffectMaskContainer;", "effectMask", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanelViewController;", "h0", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanelViewController;", "panelController", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/l;", "i0", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/l;", "videoTrackController", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/a;", "j0", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/a;", "timelineMaskController", "k0", "timeText", "l0", "timeDurationText", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanel;", "m0", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanel;", "timelinePanel", "n0", "timelinePanelOpInterceptorView", "Landroid/view/ViewGroup;", "o0", "Landroid/view/ViewGroup;", "undoBtn", "Ljava/util/ArrayList;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "p0", "Ljava/util/ArrayList;", "mEffectCategories", "q0", "mEffectMaterials", "Ljava/util/HashMap;", "Lkotlin/Function0;", "r0", "Ljava/util/HashMap;", "onShowDelayActions", "Landroid/app/Dialog;", "s0", "Landroid/app/Dialog;", "interceptGoBackDialog", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "t0", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "playerListener", "Lcom/tencent/tavcut/core/session/ISessionListener;", "u0", "Lcom/tencent/tavcut/core/session/ISessionListener;", "renderListener", "<init>", "()V", "v0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorEffectTimelinePart extends WinkEditorMenuPart implements com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.h {

    /* renamed from: M, reason: from kotlin metadata */
    private int timelineMenuHeight;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private ImageView playerStatusBtn;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private ImageView cancelBtn;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private ImageView confirmBtn;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private ConstraintLayout catScreenBtn;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private ImageView catScreenLogo;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private TextView catScreenContent;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private ConstraintLayout catFaceBtn;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private ImageView catFaceLogo;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private TextView catFaceContent;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private View catFaceRedDot;

    /* renamed from: Y, reason: from kotlin metadata */
    private com.tencent.mobileqq.wink.editor.effect.d effectMaterialMvp;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private TimelineViewModelV2 timelineViewModel;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private m63.d effectViewModel;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private long nowTimeProgress;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private boolean needRefreshSourceDuration;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean needRefreshVideoTrack;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private VideoTrackContainerView videoTrack;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private EffectMaskContainer effectMask;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TimelinePanelViewController panelController;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l videoTrackController;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.clipping.timeline.widget.effectmask.a timelineMaskController;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView timeText;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView timeDurationText;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TimelinePanel timelinePanel;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View timelinePanelOpInterceptorView;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup undoBtn;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog interceptGoBackDialog;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private int mCurrentTabPos = -1;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<MetaCategory> mEffectCategories = new ArrayList<>();

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<MetaMaterial> mEffectMaterials = new ArrayList<>();

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, Function0<Unit>> onShowDelayActions = new HashMap<>();

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IPlayer.PlayerListener playerListener = new e();

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ISessionListener renderListener = new f();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f320031a;

        static {
            int[] iArr = new int[WinkEffectCatType.values().length];
            try {
                iArr[WinkEffectCatType.TypeScreen.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WinkEffectCatType.TypeFace.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f320031a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/effect/WinkEditorEffectTimelinePart$c", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "Lkotlin/Pair;", "", "d", "Lkotlin/Pair;", "currentSize", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Pair<Integer, Integer> currentSize;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f320033e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ WinkEditorEffectTimelinePart f320034f;

        c(View view, WinkEditorEffectTimelinePart winkEditorEffectTimelinePart) {
            this.f320033e = view;
            this.f320034f = winkEditorEffectTimelinePart;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Pair<Integer, Integer> pair = TuplesKt.to(Integer.valueOf(this.f320033e.getRootView().getMeasuredWidth()), Integer.valueOf(this.f320033e.getRootView().getMeasuredHeight()));
            if (!Intrinsics.areEqual(pair, this.currentSize) && pair.getFirst().intValue() > 0 && pair.getSecond().intValue() > 0) {
                this.currentSize = pair;
                this.f320034f.Wb(pair.getFirst().intValue() / 2);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010\f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wink/editor/effect/WinkEditorEffectTimelinePart$d", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/effectmask/EffectMaskContainer$b;", "Le63/a;", "effectData", "", "b", "", "isLeftSlider", "c", "d", "a", "Z", "playingOnEditStart", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements EffectMaskContainer.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean playingOnEditStart;

        d() {
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.effectmask.EffectMaskContainer.b
        public void a(@Nullable EffectMaskLocation effectData, boolean isLeftSlider) {
            dr H9;
            if (effectData != null) {
                m63.d dVar = WinkEditorEffectTimelinePart.this.effectViewModel;
                if (dVar != null) {
                    long j3 = 1000;
                    dVar.x2(effectData.getStartPositionMs() * j3, j3 * effectData.getStopPositionMs(), isLeftSlider);
                }
                if (this.playingOnEditStart && (H9 = WinkEditorEffectTimelinePart.this.H9()) != null) {
                    H9.play();
                }
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.effectmask.EffectMaskContainer.b
        public void b(@Nullable EffectMaskLocation effectData) {
            long j3;
            TimelineViewModelV2 timelineViewModelV2;
            if (effectData != null) {
                TimelineViewModelV2 timelineViewModelV22 = WinkEditorEffectTimelinePart.this.timelineViewModel;
                if (timelineViewModelV22 != null) {
                    j3 = timelineViewModelV22.b2();
                } else {
                    j3 = 0;
                }
                long j16 = 1000;
                long startPositionMs = (effectData.getStartPositionMs() * j16) + 33333;
                if (j3 < effectData.getStartPositionMs() * j16) {
                    TimelineViewModelV2 timelineViewModelV23 = WinkEditorEffectTimelinePart.this.timelineViewModel;
                    if (timelineViewModelV23 != null) {
                        TimelineViewModelV2.g3(timelineViewModelV23, startPositionMs, false, false, 6, null);
                    }
                } else if (j3 > effectData.getStopPositionMs() * j16 && (timelineViewModelV2 = WinkEditorEffectTimelinePart.this.timelineViewModel) != null) {
                    TimelineViewModelV2.g3(timelineViewModelV2, startPositionMs, false, false, 6, null);
                }
                EffectMaskContainer effectMaskContainer = WinkEditorEffectTimelinePart.this.effectMask;
                if (effectMaskContainer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("effectMask");
                    effectMaskContainer = null;
                }
                effectMaskContainer.w(effectData.getAppliedEffect().getId());
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.effectmask.EffectMaskContainer.b
        public void c(@Nullable EffectMaskLocation effectData, boolean isLeftSlider) {
            SliderView D;
            if (effectData == null) {
                return;
            }
            com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
            EffectMaskContainer effectMaskContainer = null;
            if (isLeftSlider) {
                EffectMaskContainer effectMaskContainer2 = WinkEditorEffectTimelinePart.this.effectMask;
                if (effectMaskContainer2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("effectMask");
                } else {
                    effectMaskContainer = effectMaskContainer2;
                }
                D = effectMaskContainer.C();
            } else {
                EffectMaskContainer effectMaskContainer3 = WinkEditorEffectTimelinePart.this.effectMask;
                if (effectMaskContainer3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("effectMask");
                } else {
                    effectMaskContainer = effectMaskContainer3;
                }
                D = effectMaskContainer.D();
            }
            SliderView sliderView = D;
            Map<String, ?> buildElementParams = WinkDTParamBuilder.buildElementParams();
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXIAO_NAME, effectData.getAppliedEffect().getMaterialId());
            Unit unit = Unit.INSTANCE;
            Map<String, ?> buildElementParams2 = WinkDTParamBuilder.buildElementParams();
            buildElementParams2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXIAO_NAME, effectData.getAppliedEffect().getMaterialId());
            eVar.q("ev_xsj_abnormal_clck", sliderView, WinkDaTongReportConstant.ElementId.EM_XSJ_TEXIAO_CHOICE_BOX, buildElementParams, buildElementParams2);
            dr H9 = WinkEditorEffectTimelinePart.this.H9();
            boolean z16 = false;
            if (H9 != null && H9.isPlaying()) {
                z16 = true;
            }
            this.playingOnEditStart = z16;
            dr H92 = WinkEditorEffectTimelinePart.this.H9();
            if (H92 != null) {
                H92.pause();
            }
            m63.d dVar = WinkEditorEffectTimelinePart.this.effectViewModel;
            if (dVar != null) {
                dVar.u2(effectData.getAppliedEffect());
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.effectmask.EffectMaskContainer.b
        public void d(@Nullable EffectMaskLocation effectData, boolean isLeftSlider) {
            long stopPositionMs;
            if (effectData == null) {
                return;
            }
            if (isLeftSlider) {
                stopPositionMs = effectData.getStartPositionMs();
            } else {
                stopPositionMs = effectData.getStopPositionMs();
            }
            TimelineViewModelV2 timelineViewModelV2 = WinkEditorEffectTimelinePart.this.timelineViewModel;
            if (timelineViewModelV2 != null) {
                TimelineViewModelV2.g3(timelineViewModelV2, 1000 * stopPositionMs, false, false, 6, null);
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wink/editor/effect/WinkEditorEffectTimelinePart$e", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerStatus;", "status", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "iPlayer", "", "onStatusChanged", "", "currentDurationUs", "playerDurationUs", "onPositionChanged", "onPlayerSourceReady", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements IPlayer.PlayerListener {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(IPlayer.PlayerStatus playerStatus, WinkEditorEffectTimelinePart this$0) {
            ImageView imageView;
            MutableLiveData<IPlayer.PlayerStatus> l26;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (playerStatus == IPlayer.PlayerStatus.PLAYING) {
                ImageView imageView2 = this$0.playerStatusBtn;
                if (imageView2 != null) {
                    imageView2.setImageResource(R.drawable.oqq);
                }
            } else if (playerStatus == IPlayer.PlayerStatus.PAUSED && (imageView = this$0.playerStatusBtn) != null) {
                imageView.setImageResource(R.drawable.oqs);
            }
            TimelineViewModelV2 timelineViewModelV2 = this$0.timelineViewModel;
            if (timelineViewModelV2 != null && (l26 = timelineViewModelV2.l2()) != null) {
                l26.postValue(playerStatus);
            }
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPlayerSourceReady(@NotNull IPlayer iPlayer) {
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPositionChanged(long currentDurationUs, long playerDurationUs) {
            MutableLiveData<Long> m26;
            TimelineViewModelV2 timelineViewModelV2 = WinkEditorEffectTimelinePart.this.timelineViewModel;
            if (timelineViewModelV2 != null && (m26 = timelineViewModelV2.m2()) != null) {
                m26.postValue(Long.valueOf(currentDurationUs));
            }
            WinkEditorEffectTimelinePart.this.nowTimeProgress = currentDurationUs;
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onStatusChanged(@Nullable final IPlayer.PlayerStatus status, @NotNull IPlayer iPlayer) {
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
            com.tencent.videocut.utils.thread.c cVar = com.tencent.videocut.utils.thread.c.f384289c;
            final WinkEditorEffectTimelinePart winkEditorEffectTimelinePart = WinkEditorEffectTimelinePart.this;
            cVar.e(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.effect.ab
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorEffectTimelinePart.e.b(IPlayer.PlayerStatus.this, winkEditorEffectTimelinePart);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ab(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Bb() {
        TimelineViewModelV2 timelineViewModelV2;
        dr H9 = H9();
        if (H9 != null && (timelineViewModelV2 = this.timelineViewModel) != null) {
            timelineViewModelV2.R2(H9, this.playerListener, this.renderListener);
        }
    }

    private final void Cb() {
        ImageView imageView = this.playerStatusBtn;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.effect.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorEffectTimelinePart.Gb(WinkEditorEffectTimelinePart.this, view);
                }
            });
        }
        ImageView imageView2 = this.cancelBtn;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.effect.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorEffectTimelinePart.Db(WinkEditorEffectTimelinePart.this, view);
                }
            });
        }
        ImageView imageView3 = this.confirmBtn;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.effect.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorEffectTimelinePart.Eb(WinkEditorEffectTimelinePart.this, view);
                }
            });
        }
        final com.tencent.mobileqq.wink.editor.util.c cVar = new com.tencent.mobileqq.wink.editor.util.c(300L);
        ViewGroup viewGroup = this.undoBtn;
        if (viewGroup != null && viewGroup != null) {
            viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.effect.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorEffectTimelinePart.Fb(com.tencent.mobileqq.wink.editor.util.c.this, this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Db(WinkEditorEffectTimelinePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        m63.d dVar = this$0.effectViewModel;
        if (dVar != null) {
            dVar.N1();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eb(WinkEditorEffectTimelinePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        m63.d dVar = this$0.effectViewModel;
        if (dVar != null) {
            dVar.P1();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fb(com.tencent.mobileqq.wink.editor.util.c debouncer, final WinkEditorEffectTimelinePart this$0, final View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(debouncer, "$debouncer");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        debouncer.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.effect.WinkEditorEffectTimelinePart$initTopBar$4$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                m63.d dVar = WinkEditorEffectTimelinePart.this.effectViewModel;
                if (dVar != null) {
                    dVar.z2();
                }
                com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
                View it = view;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                com.tencent.mobileqq.wink.report.e.k(eVar, it, WinkDaTongReportConstant.ElementId.EM_XSJ_TEXIAO_BACKOUT_BUTTON, WinkDTParamBuilder.buildElementParams(), null, 8, null);
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gb(WinkEditorEffectTimelinePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dr H9 = this$0.H9();
        boolean z16 = true;
        if (H9 != null) {
            H9.setLoopPlay(true);
        }
        TimelineViewModelV2 timelineViewModelV2 = this$0.timelineViewModel;
        if (timelineViewModelV2 == null || !timelineViewModelV2.W2()) {
            z16 = false;
        }
        if (z16) {
            TimelineViewModelV2 timelineViewModelV22 = this$0.timelineViewModel;
            if (timelineViewModelV22 != null) {
                timelineViewModelV22.b3();
            }
        } else {
            TimelineViewModelV2 timelineViewModelV23 = this$0.timelineViewModel;
            if (timelineViewModelV23 != null) {
                timelineViewModelV23.c3();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Hb() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        VideoTrackContainerView videoTrackContainerView = new VideoTrackContainerView(context, null, 0, 0, 14, null);
        com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l lVar = this.videoTrackController;
        if (lVar != null) {
            lVar.x(videoTrackContainerView);
        }
        com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, eVar.a(54.0f));
        layoutParams.topMargin = eVar.a(7.0f);
        videoTrackContainerView.setLayoutParams(layoutParams);
        this.videoTrack = videoTrackContainerView;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        EffectMaskContainer effectMaskContainer = new EffectMaskContainer(context2, null, 0, 6, null);
        com.tencent.mobileqq.wink.editor.clipping.timeline.widget.effectmask.a aVar = this.timelineMaskController;
        if (aVar != null) {
            aVar.g(effectMaskContainer);
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, eVar.a(58.0f));
        layoutParams2.topMargin = eVar.a(-56.0f) - 1;
        effectMaskContainer.setLayoutParams(layoutParams2);
        effectMaskContainer.setEffectMaskContainerOp(new d());
        this.effectMask = effectMaskContainer;
    }

    private final void Ib(View rootView) {
        boolean z16;
        View view;
        this.timelinePanel = (TimelinePanel) rootView.findViewById(R.id.f1189275g);
        this.timelinePanelOpInterceptorView = rootView.findViewById(R.id.f11881756);
        this.playerStatusBtn = (ImageView) rootView.findViewById(R.id.xyv);
        this.cancelBtn = (ImageView) rootView.findViewById(R.id.xyi);
        this.confirmBtn = (ImageView) rootView.findViewById(R.id.xyk);
        this.timeText = (TextView) rootView.findViewById(R.id.kbp);
        this.timeDurationText = (TextView) rootView.findViewById(R.id.f111886mf);
        this.undoBtn = (ViewGroup) rootView.findViewById(R.id.urq);
        View findViewById = rootView.findViewById(R.id.f99025oo);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.tlEffectCategory)");
        TabLayoutCompat tabLayoutCompat = (TabLayoutCompat) findViewById;
        this.catScreenBtn = (ConstraintLayout) rootView.findViewById(R.id.f164806tx1);
        this.catScreenLogo = (ImageView) rootView.findViewById(R.id.xyy);
        this.catScreenContent = (TextView) rootView.findViewById(R.id.f1055566b);
        this.catFaceBtn = (ConstraintLayout) rootView.findViewById(R.id.f164805tx0);
        this.catFaceLogo = (ImageView) rootView.findViewById(R.id.xyp);
        this.catFaceContent = (TextView) rootView.findViewById(R.id.f1052365g);
        this.catFaceRedDot = rootView.findViewById(R.id.f115936xd);
        m63.d dVar = this.effectViewModel;
        if (dVar != null && dVar.m2()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (view = this.catFaceRedDot) != null) {
            view.setVisibility(0);
        }
        View findViewById2 = rootView.findViewById(R.id.f789348e);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.rv_effect_list)");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.effectMaterialMvp = new com.tencent.mobileqq.wink.editor.effect.d(context, tabLayoutCompat, (RecyclerView) findViewById2, G9().getEditMode());
        Cb();
        yb();
        Hb();
        lb();
        rootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.wink.editor.effect.aa
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean Jb;
                Jb = WinkEditorEffectTimelinePart.Jb(view2, motionEvent);
                return Jb;
            }
        });
        rootView.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Jb(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kb(WinkEditorEffectTimelinePart this$0, x.UpdateTemplateAction updateTemplateAction) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        m63.d dVar = this$0.effectViewModel;
        if (dVar != null) {
            dVar.O1();
        }
    }

    private final boolean Lb() {
        if (this.interceptGoBackDialog != null) {
            return true;
        }
        QQCustomDialog negativeButton = DialogUtil.createCustomDialog(getActivity(), 230).setTitle(getContext().getString(R.string.f215985x3)).setPositiveButton(getContext().getString(R.string.f216445yb), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.effect.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkEditorEffectTimelinePart.Mb(WinkEditorEffectTimelinePart.this, dialogInterface, i3);
            }
        }).setNegativeButton(getContext().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.effect.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkEditorEffectTimelinePart.Nb(dialogInterface, i3);
            }
        });
        this.interceptGoBackDialog = negativeButton;
        if (negativeButton != null) {
            try {
                negativeButton.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.wink.editor.effect.j
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        WinkEditorEffectTimelinePart.Ob(WinkEditorEffectTimelinePart.this, dialogInterface);
                    }
                });
                if (!negativeButton.isShowing()) {
                    negativeButton.show();
                }
            } catch (Throwable th5) {
                ms.a.e("WinkEditorFragment", th5);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mb(WinkEditorEffectTimelinePart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        m63.d dVar = this$0.effectViewModel;
        if (dVar != null) {
            dVar.B2();
        }
        this$0.x9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ob(WinkEditorEffectTimelinePart this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.interceptGoBackDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Pb(long time) {
        EffectStatusManager.AppliedEffect appliedEffect;
        boolean z16;
        TimelinePanelViewController timelinePanelViewController;
        FlingHelper flingHelper;
        boolean z17 = true;
        QLog.d("Sticker TAG", 1, "current player time = " + time);
        m63.d dVar = this.effectViewModel;
        EffectMaskContainer effectMaskContainer = null;
        if (dVar != null) {
            appliedEffect = dVar.getEditingEffect();
        } else {
            appliedEffect = null;
        }
        if (appliedEffect == null) {
            TimelinePanelViewController timelinePanelViewController2 = this.panelController;
            if (timelinePanelViewController2 != null && timelinePanelViewController2.getIsUserTouching()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                TimelinePanelViewController timelinePanelViewController3 = this.panelController;
                if (timelinePanelViewController3 == null || (flingHelper = timelinePanelViewController3.getFlingHelper()) == null || !flingHelper.d()) {
                    z17 = false;
                }
                if (!z17 && (timelinePanelViewController = this.panelController) != null) {
                    timelinePanelViewController.a(timelinePanelViewController.getScaleCalculator().y(time));
                }
            }
        }
        EffectMaskContainer effectMaskContainer2 = this.effectMask;
        if (effectMaskContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectMask");
        } else {
            effectMaskContainer = effectMaskContainer2;
        }
        effectMaskContainer.x(time);
        TextView textView = this.timeText;
        if (textView != null) {
            textView.setText(com.tencent.mobileqq.wink.editor.music.a.c(time / 1000));
        }
        TextView textView2 = this.timeDurationText;
        if (textView2 != null) {
            TimelineViewModelV2 timelineViewModelV2 = this.timelineViewModel;
            Intrinsics.checkNotNull(timelineViewModelV2);
            textView2.setText(com.tencent.mobileqq.wink.editor.music.a.c(timelineViewModelV2.j2() / 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public final void Qb(long duration) {
        Long l3;
        long j3;
        MutableLiveData<Long> m26;
        TimelineViewModelV2 timelineViewModelV2 = this.timelineViewModel;
        if (timelineViewModelV2 != null) {
            long T1 = timelineViewModelV2.T1();
            TimelinePanelViewController timelinePanelViewController = this.panelController;
            if (timelinePanelViewController != null) {
                timelinePanelViewController.y(T1);
            }
        }
        TimelinePanelViewController timelinePanelViewController2 = this.panelController;
        if (timelinePanelViewController2 != null) {
            timelinePanelViewController2.C(duration);
        }
        TimelineViewModelV2 timelineViewModelV22 = this.timelineViewModel;
        EffectMaskContainer effectMaskContainer = null;
        if (timelineViewModelV22 != null && (m26 = timelineViewModelV22.m2()) != null) {
            l3 = m26.getValue();
        } else {
            l3 = null;
        }
        if (l3 != null) {
            TimelineViewModelV2 timelineViewModelV23 = this.timelineViewModel;
            Intrinsics.checkNotNull(timelineViewModelV23);
            Long value = timelineViewModelV23.m2().getValue();
            Intrinsics.checkNotNull(value);
            j3 = value.longValue();
        } else {
            j3 = 0;
        }
        QLog.i("Sticker TAG", 1, "video source duration changed, current player time = " + j3);
        TextView textView = this.timeText;
        if (textView != null) {
            textView.setText(com.tencent.mobileqq.wink.editor.music.a.c(j3 / 1000));
        }
        TextView textView2 = this.timeDurationText;
        if (textView2 != null) {
            textView2.setText(com.tencent.mobileqq.wink.editor.music.a.c(duration / 1000));
        }
        TimelinePanel timelinePanel = this.timelinePanel;
        if (timelinePanel != null) {
            timelinePanel.setEnableScale(false);
        }
        if (this.needRefreshSourceDuration) {
            VideoTrackContainerView videoTrackContainerView = this.videoTrack;
            if (videoTrackContainerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
                videoTrackContainerView = null;
            }
            videoTrackContainerView.e0(0L, duration);
            this.needRefreshSourceDuration = false;
        }
        EffectMaskContainer effectMaskContainer2 = this.effectMask;
        if (effectMaskContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectMask");
        } else {
            effectMaskContainer = effectMaskContainer2;
        }
        effectMaskContainer.setDurationUs(duration);
        m63.d dVar = this.effectViewModel;
        if (dVar != null) {
            dVar.o2(duration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public final void Rb(List<ClipModel> videoTrackModelList, List<Object> transitionModelList) {
        List<MediaClip> list;
        boolean z16;
        long j3;
        dr H9 = H9();
        VideoTrackContainerView videoTrackContainerView = null;
        if (H9 != null) {
            list = H9.a0();
        } else {
            list = null;
        }
        if (list != null && com.tencent.videocut.render.extension.e.u(list)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && list.size() >= 2) {
            ArrayList arrayList = new ArrayList(videoTrackModelList);
            int size = arrayList.size() - 1;
            int i3 = 0;
            while (i3 < size) {
                TimeData timeData = ((ClipModel) arrayList.get(i3)).getTimeData();
                int i16 = i3 + 1;
                TimeData timeData2 = ((ClipModel) arrayList.get(i16)).getTimeData();
                long l3 = (timeData.l() + timeData2.getTimelineStartTimeUs()) / 2;
                TimeData d16 = TimeData.d(timeData, 0L, l3 - timeData.getTimelineStartTimeUs(), 0L, 0L, 0L, 0L, 0L, 125, null);
                TimeData d17 = TimeData.d(timeData2, l3, timeData2.getTimelineDurationUs() - (l3 - timeData2.getTimelineStartTimeUs()), 0L, 0L, 0L, 0L, 0L, 124, null);
                Object obj = arrayList.get(i3);
                Intrinsics.checkNotNullExpressionValue(obj, "newVideoTrackModels[i]");
                arrayList.set(i3, ClipModel.b((ClipModel) obj, null, 0, null, d16, null, 23, null));
                Object obj2 = arrayList.get(i16);
                Intrinsics.checkNotNullExpressionValue(obj2, "newVideoTrackModels[i + 1]");
                arrayList.set(i16, ClipModel.b((ClipModel) obj2, null, 0, null, d17, null, 23, null));
                i3 = i16;
            }
            com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l lVar = this.videoTrackController;
            if (lVar != null) {
                lVar.K(arrayList, transitionModelList);
            }
        } else {
            com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l lVar2 = this.videoTrackController;
            if (lVar2 != null) {
                lVar2.K(videoTrackModelList, transitionModelList);
            }
        }
        if (this.needRefreshVideoTrack) {
            VideoTrackContainerView videoTrackContainerView2 = this.videoTrack;
            if (videoTrackContainerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
                videoTrackContainerView2 = null;
            }
            VideoTrackContainerView videoTrackContainerView3 = this.videoTrack;
            if (videoTrackContainerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
                videoTrackContainerView3 = null;
            }
            Pair<Long, Boolean> value = videoTrackContainerView3.F().getValue();
            long j16 = 0;
            if (value != null) {
                j3 = value.getFirst().longValue();
            } else {
                j3 = 0;
            }
            VideoTrackContainerView videoTrackContainerView4 = this.videoTrack;
            if (videoTrackContainerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
            } else {
                videoTrackContainerView = videoTrackContainerView4;
            }
            Pair<Long, Boolean> value2 = videoTrackContainerView.K().getValue();
            if (value2 != null) {
                j16 = value2.getFirst().longValue();
            }
            videoTrackContainerView2.e0(j3, j16);
            this.needRefreshVideoTrack = false;
        }
    }

    private final void Sb(View view, boolean clickable) {
        int i3;
        if (clickable) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    private final void Tb(WinkEffectCatType type) {
        m63.d dVar = this.effectViewModel;
        if (dVar != null) {
            dVar.y2(type);
        }
        com.tencent.mobileqq.wink.editor.model.b value = aa().getEffectMaterialVOLiveData().getValue();
        com.tencent.mobileqq.wink.editor.effect.d dVar2 = this.effectMaterialMvp;
        com.tencent.mobileqq.wink.editor.effect.d dVar3 = null;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectMaterialMvp");
            dVar2 = null;
        }
        dVar2.n(type, value);
        com.tencent.mobileqq.wink.editor.effect.d dVar4 = this.effectMaterialMvp;
        if (dVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectMaterialMvp");
        } else {
            dVar3 = dVar4;
        }
        dVar3.k(0);
        int i3 = b.f320031a[type.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                ImageView imageView = this.catScreenLogo;
                if (imageView != null) {
                    imageView.setAlpha(0.55f);
                }
                TextView textView = this.catScreenContent;
                if (textView != null) {
                    textView.setAlpha(0.55f);
                }
                ImageView imageView2 = this.catFaceLogo;
                if (imageView2 != null) {
                    imageView2.setAlpha(1.0f);
                }
                TextView textView2 = this.catFaceContent;
                if (textView2 != null) {
                    textView2.setAlpha(1.0f);
                    return;
                }
                return;
            }
            return;
        }
        ImageView imageView3 = this.catScreenLogo;
        if (imageView3 != null) {
            imageView3.setAlpha(1.0f);
        }
        TextView textView3 = this.catScreenContent;
        if (textView3 != null) {
            textView3.setAlpha(1.0f);
        }
        ImageView imageView4 = this.catFaceLogo;
        if (imageView4 != null) {
            imageView4.setAlpha(0.55f);
        }
        TextView textView4 = this.catFaceContent;
        if (textView4 != null) {
            textView4.setAlpha(0.55f);
        }
    }

    private final void Vb() {
        dr H9 = H9();
        if (this.effectViewModel == null && (H9 instanceof WinkVideoTavCut)) {
            try {
                m63.d dVar = (m63.d) getViewModel(m63.d.class);
                if (dVar != null) {
                    dVar.k2(new com.tencent.mobileqq.wink.editor.effect.b(H9));
                    dVar.s2();
                } else {
                    dVar = null;
                }
                this.effectViewModel = dVar;
            } catch (Exception e16) {
                w53.b.d(this.TAG, "effect onTavCutInit", e16);
            }
            if (this.effectViewModel == null) {
                ms.a.c("WinkEditorFragment", "effectViewModel init fail when onTavCutInit");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wb(int startMargin) {
        CommonConfig commonConfig = new CommonConfig(null, new LayoutConfig(startMargin, 0.0f, 0.0f, 68.0f, 0.0f, 0, 52, null), new VideoTrackConfig(54.0f, 54.0f, 54.0f, 0.0f, 0.0f, 0.0f, false, false, false, 304, null), null, 9, null);
        TimelinePanelViewController timelinePanelViewController = this.panelController;
        if (timelinePanelViewController != null) {
            timelinePanelViewController.w(commonConfig);
        }
        TimelinePanelViewController timelinePanelViewController2 = this.panelController;
        if (timelinePanelViewController2 != null) {
            timelinePanelViewController2.r();
        }
    }

    static /* synthetic */ void Xb(WinkEditorEffectTimelinePart winkEditorEffectTimelinePart, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = com.tencent.videocut.utils.o.g() / 2;
        }
        winkEditorEffectTimelinePart.Wb(i3);
    }

    private final void Yb(long currentPlayingTime, boolean isLast) {
        long j3;
        dr H9 = H9();
        if (H9 != null) {
            j3 = H9.getDurationUs();
        } else {
            j3 = 0;
        }
        if (currentPlayingTime > j3) {
            currentPlayingTime = j3;
        }
        TimelineViewModelV2 timelineViewModelV2 = this.timelineViewModel;
        if (timelineViewModelV2 != null) {
            TimelineViewModelV2.g3(timelineViewModelV2, currentPlayingTime, !isLast, false, 4, null);
        }
        this.nowTimeProgress = currentPlayingTime;
    }

    static /* synthetic */ void Zb(WinkEditorEffectTimelinePart winkEditorEffectTimelinePart, long j3, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        winkEditorEffectTimelinePart.Yb(j3, z16);
    }

    private final <T> Observer<T> hb(final String actionName, final Function1<? super T, Unit> action) {
        return new Observer() { // from class: com.tencent.mobileqq.wink.editor.effect.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorEffectTimelinePart.ib(WinkEditorEffectTimelinePart.this, actionName, action, obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ib(WinkEditorEffectTimelinePart this$0, String actionName, final Function1 action, final Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionName, "$actionName");
        Intrinsics.checkNotNullParameter(action, "$action");
        if (!this$0.visible) {
            this$0.onShowDelayActions.put(actionName, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.effect.WinkEditorEffectTimelinePart$executeSafely$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    action.invoke(obj);
                }
            });
        } else {
            action.invoke(obj);
        }
    }

    private final void initViewModel() {
        if (this.timelineViewModel == null) {
            this.timelineViewModel = (TimelineViewModelV2) new ViewModelProvider(getHostFragment()).get(TimelineViewModelV2.class);
        }
        if (this.effectViewModel == null) {
            m63.d dVar = (m63.d) getViewModel(m63.d.class);
            if (dVar != null) {
                dr H9 = H9();
                Intrinsics.checkNotNull(H9);
                dVar.k2(new com.tencent.mobileqq.wink.editor.effect.b(H9));
                dVar.s2();
            } else {
                dVar = null;
            }
            this.effectViewModel = dVar;
            if (dVar == null) {
                ms.a.c("WinkEditorFragment", "effectViewModel init fail when initViewModel");
            }
        }
        ((com.tencent.mobileqq.wink.editor.template.x) getViewModel(com.tencent.mobileqq.wink.editor.template.x.class)).P1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.effect.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorEffectTimelinePart.Kb(WinkEditorEffectTimelinePart.this, (x.UpdateTemplateAction) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<List<String>, Triple<String, String, Integer>> jb(MetaMaterial material) {
        Pair<List<String>, Triple<String, String, Integer>> o16 = l73.a.f413927a.o(material);
        if (o16 == null) {
            QQToast.makeText(getContext(), R.string.f239937nt, 0).show();
            String m3 = WinkEditorResourceManager.a1().m(material);
            Intrinsics.checkNotNullExpressionValue(m3, "getInstance().getDownloadFolder(material)");
            try {
                FileUtils.deleteDirectory(m3);
                com.tencent.mobileqq.wink.editor.c.s1(material, -1);
                return null;
            } catch (Exception e16) {
                w53.b.d(this.TAG, "getEffectInfos fail delete: " + m3, e16);
                return null;
            }
        }
        return o16;
    }

    private final void kb() {
        this.panelController = new TimelinePanelViewController();
        com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l lVar = new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l(com.tencent.mobileqq.wink.editor.clipping.thumbnail.o.f319264a);
        this.videoTrackController = lVar;
        TimelinePanelViewController timelinePanelViewController = this.panelController;
        if (timelinePanelViewController != null) {
            Intrinsics.checkNotNull(lVar);
            timelinePanelViewController.h(lVar);
        }
        com.tencent.mobileqq.wink.editor.clipping.timeline.widget.effectmask.a aVar = new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.effectmask.a();
        this.timelineMaskController = aVar;
        TimelinePanelViewController timelinePanelViewController2 = this.panelController;
        if (timelinePanelViewController2 != null) {
            Intrinsics.checkNotNull(aVar);
            timelinePanelViewController2.h(aVar);
        }
    }

    private final void lb() {
        ConstraintLayout constraintLayout = this.catScreenBtn;
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.effect.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorEffectTimelinePart.mb(WinkEditorEffectTimelinePart.this, view);
                }
            });
        }
        ConstraintLayout constraintLayout2 = this.catFaceBtn;
        if (constraintLayout2 != null) {
            constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.effect.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorEffectTimelinePart.nb(WinkEditorEffectTimelinePart.this, view);
                }
            });
        }
        com.tencent.mobileqq.wink.editor.effect.d dVar = this.effectMaterialMvp;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectMaterialMvp");
            dVar = null;
        }
        dVar.l(new d.b() { // from class: com.tencent.mobileqq.wink.editor.effect.WinkEditorEffectTimelinePart$initEffectList$3

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final com.tencent.mobileqq.wink.editor.util.c deBouncer = new com.tencent.mobileqq.wink.editor.util.c(300);

            @Override // com.tencent.mobileqq.wink.editor.effect.d.b
            public void a(int posX, int posY, int pos, @NotNull final MetaMaterial material) {
                Intrinsics.checkNotNullParameter(material, "material");
                com.tencent.mobileqq.wink.editor.util.c cVar = this.deBouncer;
                final WinkEditorEffectTimelinePart winkEditorEffectTimelinePart = WinkEditorEffectTimelinePart.this;
                cVar.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.effect.WinkEditorEffectTimelinePart$initEffectList$3$onItemClick$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:9:0x0014, code lost:
                    
                        r0 = r1.jb(r2);
                     */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void invoke2() {
                        TimelinePanelViewController timelinePanelViewController;
                        Pair jb5;
                        timelinePanelViewController = WinkEditorEffectTimelinePart.this.panelController;
                        boolean z16 = false;
                        if (timelinePanelViewController != null && timelinePanelViewController.getIsUserTouching()) {
                            z16 = true;
                        }
                        if (z16 || jb5 == null) {
                            return;
                        }
                        List<String> list = (List) jb5.component1();
                        Triple triple = (Triple) jb5.component2();
                        long e16 = l73.a.f413927a.e(material, 3000000L);
                        m63.d dVar2 = WinkEditorEffectTimelinePart.this.effectViewModel;
                        if (dVar2 != null) {
                            String str = material.f30533id;
                            Intrinsics.checkNotNullExpressionValue(str, "material.id");
                            String str2 = material.f30533id;
                            Intrinsics.checkNotNullExpressionValue(str2, "material.id");
                            dVar2.M1(str, str2, ((Number) triple.getThird()).intValue(), list, e16);
                        }
                    }
                });
            }

            /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
            
                r5 = r4.f320040b.jb(r6);
             */
            @Override // com.tencent.mobileqq.wink.editor.effect.d.b
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void b(int position, @Nullable MetaMaterial material) {
                ConstraintLayout constraintLayout3;
                ConstraintLayout constraintLayout4;
                Pair jb5;
                constraintLayout3 = WinkEditorEffectTimelinePart.this.catScreenBtn;
                if (constraintLayout3 != null) {
                    constraintLayout3.setEnabled(false);
                }
                constraintLayout4 = WinkEditorEffectTimelinePart.this.catFaceBtn;
                if (constraintLayout4 != null) {
                    constraintLayout4.setEnabled(false);
                }
                if (material == null || jb5 == null) {
                    return;
                }
                List<String> list = (List) jb5.component1();
                Triple triple = (Triple) jb5.component2();
                m63.d dVar2 = WinkEditorEffectTimelinePart.this.effectViewModel;
                if (dVar2 != null) {
                    String str = material.f30533id;
                    Intrinsics.checkNotNullExpressionValue(str, "material.id");
                    String str2 = material.f30533id;
                    Intrinsics.checkNotNullExpressionValue(str2, "material.id");
                    dVar2.t2(str, str2, ((Number) triple.getThird()).intValue(), list);
                }
            }

            @Override // com.tencent.mobileqq.wink.editor.effect.d.b
            public void c(@NotNull TabLayoutCompat.f tab) {
                Intrinsics.checkNotNullParameter(tab, "tab");
                m63.d dVar2 = WinkEditorEffectTimelinePart.this.effectViewModel;
                if (dVar2 != null) {
                    WinkEffectOpReportData reportData = dVar2.getReportData();
                    reportData.f(reportData.getEffectCatClickNum() + 1);
                }
            }

            @Override // com.tencent.mobileqq.wink.editor.effect.d.b
            public boolean d() {
                TimelinePanelViewController timelinePanelViewController;
                timelinePanelViewController = WinkEditorEffectTimelinePart.this.panelController;
                if (timelinePanelViewController == null || !timelinePanelViewController.getIsUserTouching()) {
                    return false;
                }
                return true;
            }

            @Override // com.tencent.mobileqq.wink.editor.effect.d.b
            public void e(int position, @Nullable MetaMaterial material) {
                ConstraintLayout constraintLayout3;
                ConstraintLayout constraintLayout4;
                constraintLayout3 = WinkEditorEffectTimelinePart.this.catScreenBtn;
                if (constraintLayout3 != null) {
                    constraintLayout3.setEnabled(true);
                }
                constraintLayout4 = WinkEditorEffectTimelinePart.this.catFaceBtn;
                if (constraintLayout4 != null) {
                    constraintLayout4.setEnabled(true);
                }
                m63.d dVar2 = WinkEditorEffectTimelinePart.this.effectViewModel;
                if (dVar2 != null) {
                    m63.d.w2(dVar2, 0L, 1, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mb(WinkEditorEffectTimelinePart this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Tb(WinkEffectCatType.TypeScreen);
        com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        com.tencent.mobileqq.wink.report.e.k(eVar, it, WinkDaTongReportConstant.ElementId.EM_XSJ_PICTURE_TEXIAO_TAB, null, null, 12, null);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void nb(WinkEditorEffectTimelinePart this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Tb(WinkEffectCatType.TypeFace);
        View view = this$0.catFaceRedDot;
        if (view != null) {
            view.setVisibility(8);
        }
        m63.d dVar = this$0.effectViewModel;
        if (dVar != null) {
            dVar.l2();
        }
        com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        com.tencent.mobileqq.wink.report.e.k(eVar, it, WinkDaTongReportConstant.ElementId.EM_XSJ_FIGURE_TEXIAO_TAB, null, null, 12, null);
        EventCollector.getInstance().onViewClicked(it);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private final void ob() {
        TimelineViewModelV2 timelineViewModelV2 = this.timelineViewModel;
        if (timelineViewModelV2 != null) {
            timelineViewModelV2.A2().observe(getHostFragment(), hb("duration", new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.wink.editor.effect.WinkEditorEffectTimelinePart$initObserver$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                    invoke2(l3);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Long it) {
                    WinkEditorEffectTimelinePart winkEditorEffectTimelinePart = WinkEditorEffectTimelinePart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    winkEditorEffectTimelinePart.Qb(it.longValue());
                }
            }));
            timelineViewModelV2.B2().observe(getHostFragment(), hb("videoTracks", new Function1<VideoTrackData, Unit>() { // from class: com.tencent.mobileqq.wink.editor.effect.WinkEditorEffectTimelinePart$initObserver$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(VideoTrackData videoTrackData) {
                    invoke2(videoTrackData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(VideoTrackData videoTrackData) {
                    WinkEditorEffectTimelinePart.this.Rb(videoTrackData.d(), videoTrackData.c());
                }
            }));
            timelineViewModelV2.m2().observe(getHostFragment(), hb(InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.wink.editor.effect.WinkEditorEffectTimelinePart$initObserver$1$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                    invoke2(l3);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Long it) {
                    WinkEditorEffectTimelinePart winkEditorEffectTimelinePart = WinkEditorEffectTimelinePart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    winkEditorEffectTimelinePart.Pb(it.longValue());
                }
            }));
        }
        final m63.d dVar = this.effectViewModel;
        if (dVar != null) {
            dVar.S1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.effect.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkEditorEffectTimelinePart.pb(WinkEditorEffectTimelinePart.this, dVar, (t73.a) obj);
                }
            });
            dVar.T1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.effect.q
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkEditorEffectTimelinePart.qb(WinkEditorEffectTimelinePart.this, (ArrayList) obj);
                }
            });
            dVar.j2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.effect.t
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkEditorEffectTimelinePart.rb(WinkEditorEffectTimelinePart.this, (Boolean) obj);
                }
            });
            dVar.h2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.effect.u
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkEditorEffectTimelinePart.sb((Boolean) obj);
                }
            });
            dVar.U1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.effect.v
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkEditorEffectTimelinePart.tb(WinkEditorEffectTimelinePart.this, (Boolean) obj);
                }
            });
            dVar.X1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.effect.w
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkEditorEffectTimelinePart.ub(WinkEditorEffectTimelinePart.this, (t73.a) obj);
                }
            });
            dVar.e2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.effect.x
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkEditorEffectTimelinePart.vb((WinkEffectCatType) obj);
                }
            });
            dVar.f2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.effect.y
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkEditorEffectTimelinePart.wb(WinkEditorEffectTimelinePart.this, (Long) obj);
                }
            });
        }
        LiveData<com.tencent.mobileqq.wink.editor.model.b> effectMaterialVOLiveData = aa().getEffectMaterialVOLiveData();
        if (effectMaterialVOLiveData != null) {
            effectMaterialVOLiveData.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.effect.z
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkEditorEffectTimelinePart.xb(WinkEditorEffectTimelinePart.this, (com.tencent.mobileqq.wink.editor.model.b) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pb(final WinkEditorEffectTimelinePart this$0, final m63.d this_apply, t73.a aVar) {
        EffectMaskContainer effectMaskContainer;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        m63.b bVar = (m63.b) aVar.a();
        if (bVar == null) {
            return;
        }
        EffectMaskContainer effectMaskContainer2 = null;
        if (bVar instanceof b.Start) {
            EffectMaskContainer effectMaskContainer3 = this$0.effectMask;
            if (effectMaskContainer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("effectMask");
                effectMaskContainer = null;
            } else {
                effectMaskContainer = effectMaskContainer3;
            }
            b.Start start = (b.Start) bVar;
            effectMaskContainer.P(start.getAppliedEffect(), start.getStartUs() / 1000, start.getColor(), new Function0<Long>() { // from class: com.tencent.mobileqq.wink.editor.effect.WinkEditorEffectTimelinePart$initObserver$2$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Long invoke() {
                    dr H9 = WinkEditorEffectTimelinePart.this.H9();
                    return Long.valueOf((H9 != null ? H9.getCurrentPlayUs() : 0L) / 1000);
                }
            }, new Function2<EffectMaskContainer, Long, Unit>() { // from class: com.tencent.mobileqq.wink.editor.effect.WinkEditorEffectTimelinePart$initObserver$2$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(EffectMaskContainer effectMaskContainer4, Long l3) {
                    invoke(effectMaskContainer4, l3.longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull EffectMaskContainer maskView, long j3) {
                    Intrinsics.checkNotNullParameter(maskView, "maskView");
                    maskView.Q(j3);
                    m63.d.this.v2(j3);
                }
            });
            return;
        }
        if (bVar instanceof b.Stop) {
            EffectMaskContainer effectMaskContainer4 = this$0.effectMask;
            if (effectMaskContainer4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("effectMask");
            } else {
                effectMaskContainer2 = effectMaskContainer4;
            }
            effectMaskContainer2.Q(((b.Stop) bVar).getEndUs() / 1000);
            return;
        }
        if (bVar instanceof b.C10768b) {
            EffectMaskContainer effectMaskContainer5 = this$0.effectMask;
            if (effectMaskContainer5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("effectMask");
            } else {
                effectMaskContainer2 = effectMaskContainer5;
            }
            effectMaskContainer2.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qb(WinkEditorEffectTimelinePart this$0, ArrayList it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EffectMaskContainer effectMaskContainer = this$0.effectMask;
        if (effectMaskContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectMask");
            effectMaskContainer = null;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        effectMaskContainer.S(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rb(WinkEditorEffectTimelinePart this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ms.a.a("effectTest", "observer: undo:" + it);
        ViewGroup viewGroup = this$0.undoBtn;
        if (viewGroup != null) {
            Intrinsics.checkNotNull(viewGroup);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.Sb(viewGroup, it.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sb(Boolean bool) {
        ms.a.a("effectTest", "observer: redo:" + bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tb(WinkEditorEffectTimelinePart this$0, Boolean it) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.playerStatusBtn;
        if (imageView != null) {
            imageView.setEnabled(!it.booleanValue());
        }
        ImageView imageView2 = this$0.cancelBtn;
        if (imageView2 != null) {
            imageView2.setEnabled(!it.booleanValue());
        }
        ImageView imageView3 = this$0.confirmBtn;
        if (imageView3 != null) {
            imageView3.setEnabled(!it.booleanValue());
        }
        View view = this$0.timelinePanelOpInterceptorView;
        if (view != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (it.booleanValue()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ub(WinkEditorEffectTimelinePart this$0, t73.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        m63.a aVar2 = (m63.a) aVar.a();
        if (Intrinsics.areEqual(aVar2, a.C10767a.f416292a)) {
            this$0.x9();
        } else if (Intrinsics.areEqual(aVar2, a.b.f416293a)) {
            this$0.Lb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wb(WinkEditorEffectTimelinePart this$0, Long it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EffectMaskContainer effectMaskContainer = this$0.effectMask;
        if (effectMaskContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectMask");
            effectMaskContainer = null;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        effectMaskContainer.w(it.longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xb(WinkEditorEffectTimelinePart this$0, com.tencent.mobileqq.wink.editor.model.b winkMaterialVO) {
        WinkEffectCatType winkEffectCatType;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(winkMaterialVO, "winkMaterialVO");
        com.tencent.mobileqq.wink.editor.effect.d dVar = this$0.effectMaterialMvp;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("effectMaterialMvp");
            dVar = null;
        }
        m63.d dVar2 = this$0.effectViewModel;
        if (dVar2 == null || (winkEffectCatType = dVar2.d2()) == null) {
            winkEffectCatType = WinkEffectCatType.TypeScreen;
        }
        dVar.n(winkEffectCatType, winkMaterialVO);
    }

    private final void yb() {
        TimelinePanelViewController timelinePanelViewController = this.panelController;
        if (timelinePanelViewController != null) {
            if (timelinePanelViewController != null) {
                TimelinePanel timelinePanel = this.timelinePanel;
                Intrinsics.checkNotNull(timelinePanel);
                timelinePanelViewController.j(timelinePanel);
            }
            Xb(this, 0, 1, null);
        }
        View view = this.timelinePanelOpInterceptorView;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.effect.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WinkEditorEffectTimelinePart.Ab(view2);
                }
            });
        }
        View partRootView = getPartRootView();
        if (partRootView != null) {
            partRootView.getViewTreeObserver().addOnGlobalLayoutListener(new c(partRootView, this));
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.ure;
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void J9(@NotNull WinkEditorViewModel.EditMode editMode) {
        Intrinsics.checkNotNullParameter(editMode, "editMode");
        super.J9(editMode);
        if (this.effectViewModel == null && editMode == WinkEditorViewModel.EditMode.Video) {
            Vb();
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.h
    public void Jc(@NotNull com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.g event) {
        TimelineViewModelV2 timelineViewModelV2;
        EffectStatusManager.AppliedEffect appliedEffect;
        TimelineViewModelV2 timelineViewModelV22;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.i) {
            m63.d dVar = this.effectViewModel;
            if (dVar != null) {
                appliedEffect = dVar.getEditingEffect();
            } else {
                appliedEffect = null;
            }
            if (appliedEffect == null && (timelineViewModelV22 = this.timelineViewModel) != null) {
                com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.i iVar = (com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.i) event;
                timelineViewModelV22.a3(iVar.getData(), iVar.getIsOutCalled());
                return;
            }
            return;
        }
        if ((event instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.e) && (timelineViewModelV2 = this.timelineViewModel) != null) {
            timelineViewModelV2.b3();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void L9(@Nullable Bundle args) {
        PanelEventHandler panelEventHandler;
        Boolean bool;
        super.L9(args);
        Tb(WinkEffectCatType.TypeScreen);
        Bb();
        ViewGroup viewGroup = this.undoBtn;
        WinkVideoTavCut winkVideoTavCut = null;
        if (viewGroup != null) {
            Intrinsics.checkNotNull(viewGroup);
            m63.d dVar = this.effectViewModel;
            if (dVar != null) {
                bool = Boolean.valueOf(dVar.W1());
            } else {
                bool = null;
            }
            Intrinsics.checkNotNull(bool);
            Sb(viewGroup, bool.booleanValue());
        }
        m63.d dVar2 = this.effectViewModel;
        if (dVar2 != null) {
            dVar2.r2();
        }
        WinkEditorMenuPart.sa(this, this.timelineMenuHeight, 0, 2, null);
        TimelinePanelViewController timelinePanelViewController = this.panelController;
        if (timelinePanelViewController != null && (panelEventHandler = timelinePanelViewController.getPanelEventHandler()) != null) {
            panelEventHandler.b(this, new Function1<com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.g, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.effect.WinkEditorEffectTimelinePart$onShow$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@Nullable com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.g gVar) {
                    return Boolean.valueOf((gVar instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.n) || (gVar instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.f) || (gVar instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.j) || (gVar instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.a) || (gVar instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.i) || (gVar instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.l) || (gVar instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.e));
                }
            });
        }
        Iterator<Function0<Unit>> it = this.onShowDelayActions.values().iterator();
        while (it.hasNext()) {
            it.next().invoke();
        }
        this.onShowDelayActions.clear();
        ConstraintLayout constraintLayout = this.catScreenBtn;
        if (constraintLayout != null) {
            com.tencent.mobileqq.wink.report.e.r(com.tencent.mobileqq.wink.report.e.f326265a, "dt_imp", constraintLayout, WinkDaTongReportConstant.ElementId.EM_XSJ_PICTURE_TEXIAO_TAB, WinkDTParamBuilder.buildElementParams(), null, 16, null);
        }
        ConstraintLayout constraintLayout2 = this.catFaceBtn;
        if (constraintLayout2 != null) {
            com.tencent.mobileqq.wink.report.e.r(com.tencent.mobileqq.wink.report.e.f326265a, "dt_imp", constraintLayout2, WinkDaTongReportConstant.ElementId.EM_XSJ_FIGURE_TEXIAO_TAB, WinkDTParamBuilder.buildElementParams(), null, 16, null);
        }
        dr H9 = H9();
        if (H9 instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) H9;
        }
        if (winkVideoTavCut != null) {
            winkVideoTavCut.O2(-16777216);
        }
        dr H92 = H9();
        if (H92 == null) {
            return;
        }
        H92.pause();
        Zb(this, 0L, false, 2, null);
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void M9() {
        Vb();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    @NotNull
    public MenuType ba() {
        return MenuType.EFFECT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void initAfterInflation(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.initAfterInflation(rootView);
        initViewModel();
        kb();
        Ib(rootView);
        ob();
        this.timelineMenuHeight = getContext().getResources().getDimensionPixelSize(R.dimen.f159629dj4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void ma() {
        qa();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (this.visible) {
            ImageView imageView = this.cancelBtn;
            if (imageView != null) {
                imageView.performClick();
            }
            return true;
        }
        return super.onBackEvent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void onDismiss() {
        WinkVideoTavCut winkVideoTavCut;
        PanelEventHandler panelEventHandler;
        super.onDismiss();
        m63.d dVar = this.effectViewModel;
        if (dVar != null) {
            dVar.Q1();
        }
        dr H9 = H9();
        if (H9 != null) {
            H9.removePlayerListener(this.playerListener);
        }
        dr H92 = H9();
        if (H92 != null) {
            H92.Q(this.renderListener);
        }
        dr H93 = H9();
        if (H93 != null) {
            H93.play();
        }
        TimelinePanelViewController timelinePanelViewController = this.panelController;
        if (timelinePanelViewController != null && (panelEventHandler = timelinePanelViewController.getPanelEventHandler()) != null) {
            panelEventHandler.c(this);
        }
        m63.d dVar2 = this.effectViewModel;
        if (dVar2 != null) {
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXIAO_CLICK_CNT, Integer.valueOf(dVar2.getReportData().getEffectItemClickNum()));
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXIAO_LONG_PRESS_CNT, Integer.valueOf(dVar2.getReportData().getEffectItemLongClickNum()));
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXIAO_BACKOUT_CNT, Integer.valueOf(dVar2.getReportData().getEffectUndoClickNum()));
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXIAO_DRAG_CNT, Integer.valueOf(dVar2.getReportData().getEffectItemEditNum()));
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXIAO_REPLACE_CNT, Integer.valueOf(dVar2.getReportData().getEffectCatClickNum()));
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PICTURE_TEXIAO_NUM, Integer.valueOf(dVar2.b2(WinkEffectCatType.TypeScreen)));
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FIGURE_TEXIAO_NUM, Integer.valueOf(dVar2.b2(WinkEffectCatType.TypeFace)));
        }
        dr H94 = H9();
        if (H94 instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) H94;
        } else {
            winkVideoTavCut = null;
        }
        if (winkVideoTavCut != null) {
            winkVideoTavCut.O2(WinkVideoTavCut.INSTANCE.m());
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l lVar = this.videoTrackController;
        if (lVar != null) {
            lVar.F();
        }
        super.onPartDestroy(activity);
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/editor/effect/WinkEditorEffectTimelinePart$f", "Lcom/tencent/tavcut/core/session/ISessionListener;", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "newData", "", "duration", "mediaDuration", "", "onRenderDataChanged", "onRenderDataApplied", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f implements ISessionListener {
        f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(WinkEditorEffectTimelinePart this$0, LAKRenderModel newData) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(newData, "$newData");
            TimelineViewModelV2 timelineViewModelV2 = this$0.timelineViewModel;
            if (timelineViewModelV2 != null) {
                timelineViewModelV2.D3(newData.getTimeLines());
            }
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataChanged(@NotNull final LAKRenderModel newData, long duration, long mediaDuration) {
            Intrinsics.checkNotNullParameter(newData, "newData");
            com.tencent.videocut.utils.thread.c cVar = com.tencent.videocut.utils.thread.c.f384289c;
            final WinkEditorEffectTimelinePart winkEditorEffectTimelinePart = WinkEditorEffectTimelinePart.this;
            cVar.e(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.effect.ac
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorEffectTimelinePart.f.b(WinkEditorEffectTimelinePart.this, newData);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vb(WinkEffectCatType winkEffectCatType) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nb(DialogInterface dialogInterface, int i3) {
    }
}
