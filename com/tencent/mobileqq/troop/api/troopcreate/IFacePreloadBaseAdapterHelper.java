package com.tencent.mobileqq.troop.api.troopcreate;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process = {""})
/* loaded from: classes19.dex */
public interface IFacePreloadBaseAdapterHelper extends IRuntimeService {
    View getBuddyListRelationTroopView(View view, ViewGroup viewGroup, Context context, View.OnClickListener onClickListener, Entity entity);
}
