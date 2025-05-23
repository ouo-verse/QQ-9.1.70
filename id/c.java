package id;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u000b"}, d2 = {"Lid/c;", "", "Landroid/content/Context;", "context", "", "dataFactoryKey", "", "Lhd/b;", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f407503a = new c();

    c() {
    }

    public final List<hd.b> a(Context context, String dataFactoryKey) {
        List<hd.b> emptyList;
        if (context == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        if (dataFactoryKey != null) {
            switch (dataFactoryKey.hashCode()) {
                case -2127253274:
                    if (dataFactoryKey.equals("KEY_ENV_SWITCH")) {
                        return e.f407505a.b(context);
                    }
                    break;
                case -1038850837:
                    if (dataFactoryKey.equals("KEY_QZONE_ALBUMX")) {
                        return bv.f407501a.b(context);
                    }
                    break;
                case -674552678:
                    if (dataFactoryKey.equals("KEY_NT_UPLOAD")) {
                        return bl.f407492a.b(context);
                    }
                    break;
                case -663198343:
                    if (dataFactoryKey.equals("KEY_QZONE_QQVIDEO")) {
                        return a.f407464a.b(context);
                    }
                    break;
                case -232423825:
                    if (dataFactoryKey.equals("KEY_GROUP_ALBUM")) {
                        return q.f407516a.b(context);
                    }
                    break;
                case -96186744:
                    if (dataFactoryKey.equals("KEY_PAY")) {
                        return bn.f407494a.b(context);
                    }
                    break;
                case 437940898:
                    if (dataFactoryKey.equals("KEY_USER_INFO")) {
                        return bw.f407502a.b(context);
                    }
                    break;
                case 439141918:
                    if (dataFactoryKey.equals("KEY_LOCAL_PHOTO")) {
                        return ar.f407475a.b(context);
                    }
                    break;
                case 1136128836:
                    if (dataFactoryKey.equals("KEY_PERFORMANCE_DEBUG")) {
                        return bq.f407496a.b(context);
                    }
                    break;
                case 1183817478:
                    if (dataFactoryKey.equals("KEY_INTIMATE_SPACE")) {
                        return al.f407474a.b(context);
                    }
                    break;
                case 1215976689:
                    if (dataFactoryKey.equals("KEY_QZONE_DEBUG")) {
                        return bi.f407489a.b(context);
                    }
                    break;
                case 1655795519:
                    if (dataFactoryKey.equals("KEY_MOCK_DATA")) {
                        return bj.f407490a.b(context);
                    }
                    break;
                case 1686295350:
                    if (dataFactoryKey.equals("KEY_FRIEND_FEED_REFRESH_TEST")) {
                        return g.f407506a.b(context);
                    }
                    break;
            }
        }
        return new ArrayList();
    }
}
