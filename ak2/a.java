package ak2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqvideoedit.editor.VideoEditorViewModel;
import com.tencent.mobileqq.qqvideoedit.view.VideoMaterialPanelContentAdapter;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a extends VideoMaterialPanelContentAdapter {
    private final int L;
    private final int M;

    public a(@NonNull Context context, VideoEditorViewModel.EditMode editMode) {
        super(context, editMode, 2);
        this.L = com.tencent.mobileqq.util.x.c(context, 14.0f);
        this.M = com.tencent.mobileqq.util.x.c(context, 12.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqvideoedit.view.VideoMaterialPanelContentAdapter
    public void F(VideoMaterialPanelContentAdapter.b bVar, int i3, @NonNull MetaMaterial metaMaterial) {
        super.F(bVar, i3, metaMaterial);
        Q(bVar.itemView, metaMaterial, i3);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.view.VideoMaterialPanelContentAdapter
    protected VideoMaterialPanelContentAdapter.b G(ViewGroup viewGroup, int i3) {
        VideoMaterialPanelContentAdapter.b bVar = new VideoMaterialPanelContentAdapter.b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f168852h20, viewGroup, false));
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) bVar.itemView.getLayoutParams();
        int i16 = i3 & 15;
        if (i16 == 1) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.L;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.M;
        } else if (i16 == 3) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = 12;
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.M;
        }
        return bVar;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (i3 < 4) {
            return 1;
        }
        if (((int) Math.ceil(((i3 + 1) * 1.0f) / 4.0f)) == ((int) Math.ceil((getItemCount() * 1.0f) / 4.0f))) {
            return 3;
        }
        return 2;
    }

    private void Q(View view, MetaMaterial metaMaterial, int i3) {
    }
}
