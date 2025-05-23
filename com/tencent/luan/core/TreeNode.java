package com.tencent.luan.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes7.dex */
public class TreeNode<E> extends AbstractNode<E> {
    static IPatchRedirector $redirector_;
    private SingleLinkedListNode<TreeNode<E>> headChildNode;
    private final SingleLinkedListNode<TreeNode<E>> parentNode;
    private final SingleLinkedListNode<TreeNode<E>> selfNode;
    private SingleLinkedListNode<TreeNode<E>> tailChildNode;

    public TreeNode(E e16) {
        this(e16, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) e16);
    }

    public TreeNode<E> addChild(E e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TreeNode) iPatchRedirector.redirect((short) 3, (Object) this, (Object) e16);
        }
        TreeNode<E> treeNode = new TreeNode<>(e16, this.selfNode);
        SingleLinkedListNode<TreeNode<E>> singleLinkedListNode = this.tailChildNode;
        if (singleLinkedListNode == null) {
            this.headChildNode = treeNode.selfNode;
        } else {
            singleLinkedListNode.setNext(treeNode.selfNode);
        }
        this.tailChildNode = treeNode.selfNode;
        return treeNode;
    }

    public TreeNode<E> getParent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TreeNode) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        SingleLinkedListNode<TreeNode<E>> singleLinkedListNode = this.parentNode;
        if (singleLinkedListNode == null) {
            return null;
        }
        return singleLinkedListNode.element;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Iterator) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new Iterator<E>() { // from class: com.tencent.luan.core.TreeNode.1
            static IPatchRedirector $redirector_;
            TreeNode<E> node;
            TreeNode<E> rootNode;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TreeNode.this);
                } else {
                    this.rootNode = TreeNode.this;
                    this.node = TreeNode.this;
                }
            }

            private SingleLinkedListNode<TreeNode<E>> getNextLinkedNode(SingleLinkedListNode<TreeNode<E>> singleLinkedListNode) {
                if (!singleLinkedListNode.hasNext()) {
                    SingleLinkedListNode<TreeNode<E>> singleLinkedListNode2 = ((TreeNode) singleLinkedListNode.element).parentNode;
                    if (singleLinkedListNode2 == null) {
                        return null;
                    }
                    return getNextLinkedNode(singleLinkedListNode2);
                }
                return singleLinkedListNode.next();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this)).booleanValue();
                }
                if (this.node != null) {
                    return true;
                }
                return false;
            }

            @Override // java.util.Iterator
            public E next() {
                TreeNode<E> treeNode;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    return (E) iPatchRedirector2.redirect((short) 3, (Object) this);
                }
                TreeNode<E> treeNode2 = this.node;
                E e16 = treeNode2.element;
                if (((TreeNode) treeNode2).headChildNode != null) {
                    this.node = (TreeNode) ((TreeNode) this.node).headChildNode.element;
                } else {
                    SingleLinkedListNode<TreeNode<E>> nextLinkedNode = getNextLinkedNode(((TreeNode) this.node).selfNode);
                    if (nextLinkedNode == null) {
                        treeNode = null;
                    } else {
                        treeNode = nextLinkedNode.element;
                    }
                    this.node = treeNode;
                }
                return e16;
            }

            @Override // java.util.Iterator
            public void remove() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this);
                    return;
                }
                throw new IllegalArgumentException("wrong call");
            }
        };
    }

    TreeNode(E e16, SingleLinkedListNode<TreeNode<E>> singleLinkedListNode) {
        super(e16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) e16, (Object) singleLinkedListNode);
        } else {
            this.parentNode = singleLinkedListNode;
            this.selfNode = new SingleLinkedListNode<>(this);
        }
    }
}
