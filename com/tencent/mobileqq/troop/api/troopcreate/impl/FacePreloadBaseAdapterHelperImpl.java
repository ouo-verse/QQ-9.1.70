package com.tencent.mobileqq.troop.api.troopcreate.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.adapter.k;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.troopcreate.IFacePreloadBaseAdapterHelper;
import com.tencent.mobileqq.troop.troopcreate.RelationTroopEntity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* loaded from: classes19.dex */
public class FacePreloadBaseAdapterHelperImpl implements IFacePreloadBaseAdapterHelper {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "RelationFriendsTroopViewHelper";
    private AppInterface mApp;

    /* loaded from: classes19.dex */
    public static class a extends b {
        static IPatchRedirector $redirector_;
        public View D;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* loaded from: classes19.dex */
    public static class b extends k {
        static IPatchRedirector $redirector_;
        public Object C;

        /* renamed from: i, reason: collision with root package name */
        public TextView f294323i;

        /* renamed from: m, reason: collision with root package name */
        public CheckBox f294324m;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public FacePreloadBaseAdapterHelperImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.troopcreate.IFacePreloadBaseAdapterHelper
    public View getBuddyListRelationTroopView(View view, ViewGroup viewGroup, Context context, View.OnClickListener onClickListener, Entity entity) {
        a aVar;
        TroopInfo troopInfo;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, view, viewGroup, context, onClickListener, entity);
        }
        RelationTroopEntity relationTroopEntity = (RelationTroopEntity) entity;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.act, viewGroup, false);
            aVar = new a();
            aVar.f187212f = (ImageView) view.findViewById(R.id.icon);
            aVar.f294323i = (TextView) view.findViewById(R.id.f5e);
            aVar.f294324m = (CheckBox) view.findViewById(R.id.axa);
            aVar.D = view.findViewById(R.id.kab);
            if (onClickListener != null) {
                view.setOnClickListener(onClickListener);
            }
            view.findViewById(R.id.k8u).setVisibility(8);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
            aVar.f294323i.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        aVar.f294324m.setVisibility(8);
        aVar.D.setVisibility(8);
        if (relationTroopEntity != null && (troopInfo = relationTroopEntity.troopInfo) != null) {
            aVar.C = relationTroopEntity;
            aVar.f187210d = troopInfo.troopuin;
            if (troopInfo.hasSetTroopHead()) {
                i3 = 4;
            } else {
                i3 = 113;
            }
            aVar.f187212f.setImageDrawable(FaceDrawable.getFaceDrawable(this.mApp, i3, relationTroopEntity.troopInfo.troopuin, 3, FaceDrawable.getDefaultDrawable(4, 3), FaceDrawable.getDefaultDrawable(4, 3)));
            aVar.f294323i.setText(relationTroopEntity.troopInfo.getTroopDisplayName());
            return view;
        }
        QLog.e(TAG, 1, "getBuddyListRelationTroopView: troop entity=" + relationTroopEntity);
        return view;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
        } else {
            this.mApp = (AppInterface) appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }
}
