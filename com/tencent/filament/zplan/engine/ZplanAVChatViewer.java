package com.tencent.filament.zplan.engine;

import android.graphics.PointF;
import android.text.TextUtils;
import android.view.Surface;
import androidx.annotation.Keep;
import com.tencent.filament.zplan.animation.FilamentAnimation;
import com.tencent.filament.zplan.data.AvatarAIInfo;
import com.tencent.filament.zplan.data.ZPlanPinchFaceModel;
import com.tencent.filament.zplan.e;
import com.tencent.filament.zplan.view.event.TouchEvent;
import com.tencent.filament.zplan.view.event.TouchEventType;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@NativeProxy(allFields = false, allMethods = false)
@Keep
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0007\u0018\u0000 \u00a9\u00012\u00020\u0001:\u0001%B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0007\u0010\u00a0\u0001\u001a\u00020\u0010\u0012\t\b\u0002\u0010\u00a4\u0001\u001a\u00020\u0006\u00a2\u0006\u0006\b\u00a7\u0001\u0010\u00a8\u0001J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0082 J\u0011\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\bH\u0082 J\u0011\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\bH\u0082 J\u0019\u0010\u000f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0002H\u0082 J9\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010H\u0082 J\u0019\u0010\u0018\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0006H\u0082 J)\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0082 J!\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0006H\u0082 J5\u0010!\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\b\u0010 \u001a\u0004\u0018\u00010\u0002H\u0082 JA\u0010&\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0010H\u0082 J\u0011\u0010'\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\bH\u0082 J\u0019\u0010)\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u0001H\u0082 J.\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0002H\u0082 \u00a2\u0006\u0004\b-\u0010.J)\u00101\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u00022\u0006\u00100\u001a\u00020/H\u0082 J\u0019\u00102\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0082 J\u0019\u00103\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0082 JL\u00109\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u00022\f\u00106\u001a\b\u0012\u0004\u0012\u0002050+2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00020+2\u0006\u00108\u001a\u00020\u0006H\u0082 \u00a2\u0006\u0004\b9\u0010:J\u0019\u0010;\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0082 J1\u0010A\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u00102\u0006\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020>H\u0082 JA\u0010D\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u00102\u0006\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020>2\u0006\u0010B\u001a\u00020>2\u0006\u0010C\u001a\u00020>H\u0082 J)\u0010H\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010E\u001a\u00020>2\u0006\u0010F\u001a\u00020>2\u0006\u0010G\u001a\u00020>H\u0082 J!\u0010J\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010I\u001a\u00020\u0002H\u0082 J!\u0010K\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010I\u001a\u00020\u0002H\u0082 J\u0011\u0010L\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\bH\u0082 J\u0019\u0010N\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010M\u001a\u00020\u0002H\u0082 J\u0011\u0010O\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\bH\u0082 J\u0019\u0010P\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0082 J1\u0010U\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020>2\u0006\u0010T\u001a\u00020\u0006H\u0082 J!\u0010W\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010V\u001a\u00020\u0010H\u0082 J!\u0010X\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0082 J)\u0010[\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010Y\u001a\u00020\u00022\u0006\u0010Z\u001a\u00020\u0002H\u0082 J\u0019\u0010\\\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0082 J\u0019\u0010]\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0002H\u0082 J\u0019\u0010^\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0002H\u0082 J\u0019\u0010_\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0082 J1\u0010c\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010`\u001a\u00020>2\u0006\u0010a\u001a\u00020>2\u0006\u0010b\u001a\u00020>H\u0082 J\u000e\u0010d\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0002J.\u0010g\u001a\u00020\u000b2\u0006\u0010e\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010J\u0010\u0010h\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u0006J2\u0010l\u001a\u00020\u000b2\u0006\u0010e\u001a\u00020\u00102\"\u0010k\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020ij\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`jJ*\u0010m\u001a\u00020\u000b2\u0006\u0010e\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\b\u0010 \u001a\u0004\u0018\u00010\u0002J6\u0010n\u001a\u00020\u000b2\u0006\u0010e\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0010J\u0016\u0010p\u001a\u00020\u000b2\u0006\u0010o\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0006J\u0006\u0010q\u001a\u00020\u000bJ\u000e\u0010t\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020rJ#\u0010u\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010e\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0002\u00a2\u0006\u0004\bu\u0010vJ\u001e\u0010w\u001a\u00020\u000b2\u0006\u0010e\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u00022\u0006\u00100\u001a\u00020/J\u000e\u0010x\u001a\u00020\u000b2\u0006\u0010e\u001a\u00020\u0010J\u0006\u0010y\u001a\u00020\u000bJ\u0006\u0010z\u001a\u00020\u000bJ\u000e\u0010{\u001a\u00020\u000b2\u0006\u0010e\u001a\u00020\u0010JA\u0010|\u001a\u00020\u000b2\u0006\u0010e\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u00022\f\u00106\u001a\b\u0012\u0004\u0012\u0002050+2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00020+2\u0006\u00108\u001a\u00020\u0006\u00a2\u0006\u0004\b|\u0010}J\u000e\u0010~\u001a\u00020\u000b2\u0006\u0010e\u001a\u00020\u0010J\u0010\u0010\u0081\u0001\u001a\u00020\u000b2\u0007\u0010\u0080\u0001\u001a\u00020\u007fJ\u0019\u0010\u0084\u0001\u001a\u00020\u000b2\b\u0010\u0083\u0001\u001a\u00030\u0082\u00012\u0006\u0010G\u001a\u00020>J\u0007\u0010\u0085\u0001\u001a\u00020\u000bJ\u0019\u0010\u0088\u0001\u001a\u00020\u000b2\u0007\u0010\u0086\u0001\u001a\u00020\u00102\u0007\u0010\u0087\u0001\u001a\u00020\u0002J\u0019\u0010\u008a\u0001\u001a\u00020\u000b2\u0007\u0010\u0086\u0001\u001a\u00020\u00102\u0007\u0010\u0089\u0001\u001a\u00020\u0002J\u0012\u0010\u008c\u0001\u001a\u00020\u000b2\u0007\u0010\u008b\u0001\u001a\u00020\u0010H\u0007J\u0011\u0010\u008f\u0001\u001a\u00020\u000b2\b\u0010\u008e\u0001\u001a\u00030\u008d\u0001J\u000f\u0010\u0090\u0001\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0002J\u0010\u0010\u0091\u0001\u001a\u00020\u000b2\u0007\u0010\u0086\u0001\u001a\u00020\u0010J\u0007\u0010\u0092\u0001\u001a\u00020\u0010J\u0010\u0010\u0093\u0001\u001a\u00020\u000b2\u0007\u0010\u0086\u0001\u001a\u00020\u0010J(\u0010\u0094\u0001\u001a\u00020\u000b2\u0007\u0010\u0086\u0001\u001a\u00020\u00102\u0006\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020>2\u0006\u0010T\u001a\u00020\u0006J\u0018\u0010\u0095\u0001\u001a\u00020\u000b2\u0007\u0010\u0086\u0001\u001a\u00020\u00102\u0006\u0010V\u001a\u00020\u0010J\u0018\u0010\u0096\u0001\u001a\u00020\u000b2\u0007\u0010\u0086\u0001\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010J \u0010\u0097\u0001\u001a\u00020\u000b2\u0007\u0010\u0086\u0001\u001a\u00020\u00102\u0006\u0010Y\u001a\u00020\u00022\u0006\u0010Z\u001a\u00020\u0002J\u000f\u0010\u0098\u0001\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0002J\u000f\u0010\u0099\u0001\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0002J\u0010\u0010\u009a\u0001\u001a\u00020\u00062\u0007\u0010\u0086\u0001\u001a\u00020\u0010J(\u0010\u009b\u0001\u001a\u00020\u000b2\u0007\u0010\u0086\u0001\u001a\u00020\u00102\u0006\u0010`\u001a\u00020>2\u0006\u0010a\u001a\u00020>2\u0006\u0010b\u001a\u00020>R\u0019\u0010\u009c\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001c\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001c\u0010\u00a0\u0001\u001a\u00020\u00108\u0006\u00a2\u0006\u0010\n\u0006\b\u00a0\u0001\u0010\u00a1\u0001\u001a\u0006\b\u00a2\u0001\u0010\u00a3\u0001R\u001c\u0010\u00a4\u0001\u001a\u00020\u00068\u0006\u00a2\u0006\u0010\n\u0006\b\u00a4\u0001\u0010\u00a5\u0001\u001a\u0006\b\u00a4\u0001\u0010\u00a6\u0001\u00a8\u0006\u00aa\u0001"}, d2 = {"Lcom/tencent/filament/zplan/engine/ZplanAVChatViewer;", "", "", "filamatRootPath", "bodyRefJsonPath", "aiBundle", "", "isSharedContext", "", "nCreateViewer", "nativeViewer", "", "nLoadSpotLight", "nLoadSun", "iblPath", "nLoadLight", "", "avatarViewIndex", "left", "bootom", "width", "height", "nUpdateViewport", "needRecord", "nRender", "slot", "path", "nUpdateAvatar", "isMale", "nReloadAvatar", "slotName", "textureAbsPath", "jsonAbsPath", "nUpdateMakeupSlotTexture", "r", "g", "b", "a", "nUpdateMakeupSlotColor", "nDestroy", "nativeWindow", "nCreateSwapChain", "animationGltfPath", "", "Lcom/tencent/filament/zplan/animation/FilamentAnimation;", "nLoadAnimation", "(JILjava/lang/String;)[Lcom/tencent/filament/zplan/animation/FilamentAnimation;", "", "now", "nPlayAnimation", "nStopAnimation", "nCleanAvatar", "pinchFaceConfigPath", "Lcom/tencent/filament/zplan/data/ZPlanPinchFaceModel;", "pinchFaceModels", "itemIdArray", "isFemale", "nLoadPinchFaceConfig", "(JILjava/lang/String;[Lcom/tencent/filament/zplan/data/ZPlanPinchFaceModel;[Ljava/lang/String;Z)V", "nApplyPinchFace", "state", "touchCount", "", "locationX", "locationY", "nDidPan", "velocity", "scale", "nDidPinch", "centerLocationX", "centerLocationY", "scrolldelta", "nScrollCamera", "filePath", "nSetLutPath", "nSetPhysicPath", "nResetCamera", "aiPath", "nParseAIInfoFromJson", "nCreateAvatar", "nRemoveAvatar", "Lcom/tencent/filament/zplan/data/AvatarAIInfo;", "avatarAIInfo", "ratio", "immediately", "nApplyAIDataToAvatar", "zorder", "nSetRenderZOrder", "nSetRenderTargetWidth", "gltfPath", "imageName", "nUpdateAvatarViewBg", "nMirrorAvatar", "nUpdate3DMMPath", "nUpdateMaterialRootPath", "nCheck3DMMReady", "xOffset", "yOffset", "zOffset", "nSetTranslationOffset", "loadLight", "index", "bottom", "updateViewport", ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "resourceModel", "updateAvatar", "updateMakeupSlotTexture", "updateMakeupSlotColor", "avatarIndex", "reloadAvatar", "destroy", "Landroid/view/Surface;", "surface", "createSwapChain", "loadAnimation", "(ILjava/lang/String;)[Lcom/tencent/filament/zplan/animation/FilamentAnimation;", QZoneJsConstants.METHOD_PLAY, "stopAnimation", "loadSpotLight", "loadSun", "cleanAvatar", "loadPinchFaceConfig", "(ILjava/lang/String;[Lcom/tencent/filament/zplan/data/ZPlanPinchFaceModel;[Ljava/lang/String;Z)V", "applyPinchFace", "Lcom/tencent/filament/zplan/view/event/TouchEvent;", "event", "receiveTouchEvent", "Landroid/graphics/PointF;", "centerLocation", "scrollCamera", "resetCamera", "viewIndex", "lutPath", "loadLut", "physicPath", "loadPhysic", "textureId", "onReocrdTexture", "Lcom/tencent/filament/zplan/e;", "listener", "recordFrame", "parseAIInfo", "remoteAvatar", "createAvatar", "mirrorAvatar", "applyAIDataToAvatar", "setAvatarViewZoder", "setRenderTargetWidth", "updateAvatarViewBg", "update3DMMPath", "updateMaterialRootPath", "check3DMMReady", "setTranslationOffset", "nativeObject", "J", "recordFrameListener", "Lcom/tencent/filament/zplan/e;", "renderMaxTargetWidth", "I", "getRenderMaxTargetWidth", "()I", "isRenderDebug", "Z", "()Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V", "Companion", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ZplanAVChatViewer {
    private static final String TAG = "ZplanAVChat";
    private final boolean isRenderDebug;
    private long nativeObject;
    private e recordFrameListener;
    private final int renderMaxTargetWidth;

    public ZplanAVChatViewer(@NotNull String filamatRootPath, @NotNull String bodyRefJsonPath, @NotNull String aiBundle, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(filamatRootPath, "filamatRootPath");
        Intrinsics.checkNotNullParameter(bodyRefJsonPath, "bodyRefJsonPath");
        Intrinsics.checkNotNullParameter(aiBundle, "aiBundle");
        this.renderMaxTargetWidth = i3;
        this.isRenderDebug = z16;
        this.nativeObject = nCreateViewer(filamatRootPath, bodyRefJsonPath, aiBundle, false);
        FLog.INSTANCE.i(TAG, "lgx nCreateViewer, " + this.nativeObject);
    }

    private final native void nApplyAIDataToAvatar(long nativeViewer, int avatarViewIndex, AvatarAIInfo avatarAIInfo, float ratio, boolean immediately);

    private final native void nApplyPinchFace(long nativeViewer, int avatarViewIndex);

    private final native boolean nCheck3DMMReady(long nativeViewer, int avatarViewIndex);

    private final native void nCleanAvatar(long nativeViewer, int avatarViewIndex);

    private final native int nCreateAvatar(long nativeViewer);

    private final native void nCreateSwapChain(long nativeViewer, Object nativeWindow);

    private final native long nCreateViewer(String filamatRootPath, String bodyRefJsonPath, String aiBundle, boolean isSharedContext);

    private final native void nDestroy(long nativeViewer);

    private final native void nDidPan(long nativeViewer, int state, int touchCount, float locationX, float locationY);

    private final native void nDidPinch(long nativeViewer, int state, int touchCount, float locationX, float locationY, float velocity, float scale);

    private final native FilamentAnimation[] nLoadAnimation(long nativeViewer, int avatarViewIndex, String animationGltfPath);

    private final native long nLoadLight(long nativeViewer, String iblPath);

    private final native void nLoadPinchFaceConfig(long nativeViewer, int avatarViewIndex, String pinchFaceConfigPath, ZPlanPinchFaceModel[] pinchFaceModels, String[] itemIdArray, boolean isFemale);

    private final native void nLoadSpotLight(long nativeViewer);

    private final native void nLoadSun(long nativeViewer);

    private final native void nMirrorAvatar(long nativeViewer, int avatarViewIndex);

    private final native void nParseAIInfoFromJson(long nativeViewer, String aiPath);

    private final native void nPlayAnimation(long nativeViewer, int avatarViewIndex, String animationGltfPath, double now);

    private final native void nReloadAvatar(long nativeViewer, int avatarViewIndex, boolean isMale);

    private final native void nRemoveAvatar(long nativeViewer, int avatarViewIndex);

    private final native boolean nRender(long nativeViewer, boolean needRecord);

    private final native void nResetCamera(long nativeViewer);

    private final native void nScrollCamera(long nativeViewer, float centerLocationX, float centerLocationY, float scrolldelta);

    private final native void nSetLutPath(long nativeViewer, int avatarViewIndex, String filePath);

    private final native void nSetPhysicPath(long nativeViewer, int avatarViewIndex, String filePath);

    private final native void nSetRenderTargetWidth(long nativeViewer, int avatarViewIndex, int width);

    private final native void nSetRenderZOrder(long nativeViewer, int avatarViewIndex, int zorder);

    private final native void nSetTranslationOffset(long nativeViewer, int avatarViewIndex, float xOffset, float yOffset, float zOffset);

    private final native void nStopAnimation(long nativeViewer, int avatarViewIndex);

    private final native void nUpdate3DMMPath(long nativeViewer, String path);

    private final native void nUpdateAvatar(long nativeViewer, int avatarViewIndex, String slot, String path);

    private final native void nUpdateAvatarViewBg(long nativeViewer, int avatarViewIndex, String gltfPath, String imageName);

    private final native void nUpdateMakeupSlotColor(long nativeViewer, int avatarViewIndex, String slotName, int r16, int g16, int b16, int a16);

    private final native void nUpdateMakeupSlotTexture(long nativeViewer, int avatarViewIndex, String slotName, String textureAbsPath, String jsonAbsPath);

    private final native void nUpdateMaterialRootPath(long nativeViewer, String path);

    private final native void nUpdateViewport(long nativeViewer, int avatarViewIndex, int left, int bootom, int width, int height);

    public static /* synthetic */ boolean render$default(ZplanAVChatViewer zplanAVChatViewer, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        return zplanAVChatViewer.render(z16);
    }

    public final void applyAIDataToAvatar(int viewIndex, @NotNull AvatarAIInfo avatarAIInfo, float ratio, boolean immediately) {
        Intrinsics.checkNotNullParameter(avatarAIInfo, "avatarAIInfo");
        if (viewIndex < 0) {
            return;
        }
        nApplyAIDataToAvatar(this.nativeObject, viewIndex, avatarAIInfo, ratio, immediately);
        long currentTimeMillis = System.currentTimeMillis() - avatarAIInfo.getOriginPts();
        if (this.isRenderDebug || (currentTimeMillis > 200 && currentTimeMillis < 10000)) {
            FLog.INSTANCE.d(TAG, "[applyAIDataToAvatar][" + viewIndex + "] delay: " + currentTimeMillis + "ms");
        }
    }

    public final void applyPinchFace(int index) {
        FLog.INSTANCE.i(TAG, "applyPinchFace " + index);
        if (index >= 0) {
            nApplyPinchFace(this.nativeObject, index);
        }
    }

    public final boolean check3DMMReady(int viewIndex) {
        return nCheck3DMMReady(this.nativeObject, viewIndex);
    }

    public final void cleanAvatar(int index) {
        FLog.INSTANCE.i(TAG, "cleanAvatar");
        if (index >= 0) {
            nCleanAvatar(this.nativeObject, index);
        }
    }

    public final int createAvatar() {
        int nCreateAvatar = nCreateAvatar(this.nativeObject);
        setRenderTargetWidth(nCreateAvatar, this.renderMaxTargetWidth);
        return nCreateAvatar;
    }

    public final void createSwapChain(@NotNull Surface surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        FLog.INSTANCE.i(TAG, "createSwapChain");
        nCreateSwapChain(this.nativeObject, surface);
    }

    public final void destroy() {
        FLog.INSTANCE.i(TAG, "destroy");
        long j3 = this.nativeObject;
        if (j3 != 0) {
            nDestroy(j3);
            this.nativeObject = 0L;
        }
    }

    public final int getRenderMaxTargetWidth() {
        return this.renderMaxTargetWidth;
    }

    /* renamed from: isRenderDebug, reason: from getter */
    public final boolean getIsRenderDebug() {
        return this.isRenderDebug;
    }

    @NotNull
    public final FilamentAnimation[] loadAnimation(int index, @NotNull String animationGltfPath) {
        Intrinsics.checkNotNullParameter(animationGltfPath, "animationGltfPath");
        FLog.INSTANCE.i(TAG, "loadAnimation " + index + TokenParser.SP + animationGltfPath);
        if (index >= 0 && !TextUtils.isEmpty(animationGltfPath)) {
            return nLoadAnimation(this.nativeObject, index, animationGltfPath);
        }
        return new FilamentAnimation[0];
    }

    public final void loadLight(@NotNull String iblPath) {
        Intrinsics.checkNotNullParameter(iblPath, "iblPath");
        FLog.INSTANCE.i(TAG, "loadLight, " + iblPath);
        if (!TextUtils.isEmpty(iblPath)) {
            nLoadLight(this.nativeObject, iblPath);
        }
    }

    public final void loadLut(int viewIndex, @NotNull String lutPath) {
        Intrinsics.checkNotNullParameter(lutPath, "lutPath");
        FLog.INSTANCE.i(TAG, "Load Lut index=" + viewIndex + " with file: " + lutPath + TokenParser.SP);
        if (!TextUtils.isEmpty(lutPath)) {
            nSetLutPath(this.nativeObject, viewIndex, lutPath);
        }
    }

    public final void loadPhysic(int viewIndex, @NotNull String physicPath) {
        Intrinsics.checkNotNullParameter(physicPath, "physicPath");
        FLog.INSTANCE.i(TAG, "Load Physic with file: " + physicPath);
        if (!TextUtils.isEmpty(physicPath)) {
            nSetPhysicPath(this.nativeObject, viewIndex, physicPath);
        }
    }

    public final void loadPinchFaceConfig(int index, @NotNull String pinchFaceConfigPath, @NotNull ZPlanPinchFaceModel[] pinchFaceModels, @NotNull String[] itemIdArray, boolean isFemale) {
        Intrinsics.checkNotNullParameter(pinchFaceConfigPath, "pinchFaceConfigPath");
        Intrinsics.checkNotNullParameter(pinchFaceModels, "pinchFaceModels");
        Intrinsics.checkNotNullParameter(itemIdArray, "itemIdArray");
        FLog.INSTANCE.i(TAG, "nLoadPinchFaceConfig");
        if (index >= 0) {
            nLoadPinchFaceConfig(this.nativeObject, index, pinchFaceConfigPath, pinchFaceModels, itemIdArray, isFemale);
        }
    }

    public final void loadSpotLight() {
        FLog.INSTANCE.i(TAG, "loadSpotLight");
        nLoadSpotLight(this.nativeObject);
    }

    public final void loadSun() {
        FLog.INSTANCE.i(TAG, "loadSun");
        nLoadSun(this.nativeObject);
    }

    public final void mirrorAvatar(int viewIndex) {
        if (viewIndex >= 0) {
            nMirrorAvatar(this.nativeObject, viewIndex);
        }
    }

    public final void parseAIInfo(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (!TextUtils.isEmpty(path)) {
            nParseAIInfoFromJson(this.nativeObject, path);
        }
    }

    public final void playAnimation(int index, @NotNull String animationGltfPath, double now) {
        Intrinsics.checkNotNullParameter(animationGltfPath, "animationGltfPath");
        FLog.INSTANCE.i(TAG, "playAnimation " + index + TokenParser.SP + animationGltfPath);
        if (index >= 0 && !TextUtils.isEmpty(animationGltfPath)) {
            nPlayAnimation(this.nativeObject, index, animationGltfPath, now);
        }
    }

    public final void receiveTouchEvent(@NotNull TouchEvent event) {
        float f16;
        Intrinsics.checkNotNullParameter(event, "event");
        FLog.INSTANCE.i(TAG, "receiveTouchEvent, touchEvent: " + event);
        int touchEventIntState = event.getState().toTouchEventIntState();
        int touchCount = event.getTouchCount();
        float f17 = event.getLocation().x;
        float f18 = event.getLocation().y;
        Float velocity = event.getVelocity();
        Float scale = event.getScale();
        if (event.getType() == TouchEventType.Pan) {
            nDidPan(this.nativeObject, touchEventIntState, touchCount, f17, f18);
            return;
        }
        if (event.getType() != TouchEventType.Pinch || scale == null) {
            return;
        }
        long j3 = this.nativeObject;
        if (velocity != null) {
            f16 = velocity.floatValue();
        } else {
            f16 = 0.0f;
        }
        nDidPinch(j3, touchEventIntState, touchCount, f17, f18, f16, scale.floatValue());
    }

    public final void recordFrame(@NotNull e listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        FLog.INSTANCE.i(TAG, "recordFrame");
    }

    public final void reloadAvatar(int avatarIndex, boolean isMale) {
        FLog.INSTANCE.i(TAG, "reloadAvatar, " + this.nativeObject);
        if (avatarIndex >= 0) {
            nReloadAvatar(this.nativeObject, avatarIndex, isMale);
        }
    }

    public final void remoteAvatar(int viewIndex) {
        if (viewIndex >= 0) {
            nRemoveAvatar(this.nativeObject, viewIndex);
        }
    }

    public final boolean render(boolean needRecord) {
        return nRender(this.nativeObject, needRecord);
    }

    public final void resetCamera() {
        FLog.INSTANCE.i(TAG, "resetCamera.");
        nResetCamera(this.nativeObject);
    }

    public final void scrollCamera(@NotNull PointF centerLocation, float scrolldelta) {
        Intrinsics.checkNotNullParameter(centerLocation, "centerLocation");
        FLog.INSTANCE.i(TAG, "scrollCamera, centerLocation: " + centerLocation + ", scrolldelta: " + scrolldelta);
        nScrollCamera(this.nativeObject, centerLocation.x, centerLocation.y, scrolldelta);
    }

    public final void setAvatarViewZoder(int viewIndex, int zorder) {
        if (viewIndex < 0) {
            return;
        }
        FLog.INSTANCE.d(TAG, "setAvatarViewZoder " + viewIndex + TokenParser.SP + zorder);
        nSetRenderZOrder(this.nativeObject, viewIndex, zorder);
    }

    public final void setRenderTargetWidth(int viewIndex, int width) {
        FLog.INSTANCE.d(TAG, "setRenderTargetWidth " + viewIndex + TokenParser.SP + width);
        nSetRenderTargetWidth(this.nativeObject, viewIndex, width);
    }

    public final void setTranslationOffset(int viewIndex, float xOffset, float yOffset, float zOffset) {
        FLog.INSTANCE.d(TAG, "setTranslationOffset [" + viewIndex + "] transform: {" + xOffset + ", " + yOffset + ", " + zOffset + '}');
        if (viewIndex < 0) {
            return;
        }
        nSetTranslationOffset(this.nativeObject, viewIndex, xOffset, yOffset, zOffset);
    }

    public final void stopAnimation(int index) {
        FLog.INSTANCE.i(TAG, "stopAnimation " + index);
        if (index >= 0) {
            nStopAnimation(this.nativeObject, index);
        }
    }

    public final void update3DMMPath(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        FLog fLog = FLog.INSTANCE;
        fLog.d(TAG, "update3DMMPath " + path + '.');
        if (TextUtils.isEmpty(path)) {
            fLog.d(TAG, "update3DMMPath error for null path.");
        } else {
            nUpdate3DMMPath(this.nativeObject, path);
        }
    }

    public final void updateAvatar(int index, @NotNull HashMap<String, String> resourceModel) {
        Intrinsics.checkNotNullParameter(resourceModel, "resourceModel");
        FLog.INSTANCE.i(TAG, "updateAvatar, " + resourceModel.size());
        if (index >= 0) {
            for (Map.Entry<String, String> entry : resourceModel.entrySet()) {
                nUpdateAvatar(this.nativeObject, index, entry.getKey(), entry.getValue());
            }
        }
    }

    public final void updateAvatarViewBg(int viewIndex, @NotNull String gltfPath, @NotNull String imageName) {
        Intrinsics.checkNotNullParameter(gltfPath, "gltfPath");
        Intrinsics.checkNotNullParameter(imageName, "imageName");
        FLog.INSTANCE.d(TAG, "updateAvatarViewBg " + viewIndex + TokenParser.SP + gltfPath + TokenParser.SP + imageName);
        if (!TextUtils.isEmpty(gltfPath) && !TextUtils.isEmpty(imageName)) {
            nUpdateAvatarViewBg(this.nativeObject, viewIndex, gltfPath, imageName);
        }
    }

    public final void updateMakeupSlotColor(int index, @NotNull String slotName, int r16, int g16, int b16, int a16) {
        Intrinsics.checkNotNullParameter(slotName, "slotName");
        FLog.INSTANCE.i(TAG, "updateMakeupSlotColor, " + index + TokenParser.SP + slotName);
        if (index >= 0 && !TextUtils.isEmpty(slotName)) {
            nUpdateMakeupSlotColor(this.nativeObject, index, slotName, r16, g16, b16, a16);
        }
    }

    public final void updateMakeupSlotTexture(int index, @NotNull String slotName, @Nullable String textureAbsPath, @Nullable String jsonAbsPath) {
        Intrinsics.checkNotNullParameter(slotName, "slotName");
        FLog.INSTANCE.i(TAG, "updateMakeupSlotTexture, " + index + TokenParser.SP + slotName);
        if (index >= 0 && !TextUtils.isEmpty(slotName)) {
            nUpdateMakeupSlotTexture(this.nativeObject, index, slotName, textureAbsPath, jsonAbsPath);
        }
    }

    public final void updateMaterialRootPath(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        FLog fLog = FLog.INSTANCE;
        fLog.d(TAG, "updateMaterialRootPath " + path + '.');
        if (TextUtils.isEmpty(path)) {
            fLog.d(TAG, "updateMaterialRootPath error for null path.");
        } else {
            nUpdateMaterialRootPath(this.nativeObject, path);
        }
    }

    public final void updateViewport(int index, int left, int bottom, int width, int height) {
        FLog.INSTANCE.i(TAG, "updateViewport, index=" + index + " w=" + width + " h=" + height + " left=" + left + " bottom=" + bottom, new Throwable(""));
        if (index >= 0 && left >= 0 && bottom >= 0 && width >= 0 && height >= 0) {
            nUpdateViewport(this.nativeObject, index, left, bottom, width, height);
        }
    }

    public /* synthetic */ ZplanAVChatViewer(String str, String str2, String str3, int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, i3, (i16 & 16) != 0 ? false : z16);
    }

    @NativeMethodProxy
    public final void onReocrdTexture(int textureId) {
    }
}
