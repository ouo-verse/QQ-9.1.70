package com.tencent.mobileqq.zplan.aigc.logic;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.aigc.data.AIGCModelRenderTask;
import com.tencent.mobileqq.zplan.aigc.data.PatternImage;
import com.tencent.mobileqq.zplan.aigc.data.TASK_STATUS;
import com.tencent.mobileqq.zplan.aigc.render.AIGCWhiteModel;
import com.tencent.mobileqq.zplan.aigc.render.ModelExtraInfo;
import com.tencent.mobileqq.zplan.aigc.render.ModelStyle;
import com.tencent.mobileqq.zplan.aigc.render.ZplanFilamentAIGCEditorManager;
import com.tencent.mobileqq.zplan.aigc.render.d;
import com.tencent.mobileqq.zplan.aigc.render.g;
import com.tencent.mobileqq.zplan.aigc.utils.AIGCHelper;
import com.tencent.mobileqq.zplan.aigc.utils.b;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.util.WeakReference;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 \u00062\u00020\u0001:\u0002-5B\u0011\b\u0016\u0012\u0006\u0010U\u001a\u00020N\u00a2\u0006\u0004\ba\u0010TJ\u001a\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J,\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u0016\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u001a\u0010\u0019\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017J$\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u001cJ\u0012\u0010\u001e\u001a\u00020\r2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u0006\u0010\u001f\u001a\u00020\u0002J\u0006\u0010 \u001a\u00020\u0004J\u0006\u0010!\u001a\u00020\rJ\u000e\u0010\"\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0004J*\u0010#\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010$\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJh\u0010+\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0004R$\u00103\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010;\u001a\u0002048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R2\u0010C\u001a\u0012\u0012\u0004\u0012\u00020\u00140<j\b\u0012\u0004\u0012\u00020\u0014`=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR2\u0010F\u001a\u0012\u0012\u0004\u0012\u00020\u00070<j\b\u0012\u0004\u0012\u00020\u0007`=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010>\u001a\u0004\bD\u0010@\"\u0004\bE\u0010BR\u0016\u0010H\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010GR\u0016\u0010J\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010IR$\u0010K\u001a\u0012\u0012\u0004\u0012\u00020\u00040<j\b\u0012\u0004\u0012\u00020\u0004`=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010>R\"\u0010L\u001a\u0002048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u00106\u001a\u0004\bL\u00108\"\u0004\bM\u0010:R$\u0010U\u001a\u0004\u0018\u00010N8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010Z\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010I\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010`\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_\u00a8\u0006b"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/logic/CreatedClothShowLogic;", "", "", "index", "", "givenColor", "l", "Lcom/tencent/mobileqq/zplan/aigc/data/d;", "renderTask", "Lcom/tencent/mobileqq/zplan/aigc/render/AIGCWhiteModel;", "whiteModel", "Lcom/tencent/mobileqq/zplan/aigc/logic/CreatedClothShowLogic$b;", "callback", "", "d", "imageryId", "imageryDescription", "", "ugcId", "imageryName", "Lcom/tencent/mobileqq/zplan/aigc/data/l;", "g", "j", "Lcom/tencent/mobileqq/zplan/aigc/render/g;", "listener", "c", "patternPosType", "color", "Lmqq/util/WeakReference;", "f", "e", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ReportConstant.COSTREPORT_PREFIX, "w", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "id", "imgUGCId", "Lcom/tencent/mobileqq/zplan/aigc/data/TASK_STATUS;", "taskStatus", "baseColor", "modelItemId", h.F, "Lcom/tencent/mobileqq/zplan/aigc/render/d;", "a", "Lcom/tencent/mobileqq/zplan/aigc/render/d;", "k", "()Lcom/tencent/mobileqq/zplan/aigc/render/d;", "setAigcClothThumbnailRender", "(Lcom/tencent/mobileqq/zplan/aigc/render/d;)V", "aigcClothThumbnailRender", "", "b", "Z", "getCreatedClothLoading", "()Z", "setCreatedClothLoading", "(Z)V", "createdClothLoading", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getCurrentPatterImages", "()Ljava/util/ArrayList;", "setCurrentPatterImages", "(Ljava/util/ArrayList;)V", "currentPatterImages", "getCurrentRenderTasks", "setCurrentRenderTasks", "currentRenderTasks", "Ljava/lang/String;", "currentColorString", "I", "currentPatternPosType", "firstRenderColors", "isManagerInit", "t", "Landroid/content/Context;", "i", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "o", "()I", "u", "(I)V", "safeReqId", "Lcom/tencent/mobileqq/zplan/aigc/data/d;", "p", "()Lcom/tencent/mobileqq/zplan/aigc/data/d;", "v", "(Lcom/tencent/mobileqq/zplan/aigc/data/d;)V", "selectedPatternTask", "<init>", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class CreatedClothShowLogic {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zplan.aigc.render.d aigcClothThumbnailRender;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean createdClothLoading;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ArrayList<PatternImage> currentPatterImages;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ArrayList<AIGCModelRenderTask> currentRenderTasks;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String currentColorString;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int currentPatternPosType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<String> firstRenderColors;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isManagerInit;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Context context;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int safeReqId;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private AIGCModelRenderTask selectedPatternTask;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aigc/logic/CreatedClothShowLogic$c", "Lcom/tencent/mobileqq/zplan/aigc/utils/b$a;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AIGCModelRenderTask f330365a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CreatedClothShowLogic f330366b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f330367c;

        c(AIGCModelRenderTask aIGCModelRenderTask, CreatedClothShowLogic createdClothShowLogic, b bVar) {
            this.f330365a = aIGCModelRenderTask;
            this.f330366b = createdClothShowLogic;
            this.f330367c = bVar;
        }

        @Override // com.tencent.mobileqq.zplan.aigc.utils.b.a
        public void a(Bitmap bitmap) {
            this.f330365a.getPatternImage().h(bitmap);
            this.f330366b.j(this.f330365a, this.f330367c);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aigc/logic/CreatedClothShowLogic$d", "Lcom/tencent/mobileqq/zplan/aigc/render/g;", "", "result", "", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements com.tencent.mobileqq.zplan.aigc.render.g {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.aigc.render.g f330369b;

        d(com.tencent.mobileqq.zplan.aigc.render.g gVar) {
            this.f330369b = gVar;
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void a(String str) {
            g.a.b(this, str);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void b(int result) {
            ZplanFilamentAIGCEditorManager zplanFilamentAIGCEditorManager;
            com.tencent.mobileqq.zplan.aigc.render.d aigcClothThumbnailRender = CreatedClothShowLogic.this.getAigcClothThumbnailRender();
            if (aigcClothThumbnailRender == null || (zplanFilamentAIGCEditorManager = aigcClothThumbnailRender.getZplanFilamentAIGCEditorManager()) == null) {
                return;
            }
            zplanFilamentAIGCEditorManager.K(this.f330369b);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void c(boolean z16) {
            g.a.f(this, z16);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void d(String str) {
            g.a.c(this, str);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void e(boolean z16, AIGCWhiteModel aIGCWhiteModel) {
            g.a.g(this, z16, aIGCWhiteModel);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void f(int i3) {
            g.a.a(this, i3);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void onScreenShotResult(Bitmap bitmap) {
            g.a.d(this, bitmap);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aigc/logic/CreatedClothShowLogic$e", "Lcom/tencent/mobileqq/zplan/aigc/render/g;", "", "result", "", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements com.tencent.mobileqq.zplan.aigc.render.g {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WeakReference<com.tencent.mobileqq.zplan.aigc.render.g> f330371b;

        e(WeakReference<com.tencent.mobileqq.zplan.aigc.render.g> weakReference) {
            this.f330371b = weakReference;
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void a(String str) {
            g.a.b(this, str);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void b(int result) {
            ZplanFilamentAIGCEditorManager zplanFilamentAIGCEditorManager;
            com.tencent.mobileqq.zplan.aigc.render.d aigcClothThumbnailRender = CreatedClothShowLogic.this.getAigcClothThumbnailRender();
            if (aigcClothThumbnailRender == null || (zplanFilamentAIGCEditorManager = aigcClothThumbnailRender.getZplanFilamentAIGCEditorManager()) == null) {
                return;
            }
            zplanFilamentAIGCEditorManager.M(null, this.f330371b);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void c(boolean z16) {
            g.a.f(this, z16);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void d(String str) {
            g.a.c(this, str);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void e(boolean z16, AIGCWhiteModel aIGCWhiteModel) {
            g.a.g(this, z16, aIGCWhiteModel);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void f(int i3) {
            g.a.a(this, i3);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void onScreenShotResult(Bitmap bitmap) {
            g.a.d(this, bitmap);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/aigc/logic/CreatedClothShowLogic$f", "Lcom/tencent/mobileqq/zplan/aigc/render/d$d;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "id", "Lcom/tencent/mobileqq/zplan/aigc/data/TASK_STATUS;", "result", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f implements d.InterfaceC9136d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AIGCModelRenderTask f330372a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f330373b;

        f(AIGCModelRenderTask aIGCModelRenderTask, b bVar) {
            this.f330372a = aIGCModelRenderTask;
            this.f330373b = bVar;
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.d.InterfaceC9136d
        public void a(Bitmap bitmap, int id5, TASK_STATUS result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.f330372a.n(bitmap);
            this.f330372a.o(result);
            QLog.i("CreatedClothShowLogic", 1, "aigctest generateThumbnail " + this.f330372a.getId() + ", " + this.f330372a.getStatus());
            b bVar = this.f330373b;
            if (bVar != null) {
                bVar.b(this.f330372a);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aigc/logic/CreatedClothShowLogic$g", "Lcom/tencent/mobileqq/zplan/aigc/render/g;", "", "result", "", "f", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class g implements com.tencent.mobileqq.zplan.aigc.render.g {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f330375b;

        g(b bVar) {
            this.f330375b = bVar;
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void a(String str) {
            g.a.b(this, str);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void b(int i3) {
            g.a.e(this, i3);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void c(boolean z16) {
            g.a.f(this, z16);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void d(String str) {
            g.a.c(this, str);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void e(boolean z16, AIGCWhiteModel aIGCWhiteModel) {
            g.a.g(this, z16, aIGCWhiteModel);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void f(int result) {
            CreatedClothShowLogic.this.t(true);
            QLog.i("CreatedClothShowLogic", 1, "preCheckEngine onAIGCEngineState");
            b bVar = this.f330375b;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void onScreenShotResult(Bitmap bitmap) {
            g.a.d(this, bitmap);
        }
    }

    public CreatedClothShowLogic(Context context) {
        ArrayList<String> arrayListOf;
        Intrinsics.checkNotNullParameter(context, "context");
        this.currentPatterImages = new ArrayList<>();
        this.currentRenderTasks = new ArrayList<>();
        this.currentColorString = "#FFFFFF";
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("#FFFFFF", "#000000", "#FF0000FF", "#FFFFC0CB");
        this.firstRenderColors = arrayListOf;
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(AIGCModelRenderTask renderTask, AIGCWhiteModel whiteModel, b callback) {
        com.tencent.mobileqq.zplan.aigc.utils.b bVar = new com.tencent.mobileqq.zplan.aigc.utils.b(new c(renderTask, this, callback));
        String url = renderTask.getPatternImage().getUrl();
        if (TextUtils.isEmpty(url) && callback != null) {
            callback.c(renderTask, TASK_STATUS.TASK_STATUS_ERROR_IMG_NETWORK.ordinal());
        }
        bVar.execute(url);
    }

    private final PatternImage g(int imageryId, String imageryDescription, long ugcId, String imageryName) {
        return new PatternImage(null, 512, 512, "", imageryId, imageryDescription, ugcId, null, imageryName, 128, null);
    }

    private final String l(int index, String givenColor) {
        if (TextUtils.isEmpty(givenColor)) {
            String str = this.firstRenderColors.get(index % 4);
            Intrinsics.checkNotNullExpressionValue(str, "{\n            firstRende\u2026%ITEM_PER_PAGE]\n        }");
            return str;
        }
        Intrinsics.checkNotNull(givenColor);
        return givenColor;
    }

    public final void c(AIGCModelRenderTask renderTask, com.tencent.mobileqq.zplan.aigc.render.g listener) {
        Intrinsics.checkNotNullParameter(renderTask, "renderTask");
        this.selectedPatternTask = renderTask;
        this.currentColorString = renderTask.getColor();
        this.currentPatternPosType = renderTask.getPatternPosType();
        if (listener != null) {
            String previewResourceDirPath = renderTask.getPreviewResourceDirPath();
            Intrinsics.checkNotNull(previewResourceDirPath);
            listener.a(previewResourceDirPath);
        }
    }

    public final void e(com.tencent.mobileqq.zplan.aigc.render.g listener) {
        ZplanFilamentAIGCEditorManager zplanFilamentAIGCEditorManager;
        List<ModelStyle> modelStyles;
        AIGCModelRenderTask aIGCModelRenderTask = this.selectedPatternTask;
        int i3 = 1;
        if (aIGCModelRenderTask != null) {
            Intrinsics.checkNotNull(aIGCModelRenderTask);
            ModelExtraInfo modelExtraInfo = aIGCModelRenderTask.getModel().getModelExtraInfo();
            if (modelExtraInfo != null && (modelStyles = modelExtraInfo.getModelStyles()) != null) {
                i3 = modelStyles.size();
            }
            com.tencent.mobileqq.zplan.aigc.render.d dVar = this.aigcClothThumbnailRender;
            if (dVar == null || (zplanFilamentAIGCEditorManager = dVar.getZplanFilamentAIGCEditorManager()) == null) {
                return;
            }
            int i16 = this.currentPatternPosType % i3;
            String str = this.currentColorString;
            AIGCModelRenderTask aIGCModelRenderTask2 = this.selectedPatternTask;
            Intrinsics.checkNotNull(aIGCModelRenderTask2);
            Bitmap bitmap = aIGCModelRenderTask2.getPatternImage().getBitmap();
            AIGCModelRenderTask aIGCModelRenderTask3 = this.selectedPatternTask;
            Intrinsics.checkNotNull(aIGCModelRenderTask3);
            zplanFilamentAIGCEditorManager.V(i16, str, 1024, 1024, bitmap, aIGCModelRenderTask3.getModel(), true, new d(listener));
            return;
        }
        QLog.e("CreatedClothShowLogic", 1, "generateArchiveResource, currentTask is null !!!");
    }

    public final void f(int patternPosType, String color, WeakReference<com.tencent.mobileqq.zplan.aigc.render.g> listener) {
        ZplanFilamentAIGCEditorManager zplanFilamentAIGCEditorManager;
        ZplanFilamentAIGCEditorManager zplanFilamentAIGCEditorManager2;
        List<ModelStyle> modelStyles;
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.currentColorString = color;
        this.currentPatternPosType = patternPosType;
        AIGCModelRenderTask aIGCModelRenderTask = this.selectedPatternTask;
        if (aIGCModelRenderTask != null) {
            Intrinsics.checkNotNull(aIGCModelRenderTask);
            ModelExtraInfo modelExtraInfo = aIGCModelRenderTask.getModel().getModelExtraInfo();
            int size = (modelExtraInfo == null || (modelStyles = modelExtraInfo.getModelStyles()) == null) ? 1 : modelStyles.size();
            AIGCModelRenderTask aIGCModelRenderTask2 = this.selectedPatternTask;
            Intrinsics.checkNotNull(aIGCModelRenderTask2);
            String ugcID = aIGCModelRenderTask2.getUgcID();
            com.tencent.mobileqq.zplan.aigc.render.d dVar = this.aigcClothThumbnailRender;
            QLog.e("CreatedClothShowLogic", 1, "generatePreviewResource ugcID: " + ugcID + ", " + ((dVar == null || (zplanFilamentAIGCEditorManager2 = dVar.getZplanFilamentAIGCEditorManager()) == null) ? null : zplanFilamentAIGCEditorManager2.getUgcEditorId()));
            com.tencent.mobileqq.zplan.aigc.render.d dVar2 = this.aigcClothThumbnailRender;
            if (dVar2 == null || (zplanFilamentAIGCEditorManager = dVar2.getZplanFilamentAIGCEditorManager()) == null) {
                return;
            }
            int i3 = patternPosType % size;
            AIGCModelRenderTask aIGCModelRenderTask3 = this.selectedPatternTask;
            Intrinsics.checkNotNull(aIGCModelRenderTask3);
            Bitmap bitmap = aIGCModelRenderTask3.getPatternImage().getBitmap();
            AIGCModelRenderTask aIGCModelRenderTask4 = this.selectedPatternTask;
            Intrinsics.checkNotNull(aIGCModelRenderTask4);
            zplanFilamentAIGCEditorManager.V(i3, color, 1024, 1024, bitmap, aIGCModelRenderTask4.getModel(), false, new e(listener));
            return;
        }
        QLog.e("CreatedClothShowLogic", 1, "currentTask is null !!!");
    }

    /* renamed from: k, reason: from getter */
    public final com.tencent.mobileqq.zplan.aigc.render.d getAigcClothThumbnailRender() {
        return this.aigcClothThumbnailRender;
    }

    /* renamed from: m, reason: from getter */
    public final String getCurrentColorString() {
        return this.currentColorString;
    }

    /* renamed from: n, reason: from getter */
    public final int getCurrentPatternPosType() {
        return this.currentPatternPosType;
    }

    /* renamed from: o, reason: from getter */
    public final int getSafeReqId() {
        return this.safeReqId;
    }

    /* renamed from: p, reason: from getter */
    public final AIGCModelRenderTask getSelectedPatternTask() {
        return this.selectedPatternTask;
    }

    public final void q(b callback) {
        if (this.isManagerInit) {
            if (callback != null) {
                callback.a();
            }
        } else {
            Context context = this.context;
            Intrinsics.checkNotNull(context);
            this.aigcClothThumbnailRender = new com.tencent.mobileqq.zplan.aigc.render.d(512, 512, context, new g(callback));
        }
    }

    public final void s() {
        com.tencent.mobileqq.zplan.aigc.render.d dVar = this.aigcClothThumbnailRender;
        if (dVar != null) {
            dVar.m();
        }
        this.aigcClothThumbnailRender = null;
    }

    public final void t(boolean z16) {
        this.isManagerInit = z16;
    }

    public final void u(int i3) {
        this.safeReqId = i3;
    }

    public final void v(AIGCModelRenderTask aIGCModelRenderTask) {
        this.selectedPatternTask = aIGCModelRenderTask;
    }

    public final void w(String ugcId) {
        Intrinsics.checkNotNullParameter(ugcId, "ugcId");
        if (this.isManagerInit) {
            com.tencent.mobileqq.zplan.aigc.render.d dVar = this.aigcClothThumbnailRender;
            ZplanFilamentAIGCEditorManager zplanFilamentAIGCEditorManager = dVar != null ? dVar.getZplanFilamentAIGCEditorManager() : null;
            if (zplanFilamentAIGCEditorManager == null) {
                return;
            }
            zplanFilamentAIGCEditorManager.W(ugcId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(AIGCModelRenderTask renderTask, b callback) {
        this.createdClothLoading = true;
        com.tencent.mobileqq.zplan.aigc.render.d dVar = this.aigcClothThumbnailRender;
        if (dVar != null) {
            dVar.i(renderTask, new f(renderTask, callback));
        }
    }

    public final AIGCModelRenderTask h(int id5, AIGCWhiteModel whiteModel, int imageryId, String imageryDescription, long imgUGCId, String ugcId, TASK_STATUS taskStatus, String baseColor, String imageryName, String modelItemId) {
        Intrinsics.checkNotNullParameter(whiteModel, "whiteModel");
        Intrinsics.checkNotNullParameter(ugcId, "ugcId");
        Intrinsics.checkNotNullParameter(taskStatus, "taskStatus");
        PatternImage g16 = g(imageryId, imageryDescription, imgUGCId, imageryName);
        Integer num = AIGCHelper.f330685a.t().get(id5 % 4);
        Intrinsics.checkNotNullExpressionValue(num, "AIGCHelper.firstRenderTypes[id%ITEM_PER_PAGE]");
        return new AIGCModelRenderTask(id5, whiteModel, g16, num.intValue(), l(id5, baseColor), null, taskStatus, ugcId, id5, modelItemId, null, 1024, null);
    }

    public final void r(AIGCModelRenderTask renderTask, long ugcId, AIGCWhiteModel whiteModel, b callback) {
        Intrinsics.checkNotNullParameter(renderTask, "renderTask");
        Intrinsics.checkNotNullParameter(whiteModel, "whiteModel");
        if (renderTask.getStatus() == TASK_STATUS.TASK_STATUS_SCREEN_SHOT_SUCCESS || renderTask.getStatus() == TASK_STATUS.TASK_STATUS_ERROR_PROMPT_FORBIDDEN) {
            if (callback != null) {
                callback.b(renderTask);
            }
        } else if (TextUtils.isEmpty(renderTask.getPatternImage().getUrl())) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CreatedClothShowLogic$processSingleRenderTask2$1(ugcId, renderTask, this, whiteModel, callback, null), 3, null);
        } else {
            d(renderTask, whiteModel, callback);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/logic/CreatedClothShowLogic$b;", "", "Lcom/tencent/mobileqq/zplan/aigc/data/d;", "renderTask", "", "b", "", "resCode", "c", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface b {
        void a();

        void b(AIGCModelRenderTask renderTask);

        void c(AIGCModelRenderTask renderTask, int resCode);

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes35.dex */
        public static final class a {
            public static void b(b bVar, AIGCModelRenderTask renderTask, int i3) {
                Intrinsics.checkNotNullParameter(renderTask, "renderTask");
            }

            public static void c(b bVar, AIGCModelRenderTask renderTask) {
                Intrinsics.checkNotNullParameter(renderTask, "renderTask");
            }

            public static void a(b bVar) {
            }
        }
    }
}
