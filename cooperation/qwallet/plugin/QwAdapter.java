package cooperation.qwallet.plugin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QwAdapter<V> extends BaseAdapter {
    private static final String TAG = "QwAdapter";
    protected LayoutInflater layoutInflater;
    protected List<V> list;
    private IViewHolder mCloneObj;
    private IViewHolder mHolder;
    protected int resource;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface IViewHolder<V> extends Cloneable {
        IViewHolder clone() throws CloneNotSupportedException;

        View initView(int i3, View view);

        void setItemView(int i3, View view, V v3);
    }

    public QwAdapter(Context context, List<V> list, int i3, IViewHolder iViewHolder) {
        this.resource = i3;
        this.list = list;
        this.mCloneObj = iViewHolder;
        this.layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.list.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    public List<V> getList() {
        return this.list;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.layoutInflater.inflate(this.resource, viewGroup, false);
            try {
                IViewHolder iViewHolder = this.mCloneObj;
                if (iViewHolder != null) {
                    this.mHolder = iViewHolder.clone();
                }
                this.mHolder.initView(i3, view);
                view.setTag(this.mHolder);
            } catch (CloneNotSupportedException e16) {
                QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
            }
        } else {
            this.mHolder = (IViewHolder) view.getTag();
        }
        this.mHolder.setItemView(i3, view, this.list.get(i3));
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }
}
