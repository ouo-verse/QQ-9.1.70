package com.qzone.reborn.albumx.qzonex.section.albumdetail;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.common.convert.bean.CommonClientAttr;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumMemberInitBean;
import com.qzone.reborn.albumx.qzonex.widget.OverlappingImgLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetPrivacyDetailServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0014J\b\u0010\u001b\u001a\u00020\u001aH\u0014J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\bH\u0014J*\u0010 \u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u000f2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0013H\u0014J\b\u0010!\u001a\u00020\u0004H\u0016R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/section/albumdetail/QZAlbumxAlbumDetailAvatarSection;", "Lcom/qzone/reborn/base/l;", "Lxa/a;", "data", "", "D", "", "emId", "Landroid/view/View;", "view", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "", "", "H", "", BdhLogUtil.LogTag.Tag_Conn, "", UserInfo.SEX_FEMALE, "", "Lcom/qzone/reborn/albumx/qzonex/widget/OverlappingImgLayout$b;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "J", "B", "G", "getLogTag", "", "getViewStubLayoutId", "containerView", "onInitView", "position", "payload", "K", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/qzone/reborn/albumx/qzonex/widget/OverlappingImgLayout;", "e", "Lcom/qzone/reborn/albumx/qzonex/widget/OverlappingImgLayout;", "avatarLayout", "f", "Landroid/view/View;", "headView", tl.h.F, "Z", "isReportPlusImp", "<init>", "()V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxAlbumDetailAvatarSection extends com.qzone.reborn.base.l<xa.a> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private OverlappingImgLayout avatarLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View headView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isReportPlusImp;

    private final List<OverlappingImgLayout.b> A(xa.a data) {
        Resources resources;
        ArrayList arrayList = new ArrayList();
        int B = B(data);
        int size = data.j().size();
        int i3 = 0;
        while (true) {
            boolean z16 = true;
            if (i3 >= size || i3 >= B) {
                break;
            }
            xa.d dVar = data.j().get(i3);
            String uin = dVar.getUin();
            if (uin != null && uin.length() != 0) {
                z16 = false;
            }
            if (!z16) {
                OverlappingImgLayout.b bVar = new OverlappingImgLayout.b();
                bVar.d(dVar.getUin());
                arrayList.add(bVar);
            }
            i3++;
        }
        if ((!arrayList.isEmpty()) && J(data)) {
            OverlappingImgLayout.b bVar2 = new OverlappingImgLayout.b();
            OverlappingImgLayout overlappingImgLayout = this.avatarLayout;
            Drawable drawable = null;
            if (overlappingImgLayout != null && (resources = overlappingImgLayout.getResources()) != null) {
                drawable = resources.getDrawable(R.drawable.f14131m, null);
            }
            bVar2.c(drawable);
            arrayList.add(bVar2);
            if (!this.isReportPlusImp) {
                z("em_qz_invite_plus", this.avatarLayout, data);
                this.isReportPlusImp = true;
            }
        }
        return arrayList;
    }

    private final int B(xa.a data) {
        return data.getPageId() == 4 ? 2 : 6;
    }

    private final int C(xa.a data) {
        String uinString = LoginData.getInstance().getUinString();
        if (Intrinsics.areEqual(data.getShareAlbumMeta().getOwner().getUin(), uinString)) {
            return 1;
        }
        Iterator<CommonClientAttr> it = data.getShareAlbumMeta().e().iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String().getUin(), uinString)) {
                return 2;
            }
        }
        return 3;
    }

    private final void D(final xa.a data) {
        OverlappingImgLayout.c cVar = new OverlappingImgLayout.c();
        cVar.k(A(data));
        cVar.o(ViewUtils.dip2px(8.0f));
        cVar.l(7);
        cVar.j(40.0f);
        cVar.i(40.0f);
        cVar.m(false);
        cVar.n(new Function1<OverlappingImgLayout.b, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.section.albumdetail.QZAlbumxAlbumDetailAvatarSection$initOverlappingImgLayout$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OverlappingImgLayout.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(OverlappingImgLayout.b bVar) {
                boolean F;
                OverlappingImgLayout overlappingImgLayout;
                if (bVar != null && TextUtils.isEmpty(bVar.getUin())) {
                    F = QZAlbumxAlbumDetailAvatarSection.this.F(data);
                    if (F) {
                        View rootView = QZAlbumxAlbumDetailAvatarSection.this.getRootView();
                        TextView textView = rootView != null ? (TextView) rootView.findViewById(R.id.krp) : null;
                        if (textView != null) {
                            textView.performClick();
                        }
                        QZAlbumxAlbumDetailAvatarSection qZAlbumxAlbumDetailAvatarSection = QZAlbumxAlbumDetailAvatarSection.this;
                        overlappingImgLayout = qZAlbumxAlbumDetailAvatarSection.avatarLayout;
                        qZAlbumxAlbumDetailAvatarSection.y("em_qz_invite_plus", overlappingImgLayout, data);
                        return;
                    }
                }
                QZAlbumxAlbumDetailAvatarSection.this.G(data);
            }
        });
        OverlappingImgLayout overlappingImgLayout = this.avatarLayout;
        if (overlappingImgLayout != null) {
            overlappingImgLayout.i(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean F(xa.a data) {
        return data.g().contains(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(xa.a data) {
        vb.b x16 = ho.i.x();
        Activity activity = p();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        QZAlbumxAlbumMemberInitBean qZAlbumxAlbumMemberInitBean = new QZAlbumxAlbumMemberInitBean(data.getUin());
        qZAlbumxAlbumMemberInitBean.setAlbumId(data.getAlbumId());
        qZAlbumxAlbumMemberInitBean.setCreatorUin(data.getCreatorUin());
        qZAlbumxAlbumMemberInitBean.setShareAlbumOwnerUin(data.getShareAlbumMeta().getOwner().getUin());
        qZAlbumxAlbumMemberInitBean.setPageType(data.getPageId());
        Unit unit = Unit.INSTANCE;
        x16.b(activity, qZAlbumxAlbumMemberInitBean);
    }

    private final Map<String, Object> H(xa.a data) {
        HashMap hashMap = new HashMap();
        mc.d dVar = mc.d.f416543a;
        hashMap.put("topic_type", Integer.valueOf(dVar.a(data.getPageId())));
        hashMap.put("albumid", data.getAlbumId());
        hashMap.put("album_name", data.getCom.tencent.aelight.camera.constants.AEEditorConstants.ALBUMNAME java.lang.String());
        hashMap.put("user_identity", Integer.valueOf(C(data)));
        hashMap.put(MiniAppGetPrivacyDetailServlet.KEY_AUTHORITY_NAME, Integer.valueOf(dVar.c(Integer.valueOf(data.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().getPermissionType()))));
        return hashMap;
    }

    private final boolean J(xa.a data) {
        return data.getPageId() != 4 || data.j().size() < 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxAlbumDetailAvatarSection";
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        OverlappingImgLayout overlappingImgLayout = this.avatarLayout;
        if (overlappingImgLayout != null) {
            overlappingImgLayout.m();
        }
        this.isReportPlusImp = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public void onBindData(xa.a data, int position, List<Object> payload) {
        if (data != null) {
            D(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(String emId, View view, xa.a data) {
        if (view == null) {
            return;
        }
        fo.c.e(emId, "pg_qz_photo_list_new", view, H(data));
    }

    private final void z(String emId, View view, xa.a data) {
        if (view == null) {
            return;
        }
        fo.c.g(emId, "pg_qz_photo_list_new", view, H(data));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        this.avatarLayout = containerView != null ? (OverlappingImgLayout) containerView.findViewById(R.id.mgt) : null;
        View findViewById = containerView != null ? containerView.findViewById(R.id.kap) : null;
        this.headView = findViewById;
        ViewGroup.LayoutParams layoutParams = findViewById != null ? findViewById.getLayoutParams() : null;
        if (layoutParams == null) {
            return;
        }
        layoutParams.width = com.qzone.reborn.groupalbum.selectmedia.util.g.f56961a.c();
    }
}
