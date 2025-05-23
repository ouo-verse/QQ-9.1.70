package jn2;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.troopplugin.PluginJumpManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateSearchSuggestView;
import com.tencent.mobileqq.search.business.net.view.p;
import com.tencent.mobileqq.search.model.ad;
import com.tencent.mobileqq.search.model.ah;
import com.tencent.mobileqq.search.model.i;
import com.tencent.mobileqq.search.model.t;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.presenter.ContactSearchResultGroupPresenter;
import com.tencent.mobileqq.search.presenter.SearchResultGroupTitlePresenter;
import com.tencent.mobileqq.search.presenter.SearchTemplatePresenter;
import com.tencent.mobileqq.search.presenter.j;
import com.tencent.mobileqq.search.presenter.k;
import com.tencent.mobileqq.search.presenter.l;
import com.tencent.mobileqq.search.presenter.m;
import com.tencent.mobileqq.search.presenter.n;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.rich.RichNodeController;
import com.tencent.mobileqq.search.rich.o;
import com.tencent.mobileqq.search.tux.SearchTuxPresenter;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.q;
import com.tencent.mobileqq.search.view.r;
import com.tencent.mobileqq.search.view.s;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import do2.GroupSearchModelNtTroopResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import lo2.ac;
import lo2.af;
import lo2.ai;
import lo2.al;
import lo2.am;
import lo2.u;
import lo2.w;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends mn2.a implements DecodeTaskCompletionListener, AbsListView.OnScrollListener {
    public String C;
    public String D;
    private boolean E;

    /* renamed from: e, reason: collision with root package name */
    private IFaceDecoder f410657e;

    /* renamed from: h, reason: collision with root package name */
    private ListView f410659h;

    /* renamed from: i, reason: collision with root package name */
    private AbsListView.OnScrollListener f410660i;

    /* renamed from: m, reason: collision with root package name */
    public int f410661m;

    /* renamed from: f, reason: collision with root package name */
    protected int f410658f = 0;
    private RichNodeController F = new RichNodeController();

    public c(ListView listView, IFaceDecoder iFaceDecoder, AbsListView.OnScrollListener onScrollListener, int i3) {
        this.f410661m = -1;
        this.f410659h = listView;
        this.f410657e = iFaceDecoder;
        iFaceDecoder.setDecodeTaskCompletionListener(this);
        listView.setOnScrollListener(this);
        this.f410660i = onScrollListener;
        this.f410661m = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean h(View view, v vVar, int i3, int i16, int i17, boolean z16) {
        com.tencent.mobileqq.search.rich.h hVar;
        boolean z17;
        if (i16 == 59) {
            List<y> list = null;
            if (view != null) {
                sn2.d dVar = (sn2.d) view.getTag(R.id.kxg);
                if (dVar instanceof com.tencent.mobileqq.search.rich.h) {
                    hVar = (com.tencent.mobileqq.search.rich.h) dVar;
                    if (hVar != null && (hVar instanceof o)) {
                        if (i3 != 0) {
                            ((o) hVar).p(false);
                        } else if (i3 == 1) {
                            v item = getItem(i3 - 1);
                            if (item instanceof i) {
                                i iVar = (i) item;
                                if (!iVar.I) {
                                    list = iVar.v().o();
                                }
                            }
                            if (vVar != null && list != null && list.contains(vVar)) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z17) {
                                ((o) hVar).p(false);
                            }
                        }
                    }
                }
            }
            hVar = null;
            if (hVar != null) {
                if (i3 != 0) {
                }
            }
        }
        if (i3 >= 1 && i17 == 59) {
            com.tencent.mobileqq.search.rich.f r16 = r(i3 - 1);
            if ((r16 instanceof com.tencent.mobileqq.search.rich.d) && ((com.tencent.mobileqq.search.rich.d) r16).m() == 1) {
                return true;
            }
        }
        return z16;
    }

    private void i(int i3, View view, v vVar) {
        com.tencent.mobileqq.search.rich.f fVar;
        if (view == null || vVar == null || !(vVar instanceof am)) {
            return;
        }
        sn2.d dVar = (sn2.d) view.getTag(R.id.kxg);
        if (dVar instanceof com.tencent.mobileqq.search.rich.h) {
            fVar = ((com.tencent.mobileqq.search.rich.h) dVar).i();
        } else {
            fVar = null;
        }
        if (fVar == null) {
            return;
        }
        this.F.j(i3, fVar);
    }

    private int l(v vVar, int i3) {
        int i16 = -1;
        if (vVar instanceof i) {
            while (i3 >= 0) {
                if (getItem(i3) instanceof i) {
                    i16++;
                }
                i3--;
            }
            return i16;
        }
        int f16 = vVar.f();
        while (i3 >= 0) {
            v item = getItem(i3);
            if (item != null) {
                if (item instanceof i) {
                    if (item.f() == f16) {
                        return i16;
                    }
                } else {
                    i16++;
                }
                i3--;
            } else {
                return i16;
            }
        }
        return 0;
    }

    private boolean m(List<v> list) {
        if (list == null) {
            return false;
        }
        List<v> list2 = this.f417041d;
        if (list2 == list) {
            return true;
        }
        if (!list2.isEmpty() && this.f417041d.size() == list.size()) {
            for (int i3 = 0; i3 < this.f417041d.size(); i3++) {
                if (this.f417041d.get(i3) != list.get(i3)) {
                    QLog.d("Q.uniteSearch.BaseMvpAdapter", 1, "isListIsTheSame false ", this.f417041d.get(i3), " ", list.get(i3));
                    return false;
                }
            }
            return true;
        }
        QLog.d("Q.uniteSearch.BaseMvpAdapter", 1, "isListIsTheSame false modelList.size:", Integer.valueOf(this.f417041d.size()), " dataList.size", Integer.valueOf(list.size()));
        return false;
    }

    private boolean n(View view, v vVar) {
        com.tencent.mobileqq.search.rich.f fVar;
        if (view == null || vVar == null) {
            return false;
        }
        if (vVar instanceof am) {
            sn2.d dVar = (sn2.d) view.getTag(R.id.kxg);
            if (dVar instanceof com.tencent.mobileqq.search.rich.h) {
                fVar = ((com.tencent.mobileqq.search.rich.h) dVar).i();
            } else {
                fVar = null;
            }
            if (fVar == null) {
                return false;
            }
            am amVar = (am) vVar;
            if (amVar.a0() != fVar.e() || amVar.b0() != fVar.getType()) {
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, "reuse contentview");
                return true;
            }
            return true;
        }
        return true;
    }

    private void o(View view) {
        if ((view.getTag(R.id.kxb) instanceof t) && (view.getTag(R.id.kxd) instanceof qn2.c) && (view.getTag(R.id.kxg) instanceof sn2.a)) {
            ((qn2.c) view.getTag(R.id.kxd)).c((t) view.getTag(R.id.kxb), (sn2.a) view.getTag(R.id.kxg));
        } else if ((view.getTag(R.id.kxb) instanceof v) && (view.getTag(R.id.kxd) instanceof ContactSearchResultGroupPresenter) && (view.getTag(R.id.kxg) instanceof sn2.b)) {
            ((ContactSearchResultGroupPresenter) view.getTag(R.id.kxd)).a((v) view.getTag(R.id.kxb), (sn2.b) view.getTag(R.id.kxg));
        }
    }

    private com.tencent.mobileqq.search.rich.f r(int i3) {
        Object item = getItem(i3);
        if (item == null || !(item instanceof com.tencent.mobileqq.search.rich.f)) {
            return null;
        }
        return (com.tencent.mobileqq.search.rich.f) item;
    }

    private void s(View view, int i3, String str, Bitmap bitmap) {
        if (QLog.isDebugVersion() && (view.getTag(R.id.kxb) instanceof t) && TextUtils.equals(((t) view.getTag(R.id.kxb)).getUin(), str)) {
            QLog.d("Q.uniteSearch.BaseMvpAdapter", 4, "tryUpdateFace uin:", str, " facePresenter:", (qn2.c) view.getTag(R.id.kxd), " faceView:", (sn2.a) view.getTag(R.id.kxg));
        }
        if ((view.getTag(R.id.kxb) instanceof t) && (view.getTag(R.id.kxd) instanceof qn2.c) && (view.getTag(R.id.kxg) instanceof sn2.a)) {
            t tVar = (t) view.getTag(R.id.kxb);
            qn2.c cVar = (qn2.c) view.getTag(R.id.kxd);
            sn2.a aVar = (sn2.a) view.getTag(R.id.kxg);
            if (str.equals(tVar.getUin()) && d(i3, tVar)) {
                cVar.f(tVar, aVar, bitmap);
            }
        }
    }

    @Override // mn2.a
    protected int a(int i3) {
        int i16 = 0;
        for (int i17 = i3 - 1; i17 >= 0; i17--) {
            v item = getItem(i17);
            if (!(item instanceof i)) {
                if (item instanceof x) {
                    x xVar = (x) item;
                    i16 += Math.min(xVar.o().size(), xVar.n());
                } else {
                    i16++;
                }
            }
        }
        return i16;
    }

    @Override // mn2.a
    protected int c(v vVar, int i3) {
        if (!(vVar instanceof ah) && !(vVar instanceof ai)) {
            return l(vVar, i3);
        }
        return j(vVar, i3);
    }

    @Override // mn2.a
    protected qn2.d e(int i3) {
        switch (getItemViewType(i3)) {
            case 0:
                return new SearchResultGroupTitlePresenter();
            case 1:
            case 4:
            case 5:
            case 6:
            case 7:
            case 17:
            case 18:
            case 19:
            case 20:
            case 28:
            case 32:
            case 33:
            case 34:
            case 35:
            case 37:
            case 43:
            case 58:
            default:
                return new n(this.f410657e);
            case 2:
            case 8:
                return new com.tencent.mobileqq.search.presenter.i(this.f410657e);
            case 3:
                return new l(this.f410657e, false);
            case 9:
                return new m();
            case 10:
                return new cooperation.qqfav.globalsearch.a();
            case 11:
                return new com.tencent.mobileqq.filemanager.data.search.d(this.f410657e);
            case 12:
                return new l(this.f410657e, true);
            case 13:
                return new ContactSearchResultGroupPresenter(this.f410657e);
            case 14:
                return new m();
            case 15:
                return new SearchResultGroupTitlePresenter();
            case 16:
                return new n(this.f410657e);
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 31:
            case 40:
            case 64:
                return new com.tencent.mobileqq.search.presenter.b(this.f410657e, k(i3), this);
            case 29:
            case 30:
            case 36:
                return new qn2.a();
            case 38:
            case 39:
            case 42:
            case 44:
            case 45:
            case 47:
            case 48:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 61:
            case 62:
            case 63:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
                return new SearchTemplatePresenter(this.f410657e, this);
            case 41:
                return new com.tencent.mobileqq.search.presenter.d(this.f410657e);
            case 46:
                return new j(this.f410657e);
            case 49:
                return new qn2.e();
            case 56:
                return new com.tencent.mobileqq.search.presenter.e(this.f410657e);
            case 57:
                return new eo2.a();
            case 59:
                return new k(this.f410657e, this);
            case 60:
                return new com.tencent.mobileqq.search.presenter.g(this.f410657e);
            case 75:
                return new SearchTuxPresenter();
        }
    }

    @Override // mn2.a
    protected sn2.d f(int i3, ViewGroup viewGroup) {
        boolean z16;
        switch (getItemViewType(i3)) {
            case 0:
            case 15:
                v item = getItem(i3);
                boolean z17 = false;
                if (item instanceof i) {
                    z16 = ((i) item).A();
                } else {
                    z16 = false;
                }
                if (i3 != 0) {
                    z17 = true;
                }
                return new fo2.d(viewGroup, z17, z16);
            case 1:
            case 13:
                return new yn2.a(viewGroup, R.layout.bxg);
            case 2:
                return new sn2.f(viewGroup, R.layout.f168430vz);
            case 3:
                return new s(viewGroup);
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 18:
            case 20:
            case 28:
            case 32:
            case 33:
            case 34:
            case 35:
            case 37:
            case 43:
            case 58:
            default:
                return new sn2.f(viewGroup, R.layout.bxc);
            case 9:
                return new fo2.c(viewGroup, R.layout.bxx, R.drawable.f87, -1);
            case 10:
                return new sn2.g(viewGroup, R.layout.a0v);
            case 12:
                return new r(viewGroup);
            case 14:
                return new fo2.c(viewGroup, R.layout.bxx, R.drawable.f87, 12);
            case 16:
                return new sn2.f(viewGroup, R.layout.bxd);
            case 17:
                return new sn2.f(viewGroup, R.layout.bxk);
            case 19:
                return new com.tencent.mobileqq.search.view.a(viewGroup, R.layout.byp);
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 31:
            case 40:
            case 64:
                return new q(viewGroup, k(i3));
            case 29:
            case 30:
            case 36:
                v item2 = getItem(i3);
                if (item2 instanceof pn2.c) {
                    return new sn2.e(viewGroup, ((pn2.c) item2).I());
                }
                throw new RuntimeException("model type is TYPE_UNITE_ENTRANCE_SUB_ITEM_COMMON_TEXT, but model item is not instance SearchResultModelForEntrance.");
            case 38:
            case 39:
            case 42:
            case 44:
            case 45:
            case 47:
            case 48:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 61:
            case 62:
            case 63:
            case 65:
            case 66:
            case 69:
            case 70:
            case 71:
            case 72:
            case 74:
                v item3 = getItem(i3);
                if (item3 instanceof lo2.m) {
                    lo2.m mVar = (lo2.m) item3;
                    switch (mVar.J()) {
                        case 2:
                            return new lo2.k(viewGroup, mVar.I());
                        case 3:
                            return new p(viewGroup, mVar.I());
                        case 4:
                            return new com.tencent.mobileqq.search.business.net.view.b(viewGroup, mVar.I());
                        case 5:
                        case 10:
                        case 22:
                        case 23:
                        case 28:
                        default:
                            throw new RuntimeException("NetSearchTemplateBaseItem.getLayoutId() is " + mVar.I() + " which is not supported!!!");
                        case 6:
                            return new com.tencent.mobileqq.search.business.net.view.o(viewGroup, mVar.I());
                        case 7:
                            return new com.tencent.mobileqq.search.view.h(viewGroup, mVar.I());
                        case 8:
                            return new com.tencent.mobileqq.search.view.o(viewGroup, mVar.I());
                        case 9:
                            return new com.tencent.mobileqq.search.view.n(viewGroup, mVar.I());
                        case 11:
                            return new com.tencent.mobileqq.search.business.net.view.h(viewGroup, mVar.I());
                        case 12:
                            return new com.tencent.mobileqq.search.business.net.view.d(viewGroup, mVar.I());
                        case 13:
                            return new com.tencent.mobileqq.search.view.g(viewGroup, mVar.I());
                        case 14:
                            return new com.tencent.mobileqq.search.business.net.view.n(viewGroup, mVar.I());
                        case 15:
                            return new com.tencent.mobileqq.search.view.m(viewGroup, mVar.I());
                        case 16:
                            return new com.tencent.mobileqq.search.view.k(viewGroup, mVar.I());
                        case 17:
                            return new com.tencent.mobileqq.search.view.l(viewGroup, mVar.I());
                        case 18:
                            return new com.tencent.mobileqq.search.business.net.view.l(viewGroup, mVar.I());
                        case 19:
                            return new com.tencent.mobileqq.search.view.i(viewGroup, mVar.I());
                        case 20:
                            return new go2.g(viewGroup, mVar.I());
                        case 21:
                            return new com.tencent.mobileqq.search.business.game.e(viewGroup, mVar.I());
                        case 24:
                            return new yo2.a(viewGroup, mVar.I());
                        case 25:
                            return new com.tencent.mobileqq.search.business.net.view.g(viewGroup, mVar.I());
                        case 26:
                            return new com.tencent.mobileqq.search.business.net.view.k(viewGroup, mVar.I());
                        case 27:
                            return new com.tencent.mobileqq.search.model.ai(viewGroup, mVar.I());
                        case 29:
                            return new NetSearchTemplateSearchSuggestView(viewGroup);
                    }
                }
                throw new RuntimeException("model type is TYPE_UNITE_TEMPLATE_NORMAL or TYPE_UNITE_TEMPLATE_NEWS, but model item is not instance NetSearchTemplateBaseItem.");
            case 41:
                return new bo2.a(viewGroup);
            case 46:
                return new sn2.g(viewGroup, R.layout.f168431w0);
            case 49:
                return new fo2.b(viewGroup);
            case 56:
                return new io2.a(viewGroup, R.layout.bxi);
            case 57:
                return new fo2.a(viewGroup);
            case 59:
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                v item4 = getItem(i3);
                com.tencent.mobileqq.search.rich.f a16 = com.tencent.mobileqq.search.rich.n.g().a(qQAppInterface, viewGroup.getContext(), item4);
                if (a16 != null && item4 != null && (item4 instanceof am)) {
                    ((am) item4).j0(a16.getType());
                }
                if (a16 == null) {
                    return new fo2.a(viewGroup);
                }
                return a16.b();
            case 60:
                return new jo2.a(viewGroup, R.layout.bxj);
            case 67:
                return new po2.a(viewGroup, this.C, this.D, getItem(i3));
            case 68:
                return new to2.a(viewGroup, this.C, this.D, getItem(i3));
            case 73:
                return new com.tencent.mobileqq.search.business.qcircle.video.game.union.a(viewGroup, this.D, i3);
            case 75:
                return new com.tencent.mobileqq.search.tux.k(viewGroup);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        if (super.getItem(i3) instanceof do2.g) {
            return 41;
        }
        if (super.getItem(i3) instanceof do2.i) {
            return 3;
        }
        if ((super.getItem(i3) instanceof com.tencent.mobileqq.search.ftsmsg.a) || (super.getItem(i3) instanceof vn2.a)) {
            return 12;
        }
        if ((super.getItem(i3) instanceof i) && this.f410661m != 12) {
            i iVar = (i) super.getItem(i3);
            if (iVar == null || !iVar.I) {
                return 57;
            }
            return 0;
        }
        if ((super.getItem(i3) instanceof i) && this.f410661m == 12) {
            i iVar2 = (i) super.getItem(i3);
            if (iVar2 == null || !iVar2.I) {
                return 57;
            }
            return 15;
        }
        if (super.getItem(i3) instanceof do2.f) {
            do2.f fVar = (do2.f) super.getItem(i3);
            if (fVar == null || !fVar.E) {
                return 57;
            }
            return 49;
        }
        if (super.getItem(i3) instanceof do2.p) {
            return 2;
        }
        if (super.getItem(i3) instanceof com.tencent.mobileqq.search.model.d) {
            return 5;
        }
        if (super.getItem(i3) instanceof do2.j) {
            return 56;
        }
        if (super.getItem(i3) instanceof com.tencent.mobileqq.search.model.g) {
            return 6;
        }
        if (super.getItem(i3) instanceof do2.l) {
            return 60;
        }
        if (super.getItem(i3) instanceof com.tencent.mobileqq.search.model.e) {
            return 8;
        }
        if (super.getItem(i3) instanceof do2.b) {
            return 16;
        }
        if ((super.getItem(i3) instanceof do2.k) && this.f410661m != 12) {
            return 9;
        }
        if ((super.getItem(i3) instanceof do2.k) && this.f410661m == 12) {
            return 14;
        }
        if (getItem(i3) instanceof do2.d) {
            return 10;
        }
        if (getItem(i3) instanceof do2.e) {
            return 11;
        }
        if (!(super.getItem(i3) instanceof do2.h) && !(super.getItem(i3) instanceof com.tencent.mobileqq.search.model.j) && !(super.getItem(i3) instanceof do2.n) && !(super.getItem(i3) instanceof GroupSearchModelNtTroopResult)) {
            if (getItem(i3) instanceof do2.m) {
                return 17;
            }
            if (getItem(i3) instanceof am) {
                return 59;
            }
            if (getItem(i3) instanceof lo2.c) {
                lo2.c cVar = (lo2.c) getItem(i3);
                if (cVar == null) {
                    return 25;
                }
                int J = cVar.J();
                if (J != 1001) {
                    if (J != 1002) {
                        if (J != 1107) {
                            if (J != 268435456) {
                                return 25;
                            }
                            return 26;
                        }
                        return 64;
                    }
                    return 22;
                }
                return 21;
            }
            if (getItem(i3) instanceof pn2.c) {
                pn2.c cVar2 = (pn2.c) getItem(i3);
                if (cVar2 == null) {
                    return 29;
                }
                int i16 = cVar2.I;
                if (i16 != -4) {
                    if (i16 != -3) {
                        return 29;
                    }
                    return 30;
                }
                return 36;
            }
            if (getItem(i3) instanceof com.tencent.mobileqq.search.tux.g) {
                return 75;
            }
            if (getItem(i3) instanceof lo2.m) {
                lo2.m mVar = (lo2.m) getItem(i3);
                if (mVar == null) {
                    return 45;
                }
                switch (mVar.J()) {
                    case 2:
                        return 38;
                    case 3:
                        return 39;
                    case 4:
                        return 42;
                    case 5:
                    case 6:
                    case 10:
                    case 22:
                    default:
                        return 45;
                    case 7:
                        return 44;
                    case 8:
                        return 47;
                    case 9:
                        return 48;
                    case 11:
                        return 50;
                    case 12:
                        return 51;
                    case 13:
                        return 52;
                    case 14:
                        return 53;
                    case 15:
                        return 54;
                    case 16:
                        return 55;
                    case 17:
                        return 61;
                    case 18:
                        return 62;
                    case 19:
                        return 63;
                    case 20:
                        return 65;
                    case 21:
                        return 66;
                    case 23:
                        if (mVar instanceof ac) {
                            ac.a d06 = ((ac) mVar).d0();
                            if (d06 instanceof ac.b) {
                                return 67;
                            }
                            if (d06 instanceof ac.c) {
                                return 68;
                            }
                        }
                        return 45;
                    case 24:
                        return 69;
                    case 25:
                        return 70;
                    case 26:
                        return 71;
                    case 27:
                        return 72;
                    case 28:
                        return 73;
                    case 29:
                        return 74;
                }
            }
            if (getItem(i3) instanceof up2.b) {
                return 46;
            }
            return 4;
        }
        return 13;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x07c2  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0882  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x088f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0894  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x08b4  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x08be  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0891  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0884  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x06ff  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x07b6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x021e  */
    @Override // mn2.a, android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i3, View view, ViewGroup viewGroup) {
        String str;
        String str2;
        String str3;
        Object obj;
        String str4;
        String str5;
        String str6;
        c cVar;
        c cVar2;
        String str7;
        v vVar;
        String str8;
        View view2;
        String str9;
        Iterator<u> it;
        String str10;
        String str11;
        String str12;
        String str13;
        Object obj2;
        String str14;
        View view3;
        View view4;
        boolean z16;
        int i16;
        int i17;
        int i18;
        lo2.b bVar;
        String str15;
        Object obj3;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        Object obj4;
        String str22;
        x xVar;
        List<y> o16;
        int min;
        int i19;
        String str23;
        String str24;
        String str25;
        Object obj5;
        String str26;
        int i26;
        String str27;
        String str28;
        Object obj6;
        String str29;
        v item = getItem(i3);
        String str30 = "obj_lct";
        String str31 = "e = ";
        String str32 = "Q.uniteSearch.BaseMvpAdapter";
        if (SearchUtil.q(item) <= 0) {
            str = "1";
            str2 = "obj_lct";
            str3 = "get_src";
            obj = "client";
            str4 = "e = ";
            str5 = "Q.uniteSearch.BaseMvpAdapter";
            str6 = "exp_item";
            cVar = this;
        } else {
            HashMap<v, SearchUtils.d> hashMap = SearchUtils.f284965n;
            if (hashMap.containsKey(item)) {
                SearchUtils.d dVar = hashMap.get(item);
                if (!dVar.f284979d) {
                    dVar.f284979d = true;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("project", com.tencent.mobileqq.search.report.b.c());
                        jSONObject.put("event_src", "client");
                        jSONObject.put("get_src", "native");
                        jSONObject.put("obj_lct", dVar.f284978c);
                        str = "1";
                    } catch (JSONException e16) {
                        str = "1";
                        QLog.e("Q.uniteSearch.BaseMvpAdapter", 2, "e = " + e16);
                    }
                    QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                    ReportModelDC02528 action = new ReportModelDC02528().module("all_result").action("exp_item");
                    str22 = "exp_item";
                    StringBuilder sb5 = new StringBuilder();
                    str21 = "get_src";
                    obj4 = "client";
                    sb5.append(dVar.f284977b);
                    sb5.append("");
                    com.tencent.mobileqq.search.report.b.h(qQAppInterface, action.obj1(sb5.toString()).obj2(dVar.f284980e).ver1(dVar.f284976a).ver2(com.tencent.mobileqq.search.report.b.a(this.f410661m)).ver7(jSONObject.toString()).session_id(qQAppInterface.getCurrentAccountUin() + SearchUtils.f284963l));
                    dVar.f284979d = true;
                    SearchUtils.f284965n.put(item, dVar);
                    if ((item instanceof x) && (o16 = (xVar = (x) item).o()) != null && o16.size() > 0) {
                        min = Math.min(o16.size(), xVar.n());
                        i19 = 0;
                        while (i19 < min) {
                            HashMap<v, SearchUtils.d> hashMap2 = SearchUtils.f284965n;
                            if (hashMap2.containsKey(o16.get(i19))) {
                                SearchUtils.d dVar2 = hashMap2.get(o16.get(i19));
                                if (!dVar2.f284979d) {
                                    dVar2.f284979d = true;
                                    JSONObject jSONObject2 = new JSONObject();
                                    try {
                                        jSONObject2.put("project", com.tencent.mobileqq.search.report.b.c());
                                        obj6 = obj4;
                                        try {
                                            jSONObject2.put("event_src", obj6);
                                            str28 = str21;
                                        } catch (JSONException e17) {
                                            e = e17;
                                            str28 = str21;
                                        }
                                        try {
                                            jSONObject2.put(str28, "native");
                                            jSONObject2.put(str30, dVar2.f284978c);
                                            i26 = min;
                                        } catch (JSONException e18) {
                                            e = e18;
                                            i26 = min;
                                            QLog.e(str32, 2, str31 + e);
                                            if (!(o16.get(i19) instanceof up2.a)) {
                                            }
                                            i19++;
                                            str30 = str26;
                                            min = i26;
                                            str32 = str27;
                                            obj4 = obj5;
                                            str21 = str25;
                                            str22 = str24;
                                            str31 = str23;
                                        }
                                    } catch (JSONException e19) {
                                        e = e19;
                                        str28 = str21;
                                        obj6 = obj4;
                                    }
                                    if (!(o16.get(i19) instanceof up2.a)) {
                                        up2.a aVar = (up2.a) o16.get(i19);
                                        if (aVar.R()) {
                                            str29 = str;
                                        } else {
                                            str29 = "0";
                                        }
                                        dVar2.f284980e = aVar.G();
                                        QQAppInterface qQAppInterface2 = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                                        str27 = str32;
                                        str23 = str31;
                                        str24 = str22;
                                        ReportModelDC02528 action2 = new ReportModelDC02528().module("all_result").action(str24);
                                        str26 = str30;
                                        StringBuilder sb6 = new StringBuilder();
                                        obj5 = obj6;
                                        str25 = str28;
                                        sb6.append(dVar2.f284977b);
                                        sb6.append("");
                                        com.tencent.mobileqq.search.report.b.h(qQAppInterface2, action2.obj1(sb6.toString()).obj2(dVar2.f284980e).ver1(dVar2.f284976a).ver2(com.tencent.mobileqq.search.report.b.a(this.f410661m)).ver3(str29).ver7(jSONObject2.toString()).session_id(qQAppInterface2.getCurrentAccountUin() + SearchUtils.f284963l));
                                        dVar2.f284979d = true;
                                        SearchUtils.f284965n.put(o16.get(i19), dVar2);
                                    } else {
                                        str23 = str31;
                                        str27 = str32;
                                        obj5 = obj6;
                                        str25 = str28;
                                        str24 = str22;
                                        str26 = str30;
                                        QQAppInterface qQAppInterface3 = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                                        com.tencent.mobileqq.search.report.b.h(qQAppInterface3, new ReportModelDC02528().module("all_result").action(str24).obj1(dVar2.f284977b + "").obj2(dVar2.f284980e).ver1(dVar2.f284976a).ver2(com.tencent.mobileqq.search.report.b.a(this.f410661m)).ver7(jSONObject2.toString()).session_id(qQAppInterface3.getCurrentAccountUin() + SearchUtils.f284963l));
                                        dVar2.f284979d = true;
                                        SearchUtils.f284965n.put(o16.get(i19), dVar2);
                                    }
                                    i19++;
                                    str30 = str26;
                                    min = i26;
                                    str32 = str27;
                                    obj4 = obj5;
                                    str21 = str25;
                                    str22 = str24;
                                    str31 = str23;
                                }
                            }
                            str23 = str31;
                            str24 = str22;
                            str25 = str21;
                            obj5 = obj4;
                            str26 = str30;
                            i26 = min;
                            str27 = str32;
                            i19++;
                            str30 = str26;
                            min = i26;
                            str32 = str27;
                            obj4 = obj5;
                            str21 = str25;
                            str22 = str24;
                            str31 = str23;
                        }
                    }
                    str4 = str31;
                    str6 = str22;
                    str3 = str21;
                    obj = obj4;
                    str2 = str30;
                    str5 = str32;
                    cVar = this;
                }
            }
            str = "1";
            str21 = "get_src";
            obj4 = "client";
            str22 = "exp_item";
            if (item instanceof x) {
                min = Math.min(o16.size(), xVar.n());
                i19 = 0;
                while (i19 < min) {
                }
            }
            str4 = str31;
            str6 = str22;
            str3 = str21;
            obj = obj4;
            str2 = str30;
            str5 = str32;
            cVar = this;
        }
        String str33 = "web";
        if (item instanceof lo2.b) {
            lo2.b bVar2 = (lo2.b) item;
            if (bVar2.o() != null && bVar2.o().size() > 0) {
                int i27 = 0;
                while (i27 < bVar2.o().size()) {
                    y yVar = bVar2.o().get(i27);
                    HashMap<v, SearchUtils.d> hashMap3 = SearchUtils.f284965n;
                    if (hashMap3.containsKey(yVar)) {
                        SearchUtils.d dVar3 = hashMap3.get(yVar);
                        if (!dVar3.f284979d) {
                            dVar3.f284979d = true;
                            JSONObject jSONObject3 = new JSONObject();
                            try {
                                jSONObject3.put("project", com.tencent.mobileqq.search.report.b.c());
                                obj3 = obj;
                                try {
                                    jSONObject3.put("event_src", obj3);
                                    str20 = str3;
                                    try {
                                        jSONObject3.put(str20, str33);
                                        str19 = str2;
                                    } catch (JSONException e26) {
                                        e = e26;
                                        str19 = str2;
                                    }
                                } catch (JSONException e27) {
                                    e = e27;
                                    str19 = str2;
                                    str20 = str3;
                                    bVar = bVar2;
                                    StringBuilder sb7 = new StringBuilder();
                                    str2 = str19;
                                    sb7.append(str4);
                                    sb7.append(e);
                                    String sb8 = sb7.toString();
                                    str15 = str5;
                                    QLog.e(str15, 2, sb8);
                                    QQAppInterface qQAppInterface4 = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                                    ReportModelDC02528 action3 = new ReportModelDC02528().module("all_result").action(str6);
                                    str18 = str6;
                                    StringBuilder sb9 = new StringBuilder();
                                    str16 = str20;
                                    str17 = str33;
                                    sb9.append(dVar3.f284977b);
                                    sb9.append("");
                                    com.tencent.mobileqq.search.report.b.h(qQAppInterface4, action3.obj1(sb9.toString()).obj2(dVar3.f284980e).ver1(dVar3.f284976a).ver2(com.tencent.mobileqq.search.report.b.a(cVar.f410661m)).ver7(jSONObject3.toString()).session_id(qQAppInterface4.getCurrentAccountUin() + SearchUtils.f284963l));
                                    i27++;
                                    cVar = this;
                                    obj = obj3;
                                    str6 = str18;
                                    str33 = str17;
                                    str3 = str16;
                                    str5 = str15;
                                    bVar2 = bVar;
                                }
                                try {
                                    jSONObject3.put(str19, dVar3.f284978c);
                                    str2 = str19;
                                    bVar = bVar2;
                                    str15 = str5;
                                } catch (JSONException e28) {
                                    e = e28;
                                    bVar = bVar2;
                                    StringBuilder sb72 = new StringBuilder();
                                    str2 = str19;
                                    sb72.append(str4);
                                    sb72.append(e);
                                    String sb82 = sb72.toString();
                                    str15 = str5;
                                    QLog.e(str15, 2, sb82);
                                    QQAppInterface qQAppInterface42 = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                                    ReportModelDC02528 action32 = new ReportModelDC02528().module("all_result").action(str6);
                                    str18 = str6;
                                    StringBuilder sb92 = new StringBuilder();
                                    str16 = str20;
                                    str17 = str33;
                                    sb92.append(dVar3.f284977b);
                                    sb92.append("");
                                    com.tencent.mobileqq.search.report.b.h(qQAppInterface42, action32.obj1(sb92.toString()).obj2(dVar3.f284980e).ver1(dVar3.f284976a).ver2(com.tencent.mobileqq.search.report.b.a(cVar.f410661m)).ver7(jSONObject3.toString()).session_id(qQAppInterface42.getCurrentAccountUin() + SearchUtils.f284963l));
                                    i27++;
                                    cVar = this;
                                    obj = obj3;
                                    str6 = str18;
                                    str33 = str17;
                                    str3 = str16;
                                    str5 = str15;
                                    bVar2 = bVar;
                                }
                            } catch (JSONException e29) {
                                e = e29;
                                str19 = str2;
                                obj3 = obj;
                            }
                            QQAppInterface qQAppInterface422 = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                            ReportModelDC02528 action322 = new ReportModelDC02528().module("all_result").action(str6);
                            str18 = str6;
                            StringBuilder sb922 = new StringBuilder();
                            str16 = str20;
                            str17 = str33;
                            sb922.append(dVar3.f284977b);
                            sb922.append("");
                            com.tencent.mobileqq.search.report.b.h(qQAppInterface422, action322.obj1(sb922.toString()).obj2(dVar3.f284980e).ver1(dVar3.f284976a).ver2(com.tencent.mobileqq.search.report.b.a(cVar.f410661m)).ver7(jSONObject3.toString()).session_id(qQAppInterface422.getCurrentAccountUin() + SearchUtils.f284963l));
                            i27++;
                            cVar = this;
                            obj = obj3;
                            str6 = str18;
                            str33 = str17;
                            str3 = str16;
                            str5 = str15;
                            bVar2 = bVar;
                        }
                    }
                    bVar = bVar2;
                    str15 = str5;
                    obj3 = obj;
                    str16 = str3;
                    str17 = str33;
                    str18 = str6;
                    i27++;
                    cVar = this;
                    obj = obj3;
                    str6 = str18;
                    str33 = str17;
                    str3 = str16;
                    str5 = str15;
                    bVar2 = bVar;
                }
            }
            view2 = null;
            cVar2 = this;
            str9 = "";
        } else {
            String str34 = str5;
            Object obj7 = obj;
            String str35 = str3;
            Object obj8 = "web";
            String str36 = str6;
            if (item instanceof ad) {
                ArrayList<u> arrayList = ((ad) item).f283479c0;
                if (arrayList != null) {
                    Iterator<u> it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        u next = it5.next();
                        HashMap<v, SearchUtils.d> hashMap4 = SearchUtils.f284965n;
                        if (hashMap4.containsKey(next)) {
                            SearchUtils.d dVar4 = hashMap4.get(next);
                            if (!dVar4.f284979d) {
                                dVar4.f284979d = true;
                                JSONObject jSONObject4 = new JSONObject();
                                try {
                                    jSONObject4.put("project", com.tencent.mobileqq.search.report.b.c());
                                    jSONObject4.put("event_src", obj7);
                                    obj2 = obj8;
                                    str14 = str35;
                                    try {
                                        jSONObject4.put(str14, obj2);
                                        str13 = str2;
                                    } catch (JSONException e36) {
                                        e = e36;
                                        str13 = str2;
                                    }
                                    try {
                                        jSONObject4.put(str13, dVar4.f284978c);
                                        jSONObject4.put("extra_info", next.f415280d0);
                                        jSONObject4.put("tepl", next.M);
                                        it = it5;
                                        str10 = str4;
                                    } catch (JSONException e37) {
                                        e = e37;
                                        StringBuilder sb10 = new StringBuilder();
                                        it = it5;
                                        str10 = str4;
                                        sb10.append(str10);
                                        sb10.append(e);
                                        QLog.e(str34, 2, sb10.toString());
                                        QQAppInterface qQAppInterface5 = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                                        str11 = str34;
                                        ReportModelDC02528 action4 = new ReportModelDC02528().module("all_result").action(str36);
                                        StringBuilder sb11 = new StringBuilder();
                                        obj8 = obj2;
                                        str35 = str14;
                                        sb11.append(next.J);
                                        sb11.append("");
                                        ReportModelDC02528 ver7 = action4.obj1(sb11.toString()).obj2(next.f415281e0).ver1(dVar4.f284976a).ver2(com.tencent.mobileqq.search.report.b.a(this.f410661m)).ver7(jSONObject4.toString());
                                        StringBuilder sb12 = new StringBuilder();
                                        sb12.append(qQAppInterface5.getCurrentAccountUin());
                                        str12 = str13;
                                        sb12.append(SearchUtils.f284963l);
                                        com.tencent.mobileqq.search.report.b.h(qQAppInterface5, ver7.session_id(sb12.toString()));
                                        str4 = str10;
                                        it5 = it;
                                        String str37 = str11;
                                        str2 = str12;
                                        str34 = str37;
                                    }
                                } catch (JSONException e38) {
                                    e = e38;
                                    str13 = str2;
                                    obj2 = obj8;
                                    str14 = str35;
                                }
                                QQAppInterface qQAppInterface52 = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                                str11 = str34;
                                ReportModelDC02528 action42 = new ReportModelDC02528().module("all_result").action(str36);
                                StringBuilder sb112 = new StringBuilder();
                                obj8 = obj2;
                                str35 = str14;
                                sb112.append(next.J);
                                sb112.append("");
                                ReportModelDC02528 ver72 = action42.obj1(sb112.toString()).obj2(next.f415281e0).ver1(dVar4.f284976a).ver2(com.tencent.mobileqq.search.report.b.a(this.f410661m)).ver7(jSONObject4.toString());
                                StringBuilder sb122 = new StringBuilder();
                                sb122.append(qQAppInterface52.getCurrentAccountUin());
                                str12 = str13;
                                sb122.append(SearchUtils.f284963l);
                                com.tencent.mobileqq.search.report.b.h(qQAppInterface52, ver72.session_id(sb122.toString()));
                                str4 = str10;
                                it5 = it;
                                String str372 = str11;
                                str2 = str12;
                                str34 = str372;
                            }
                        }
                        it = it5;
                        str10 = str4;
                        String str38 = str2;
                        str11 = str34;
                        str12 = str38;
                        str4 = str10;
                        it5 = it;
                        String str3722 = str11;
                        str2 = str12;
                        str34 = str3722;
                    }
                }
                cVar2 = this;
            } else {
                cVar2 = this;
                String str39 = str4;
                String str40 = str2;
                if (item instanceof w) {
                    HashMap<v, SearchUtils.d> hashMap5 = SearchUtils.f284965n;
                    if (hashMap5.containsKey(item)) {
                        SearchUtils.d dVar5 = hashMap5.get(item);
                        w wVar = (w) item;
                        if (!dVar5.f284979d) {
                            dVar5.f284979d = true;
                            StringBuilder sb13 = new StringBuilder();
                            List<lo2.i> list = wVar.f415300g0;
                            if (list != null && list.size() > 0) {
                                for (int i28 = 0; i28 < wVar.f415300g0.size(); i28++) {
                                    if (i28 != wVar.f415300g0.size() - 1) {
                                        sb13.append(wVar.f415300g0.get(i28).f415215b);
                                        sb13.append("::");
                                    } else {
                                        sb13.append(wVar.f415300g0.get(i28).f415215b);
                                    }
                                }
                            }
                            com.tencent.mobileqq.search.report.b.h(null, new ReportModelDC02528().module("all_result").action("exp_web_search").obj1("2073745984").ver1(dVar5.f284976a).ver2(com.tencent.mobileqq.search.report.b.a(cVar2.f410661m)).ver4(sb13.toString()).ver5(str).ver7("{experiment_id:" + com.tencent.mobileqq.search.report.b.f283718b + "}"));
                        }
                    }
                } else {
                    String str41 = str;
                    if (((item instanceof lo2.m) && !(item instanceof af)) || (item instanceof lo2.c) || ((item instanceof pn2.c) && ((pn2.c) item).I == -4)) {
                        HashMap<v, SearchUtils.d> hashMap6 = SearchUtils.f284965n;
                        if (hashMap6.containsKey(item)) {
                            SearchUtils.d dVar6 = hashMap6.get(item);
                            if (item instanceof lo2.x) {
                                lo2.x xVar2 = (lo2.x) item;
                                str8 = "";
                                if (!dVar6.f284979d) {
                                    dVar6.f284979d = true;
                                    StringBuilder sb14 = new StringBuilder();
                                    str7 = str39;
                                    List<al> list2 = xVar2.f415307g0;
                                    if (list2 != null && list2.size() > 0) {
                                        vVar = item;
                                        for (int i29 = 0; i29 < xVar2.f415307g0.size(); i29++) {
                                            sb14.append(xVar2.f415307g0.get(i29).f415168a);
                                            sb14.append("::");
                                        }
                                        com.tencent.mobileqq.search.report.b.h(null, new ReportModelDC02528().module("all_result").action("exp_relatedsearch_list").obj1(PluginJumpManager.CONFIG_BID).ver1(dVar6.f284976a).ver2(com.tencent.mobileqq.search.report.b.a(cVar2.f410661m)).ver4(sb14.toString()).ver5(str41).ver7("{experiment_id:" + com.tencent.mobileqq.search.report.b.f283718b + "}"));
                                    } else {
                                        vVar = item;
                                    }
                                    view2 = null;
                                    com.tencent.mobileqq.search.report.b.h(null, new ReportModelDC02528().module("all_result").action("exp_web_search").obj1("2073745984").ver1(dVar6.f284976a).ver2(com.tencent.mobileqq.search.report.b.a(cVar2.f410661m)).ver5("2").ver7("{experiment_id:" + com.tencent.mobileqq.search.report.b.f283718b + "}"));
                                    if (dVar6.f284979d) {
                                        dVar6.f284979d = true;
                                        JSONObject jSONObject5 = new JSONObject();
                                        try {
                                            jSONObject5.put("project", com.tencent.mobileqq.search.report.b.c());
                                            jSONObject5.put("event_src", obj7);
                                            jSONObject5.put(str35, obj8);
                                            jSONObject5.put(str40, dVar6.f284978c);
                                            item = vVar;
                                            try {
                                                if (item instanceof lo2.m) {
                                                    jSONObject5.put("tepl", ((lo2.m) item).M);
                                                }
                                            } catch (JSONException e39) {
                                                e = e39;
                                                QLog.e(str34, 2, str7 + e);
                                                QQAppInterface qQAppInterface6 = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                                                ReportModelDC02528 action5 = new ReportModelDC02528().module("all_result").action(str36);
                                                StringBuilder sb15 = new StringBuilder();
                                                sb15.append(dVar6.f284977b);
                                                str9 = str8;
                                                sb15.append(str9);
                                                com.tencent.mobileqq.search.report.b.h(qQAppInterface6, action5.obj1(sb15.toString()).obj2(dVar6.f284980e).ver1(dVar6.f284976a).ver2(com.tencent.mobileqq.search.report.b.a(cVar2.f410661m)).ver7(jSONObject5.toString()).session_id(qQAppInterface6.getCurrentAccountUin() + SearchUtils.f284963l));
                                                if (SearchUtils.f284964m.containsKey(item)) {
                                                }
                                                if (cVar2.n(view, item)) {
                                                }
                                                view4 = super.getView(i3, view3, viewGroup);
                                                cVar2.i(i3, view4, item);
                                                if (i3 != 0) {
                                                }
                                                if (i3 >= 1) {
                                                }
                                                if (view4 != null) {
                                                    if (!z16) {
                                                    }
                                                }
                                                EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
                                                return view4;
                                            }
                                        } catch (JSONException e46) {
                                            e = e46;
                                            item = vVar;
                                        }
                                        QQAppInterface qQAppInterface62 = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                                        ReportModelDC02528 action52 = new ReportModelDC02528().module("all_result").action(str36);
                                        StringBuilder sb152 = new StringBuilder();
                                        sb152.append(dVar6.f284977b);
                                        str9 = str8;
                                        sb152.append(str9);
                                        com.tencent.mobileqq.search.report.b.h(qQAppInterface62, action52.obj1(sb152.toString()).obj2(dVar6.f284980e).ver1(dVar6.f284976a).ver2(com.tencent.mobileqq.search.report.b.a(cVar2.f410661m)).ver7(jSONObject5.toString()).session_id(qQAppInterface62.getCurrentAccountUin() + SearchUtils.f284963l));
                                    } else {
                                        str9 = str8;
                                        item = vVar;
                                    }
                                } else {
                                    str7 = str39;
                                    vVar = item;
                                }
                            } else {
                                str7 = str39;
                                vVar = item;
                                str8 = "";
                            }
                            view2 = null;
                            if (dVar6.f284979d) {
                            }
                        }
                    }
                }
            }
            str9 = "";
            view2 = null;
        }
        if (SearchUtils.f284964m.containsKey(item)) {
            SearchUtils.d dVar7 = SearchUtils.f284964m.get(item);
            if (!dVar7.f284979d) {
                if (SearchUtils.D0(dVar7.f284977b)) {
                    if (dVar7.f284981f) {
                        i18 = 2;
                    } else {
                        i18 = 1;
                    }
                    SearchUtils.U0("all_result", "exp_object", i18, 0, dVar7.f284976a, dVar7.f284977b + str9, dVar7.f284980e, dVar7.f284978c + str9);
                    dVar7.f284979d = true;
                    SearchUtils.f284964m.put((y) item, dVar7);
                }
                if ((item instanceof pn2.c) && ((i16 = ((pn2.c) item).I) == -3 || i16 == -4)) {
                    if (dVar7.f284981f) {
                        i17 = 2;
                    } else {
                        i17 = 1;
                    }
                    SearchUtils.U0("all_result", "exp_net_search", i17, 0, dVar7.f284976a, dVar7.f284977b + str9, dVar7.f284980e, dVar7.f284978c + str9);
                }
            }
        }
        if (cVar2.n(view, item)) {
            view3 = view2;
        } else {
            view3 = view;
        }
        view4 = super.getView(i3, view3, viewGroup);
        cVar2.i(i3, view4, item);
        if (i3 != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i3 >= 1) {
            z16 = h(view4, item, i3, getItemViewType(i3), cVar2.getItemViewType(i3 - 1), z16);
        }
        if (view4 != null && view4.findViewById(R.id.bnd) != null) {
            if (!z16) {
                view4.findViewById(R.id.bnd).setVisibility(8);
            } else {
                view4.findViewById(R.id.bnd).setVisibility(0);
            }
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view4;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 76;
    }

    protected int j(v vVar, int i3) {
        String h16 = com.tencent.mobileqq.search.util.x.h(vVar);
        int i16 = -1;
        while (i3 >= 0 && h16.equals(com.tencent.mobileqq.search.util.x.h(getItem(i3)))) {
            i16++;
            i3--;
        }
        return i16;
    }

    public int k(int i3) {
        lo2.c cVar;
        if (getItem(i3) instanceof lo2.b) {
            lo2.b bVar = (lo2.b) getItem(i3);
            if (bVar != null) {
                return bVar.v();
            }
            return 0;
        }
        if ((getItem(i3) instanceof lo2.c) && (cVar = (lo2.c) getItem(i3)) != null) {
            return cVar.J();
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        int count = getCount();
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < count; i18++) {
            v item = getItem(i18);
            if (item instanceof i) {
                i iVar = (i) item;
                i3++;
                iVar.t(1, i3);
                if (iVar.x() == 2) {
                    i17++;
                }
                iVar.t(3, i17);
                iVar.u(0, i3, i17);
                i16 = 0;
            } else if (item instanceof do2.r) {
                i16++;
                ((do2.r) item).u(i16, i3, i17);
            } else if (item instanceof lo2.c) {
                i16++;
                ((lo2.c) item).W(i16, i3, i17);
            }
        }
        super.notifyDataSetChanged();
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        if (!this.f410657e.isPausing()) {
            int i17 = this.f410658f;
            if (i17 == 0 || i17 == 1) {
                int childCount = this.f410659h.getChildCount();
                for (int i18 = 0; i18 < childCount; i18++) {
                    View childAt = this.f410659h.getChildAt(i18);
                    s(childAt, i16, str, bitmap);
                    if (childAt instanceof ViewGroup) {
                        int i19 = 0;
                        while (true) {
                            ViewGroup viewGroup = (ViewGroup) childAt;
                            if (i19 >= viewGroup.getChildCount()) {
                                break;
                            }
                            s(viewGroup.getChildAt(i19), i16, str, bitmap);
                            i19++;
                        }
                        View findViewById = childAt.findViewById(R.id.ecl);
                        if (findViewById instanceof ViewGroup) {
                            ViewGroup viewGroup2 = (ViewGroup) findViewById;
                            int childCount2 = viewGroup2.getChildCount();
                            for (int i26 = 0; i26 < childCount2; i26++) {
                                s(viewGroup2.getChildAt(i26), i16, str, bitmap);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        AbsListView.OnScrollListener onScrollListener = this.f410660i;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i3, i16, i17);
        }
        this.F.m(i3, i16, i17);
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        if (this.f410659h != null && absListView != null) {
            this.f410658f = i3;
            boolean z16 = true;
            if (i3 != 0 && i3 != 1) {
                this.f410657e.cancelPendingRequests();
                this.f410657e.pause();
            } else {
                if (this.f410657e.isPausing()) {
                    this.f410657e.resume();
                } else {
                    z16 = false;
                }
                int childCount = this.f410659h.getChildCount();
                for (int i16 = 0; i16 < childCount; i16++) {
                    View childAt = this.f410659h.getChildAt(i16);
                    if (childAt instanceof ViewGroup) {
                        int i17 = 0;
                        while (true) {
                            ViewGroup viewGroup = (ViewGroup) childAt;
                            if (i17 >= viewGroup.getChildCount()) {
                                break;
                            }
                            o(viewGroup.getChildAt(i17));
                            i17++;
                        }
                    }
                    if (z16) {
                        o(childAt);
                    }
                }
            }
            AbsListView.OnScrollListener onScrollListener = this.f410660i;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChanged(absListView, i3);
            }
            this.F.n(i3);
        }
    }

    public void p(List<v> list) {
        if (m(list)) {
            QLog.d("Q.uniteSearch.BaseMvpAdapter", 1, "list is same ", Integer.valueOf(list.size()));
        } else {
            super.g(list);
            QLog.d("Q.uniteSearch.BaseMvpAdapter", 4, "setItems ", list);
        }
    }

    public void q(boolean z16) {
        this.E = z16;
    }
}
