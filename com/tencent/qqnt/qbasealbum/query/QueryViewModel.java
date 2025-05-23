package com.tencent.qqnt.qbasealbum.query;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.qqnt.qbasealbum.coroutine.QAlbumCoroutineScopes;
import com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.select.model.j;
import com.tencent.qqnt.qbasealbum.utils.InitDataUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bA\u0010BJB\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0002J-\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u0014\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0016J,\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00052\u0006\u0010\r\u001a\u00020\fJ@\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00052\u0006\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\bR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020%0)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010'R\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020%0)8\u0006\u00a2\u0006\f\n\u0004\b1\u0010+\u001a\u0004\b2\u0010-R\"\u0010;\u001a\u0002048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010=\u00a8\u0006C"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/query/QueryViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "start", "end", "", "", "list", "", "needPickerPayload", "Lcom/tencent/qqnt/qbasealbum/query/FromType;", IProfileCardConst.KEY_FROM_TYPE, "Lcom/tencent/qqnt/qbasealbum/query/ScrollDirection;", "scrollDirection", "", "j2", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "", "projection", "selection", SemanticAttributes.DbSystemValues.H2, "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;)V", "d2", "f2", "getLogTag", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "c2", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "needNotify", "changeAlbum", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lkotlinx/coroutines/Job;", "i", "Lkotlinx/coroutines/Job;", "queryJob", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/qqnt/qbasealbum/select/model/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_mediaUpdateByPayload", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "W1", "()Landroidx/lifecycle/LiveData;", "mediaUpdateByPayload", "D", "_mediaUpdateInPreview", "E", "X1", "mediaUpdateInPreview", "Lcom/tencent/qqnt/qbasealbum/query/a;", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/qbasealbum/query/a;", "Z1", "()Lcom/tencent/qqnt/qbasealbum/query/a;", "i2", "(Lcom/tencent/qqnt/qbasealbum/query/a;)V", "posData", "G", "I", "startPos", "H", "endPos", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class QueryViewModel extends BaseViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: C */
    @NotNull
    private final LiveData<com.tencent.qqnt.qbasealbum.select.model.a> mediaUpdateByPayload;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<com.tencent.qqnt.qbasealbum.select.model.a> _mediaUpdateInPreview;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<com.tencent.qqnt.qbasealbum.select.model.a> mediaUpdateInPreview;

    /* renamed from: F */
    @NotNull
    private a posData;

    /* renamed from: G, reason: from kotlin metadata */
    private int startPos;

    /* renamed from: H, reason: from kotlin metadata */
    private int endPos;

    /* renamed from: i, reason: from kotlin metadata */
    @Nullable
    private Job queryJob;

    /* renamed from: m */
    @NotNull
    private final MutableLiveData<com.tencent.qqnt.qbasealbum.select.model.a> _mediaUpdateByPayload;

    public QueryViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MutableLiveData<com.tencent.qqnt.qbasealbum.select.model.a> mutableLiveData = new MutableLiveData<>();
        this._mediaUpdateByPayload = mutableLiveData;
        this.mediaUpdateByPayload = mutableLiveData;
        MutableLiveData<com.tencent.qqnt.qbasealbum.select.model.a> mutableLiveData2 = new MutableLiveData<>();
        this._mediaUpdateInPreview = mutableLiveData2;
        this.mediaUpdateInPreview = mutableLiveData2;
        this.posData = new a(0, 0);
        this.endPos = InitDataUtil.f361625a.b() - 1;
    }

    public static /* synthetic */ void b2(QueryViewModel queryViewModel, int i3, int i16, List list, boolean z16, ScrollDirection scrollDirection, boolean z17, int i17, Object obj) {
        if ((i17 & 16) != 0) {
            scrollDirection = ScrollDirection.DEFAULT;
        }
        ScrollDirection scrollDirection2 = scrollDirection;
        if ((i17 & 32) != 0) {
            z17 = false;
        }
        queryViewModel.a2(i3, i16, list, z16, scrollDirection2, z17);
    }

    public final void d2(final int start, final int end) {
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.query.c
            @Override // java.lang.Runnable
            public final void run() {
                QueryViewModel.e2(QueryViewModel.this, start, end);
            }
        });
    }

    public static final void e2(QueryViewModel this$0, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0._mediaUpdateByPayload.postValue(new j(i3, i16));
    }

    public final void f2(final int start, final int end) {
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.query.d
            @Override // java.lang.Runnable
            public final void run() {
                QueryViewModel.g2(QueryViewModel.this, start, end);
            }
        });
    }

    public static final void g2(QueryViewModel this$0, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0._mediaUpdateInPreview.postValue(new j(i3, i16));
    }

    public final void h2(Uri uri, String[] strArr, String str) {
        try {
            Cursor query = ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), uri, strArr, str, null, com.tencent.mobileqq.activity.photo.album.querymedia.ICursor.ORDER_BY_DATE_MODIFIED);
            if (query != null) {
                Cursor cursor = query;
                try {
                    Cursor cursor2 = cursor;
                    int columnIndex = cursor2.getColumnIndex("_id");
                    int columnIndex2 = cursor2.getColumnIndex("_data");
                    while (cursor2.moveToNext()) {
                        long j3 = cursor2.getLong(columnIndex);
                        String path = cursor2.getString(columnIndex2);
                        LocalMediaDataHub a16 = LocalMediaDataHub.INSTANCE.a();
                        Intrinsics.checkNotNullExpressionValue(path, "path");
                        a16.u0(j3, path);
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(cursor, null);
                } catch (Throwable th5) {
                    try {
                        throw th5;
                    } catch (Throwable th6) {
                        CloseableKt.closeFinally(cursor, th5);
                        throw th6;
                    }
                }
            }
        } catch (SQLiteException e16) {
            ox3.a.f(getTAG(), new Function0<String>(e16) { // from class: com.tencent.qqnt.qbasealbum.query.QueryViewModel$queryAndUpdate$4
                static IPatchRedirector $redirector_;
                final /* synthetic */ SQLiteException $e;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$e = e16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) e16);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "loadMoreMedia database error: " + this.$e;
                }
            });
        } catch (IllegalArgumentException e17) {
            ox3.a.f(getTAG(), new Function0<String>(e17) { // from class: com.tencent.qqnt.qbasealbum.query.QueryViewModel$queryAndUpdate$3
                static IPatchRedirector $redirector_;
                final /* synthetic */ IllegalArgumentException $e;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$e = e17;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) e17);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "loadMoreMedia invalid query arguments: " + this.$e;
                }
            });
        } catch (SecurityException e18) {
            ox3.a.f(getTAG(), new Function0<String>(e18) { // from class: com.tencent.qqnt.qbasealbum.query.QueryViewModel$queryAndUpdate$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ SecurityException $e;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$e = e18;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) e18);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "loadMoreMedia permission denied: " + this.$e;
                }
            });
        }
    }

    private final void j2(int start, int end, List<String> list, boolean needPickerPayload, FromType r19, ScrollDirection scrollDirection) {
        Job launch$default;
        if (this.queryJob != null) {
            ox3.a.c(getTAG(), QueryViewModel$startQueryJob$1.INSTANCE);
            Job job = this.queryJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
        }
        ox3.a.c(getTAG(), new Function0<String>(start, end, needPickerPayload, r19) { // from class: com.tencent.qqnt.qbasealbum.query.QueryViewModel$startQueryJob$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $end;
            final /* synthetic */ FromType $fromType;
            final /* synthetic */ boolean $needPickerPayload;
            final /* synthetic */ int $start;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$start = start;
                this.$end = end;
                this.$needPickerPayload = needPickerPayload;
                this.$fromType = r19;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Integer.valueOf(start), Integer.valueOf(end), Boolean.valueOf(needPickerPayload), r19);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "loadMoreMedia start: " + this.$start + " end: " + this.$end + " needPickerPayload: " + this.$needPickerPayload + " fromType: " + this.$fromType;
            }
        });
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(QAlbumCoroutineScopes.f361069a.d()), null, null, new QueryViewModel$startQueryJob$3(list, this, scrollDirection, start, end, r19, needPickerPayload, null), 3, null);
        this.queryJob = launch$default;
    }

    static /* synthetic */ void k2(QueryViewModel queryViewModel, int i3, int i16, List list, boolean z16, FromType fromType, ScrollDirection scrollDirection, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            z16 = false;
        }
        boolean z17 = z16;
        if ((i17 & 32) != 0) {
            scrollDirection = ScrollDirection.DEFAULT;
        }
        queryViewModel.j2(i3, i16, list, z17, fromType, scrollDirection);
    }

    @NotNull
    public final LiveData<com.tencent.qqnt.qbasealbum.select.model.a> W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mediaUpdateByPayload;
    }

    @NotNull
    public final LiveData<com.tencent.qqnt.qbasealbum.select.model.a> X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mediaUpdateInPreview;
    }

    @NotNull
    public final a Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.posData;
    }

    public final void a2(int i3, int i16, @NotNull List<LocalMediaInfo> list, boolean z16, @NotNull ScrollDirection scrollDirection, boolean z17) {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), list, Boolean.valueOf(z16), scrollDirection, Boolean.valueOf(z17));
            return;
        }
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(scrollDirection, "scrollDirection");
        if (z17) {
            ox3.a.c(getTAG(), new Function0<String>(i3, i16) { // from class: com.tencent.qqnt.qbasealbum.query.QueryViewModel$loadMoreMediaForPicker$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $end;
                final /* synthetic */ int $start;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$start = i3;
                    this.$end = i16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return "changeAlbum start: " + this.$start + " end: " + this.$end;
                }
            });
            this.posData = new a(i3, i16);
        }
        if (list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (TextUtils.isEmpty(((LocalMediaInfo) obj).getPath())) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(String.valueOf(((LocalMediaInfo) it.next()).get_id()));
            }
            j2(i3, i16, arrayList2, z16, FromType.FROM_PICKER, scrollDirection);
            return;
        }
        this.posData = new a(i3, i16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006b, code lost:
    
        if (android.text.TextUtils.isEmpty(r5) == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0089, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0087, code lost:
    
        if (android.text.TextUtils.isEmpty(r6) != false) goto L86;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c2(int start, int end, @NotNull List<? extends RFWLayerItemMediaInfo> list, @NotNull ScrollDirection scrollDirection) {
        int collectionSizeOrDefault;
        RFWLayerPicInfo.RFWPicInfo originPicInfo;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(start), Integer.valueOf(end), list, scrollDirection);
            return;
        }
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(scrollDirection, "scrollDirection");
        if (list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = (RFWLayerItemMediaInfo) obj;
            String str2 = null;
            if (rFWLayerItemMediaInfo.isVideo()) {
                RFWLayerVideoInfo layerVideoInfo = rFWLayerItemMediaInfo.getLayerVideoInfo();
                if (layerVideoInfo != null) {
                    str = layerVideoInfo.getLocalPath();
                } else {
                    str = null;
                }
            }
            if (!rFWLayerItemMediaInfo.isVideo()) {
                RFWLayerPicInfo layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo();
                if (layerPicInfo != null && (originPicInfo = layerPicInfo.getOriginPicInfo()) != null) {
                    str2 = originPicInfo.getLocalPath();
                }
            }
            boolean z16 = false;
            if (z16) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String mediaId = ((RFWLayerItemMediaInfo) it.next()).getMediaId();
                if (mediaId == null) {
                    mediaId = "";
                }
                arrayList2.add(mediaId);
            }
            k2(this, start, end, arrayList2, false, FromType.FROM_PREVIEW, scrollDirection, 8, null);
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "QBaseAlbum.MediaPayloadQuery";
    }

    public final void i2(@NotNull a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        } else {
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            this.posData = aVar;
        }
    }
}
