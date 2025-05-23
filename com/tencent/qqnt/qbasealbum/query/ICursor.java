package com.tencent.qqnt.qbasealbum.query;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.utils.InitDataUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\b&\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001d\u0011B\u0019\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u00102\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b3\u00104J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\u0012\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016R2\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001bj\b\u0012\u0004\u0012\u00020\u0002`\u001c8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010)\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010/\u001a\u0004\u0018\u00010\u000b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u00100\u00a8\u00065"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/query/ICursor;", "", "", "path", "", "j", "(Ljava/lang/String;)Ljava/lang/Boolean;", "", "i", "Landroid/content/Context;", "context", "Landroid/database/Cursor;", "c", "", "d", "position", "l", "b", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "info", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "needSimpleData", "k", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/qbasealbum/query/ICursor$b;", "filter", "o", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "e", "()Ljava/util/ArrayList;", "p", "(Ljava/util/ArrayList;)V", "mColumns", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "setMSelector", "(Ljava/lang/String;)V", "mSelector", "Landroid/database/Cursor;", "f", "()Landroid/database/Cursor;", "setMCursor", "(Landroid/database/Cursor;)V", "mCursor", "Lcom/tencent/qqnt/qbasealbum/query/ICursor$b;", "mCustomizeFilter", "albumId", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class ICursor {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final String[] f361445f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final String[] f361446g;

    /* renamed from: h, reason: collision with root package name */
    private static final int f361447h;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    protected ArrayList<String> mColumns;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mSelector;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Cursor mCursor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b mCustomizeFilter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\bR \u0010\u0003\u001a\u00020\u00028\u0004X\u0085\u0004\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/query/ICursor$a;", "", "", "SUB_START_INDEX", "I", "a", "()I", "getSUB_START_INDEX$annotations", "()V", "INDEX_DATA_PATH", "INDEX_DATE_ADDED", "INDEX_DATE_MODIFIED", "INDEX_HEIGHT", "INDEX_ID", "INDEX_MIME_TYPE", "INDEX_SIZE", "INDEX_WIDTH", "", "ORDER_BY_DATE_MODIFIED", "Ljava/lang/String;", "TAG", "<init>", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.query.ICursor$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        protected final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return ICursor.f361447h;
            }
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/query/ICursor$b;", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "info", "", "a", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface b {
        boolean a(@NotNull LocalMediaInfo info);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44615);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
            return;
        }
        INSTANCE = new Companion(null);
        String[] strArr = {"_id", "_data", JobDbManager.COL_UP_MIME_TYPE, "date_added", "date_modified", "_size"};
        f361445f = strArr;
        String[] strArr2 = {"width", "height"};
        f361446g = strArr2;
        f361447h = strArr.length + strArr2.length;
    }

    public ICursor(@NotNull Context context, @Nullable String str) {
        Cursor cursor;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
            return;
        }
        this.mSelector = "";
        if (!TextUtils.isEmpty(str)) {
            com.tencent.qqnt.qbasealbum.model.a aVar = com.tencent.qqnt.qbasealbum.model.a.f361348a;
            if (!Intrinsics.areEqual(str, aVar.a()) && !Intrinsics.areEqual(str, aVar.b())) {
                this.mSelector = "bucket_id='" + str + "'";
            }
        }
        i();
        try {
            cursor = c(context);
        } catch (Exception e16) {
            ox3.a.f("QBaseAlbum.MediaQuery", new Function0<String>(e16) { // from class: com.tencent.qqnt.qbasealbum.query.ICursor.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Exception $e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$e = e16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) e16);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return "createCursor error:" + this.$e.getMessage();
                }
            });
            cursor = null;
        }
        this.mCursor = cursor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final int h() {
        return INSTANCE.a();
    }

    private final Boolean j(String path) {
        boolean z16;
        if (!InitDataUtil.f361625a.a()) {
            return null;
        }
        if (path != null && new File(path).length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        return Boolean.valueOf(z16);
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        Cursor cursor = this.mCursor;
        boolean z16 = false;
        if (cursor != null && !cursor.isClosed()) {
            z16 = true;
        }
        if (z16) {
            Cursor cursor2 = this.mCursor;
            Intrinsics.checkNotNull(cursor2);
            cursor2.close();
        }
    }

    @Nullable
    public abstract Cursor c(@NotNull Context context);

    public int d() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        Cursor cursor = this.mCursor;
        if (cursor != null && !cursor.isClosed()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return 0;
        }
        Cursor cursor2 = this.mCursor;
        Intrinsics.checkNotNull(cursor2);
        return cursor2.getCount();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ArrayList<String> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ArrayList<String> arrayList = this.mColumns;
        if (arrayList != null) {
            return arrayList;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mColumns");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final Cursor f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Cursor) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mCursor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mSelector;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        List listOf;
        List listOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        p(new ArrayList<>());
        ArrayList<String> e16 = e();
        String[] strArr = f361445f;
        listOf = CollectionsKt__CollectionsKt.listOf(Arrays.copyOf(strArr, strArr.length));
        e16.addAll(listOf);
        ArrayList<String> e17 = e();
        String[] strArr2 = f361446g;
        listOf2 = CollectionsKt__CollectionsKt.listOf(Arrays.copyOf(strArr2, strArr2.length));
        e17.addAll(listOf2);
    }

    @NotNull
    public LocalMediaInfo k(boolean needSimpleData) {
        LocalMediaInfo localMediaInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (LocalMediaInfo) iPatchRedirector.redirect((short) 13, (Object) this, needSimpleData);
        }
        int i3 = 0;
        if (needSimpleData) {
            localMediaInfo = new LocalMediaInfo(true);
        } else {
            localMediaInfo = new LocalMediaInfo(false, 1, null);
        }
        Cursor cursor = this.mCursor;
        if (cursor != null) {
            Intrinsics.checkNotNull(cursor);
            if (!cursor.isClosed()) {
                Cursor cursor2 = this.mCursor;
                Intrinsics.checkNotNull(cursor2);
                localMediaInfo.set_id(cursor2.getLong(0));
                Cursor cursor3 = this.mCursor;
                Intrinsics.checkNotNull(cursor3);
                localMediaInfo.setMMimeType(cursor3.getString(2));
                Cursor cursor4 = this.mCursor;
                Intrinsics.checkNotNull(cursor4);
                localMediaInfo.setAddedDate(cursor4.getLong(3));
                Cursor cursor5 = this.mCursor;
                Intrinsics.checkNotNull(cursor5);
                localMediaInfo.setModifiedDate(cursor5.getLong(4));
                Cursor cursor6 = this.mCursor;
                Intrinsics.checkNotNull(cursor6);
                localMediaInfo.setFileSize(cursor6.getLong(5));
                Cursor cursor7 = this.mCursor;
                Intrinsics.checkNotNull(cursor7);
                localMediaInfo.setMediaWidth(cursor7.getInt(6));
                Cursor cursor8 = this.mCursor;
                Intrinsics.checkNotNull(cursor8);
                localMediaInfo.setMediaHeight(cursor8.getInt(7));
                if (!needSimpleData) {
                    Cursor cursor9 = this.mCursor;
                    Intrinsics.checkNotNull(cursor9);
                    localMediaInfo.setPath(cursor9.getString(1));
                    if (InitDataUtil.f361625a.a()) {
                        localMediaInfo.set0BFile(j(localMediaInfo.getPath()));
                    }
                }
                if (localMediaInfo.getPath() == null) {
                    Cursor cursor10 = this.mCursor;
                    Intrinsics.checkNotNull(cursor10);
                    i3 = cursor10.getString(1).hashCode();
                } else {
                    String path = localMediaInfo.getPath();
                    if (path != null) {
                        i3 = path.hashCode();
                    }
                }
                localMediaInfo.setPathHash(i3);
            }
        }
        return localMediaInfo;
    }

    public boolean l(int position) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, position)).booleanValue();
        }
        Cursor cursor = this.mCursor;
        if (cursor != null && !cursor.isClosed()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        Cursor cursor2 = this.mCursor;
        Intrinsics.checkNotNull(cursor2);
        return cursor2.moveToPosition(position);
    }

    public boolean m(@Nullable LocalMediaInfo info) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) info)).booleanValue();
        }
        if (info == null || !n(info)) {
            return false;
        }
        b bVar = this.mCustomizeFilter;
        if (bVar != null && !bVar.a(info)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean n(@NotNull final LocalMediaInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) info)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(info, "info");
        if (info.getPathHash() != 0 && info.getFileSize() != 0 && !Intrinsics.areEqual(info.is0BFile(), Boolean.TRUE)) {
            return true;
        }
        ox3.a.c("QBaseAlbum.MediaQuery", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.query.ICursor$needMediaInfo$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LocalMediaInfo.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "file not exists: " + LocalMediaInfo.this.get_id();
            }
        });
        return false;
    }

    public void o(@Nullable b filter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) filter);
        } else {
            this.mCustomizeFilter = filter;
        }
    }

    protected final void p(@NotNull ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) arrayList);
        } else {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.mColumns = arrayList;
        }
    }
}
