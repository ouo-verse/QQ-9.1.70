package com.qzone.reborn.albumx.qzonex.utils;

import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.utils.DateUtil;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonClientAttr;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J+\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0010\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/utils/k;", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", "", "a", "", "year", "month", "day", "d", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/String;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "b", "c", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f53414a = new k();

    k() {
    }

    public final String a(CommonAlbumInfo albumInfo) {
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        if (albumInfo.getIsShareAlbum() && !TextUtils.equals(LoginData.getInstance().getUinString(), albumInfo.getCreator().getUin())) {
            for (CommonClientAttr commonClientAttr : albumInfo.getShareAlbum().e()) {
                if (TextUtils.equals(commonClientAttr.getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String().getUin(), LoginData.getInstance().getUinString())) {
                    return commonClientAttr.getAttr().getShareAlbumid();
                }
            }
            return albumInfo.getAlbumId();
        }
        return albumInfo.getAlbumId();
    }

    public final boolean b(RecyclerView recyclerView) {
        int findFirstVisibleItemPosition;
        View findViewByPosition;
        if (recyclerView == null) {
            return false;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        return (linearLayoutManager == null || (findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()) == -1 || (findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition)) == null || findViewByPosition.getTop() < 0) ? false : true;
    }

    public final boolean c(RecyclerView recyclerView) {
        int findLastVisibleItemPosition;
        View findViewByPosition;
        if (recyclerView == null) {
            return false;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        return (linearLayoutManager == null || (findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition()) == -1 || (findViewByPosition = linearLayoutManager.findViewByPosition(findLastVisibleItemPosition)) == null || findViewByPosition.getBottom() > recyclerView.getHeight()) ? false : true;
    }

    public final String d(Integer year, Integer month, Integer day) {
        if (year != null && month != null && day != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year.intValue(), month.intValue() - 1, day.intValue());
            String formattedDate = new SimpleDateFormat(DateUtil.DATE_FORMAT_8, Locale.getDefault()).format(calendar.getTime());
            Intrinsics.checkNotNullExpressionValue(formattedDate, "formattedDate");
            return formattedDate;
        }
        return "";
    }
}
