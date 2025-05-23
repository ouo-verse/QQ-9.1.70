package com.tencent.now.linkpkanchorplay.search.model;

import android.graphics.Paint;
import android.graphics.Rect;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.component.core.log.LogUtil;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0002\u0012\u0011B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\u0002R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0015R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/search/model/a;", "", "", h.F, "g", "", "d", "searchWord", "", "e", "Lcom/tencent/now/linkpkanchorplay/search/model/a$b;", "listener", "j", "i", "c", "", "Lcom/tencent/now/linkpkanchorplay/search/model/SearchHistoryData;", "b", "a", "f", "", UserInfo.SEX_FEMALE, "baseItemWidth", "", "Ljava/util/List;", "historyList", "Lcom/tencent/now/linkpkanchorplay/search/model/a$b;", "dataChangeListener", "<init>", "()V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private float baseItemWidth;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<SearchHistoryData> historyList = new ArrayList();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b dataChangeListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/search/model/a$b;", "", "", "Lcom/tencent/now/linkpkanchorplay/search/model/SearchHistoryData;", "dataList", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public interface b {
        void a(@NotNull List<SearchHistoryData> dataList);
    }

    public a() {
        this.baseItemWidth = 10.0f;
        this.baseItemWidth = (com.tencent.misc.utils.a.c(ul3.b.d()) - (com.tencent.misc.utils.a.a(12.0f) * 2)) / 100;
        g();
    }

    private final String d() {
        StringBuilder sb5 = new StringBuilder();
        String str = null;
        File externalFilesDir = ul3.b.d().getExternalFilesDir(null);
        if (externalFilesDir != null) {
            str = externalFilesDir.getAbsolutePath();
        }
        sb5.append(str);
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(ul3.b.b().getUid());
        String sb6 = sb5.toString();
        File file = new File(sb6);
        if (!file.isDirectory()) {
            file.mkdir();
        }
        return sb6 + str2 + "pk_search";
    }

    private final int e(String searchWord) {
        Paint paint = new Paint();
        Rect rect = new Rect();
        paint.setTextSize(com.tencent.misc.utils.a.a(12.0f));
        String c16 = c(String.valueOf(searchWord));
        paint.getTextBounds(c16, 0, c16.length(), rect);
        paint.setFakeBoldText(true);
        return (int) Math.ceil((com.tencent.misc.utils.a.a(32.0f) + rect.width()) / this.baseItemWidth);
    }

    private final void g() {
        List asList;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(d())));
            Object readObject = objectInputStream.readObject();
            Intrinsics.checkNotNull(readObject, "null cannot be cast to non-null type kotlin.Array<com.tencent.now.linkpkanchorplay.search.model.SearchHistoryData>");
            List<SearchHistoryData> list = this.historyList;
            asList = ArraysKt___ArraysJvmKt.asList((SearchHistoryData[]) readObject);
            list.addAll(asList);
            objectInputStream.close();
        } catch (Exception e16) {
            LogUtil.e("SearchHistoryDataModel", "readCacheFromDisk Exception e = " + e16.getMessage(), new Object[0]);
        }
    }

    private final void h() {
        File file = new File(d());
        if (file.isDirectory()) {
            file.delete();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            Object[] array = this.historyList.toArray(new SearchHistoryData[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            objectOutputStream.writeObject((SearchHistoryData[]) array);
            objectOutputStream.close();
        } catch (Exception e16) {
            LogUtil.e("SearchHistoryDataModel", "saveFileToDisk " + e16 + ".message", new Object[0]);
        }
    }

    public final void a() {
        this.historyList.clear();
        b bVar = this.dataChangeListener;
        if (bVar != null) {
            bVar.a(this.historyList);
        }
    }

    @NotNull
    public final List<SearchHistoryData> b() {
        return this.historyList;
    }

    @NotNull
    public final String c(@NotNull String searchWord) {
        Intrinsics.checkNotNullParameter(searchWord, "searchWord");
        if (searchWord.length() > 10) {
            StringBuilder sb5 = new StringBuilder();
            String substring = searchWord.substring(0, 10);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            sb5.append(substring);
            sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
            return sb5.toString();
        }
        return searchWord;
    }

    public final void f() {
        h();
    }

    public final void i(@NotNull String searchWord) {
        String replace$default;
        CharSequence trim;
        boolean z16;
        Intrinsics.checkNotNullParameter(searchWord, "searchWord");
        replace$default = StringsKt__StringsJVMKt.replace$default(searchWord, "\n", "", false, 4, (Object) null);
        trim = StringsKt__StringsKt.trim((CharSequence) replace$default);
        String obj = trim.toString();
        if (obj.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        Iterator<SearchHistoryData> it = this.historyList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().getSearchWord().equals(obj)) {
                it.remove();
                break;
            }
        }
        this.historyList.add(0, new SearchHistoryData(obj, System.currentTimeMillis(), e(obj)));
        if (this.historyList.size() > 10) {
            List<SearchHistoryData> list = this.historyList;
            list.remove(list.size() - 1);
        }
        b bVar = this.dataChangeListener;
        if (bVar != null) {
            bVar.a(this.historyList);
        }
    }

    public final void j(@Nullable b listener) {
        this.dataChangeListener = listener;
    }
}
