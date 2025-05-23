package com.qzone.reborn.comment.utils.cachedata;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qzone.reborn.comment.bean.QZoneCommentCacheData;
import com.qzone.reborn.util.i;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0006\u0010\f\u001a\u00020\u0002R&\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00040\rj\b\u0012\u0004\u0012\u00020\u0004`\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/comment/utils/cachedata/d;", "Lcom/qzone/reborn/comment/utils/cachedata/a;", "", "b", "Lcom/qzone/reborn/comment/bean/QZoneCommentCacheData;", "cacheData", "e", "c", "", v4.b.UNIKEY, "query", "a", "f", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mCacheDataList", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class d implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private ArrayList<QZoneCommentCacheData> mCacheDataList = new ArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001\u00a8\u0006\u0005"}, d2 = {"com/qzone/reborn/comment/utils/cachedata/d$b", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "Lcom/qzone/reborn/comment/bean/QZoneCommentCacheData;", "Lkotlin/collections/ArrayList;", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends TypeToken<ArrayList<QZoneCommentCacheData>> {
        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            String json = new Gson().toJson(this$0.mCacheDataList);
            i.b().r("key_comment_cache", json);
            QLog.d("QZoneCommentMmkvCacheImp", 4, "[saveCacheData] cacheDataStr:" + json);
        } catch (Exception e16) {
            QLog.e("QZoneCommentMmkvCacheImp", 1, "[saveCacheData] fail:" + e16);
        }
    }

    @Override // com.qzone.reborn.comment.utils.cachedata.a
    public void a(String unikey) {
        Intrinsics.checkNotNullParameter(unikey, "unikey");
        boolean z16 = true;
        QLog.d("QZoneCommentMmkvCacheImp", 1, "[deleteCacheData] unikey:" + unikey);
        Iterator<QZoneCommentCacheData> it = this.mCacheDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                z16 = false;
                break;
            }
            QZoneCommentCacheData next = it.next();
            if (Intrinsics.areEqual(unikey, next.getV4.b.UNIKEY java.lang.String())) {
                this.mCacheDataList.remove(next);
                break;
            }
        }
        if (z16) {
            f();
        }
    }

    @Override // com.qzone.reborn.comment.utils.cachedata.a
    public void b() {
        String j3 = i.b().j("key_comment_cache", null);
        QLog.d("QZoneCommentMmkvCacheImp", 4, "[loadCacheData] cacheJsonStr:" + j3);
        if (TextUtils.isEmpty(j3)) {
            return;
        }
        try {
            Object fromJson = new Gson().fromJson(j3, new b().getType());
            Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(\n       \u2026{}.type\n                )");
            this.mCacheDataList = (ArrayList) fromJson;
        } catch (Throwable th5) {
            QLog.e("QZoneCommentMmkvCacheImp", 1, "parse error:" + th5);
        }
    }

    @Override // com.qzone.reborn.comment.utils.cachedata.a
    public void c(QZoneCommentCacheData cacheData) {
        boolean z16;
        Intrinsics.checkNotNullParameter(cacheData, "cacheData");
        QLog.d("QZoneCommentMmkvCacheImp", 4, "[updateCacheData] cacheData:" + cacheData);
        Iterator<QZoneCommentCacheData> it = this.mCacheDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                z16 = false;
                break;
            }
            QZoneCommentCacheData next = it.next();
            if (Intrinsics.areEqual(cacheData.getV4.b.UNIKEY java.lang.String(), next.getV4.b.UNIKEY java.lang.String())) {
                if (Intrinsics.areEqual(cacheData.getInputContent(), next.getInputContent())) {
                    return;
                }
                next.e(cacheData.getInputContent());
                next.f(cacheData.getTimestamp());
                z16 = true;
            }
        }
        if (z16) {
            f();
        } else {
            e(cacheData);
        }
    }

    public void e(QZoneCommentCacheData cacheData) {
        Intrinsics.checkNotNullParameter(cacheData, "cacheData");
        QLog.d("QZoneCommentMmkvCacheImp", 4, "[insertCacheData] cacheData:" + cacheData);
        this.mCacheDataList.add(cacheData);
        f();
        if (this.mCacheDataList.size() > 50) {
            Iterator<QZoneCommentCacheData> it = this.mCacheDataList.iterator();
            String str = "";
            long j3 = 0;
            while (it.hasNext()) {
                QZoneCommentCacheData next = it.next();
                if (j3 == 0 || next.getTimestamp() < j3) {
                    j3 = next.getTimestamp();
                    str = next.getV4.b.UNIKEY java.lang.String();
                    if (str == null) {
                        str = "";
                    }
                }
            }
            a(str);
        }
    }

    public final void f() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.comment.utils.cachedata.c
            @Override // java.lang.Runnable
            public final void run() {
                d.g(d.this);
            }
        });
    }

    @Override // com.qzone.reborn.comment.utils.cachedata.a
    public QZoneCommentCacheData query(String unikey) {
        Object obj;
        Intrinsics.checkNotNullParameter(unikey, "unikey");
        QLog.d("QZoneCommentMmkvCacheImp", 1, "[query] unikey:" + unikey);
        Iterator<T> it = this.mCacheDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            QZoneCommentCacheData qZoneCommentCacheData = (QZoneCommentCacheData) obj;
            if (Intrinsics.areEqual(unikey, qZoneCommentCacheData.getV4.b.UNIKEY java.lang.String()) && qZoneCommentCacheData.getTimestamp() > (System.currentTimeMillis() / ((long) 1000)) - ((long) QzoneConfig.DefaultValue.MOOD_RECENT_NEW_PHOTO_TIME)) {
                break;
            }
        }
        return (QZoneCommentCacheData) obj;
    }
}
