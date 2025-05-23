package com.tencent.mobileqq.troop.homework.impl;

import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.troop.homework.ITroopTeacherApi;
import com.tencent.mobileqq.troop.homework.file.view.TroopTeacherFileFragment;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/impl/TroopTeacherApiImpl;", "Lcom/tencent/mobileqq/troop/homework/ITroopTeacherApi;", "()V", "createTeacherFileFragment", "Landroidx/fragment/app/Fragment;", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class TroopTeacherApiImpl implements ITroopTeacherApi {
    @Override // com.tencent.mobileqq.troop.homework.ITroopTeacherApi
    public Fragment createTeacherFileFragment() {
        return new TroopTeacherFileFragment();
    }
}
