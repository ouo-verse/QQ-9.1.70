package com.tencent.mobileqq.zplan.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.easteregg.model.d;
import com.tencent.mobileqq.zplan.easteregg.t;
import com.tencent.mobileqq.zplan.easteregg.u;
import com.tencent.mobileqq.zplan.easteregg.w;
import com.tencent.mobileqq.zplan.meme.ZPlanRecordScene;
import com.tencent.mobileqq.zplan.meme.frameanim.ZPlanAvatarBannerParams;
import com.tencent.mobileqq.zplan.meme.frameanim.e;
import com.tencent.mobileqq.zplan.model.MaintEntryType;
import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import com.tencent.mobileqq.zplan.model.ZPlanMaintInfo;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqnt.aio.api.INTZPlanAvatarView;
import com.tencent.state.data.SquareJSConst;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener;
import com.tencent.zplan.meme.EngineType;
import com.tencent.zplan.record.model.Source;
import com.tencent.zplan.world.IZPlanWorldStatusListener;
import com.tencent.zplan.world.view.NormalRenderTextureView;
import cooperation.qzone.panorama.util.PanoramaConfig;
import gw4.f;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ji3.j;
import ji3.k;
import ji3.l;
import ji3.m;
import ji3.n;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000\u00f2\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u00aa\u00022\u00020\u0001:\u0004\u00ab\u0002\u00ac\u0002J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J$\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\bH&J0\u0010\u0010\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0006H&J\"\u0010\u0017\u001a\u00020\u00022\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0006H&J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H&J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H&J\b\u0010\u001c\u001a\u00020\u0002H&J\b\u0010\u001e\u001a\u00020\u001dH&J\n\u0010 \u001a\u0004\u0018\u00010\u001fH&J\u001e\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u0019\u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010\u0006H&J\b\u0010%\u001a\u00020\u0004H&J\b\u0010'\u001a\u00020&H&J \u0010-\u001a\u00020,2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H&J\u0018\u0010.\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(2\u0006\u0010\u0016\u001a\u00020\u0006H&J\u0018\u0010/\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(2\u0006\u0010\u0016\u001a\u00020\u0006H&J\u0018\u00100\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(2\u0006\u0010\u0016\u001a\u00020\u0006H&J\"\u00100\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(2\u0006\u0010\u0016\u001a\u00020\u00062\b\u00102\u001a\u0004\u0018\u000101H&J\u0010\u00103\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(H&J\u0010\u00106\u001a\u00020\u00022\u0006\u00105\u001a\u000204H&J\u0010\u00107\u001a\u00020\u00022\u0006\u00105\u001a\u000204H&J\u0010\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u000208H&J\b\u0010;\u001a\u00020\u0004H&J\"\u0010?\u001a\u00020\u00022\u0006\u0010<\u001a\u00020\u00182\u0006\u0010=\u001a\u0002082\b\u0010\u000f\u001a\u0004\u0018\u00010>H&J\u001a\u0010A\u001a\u00020\u00022\u0006\u0010=\u001a\u0002082\b\u0010\u000f\u001a\u0004\u0018\u00010@H&J\u0018\u0010C\u001a\u00020\u00022\u0006\u0010=\u001a\u0002082\u0006\u0010\u000f\u001a\u00020BH&J\b\u0010D\u001a\u00020\u0002H&J\b\u0010E\u001a\u00020\u0002H&J8\u0010N\u001a\u00020\u00022\b\u0010G\u001a\u0004\u0018\u00010F2\u0006\u0010I\u001a\u00020H2\u0006\u0010K\u001a\u00020J2\b\u0010L\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u0006H&J\b\u0010O\u001a\u00020\u0002H&J\u001a\u0010R\u001a\u00020\u00022\u0006\u0010Q\u001a\u00020P2\b\b\u0002\u0010\u0016\u001a\u00020\u0006H&J\u0010\u0010V\u001a\u00020U2\u0006\u0010T\u001a\u00020SH&J\u0010\u0010W\u001a\u00020U2\u0006\u0010T\u001a\u00020SH&J\u001a\u0010Y\u001a\u00020\u00022\u0006\u0010T\u001a\u00020S2\b\u0010\u000f\u001a\u0004\u0018\u00010XH&J\u0012\u0010[\u001a\u0004\u0018\u00010\u00062\u0006\u0010Z\u001a\u00020\u0006H&J\u001a\u0010\\\u001a\u0004\u0018\u00010\u00062\u0006\u0010Z\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u0006H&J\u0010\u0010]\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u0006H&J\u001a\u0010^\u001a\u0004\u0018\u00010\u00062\u0006\u0010Z\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u0006H&J\u0010\u0010`\u001a\u00020_2\u0006\u00109\u001a\u00020\u0006H&J\u0018\u0010c\u001a\u00020b2\u0006\u0010a\u001a\u00020\b2\u0006\u0010Z\u001a\u00020\u0006H&J<\u0010g\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(2\u0006\u0010d\u001a\u00020\u00062\"\u00102\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060ej\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`fH&J\u0010\u0010h\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(H&J<\u0010i\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(2\u0006\u0010d\u001a\u00020\u00062\"\u00102\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060ej\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`fH&J4\u0010j\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(2\"\u00102\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060ej\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`fH&J4\u0010k\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(2\"\u00102\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060ej\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`fH&J\n\u0010l\u001a\u0004\u0018\u00010\u0018H&J\u0018\u0010n\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(2\u0006\u0010m\u001a\u00020\u0006H&J\u0018\u0010o\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(2\u0006\u0010m\u001a\u00020\u0006H&J0\u0010x\u001a\u00020w2\u0006\u0010)\u001a\u00020(2\u0006\u0010q\u001a\u00020p2\u0006\u0010s\u001a\u00020r2\u0006\u0010t\u001a\u00020p2\u0006\u0010v\u001a\u00020uH&J\b\u0010y\u001a\u00020\bH&J\u0010\u0010z\u001a\u00020\b2\u0006\u00109\u001a\u00020\u0006H&J\"\u0010\u007f\u001a\u00020\u00042\u0006\u0010{\u001a\u00020\b2\u0006\u0010|\u001a\u00020\u00062\b\u0010~\u001a\u0004\u0018\u00010}H&J#\u0010\u0080\u0001\u001a\u00020\u00022\u0006\u0010{\u001a\u00020\b2\u0006\u0010|\u001a\u00020\u00062\b\u0010~\u001a\u0004\u0018\u00010}H&J\u0013\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00062\u0006\u00109\u001a\u00020\u0006H&J\u0013\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00062\u0006\u00109\u001a\u00020\u0006H&J\u0013\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00062\u0006\u00109\u001a\u00020\u0006H&J\t\u0010\u0084\u0001\u001a\u00020\u0002H&J\t\u0010\u0085\u0001\u001a\u00020\u0006H&J(\u0010\u0089\u0001\u001a\u00020\u00022\u0007\u0010\u0086\u0001\u001a\u00020\u00062\u0014\u0010\u0088\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u0087\u0001H&J(\u0010\u008a\u0001\u001a\u00020\u00022\u0007\u0010\u0086\u0001\u001a\u00020\u00062\u0014\u0010\u0088\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u0087\u0001H&J\t\u0010\u008b\u0001\u001a\u00020\u0002H&J\u001a\u0010\u008d\u0001\u001a\u00020\u00022\u0006\u0010G\u001a\u00020F2\u0007\u0010\u008c\u0001\u001a\u000208H&J\u001b\u0010\u0090\u0001\u001a\u00020\u00022\u0007\u0010\u008e\u0001\u001a\u00020\u00042\u0007\u0010\u000f\u001a\u00030\u008f\u0001H&J\u0011\u0010\u0091\u0001\u001a\u00020\b2\u0006\u00109\u001a\u00020\u0006H&J\u0019\u0010\u0092\u0001\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u00109\u001a\u000208H&JO\u0010\u0099\u0001\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010(2\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u0011\u001a\u00030\u0096\u00012\u0007\u0010\u0097\u0001\u001a\u00020\u00042\u0007\u0010\u0098\u0001\u001a\u000208H&J\u001a\u0010\u009b\u0001\u001a\u00020\u00022\u0006\u0010G\u001a\u00020F2\u0007\u0010\u009a\u0001\u001a\u000201H&J4\u0010\u009d\u0001\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u00062\u0006\u0010d\u001a\u00020\u00062\u0019\u0010\u0015\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u009c\u0001H&J\u001a\u0010\u009f\u0001\u001a\u00020\u00022\u0006\u0010G\u001a\u00020F2\u0007\u0010\u009e\u0001\u001a\u00020\u0006H&J\t\u0010\u00a0\u0001\u001a\u00020\u0002H&J\u0011\u0010\u00a1\u0001\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u0006H&J\t\u0010\u00a2\u0001\u001a\u00020\u0004H&JS\u0010\u00ae\u0001\u001a\u00030\u00ad\u0001\"\u000f\b\u0000\u0010\u00a5\u0001*\u00030\u00a3\u0001*\u00030\u00a4\u0001\"\n\b\u0001\u0010\u00a7\u0001*\u00030\u00a6\u00012\b\u0010\u00a9\u0001\u001a\u00030\u00a8\u00012\u0007\u0010\u00aa\u0001\u001a\u00028\u00002\u000e\u0010\u00ac\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u00ab\u0001H&\u00a2\u0006\u0006\b\u00ae\u0001\u0010\u00af\u0001J)\u0010\u00b4\u0001\u001a\u00020\u00022\u000e\u0010\u00b1\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u00b0\u00012\u000e\u0010\u00b3\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u00b2\u0001H&J\t\u0010\u00b5\u0001\u001a\u00020\bH&J\t\u0010\u00b6\u0001\u001a\u00020\u0004H&J&\u0010\u00b8\u0001\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(2\u0006\u0010\u0011\u001a\u00020\u00062\u000b\b\u0002\u0010\u00b7\u0001\u001a\u0004\u0018\u00010\u0006H&J+\u0010\u00ba\u0001\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(2\u0006\u0010\u0011\u001a\u00020\u00062\u0007\u0010\u00b9\u0001\u001a\u00020\u00062\u0007\u0010\u00b7\u0001\u001a\u00020\u0006H&J\t\u0010\u00bb\u0001\u001a\u00020\u0002H&J\u0015\u0010\u00be\u0001\u001a\u00020\u00042\n\u0010\u00bd\u0001\u001a\u0005\u0018\u00010\u00bc\u0001H&J\u0019\u0010\u00bf\u0001\u001a\u00020\u00062\u0006\u0010a\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u0006H&J\t\u0010\u00c0\u0001\u001a\u00020\u0004H&J\t\u0010\u00c1\u0001\u001a\u00020\u0004H&J\t\u0010\u00c2\u0001\u001a\u00020\u0002H&J\t\u0010\u00c3\u0001\u001a\u00020\u0002H&J\t\u0010\u00c4\u0001\u001a\u00020\u0002H&J\u001b\u0010\u00c7\u0001\u001a\u00020\u00022\u0007\u0010v\u001a\u00030\u00c5\u00012\u0007\u0010\u000f\u001a\u00030\u00c6\u0001H&J\n\u0010\u00c9\u0001\u001a\u00030\u00c8\u0001H&J \u0010\u00cd\u0001\u001a\u0005\u0018\u00010\u00cc\u00012\t\u0010\u00ca\u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u00cb\u0001\u001a\u00020\bH&J\u0010\u0010\u00ce\u0001\u001a\t\u0012\u0004\u0012\u00020\b0\u00b0\u0001H&J\n\u0010\u00d0\u0001\u001a\u00030\u00cf\u0001H&J\u0010\u0010\u00d1\u0001\u001a\t\u0012\u0004\u0012\u00020\b0\u00b0\u0001H&J\t\u0010\u00d2\u0001\u001a\u00020\u0002H&J'\u0010\u00d4\u0001\u001a\u00020\u00022\u0007\u0010\u00d3\u0001\u001a\u00020\b2\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u0087\u0001H&J\u001c\u0010\u00d7\u0001\u001a\u00020\u00022\u0007\u0010\u00d3\u0001\u001a\u00020\b2\b\u0010\u00d6\u0001\u001a\u00030\u00d5\u0001H&J1\u0010\u00dc\u0001\u001a\u00020\u00022&\u0010\u00db\u0001\u001a!\u0012\u0016\u0012\u00140\u0006\u00a2\u0006\u000f\b\u00d8\u0001\u0012\n\b\u00d9\u0001\u0012\u0005\b\b(\u00da\u0001\u0012\u0004\u0012\u00020\u00020\u0087\u0001H&J.\u0010\u00df\u0001\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010#2\u0007\u0010\u00da\u0001\u001a\u00020\u00062\u0007\u0010\u00dd\u0001\u001a\u00020\b2\u0007\u0010\u00de\u0001\u001a\u00020\bH&J\u001f\u0010\u00e2\u0001\u001a\u00020\u00022\u0007\u0010\u00e0\u0001\u001a\u00020\u00062\u000b\b\u0002\u0010\u000f\u001a\u0005\u0018\u00010\u00e1\u0001H&J\t\u0010\u00e3\u0001\u001a\u00020\u0004H&J\n\u0010\u00e5\u0001\u001a\u00030\u00e4\u0001H&J\u001d\u0010\u00e6\u0001\u001a\u00020\u00042\b\u0010G\u001a\u0004\u0018\u00010F2\b\u0010d\u001a\u0004\u0018\u00010\u0006H&J\u0011\u0010\u00e7\u0001\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020#H&J\u001a\u0010\u00e9\u0001\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u00062\u0007\u0010\u00e8\u0001\u001a\u00020\u0006H&J\u0011\u0010\u00ea\u0001\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u0006H&J\t\u0010\u00eb\u0001\u001a\u00020\u0004H&J\u0015\u0010\u00ed\u0001\u001a\u00020\u00022\n\u0010\u00ec\u0001\u001a\u0005\u0018\u00010\u00cc\u0001H&J\u001b\u0010\u00f0\u0001\u001a\u00020\u00062\u0006\u0010m\u001a\u00020\u00062\b\u0010\u00ef\u0001\u001a\u00030\u00ee\u0001H&J\u0015\u0010\u00f3\u0001\u001a\u0005\u0018\u00010\u00f2\u00012\u0007\u0010=\u001a\u00030\u00f1\u0001H&J\u0012\u0010\u00f4\u0001\u001a\u00020\u00042\u0007\u0010=\u001a\u00030\u00f1\u0001H&J\t\u0010\u00f5\u0001\u001a\u00020\u0002H&J\u001a\u0010\u00f7\u0001\u001a\n\u0012\u0005\u0012\u00030\u00f6\u00010\u00b0\u00012\u0007\u0010=\u001a\u00030\u00f1\u0001H&J\u0012\u0010\u00f8\u0001\u001a\u00020\u00042\u0007\u0010=\u001a\u00030\u00f1\u0001H&J\t\u0010\u00f9\u0001\u001a\u00020\u0004H&J\u0012\u0010\u00fb\u0001\u001a\u00020\u00022\u0007\u0010\u00fa\u0001\u001a\u00020\u0006H&J\u000b\u0010\u00fc\u0001\u001a\u0004\u0018\u00010}H&J \u0010\u00fe\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010\u00fd\u0001\u001a\u0004\u0018\u00010\u00062\b\u00109\u001a\u0004\u0018\u00010\u0006H&J\u0015\u0010\u00ff\u0001\u001a\u00020\u00022\n\u0010\u00bd\u0001\u001a\u0005\u0018\u00010\u00bc\u0001H&J\t\u0010\u00ff\u0001\u001a\u00020\u0002H&J\u0013\u0010\u0080\u0002\u001a\u00020\u00062\b\u00109\u001a\u0004\u0018\u00010\u0006H&J6\u0010\u0084\u0002\u001a\u00020\u00022\t\b\u0002\u0010\u0081\u0002\u001a\u00020\u00062\u0007\u0010\u0082\u0002\u001a\u00020\u00062\u0017\b\u0002\u00102\u001a\u0011\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0083\u0002H&J\u0012\u0010\u0086\u0002\u001a\u00020\u00042\u0007\u0010\u0085\u0002\u001a\u00020\bH&J\t\u0010\u0087\u0002\u001a\u00020\u0004H&J\t\u0010\u0088\u0002\u001a\u00020\u0002H&J\t\u0010\u0089\u0002\u001a\u00020\u0004H&J'\u0010\u008e\u0002\u001a\u0005\u0018\u00010\u008d\u00022\u0006\u0010)\u001a\u00020(2\u0007\u0010\u008a\u0002\u001a\u00020}2\b\u0010\u008c\u0002\u001a\u00030\u008b\u0002H&J\u0014\u0010\u0090\u0002\u001a\u0004\u0018\u00010}2\u0007\u0010\u008f\u0002\u001a\u00020\u0006H&J\t\u0010\u0091\u0002\u001a\u00020\u0004H&J\t\u0010\u0092\u0002\u001a\u00020\u0002H&JC\u0010\u0097\u0002\u001a\u00020\u00062\u0007\u0010\u0093\u0002\u001a\u00020\u00062\u000b\b\u0002\u0010\u0094\u0002\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00062\t\b\u0002\u0010\u0095\u0002\u001a\u00020\u00042\u000b\b\u0002\u0010\u0096\u0002\u001a\u0004\u0018\u00010\u0006H&J\u000b\u0010\u0098\u0002\u001a\u0004\u0018\u00010FH&J\u000b\u0010\u0099\u0002\u001a\u0004\u0018\u00010\u0006H&J\t\u0010\u009a\u0002\u001a\u00020\u0006H&J\u0011\u0010\u009b\u0002\u001a\u00020\u00022\u0006\u0010v\u001a\u00020\u0006H&J\u0011\u0010\u009c\u0002\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(H&J\u0013\u0010\u009d\u0002\u001a\u0004\u0018\u00010F2\u0006\u0010)\u001a\u00020(H&J\u0011\u0010\u009e\u0002\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(H&J\u0012\u0010\u00a0\u0002\u001a\u00020\u00022\u0007\u0010\u009f\u0002\u001a\u000208H&J\t\u0010\u00a1\u0002\u001a\u000208H&J\u0011\u0010\u00a2\u0002\u001a\u00020\u00022\u0006\u00109\u001a\u000208H&J-\u0010\u00a7\u0002\u001a\u00020\u00022\u0007\u0010\u00a3\u0002\u001a\u00020\u00062\u0007\u0010\u00a4\u0002\u001a\u00020\u00062\u0007\u0010\u00a5\u0002\u001a\u00020\u00062\u0007\u0010\u000f\u001a\u00030\u00a6\u0002H&J\u0012\u0010\u00a9\u0002\u001a\u00020\u00022\u0007\u0010\u000f\u001a\u00030\u00a8\u0002H&\u00a8\u0006\u00ad\u0002"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/IZPlanApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "stopZPlanEngine", "", "shouldCheckFloat", "", "desc", "", "sceneType", "killZPlanProcess", "Ldy4/a;", "zplanRender", "sceneParams", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "listener", "enterAvatarScene", "source", "preloadZPlanEngine", "Lmqq/util/WeakReference;", "Lcom/tencent/zplan/engine/c;", "callback", "from", "startEngineWhenNotReady", "Lcom/tencent/common/app/AppInterface;", "app", "prepareZPlanEnv", "prepareZPlanConfig", "checkUe4So", "Ljavax/microedition/khronos/egl/EGLContext;", "getUEContext", "Landroid/opengl/EGLContext;", "getUEAndroidContext", "Lmqq/app/MobileQQ;", "procname", "Lmqq/app/AppRuntime;", "createZplanAppInterface", "isEngineReady", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "Landroid/content/Context;", "context", "needTouch", TPReportKeys.PlayerStep.PLAYER_CALLBACK_OPAQUE, "Lcom/tencent/zplan/world/view/NormalRenderTextureView;", "getZPlanTextureView", "startSettingActivity", "startSettingV2Activity", "startAvatarSettingActivity", "Landroid/content/Intent;", "params", "startFriendChooseActivity", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "statusUpdateListener", "registerZPlanEngineStatusUpdateListener", "unRegisterZPlanEngineStatusUpdateListener", "", "uin", "isQzoneEntranceEnabled", "isDrawerEntranceSwitchOpen", "appInterface", "scene", "Lji3/k;", "setOnSettingChangeListener", "Lji3/m;", "setOnZPlanSettingChangeListener", "Lji3/j;", "setOnZplanAccessibleWithoutSettingListener", "resumeEngine", "pauseEngine", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/zplan/model/e;", "info", "Lcom/tencent/mobileqq/activity/aio/p;", SessionDbHelper.SESSION_ID, "peerUin", "peerNickName", "sendMessage", "reLoginAfterAccountChanged", "", "baseChatPie", "openZPlanEmoticonPanel", "Lcom/tencent/mobileqq/zplan/model/MaintEntryType;", "type", "Lcom/tencent/mobileqq/zplan/model/i;", "getMaintenanceInfo", "refetchMaintenanceInfoSync", "Lcom/tencent/mobileqq/zplan/model/d;", "refetchMaintenanceInfoAsync", "theme", "getZPlanAvatarImagePath", "getZPlanAvatarImagePathWithUin", "getZPlanStaticAvatarKey", "getAvatarLocalUrlWithUin", "", "getAvaterWindowsillLocationWithUin", "gender", "Ljava/net/URL;", "getZPlanDefaultAvatarURL", "url", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "handleZPlanEnterAvatarSceneScheme", "cleanZPlanCache", "handleZPlanOpenPageScheme", "handleToast", "handleZplanThirdScheme", "getAppInterface", "schemeUrl", "launchScheme", "launchSchemeWithContext", "Landroid/widget/FrameLayout;", "zPlanBannerLayout", "Landroid/widget/ImageView;", "avatarIV", "backgroundContainer", "Lcom/tencent/mobileqq/zplan/meme/frameanim/i;", "param", "Lcom/tencent/mobileqq/zplan/meme/frameanim/a;", "createZPlanAvatarBannerManager", "getZPlanGender", "getZPlanGenderWithUin", "portraitId", "selfUin", "Lorg/json/JSONObject;", "emoticonJson", "isEmoticonPicRecorded", "recordEmoticonFromRecommend", "getDynamicAvatarUrl", "getDynamicAvatarProperty", "getDynamicAvatarAppearanceKey", "pausePlaySharpPForReport", "getZPlanVersion", "path", "Lkotlin/Function1;", "onResult", "setAvatarFromPeak", "addPicToCustomEmoticonFromPeak", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "status", "showStatusTip", "isChecked", "Lji3/l;", "updateZPlanSettingQZoneSwitch", "getStatusPortraitIdByUin", "preloadZPlanSuitIfNeed", IProfileProtocolConst.PARAM_TARGET_UIN, PanoramaConfig.KEY_CURRENT_UIN, "nickName", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "isNeedTransit", "connectedTime", "openSmallHomeGuidePageFromQav", "intent", "startZPlanBackgroundEdit", "Lkotlin/Function2;", "update", "imgPath", "setZPlanBackgroundImage", "requestStaticImageUrl", "requestStaticImageUrlWithUin", "isEngineHotReady", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/lifecycle/LifecycleOwner;", "T", "Landroidx/lifecycle/ViewModel;", "K", "Landroid/view/LayoutInflater;", "inflater", "lifecycleSpan", "Ljava/lang/Class;", "viewModelClass", "Lcom/tencent/mobileqq/zplan/meme/frameanim/e;", "createAvatarLoadingViewHelper", "(Landroid/view/LayoutInflater;Landroidx/lifecycle/ViewModelStoreOwner;Ljava/lang/Class;)Lcom/tencent/mobileqq/zplan/meme/frameanim/e;", "", SquareJSConst.Params.PARAMS_UIN_LIST, "Lkotlin/Function0;", "onDone", "requireUserZPlanInfo", "getZPlanStartStatus", "isZPlanAvatarSettingEnable", "enableNewTask", "openZPlanAvatarPicEditPage", "backupUrl", "openZPlanAvatarPicEditPageWithWhiteListCheck", "checkZPlanAvatarUpdate", "Lcom/tencent/mobileqq/data/MessageRecord;", "message", "isZPlanMessage", "getStaticDefaultUrlFromConfig", "isBigScreen", "showAioZPlanGifLoading", "resetZPlanEnvOnSSOChange", "clearRecordCache", "doOnClearSystemCache", "Lcom/tencent/mobileqq/zplan/easteregg/model/d;", "Lcom/tencent/mobileqq/zplan/easteregg/t;", "getEasterEggPortraitResource", "Lcom/tencent/mobileqq/zplan/easteregg/w;", "createZPlanAvatarEasterEggManager", "msg", QQBrowserActivity.KEY_MSG_TYPE, "Lcom/tencent/mobileqq/zplan/easteregg/a;", "getMatchKeywordEasterEggConfig", "getEasterEggAllConfigPortraitId", "Lcom/tencent/mobileqq/zplan/easteregg/u;", "createEasterEggDaTongReporter", "getEasterEggPreRecordPortraitId", "pauseRecordQueueAfterEnterBackground", "mapId", "isDeviceAdaptiveForMod", "Lgw4/f;", "commonCheckResult", "updateCheckResultCache", "Lkotlin/ParameterName;", "name", "itemId", "callBack", "requestAvatarEditEntranceRedDotData", "actionId", "avatarEntrance", "reportAvatarEditEntranceRedDotData", "fromSource", "Lji3/n;", "checkUEBsResource", "isUEBsResourceReady", "Lcom/tencent/mobileqq/zplan/avatar/b;", "createAvatarEditDaTongReporter", "shouldInterceptWebToNative", "getZPlanEditAvatarFlag", "appearanceKey", "saveAppearanceKeyToMMKV", "getAppearanceKeyFromMMKV", "isFilamentEnabled", DownloadInfo.spKey_Config, "reportEasterEggPlaySuccess", "Landroid/os/Bundle;", "bundle", "appendPageDataToScheme", "Lcom/tencent/mobileqq/zplan/meme/ZPlanRecordScene;", "Lcom/tencent/zplan/meme/EngineType;", "getTargetEngineForRecord", "enableFilamentRecordResultUpload", "clearMMKVCacheWhenLogout", "Lcom/tencent/zplan/record/model/Source;", "getRecordSourceWhenUsingFilament", "enableFilamentRecordCloudCache", "enablePortalPlanarShadow", "updatedStatus", "setZPlanEmoticonGrayTipsMMKV", "getZPlanEmoticonGrayTipsMMKV", "originURL", "updateSchemeURLWithUin", "refreshZPlanEmoticonGrayTipsMMKVIfNeed", "getEmoticonGrayTipsCreateRoleScheme", com.heytap.mcssdk.a.a.f36102l, "eventCode", "", "reportToBeacon", "filamentSceneType", "enableMiniHome", "miniHomeQQMCSwitchOn", "setMiniHomeRewardGiftBubbleMMKV", "getMiniHomeRewardGiftBubbleMMKV", "avatarCharacter", "Lcom/tencent/qqnt/aio/api/d;", "iNTAvatarStatusViewCb", "Lcom/tencent/qqnt/aio/api/INTZPlanAvatarView;", "getZPlanTofuAvatarView", "busiExtra", "getTofuJSONFromExtra", "showAIOZPlanTofu", "jumpToSplash", ISchemeApi.KEY_REFERER, "subReferer", "isFocus", ISchemeApi.KEY_PAGE_DATA, "generateXWConnectScheme", "getTopActivity", "getCurrentUin", "getSSOServerEnvName", "notifyAppearanceKeyChange", "isNetworkAvailable", "getActivityFromContext", "showOpenVipSuccessDialog", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "saveLastZPlanUsingTimeStamp", "getLastZPlanUsingTimeStamp", "preRequestMiniHomeFlag", "oldFilePath", "diffFilePath", "outFilePath", "Lji3/b;", "hDiffPatch", "Lcom/tencent/mobileqq/zplan/api/IZPlanApi$c;", "preloadHDiffPatchSo", "Companion", "a", "c", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanApi extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f331333a;

    @NotNull
    public static final String FROM_C2C_ARK = "from_c2c_ark";

    @NotNull
    public static final String FROM_CHANNEL_ARK = "from_channel_ark";

    @NotNull
    public static final String FROM_QQ_SETTING = "from_qq_setting";

    @NotNull
    public static final String FROM_ZPLAN_STORE = "from_zplan_store";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/IZPlanApi$a;", "", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.api.IZPlanApi$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f331333a = new Companion();

        Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class b {
        public static /* synthetic */ void a(IZPlanApi iZPlanApi, String str, boolean z16, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    z16 = false;
                }
                if ((i16 & 4) != 0) {
                    i3 = 0;
                }
                iZPlanApi.killZPlanProcess(str, z16, i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: killZPlanProcess");
        }

        public static /* synthetic */ void b(IZPlanApi iZPlanApi, Context context, String str, String str2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str2 = "";
                }
                iZPlanApi.openZPlanAvatarPicEditPage(context, str, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openZPlanAvatarPicEditPage");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void c(IZPlanApi iZPlanApi, WeakReference weakReference, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    weakReference = null;
                }
                iZPlanApi.startEngineWhenNotReady(weakReference, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startEngineWhenNotReady");
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/IZPlanApi$c;", "", "", "isSuccess", "", "code", "", "msg", "", "onLoaded", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface c {
        void onLoaded(boolean isSuccess, int code, @Nullable String msg2);
    }

    void addPicToCustomEmoticonFromPeak(@NotNull String path, @NotNull Function1<? super Boolean, Unit> onResult);

    @NotNull
    String appendPageDataToScheme(@NotNull String schemeUrl, @NotNull Bundle bundle);

    void checkUEBsResource(@NotNull String fromSource, @Nullable n listener);

    void checkUe4So();

    void checkZPlanAvatarUpdate();

    void cleanZPlanCache(@NotNull Context context);

    void clearCache();

    void clearMMKVCacheWhenLogout();

    void clearRecordCache();

    @NotNull
    com.tencent.mobileqq.zplan.avatar.b createAvatarEditDaTongReporter();

    @NotNull
    <T extends ViewModelStoreOwner & LifecycleOwner, K extends ViewModel> e createAvatarLoadingViewHelper(@NotNull LayoutInflater inflater, @NotNull T lifecycleSpan, @NotNull Class<K> viewModelClass);

    @NotNull
    u createEasterEggDaTongReporter();

    @NotNull
    com.tencent.mobileqq.zplan.meme.frameanim.a createZPlanAvatarBannerManager(@NotNull Context context, @NotNull FrameLayout zPlanBannerLayout, @NotNull ImageView avatarIV, @NotNull FrameLayout backgroundContainer, @NotNull ZPlanAvatarBannerParams param);

    @NotNull
    w createZPlanAvatarEasterEggManager();

    @Nullable
    AppRuntime createZplanAppInterface(@Nullable MobileQQ app, @Nullable String procname);

    void doOnClearSystemCache();

    boolean enableFilamentRecordCloudCache(@NotNull ZPlanRecordScene scene);

    boolean enableFilamentRecordResultUpload(@NotNull ZPlanRecordScene scene);

    boolean enableMiniHome(int filamentSceneType);

    boolean enablePortalPlanarShadow();

    void enterAvatarScene(@NotNull dy4.a zplanRender, int sceneType, @Nullable String sceneParams, @Nullable IZPlanWorldStatusListener listener);

    @NotNull
    String generateXWConnectScheme(@NotNull String referer, @Nullable String subReferer, @Nullable String uin, boolean isFocus, @Nullable String pageData);

    @Nullable
    Activity getActivityFromContext(@NotNull Context context);

    @Nullable
    AppInterface getAppInterface();

    @NotNull
    String getAppearanceKeyFromMMKV(@NotNull String uin);

    @Nullable
    String getAvatarLocalUrlWithUin(@NotNull String theme, @NotNull String uin);

    float getAvaterWindowsillLocationWithUin(@NotNull String uin);

    @Nullable
    String getCurrentUin();

    @Nullable
    String getDynamicAvatarAppearanceKey(@NotNull String uin);

    @Nullable
    String getDynamicAvatarProperty(@NotNull String uin);

    @Nullable
    String getDynamicAvatarUrl(@NotNull String uin);

    @NotNull
    List<Integer> getEasterEggAllConfigPortraitId();

    void getEasterEggPortraitResource(@NotNull d param, @NotNull t listener);

    @NotNull
    List<Integer> getEasterEggPreRecordPortraitId();

    @NotNull
    String getEmoticonGrayTipsCreateRoleScheme(@Nullable String uin);

    long getLastZPlanUsingTimeStamp();

    @NotNull
    ZPlanMaintInfo getMaintenanceInfo(@NotNull MaintEntryType type);

    @Nullable
    com.tencent.mobileqq.zplan.easteregg.a getMatchKeywordEasterEggConfig(@Nullable String msg2, int msgType);

    boolean getMiniHomeRewardGiftBubbleMMKV();

    @NotNull
    List<Source> getRecordSourceWhenUsingFilament(@NotNull ZPlanRecordScene scene);

    @NotNull
    String getSSOServerEnvName();

    @NotNull
    String getStaticDefaultUrlFromConfig(@NotNull String gender, @NotNull String theme);

    int getStatusPortraitIdByUin(@NotNull String uin);

    @NotNull
    SurfaceTexture getSurfaceTexture();

    @Nullable
    EngineType getTargetEngineForRecord(@NotNull ZPlanRecordScene scene);

    @Nullable
    JSONObject getTofuJSONFromExtra(@NotNull String busiExtra);

    @Nullable
    Activity getTopActivity();

    @Nullable
    EGLContext getUEAndroidContext();

    @NotNull
    javax.microedition.khronos.egl.EGLContext getUEContext();

    @Nullable
    String getZPlanAvatarImagePath(@NotNull String theme);

    @Nullable
    String getZPlanAvatarImagePathWithUin(@NotNull String theme, @NotNull String uin);

    @NotNull
    URL getZPlanDefaultAvatarURL(int gender, @NotNull String theme);

    boolean getZPlanEditAvatarFlag(@NotNull AppRuntime app);

    @Nullable
    JSONObject getZPlanEmoticonGrayTipsMMKV();

    int getZPlanGender();

    int getZPlanGenderWithUin(@NotNull String uin);

    int getZPlanStartStatus();

    @NotNull
    String getZPlanStaticAvatarKey(@NotNull String uin);

    @NotNull
    NormalRenderTextureView getZPlanTextureView(@NotNull Context context, boolean needTouch, boolean opaque);

    @Nullable
    INTZPlanAvatarView getZPlanTofuAvatarView(@NotNull Context context, @NotNull JSONObject avatarCharacter, @NotNull com.tencent.qqnt.aio.api.d iNTAvatarStatusViewCb);

    @NotNull
    String getZPlanVersion();

    void hDiffPatch(@NotNull String oldFilePath, @NotNull String diffFilePath, @NotNull String outFilePath, @NotNull ji3.b listener);

    void handleToast(@NotNull Context context, @NotNull HashMap<String, String> params);

    boolean handleZPlanEnterAvatarSceneScheme(@NotNull Context context, @NotNull String url, @NotNull HashMap<String, String> params);

    boolean handleZPlanOpenPageScheme(@NotNull Context context, @NotNull String url, @NotNull HashMap<String, String> params);

    void handleZplanThirdScheme(@NotNull Context context, @NotNull HashMap<String, String> params);

    boolean isBigScreen();

    void isDeviceAdaptiveForMod(int mapId, @NotNull Function1<? super Boolean, Unit> callback);

    boolean isDrawerEntranceSwitchOpen();

    boolean isEmoticonPicRecorded(int portraitId, @NotNull String selfUin, @Nullable JSONObject emoticonJson);

    boolean isEngineHotReady();

    boolean isEngineReady();

    boolean isFilamentEnabled();

    boolean isNetworkAvailable(@NotNull Context context);

    boolean isQzoneEntranceEnabled(long uin);

    boolean isUEBsResourceReady();

    boolean isZPlanAvatarSettingEnable();

    boolean isZPlanMessage(@Nullable MessageRecord message);

    void jumpToSplash();

    void killZPlanProcess(@NotNull String desc, boolean shouldCheckFloat, int sceneType);

    boolean launchScheme(@NotNull Context context, @NotNull String schemeUrl);

    boolean launchSchemeWithContext(@NotNull Context context, @NotNull String schemeUrl);

    boolean miniHomeQQMCSwitchOn();

    void notifyAppearanceKeyChange(@NotNull String param);

    void openSmallHomeGuidePageFromQav(@Nullable Context context, @Nullable String targetUin, @Nullable String currentUin, @Nullable String nickName, @NotNull ZootopiaSource source, boolean isNeedTransit, long connectedTime);

    void openZPlanAvatarPicEditPage(@NotNull Context context, @NotNull String source, @Nullable String enableNewTask);

    void openZPlanAvatarPicEditPageWithWhiteListCheck(@NotNull Context context, @NotNull String source, @NotNull String backupUrl, @NotNull String enableNewTask);

    void openZPlanEmoticonPanel(@NotNull Object baseChatPie, @NotNull String from);

    void pauseEngine();

    void pausePlaySharpPForReport();

    void pauseRecordQueueAfterEnterBackground();

    void preRequestMiniHomeFlag(long uin);

    void preloadHDiffPatchSo(@NotNull c listener);

    void preloadZPlanEngine(@NotNull String source);

    void preloadZPlanSuitIfNeed(@NotNull AppInterface app, long uin);

    void prepareZPlanConfig(@NotNull AppInterface app);

    void prepareZPlanEnv(@NotNull AppInterface app);

    void reLoginAfterAccountChanged();

    void recordEmoticonFromRecommend(int portraitId, @NotNull String selfUin, @Nullable JSONObject emoticonJson);

    void refetchMaintenanceInfoAsync(@NotNull MaintEntryType type, @Nullable com.tencent.mobileqq.zplan.model.d listener);

    @NotNull
    ZPlanMaintInfo refetchMaintenanceInfoSync(@NotNull MaintEntryType type);

    void refreshZPlanEmoticonGrayTipsMMKVIfNeed();

    void refreshZPlanEmoticonGrayTipsMMKVIfNeed(@Nullable MessageRecord message);

    void registerZPlanEngineStatusUpdateListener(@NotNull ZPlanEngineStatusUpdateListener statusUpdateListener);

    void reportAvatarEditEntranceRedDotData(@Nullable AppRuntime app, @NotNull String itemId, int actionId, int avatarEntrance);

    void reportEasterEggPlaySuccess(@Nullable com.tencent.mobileqq.zplan.easteregg.a config);

    void reportToBeacon(@NotNull String appKey, @NotNull String eventCode, @Nullable Map<String, String> params);

    void requestAvatarEditEntranceRedDotData(@NotNull Function1<? super String, Unit> callBack);

    void requestStaticImageUrl();

    void requestStaticImageUrlWithUin(@NotNull String uin);

    void requireUserZPlanInfo(@NotNull List<String> uinList, @NotNull Function0<Unit> onDone);

    void resetZPlanEnvOnSSOChange();

    void resumeEngine();

    void saveAppearanceKeyToMMKV(@NotNull String uin, @NotNull String appearanceKey);

    void saveLastZPlanUsingTimeStamp(long timeStamp);

    void sendMessage(@Nullable Activity activity, @NotNull ZPlanActionInfo info, @NotNull p session, @Nullable String peerUin, @Nullable String peerNickName);

    void setAvatarFromPeak(@NotNull String path, @NotNull Function1<? super Boolean, Unit> onResult);

    void setMiniHomeRewardGiftBubbleMMKV();

    void setOnSettingChangeListener(@NotNull AppInterface appInterface, long scene, @Nullable k listener);

    void setOnZPlanSettingChangeListener(long scene, @Nullable m listener);

    void setOnZplanAccessibleWithoutSettingListener(long scene, @NotNull j listener);

    void setZPlanBackgroundImage(@NotNull Activity activity, @NotNull String imgPath);

    void setZPlanEmoticonGrayTipsMMKV(@NotNull String updatedStatus);

    boolean shouldInterceptWebToNative(@Nullable Activity activity, @Nullable String url);

    boolean showAIOZPlanTofu();

    boolean showAioZPlanGifLoading();

    void showOpenVipSuccessDialog(@NotNull Context context);

    void showStatusTip(@NotNull Activity activity, long status);

    void startAvatarSettingActivity(@NotNull Context context, @NotNull String from);

    void startAvatarSettingActivity(@NotNull Context context, @NotNull String from, @Nullable Intent params);

    void startEngineWhenNotReady(@Nullable WeakReference<com.tencent.zplan.engine.c> callback, @NotNull String from);

    void startFriendChooseActivity(@NotNull Context context);

    void startSettingActivity(@NotNull Context context, @NotNull String from);

    void startSettingV2Activity(@NotNull Context context, @NotNull String from);

    void startZPlanBackgroundEdit(@NotNull Activity activity, @NotNull Intent intent);

    void stopZPlanEngine();

    void stopZPlanEngine(boolean shouldCheckFloat);

    void unRegisterZPlanEngineStatusUpdateListener(@NotNull ZPlanEngineStatusUpdateListener statusUpdateListener);

    void update(@NotNull String uin, @NotNull String url, @NotNull Function2<? super Boolean, ? super String, Unit> callback);

    void updateCheckResultCache(int mapId, @NotNull f commonCheckResult);

    @Nullable
    String updateSchemeURLWithUin(@Nullable String originURL, @Nullable String uin);

    void updateZPlanSettingQZoneSwitch(boolean isChecked, @NotNull l listener);
}
