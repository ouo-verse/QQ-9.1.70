package com.tencent.mobileqq.qqvideoedit.editor;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.shortvideo.SendVideoInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqvideoedit.api.IVideoExportApi;
import com.tencent.mobileqq.qqvideoedit.edit.manager.VideoDataServiceHandler;
import com.tencent.mobileqq.qqvideoedit.edit.manager.VideoEditorResourceManager;
import com.tencent.mobileqq.qqvideoedit.editor.aw;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.TimelineViewModel;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.reorder.ReorderContainerView;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.DragDropScrollView;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.DragViewModel;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.TimelinePanel;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.TimelinePanelViewController;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.ClipModel;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.VideoTrackContainerView;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.VideoTrackData;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.VideoTrackTimelineView;
import com.tencent.mobileqq.qqvideoedit.editor.draft.VideoEditData;
import com.tencent.mobileqq.qqvideoedit.editor.draft.VideoEditDataWrapper;
import com.tencent.mobileqq.qqvideoedit.editor.draft.VideoStickerModelExtra;
import com.tencent.mobileqq.qqvideoedit.editor.export.VideoExportProgress;
import com.tencent.mobileqq.qqvideoedit.editor.export.VideoExportViewModel;
import com.tencent.mobileqq.qqvideoedit.editor.menu.MenuSwitchAction;
import com.tencent.mobileqq.qqvideoedit.editor.menu.MenuType;
import com.tencent.mobileqq.qqvideoedit.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.qqvideoedit.editor.sticker.VideoStickerModel;
import com.tencent.mobileqq.qqvideoedit.editor.transition.TransitionResourceManager;
import com.tencent.mobileqq.qqvideoedit.editor.view.BorderView;
import com.tencent.mobileqq.qqvideoedit.editor.view.ProgressView;
import com.tencent.mobileqq.qqvideoedit.event.QQVideoEditFinishActivityEvent;
import com.tencent.mobileqq.qqvideoedit.event.ReceiveSchemaEvent;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.BackgroundModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaClip;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaType;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.RectF;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.ResourceModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.Size;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.SizeF;
import com.tencent.mobileqq.qqvideoedit.utils.QQVideoEditUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tavcut.render.player.IPlayer;
import com.tencent.tavcut.rendermodel.RenderModel;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qj2.CommonConfig;
import qj2.LayoutConfig;
import qj2.ScrollConfig;
import qj2.TimeBarConfig;
import qj2.VideoTrackConfig;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d8\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00e0\u00022\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u00052\u00020\u0006:\u0002\u00e1\u0002B\t\u00a2\u0006\u0006\b\u00de\u0002\u0010\u00df\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\u000b\u001a\u00020\tH\u0014J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\u001a\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0006\u0010 \u001a\u00020\u0013J\u0006\u0010!\u001a\u00020\u0013J\b\u0010\"\u001a\u00020\u0013H\u0016J\b\u0010#\u001a\u00020\u0013H\u0016J\b\u0010$\u001a\u00020\u0013H\u0016J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0007H\u0016J\n\u0010(\u001a\u0004\u0018\u00010'H\u0016J\"\u0010-\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010/\u001a\u00020\u00132\b\u0010.\u001a\u0004\u0018\u00010\u0004H\u0016J$\u00103\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040100j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000401`2H\u0016J\b\u00105\u001a\u000204H\u0014J\b\u00106\u001a\u00020\tH\u0016J\b\u00107\u001a\u00020\tH\u0016J\b\u00108\u001a\u00020\tH\u0016J\b\u00109\u001a\u00020\tH\u0016J\u0010\u0010<\u001a\u00020\u00132\u0006\u0010;\u001a\u00020:H\u0016J\u001a\u0010@\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00072\b\u0010?\u001a\u0004\u0018\u00010>H\u0016J*\u0010H\u001a\u00020\u00132\b\u0010B\u001a\u0004\u0018\u00010A2\u0006\u0010C\u001a\u00020\u00072\u0006\u0010E\u001a\u00020D2\b\u0010G\u001a\u0004\u0018\u00010FJ\u0006\u0010I\u001a\u00020\u0013J\u0006\u0010J\u001a\u00020\u0007J\b\u0010K\u001a\u00020\u0007H\u0016J\u0010\u0010N\u001a\u00020\u00132\b\u0010M\u001a\u0004\u0018\u00010LJ/\u0010S\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\t2\u000e\u0010Q\u001a\n\u0012\u0006\b\u0001\u0012\u0002040P2\u0006\u0010R\u001a\u00020>H\u0016\u00a2\u0006\u0004\bS\u0010TJ\u0016\u0010V\u001a\u0012\u0012\u0004\u0012\u00020U00j\b\u0012\u0004\u0012\u00020U`2J\u0010\u0010X\u001a\u00020\u00132\u0006\u0010W\u001a\u00020\u0016H\u0003J\u0010\u0010Z\u001a\u00020\u00132\u0006\u0010Y\u001a\u00020\u0007H\u0002J\u0012\u0010]\u001a\u00020\u00132\b\u0010\\\u001a\u0004\u0018\u00010[H\u0002J\b\u0010^\u001a\u00020\u0013H\u0002J\u0010\u0010_\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010b\u001a\u00020\u00132\u0006\u0010a\u001a\u00020`H\u0002J\b\u0010d\u001a\u00020cH\u0002J\u0018\u0010h\u001a\u00020\u00132\u0006\u0010f\u001a\u00020e2\u0006\u0010g\u001a\u00020cH\u0002J\b\u0010i\u001a\u00020\u0007H\u0002J\u0010\u0010j\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010k\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010l\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010m\u001a\u00020\u0013H\u0003J\u0010\u0010n\u001a\u00020\u00132\u0006\u0010W\u001a\u00020\u0016H\u0002J\u0010\u0010o\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0003J\b\u0010p\u001a\u00020\u0013H\u0003J\u001a\u0010s\u001a\u00020\u00132\u0006\u0010q\u001a\u00020D2\b\b\u0002\u0010r\u001a\u00020\u0007H\u0002J\b\u0010t\u001a\u00020\u0013H\u0003J\b\u0010u\u001a\u00020\u0013H\u0002J\u0010\u0010v\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010w\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010x\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010y\u001a\u00020\u0007H\u0002J\u0010\u0010z\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010{\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010|\u001a\u00020\u0013H\u0002J\u0010\u0010}\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010~\u001a\u00020\u0013H\u0002J\b\u0010\u007f\u001a\u00020\u0013H\u0002J\u0012\u0010\u0081\u0001\u001a\u00020\u00132\u0007\u0010\u0080\u0001\u001a\u00020DH\u0002J\t\u0010\u0082\u0001\u001a\u00020\u0013H\u0002J\u0011\u0010\u0083\u0001\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0007H\u0002J\u001b\u0010\u0086\u0001\u001a\u00020\u00132\u0010\u0010\u0085\u0001\u001a\u000b\u0012\u0004\u0012\u00020U\u0018\u00010\u0084\u0001H\u0002J\t\u0010\u0087\u0001\u001a\u00020\u0013H\u0002J\u001c\u0010\u0089\u0001\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0007\u0010\u0088\u0001\u001a\u00020\tH\u0002J\u001b\u0010\u008a\u0001\u001a\u00020\u00072\u0010\u0010\u0085\u0001\u001a\u000b\u0012\u0004\u0012\u00020U\u0018\u00010\u0084\u0001H\u0002J\t\u0010\u008b\u0001\u001a\u00020\u0013H\u0002J\t\u0010\u008c\u0001\u001a\u00020\u0013H\u0002J\t\u0010\u008d\u0001\u001a\u00020\u0013H\u0002J\t\u0010\u008e\u0001\u001a\u00020\u0013H\u0002R\u001e\u0010\u0092\u0001\u001a\t\u0012\u0005\u0012\u00030\u008f\u00010\u000e8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0017\u0010\u0095\u0001\u001a\u00020D8\u0002X\u0082D\u00a2\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001a\u0010\u0099\u0001\u001a\u00030\u0096\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001a\u0010\u009d\u0001\u001a\u00030\u009a\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001a\u0010\u00a1\u0001\u001a\u00030\u009e\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u009f\u0001\u0010\u00a0\u0001R\u001a\u0010\u00a5\u0001\u001a\u00030\u00a2\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00a3\u0001\u0010\u00a4\u0001R\u001a\u0010\u00a9\u0001\u001a\u00030\u00a6\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00a7\u0001\u0010\u00a8\u0001R\u001a\u0010\u00ac\u0001\u001a\u00030\u00aa\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u00ab\u0001R\u001a\u0010\u00b0\u0001\u001a\u00030\u00ad\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00ae\u0001\u0010\u00af\u0001R\u001a\u0010\u00b2\u0001\u001a\u00030\u00a6\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00b1\u0001\u0010\u00a8\u0001R\u001a\u0010\u00b4\u0001\u001a\u00030\u00a6\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00b3\u0001\u0010\u00a8\u0001R\u001a\u0010\u00b6\u0001\u001a\u00030\u00a6\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00b5\u0001\u0010\u00a8\u0001R\u001a\u0010\u00b8\u0001\u001a\u00030\u00a2\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00b7\u0001\u0010\u00a4\u0001R\u001a\u0010\u00ba\u0001\u001a\u00030\u00a2\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00b9\u0001\u0010\u00a4\u0001R\u001a\u0010\u00be\u0001\u001a\u00030\u00bb\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00bc\u0001\u0010\u00bd\u0001R\u001a\u0010\u00c2\u0001\u001a\u00030\u00bf\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00c0\u0001\u0010\u00c1\u0001R\u001a\u0010\u00c6\u0001\u001a\u00030\u00c3\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00c4\u0001\u0010\u00c5\u0001R\u001a\u0010\u00ca\u0001\u001a\u00030\u00c7\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00c8\u0001\u0010\u00c9\u0001R\u001a\u0010\u00ce\u0001\u001a\u00030\u00cb\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00cc\u0001\u0010\u00cd\u0001R\u001a\u0010\u00d2\u0001\u001a\u00030\u00cf\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00d0\u0001\u0010\u00d1\u0001R\u001a\u0010\u00d6\u0001\u001a\u00030\u00d3\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00d4\u0001\u0010\u00d5\u0001R\u001a\u0010\u00d9\u0001\u001a\u00030\u008f\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00d7\u0001\u0010\u00d8\u0001R\u001a\u0010\u00db\u0001\u001a\u00030\u008f\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00da\u0001\u0010\u00d8\u0001R\u0019\u0010\u00de\u0001\u001a\u00020`8\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00dc\u0001\u0010\u00dd\u0001R\u0019\u0010\u00e0\u0001\u001a\u00020`8\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00df\u0001\u0010\u00dd\u0001R\u0019\u0010\u00e3\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00e1\u0001\u0010\u00e2\u0001R\u0019\u0010\u00e5\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00e4\u0001\u0010\u00e2\u0001R\u0019\u0010\u00e7\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00e6\u0001\u0010\u00e2\u0001R\u001a\u0010\u00e9\u0001\u001a\u00030\u00a2\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00e8\u0001\u0010\u00a4\u0001R\u001b\u0010\u00ec\u0001\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ea\u0001\u0010\u00eb\u0001R\u001c\u0010\u00f0\u0001\u001a\u0005\u0018\u00010\u00ed\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ee\u0001\u0010\u00ef\u0001R\u001b\u0010\u00f3\u0001\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f1\u0001\u0010\u00f2\u0001R\u001b\u0010\u00f5\u0001\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f4\u0001\u0010\u00f2\u0001R\u001b\u0010\u00f7\u0001\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f6\u0001\u0010\u00f2\u0001R\u001a\u0010\u00fb\u0001\u001a\u00030\u00f8\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f9\u0001\u0010\u00fa\u0001R\u001c\u0010\u00ff\u0001\u001a\u0005\u0018\u00010\u00fc\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00fd\u0001\u0010\u00fe\u0001R\u001a\u0010\u0083\u0002\u001a\u00030\u0080\u00028\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0081\u0002\u0010\u0082\u0002R\u0018\u0010\u0087\u0002\u001a\u00030\u0084\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0085\u0002\u0010\u0086\u0002R\u001a\u0010\u008b\u0002\u001a\u00030\u0088\u00028\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0089\u0002\u0010\u008a\u0002R\u001a\u0010\u008f\u0002\u001a\u00030\u008c\u00028\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u008d\u0002\u0010\u008e\u0002R\u001a\u0010\u0093\u0002\u001a\u00030\u0090\u00028\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0091\u0002\u0010\u0092\u0002R\u001a\u0010\u0097\u0002\u001a\u00030\u0094\u00028\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0095\u0002\u0010\u0096\u0002R\u001a\u0010\u009b\u0002\u001a\u00030\u0098\u00028\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0099\u0002\u0010\u009a\u0002R\u001b\u0010\u009e\u0002\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009c\u0002\u0010\u009d\u0002R\u001b\u0010\u00a0\u0002\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009f\u0002\u0010\u009d\u0002R\u001a\u0010\u00a4\u0002\u001a\u00030\u00a1\u00028\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00a2\u0002\u0010\u00a3\u0002R\u0019\u0010\u00a6\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a5\u0002\u0010\u00da\u0001R\u0019\u0010\u00a8\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a7\u0002\u0010\u00da\u0001R\u001b\u0010\u00ab\u0002\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a9\u0002\u0010\u00aa\u0002R\u0019\u0010\u00ad\u0002\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ac\u0002\u0010\u00a7\u0001R\u0019\u0010\u00af\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ae\u0002\u0010\u00da\u0001R\u0019\u0010\u00b1\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b0\u0002\u0010\u00da\u0001R\u0019\u0010\u00b3\u0002\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b2\u0002\u0010\u0094\u0001R\u0019\u0010\u00b5\u0002\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b4\u0002\u0010\u0094\u0001R\u0019\u0010\u00b7\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b6\u0002\u0010\u00da\u0001R\u0019\u0010\u00b9\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b8\u0002\u0010\u00da\u0001R\u0019\u0010\u00bb\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ba\u0002\u0010\u00da\u0001R\u001a\u0010\u00bf\u0002\u001a\u00030\u00bc\u00028\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00bd\u0002\u0010\u00be\u0002R\u0019\u0010\u00c1\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c0\u0002\u0010\u00da\u0001R\u0019\u0010\u00c3\u0002\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c2\u0002\u0010\u00a7\u0001R\u0019\u0010\u00c5\u0002\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c4\u0002\u0010\u00a7\u0001R\u0019\u0010\u00c7\u0002\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c6\u0002\u0010\u0094\u0001R\u0019\u0010\u00c9\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c8\u0002\u0010\u00da\u0001R\u0019\u0010\u00cb\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ca\u0002\u0010\u00da\u0001R\u0017\u0010\u00cd\u0002\u001a\u00020D8\u0002X\u0082D\u00a2\u0006\b\n\u0006\b\u00cc\u0002\u0010\u0094\u0001R\u0019\u0010\u00cf\u0002\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ce\u0002\u0010\u0094\u0001R\u001d\u0010\u00d5\u0002\u001a\u00030\u00d0\u00028\u0006\u00a2\u0006\u0010\n\u0006\b\u00d1\u0002\u0010\u00d2\u0002\u001a\u0006\b\u00d3\u0002\u0010\u00d4\u0002R\u0018\u0010\u00d9\u0002\u001a\u00030\u00d6\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d7\u0002\u0010\u00d8\u0002R\u0018\u0010\u00dd\u0002\u001a\u00030\u00da\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00db\u0002\u0010\u00dc\u0002\u00a8\u0006\u00e2\u0002"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/VideoEditorFragment;", "Lcom/tencent/mobileqq/qqvideoedit/editor/BaseVideEditorFragment;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/event/e;", "Lcom/tencent/mobileqq/qqvideoedit/editor/a;", "", "enableRootViewSetFitsSystemWindows", "", "getStatusBarColor", "getContentLayoutId", "Lcom/tencent/biz/richframework/part/PartManager;", "getPartManager", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/content/Context;", "context", "", "onAttach", "onDestroyView", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedAfterPartInit", "isChildShow", "g1", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/event/d;", "event", "N8", "Gj", "Ij", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "hidden", "onHiddenChanged", "Lcom/tencent/mobileqq/qqvideoedit/editor/aw;", "wi", "type", "isSuccess", "", "data", "onUpdate", "simpleBaseEvent", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "", "getLogTag", "getRenderWidth", "getRenderHeight", "qh", "ph", "Lcom/tencent/mobileqq/qqvideoedit/editor/view/BorderView$Direction;", "direction", "Lb", "isMove", "", "touchLocationOnScreen", "nh", "", "msg", "cancelable", "", "delay", "Landroid/content/DialogInterface$OnDismissListener;", "dismissListener", "Pj", "pi", "zj", "onBackEvent", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfo", "Mj", "requestCode", "", "permissions", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;", SensorJsPlugin.SENSOR_INTERVAL_UI, MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initView", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "Nj", "Lcom/tencent/mobileqq/qqvideoedit/editor/aw$a;", "params", "uj", "wj", "Zi", "Lck2/f;", "videoPart", "ti", "Lcom/tencent/mobileqq/qqvideoedit/editor/draft/VideoEditDataWrapper;", "Ci", "Lcom/tencent/mobileqq/qqvideoedit/editor/draft/VideoEditData;", "editData", "dataWrapper", "ni", "Dj", "lj", "tj", "Ai", "Bi", "qj", "kj", "bj", "seekTime", "onlyUpdateText", "Kj", "xj", "sj", WidgetCacheLunarData.YI, "Di", "si", "ri", "Jj", "yj", "Fi", "Ni", "Hi", "xi", "durationUs", "Rj", "Ui", "Fj", "", "mediaClips", "Hj", "Ej", "visibility", "oi", "Cj", "Si", "Oj", "Tj", "Sj", "Lcom/tencent/mobileqq/qqvideoedit/editor/d;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "parts", "D", "J", "HDR_TIPS_SHOW_TIME", "Lck2/b;", "E", "Lck2/b;", "partFactory", "Landroid/widget/FrameLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/FrameLayout;", "playerContainerWrapper", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "G", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "globalLayoutListener", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "backBtn", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "showHDRTips", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "nextButton", "Landroid/widget/LinearLayout;", "K", "Landroid/widget/LinearLayout;", "menuBar", "L", "playerCurrentTimeText", "M", "timeText", "N", "clipTimeText", "P", "playerStatusBtn", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "downloadBtn", "Lcom/tencent/mobileqq/qqvideoedit/editor/view/BorderView;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/qqvideoedit/editor/view/BorderView;", "stickerBorderView", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/reorder/ReorderContainerView;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/reorder/ReorderContainerView;", "reorderContainerView", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/TimelinePanel;", "T", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/TimelinePanel;", "timelinePanel", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/TimelinePanelViewController;", "U", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/panel/TimelinePanelViewController;", "panelController", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/n;", "V", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/n;", "videoTrackController", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/f;", "W", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/f;", "dragDropScrollViewController", "Lcom/tencent/mobileqq/qqvideoedit/editor/menu/e;", "X", "Lcom/tencent/mobileqq/qqvideoedit/editor/menu/e;", "dashboardMenuPart", "Y", "Lcom/tencent/mobileqq/qqvideoedit/editor/d;", "textMenuPart", "Z", "stickerControlPart", "a0", "Lck2/f;", "videoExportPart", "b0", "videoDownloadPart", "c0", "Landroid/view/View;", "flBottomBar", "d0", "flBottomBarDelete", "e0", "flBottomBarDeleteBg", "f0", "flBottomBarGarbage", "g0", "[I", "flBottomBarDeleteLocationOnScreen", "Landroid/animation/ValueAnimator;", "h0", "Landroid/animation/ValueAnimator;", "mHDRTipsAnimator", "i0", "Lcom/tencent/mobileqq/qqvideoedit/editor/aw;", "curTavCut", "j0", "videoTavCut", "k0", "imageTavCut", "Landroid/os/Handler;", "l0", "Landroid/os/Handler;", "handler", "Landroid/app/Dialog;", "m0", "Landroid/app/Dialog;", "loadingDialog", "Lcom/tencent/mobileqq/qqvideoedit/editor/view/ProgressView;", "n0", "Lcom/tencent/mobileqq/qqvideoedit/editor/view/ProgressView;", "loadingView", "Lcom/tencent/mobileqq/qqvideoedit/edit/manager/VideoDataServiceHandler;", "o0", "Lcom/tencent/mobileqq/qqvideoedit/edit/manager/VideoDataServiceHandler;", "editorDataServiceHandler", "Lcom/tencent/mobileqq/qqvideoedit/editor/VideoEditorViewModel;", "p0", "Lcom/tencent/mobileqq/qqvideoedit/editor/VideoEditorViewModel;", "videoEditorViewModel", "Lcom/tencent/mobileqq/qqvideoedit/editor/music/viewmodel/MusicVolumeControlViewModel;", "q0", "Lcom/tencent/mobileqq/qqvideoedit/editor/music/viewmodel/MusicVolumeControlViewModel;", "musicVolumeViewModel", "Lak2/o;", "r0", "Lak2/o;", "videoEditorTextViewModel", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/TimelineViewModel;", "s0", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/TimelineViewModel;", "timelineViewModel", "Lcom/tencent/mobileqq/qqvideoedit/editor/export/VideoExportViewModel;", "t0", "Lcom/tencent/mobileqq/qqvideoedit/editor/export/VideoExportViewModel;", "mVideoExportViewModel", "u0", "Ljava/lang/String;", "clientTraceId", "v0", "tongKuanMusicMid", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView;", "w0", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/videotrack/VideoTrackContainerView;", "videoTrack", "x0", "hasScaledView", "y0", "nextStepToPreview", "z0", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "originLocalMediaInfo", "A0", "uinType", "B0", "hasTimeLineActivated", "C0", "isPlayingBeforeEditVideo", "D0", "lastSeekTimeSeconds", "E0", "lastSystemTimeMillisWhenSeek", "F0", "isSeekFromClipEnd", "G0", "isPendingClipEnd", "H0", "hasAnimateDelete", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "I0", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "mQQPermission", "J0", "globalLayoutInited", "K0", "lastPreviewWidth", "L0", "lastPreviewHeight", "M0", "mFixedMaxDuration", "N0", "isShowTextMenu", "O0", "isIgnoreAttract", "P0", "DOWNLOAD_BTN_CLICK_INTERVAL", "Q0", "lastDownloadBtnClickTime", "Lcom/tencent/tavcut/render/player/IPlayer$a;", "R0", "Lcom/tencent/tavcut/render/player/IPlayer$a;", "vi", "()Lcom/tencent/tavcut/render/player/IPlayer$a;", "playerListener", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/reorder/g;", "S0", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/reorder/g;", "reorderListener", "Lcom/tencent/tavcut/session/d;", "T0", "Lcom/tencent/tavcut/session/d;", "renderListener", "<init>", "()V", "U0", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class VideoEditorFragment extends BaseVideEditorFragment implements BusinessObserver, SimpleEventReceiver<SimpleBaseEvent>, com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.e, a {

    /* renamed from: A0, reason: from kotlin metadata */
    private int uinType;

    /* renamed from: B0, reason: from kotlin metadata */
    private boolean hasTimeLineActivated;

    /* renamed from: C0, reason: from kotlin metadata */
    private boolean isPlayingBeforeEditVideo;

    /* renamed from: D0, reason: from kotlin metadata */
    private long lastSeekTimeSeconds;

    /* renamed from: E, reason: from kotlin metadata */
    private ck2.b partFactory;

    /* renamed from: E0, reason: from kotlin metadata */
    private long lastSystemTimeMillisWhenSeek;

    /* renamed from: F, reason: from kotlin metadata */
    private FrameLayout playerContainerWrapper;

    /* renamed from: F0, reason: from kotlin metadata */
    private boolean isSeekFromClipEnd;

    /* renamed from: G, reason: from kotlin metadata */
    private ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;

    /* renamed from: G0, reason: from kotlin metadata */
    private boolean isPendingClipEnd;

    /* renamed from: H, reason: from kotlin metadata */
    private ImageView backBtn;

    /* renamed from: H0, reason: from kotlin metadata */
    private boolean hasAnimateDelete;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView showHDRTips;

    /* renamed from: I0, reason: from kotlin metadata */
    private QQPermission mQQPermission;

    /* renamed from: J, reason: from kotlin metadata */
    private QUIButton nextButton;

    /* renamed from: J0, reason: from kotlin metadata */
    private boolean globalLayoutInited;

    /* renamed from: K, reason: from kotlin metadata */
    private LinearLayout menuBar;

    /* renamed from: K0, reason: from kotlin metadata */
    private int lastPreviewWidth;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView playerCurrentTimeText;

    /* renamed from: L0, reason: from kotlin metadata */
    private int lastPreviewHeight;

    /* renamed from: M, reason: from kotlin metadata */
    private TextView timeText;

    /* renamed from: M0, reason: from kotlin metadata */
    private long mFixedMaxDuration;

    /* renamed from: N, reason: from kotlin metadata */
    private TextView clipTimeText;

    /* renamed from: N0, reason: from kotlin metadata */
    private boolean isShowTextMenu;

    /* renamed from: O0, reason: from kotlin metadata */
    private boolean isIgnoreAttract;

    /* renamed from: P, reason: from kotlin metadata */
    private ImageView playerStatusBtn;

    /* renamed from: P0, reason: from kotlin metadata */
    private final long DOWNLOAD_BTN_CLICK_INTERVAL;

    /* renamed from: Q, reason: from kotlin metadata */
    private ImageView downloadBtn;

    /* renamed from: Q0, reason: from kotlin metadata */
    private long lastDownloadBtnClickTime;

    /* renamed from: R, reason: from kotlin metadata */
    private BorderView stickerBorderView;

    /* renamed from: R0, reason: from kotlin metadata */
    @NotNull
    private final IPlayer.a playerListener;

    /* renamed from: S, reason: from kotlin metadata */
    private ReorderContainerView reorderContainerView;

    /* renamed from: S0, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.reorder.g reorderListener;

    /* renamed from: T, reason: from kotlin metadata */
    private TimelinePanel timelinePanel;

    /* renamed from: T0, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.tavcut.session.d renderListener;

    /* renamed from: U, reason: from kotlin metadata */
    private TimelinePanelViewController panelController;

    /* renamed from: V, reason: from kotlin metadata */
    private com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.n videoTrackController;

    /* renamed from: W, reason: from kotlin metadata */
    private com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.f dragDropScrollViewController;

    /* renamed from: X, reason: from kotlin metadata */
    private com.tencent.mobileqq.qqvideoedit.editor.menu.e dashboardMenuPart;

    /* renamed from: Y, reason: from kotlin metadata */
    private com.tencent.mobileqq.qqvideoedit.editor.d textMenuPart;

    /* renamed from: Z, reason: from kotlin metadata */
    private com.tencent.mobileqq.qqvideoedit.editor.d stickerControlPart;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private ck2.f videoExportPart;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private ck2.f videoDownloadPart;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private View flBottomBar;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private View flBottomBarDelete;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private View flBottomBarDeleteBg;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private ImageView flBottomBarGarbage;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private int[] flBottomBarDeleteLocationOnScreen;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator mHDRTipsAnimator;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private aw curTavCut;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private aw videoTavCut;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private aw imageTavCut;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog loadingDialog;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private ProgressView loadingView;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VideoDataServiceHandler editorDataServiceHandler;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private VideoEditorViewModel videoEditorViewModel;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private MusicVolumeControlViewModel musicVolumeViewModel;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private ak2.o videoEditorTextViewModel;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private TimelineViewModel timelineViewModel;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private VideoExportViewModel mVideoExportViewModel;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String clientTraceId;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String tongKuanMusicMid;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    private VideoTrackContainerView videoTrack;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    private boolean hasScaledView;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    private boolean nextStepToPreview;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LocalMediaInfo originLocalMediaInfo;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.qqvideoedit.editor.d> parts = new ArrayList();

    /* renamed from: D, reason: from kotlin metadata */
    private final long HDR_TIPS_SHOW_TIME = 2000;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Handler handler = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/VideoEditorFragment$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f275125b;

        b(View view) {
            this.f275125b = view;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            VideoEditorFragment.this.Jj(this.f275125b);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/VideoEditorFragment$d", "Lcom/tencent/tavcut/render/player/IPlayer$a;", "Lcom/tencent/tavcut/render/player/IPlayer$PlayerStatus;", "playerStatus", "Lcom/tencent/tavcut/render/player/IPlayer;", "iPlayer", "", "a", "", "l", "l1", "onPositionChanged", "b", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class d implements IPlayer.a {
        d() {
        }

        @Override // com.tencent.tavcut.render.player.IPlayer.a
        public void a(@Nullable IPlayer.PlayerStatus playerStatus, @NotNull IPlayer iPlayer) {
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
            TimelineViewModel timelineViewModel = null;
            if (playerStatus == IPlayer.PlayerStatus.PLAYING) {
                ImageView imageView = VideoEditorFragment.this.playerStatusBtn;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playerStatusBtn");
                    imageView = null;
                }
                imageView.setImageResource(R.drawable.nh9);
            } else if (playerStatus == IPlayer.PlayerStatus.PAUSED || playerStatus == IPlayer.PlayerStatus.STOPPED) {
                ImageView imageView2 = VideoEditorFragment.this.playerStatusBtn;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playerStatusBtn");
                    imageView2 = null;
                }
                imageView2.setImageResource(R.drawable.nh_);
            }
            VideoEditorViewModel videoEditorViewModel = VideoEditorFragment.this.videoEditorViewModel;
            if (videoEditorViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
                videoEditorViewModel = null;
            }
            videoEditorViewModel.T1().postValue(playerStatus);
            TimelineViewModel timelineViewModel2 = VideoEditorFragment.this.timelineViewModel;
            if (timelineViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
            } else {
                timelineViewModel = timelineViewModel2;
            }
            timelineViewModel.R1().postValue(playerStatus);
        }

        @Override // com.tencent.tavcut.render.player.IPlayer.a
        public void b(@NotNull IPlayer iPlayer) {
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
        }

        @Override // com.tencent.tavcut.render.player.IPlayer.a
        public void onPositionChanged(long l3, long l16) {
            yj2.a.a(l3 / 1000);
            VideoEditorViewModel videoEditorViewModel = VideoEditorFragment.this.videoEditorViewModel;
            TimelineViewModel timelineViewModel = null;
            if (videoEditorViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
                videoEditorViewModel = null;
            }
            videoEditorViewModel.U1().postValue(Long.valueOf(l3));
            TimelineViewModel timelineViewModel2 = VideoEditorFragment.this.timelineViewModel;
            if (timelineViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
            } else {
                timelineViewModel = timelineViewModel2;
            }
            timelineViewModel.S1().postValue(Long.valueOf(l3));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/VideoEditorFragment$f", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/reorder/g;", "", "uuid", "", "targetIndex", "", "a", "I", "getDragIndex", "()I", "setDragIndex", "(I)V", "dragIndex", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class f implements com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.reorder.g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int dragIndex = -1;

        f() {
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.reorder.g
        public void a(@NotNull String uuid, int targetIndex) {
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            ReorderContainerView reorderContainerView = VideoEditorFragment.this.reorderContainerView;
            TimelineViewModel timelineViewModel = null;
            if (reorderContainerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reorderContainerView");
                reorderContainerView = null;
            }
            reorderContainerView.setVisibility(4);
            TimelinePanelViewController timelinePanelViewController = VideoEditorFragment.this.panelController;
            if (timelinePanelViewController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelController");
                timelinePanelViewController = null;
            }
            timelinePanelViewController.q(true);
            com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.n nVar = VideoEditorFragment.this.videoTrackController;
            if (nVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoTrackController");
                nVar = null;
            }
            if (nVar.m() != null) {
                com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.n nVar2 = VideoEditorFragment.this.videoTrackController;
                if (nVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoTrackController");
                    nVar2 = null;
                }
                VideoTrackContainerView m3 = nVar2.m();
                Intrinsics.checkNotNull(m3);
                m3.setVisibility(0);
            }
            com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.f fVar = VideoEditorFragment.this.dragDropScrollViewController;
            if (fVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dragDropScrollViewController");
                fVar = null;
            }
            if (fVar.m() != null) {
                com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.f fVar2 = VideoEditorFragment.this.dragDropScrollViewController;
                if (fVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dragDropScrollViewController");
                    fVar2 = null;
                }
                DragDropScrollView m16 = fVar2.m();
                Intrinsics.checkNotNull(m16);
                m16.setVisibility(0);
            }
            com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.n nVar3 = VideoEditorFragment.this.videoTrackController;
            if (nVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoTrackController");
                nVar3 = null;
            }
            VideoTrackContainerView m17 = nVar3.m();
            Intrinsics.checkNotNull(m17);
            m17.setHandleView(null);
            if (this.dragIndex != targetIndex && targetIndex >= 0) {
                TimelineViewModel timelineViewModel2 = VideoEditorFragment.this.timelineViewModel;
                if (timelineViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
                } else {
                    timelineViewModel = timelineViewModel2;
                }
                timelineViewModel.b2(uuid, targetIndex);
            }
        }
    }

    public VideoEditorFragment() {
        BusinessHandler businessHandler = com.tencent.mobileqq.qqvideoedit.a.a().getBusinessHandler(VideoDataServiceHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.qqvideoedit.edit.manager.VideoDataServiceHandler");
        this.editorDataServiceHandler = (VideoDataServiceHandler) businessHandler;
        this.clientTraceId = "";
        this.tongKuanMusicMid = "";
        this.isShowTextMenu = true;
        this.DOWNLOAD_BTN_CLICK_INTERVAL = 500L;
        this.playerListener = new d();
        this.reorderListener = new f();
        this.renderListener = new e();
    }

    private final void Ai(View view) {
        View findViewById = view.findViewById(R.id.v7h);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.fl_bottom_bar)");
        this.flBottomBar = findViewById;
        View findViewById2 = view.findViewById(R.id.v7i);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.fl_bottom_bar_delete)");
        this.flBottomBarDelete = findViewById2;
        View findViewById3 = view.findViewById(R.id.v7j);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.fl_bottom_bar_delete_bg)");
        this.flBottomBarDeleteBg = findViewById3;
        View findViewById4 = view.findViewById(R.id.v7k);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.fl_bottom_bar_garbage)");
        this.flBottomBarGarbage = (ImageView) findViewById4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Aj(VideoEditorFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoEditorViewModel videoEditorViewModel = this$0.videoEditorViewModel;
        if (videoEditorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
            videoEditorViewModel = null;
        }
        videoEditorViewModel.s2(this$0.getContext());
        this$0.requireActivity().finish();
    }

    @RequiresApi(api = 21)
    private final void Bi() {
        this.panelController = new TimelinePanelViewController();
        com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.n nVar = new com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.n(com.tencent.mobileqq.qqvideoedit.editor.clipping.thumbnail.k.f275344a);
        this.videoTrackController = nVar;
        nVar.D(this.isIgnoreAttract);
        this.dragDropScrollViewController = new com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.f();
        TimelinePanelViewController timelinePanelViewController = this.panelController;
        com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.f fVar = null;
        if (timelinePanelViewController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelController");
            timelinePanelViewController = null;
        }
        com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.n nVar2 = this.videoTrackController;
        if (nVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTrackController");
            nVar2 = null;
        }
        timelinePanelViewController.c(nVar2);
        TimelinePanelViewController timelinePanelViewController2 = this.panelController;
        if (timelinePanelViewController2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelController");
            timelinePanelViewController2 = null;
        }
        com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.f fVar2 = this.dragDropScrollViewController;
        if (fVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragDropScrollViewController");
        } else {
            fVar = fVar2;
        }
        timelinePanelViewController2.c(fVar);
    }

    private final VideoEditDataWrapper Ci() {
        String str;
        long j3;
        boolean z16;
        List<VideoEditData> n3;
        aw awVar = this.curTavCut;
        MusicVolumeControlViewModel musicVolumeControlViewModel = null;
        if (awVar instanceof VideoTavCut) {
            Intrinsics.checkNotNull(awVar, "null cannot be cast to non-null type com.tencent.mobileqq.qqvideoedit.editor.VideoTavCut");
            str = ((VideoTavCut) awVar).getTemplatePath();
        } else {
            str = null;
        }
        VideoEditorViewModel videoEditorViewModel = this.videoEditorViewModel;
        if (videoEditorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
            videoEditorViewModel = null;
        }
        String missionId = videoEditorViewModel.getMissionId();
        VideoEditorViewModel videoEditorViewModel2 = this.videoEditorViewModel;
        if (videoEditorViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
            videoEditorViewModel2 = null;
        }
        int Z1 = videoEditorViewModel2.Z1();
        VideoEditorViewModel videoEditorViewModel3 = this.videoEditorViewModel;
        if (videoEditorViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
            videoEditorViewModel3 = null;
        }
        ArrayList<LocalMediaInfo> b26 = videoEditorViewModel3.b2();
        VideoEditorViewModel videoEditorViewModel4 = this.videoEditorViewModel;
        if (videoEditorViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
            videoEditorViewModel4 = null;
        }
        int mFrom = videoEditorViewModel4.getMFrom();
        aw awVar2 = this.curTavCut;
        if (awVar2 != null) {
            j3 = awVar2.getDurationUs();
        } else {
            j3 = 0;
        }
        long j16 = j3;
        VideoEditorViewModel videoEditorViewModel5 = this.videoEditorViewModel;
        if (videoEditorViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
            videoEditorViewModel5 = null;
        }
        boolean isFromCapture = videoEditorViewModel5.getIsFromCapture();
        aw awVar3 = this.curTavCut;
        if (awVar3 != null) {
            z16 = awVar3.getIsChangedBackground();
        } else {
            z16 = false;
        }
        boolean z17 = z16;
        VideoEditorViewModel videoEditorViewModel6 = this.videoEditorViewModel;
        if (videoEditorViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
            videoEditorViewModel6 = null;
        }
        int useHD = videoEditorViewModel6.getUseHD();
        MusicVolumeControlViewModel musicVolumeControlViewModel2 = this.musicVolumeViewModel;
        if (musicVolumeControlViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicVolumeViewModel");
            musicVolumeControlViewModel2 = null;
        }
        Float value = musicVolumeControlViewModel2.T1().getValue();
        if (value == null) {
            value = Float.valueOf(0.0f);
        }
        MusicVolumeControlViewModel musicVolumeControlViewModel3 = this.musicVolumeViewModel;
        if (musicVolumeControlViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicVolumeViewModel");
            musicVolumeControlViewModel3 = null;
        }
        Float value2 = musicVolumeControlViewModel3.Q1().getValue();
        if (value2 == null) {
            value2 = Float.valueOf(0.0f);
        }
        Float f16 = value2;
        MusicVolumeControlViewModel musicVolumeControlViewModel4 = this.musicVolumeViewModel;
        if (musicVolumeControlViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicVolumeViewModel");
        } else {
            musicVolumeControlViewModel = musicVolumeControlViewModel4;
        }
        VideoEditDataWrapper videoEditDataWrapper = new VideoEditDataWrapper(missionId, Integer.valueOf(Z1), null, b26, str, Integer.valueOf(mFrom), null, j16, isFromCapture, "fakeMid_template_bgm", z17, useHD, value.floatValue(), f16.floatValue(), musicVolumeControlViewModel.R1(), 68, null);
        aw awVar4 = this.curTavCut;
        if (awVar4 != null && (n3 = awVar4.n()) != null) {
            Iterator<T> it = n3.iterator();
            while (it.hasNext()) {
                ni((VideoEditData) it.next(), videoEditDataWrapper);
            }
        }
        return videoEditDataWrapper;
    }

    private final boolean Cj(List<MediaClip> mediaClips) {
        if (mediaClips == null || mediaClips.size() <= 1) {
            return false;
        }
        Iterator<MediaClip> it = mediaClips.iterator();
        while (it.hasNext()) {
            ResourceModel resourceModel = it.next().resource;
            if (resourceModel != null && resourceModel.type != MediaType.IMAGE) {
                return false;
            }
        }
        return true;
    }

    private final void Di(View view) {
        View findViewById = view.findViewById(R.id.uky);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.downloadBtn)");
        ImageView imageView = (ImageView) findViewById;
        this.downloadBtn = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadBtn");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VideoEditorFragment.Ei(VideoEditorFragment.this, view2);
            }
        });
    }

    private final boolean Dj() {
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || !intent.getBooleanExtra(PeakConstants.VIDEO_EDIT_GAME_STRATEGY_PUBLISH, false)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ei(VideoEditorFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.ri()) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.si(it);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void Ej() {
        com.tencent.mobileqq.qqvideoedit.c.b();
        String lightAssetsDir = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightAssetsDir();
        Intrinsics.checkNotNullExpressionValue(lightAssetsDir, "api(IAEResUtil::class.java).lightAssetsDir");
        od4.b.t(lightAssetsDir);
        com.tencent.mobileqq.qqvideoedit.c.c();
    }

    private final void Fi() {
        ViewModel viewModel = getViewModel(ak2.o.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(VideoEditorTextViewModel::class.java)");
        ak2.o oVar = (ak2.o) viewModel;
        this.videoEditorTextViewModel = oVar;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoEditorTextViewModel");
            oVar = null;
        }
        oVar.Q1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoEditorFragment.Gi(VideoEditorFragment.this, (MetaMaterial) obj);
            }
        });
    }

    private final void Fj(boolean hidden) {
        IPlayer currentPlayer;
        aw awVar;
        IPlayer currentPlayer2;
        if (!hidden) {
            Bundle arguments = getArguments();
            MenuType menuType = null;
            if (arguments != null) {
                if (arguments.getBoolean(QQWinkConstants.IS_FROM_CLIP)) {
                    VideoEditorViewModel videoEditorViewModel = this.videoEditorViewModel;
                    if (videoEditorViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
                        videoEditorViewModel = null;
                    }
                    videoEditorViewModel.x2();
                    ArrayList parcelableArrayList = arguments.getParcelableArrayList(QQWinkConstants.CLIP_RESOURCE_MODEL);
                    if (parcelableArrayList != null) {
                        aw awVar2 = this.curTavCut;
                        Intrinsics.checkNotNull(awVar2, "null cannot be cast to non-null type com.tencent.mobileqq.qqvideoedit.editor.VideoTavCut");
                        ((VideoTavCut) awVar2).G(parcelableArrayList);
                    }
                    Hj(parcelableArrayList);
                    long j3 = arguments.getLong(QQWinkConstants.MEDIA_DURATION);
                    if (parcelableArrayList != null && Cj(parcelableArrayList) && QzoneConfig.getWinkTransitionSwitch()) {
                        long size = j3 - ((parcelableArrayList.size() - 1) * 1000000);
                        if (size > parcelableArrayList.size() * 1000000) {
                            j3 = size;
                        }
                    }
                    if (j3 != 0) {
                        aw awVar3 = this.curTavCut;
                        if (awVar3 != null) {
                            awVar3.W(j3);
                        }
                        Rj(j3);
                    }
                    arguments.putBoolean(QQWinkConstants.IS_FROM_CLIP, false);
                } else if (arguments.getBoolean(QQWinkConstants.IS_FROM_CROP)) {
                    VideoEditorViewModel videoEditorViewModel2 = this.videoEditorViewModel;
                    if (videoEditorViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
                        videoEditorViewModel2 = null;
                    }
                    videoEditorViewModel2.x2();
                    arguments.putBoolean(QQWinkConstants.IS_FROM_CROP, false);
                }
            }
            VideoEditorViewModel videoEditorViewModel3 = this.videoEditorViewModel;
            if (videoEditorViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
                videoEditorViewModel3 = null;
            }
            MenuSwitchAction value = videoEditorViewModel3.c2().getValue();
            if (value != null) {
                menuType = value.getMenuType();
            }
            if (menuType != MenuType.BACKGROUND && (awVar = this.curTavCut) != null && (currentPlayer2 = awVar.getCurrentPlayer()) != null) {
                currentPlayer2.play();
                return;
            }
            return;
        }
        aw awVar4 = this.curTavCut;
        if (awVar4 != null && (currentPlayer = awVar4.getCurrentPlayer()) != null) {
            currentPlayer.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gi(VideoEditorFragment this$0, MetaMaterial it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        for (com.tencent.mobileqq.qqvideoedit.editor.d dVar : this$0.parts) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            dVar.M9(true, it);
        }
        this$0.Sj();
    }

    private final void Hi() {
        Intent intent;
        VideoEditorViewModel videoEditorViewModel = this.videoEditorViewModel;
        VideoEditorViewModel videoEditorViewModel2 = null;
        if (videoEditorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
            videoEditorViewModel = null;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        videoEditorViewModel.h2(intent);
        VideoEditorViewModel videoEditorViewModel3 = this.videoEditorViewModel;
        if (videoEditorViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
            videoEditorViewModel3 = null;
        }
        videoEditorViewModel3.c2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoEditorFragment.Ii(VideoEditorFragment.this, (MenuSwitchAction) obj);
            }
        });
        VideoEditorViewModel videoEditorViewModel4 = this.videoEditorViewModel;
        if (videoEditorViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
            videoEditorViewModel4 = null;
        }
        videoEditorViewModel4.f2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoEditorFragment.Ji(VideoEditorFragment.this, (aw.VideoTavCutParams) obj);
            }
        });
        VideoEditorViewModel videoEditorViewModel5 = this.videoEditorViewModel;
        if (videoEditorViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
            videoEditorViewModel5 = null;
        }
        videoEditorViewModel5.e2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoEditorFragment.Ki(VideoEditorFragment.this, (SizeF) obj);
            }
        });
        VideoEditorViewModel videoEditorViewModel6 = this.videoEditorViewModel;
        if (videoEditorViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
            videoEditorViewModel6 = null;
        }
        videoEditorViewModel6.o2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoEditorFragment.Li(VideoEditorFragment.this, (Boolean) obj);
            }
        });
        VideoEditorViewModel videoEditorViewModel7 = this.videoEditorViewModel;
        if (videoEditorViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
        } else {
            videoEditorViewModel2 = videoEditorViewModel7;
        }
        videoEditorViewModel2.R1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoEditorFragment.Mi(VideoEditorFragment.this, (Boolean) obj);
            }
        });
    }

    private final void Hj(List<MediaClip> mediaClips) {
        if (!QzoneConfig.getWinkTransitionSwitch()) {
            return;
        }
        if (Cj(mediaClips)) {
            aw awVar = this.curTavCut;
            Intrinsics.checkNotNull(awVar, "null cannot be cast to non-null type com.tencent.mobileqq.qqvideoedit.editor.VideoTavCut");
            ((VideoTavCut) awVar).J();
        } else {
            aw awVar2 = this.curTavCut;
            Intrinsics.checkNotNull(awVar2, "null cannot be cast to non-null type com.tencent.mobileqq.qqvideoedit.editor.VideoTavCut");
            ((VideoTavCut) awVar2).z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ii(VideoEditorFragment this$0, MenuSwitchAction menuSwitchAction) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = null;
        if (menuSwitchAction.getMenuType() == MenuType.BOTTOM_DASHBOARD) {
            ImageView imageView2 = this$0.backBtn;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backBtn");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(0);
            return;
        }
        ImageView imageView3 = this$0.backBtn;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ji(VideoEditorFragment this$0, aw.VideoTavCutParams videoTavCutParams) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.uj(videoTavCutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void Jj(View view) {
        byte b16;
        byte b17;
        LocalMediaInfo localMediaInfo;
        String str;
        aw awVar = this.curTavCut;
        if (awVar != null && !awVar.U()) {
            b16 = true;
        } else {
            b16 = false;
        }
        ck2.f fVar = null;
        VideoEditorViewModel videoEditorViewModel = null;
        if (b16 != false && !Dj()) {
            VideoEditorViewModel videoEditorViewModel2 = this.videoEditorViewModel;
            if (videoEditorViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
                videoEditorViewModel2 = null;
            }
            ArrayList<LocalMediaInfo> b26 = videoEditorViewModel2.b2();
            if (b26 != null && !b26.isEmpty()) {
                b17 = true;
            } else {
                b17 = false;
            }
            if (b17 != false) {
                VideoEditorViewModel videoEditorViewModel3 = this.videoEditorViewModel;
                if (videoEditorViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
                } else {
                    videoEditorViewModel = videoEditorViewModel3;
                }
                ArrayList<LocalMediaInfo> b27 = videoEditorViewModel.b2();
                if (b27 != null && (localMediaInfo = b27.get(0)) != null && (str = localMediaInfo.path) != null) {
                    QQVideoEditUtil.j(view, str);
                    QLog.i("VideoEditorFragment", 1, "saveVideoToAlbum: " + str);
                    return;
                }
                return;
            }
            return;
        }
        ck2.f fVar2 = this.videoDownloadPart;
        if (fVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoDownloadPart");
        } else {
            fVar = fVar2;
        }
        ti(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ki(VideoEditorFragment this$0, SizeF it) {
        VideoTavCut videoTavCut;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        aw awVar = this$0.curTavCut;
        if (awVar instanceof VideoTavCut) {
            videoTavCut = (VideoTavCut) awVar;
        } else {
            videoTavCut = null;
        }
        if (videoTavCut != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            videoTavCut.F(it);
        }
    }

    private final void Kj(long seekTime, boolean onlyUpdateText) {
        TextView textView = this.clipTimeText;
        TimelineViewModel timelineViewModel = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clipTimeText");
            textView = null;
        }
        textView.setText(yj2.a.c(seekTime / 1000));
        if (onlyUpdateText) {
            return;
        }
        long j3 = seekTime / 1000000;
        if (this.lastSeekTimeSeconds != j3) {
            this.lastSeekTimeSeconds = j3;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.lastSystemTimeMillisWhenSeek > 100) {
                this.lastSystemTimeMillisWhenSeek = currentTimeMillis;
                TimelineViewModel timelineViewModel2 = this.timelineViewModel;
                if (timelineViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
                } else {
                    timelineViewModel = timelineViewModel2;
                }
                timelineViewModel.W1().seek(seekTime);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Li(VideoEditorFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.Nj(it.booleanValue());
    }

    static /* synthetic */ void Lj(VideoEditorFragment videoEditorFragment, long j3, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        videoEditorFragment.Kj(j3, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mi(VideoEditorFragment this$0, Boolean isChildShow) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(isChildShow, "isChildShow");
        this$0.Fj(isChildShow.booleanValue());
    }

    private final void Ni(View view) {
        ViewModel viewModel = getViewModel(VideoExportViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(VideoExportViewModel::class.java)");
        VideoExportViewModel videoExportViewModel = (VideoExportViewModel) viewModel;
        this.mVideoExportViewModel = videoExportViewModel;
        VideoExportViewModel videoExportViewModel2 = null;
        if (videoExportViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoExportViewModel");
            videoExportViewModel = null;
        }
        videoExportViewModel.S1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoEditorFragment.Oi(VideoEditorFragment.this, (com.tencent.mobileqq.qqvideoedit.editor.export.c) obj);
            }
        });
        VideoExportViewModel videoExportViewModel3 = this.mVideoExportViewModel;
        if (videoExportViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoExportViewModel");
        } else {
            videoExportViewModel2 = videoExportViewModel3;
        }
        videoExportViewModel2.U1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoEditorFragment.Ri(VideoEditorFragment.this, (VideoExportProgress) obj);
            }
        });
    }

    private final void Nj(boolean isOpen) {
        int i3;
        TextView textView = this.showHDRTips;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showHDRTips");
            textView = null;
        }
        if (isOpen) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
        if (isOpen) {
            Oj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oi(VideoEditorFragment this$0, com.tencent.mobileqq.qqvideoedit.editor.export.c cVar) {
        com.tencent.tavcut.session.a l3;
        IPlayer currentPlayer;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (cVar != com.tencent.mobileqq.qqvideoedit.editor.export.c.f275758g && cVar != com.tencent.mobileqq.qqvideoedit.editor.export.c.f275757f) {
            if (cVar == com.tencent.mobileqq.qqvideoedit.editor.export.c.f275753b) {
                aw awVar = this$0.curTavCut;
                if (awVar != null && (currentPlayer = awVar.getCurrentPlayer()) != null) {
                    currentPlayer.pause();
                }
                this$0.Pj(HardCodeUtil.qqStr(R.string.ymo), true, 0L, new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.z
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        VideoEditorFragment.Pi(dialogInterface);
                    }
                });
                return;
            }
            if (cVar == com.tencent.mobileqq.qqvideoedit.editor.export.c.f275754c) {
                this$0.pi();
                return;
            } else if (cVar == com.tencent.mobileqq.qqvideoedit.editor.export.c.f275755d) {
                this$0.pi();
                return;
            } else {
                if (cVar == com.tencent.mobileqq.qqvideoedit.editor.export.c.f275759h) {
                    this$0.Pj(HardCodeUtil.qqStr(R.string.yml), true, 0L, new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.ab
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            VideoEditorFragment.Qi(dialogInterface);
                        }
                    });
                    return;
                }
                return;
            }
        }
        aw awVar2 = this$0.curTavCut;
        if (awVar2 != null && (l3 = awVar2.l()) != null) {
            l3.release();
        }
    }

    private final void Oj() {
        ValueAnimator valueAnimator = this.mHDRTipsAnimator;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qj(VideoEditorFragment this$0, FragmentActivity fragmentActivity, CharSequence charSequence, boolean z16, DialogInterface.OnDismissListener onDismissListener) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.requireActivity().isFinishing()) {
            ms.a.i("VideoEditorFragment", "Activity has been destroy.");
            return;
        }
        Dialog dialog = this$0.loadingDialog;
        ProgressView progressView = null;
        if (dialog == null) {
            this$0.loadingDialog = new ReportDialog(this$0.requireActivity());
            this$0.loadingView = new ProgressView(fragmentActivity);
            Dialog dialog2 = this$0.loadingDialog;
            Intrinsics.checkNotNull(dialog2);
            Window window = dialog2.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            dialog2.setCanceledOnTouchOutside(false);
            dialog2.requestWindowFeature(1);
            ProgressView progressView2 = this$0.loadingView;
            if (progressView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
                progressView2 = null;
            }
            dialog2.setContentView(progressView2);
            dialog2.setOnDismissListener(onDismissListener);
        } else {
            Intrinsics.checkNotNull(dialog);
            dialog.dismiss();
        }
        ProgressView progressView3 = this$0.loadingView;
        if (progressView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        } else {
            progressView = progressView3;
        }
        progressView.setProgressText(charSequence);
        Dialog dialog3 = this$0.loadingDialog;
        Intrinsics.checkNotNull(dialog3);
        dialog3.setCancelable(z16);
        Dialog dialog4 = this$0.loadingDialog;
        Intrinsics.checkNotNull(dialog4);
        dialog4.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ri(VideoEditorFragment this$0, VideoExportProgress it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoExportViewModel videoExportViewModel = null;
        if (it.getProcessType() == 0) {
            ck2.f fVar = this$0.videoExportPart;
            if (fVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoExportPart");
                fVar = null;
            }
            VideoExportViewModel videoExportViewModel2 = this$0.mVideoExportViewModel;
            if (videoExportViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVideoExportViewModel");
            } else {
                videoExportViewModel = videoExportViewModel2;
            }
            Intrinsics.checkNotNullExpressionValue(it, "it");
            fVar.W9(videoExportViewModel, it);
            return;
        }
        if (it.getProcessType() == 1) {
            ck2.f fVar2 = this$0.videoDownloadPart;
            if (fVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoDownloadPart");
                fVar2 = null;
            }
            VideoExportViewModel videoExportViewModel3 = this$0.mVideoExportViewModel;
            if (videoExportViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVideoExportViewModel");
            } else {
                videoExportViewModel = videoExportViewModel3;
            }
            Intrinsics.checkNotNullExpressionValue(it, "it");
            fVar2.W9(videoExportViewModel, it);
        }
    }

    private final void Si() {
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f, 1.0f, 0.0f).setDuration(this.HDR_TIPS_SHOW_TIME);
        this.mHDRTipsAnimator = duration;
        if (duration != null) {
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.e
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    VideoEditorFragment.Ti(VideoEditorFragment.this, valueAnimator);
                }
            });
        }
        ValueAnimator valueAnimator = this.mHDRTipsAnimator;
        if (valueAnimator != null) {
            valueAnimator.addListener(new c());
        }
    }

    private final void Sj() {
        if (this.nextStepToPreview) {
            QUIButton qUIButton = this.nextButton;
            if (qUIButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nextButton");
                qUIButton = null;
            }
            qUIButton.setText(R.string.f238027in);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ti(VideoEditorFragment this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        TextView textView = this$0.showHDRTips;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showHDRTips");
            textView = null;
        }
        textView.setAlpha(floatValue);
    }

    private final void Tj() {
        ResourceModel resourceModel;
        RectF rectF;
        TimelineViewModel timelineViewModel = this.timelineViewModel;
        TimelineViewModel timelineViewModel2 = null;
        if (timelineViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
            timelineViewModel = null;
        }
        ArrayList<MediaClip> T1 = timelineViewModel.T1();
        aw awVar = this.curTavCut;
        Intrinsics.checkNotNull(awVar, "null cannot be cast to non-null type com.tencent.mobileqq.qqvideoedit.editor.VideoTavCut");
        List<MediaClip> list = ((VideoTavCut) awVar).V().videos;
        if ((!T1.isEmpty()) && (!list.isEmpty())) {
            MediaClip mediaClip = T1.get(0);
            List<Float> list2 = list.get(0).matrix;
            ResourceModel resourceModel2 = T1.get(0).resource;
            if (resourceModel2 != null) {
                ResourceModel resourceModel3 = list.get(0).resource;
                if (resourceModel3 != null) {
                    rectF = resourceModel3.picClipRect;
                } else {
                    rectF = null;
                }
                resourceModel = ResourceModel.copy$default(resourceModel2, null, null, null, null, null, null, null, null, null, null, null, rectF, null, null, null, null, 63487, null);
            } else {
                resourceModel = null;
            }
            Intrinsics.checkNotNullExpressionValue(mediaClip, "mediaClips[0]");
            T1.set(0, MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, list2, null, 94, null));
        }
        aw awVar2 = this.curTavCut;
        Intrinsics.checkNotNull(awVar2, "null cannot be cast to non-null type com.tencent.mobileqq.qqvideoedit.editor.VideoTavCut");
        ((VideoTavCut) awVar2).G(T1);
        Hj(T1);
        TimelineViewModel timelineViewModel3 = this.timelineViewModel;
        if (timelineViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
        } else {
            timelineViewModel2 = timelineViewModel3;
        }
        long O1 = timelineViewModel2.O1();
        if (O1 != 0) {
            aw awVar3 = this.curTavCut;
            if (awVar3 != null) {
                awVar3.W(O1);
            }
            Rj(O1);
        }
    }

    private final void Ui() {
        ViewModel viewModel = new ViewModelProvider(requireActivity()).get(MusicVolumeControlViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir\u2026rolViewModel::class.java)");
        MusicVolumeControlViewModel musicVolumeControlViewModel = (MusicVolumeControlViewModel) viewModel;
        this.musicVolumeViewModel = musicVolumeControlViewModel;
        MusicVolumeControlViewModel musicVolumeControlViewModel2 = null;
        if (musicVolumeControlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicVolumeViewModel");
            musicVolumeControlViewModel = null;
        }
        musicVolumeControlViewModel.T1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoEditorFragment.Vi(VideoEditorFragment.this, (Float) obj);
            }
        });
        MusicVolumeControlViewModel musicVolumeControlViewModel3 = this.musicVolumeViewModel;
        if (musicVolumeControlViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicVolumeViewModel");
            musicVolumeControlViewModel3 = null;
        }
        musicVolumeControlViewModel3.U1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoEditorFragment.Wi(VideoEditorFragment.this, (Float) obj);
            }
        });
        MusicVolumeControlViewModel musicVolumeControlViewModel4 = this.musicVolumeViewModel;
        if (musicVolumeControlViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicVolumeViewModel");
            musicVolumeControlViewModel4 = null;
        }
        musicVolumeControlViewModel4.S1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoEditorFragment.Xi(VideoEditorFragment.this, (Boolean) obj);
            }
        });
        MusicVolumeControlViewModel musicVolumeControlViewModel5 = this.musicVolumeViewModel;
        if (musicVolumeControlViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicVolumeViewModel");
        } else {
            musicVolumeControlViewModel2 = musicVolumeControlViewModel5;
        }
        musicVolumeControlViewModel2.Q1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoEditorFragment.Yi(VideoEditorFragment.this, (Float) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vi(VideoEditorFragment this$0, Float it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        aw awVar = this$0.curTavCut;
        if (awVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            awVar.o(it.floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wi(VideoEditorFragment this$0, Float it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        aw awVar = this$0.curTavCut;
        if (awVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            awVar.o(it.floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xi(VideoEditorFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.booleanValue()) {
            aw awVar = this$0.curTavCut;
            if (awVar != null) {
                awVar.o(1.0f);
                return;
            }
            return;
        }
        aw awVar2 = this$0.curTavCut;
        if (awVar2 != null) {
            awVar2.o(0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yi(VideoEditorFragment this$0, Float it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        aw awVar = this$0.curTavCut;
        if (awVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            awVar.Y(it.floatValue());
        }
    }

    private final void Zi(View view) {
        View findViewById = view.findViewById(R.id.zqg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.nextBtn)");
        QUIButton qUIButton = (QUIButton) findViewById;
        this.nextButton = qUIButton;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextButton");
            qUIButton = null;
        }
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VideoEditorFragment.aj(VideoEditorFragment.this, view2);
            }
        });
        Sj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aj(VideoEditorFragment this$0, View it) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ck2.f fVar = null;
        LocalMediaInfo localMediaInfo = null;
        if (ck2.j.f31048a.a(this$0.getActivity())) {
            aw awVar = this$0.curTavCut;
            if (awVar != null && !awVar.U()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && !this$0.Dj()) {
                VideoEditorViewModel videoEditorViewModel = this$0.videoEditorViewModel;
                if (videoEditorViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
                    videoEditorViewModel = null;
                }
                ArrayList<LocalMediaInfo> b26 = videoEditorViewModel.b2();
                if (b26 != null) {
                    localMediaInfo = b26.get(0);
                }
                this$0.Mj(localMediaInfo);
                EventCollector.getInstance().onViewClicked(it);
            }
        }
        ck2.f fVar2 = this$0.videoExportPart;
        if (fVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoExportPart");
        } else {
            fVar = fVar2;
        }
        this$0.ti(fVar);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        com.tencent.mobileqq.qqvideoedit.editor.c.j(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    @RequiresApi(api = 17)
    private final void bj() {
        TimelinePanelViewController timelinePanelViewController = this.panelController;
        VideoTrackContainerView videoTrackContainerView = null;
        if (timelinePanelViewController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelController");
            timelinePanelViewController = null;
        }
        timelinePanelViewController.getPanelEventHandler().b(this, new Function1<com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.d, Boolean>() { // from class: com.tencent.mobileqq.qqvideoedit.editor.VideoEditorFragment$initObserver$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@Nullable com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.d dVar) {
                return Boolean.valueOf((dVar instanceof com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.j) || (dVar instanceof com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.c) || (dVar instanceof com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.g) || (dVar instanceof com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.a) || (dVar instanceof com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.f));
            }
        });
        TimelineViewModel timelineViewModel = this.timelineViewModel;
        if (timelineViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
            timelineViewModel = null;
        }
        timelineViewModel.Z1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoEditorFragment.cj(VideoEditorFragment.this, ((Long) obj).longValue());
            }
        });
        TimelineViewModel timelineViewModel2 = this.timelineViewModel;
        if (timelineViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
            timelineViewModel2 = null;
        }
        timelineViewModel2.a2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.aa
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoEditorFragment.dj(VideoEditorFragment.this, (VideoTrackData) obj);
            }
        });
        TimelineViewModel timelineViewModel3 = this.timelineViewModel;
        if (timelineViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
            timelineViewModel3 = null;
        }
        timelineViewModel3.S1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.ah
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoEditorFragment.ej(VideoEditorFragment.this, ((Long) obj).longValue());
            }
        });
        VideoTrackContainerView videoTrackContainerView2 = this.videoTrack;
        if (videoTrackContainerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
            videoTrackContainerView2 = null;
        }
        videoTrackContainerView2.w().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.ai
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoEditorFragment.fj(VideoEditorFragment.this, ((Long) obj).longValue());
            }
        });
        VideoTrackContainerView videoTrackContainerView3 = this.videoTrack;
        if (videoTrackContainerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
            videoTrackContainerView3 = null;
        }
        videoTrackContainerView3.v().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.aj
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoEditorFragment.gj(VideoEditorFragment.this, ((Float) obj).floatValue());
            }
        });
        VideoTrackContainerView videoTrackContainerView4 = this.videoTrack;
        if (videoTrackContainerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
            videoTrackContainerView4 = null;
        }
        videoTrackContainerView4.D().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.ak
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoEditorFragment.hj(VideoEditorFragment.this, ((Boolean) obj).booleanValue());
            }
        });
        VideoTrackContainerView videoTrackContainerView5 = this.videoTrack;
        if (videoTrackContainerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
            videoTrackContainerView5 = null;
        }
        videoTrackContainerView5.C().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.al
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoEditorFragment.ij(VideoEditorFragment.this, ((Float) obj).floatValue());
            }
        });
        VideoTrackContainerView videoTrackContainerView6 = this.videoTrack;
        if (videoTrackContainerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
        } else {
            videoTrackContainerView = videoTrackContainerView6;
        }
        videoTrackContainerView.G().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.am
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoEditorFragment.jj(VideoEditorFragment.this, ((Float) obj).floatValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cj(VideoEditorFragment this$0, long j3) {
        long j16;
        String b16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TimelinePanelViewController timelinePanelViewController = this$0.panelController;
        TextView textView = null;
        if (timelinePanelViewController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelController");
            timelinePanelViewController = null;
        }
        TimelineViewModel timelineViewModel = this$0.timelineViewModel;
        if (timelineViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
            timelineViewModel = null;
        }
        timelinePanelViewController.p(timelineViewModel.O1());
        TimelinePanelViewController timelinePanelViewController2 = this$0.panelController;
        if (timelinePanelViewController2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelController");
            timelinePanelViewController2 = null;
        }
        timelinePanelViewController2.r(j3);
        TimelineViewModel timelineViewModel2 = this$0.timelineViewModel;
        if (timelineViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
            timelineViewModel2 = null;
        }
        if (timelineViewModel2.S1().getValue() != null) {
            TimelineViewModel timelineViewModel3 = this$0.timelineViewModel;
            if (timelineViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
                timelineViewModel3 = null;
            }
            Long value = timelineViewModel3.S1().getValue();
            Intrinsics.checkNotNull(value);
            j16 = value.longValue() / 1000;
        } else {
            j16 = 0;
        }
        if (this$0.mFixedMaxDuration == 0) {
            TextView textView2 = this$0.playerCurrentTimeText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playerCurrentTimeText");
                textView2 = null;
            }
            long j17 = 1000;
            textView2.setText(yj2.a.c(j16 / j17));
            TextView textView3 = this$0.timeText;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timeText");
            } else {
                textView = textView3;
            }
            if (j3 < 0) {
                b16 = "0s";
            } else {
                b16 = yj2.a.b(j3 / j17);
            }
            textView.setText(b16);
            return;
        }
        long d16 = yj2.a.d(j3);
        TextView textView4 = this$0.playerCurrentTimeText;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerCurrentTimeText");
            textView4 = null;
        }
        textView4.setText(d16 + ReportConstant.COSTREPORT_PREFIX);
        long d17 = yj2.a.d(this$0.mFixedMaxDuration);
        TextView textView5 = this$0.timeText;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeText");
        } else {
            textView = textView5;
        }
        textView.setText("\u6700\u591a\u53ef\u751f\u6210" + d17 + "\u79d2GIF \u00b7 \u5f53\u524d" + d16 + "\u79d2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dj(VideoEditorFragment this$0, VideoTrackData videoTrackData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<ClipModel> a16 = videoTrackData.a();
        List<Object> b16 = videoTrackData.b();
        com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.n nVar = this$0.videoTrackController;
        TimelineViewModel timelineViewModel = null;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTrackController");
            nVar = null;
        }
        nVar.F(a16, b16);
        ReorderContainerView reorderContainerView = this$0.reorderContainerView;
        if (reorderContainerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reorderContainerView");
            reorderContainerView = null;
        }
        reorderContainerView.P(a16);
        TextView textView = this$0.clipTimeText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clipTimeText");
            textView = null;
        }
        textView.setVisibility(8);
        TextView textView2 = this$0.timeText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeText");
            textView2 = null;
        }
        textView2.setVisibility(0);
        if ((!a16.isEmpty()) && this$0.isPendingClipEnd) {
            this$0.isPendingClipEnd = false;
            long timelineStartTimeUs = a16.get(0).getTimeData().getTimelineStartTimeUs();
            VideoTrackContainerView videoTrackContainerView = this$0.videoTrack;
            if (videoTrackContainerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
                videoTrackContainerView = null;
            }
            com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.n nVar2 = this$0.videoTrackController;
            if (nVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoTrackController");
                nVar2 = null;
            }
            videoTrackContainerView.X(nVar2.l().u(timelineStartTimeUs));
        }
        VideoTrackContainerView videoTrackContainerView2 = this$0.videoTrack;
        if (videoTrackContainerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
            videoTrackContainerView2 = null;
        }
        TimelineViewModel timelineViewModel2 = this$0.timelineViewModel;
        if (timelineViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
        } else {
            timelineViewModel = timelineViewModel2;
        }
        com.tencent.mobileqq.qqvideoedit.editor.c.q(videoTrackContainerView2, timelineViewModel.W1().isPlaying());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ej(VideoEditorFragment this$0, long j3) {
        List<ClipModel> list;
        Integer num;
        long j16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TimelineViewModel timelineViewModel = this$0.timelineViewModel;
        TimelineViewModel timelineViewModel2 = null;
        if (timelineViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
            timelineViewModel = null;
        }
        if (j3 >= timelineViewModel.Q1()) {
            TimelineViewModel timelineViewModel3 = this$0.timelineViewModel;
            if (timelineViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
            } else {
                timelineViewModel2 = timelineViewModel3;
            }
            timelineViewModel2.W1().seek(0L);
            return;
        }
        if (this$0.isSeekFromClipEnd && j3 != 0) {
            return;
        }
        this$0.isSeekFromClipEnd = false;
        TimelineViewModel timelineViewModel4 = this$0.timelineViewModel;
        if (timelineViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
            timelineViewModel4 = null;
        }
        VideoTrackData value = timelineViewModel4.a2().getValue();
        if (value != null) {
            list = value.c();
        } else {
            list = null;
        }
        if (list != null) {
            num = Integer.valueOf(list.size());
        } else {
            num = null;
        }
        Intrinsics.checkNotNull(num);
        if (num.intValue() > 0) {
            j16 = list.get(0).getTimeData().getSelectStartTimeUs() + j3;
        } else {
            j16 = j3;
        }
        TimelineViewModel timelineViewModel5 = this$0.timelineViewModel;
        if (timelineViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
            timelineViewModel5 = null;
        }
        if (timelineViewModel5.W1().isPlaying()) {
            VideoTrackContainerView videoTrackContainerView = this$0.videoTrack;
            if (videoTrackContainerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
                videoTrackContainerView = null;
            }
            com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.n nVar = this$0.videoTrackController;
            if (nVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoTrackController");
                nVar = null;
            }
            videoTrackContainerView.X(nVar.l().u(j16));
            TimelineViewModel timelineViewModel6 = this$0.timelineViewModel;
            if (timelineViewModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
            } else {
                timelineViewModel2 = timelineViewModel6;
            }
            timelineViewModel2.L1(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fj(VideoEditorFragment this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Lj(this$0, j3, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gj(VideoEditorFragment this$0, float f16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.playerCurrentTimeText;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerCurrentTimeText");
            textView = null;
        }
        TextView textView3 = this$0.playerCurrentTimeText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerCurrentTimeText");
            textView3 = null;
        }
        textView.setTranslationX(f16 - (textView3.getMeasuredWidth() / 2));
        com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.n nVar = this$0.videoTrackController;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTrackController");
            nVar = null;
        }
        long t16 = nVar.l().t(f16);
        TextView textView4 = this$0.playerCurrentTimeText;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerCurrentTimeText");
        } else {
            textView2 = textView4;
        }
        textView2.setText(yj2.a.c(t16 / 1000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hj(VideoEditorFragment this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TimelineViewModel timelineViewModel = null;
        if (z16) {
            TextView textView = this$0.playerCurrentTimeText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playerCurrentTimeText");
                textView = null;
            }
            textView.setVisibility(0);
            TextView textView2 = this$0.clipTimeText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clipTimeText");
                textView2 = null;
            }
            textView2.setVisibility(8);
            TextView textView3 = this$0.timeText;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timeText");
                textView3 = null;
            }
            textView3.setVisibility(8);
            TimelineViewModel timelineViewModel2 = this$0.timelineViewModel;
            if (timelineViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
                timelineViewModel2 = null;
            }
            boolean isPlaying = timelineViewModel2.W1().isPlaying();
            this$0.isPlayingBeforeEditVideo = isPlaying;
            if (isPlaying) {
                TimelineViewModel timelineViewModel3 = this$0.timelineViewModel;
                if (timelineViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
                } else {
                    timelineViewModel = timelineViewModel3;
                }
                timelineViewModel.W1().pause();
                return;
            }
            return;
        }
        TextView textView4 = this$0.playerCurrentTimeText;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerCurrentTimeText");
            textView4 = null;
        }
        textView4.setVisibility(8);
        TextView textView5 = this$0.clipTimeText;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clipTimeText");
            textView5 = null;
        }
        textView5.setVisibility(8);
        TextView textView6 = this$0.timeText;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timeText");
            textView6 = null;
        }
        textView6.setVisibility(0);
        if (this$0.isPlayingBeforeEditVideo) {
            TimelineViewModel timelineViewModel4 = this$0.timelineViewModel;
            if (timelineViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
            } else {
                timelineViewModel = timelineViewModel4;
            }
            timelineViewModel.W1().play();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ij(VideoEditorFragment this$0, float f16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.clipTimeText;
        com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.n nVar = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clipTimeText");
            textView = null;
        }
        textView.setX(f16);
        VideoTrackContainerView videoTrackContainerView = this$0.videoTrack;
        if (videoTrackContainerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
            videoTrackContainerView = null;
        }
        VideoTrackTimelineView videoTrackTimelineView = videoTrackContainerView.getVideoTrackTimelineView();
        if (videoTrackTimelineView != null) {
            DragViewModel dragViewModel = videoTrackTimelineView.getDragViewModel();
            com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.n nVar2 = this$0.videoTrackController;
            if (nVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoTrackController");
            } else {
                nVar = nVar2;
            }
            this$0.Kj(nVar.l().t(dragViewModel.getStartPosition()), true);
        }
    }

    @RequiresApi(api = 21)
    private final void initView(View rootView) {
        int i3;
        View findViewById = rootView.findViewById(R.id.f107176_p);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.tv_current_player_time)");
        this.playerCurrentTimeText = (TextView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.kbp);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.tv_time)");
        this.timeText = (TextView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f1068269r);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.tv_clip_time)");
        this.clipTimeText = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.t9k);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.bottomDashboardMenu)");
        LinearLayout linearLayout = (LinearLayout) findViewById4;
        this.menuBar = linearLayout;
        TextView textView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuBar");
            linearLayout = null;
        }
        if (this.isShowTextMenu) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        linearLayout.setVisibility(i3);
        View findViewById5 = rootView.findViewById(R.id.f84954nn);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.showHDRTips)");
        TextView textView2 = (TextView) findViewById5;
        this.showHDRTips = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showHDRTips");
        } else {
            textView = textView2;
        }
        textView.setVisibility(8);
        lj(rootView);
        qj(rootView);
        kj(rootView);
        xj();
        sj();
        Zi(rootView);
        yi(rootView);
        Di(rootView);
        tj(rootView);
        Ai(rootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jj(VideoEditorFragment this$0, float f16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.clipTimeText;
        com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.n nVar = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clipTimeText");
            textView = null;
        }
        TextView textView2 = this$0.clipTimeText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clipTimeText");
            textView2 = null;
        }
        textView.setX(f16 - textView2.getMeasuredWidth());
        VideoTrackContainerView videoTrackContainerView = this$0.videoTrack;
        if (videoTrackContainerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
            videoTrackContainerView = null;
        }
        VideoTrackTimelineView videoTrackTimelineView = videoTrackContainerView.getVideoTrackTimelineView();
        if (videoTrackTimelineView != null) {
            DragViewModel dragViewModel = videoTrackTimelineView.getDragViewModel();
            com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.n nVar2 = this$0.videoTrackController;
            if (nVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoTrackController");
            } else {
                nVar = nVar2;
            }
            this$0.Kj(nVar.l().t(dragViewModel.getEndPosition()), true);
        }
    }

    @RequiresApi(api = 21)
    private final void kj(View view) {
        View findViewById = view.findViewById(R.id.f72993sc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.reorder_clip_list)");
        this.reorderContainerView = (ReorderContainerView) findViewById;
        View findViewById2 = view.findViewById(R.id.f1189275g);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.view_scale_layout)");
        this.timelinePanel = (TimelinePanel) findViewById2;
        TimelinePanelViewController timelinePanelViewController = this.panelController;
        TimelinePanelViewController timelinePanelViewController2 = null;
        if (timelinePanelViewController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelController");
            timelinePanelViewController = null;
        }
        TimelinePanel timelinePanel = this.timelinePanel;
        if (timelinePanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timelinePanel");
            timelinePanel = null;
        }
        timelinePanelViewController.e(timelinePanel);
        CommonConfig commonConfig = new CommonConfig(new ScrollConfig(0.0f, 1, null), new LayoutConfig(0, 0.0f, 0.0f, 0.0f, 0, 31, null), new VideoTrackConfig(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, 127, null), new TimeBarConfig(0.0f, 0.0f, 3, null));
        TimelinePanelViewController timelinePanelViewController3 = this.panelController;
        if (timelinePanelViewController3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelController");
            timelinePanelViewController3 = null;
        }
        timelinePanelViewController3.o(commonConfig);
        TimelinePanelViewController timelinePanelViewController4 = this.panelController;
        if (timelinePanelViewController4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelController");
        } else {
            timelinePanelViewController2 = timelinePanelViewController4;
        }
        timelinePanelViewController2.l();
    }

    private final void lj(View view) {
        View findViewById = view.findViewById(R.id.f25780br);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.playerContainerWrapper)");
        this.playerContainerWrapper = (FrameLayout) findViewById;
        this.globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.s
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                VideoEditorFragment.mj(VideoEditorFragment.this);
            }
        };
        FrameLayout frameLayout = this.playerContainerWrapper;
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerContainerWrapper");
            frameLayout = null;
        }
        ViewTreeObserver viewTreeObserver = frameLayout.getViewTreeObserver();
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener2 = this.globalLayoutListener;
        if (onGlobalLayoutListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalLayoutListener");
        } else {
            onGlobalLayoutListener = onGlobalLayoutListener2;
        }
        viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mj(final VideoEditorFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrameLayout frameLayout = null;
        VideoEditorViewModel videoEditorViewModel = null;
        if (this$0.globalLayoutInited) {
            FrameLayout frameLayout2 = this$0.playerContainerWrapper;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playerContainerWrapper");
                frameLayout2 = null;
            }
            int width = frameLayout2.getWidth();
            FrameLayout frameLayout3 = this$0.playerContainerWrapper;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playerContainerWrapper");
                frameLayout3 = null;
            }
            int height = frameLayout3.getHeight();
            int i3 = this$0.lastPreviewWidth;
            if (width != i3 || height != this$0.lastPreviewHeight) {
                ms.a.f("VideoEditorFragment", "onGlobalLayoutChange old: [" + i3 + ", " + this$0.lastPreviewHeight + "] new: [" + width + " " + height + "]");
                VideoEditorViewModel videoEditorViewModel2 = this$0.videoEditorViewModel;
                if (videoEditorViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
                } else {
                    videoEditorViewModel = videoEditorViewModel2;
                }
                videoEditorViewModel.w2(new SizeF(width, height, null, 4, null));
                this$0.lastPreviewWidth = width;
                this$0.lastPreviewHeight = height;
                return;
            }
            return;
        }
        FrameLayout frameLayout4 = this$0.playerContainerWrapper;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerContainerWrapper");
            frameLayout4 = null;
        }
        int width2 = frameLayout4.getWidth();
        FrameLayout frameLayout5 = this$0.playerContainerWrapper;
        if (frameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerContainerWrapper");
            frameLayout5 = null;
        }
        ms.a.f("VideoEditorFragment", "onGlobalLayoutChange first init size: [" + width2 + ", " + frameLayout5.getHeight() + "]");
        FrameLayout frameLayout6 = this$0.playerContainerWrapper;
        if (frameLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerContainerWrapper");
            frameLayout6 = null;
        }
        this$0.lastPreviewWidth = frameLayout6.getWidth();
        FrameLayout frameLayout7 = this$0.playerContainerWrapper;
        if (frameLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerContainerWrapper");
        } else {
            frameLayout = frameLayout7;
        }
        this$0.lastPreviewHeight = frameLayout.getHeight();
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.editor.y
            @Override // java.lang.Runnable
            public final void run() {
                VideoEditorFragment.nj(VideoEditorFragment.this);
            }
        }, 10L);
        this$0.globalLayoutInited = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void ni(VideoEditData editData, VideoEditDataWrapper dataWrapper) {
        BackgroundModel backgroundModel;
        BackgroundModel backgroundModel2;
        MediaModel V;
        List<MediaClip> list;
        Object orNull;
        ResourceModel resourceModel;
        RectF rectF;
        SizeF sizeF;
        SizeF sizeF2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Map<String, VideoStickerModel> stickerModelMap = editData.getStickerModelMap();
        if (stickerModelMap != null) {
            for (Iterator<Map.Entry<String, VideoStickerModel>> it = stickerModelMap.entrySet().iterator(); it.hasNext(); it = it) {
                Map.Entry<String, VideoStickerModel> next = it.next();
                String key = next.getKey();
                VideoStickerModel value = next.getValue();
                linkedHashMap.put(key, new VideoStickerModelExtra(value.getInitStickerScale(), value.getDownScaleRecord(), value.getOriginPointInView(), value.getSizeInView(), value.getCenterInView(), value.getLeftTopInView(), value.getRightBottomInView(), value.getMaterial(), value.getLastDownScale(), value.getLastDownScale()));
            }
        }
        editData.setStickerExtraMap(linkedHashMap);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it5 = editData.getMediaModel().videos.iterator();
        while (true) {
            ResourceModel resourceModel2 = null;
            MusicVolumeControlViewModel musicVolumeControlViewModel = null;
            if (!it5.hasNext()) {
                break;
            }
            MediaClip mediaClip = (MediaClip) it5.next();
            ResourceModel resourceModel3 = mediaClip.resource;
            if (resourceModel3 != null) {
                MusicVolumeControlViewModel musicVolumeControlViewModel2 = this.musicVolumeViewModel;
                if (musicVolumeControlViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("musicVolumeViewModel");
                } else {
                    musicVolumeControlViewModel = musicVolumeControlViewModel2;
                }
                resourceModel2 = ResourceModel.copy$default(resourceModel3, null, null, null, null, null, null, null, null, null, musicVolumeControlViewModel.U1().getValue(), null, null, null, null, null, null, 65023, null);
            }
            arrayList.add(MediaClip.copy$default(mediaClip, resourceModel2, null, null, null, null, null, null, 126, null));
        }
        aw awVar = this.curTavCut;
        if (awVar != null && (V = awVar.V()) != null && (list = V.videos) != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(list, 0);
            MediaClip mediaClip2 = (MediaClip) orNull;
            if (mediaClip2 != null && (resourceModel = mediaClip2.resource) != null && (rectF = resourceModel.picClipRect) != null) {
                float f16 = rectF.right - rectF.left;
                float f17 = rectF.bottom - rectF.top;
                BackgroundModel backgroundModel3 = editData.getMediaModel().backgroundModel;
                if (backgroundModel3 != null) {
                    BackgroundModel backgroundModel4 = editData.getMediaModel().backgroundModel;
                    if (backgroundModel4 != null && (sizeF2 = backgroundModel4.renderSize) != null) {
                        sizeF = SizeF.copy$default(sizeF2, f16, f17, null, 4, null);
                    } else {
                        sizeF = null;
                    }
                    backgroundModel = BackgroundModel.copy$default(backgroundModel3, null, sizeF, null, null, null, null, null, null, 0.0f, null, 1021, null);
                    MediaModel mediaModel = editData.getMediaModel();
                    if (backgroundModel == null) {
                        BackgroundModel backgroundModel5 = editData.getMediaModel().backgroundModel;
                        if (backgroundModel5 != null) {
                            backgroundModel = BackgroundModel.copy$default(backgroundModel5, null, null, null, null, null, null, null, null, 0.0f, null, 1023, null);
                        } else {
                            backgroundModel2 = null;
                            editData.setMediaModel(MediaModel.copy$default(mediaModel, null, null, null, null, null, null, arrayList, null, null, backgroundModel2, null, null, null, null, null, null, null, null, null, 523711, null));
                            dataWrapper.getEditData().add(VideoEditData.copy$default(editData, null, 0L, null, null, null, null, false, 127, null));
                        }
                    }
                    backgroundModel2 = backgroundModel;
                    editData.setMediaModel(MediaModel.copy$default(mediaModel, null, null, null, null, null, null, arrayList, null, null, backgroundModel2, null, null, null, null, null, null, null, null, null, 523711, null));
                    dataWrapper.getEditData().add(VideoEditData.copy$default(editData, null, 0L, null, null, null, null, false, 127, null));
                }
            }
        }
        backgroundModel = null;
        MediaModel mediaModel2 = editData.getMediaModel();
        if (backgroundModel == null) {
        }
        backgroundModel2 = backgroundModel;
        editData.setMediaModel(MediaModel.copy$default(mediaModel2, null, null, null, null, null, null, arrayList, null, null, backgroundModel2, null, null, null, null, null, null, null, null, null, 523711, null));
        dataWrapper.getEditData().add(VideoEditData.copy$default(editData, null, 0L, null, null, null, null, false, 127, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void nj(final VideoEditorFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoEditorViewModel videoEditorViewModel = this$0.videoEditorViewModel;
        FrameLayout frameLayout = null;
        if (videoEditorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
            videoEditorViewModel = null;
        }
        FrameLayout frameLayout2 = this$0.playerContainerWrapper;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerContainerWrapper");
            frameLayout2 = null;
        }
        int width = frameLayout2.getWidth();
        FrameLayout frameLayout3 = this$0.playerContainerWrapper;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerContainerWrapper");
            frameLayout3 = null;
        }
        this$0.uj(videoEditorViewModel.t2(width, frameLayout3.getHeight()));
        this$0.xi();
        Iterator<T> it = this$0.parts.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.qqvideoedit.editor.d) it.next()).L9();
        }
        FrameLayout frameLayout4 = this$0.playerContainerWrapper;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerContainerWrapper");
        } else {
            frameLayout = frameLayout4;
        }
        frameLayout.post(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.editor.ad
            @Override // java.lang.Runnable
            public final void run() {
                VideoEditorFragment.oj(VideoEditorFragment.this);
            }
        });
    }

    private final void oi(View view, int visibility) {
        if (view != null) {
            view.setVisibility(visibility);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oj(final VideoEditorFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SimpleEventBus.getInstance().dispatchEvent(new ReceiveSchemaEvent(com.tencent.mobileqq.qqvideoedit.editor.d.INSTANCE.a(this$0.getActivity())));
        this$0.handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.editor.ag
            @Override // java.lang.Runnable
            public final void run() {
                VideoEditorFragment.pj(VideoEditorFragment.this);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pj(VideoEditorFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        aw awVar = this$0.curTavCut;
        if (awVar != null) {
            awVar.Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qi(VideoEditorFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Dialog dialog = this$0.loadingDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private final void qj(View rootView) {
        View findViewById = rootView.findViewById(R.id.xyv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.ivPlayerStatus)");
        ImageView imageView = (ImageView) findViewById;
        this.playerStatusBtn = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerStatusBtn");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.an
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoEditorFragment.rj(VideoEditorFragment.this, view);
            }
        });
    }

    private final boolean ri() {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.lastDownloadBtnClickTime;
        if (currentTimeMillis - j3 < this.DOWNLOAD_BTN_CLICK_INTERVAL && currentTimeMillis > j3) {
            if (QLog.isColorLevel()) {
                QLog.e("VideoEditorFragment", 2, "click too often, please try again later!");
                return true;
            }
            return true;
        }
        this.lastDownloadBtnClickTime = currentTimeMillis;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rj(VideoEditorFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TimelineViewModel timelineViewModel = this$0.timelineViewModel;
        TimelineViewModel timelineViewModel2 = null;
        if (timelineViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
            timelineViewModel = null;
        }
        if (timelineViewModel.W1().isPlaying()) {
            TimelineViewModel timelineViewModel3 = this$0.timelineViewModel;
            if (timelineViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
                timelineViewModel3 = null;
            }
            timelineViewModel3.W1().pause();
            ImageView imageView = this$0.playerStatusBtn;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playerStatusBtn");
                imageView = null;
            }
            TimelineViewModel timelineViewModel4 = this$0.timelineViewModel;
            if (timelineViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
            } else {
                timelineViewModel2 = timelineViewModel4;
            }
            com.tencent.mobileqq.qqvideoedit.editor.c.a(imageView, timelineViewModel2.W1().isPlaying());
        } else {
            TimelineViewModel timelineViewModel5 = this$0.timelineViewModel;
            if (timelineViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
                timelineViewModel5 = null;
            }
            timelineViewModel5.W1().play();
            ImageView imageView2 = this$0.playerStatusBtn;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playerStatusBtn");
                imageView2 = null;
            }
            TimelineViewModel timelineViewModel6 = this$0.timelineViewModel;
            if (timelineViewModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
            } else {
                timelineViewModel2 = timelineViewModel6;
            }
            com.tencent.mobileqq.qqvideoedit.editor.c.a(imageView2, timelineViewModel2.W1().isPlaying());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void si(View view) {
        com.tencent.mobileqq.qqvideoedit.utils.m mVar = com.tencent.mobileqq.qqvideoedit.utils.m.f276257a;
        if (!mVar.a(getContext())) {
            this.mQQPermission = mVar.b(this, new b(view));
        } else {
            Jj(view);
        }
    }

    private final void sj() {
        ReorderContainerView reorderContainerView = this.reorderContainerView;
        ReorderContainerView reorderContainerView2 = null;
        if (reorderContainerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reorderContainerView");
            reorderContainerView = null;
        }
        reorderContainerView.O(com.tencent.mobileqq.qqvideoedit.editor.clipping.thumbnail.k.f275344a);
        ReorderContainerView reorderContainerView3 = this.reorderContainerView;
        if (reorderContainerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reorderContainerView");
        } else {
            reorderContainerView2 = reorderContainerView3;
        }
        reorderContainerView2.setReorderListener(this.reorderListener);
    }

    private final void ti(ck2.f videoPart) {
        VideoExportViewModel videoExportViewModel;
        TimelineViewModel timelineViewModel = this.timelineViewModel;
        if (timelineViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
            timelineViewModel = null;
        }
        if (timelineViewModel.W1().isPlaying()) {
            TimelineViewModel timelineViewModel2 = this.timelineViewModel;
            if (timelineViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
                timelineViewModel2 = null;
            }
            timelineViewModel2.W1().pause();
        }
        Tj();
        videoPart.V9();
        VideoExportViewModel videoExportViewModel2 = this.mVideoExportViewModel;
        if (videoExportViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoExportViewModel");
            videoExportViewModel = null;
        } else {
            videoExportViewModel = videoExportViewModel2;
        }
        videoExportViewModel.W1(this, this.curTavCut, Ci(), "topic", System.currentTimeMillis(), videoPart.getExportFrom());
    }

    private final void tj(View view) {
        com.tencent.mobileqq.qqvideoedit.editor.d dVar = this.stickerControlPart;
        BorderView.b bVar = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stickerControlPart");
            dVar = null;
        }
        dVar.O9(null);
        View findViewById = view.findViewById(R.id.f88404wz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.stickerControlView)");
        BorderView borderView = (BorderView) findViewById;
        this.stickerBorderView = borderView;
        if (borderView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stickerBorderView");
            borderView = null;
        }
        borderView.setGestureDetectorCallback(this);
        BorderView borderView2 = this.stickerBorderView;
        if (borderView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stickerBorderView");
            borderView2 = null;
        }
        Object obj = this.stickerControlPart;
        if (obj == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stickerControlPart");
            obj = null;
        }
        if (obj instanceof BorderView.b) {
            bVar = (BorderView.b) obj;
        }
        borderView2.setOperationCallback(bVar);
    }

    private final void uj(aw.VideoTavCutParams params) {
        com.tencent.tavcut.session.a aVar;
        IPlayer iPlayer;
        IPlayer currentPlayer;
        if (params == null) {
            return;
        }
        if (this.videoTavCut == null) {
            VideoTavCut videoTavCut = new VideoTavCut();
            this.videoTavCut = videoTavCut;
            videoTavCut.g0(this, params);
            aw awVar = this.videoTavCut;
            if (awVar != null && (currentPlayer = awVar.getCurrentPlayer()) != null) {
                currentPlayer.a(this.playerListener);
            }
        }
        aw awVar2 = this.videoTavCut;
        Intrinsics.checkNotNull(awVar2, "null cannot be cast to non-null type com.tencent.mobileqq.qqvideoedit.editor.VideoTavCut");
        ((VideoTavCut) awVar2).J();
        this.curTavCut = this.videoTavCut;
        BorderView borderView = this.stickerBorderView;
        TimelineViewModel timelineViewModel = null;
        if (borderView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stickerBorderView");
            borderView = null;
        }
        borderView.setBorderViewEventConsumable(true);
        aw awVar3 = this.curTavCut;
        if (awVar3 != null && awVar3.p()) {
            this.handler.post(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.editor.ac
                @Override // java.lang.Runnable
                public final void run() {
                    VideoEditorFragment.vj(VideoEditorFragment.this);
                }
            });
        }
        Rj(params.d().get(0).getDurationUs());
        aw awVar4 = this.curTavCut;
        if (awVar4 != null) {
            awVar4.b(false);
        }
        Iterator<T> it = this.parts.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.qqvideoedit.editor.d) it.next()).J9(params.getEditMode());
        }
        TimelineViewModel timelineViewModel2 = this.timelineViewModel;
        if (timelineViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
            timelineViewModel2 = null;
        }
        aw awVar5 = this.curTavCut;
        if (awVar5 != null) {
            aVar = awVar5.l();
        } else {
            aVar = null;
        }
        Intrinsics.checkNotNull(aVar);
        aw awVar6 = this.curTavCut;
        if (awVar6 != null) {
            iPlayer = awVar6.getCurrentPlayer();
        } else {
            iPlayer = null;
        }
        Intrinsics.checkNotNull(iPlayer);
        timelineViewModel2.f2(aVar, iPlayer);
        TimelineViewModel timelineViewModel3 = this.timelineViewModel;
        if (timelineViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
            timelineViewModel3 = null;
        }
        timelineViewModel3.X1().k(this.renderListener);
        RenderModel x16 = od4.b.f422509e.x(null);
        if (x16 != null) {
            TimelineViewModel timelineViewModel4 = this.timelineViewModel;
            if (timelineViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
            } else {
                timelineViewModel = timelineViewModel4;
            }
            timelineViewModel.X1().g(x16);
        }
        wj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vj(VideoEditorFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.qqvideoedit.editor.menu.e eVar = this$0.dashboardMenuPart;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dashboardMenuPart");
            eVar = null;
        }
        eVar.ba(true);
    }

    private final void wj() {
        aw awVar = this.curTavCut;
        if (awVar instanceof VideoTavCut) {
            Intrinsics.checkNotNull(awVar, "null cannot be cast to non-null type com.tencent.mobileqq.qqvideoedit.editor.VideoTavCut");
            VideoTavCut videoTavCut = (VideoTavCut) awVar;
            List<MediaClip> list = videoTavCut.V().videos;
            VideoEditorViewModel videoEditorViewModel = this.videoEditorViewModel;
            TimelineViewModel timelineViewModel = null;
            if (videoEditorViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
                videoEditorViewModel = null;
            }
            Long value = videoEditorViewModel.U1().getValue();
            if (value == null) {
                value = 0L;
            }
            BackgroundModel backgroundModel = videoTavCut.V().backgroundModel;
            if (backgroundModel != null) {
                TimelineViewModel timelineViewModel2 = this.timelineViewModel;
                if (timelineViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
                } else {
                    timelineViewModel = timelineViewModel2;
                }
                timelineViewModel.g2(list, backgroundModel, value.longValue());
            }
        }
    }

    private final void xi() {
        String str;
        Intent intent;
        VideoEditorViewModel videoEditorViewModel = this.videoEditorViewModel;
        VideoEditorViewModel videoEditorViewModel2 = null;
        if (videoEditorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
            videoEditorViewModel = null;
        }
        if (!videoEditorViewModel.n2()) {
            VideoEditorViewModel videoEditorViewModel3 = this.videoEditorViewModel;
            if (videoEditorViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
                videoEditorViewModel3 = null;
            }
            if (!videoEditorViewModel3.l2()) {
                return;
            }
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            str = intent.getStringExtra("key_video_video_mission_id");
        } else {
            str = null;
        }
        VideoEditDataWrapper a16 = wj2.a.a(str);
        if (a16 != null) {
            MusicVolumeControlViewModel musicVolumeControlViewModel = this.musicVolumeViewModel;
            if (musicVolumeControlViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicVolumeViewModel");
                musicVolumeControlViewModel = null;
            }
            VideoEditorViewModel videoEditorViewModel4 = this.videoEditorViewModel;
            if (videoEditorViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
                videoEditorViewModel4 = null;
            }
            boolean z16 = true;
            musicVolumeControlViewModel.b2(!videoEditorViewModel4.getIsAllImages());
            MusicVolumeControlViewModel musicVolumeControlViewModel2 = this.musicVolumeViewModel;
            if (musicVolumeControlViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicVolumeViewModel");
                musicVolumeControlViewModel2 = null;
            }
            musicVolumeControlViewModel2.P1(a16.getOriginVolume(), MusicVolumeControlViewModel.VolumeType.ORIGIN);
            MusicVolumeControlViewModel musicVolumeControlViewModel3 = this.musicVolumeViewModel;
            if (musicVolumeControlViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicVolumeViewModel");
                musicVolumeControlViewModel3 = null;
            }
            musicVolumeControlViewModel3.a2(a16.getBgmVolumeType());
            MusicVolumeControlViewModel musicVolumeControlViewModel4 = this.musicVolumeViewModel;
            if (musicVolumeControlViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicVolumeViewModel");
                musicVolumeControlViewModel4 = null;
            }
            musicVolumeControlViewModel4.P1(a16.getBgmVolume(), a16.getBgmVolumeType());
            MusicVolumeControlViewModel musicVolumeControlViewModel5 = this.musicVolumeViewModel;
            if (musicVolumeControlViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicVolumeViewModel");
                musicVolumeControlViewModel5 = null;
            }
            VideoEditorViewModel videoEditorViewModel5 = this.videoEditorViewModel;
            if (videoEditorViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
            } else {
                videoEditorViewModel2 = videoEditorViewModel5;
            }
            if (!videoEditorViewModel2.getIsAllImages() || a16.getOriginVolume() <= 0.0f) {
                z16 = false;
            }
            musicVolumeControlViewModel5.c2(z16);
        }
    }

    @RequiresApi(api = 19)
    private final void xj() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        VideoTrackContainerView videoTrackContainerView = new VideoTrackContainerView(requireContext, null, 0, 6, null);
        this.videoTrack = videoTrackContainerView;
        videoTrackContainerView.setFixedMaxDuration(this.mFixedMaxDuration);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.tencent.videocut.utils.e.f384236a.a(47.0f));
        VideoTrackContainerView videoTrackContainerView2 = this.videoTrack;
        VideoTrackContainerView videoTrackContainerView3 = null;
        if (videoTrackContainerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
            videoTrackContainerView2 = null;
        }
        videoTrackContainerView2.setLayoutParams(layoutParams);
        com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.n nVar = this.videoTrackController;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTrackController");
            nVar = null;
        }
        VideoTrackContainerView videoTrackContainerView4 = this.videoTrack;
        if (videoTrackContainerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
        } else {
            videoTrackContainerView3 = videoTrackContainerView4;
        }
        nVar.u(videoTrackContainerView3);
    }

    private final void yi(View view) {
        View findViewById = view.findViewById(R.id.t2c);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.backBtn)");
        ImageView imageView = (ImageView) findViewById;
        this.backBtn = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VideoEditorFragment.zi(VideoEditorFragment.this, view2);
            }
        });
    }

    private final void yj(View view) {
        ViewModel viewModel = getViewModel(VideoEditorViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(VideoEditorViewModel::class.java)");
        this.videoEditorViewModel = (VideoEditorViewModel) viewModel;
        ViewModel viewModel2 = getViewModel(TimelineViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(TimelineViewModel::class.java)");
        this.timelineViewModel = (TimelineViewModel) viewModel2;
        Fi();
        Hi();
        Ui();
        Ni(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zi(VideoEditorFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        aw awVar = this$0.curTavCut;
        boolean z16 = false;
        if (awVar != null && awVar.U()) {
            z16 = true;
        }
        if (z16) {
            this$0.zj();
        } else {
            VideoEditorViewModel videoEditorViewModel = this$0.videoEditorViewModel;
            if (videoEditorViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
                videoEditorViewModel = null;
            }
            videoEditorViewModel.s2(this$0.getContext());
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        com.tencent.mobileqq.qqvideoedit.editor.c.i(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    public final void Gj() {
        IPlayer currentPlayer;
        aw awVar = this.curTavCut;
        if (awVar != null && (currentPlayer = awVar.getCurrentPlayer()) != null) {
            currentPlayer.pause();
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.view.BorderView.a
    public void Lb(@NotNull BorderView.Direction direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
    }

    public final void Mj(@Nullable LocalMediaInfo localMediaInfo) {
        if (localMediaInfo != null && getActivity() != null) {
            Intent intent = requireActivity().getIntent();
            String str = localMediaInfo.path;
            ArrayList<String> arrayList = new ArrayList<>();
            if (str != null) {
                arrayList.add(str);
            }
            HashMap hashMap = new HashMap();
            SendVideoInfo sendVideoInfo = new SendVideoInfo();
            sendVideoInfo.fileSize = localMediaInfo.fileSize;
            sendVideoInfo.duration = localMediaInfo.mDuration;
            hashMap.put(0, sendVideoInfo);
            intent.putExtra(PeakConstants.VIDEO_INFO, hashMap);
            ((IVideoExportApi) QRoute.api(IVideoExportApi.class)).sendVideo(getActivity(), intent, arrayList, 0, true);
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.e
    public void N8(@NotNull com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.d event) {
        Intrinsics.checkNotNullParameter(event, "event");
        TimelineViewModel timelineViewModel = null;
        TimelineViewModel timelineViewModel2 = null;
        TimelineViewModel timelineViewModel3 = null;
        TextView textView = null;
        TimelineViewModel timelineViewModel4 = null;
        if (event instanceof com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.i) {
            TimelineViewModel timelineViewModel5 = this.timelineViewModel;
            if (timelineViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
            } else {
                timelineViewModel2 = timelineViewModel5;
            }
            timelineViewModel2.d2((com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.i) event);
            return;
        }
        if (event instanceof com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.j) {
            TimelineViewModel timelineViewModel6 = this.timelineViewModel;
            if (timelineViewModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
            } else {
                timelineViewModel3 = timelineViewModel6;
            }
            timelineViewModel3.e2((com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.j) event);
            Sj();
            this.isPendingClipEnd = true;
            return;
        }
        if (!(event instanceof com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.b) && !(event instanceof com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.k) && !(event instanceof com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.g)) {
            if (event instanceof com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.a) {
                if (((com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.a) event).getActive()) {
                    this.isSeekFromClipEnd = false;
                    TimelineViewModel timelineViewModel7 = this.timelineViewModel;
                    if (timelineViewModel7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
                        timelineViewModel7 = null;
                    }
                    boolean isPlaying = timelineViewModel7.W1().isPlaying();
                    this.isPlayingBeforeEditVideo = isPlaying;
                    if (isPlaying) {
                        TimelineViewModel timelineViewModel8 = this.timelineViewModel;
                        if (timelineViewModel8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
                            timelineViewModel8 = null;
                        }
                        timelineViewModel8.W1().pause();
                    }
                    this.hasTimeLineActivated = true;
                    TextView textView2 = this.clipTimeText;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("clipTimeText");
                        textView2 = null;
                    }
                    textView2.setVisibility(0);
                    TextView textView3 = this.timeText;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("timeText");
                    } else {
                        textView = textView3;
                    }
                    textView.setVisibility(8);
                    return;
                }
                this.isSeekFromClipEnd = true;
                TimelineViewModel timelineViewModel9 = this.timelineViewModel;
                if (timelineViewModel9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
                    timelineViewModel9 = null;
                }
                timelineViewModel9.W1().seek(0L);
                if (this.isPlayingBeforeEditVideo) {
                    TimelineViewModel timelineViewModel10 = this.timelineViewModel;
                    if (timelineViewModel10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
                    } else {
                        timelineViewModel4 = timelineViewModel10;
                    }
                    timelineViewModel4.W1().play();
                    return;
                }
                return;
            }
            return;
        }
        TimelineViewModel timelineViewModel11 = this.timelineViewModel;
        if (timelineViewModel11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
        } else {
            timelineViewModel = timelineViewModel11;
        }
        timelineViewModel.c2();
    }

    public final void Pj(@Nullable final CharSequence msg2, final boolean cancelable, long delay, @Nullable final DialogInterface.OnDismissListener dismissListener) {
        if (getActivity() == null) {
            return;
        }
        final FragmentActivity activity = getActivity();
        this.handler.removeCallbacksAndMessages(null);
        this.handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.editor.ae
            @Override // java.lang.Runnable
            public final void run() {
                VideoEditorFragment.Qj(VideoEditorFragment.this, activity, msg2, cancelable, dismissListener);
            }
        }, delay);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<? extends Part> assembleParts() {
        if (!this.parts.isEmpty()) {
            this.parts.clear();
        }
        com.tencent.mobileqq.qqvideoedit.editor.menu.e eVar = new com.tencent.mobileqq.qqvideoedit.editor.menu.e();
        this.dashboardMenuPart = eVar;
        this.parts.add(eVar);
        ck2.b bVar = this.partFactory;
        ck2.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partFactory");
            bVar = null;
        }
        com.tencent.mobileqq.qqvideoedit.editor.d c16 = bVar.c();
        this.textMenuPart = c16;
        List<com.tencent.mobileqq.qqvideoedit.editor.d> list = this.parts;
        if (c16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textMenuPart");
            c16 = null;
        }
        list.add(c16);
        ck2.b bVar3 = this.partFactory;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partFactory");
            bVar3 = null;
        }
        com.tencent.mobileqq.qqvideoedit.editor.d a16 = bVar3.a();
        this.stickerControlPart = a16;
        List<com.tencent.mobileqq.qqvideoedit.editor.d> list2 = this.parts;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stickerControlPart");
            a16 = null;
        }
        list2.add(a16);
        ck2.b bVar4 = this.partFactory;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partFactory");
            bVar4 = null;
        }
        com.tencent.mobileqq.qqvideoedit.editor.d f16 = bVar4.f();
        if (f16 != null) {
            this.parts.add(f16);
        }
        ck2.b bVar5 = this.partFactory;
        if (bVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partFactory");
            bVar5 = null;
        }
        ck2.f d16 = bVar5.d();
        this.videoExportPart = d16;
        List<com.tencent.mobileqq.qqvideoedit.editor.d> list3 = this.parts;
        if (d16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoExportPart");
            d16 = null;
        }
        list3.add(d16);
        ck2.b bVar6 = this.partFactory;
        if (bVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partFactory");
            bVar6 = null;
        }
        ck2.f e16 = bVar6.e();
        this.videoDownloadPart = e16;
        List<com.tencent.mobileqq.qqvideoedit.editor.d> list4 = this.parts;
        if (e16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoDownloadPart");
            e16 = null;
        }
        list4.add(e16);
        List<com.tencent.mobileqq.qqvideoedit.editor.d> list5 = this.parts;
        ck2.b bVar7 = this.partFactory;
        if (bVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partFactory");
        } else {
            bVar2 = bVar7;
        }
        list5.addAll(bVar2.b());
        return this.parts;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.a
    public void g1(boolean isChildShow) {
        VideoEditorViewModel videoEditorViewModel = this.videoEditorViewModel;
        if (videoEditorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
            videoEditorViewModel = null;
        }
        videoEditorViewModel.L1(isChildShow);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.h1m;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QQVideoEditFinishActivityEvent.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "VideoEditorFragment";
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    @Nullable
    public PartManager getPartManager() {
        if (this.mPartManager == null) {
            this.mPartManager = new ck2.i(this, getFragmentContentView());
        }
        return this.mPartManager;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.view.BorderView.a
    public int getRenderHeight() {
        Size renderSize;
        Integer num;
        aw awVar = this.curTavCut;
        if (awVar != null && (renderSize = awVar.getRenderSize()) != null && (num = renderSize.height) != null) {
            return num.intValue();
        }
        FrameLayout frameLayout = this.playerContainerWrapper;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerContainerWrapper");
            frameLayout = null;
        }
        return frameLayout.getHeight();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.view.BorderView.a
    public int getRenderWidth() {
        Size renderSize;
        Integer num;
        aw awVar = this.curTavCut;
        if (awVar != null && (renderSize = awVar.getRenderSize()) != null && (num = renderSize.width) != null) {
            return num.intValue();
        }
        FrameLayout frameLayout = this.playerContainerWrapper;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerContainerWrapper");
            frameLayout = null;
        }
        return frameLayout.getWidth();
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0073, code lost:
    
        if (r3[1] <= 0) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0104  */
    @Override // com.tencent.mobileqq.qqvideoedit.editor.view.BorderView.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean nh(boolean isMove, @Nullable int[] touchLocationOnScreen) {
        int i3;
        boolean z16;
        if (isMove) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        ImageView imageView = this.backBtn;
        View view = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
            imageView = null;
        }
        oi(imageView, i3);
        if (this.isShowTextMenu) {
            LinearLayout linearLayout = this.menuBar;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("menuBar");
                linearLayout = null;
            }
            oi(linearLayout, i3);
        } else {
            LinearLayout linearLayout2 = this.menuBar;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("menuBar");
                linearLayout2 = null;
            }
            oi(linearLayout2, 4);
        }
        QUIButton qUIButton = this.nextButton;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextButton");
            qUIButton = null;
        }
        oi(qUIButton, i3);
        if (isMove) {
            View view2 = this.flBottomBar;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("flBottomBar");
                view2 = null;
            }
            oi(view2, 4);
            View view3 = this.flBottomBarDelete;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("flBottomBarDelete");
                view3 = null;
            }
            oi(view3, 0);
            if (touchLocationOnScreen != null && touchLocationOnScreen.length > 1) {
                int[] iArr = this.flBottomBarDeleteLocationOnScreen;
                if (iArr != null) {
                    Intrinsics.checkNotNull(iArr);
                }
                this.flBottomBarDeleteLocationOnScreen = new int[2];
                View view4 = this.flBottomBarDeleteBg;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("flBottomBarDeleteBg");
                    view4 = null;
                }
                view4.getLocationOnScreen(this.flBottomBarDeleteLocationOnScreen);
                int[] iArr2 = this.flBottomBarDeleteLocationOnScreen;
                Intrinsics.checkNotNull(iArr2);
                if (iArr2[1] > 0) {
                    int i16 = touchLocationOnScreen[1];
                    int[] iArr3 = this.flBottomBarDeleteLocationOnScreen;
                    Intrinsics.checkNotNull(iArr3);
                    if (i16 > iArr3[1]) {
                        z16 = true;
                        if (!z16) {
                            if (!this.hasAnimateDelete) {
                                this.hasAnimateDelete = true;
                                View view5 = this.flBottomBarDeleteBg;
                                if (view5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("flBottomBarDeleteBg");
                                    view5 = null;
                                }
                                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view5, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.143f);
                                View view6 = this.flBottomBarDeleteBg;
                                if (view6 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("flBottomBarDeleteBg");
                                    view6 = null;
                                }
                                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view6, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.143f);
                                AnimatorSet animatorSet = new AnimatorSet();
                                animatorSet.setDuration(250L);
                                animatorSet.playTogether(ofFloat, ofFloat2);
                                animatorSet.start();
                            }
                            ImageView imageView2 = this.flBottomBarGarbage;
                            if (imageView2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("flBottomBarGarbage");
                                imageView2 = null;
                            }
                            imageView2.setImageResource(R.drawable.f161874nh3);
                            View view7 = this.flBottomBarDeleteBg;
                            if (view7 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("flBottomBarDeleteBg");
                            } else {
                                view = view7;
                            }
                            view.setBackgroundResource(R.drawable.ngn);
                        } else {
                            this.hasAnimateDelete = false;
                            ImageView imageView3 = this.flBottomBarGarbage;
                            if (imageView3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("flBottomBarGarbage");
                                imageView3 = null;
                            }
                            imageView3.setImageResource(R.drawable.ngo);
                            View view8 = this.flBottomBarDeleteBg;
                            if (view8 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("flBottomBarDeleteBg");
                            } else {
                                view = view8;
                            }
                            view.setBackgroundResource(R.drawable.ngm);
                        }
                        return z16;
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
            return z16;
        }
        View view9 = this.flBottomBar;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flBottomBar");
            view9 = null;
        }
        oi(view9, 0);
        View view10 = this.flBottomBarDelete;
        if (view10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flBottomBarDelete");
        } else {
            view = view10;
        }
        oi(view, 4);
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        String str;
        boolean z16;
        Intent intent;
        Intent intent2;
        Intent intent3;
        Intent intent4;
        Intent intent5;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        Ej();
        VideoEditorResourceManager.L().Z();
        VideoEditorResourceManager.L().a0();
        VideoEditorResourceManager.L().b0();
        VideoEditorResourceManager.L().c0();
        VideoEditorResourceManager.L().d0();
        TransitionResourceManager.c().i(context);
        com.tencent.mobileqq.qqvideoedit.a.a().addObserver(this);
        this.editorDataServiceHandler.M2("MqKuaishanEdit");
        FragmentActivity activity = getActivity();
        if (activity != null && (intent5 = activity.getIntent()) != null) {
            str = intent5.getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID);
        } else {
            str = null;
        }
        this.clientTraceId = str;
        FragmentActivity activity2 = getActivity();
        long j3 = 0;
        if (activity2 != null && (intent4 = activity2.getIntent()) != null) {
            j3 = intent4.getLongExtra("key_fixed_max_duration", 0L);
        }
        this.mFixedMaxDuration = j3;
        FragmentActivity activity3 = getActivity();
        boolean z17 = true;
        if (activity3 != null && (intent3 = activity3.getIntent()) != null) {
            z17 = intent3.getBooleanExtra("IS_SHOW_TEXT_MENU", true);
        }
        this.isShowTextMenu = z17;
        FragmentActivity activity4 = getActivity();
        int i3 = 0;
        if (activity4 != null && (intent2 = activity4.getIntent()) != null) {
            z16 = intent2.getBooleanExtra("IS_IGNORE_ATTRACT", false);
        } else {
            z16 = false;
        }
        this.isIgnoreAttract = z16;
        FragmentActivity activity5 = getActivity();
        if (activity5 != null && (intent = activity5.getIntent()) != null) {
            i3 = intent.getIntExtra("EDIT_FROM_TYPE", 0);
        }
        this.partFactory = ck2.h.a(i3);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        MenuType menuType;
        VideoEditorViewModel videoEditorViewModel = this.videoEditorViewModel;
        VideoEditorViewModel videoEditorViewModel2 = null;
        if (videoEditorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
            videoEditorViewModel = null;
        }
        if (videoEditorViewModel.getMIsDisableOther()) {
            return true;
        }
        ImageView imageView = this.backBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
            imageView = null;
        }
        com.tencent.mobileqq.qqvideoedit.editor.c.i(imageView);
        VideoEditorViewModel videoEditorViewModel3 = this.videoEditorViewModel;
        if (videoEditorViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
            videoEditorViewModel3 = null;
        }
        MenuSwitchAction value = videoEditorViewModel3.c2().getValue();
        if (value != null) {
            menuType = value.getMenuType();
        } else {
            menuType = null;
        }
        if (menuType == MenuType.CLIPPING) {
            return super.onBackEvent();
        }
        aw awVar = this.curTavCut;
        boolean z16 = false;
        if (awVar != null && awVar.U()) {
            z16 = true;
        }
        if (z16) {
            zj();
            return true;
        }
        VideoEditorViewModel videoEditorViewModel4 = this.videoEditorViewModel;
        if (videoEditorViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoEditorViewModel");
        } else {
            videoEditorViewModel2 = videoEditorViewModel4;
        }
        videoEditorViewModel2.s2(getContext());
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Gj();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ms.a.c("VideoEditorFragment", "tavcut release start ");
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        aw awVar = this.videoTavCut;
        if (awVar != null) {
            awVar.release();
        }
        aw awVar2 = this.imageTavCut;
        if (awVar2 != null) {
            awVar2.release();
        }
        com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.n nVar = this.videoTrackController;
        TimelineViewModel timelineViewModel = null;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoTrackController");
            nVar = null;
        }
        nVar.B();
        TimelineViewModel timelineViewModel2 = this.timelineViewModel;
        if (timelineViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
        } else {
            timelineViewModel = timelineViewModel2;
        }
        timelineViewModel.h2();
        com.tencent.mobileqq.qqvideoedit.a.a().removeObserver(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Fj(hidden);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Gj();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QQVideoEditFinishActivityEvent) {
            ms.a.c("VideoEditorFragment", "receive QQVideoEditFinishActivityEvent: release cutsession ");
            aw awVar = this.videoTavCut;
            if (awVar != null) {
                awVar.release();
            }
            aw awVar2 = this.imageTavCut;
            if (awVar2 != null) {
                awVar2.release();
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        QQPermission qQPermission = this.mQQPermission;
        if (qQPermission == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQQPermission");
            qQPermission = null;
        }
        qQPermission.onRequestPermissionResult(requestCode, permissions, grantResults);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Ij();
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int type, boolean isSuccess, @Nullable Object data) {
        if (1 == type) {
            VideoEditorResourceManager.L().j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003d, code lost:
    
        if (r5.getBooleanExtra(cooperation.peak.PeakConstants.VIDEO_EDIT_AND_THEN_PREVIEW, false) == true) goto L15;
     */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onViewCreatedAfterPartInit(@NotNull View view, @Nullable Bundle savedInstanceState) {
        boolean z16;
        ArrayList arrayList;
        Intent intent;
        Intent intent2;
        FrameLayout frameLayout;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreatedAfterPartInit(view, savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null && (frameLayout = (FrameLayout) activity.findViewById(R.id.ckj)) != null) {
            frameLayout.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.bd5));
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (r5 = activity2.getIntent()) != null) {
            z16 = true;
        }
        z16 = false;
        this.nextStepToPreview = z16;
        FragmentActivity activity3 = getActivity();
        LocalMediaInfo localMediaInfo = null;
        if (activity3 != null && (intent2 = activity3.getIntent()) != null) {
            arrayList = intent2.getParcelableArrayListExtra(AEEditorConstants.KEY_WINK_LOCAL_MEDIA_INFOS);
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            localMediaInfo = (LocalMediaInfo) arrayList.get(0);
        }
        this.originLocalMediaInfo = localMediaInfo;
        FragmentActivity activity4 = getActivity();
        int i3 = 5;
        if (activity4 != null && (intent = activity4.getIntent()) != null) {
            i3 = intent.getIntExtra("uintype", 5);
        }
        this.uinType = i3;
        SimpleEventBus.getInstance().registerReceiver(this);
        yj(view);
        Bi();
        initView(view);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        od4.b.s(context, "", "lightsdk_qq", QQWinkConstants.ENTRY_QQ_WORLD);
        mj2.b.d(2, 6);
        od4.a.f422504b.b(false);
        bj();
        Si();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.BaseVideEditorFragment
    public int ph() {
        FrameLayout frameLayout = this.playerContainerWrapper;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerContainerWrapper");
            frameLayout = null;
        }
        return frameLayout.getHeight();
    }

    public final void pi() {
        this.handler.removeCallbacksAndMessages(null);
        this.handler.post(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.editor.af
            @Override // java.lang.Runnable
            public final void run() {
                VideoEditorFragment.qi(VideoEditorFragment.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.BaseVideEditorFragment
    public int qh() {
        FrameLayout frameLayout = this.playerContainerWrapper;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerContainerWrapper");
            frameLayout = null;
        }
        return frameLayout.getWidth();
    }

    @NotNull
    public final ArrayList<MediaClip> ui() {
        TimelineViewModel timelineViewModel = this.timelineViewModel;
        if (timelineViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
            timelineViewModel = null;
        }
        return timelineViewModel.T1();
    }

    @NotNull
    /* renamed from: vi, reason: from getter */
    public final IPlayer.a getPlayerListener() {
        return this.playerListener;
    }

    @Nullable
    /* renamed from: wi, reason: from getter */
    public aw getCurTavCut() {
        return this.curTavCut;
    }

    public final boolean zj() {
        QQCustomDialog negativeButton = DialogUtil.createCustomDialog(getActivity(), 230).setTitle(getResources().getString(R.string.f237777hz)).setPositiveButton(getResources().getString(R.string.f237767hy), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.w
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                VideoEditorFragment.Aj(VideoEditorFragment.this, dialogInterface, i3);
            }
        }).setNegativeButton(getResources().getString(R.string.f237757hx), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.x
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                VideoEditorFragment.Bj(dialogInterface, i3);
            }
        });
        negativeButton.getRootView().setBackgroundResource(R.drawable.kvy);
        negativeButton.getBtnLeft().setTextColor(getResources().getColor(android.R.color.white));
        negativeButton.getBtnight().setTextColor(getResources().getColor(android.R.color.white));
        negativeButton.getTitleTextView().setTextColor(getResources().getColor(android.R.color.white));
        negativeButton.getDialogDivider().setBackgroundColor(getResources().getColor(R.color.bdz));
        try {
            if (!negativeButton.isShowing()) {
                negativeButton.show();
                return true;
            }
            return true;
        } catch (Throwable th5) {
            ms.a.e("VideoEditorFragment", th5);
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/VideoEditorFragment$e", "Lcom/tencent/tavcut/session/d;", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "newData", "", "duration", "mediaDuration", "", ICustomDataEditor.STRING_ARRAY_PARAM_1, "onRenderDataApplied", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class e implements com.tencent.tavcut.session.d {
        e() {
        }

        @Override // com.tencent.tavcut.session.d
        public void a1(@NotNull RenderModel newData, long duration, long mediaDuration) {
            Intrinsics.checkNotNullParameter(newData, "newData");
            TimelineViewModel timelineViewModel = null;
            if (!VideoEditorFragment.this.hasScaledView) {
                VideoEditorFragment.this.hasScaledView = true;
                VideoTrackContainerView videoTrackContainerView = VideoEditorFragment.this.videoTrack;
                if (videoTrackContainerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoTrack");
                    videoTrackContainerView = null;
                }
                int measuredWidth = videoTrackContainerView.getMeasuredWidth();
                com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.videotrack.n nVar = VideoEditorFragment.this.videoTrackController;
                if (nVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoTrackController");
                    nVar = null;
                }
                rj2.a l3 = nVar.l();
                l3.o(duration);
                if (l3.c() > 0) {
                    l3.m(((measuredWidth - (com.tencent.videocut.utils.e.f384236a.a(16.0f) * 2)) * 1.0f) / l3.c());
                } else {
                    QLog.e("VideoEditorFragment", 2, "onRenderDataChanged currentMaxSpace value is not valid!");
                }
            }
            TimelineViewModel timelineViewModel2 = VideoEditorFragment.this.timelineViewModel;
            if (timelineViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
                timelineViewModel2 = null;
            }
            timelineViewModel2.m2(newData.getTimeLines());
            TimelineViewModel timelineViewModel3 = VideoEditorFragment.this.timelineViewModel;
            if (timelineViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
                timelineViewModel3 = null;
            }
            if (timelineViewModel3.getFirstEnter()) {
                TimelineViewModel timelineViewModel4 = VideoEditorFragment.this.timelineViewModel;
                if (timelineViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
                    timelineViewModel4 = null;
                }
                timelineViewModel4.n2();
                TimelineViewModel timelineViewModel5 = VideoEditorFragment.this.timelineViewModel;
                if (timelineViewModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("timelineViewModel");
                } else {
                    timelineViewModel = timelineViewModel5;
                }
                timelineViewModel.i2(false);
            }
        }

        @Override // com.tencent.tavcut.session.d
        public void onRenderDataApplied() {
        }
    }

    public final void Ij() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/VideoEditorFragment$c", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "p0", "", "onAnimationCancel", "onAnimationRepeat", "animation", "onAnimationEnd", "", "isReverse", "onAnimationStart", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c extends com.tencent.mobileqq.widget.f {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            TextView textView = VideoEditorFragment.this.showHDRTips;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("showHDRTips");
                textView = null;
            }
            textView.setVisibility(8);
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation, boolean isReverse) {
            TextView textView = VideoEditorFragment.this.showHDRTips;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("showHDRTips");
                textView = null;
            }
            textView.setVisibility(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator p06) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator p06) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pi(DialogInterface dialogInterface) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qi(DialogInterface dialogInterface) {
    }

    private final void Rj(long durationUs) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bj(DialogInterface dialogInterface, int i3) {
    }
}
