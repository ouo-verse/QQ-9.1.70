package i9;

import androidx.recyclerview.widget.DiffUtil;
import com.qzone.publish.business.task.IQueueTask;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;

/* compiled from: P */
/* loaded from: classes38.dex */
public class f extends com.qzone.reborn.base.h<IQueueTask> {

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a extends DiffUtil.ItemCallback<IQueueTask> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(IQueueTask iQueueTask, IQueueTask iQueueTask2) {
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(IQueueTask iQueueTask, IQueueTask iQueueTask2) {
            return iQueueTask.getTaskId() == iQueueTask2.getTaskId();
        }
    }

    public f() {
        super(new a(), new AdapterDelegatesManager(new m9.j()));
    }
}
